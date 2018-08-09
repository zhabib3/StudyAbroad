package com.zedTech.zeeshanamin3.StudyAbroad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MajorsActivity extends AppCompatActivity {

    private MajorsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_majors);

        // Find the List View in resources
        ListView majorsListView = findViewById(R.id.list);

        // TODO: remove the Test Majors ArrayList
        Major major1 = new Major("Computer Science", "Engineering", "test desc");
        Major major2 = new Major("Psychology", "Behavioral Science", "test desc2");
        Major major3 = new Major("Combinatronics", "Mathematics", "test desc3");

        ArrayList<Major> testList = new ArrayList<>();
        testList.add(major1);
        testList.add(major2);
        testList.add(major3);
        // Create a new Adapter with Majors ArrayList as arg
        mAdapter = new MajorsAdapter(this, 0, testList);

        // Set the adapter on the list view
        majorsListView.setAdapter(mAdapter);
    }
}
