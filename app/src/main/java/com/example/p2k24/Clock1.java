package com.example.p2k24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.text.DecimalFormat;

public class Clock1 extends AppCompatActivity {

        private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.#####");
        private static final int LOCATION_PERMISSION_REQUEST_CODE = 100;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_clock1);

            // Request location permissions
            requestLocationPermissions();
        }



        private void requestLocationPermissions() {
            // Check if the app has location permissions
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // Request location permissions
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
            } else {
                // Location permissions already granted, get current location
                getCurrentLocation();
            }
        }

        //###############################################################################################################################//
//Location Retrival Code//
        private double[] getCurrentLocation() {
            double[] coordinates = new double[2]; // Array to store latitude and longitude
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            if (locationManager != null) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // Request location permissions if not granted
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
                } else {
                    // Location permissions granted
                    Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    if (lastKnownLocation == null) {
                        lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    }
                    if (lastKnownLocation != null) {
                        coordinates[0] = lastKnownLocation.getLatitude();
                        coordinates[1] = lastKnownLocation.getLongitude();

                        // Display latitude and longitude using Toast
                        String message = "Latitude: " + DECIMAL_FORMAT.format(coordinates[0]) + ", Longitude: " + DECIMAL_FORMAT.format(coordinates[1]);
                        showToast(message);



                        // Initialize Firebase
                        FirebaseDatabase database = FirebaseDatabase.getInstance();

// Get a reference to the database node where you want to store the data
                        DatabaseReference myRef = database.getReference("app");

// Create a data object (e.g., a HashMap) with the data you want to add
                        Map<String, Object> userData = new HashMap<>();
                        userData.put("latitude", coordinates[0]);
                        userData.put("longitude", coordinates[1]);

// Add the data to the database
                        myRef.setValue(userData)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        // Data successfully added
                                        Toast.makeText(Clock1.this, "success", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        // Failed to add data
                                        Toast.makeText(Clock1.this, "fail", Toast.LENGTH_SHORT).show();
                                    }
                                });

                    } else {
                        showToast("Unable to retrieve location.");
                    }
                }
            }
            return coordinates;
        }
//############################################################################################################################//

        private void showToast(String message) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Location permissions granted, get current location
                    getCurrentLocation();
                } else {
                    showToast("Location permissions denied.\nCheck if the location is On on your mobile.");
                }
            }
        }




}