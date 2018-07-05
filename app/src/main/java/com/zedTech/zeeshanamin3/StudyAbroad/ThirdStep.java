package com.zedTech.zeeshanamin3.StudyAbroad;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;



public class ThirdStep extends AppCompatActivity {

    private ListView StepNavList;  //Initializing ListView named StepNavList
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_step);

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
                        Intent firstActIntent = new Intent(ThirdStep.this, FirstStep.class);
                        startActivity(firstActIntent);

                        break;

                    case 1:
                        Intent secondActIntent = new Intent(ThirdStep.this, SecondStep.class);
                        startActivity(secondActIntent);

                        break;

                    case 2:
                        Intent thirdActIntent = new Intent(ThirdStep.this, ThirdStep.class);
                        startActivity(thirdActIntent);

                        break;

                    case 3:
                        Intent fourthActIntent = new Intent(ThirdStep.this, FourthStep.class);
                        startActivity(fourthActIntent);

                        break;

                    case 4:
                        Intent fifthActIntent = new Intent(ThirdStep.this, FifthStep.class);
                        startActivity(fifthActIntent);

                        break;

                    case 5:
                        Intent sixthActIntent = new Intent(ThirdStep.this, SixthStep.class);
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


    //This method starts the web intent for the College Board website
    public void visitCollegeBoardPage (View v){
        Uri webpage = Uri.parse("http://international.collegeboard.org/");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(webIntent);
        }

    }


    //This method starts the web intent for the CollegeView website
    public void visitCollegeViewPage (View v){
        Uri webpage = Uri.parse("http://www.collegeview.com/collegesearch/index.jsp");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(webIntent);
        }

    }

    //This method starts the web intent for the Educations.com website
    public void visitEducationsPage (View v){
        Uri webpage = Uri.parse("http://www.educations.com/startSearch.aspx");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(webIntent);
        }

    }

    //This method is called when the Next Step button is clicked
    public void nextStep(View view) {
        Resources res = getResources();
        String checkBoxText = res.getString(R.string.checkBox_text);
        CheckBox thirdStepCheckbox = (CheckBox) findViewById(R.id.third_step_checkbox);
        if (thirdStepCheckbox.isChecked() == false) {
            CheckBox thirdStepCheckBox = (CheckBox) findViewById(R.id.third_step_checkbox);
            thirdStepCheckBox.setText(checkBoxText);
        }

        else {
            //Starts the FourthStep Activity
            Intent intent = new Intent(this, FourthStep.class);
            startActivity(intent);
        }
    }



}
