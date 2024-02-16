package com.example.p2k24;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class ProfileFragment extends Fragment {

    private TextView schoolNameTextView;
    private ImageView teacherImageView;
    private EditText teacherNameEditText, teacherSubjectEditText, teacherMailEditText, teacherMobileEditText, teacherYearEditText, teacherProjectsEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        teacherImageView = view.findViewById(R.id.teacherImageView);
        teacherNameEditText = view.findViewById(R.id.teacherNameEditText);
        teacherSubjectEditText = view.findViewById(R.id.teacherSubjectEditText);
        teacherMailEditText = view.findViewById(R.id.teachermailEditText);
        teacherMobileEditText = view.findViewById(R.id.teacherMobileEditText);
        teacherYearEditText = view.findViewById(R.id.teacherYearEditText);
        teacherProjectsEditText = view.findViewById(R.id.teacherProjectsEditText);

        // You can load an image into the ImageView using a library like Picasso or Glide
        // Example: Picasso.get().load(R.drawable.your_image).into(teacherImageView);

        // Accessing and setting values for demonstration purposes


        return view;
    }
}