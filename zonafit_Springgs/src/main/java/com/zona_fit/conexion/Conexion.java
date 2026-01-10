package com.zona_fit.conexion;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

     public static Connection getConnection(){

         Connection conexion = null;
         String baseDatos ="zonafit_spring";
         String url = "jdbc:mysql://localhost:3306/" + baseDatos;
         String user = "admin";
         String password = "admin";

         try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          conexion = DriverManager.getConnection(url,user,password);

         } catch (Exception e){
             System.out.println("Error al conectarnos a la base de datos" + e.getMessage());
         }

         return conexion;
    }
    public static void main(String[] args) {
         var conexion = Conexion.getConnection();

         if (conexion != null){
             System.out.println("Se logro conectar a nuestra base de datos:" +
                     " " + conexion);
         }else {
             System.out.println("Error al conectarse a nuestra base de datos");
         }
    }
}
