package hk.edu.hkbu.comp.hkbumapnavigated;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private SharedPreferences.Editor preferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LocationCreator.setContext(getApplicationContext());

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferenceEditor = preferences.edit();

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        final PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), MainActivity.this);
        viewPager.setAdapter(pagerAdapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        // Iterate over all tabs and set the custom view
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));
        }

        // Load settings

        ImageButton settings = (ImageButton) findViewById(R.id.settings_button);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View settingsView = layoutInflater.inflate(R.layout.settings_layout, null);

                final PopupWindow settingsWindow = new PopupWindow(settingsView, RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT);
                settingsWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                settingsWindow.showAtLocation(findViewById(R.id.toolbar), Gravity.NO_GRAVITY, 0, findViewById(R.id.toolbar).getHeight());

                ImageButton close = (ImageButton) settingsView.findViewById(R.id.settings_close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GmapFragment fragment = (GmapFragment) getSupportFragmentManager().findFragmentByTag(pagerAdapter.getFragmentTag(0));
                        fragment.updateOptionalLocations();
                        settingsWindow.dismiss();
                    }
                });

                final CheckBox atmCheckbox = (CheckBox) settingsView.findViewById(R.id.atms_checkbox);
                atmCheckbox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (atmCheckbox.isChecked()) {
                            preferenceEditor.putBoolean("atmCheckbox", true);
                        } else {
                            preferenceEditor.putBoolean("atmCheckbox", false);
                        }
                        preferenceEditor.commit();
                    }
                });

                final CheckBox coffeeCheckbox = (CheckBox) settingsView.findViewById(R.id.coffee_shops_checkbox);
                coffeeCheckbox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (coffeeCheckbox.isChecked()) {
                            preferenceEditor.putBoolean("coffeeCheckbox", true);
                        } else {
                            preferenceEditor.putBoolean("coffeeCheckbox", false);
                        }
                        preferenceEditor.commit();
                    }
                });

                final CheckBox canteenCheckbox = (CheckBox) settingsView.findViewById(R.id.canteens_checkbox);
                canteenCheckbox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (canteenCheckbox.isChecked()) {
                            preferenceEditor.putBoolean("canteenCheckbox", true);
                        } else {
                            preferenceEditor.putBoolean("canteenCheckbox", false);
                        }
                        preferenceEditor.commit();
                    }
                });

                final CheckBox bankCheckbox = (CheckBox) settingsView.findViewById(R.id.banks_checkbox);
                bankCheckbox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (bankCheckbox.isChecked()) {
                            preferenceEditor.putBoolean("bankCheckbox", true);
                        } else {
                            preferenceEditor.putBoolean("bankCheckbox", false);
                        }
                        preferenceEditor.commit();
                    }
                });

                atmCheckbox.setChecked(preferences.getBoolean("atmCheckbox", false));
                bankCheckbox.setChecked(preferences.getBoolean("bankCheckbox", false));
                canteenCheckbox.setChecked(preferences.getBoolean("canteenCheckbox", false));
                coffeeCheckbox.setChecked(preferences.getBoolean("coffeeCheckbox", false));
            }
        });
    }

    @Override
    public void onResume() {
            super.onResume();
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class PagerAdapter extends FragmentPagerAdapter {

        String tabTitles[] = new String[] {getString(R.string.Map), getString(R.string.Locations), getString(R.string.offline_map) };
        Context context;
        HashMap<Integer, String> tags = new HashMap<>();

        public PagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
                return tabTitles.length;
            }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new GmapFragment();
                case 1:
                    return new RecyclerViewFragment();
                case 2:
                    return new OfflineMapFragment();
                }

            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment createdFragment = (Fragment) super.instantiateItem(container, position);
            switch (position) {
                case 0:
                    tags.put(0, createdFragment.getTag());
                    break;
                case 1:
                    tags.put(1, createdFragment.getTag());
                    break;
            }
            return createdFragment;
        }

        public String getFragmentTag(int position) {
            return tags.get(position);
        }

        public View getTabView(int position) {
            View tab = LayoutInflater.from(MainActivity.this).inflate(R.layout.tab_layout, null);
            TextView tv = (TextView) tab.findViewById(R.id.custom_text);
            tv.setText(tabTitles[position]);
            return tab;
        }
    }
}

