package com.example.p2k24;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        // Find views
        TextView exitMessageTextView = rootView.findViewById(R.id.exitMessageTextView);
        Button yesButton = rootView.findViewById(R.id.yesButton);
        Button noButton = rootView.findViewById(R.id.noButton);

        // Set click listener for the Yes button
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action to exit the app
                getActivity().finish();
            }
        });

        // Set click listener for the No button
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the home page
                Intent intent = new Intent(getActivity(), navigationactivity.class);
                startActivity(intent);
                // Finish the current activity (MenuFragment)
                getActivity().finish();
            }
        });

        return rootView;
    }
}
