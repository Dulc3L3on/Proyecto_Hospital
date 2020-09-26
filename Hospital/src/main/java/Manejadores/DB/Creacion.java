/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores.DB;

import java.sql.Connection;

/**
 *
 * @author phily
 */
public class Creacion {//si hay algo que pueda generalizar, será colocado aquí, de lo contrario, irá en su clase específica de la entidad ó si miras que no serán tantos los metodos, entonces aquí estarán los métodos por entidad, a sabiendas de que solo haBrá 1 [no creo que hayan más, pero si sí, sería max 2 [o talvez 3 xD]
    Connection conexion;
    
    public Creacion(Connection conexionDB){
        conexion=conexionDB;        
    }//recuerda que la instanciacion de esta clase y de sus hermanas accionistas en la DB xd, deberá hacerse en el punto donde se haga el logueo, luego de haber instanciado el manejadorDB...
    
    public void crearAdministrador(String codigo, String nombre, String DPI, String contrasenia){
        //Ahi te recuerdas el preparedStament y el try con recursos...
        
        //delano que habrá que llamar la herramienta para encriptar antes de mandar a guardar... duh! xd :v
    }
    
    
    /*
    Lo bueno es que estas clases CRUD, no requieren ser la misma instancia en las demás clases,puesto 
    que solo exe axn, mas no almacenan nada en su interior... o al menos por ahora xD
    */
}
