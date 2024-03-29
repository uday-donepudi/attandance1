package com.example.p2k24;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class StudentLogin extends Fragment {

    EditText emailEditText, passwordEditText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_login, container, false);

        emailEditText = view.findViewById(R.id.loginEmailEditText);
        passwordEditText = view.findViewById(R.id.loginPasswordEditText);
        Button loginButton = view.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the email and password entered by the user
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                // Perform login action
                loginUser(email, password);
                // Create Intent to navigate to StudentHome
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void loginUser(String email, String password) {
        // Implement your login logic here
        // For demonstration purposes, you can display a toast message
       if(email.equals("student1@gmail.com") && password.equals("student1@123"))
       {
           // Inside your source fragment (e.g., FragmentA)
           FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
           StudentHome studentHome=new StudentHome();// Instantiate the target fragment
           transaction.replace(R.id.slogin, studentHome); // Replace the current fragment with the target fragment
           transaction.addToBackStack(null); // Optionally, add the transaction to the back stack
           transaction.commit(); // Commit the transaction

       }
       else {
           Toast.makeText(getActivity(), "enter correct login detaisl", Toast.LENGTH_SHORT).show();
       }
    }
}
