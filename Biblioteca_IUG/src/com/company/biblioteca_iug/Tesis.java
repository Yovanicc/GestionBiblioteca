/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.biblioteca_iug;



/**
 *
 * @author YOVANI
 */
// Archivo: Tesis.java
public class Tesis extends Libro {
    private String universidad;
    private String area;

    public Tesis(int isbn, String titulo, String autor, int anioPub, int nroPag, int nroCopias, String universidad, String area) {
        super(isbn, titulo, autor, anioPub, nroPag, nroCopias);
        this.universidad = universidad;
        this.area = area;
    }

    public String getUniversidad() {
        return universidad;
    }

    public String getArea() {
        return area;
    }

    @Override
    public String toString() {
        return super.toString() + ", Universidad: " + universidad + ", Área: " + area;
    }
}
