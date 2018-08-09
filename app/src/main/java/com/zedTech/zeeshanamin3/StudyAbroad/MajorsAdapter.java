package com.zedTech.zeeshanamin3.StudyAbroad;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MajorsAdapter extends ArrayAdapter<Major> {
    public MajorsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Major> objects) {
        super(context, 0, objects);
    }

    // Helper method to determine category band color
    private int getBandColor(String category) {
        int bandColorResId = R.color.engineering;
        switch (category) {
            case "Engineering":
                bandColorResId = R.color.engineering;
                break;
            case "Business":
                bandColorResId = R.color.business;
                break;
            case "Mathematics":
                bandColorResId = R.color.mathematics;
                break;
            case "Communication":
                bandColorResId = R.color.communication;
                break;
            case "Food-Life Science":
                bandColorResId = R.color.food_science;
                break;
            case "Agriculture":
                bandColorResId = R.color.agriculture;
                break;
            case "Social Science":
                bandColorResId = R.color.social_science;
                break;
            case "Art and Architecture":
                bandColorResId = R.color.art_architecture;
                break;
            case "Health Science":
                bandColorResId = R.color.health_science;
                break;
            case "Behavioral Science":
                bandColorResId = R.color.behavioral_science;
                break;
            case "Science":
                bandColorResId = R.color.science;
                break;
            case "Human Services":
                bandColorResId = R.color.human_services;
                break;
            case "Performing Arts":
                bandColorResId = R.color.performing_arts;
                break;
            case "Education":
                bandColorResId = R.color.education;
                break;
            case "Environmental Science":
                bandColorResId = R.color.environmental_science;
                break;
        }

        return ContextCompat.getColor(getContext(), bandColorResId);
    }

    // Provide a View for the array adapter
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if existing view is being utilized, else inflate the view
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.majors_list, parent, false);
        }

        // Get Major object located at current position
        Major currentMajor = getItem(position);

        // Now assign each view with appropriate values
        TextView nameView = listView.findViewById(R.id.nameView);
        TextView categoryView = listView.findViewById(R.id.categoryView);
        TextView categoryBand = listView.findViewById(R.id.categoryBand);

        nameView.setText(currentMajor.getName());
        categoryView.setText(currentMajor.getCategory());

        // Set the category band color based on major category
        GradientDrawable bandDrawable = (GradientDrawable) categoryBand.getBackground();
        int bandColor = getBandColor(currentMajor.getCategory());
        bandDrawable.setColor(bandColor);

        return listView;
    }
}
