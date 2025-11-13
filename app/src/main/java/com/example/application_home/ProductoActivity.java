package com.example.application_home;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ProductoActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private RecyclerView recyclerView;
    private LibroAdapter adapter; // Declare the adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        // Initialize Firestore
        db = FirebaseFirestore.getInstance();

        // Find and set up the RecyclerView
        recyclerView = findViewById(R.id.librosRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Now, we will load the books from Firestore
        loadBooksFromFirestore();
    }

    private void loadBooksFromFirestore() {
        // Create a query to get books from the "libros" collection
        // You can order them by title, for example
        Query query = db.collection("libros").orderBy("titulo", Query.Direction.ASCENDING);

        // Configure the options for the adapter
        FirestoreRecyclerOptions<Libro> options = new FirestoreRecyclerOptions.Builder<Libro>()
                .setQuery(query, Libro.class)
                .build();

        // Create the adapter with these options
        adapter = new LibroAdapter(options);

        // Attach the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
    }

    // IMPORTANT: Start listening for changes when the activity starts
    @Override
    protected void onStart() {
        super.onStart();
        if (adapter != null) {
            adapter.startListening();
        }
    }

    // IMPORTANT: Stop listening for changes when the activity stops to save resources
    @Override
    protected void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }
    }
}
