/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.biblioteca_iug;



/**
 *
 * @author YOVANI
 */
public class LibroTangible extends Libro {
    private String genero;

    public LibroTangible(int isbn, String titulo, String autor, int anioPub, int nroPag, int nroCopias, String genero) {
        super(isbn, titulo, autor, anioPub, nroPag, nroCopias);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return super.toString() + ", Género: " + genero;
    }
}