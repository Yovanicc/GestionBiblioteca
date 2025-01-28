/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.biblioteca_iug;

/**
 *
 * @author YOVANI
 */


// Archivo: Estanteria.java
import java.util.ArrayList;
import java.util.List;

public class Estanteria<T extends Libro> {
    private List<T> libros = new ArrayList<>();

    public void agregarLibro(T libro) {
        libros.add(libro);
    }

    public List<T> getLibros() {
        return libros;
    }

    public String listarLibros() {
        if (libros.isEmpty()) {
            return "No hay libros en la estantería.";
        }
        StringBuilder sb = new StringBuilder();
        for (T libro : libros) {
            sb.append(libro.toString()).append("\n");
        }
        return sb.toString();
    }

    public List<T> buscarPorAutor(String autor) {
        List<T> resultados = new ArrayList<>();
        for (T libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public List<T> buscarPorTitulo(String titulo) {
        List<T> resultados = new ArrayList<>();
        for (T libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public T buscarPorISBN(int isbn) {
        for (T libro : libros) {
            if (libro.getIsbn() == isbn) {
                return libro;
            }
        }
        return null;
    }

    public List<T> buscarPorNroCopias(int nroCopias) {
        List<T> resultados = new ArrayList<>();
        for (T libro : libros) {
            if (libro.getNroCopias() == nroCopias) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public boolean prestar(int isbn) {
        T libro = buscarPorISBN(isbn);
        if (libro != null && libro.getNroCopias() > 0) {
            libro.setNroCopias(libro.getNroCopias() - 1);
            return true;
        }
        return false;
    }

    public boolean devolver(int isbn) {
        T libro = buscarPorISBN(isbn);
        if (libro != null) {
            libro.setNroCopias(libro.getNroCopias() + 1);
            return true;
        }
        return false;
    }
}
