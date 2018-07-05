package com.zedTech.zeeshanamin3.StudyAbroad;


import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class EndActivity extends AppCompatActivity {

    private ListView StepNavList;  //Initializing ListView named StepNavList
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);


        StepNavList = (ListView) findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void addDrawerItems() {
        Resources res = getResources();
        String[] navDrawerArray = res. getStringArray(R.array.navDrawerListItems);
        mAdapter = new ArrayAdapter<String>(this, R.layout.custom_list, navDrawerArray);
        StepNavList.setAdapter(mAdapter);

        StepNavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent firstActIntent = new Intent(EndActivity.this, FirstStep.class);
                        startActivity(firstActIntent);

                        break;

                    case 1:
                        Intent secondActIntent = new Intent(EndActivity.this, SecondStep.class);
                        startActivity(secondActIntent);

                        break;

                    case 2:
                        Intent thirdActIntent = new Intent(EndActivity.this, ThirdStep.class);
                        startActivity(thirdActIntent);

                        break;

                    case 3:
                        Intent fourthActIntent = new Intent(EndActivity.this, FourthStep.class);
                        startActivity(fourthActIntent);

                        break;

                    case 4:
                        Intent fifthActIntent = new Intent(EndActivity.this, FifthStep.class);
                        startActivity(fifthActIntent);

                        break;

                    case 5:
                        Intent sixthActIntent = new Intent(EndActivity.this, SixthStep.class);
                        startActivity(sixthActIntent);

                        break;


                }
            }

        });
    }




    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(getString(R.string.navDrawer_title));
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //This method is called when the Share Button is clicked
    public void shareApp(View v) {
        Resources res = getResources();
        String shareMessage = res. getString(R.string.share_intent) ;
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);   //*
        //*Note this intent works on common messaging apps like the default SMS app, the facebook messenger app and
        // others but it doesn't work when the user intends to "post" it on a social media app like facebook or twitter.
        shareIntent.setType("text/plain");
        startActivity(shareIntent);
        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(shareIntent);
        }

    }
}
