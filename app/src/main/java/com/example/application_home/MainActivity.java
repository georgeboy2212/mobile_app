package com.example.application_home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // For now, let's just test anonymous sign-in immediately on start
        testAnonymousSignIn();
    }

    private void testAnonymousSignIn() {
        mAuth.signInAnonymously()
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success!
                            Log.d("LoginSuccess", "signInAnonymously:SUCCESS");

                            // --- THIS IS THE NAVIGATION LOGIC ---
                            // Create an Intent to open ProductoActivity
                            Intent intent = new Intent(MainActivity.this, ProductoActivity.class);
                            startActivity(intent);

                            // Finish MainActivity so the user can't go back
                            finish();
                            // ------------------------------------

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("LoginFailure", "signInAnonymously:FAILURE", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
