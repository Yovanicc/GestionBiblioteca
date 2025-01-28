/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.biblioteca_iug;



/**
 *
 * @author YOVANI
 */
public class Revista extends Libro {
    private int volumen;
    private int nroEdicion;

    public Revista(int isbn, String titulo, String autor, int anioPub, int nroPag, int nroCopias, int volumen, int nroEdicion) {
        super(isbn, titulo, autor, anioPub, nroPag, nroCopias);
        this.volumen = volumen;
        this.nroEdicion = nroEdicion;
    }

    public int getVolumen() {
        return volumen;
    }

    public int getNroEdicion() {
        return nroEdicion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Volumen: " + volumen + ", Edición: " + nroEdicion;
    }
}