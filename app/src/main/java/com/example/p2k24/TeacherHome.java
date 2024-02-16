package com.example.p2k24;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TeacherHome extends Fragment {

    private ImageView imageView;
    private TextView textView;
    private Button button1, button2, button3;

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
