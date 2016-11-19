package hk.edu.hkbu.comp.hkbumapnavigated;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class GmapFragment extends Fragment implements OnMapReadyCallback {
    private SharedPreferences sharedPreferences;
    private HashMap<HKBUSimpleLocation.LocationType, ArrayList<Marker>> optionalMarkers;

    GoogleMap mMap;
    AutoCompleteTextView source, destination;
    private HKBULocation[] locations;
    private Button setButton, clearButton;
    private String[] locationName;
    InputMethodManager imm;
    private LatLng defaultLocation = new LatLng(22.338036, 114.181979);
    float scale;
    int padding;
    static View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.fragment_gmap, container, false);
        } catch (InflateException e) {

        }
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        scale = getContext().getResources().getDisplayMetrics().density;
        padding = (int) (50 * scale + 0.5f);

        locations = LocationCreator.getLocations(Locale.getDefault().getLanguage());
        locationName = new String[locations.length];

        for (int i = 0; i < locationName.length; i++) {
            locationName[i] = locations[i].getName() + " - " + locations[i].getAbbreviation();
        }

        imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        setButton = (Button) view.findViewById(R.id.setButton);
        clearButton = (Button) view.findViewById(R.id.clearButton);
        source = (AutoCompleteTextView) view.findViewById(R.id.source);
        destination = (AutoCompleteTextView) view.findViewById(R.id.destination);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), R.layout.dropdown_layout, locationName);
        source.setThreshold(1);
        destination.setThreshold(1);
        source.setAdapter(adapter);
        destination.setAdapter(adapter);


        SupportMapFragment fragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                mMap.clear();
                source.setText("");
                destination.setText("");
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 18));
                createOptionalMarkers();
                updateOptionalLocations();
            }
        });

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                mMap.clear();
                updateOptionalLocations();
                LatLng sourceMarker = null, destinationMarker = null;
                for (int i = 0; i < locations.length; i++) {
                    if ((locations[i].getName() + " - " + locations[i].getAbbreviation()).equals(source.getText().toString())) {
                        sourceMarker = new LatLng(locations[i].getLatitude(), locations[i].getLongitude());
                        mMap.addMarker(new MarkerOptions().title(locations[i].getName()).position(sourceMarker));
                    }
                    if ((locations[i].getName() + " - " + locations[i].getAbbreviation()).equals(destination.getText().toString())) {
                        destinationMarker = new LatLng(locations[i].getLatitude(), locations[i].getLongitude());
                        mMap.addMarker(new MarkerOptions().title(locations[i].getName()).position(destinationMarker));
                    }
                }
                if(sourceMarker!=null && destinationMarker==null){
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sourceMarker, 18));
                }
                else if(sourceMarker==null && destinationMarker!=null){
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(destinationMarker, 18));
                }
                else if(sourceMarker!= null && destinationMarker!=null){

                    drawPath(sourceMarker, destinationMarker);

                    LatLngBounds.Builder builder = new LatLngBounds.Builder();
                    builder.include(sourceMarker);
                    builder.include(destinationMarker);
                    LatLngBounds bounds = builder.build();

                    CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
                    mMap.animateCamera(cu);
                }
                else  mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 18));
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mMap = googleMap;
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 18));

        if (checkPermission()) {
            mMap.setMyLocationEnabled(true);
        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
            if (checkPermission()) {
                mMap.setMyLocationEnabled(true);
            }
        }
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                hideKeyboard(getView());
            }
        });


        createOptionalMarkers();
        updateOptionalLocations();
        try {
            Thread.sleep(600);
        } catch (Exception e) {

        }
    }

    private void createOptionalMarkers() {
        optionalMarkers = new HashMap<>();
        optionalMarkers.put(HKBUSimpleLocation.LocationType.ATM, new ArrayList<Marker>());
        optionalMarkers.put(HKBUSimpleLocation.LocationType.BANK, new ArrayList<Marker>());
        optionalMarkers.put(HKBUSimpleLocation.LocationType.CANTEEN, new ArrayList<Marker>());
        optionalMarkers.put(HKBUSimpleLocation.LocationType.COFFEE, new ArrayList<Marker>());

        for (HKBUSimpleLocation simpleLocation: LocationCreator.getSimpleLocations(Locale.getDefault().getLanguage())) {
            for (Coordinates coordinates: simpleLocation.getCoordinates()) {
                switch (simpleLocation.getLocationType()) {
                    case ATM:
                        optionalMarkers.get(HKBUSimpleLocation.LocationType.ATM).add(
                                mMap.addMarker(new MarkerOptions().title(simpleLocation.getName())
                                        .position(new LatLng(coordinates.getLatitude(), coordinates.getLongitude()))
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.atm))));
                        break;
                    case BANK:
                        optionalMarkers.get(HKBUSimpleLocation.LocationType.BANK).add(
                                mMap.addMarker(new MarkerOptions().title(simpleLocation.getName())
                                        .position(new LatLng(coordinates.getLatitude(), coordinates.getLongitude()))
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank)))
                        );
                        break;
                    case CANTEEN:
                        optionalMarkers.get(HKBUSimpleLocation.LocationType.CANTEEN).add(
                                mMap.addMarker(new MarkerOptions().title(simpleLocation.getName())
                                        .position(new LatLng(coordinates.getLatitude(), coordinates.getLongitude()))
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.canteen)))
                        );
                        break;
                    case COFFEE:
                        optionalMarkers.get(HKBUSimpleLocation.LocationType.COFFEE).add(
                                mMap.addMarker(new MarkerOptions().title(simpleLocation.getName())
                                        .position(new LatLng(coordinates.getLatitude(), coordinates.getLongitude()))
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.coffee)))
                        );
                        break;
                }
            }
        }
    }

    private boolean checkPermission() {
        // Ask for permission if it wasn't granted yet
        return (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void drawPath(LatLng sourceMarker, LatLng destinationMarker) {

        if ((source.getText().toString().startsWith(getString(R.string.ACH)) && destination.getText().toString().startsWith(getString(R.string.AAB))
                || (source.getText().toString().startsWith(getString(R.string.AAB)) && destination.getText().toString().startsWith(getString(R.string.ACH))))) {
            if (source.getText().toString().startsWith(getString(R.string.ACH)))
                mMap.addPolyline(new PolylineOptions().add(sourceMarker, new LatLng(22.341152, 114.180008), new LatLng(22.340344, 114.180263), new LatLng(22.339781, 114.180692), new LatLng(22.339759, 114.181577), new LatLng(22.339399, 114.181671), new LatLng(22.338900, 114.181977), new LatLng(22.337074, 114.181998), new LatLng(22.336680, 114.182180), destinationMarker).width(4).color(Color.BLUE));
            else
                mMap.addPolyline(new PolylineOptions().add(destinationMarker, new LatLng(22.341152, 114.180008), new LatLng(22.340344, 114.180263), new LatLng(22.339781, 114.180692), new LatLng(22.339759, 114.181577), new LatLng(22.339399, 114.181671), new LatLng(22.338900, 114.181977), new LatLng(22.337074, 114.181998), new LatLng(22.336680, 114.182180), sourceMarker).width(4).color(Color.BLUE));
        }
        else
            mMap.addPolyline(new PolylineOptions().add(sourceMarker, destinationMarker).width(4).color(Color.BLUE));

    }

    public void updateOptionalLocations() {
        boolean atms = sharedPreferences.getBoolean("atmCheckbox", false);
        boolean bank = sharedPreferences.getBoolean("bankCheckbox", false);
        boolean canteen = sharedPreferences.getBoolean("canteenCheckbox", false);
        boolean coffee = sharedPreferences.getBoolean("coffeeCheckbox", false);


        for (Marker marker: optionalMarkers.get(HKBUSimpleLocation.LocationType.ATM)) {
            marker.setVisible(atms);
        }

        for (Marker marker: optionalMarkers.get(HKBUSimpleLocation.LocationType.BANK)) {
            marker.setVisible(bank);
        }

        for (Marker marker: optionalMarkers.get(HKBUSimpleLocation.LocationType.CANTEEN)) {
            marker.setVisible(canteen);
        }

        for (Marker marker: optionalMarkers.get(HKBUSimpleLocation.LocationType.COFFEE)) {
            marker.setVisible(coffee);
        }
    }
}
