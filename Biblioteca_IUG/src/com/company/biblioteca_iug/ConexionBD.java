package com.company.biblioteca_iug;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author YOVANI
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10759870";
    private static final String USER = "sql10759870";
    private static final String PASSWORD = "PSjCqQp39p";

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("¡Conexión exitosa a la base de datos!");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos:");
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexión cerrada.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
