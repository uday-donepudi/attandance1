package com.example.p2k24;

public class Biometric {
    executor = ContextCompat.getMainExecutor(this);

    // Initialize BiometricPrompt
    biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
        @Override
        public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
            super.onAuthenticationError(errorCode, errString);
            // If any error occurs during authentication
            // Handle errors if needed
        }

        @Override
        public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
            super.onAuthenticationSucceeded(result);
            // Authentication successful
            // Proceed with your logic after successful authentication
        }

        @Override
        public void onAuthenticationFailed() {
            super.onAuthenticationFailed();
            // Authentication failed
            // Handle failures if needed
        }
    });

    // Setup BiometricPrompt.PromptInfo
    promptInfo = new BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric Authentication")
                .setSubtitle("Login using fingerprint or face")
                .setNegativeButtonText("Cancel")
                .build();

    // Show the authentication dialog immediately
        biometricPrompt.authenticate(promptInfo);
}
