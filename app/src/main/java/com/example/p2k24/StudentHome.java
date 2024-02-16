package com.example.p2k24;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class StudentHome extends Fragment {

    private ImageView imageView;
    private TextView textView;
    private Button button1, button2, button3, button4, button5;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_teacher_home, container, false);

        // Initialize views
        imageView = rootView.findViewById(R.id.imageView);
        textView = rootView.findViewById(R.id.textView);
        button1 = rootView.findViewById(R.id.button1);
        button2 = rootView.findViewById(R.id.button2);
        button3 = rootView.findViewById(R.id.button3);
        button3 = rootView.findViewById(R.id.button4);
        button3 = rootView.findViewById(R.id.button5);

        // Example of setting text for TextView
        textView.setText("Your Updated Text");

        // Example of setting click listeners for buttons
        button1.setOnClickListener(v -> {
            // Handle button1 click
        });

        button2.setOnClickListener(v -> {
            // Handle button2 click
        });

        button3.setOnClickListener(v -> {
            // Handle button3 click
        });

        return rootView;
    }
}
