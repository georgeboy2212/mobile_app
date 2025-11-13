package com.example.application_home;

public class Libro {
    private String titulo;
    private String autor;
    // You can add more fields here, like a URL for the cover image (portada)

    // IMPORTANT: A public no-argument constructor is required for Firestore
    public Libro() {
    }

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // --- Getters and Setters ---
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}

