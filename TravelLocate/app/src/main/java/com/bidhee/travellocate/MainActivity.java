package com.bidhee.travellocate;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bidhee.custom.SlidingTabLayout;
import com.bidhee.fragment.HistoricalFragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;


public class MainActivity extends AppCompatActivity {

     /*
	 * Sliding tabs Setup
	 */

    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mainPager;
    private FragmentManager fragmentManager;
    CharSequence Titles[]={"Historical","Natural"};
    int Numboftabs =2;
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;
    private Location mLastLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        mainPager = (ViewPager) findViewById(R.id.mainPager);
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs_home);
        mainPager.setAdapter(new ViewPagerAdapter(fragmentManager,Titles, Numboftabs));


        mSlidingTabLayout.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        mSlidingTabLayout.setViewPager(mainPager);


        if (checkPlayServices()) {
            startService(new Intent(this, LocateSerivce.class));
        }

    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
        int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


        // Build a Constructor and assign the passed Values to appropriate values in the class
        public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
            super(fm);

            this.Titles = mTitles;
            this.NumbOfTabs = mNumbOfTabsumb;

        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) // if the position is 0 we are returning the First tab
            {
                HistoricalFragment tab1 = new HistoricalFragment();
                return tab1;
            } else             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
            {
                HistoricalFragment tab2 = new HistoricalFragment();
                return tab2;
            }


        }


        @Override
        public CharSequence getPageTitle(int position) {
            return Titles[position];
        }


        @Override
        public int getCount() {
            return NumbOfTabs;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

    }



    /**
     * Method to verify google play services on the device
     * */
    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();
                finish();
            }
            return false;
        }
        return true;
    }


}
