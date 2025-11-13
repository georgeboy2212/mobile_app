package com.example.application_home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

// We use FirestoreRecyclerAdapter to easily connect Firestore to the RecyclerView
public class LibroAdapter extends FirestoreRecyclerAdapter<Libro, LibroAdapter.LibroViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.
     */
    public LibroAdapter(@NonNull FirestoreRecyclerOptions<Libro> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull LibroViewHolder holder, int position, @NonNull Libro model) {
        // This method is called for each item in the list.
        // It binds the data from the 'Libro' model to the views in the ViewHolder.
        holder.tituloTextView.setText(model.getTitulo());
        holder.autorTextView.setText(model.getAutor());

        // Here you would load the image using a library like Glide or Picasso
        // For now, we'll just set a placeholder.
        // holder.portadaImageView.setImageResource(R.drawable.ic_launcher_background);
    }

    @NonNull
    @Override
    public LibroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This method creates a new ViewHolder by inflating the layout for a single item.
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.libro_item, parent, false); // Use your 'libro_item.xml'
        return new LibroViewHolder(view);
    }

    /**
     * The ViewHolder class holds the views for a single list item.
     */
    public static class LibroViewHolder extends RecyclerView.ViewHolder {
        TextView tituloTextView;
        TextView autorTextView;
        ImageView portadaImageView;

        public LibroViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloTextView = itemView.findViewById(R.id.tituloTextView);
            autorTextView = itemView.findViewById(R.id.autorTextView);
            portadaImageView = itemView.findViewById(R.id.portadaImageView);
        }
    }
}
