package hk.edu.hkbu.comp.hkbumapnavigated;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class GmapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap mMap;
    AutoCompleteTextView source, destination;
    private HKBULocation[] locations;
    private Button setButton, clearButton;
    private String[] locationName;
    InputMethodManager imm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gmap, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        locations = LocationCreator.getLocations();
        locationName = new String[locations.length];

        for(int i=0; i<locationName.length;i++){
            locationName[i]=locations[i].getName();
        }

        imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        setButton = (Button)view.findViewById(R.id.setButton);
        clearButton = (Button)view.findViewById(R.id.clearButton);
        source = (AutoCompleteTextView)view.findViewById(R.id.source);
        destination = (AutoCompleteTextView)view.findViewById(R.id.destination);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.select_dialog_item,locationName);
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
                LatLng marker = new LatLng(22.338036, 114.181979);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker, 18));

            }
        });

        setButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                mMap.clear();
                LatLng sourceMarker = null, destinationMarker =null;
                for(int i=0; i<locations.length;i++) {

                    if(locations[i].getName().equals(source.getText().toString())){
                        sourceMarker = new LatLng(locations[i].getLatitude(),locations[i].getLongitude());
                        mMap.addMarker(new MarkerOptions().title(locations[i].getName()).position(sourceMarker));
                    }
                    if(locations[i].getName().equals(destination.getText().toString())){
                        destinationMarker = new LatLng(locations[i].getLatitude(),locations[i].getLongitude());
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
                        //draw path for only one path, change this after having completed paths
                        if((source.getText().toString().equals("Academic Community Hall")&&destination.getText().toString().equals("Academic and Administration Building"))||(source.getText().toString().equals("Academic and Administration Building")&&destination.getText().toString().equals("Academic Community Hall"))){
                            if(source.getText().toString().equals("Academic Community Hall"))
                                mMap.addPolyline(new PolylineOptions().add(sourceMarker,new LatLng(22.341152, 114.180008),new LatLng(22.340344, 114.180263),new LatLng(22.339781, 114.180692),new LatLng(22.339759, 114.181577),new LatLng(22.339399, 114.181671),new LatLng(22.338900, 114.181977),new LatLng(22.337074, 114.181998),new LatLng(22.336680, 114.182180),destinationMarker).width(4).color(Color.BLUE));
                            else  mMap.addPolyline(new PolylineOptions().add(destinationMarker,new LatLng(22.341152, 114.180008),new LatLng(22.340344, 114.180263),new LatLng(22.339781, 114.180692),new LatLng(22.339759, 114.181577),new LatLng(22.339399, 114.181671),new LatLng(22.338900, 114.181977),new LatLng(22.337074, 114.181998),new LatLng(22.336680, 114.182180),sourceMarker).width(4).color(Color.BLUE));;
                        }
                        else mMap.addPolyline(new PolylineOptions().add(sourceMarker,destinationMarker).width(4).color(Color.BLUE));

                    LatLngBounds.Builder builder = new LatLngBounds.Builder();
                    builder.include(sourceMarker);
                    builder.include(destinationMarker);
                    LatLngBounds bounds = builder.build();
                    int padding = 0;
                    CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
                    mMap.animateCamera(cu);
                }
                else {
                    LatLng marker = new LatLng(22.338036, 114.181979);
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker, 18));
                }
            }

        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng marker = new LatLng(22.338036, 114.181979);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 18));

        if(checkPermission()) {
            mMap.setMyLocationEnabled(true);
        }
        else{
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
            if(checkPermission()) {
                mMap.setMyLocationEnabled(true);
            }


        }

      /*
      mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {

                    @Override
                    public void onMyLocationChange(Location arg0) {
                        // TODO Auto-generated method stub
                        System.out.println("get");

                        CameraUpdate center= CameraUpdateFactory.newLatLng(new LatLng(arg0.getLatitude(), arg0.getLongitude()));
                        CameraUpdate zoom=CameraUpdateFactory.zoomTo(12);


                        mMap.moveCamera(center);
                        mMap.animateCamera(zoom);
                    }
                });
        */

    }

    private boolean checkPermission() {
        // Ask for permission if it wasn't granted yet
        return (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED );
    }


}
