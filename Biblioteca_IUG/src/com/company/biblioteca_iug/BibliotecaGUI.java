/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.biblioteca_iug;


/**
 *
 * @author YOVANI
 */
// Archivo: BibliotecaGUI.java
public class BibliotecaGUI {
    private Biblioteca biblioteca;

    public BibliotecaGUI() {
        biblioteca = new Biblioteca();
    }

    public static void main(String[] args) {
        new BibliotecaGUI().biblioteca.mostrarGUI();
    }
}

