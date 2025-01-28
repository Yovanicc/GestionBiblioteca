/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.biblioteca_iug;

/**
 *
 * @author YOVANI
 */
public class EBook extends Libro {
    private double pesoMB;
    private String formato;

    public EBook(int isbn, String titulo, String autor, int anioPub, int nroPag, int nroCopias, double pesoMB, String formato) {
        super(isbn, titulo, autor, anioPub, nroPag, nroCopias);
        this.pesoMB = pesoMB;
        this.formato = formato;
    }

    public double getPesoMB() {
        return pesoMB;
    }

    public String getFormato() {
        return formato;
    }

    @Override
    public String toString() {
        return super.toString() + ", Peso: " + pesoMB + "MB, Formato: " + formato;
    }
}
