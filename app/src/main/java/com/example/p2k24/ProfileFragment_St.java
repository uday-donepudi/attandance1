package com.example.p2k24;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment_St extends Fragment {

    private TextView schoolNameTextView;
    private ImageView teacherImageView;
    private EditText teacherNameEditText, teacherSubjectEditText, teacherBranchEditText, teacherYearEditText, teacherCourseEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile__st, container, false);

        teacherImageView = view.findViewById(R.id.teacherImageView);
        teacherNameEditText = view.findViewById(R.id.teacherNameEditText);
        teacherSubjectEditText = view.findViewById(R.id.teacherSubjectEditText);
        teacherBranchEditText = view.findViewById(R.id.teacherBranchEditText);
        teacherYearEditText = view.findViewById(R.id.teacherYearEditText);

        // You can load an image into the ImageView using a library like Picasso or Glide
        // Example: Picasso.get().load(R.drawable.your_image).into(teacherImageView);

        // Accessing and setting values for demonstration purposes
        teacherNameEditText.setHint("Name:");
        teacherSubjectEditText.setHint("Register:");
        teacherBranchEditText.setHint("Branch:");
        teacherYearEditText.setHint("Year:");

        return view;
    }
}