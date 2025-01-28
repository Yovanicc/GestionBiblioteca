/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.biblioteca_iug;

/**
 *
 * @author YOVANI
 */
public class Enciclopedia extends Libro {
    private int nroVolumen;
    private String tema;

    public Enciclopedia(int isbn, String titulo, String autor, int anioPub, int nroPag, int nroCopias, int nroVolumen, String tema) {
        super(isbn, titulo, autor, anioPub, nroPag, nroCopias);
        this.nroVolumen = nroVolumen;
        this.tema = tema;
    }

    public int getNroVolumen() {
        return nroVolumen;
    }

    public String getTema() {
        return tema;
    }

    @Override
    public String toString() {
        return super.toString() + ", Volumen: " + nroVolumen + ", Tema: " + tema;
    }
}
