/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.biblioteca_iug;

/**
 *
 * @author YOVANI
 */
// Archivo: Libro.java
public class Libro {
    private int isbn;
    private String titulo;
    private String autor;
    private int anioPub;
    private int nroPag;
    private int nroCopias;

    public Libro(int isbn, String titulo, String autor, int anioPub, int nroPag, int nroCopias) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPub = anioPub;
        this.nroPag = nroPag;
        this.nroCopias = nroCopias;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPub() {
        return anioPub;
    }

    public int getNroPag() {
        return nroPag;
    }

    public int getNroCopias() {
        return nroCopias;
    }

    public void setNroCopias(int nroCopias) {
        this.nroCopias = nroCopias;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn + 
               ", Año: " + anioPub + ", Páginas: " + nroPag + ", Copias: " + nroCopias;
    }
}

