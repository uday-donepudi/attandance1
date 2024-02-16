package com.example.p2k24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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
            setContentView(R.layout.activity_main);

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

    private double getDistance(double[] location1, double[] location2) {
        double latitude1 = location1[0];
        double longitude1 = location1[1];
        double latitude2 = location2[0];
        double longitude2 = location2[1];

        double diffLatitude = latitude1 - latitude2;
        double diffLongitude = longitude1 - longitude2;
        double squaredDiffLat = Math.pow(diffLatitude, 2);
        double squaredDiffLon = Math.pow(diffLongitude, 2);
        double sumOfSquaredDiffs = squaredDiffLat + squaredDiffLon;
        double distance = Math.sqrt(sumOfSquaredDiffs);

        // Round distance to 7 decimal places using DecimalFormat
        DecimalFormat df = new DecimalFormat("#.##########");
        distance = Double.parseDouble(df.format(distance));

        return distance;
    }

    private static final double THRESHOLD = 0.0000591998;
    private boolean isPresent(double[] location1, double[] location2) {
        double distance = getDistance(location1, location2);
        return distance < THRESHOLD;
    }





}