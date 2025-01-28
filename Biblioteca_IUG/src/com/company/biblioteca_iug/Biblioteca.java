/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.biblioteca_iug;

/**
 *
 * @author YOVANI
 */


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class Biblioteca {
    private Estanteria<Libro> estanteria;
    private JTextArea outputArea;

    public Biblioteca() {
        estanteria = new Estanteria<>();
        outputArea = new JTextArea(10, 30);
    }

    public void mostrarGUI() {
        JFrame frame = new JFrame("Biblioteca");
        JButton btnAgregarLibro = new JButton("Agregar Libro");
        JButton btnListarLibros = new JButton("Listar Libros");
        JButton btnBuscarAutor = new JButton("Buscar por Autor");
        JButton btnBuscarTitulo = new JButton("Buscar por Título");
        JButton btnBuscarISBN = new JButton("Buscar por ISBN");
        JButton btnBuscarNroCopias = new JButton("Buscar por Nro. de Copias");
        JButton btnPrestar = new JButton("Prestar Libro");
        JButton btnDevolver = new JButton("Devolver Libro");

        btnAgregarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });

        btnListarLibros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarLibros();
            }
        });

        btnBuscarAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPorAutor();
            }
        });

        btnBuscarTitulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPorTitulo();
            }
        });

        btnBuscarISBN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPorISBN();
            }
        });

        btnBuscarNroCopias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPorNroCopias();
            }
        });

        btnPrestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prestarLibro();
            }
        });

        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                devolverLibro();
            }
        });

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(new JScrollPane(outputArea));
        frame.add(btnAgregarLibro);
        frame.add(btnListarLibros);
        frame.add(btnBuscarAutor);
        frame.add(btnBuscarTitulo);
        frame.add(btnBuscarISBN);
        frame.add(btnBuscarNroCopias);
        frame.add(btnPrestar);
        frame.add(btnDevolver);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void agregarLibro() {
        String[] opciones = {"Libro Tangible", "EBook", "Revista", "Enciclopedia", "Tesis"};
        int eleccion = JOptionPane.showOptionDialog(null, "Seleccione el tipo de libro:", "Agregar Libro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        if (eleccion == -1) return;

        try {
            int isbn = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ISBN del libro:"));
            String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
            String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
            int anioPub = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de publicación:"));
            int nroPag = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de páginas:"));
            int nroCopias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de copias disponibles:"));

            Libro libro = null;
            switch (eleccion) {
                case 0 -> {
                    String genero = JOptionPane.showInputDialog("Ingrese el género del libro tangible:");
                    libro = new LibroTangible(isbn, titulo, autor, anioPub, nroPag, nroCopias, genero);
                }
                case 1 -> {
                    double pesoMB = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso en MB del eBook:"));
                    String formato = JOptionPane.showInputDialog("Ingrese el formato del eBook (e.g., PDF, EPUB):");
                    libro = new EBook(isbn, titulo, autor, anioPub, nroPag, nroCopias, pesoMB, formato);
                }
                case 2 -> {
                    int volumen = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el volumen de la revista:"));
                    int nroEdicion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de edición de la revista:"));
                    libro = new Revista(isbn, titulo, autor, anioPub, nroPag, nroCopias, volumen, nroEdicion);
                }
                case 3 -> {
                    int nroVolumen = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de volumen de la enciclopedia:"));
                    String tema = JOptionPane.showInputDialog("Ingrese el tema de la enciclopedia:");
                    libro = new Enciclopedia(isbn, titulo, autor, anioPub, nroPag, nroCopias, nroVolumen, tema);
                }
                case 4 -> {
                    String universidad = JOptionPane.showInputDialog("Ingrese la universidad asociada a la tesis:");
                    String area = JOptionPane.showInputDialog("Ingrese el área de investigación de la tesis:");
                    libro = new Tesis(isbn, titulo, autor, anioPub, nroPag, nroCopias, universidad, area);
                }
            }

            if (libro != null) {
                estanteria.agregarLibro(libro);
                outputArea.append("Libro agregado: " + libro + "\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese valores numéricos válidos.");
        }
    }

    private void listarLibros() {
        outputArea.setText(estanteria.listarLibros());
    }

    private void buscarPorAutor() {
        String autor = JOptionPane.showInputDialog("Ingrese el autor a buscar:");
        List<Libro> resultados = estanteria.buscarPorAutor(autor);
        mostrarResultadosBusqueda(resultados);
    }

    private void buscarPorTitulo() {
        String titulo = JOptionPane.showInputDialog("Ingrese el título a buscar:");
        List<Libro> resultados = estanteria.buscarPorTitulo(titulo);
        mostrarResultadosBusqueda(resultados);
    }

    private void buscarPorISBN() {
        int isbn = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ISBN a buscar:"));
        Libro resultado = estanteria.buscarPorISBN(isbn);
        outputArea.setText(resultado != null ? resultado.toString() : "No se encontró el libro con ese ISBN.");
    }

    private void buscarPorNroCopias() {
        int nroCopias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de copias a buscar:"));
        List<Libro> resultados = estanteria.buscarPorNroCopias(nroCopias);
        mostrarResultadosBusqueda(resultados);
    }

    private void prestarLibro() {
        int isbn = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ISBN del libro a prestar:"));
        boolean exito = estanteria.prestar(isbn);
        outputArea.setText(exito ? "Libro prestado exitosamente." : "No se pudo prestar el libro.");
    }

    private void devolverLibro() {
        int isbn = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ISBN del libro a devolver:"));
        boolean exito = estanteria.devolver(isbn);
        outputArea.setText(exito ? "Libro devuelto exitosamente." : "No se pudo devolver el libro.");
    }

    private void mostrarResultadosBusqueda(List<Libro> resultados) {
        if (resultados.isEmpty()) {
            outputArea.setText("No se encontraron resultados.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Libro libro : resultados) {
                sb.append(libro.toString()).append("\n");
            }
            outputArea.setText(sb.toString());
        }
    }
}
