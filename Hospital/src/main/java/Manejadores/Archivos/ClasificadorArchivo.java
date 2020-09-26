/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores.Archivos;

import Manejadores.DB.Creacion;
import java.sql.Connection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author phily
 */
public class ClasificadorArchivo {
    Creacion creadorRegistros;
    
    public ClasificadorArchivo(Connection conexionDB){
         creadorRegistros = new Creacion(conexionDB);
    }
    
    
    public void descargar(String categoria, Document documento){//el XML está formado por raiz [hospital], categorias [admin, labo, pac...] y atribitos                
        
        switch(categoria){
            case "admin":
                leerAdministrador(documento.getElementsByTagName(categoria));//con esto se obtiene a todos los nodos que correspondan a la categoría "admin" en este caso...
            break;
            
            case "doctor":
                leerDoctor(documento.getElementsByTagName(categoria));//podría ser el nombre mismo, pero para generalizar xD
            break;
            
            case "laboratorista":
                leerLaboratorista(documento.getElementsByTagName(categoria));
            break;
            
            case "paciente":
                leerPaciente(documento.getElementsByTagName(categoria));
            break;
            
            case "examen":
                leerExamen(documento.getElementsByTagName(categoria));
            break;
            
            case "reporte":
                leerInforme(documento.getElementsByTagName(categoria));
            break;
            
            case "resultado":
            break;
            
            case "cita":
            break;
            
            case "consulta":
            break;
        }
        
        
    }
    
    //toma en cuenta que cada uno de estos métodos emplearán la misma técnica para leer cada una de las etiquetas, pero por la manera de guardarlas en la DB, habrán varias composiciones xD
    private void leerAdministrador(NodeList categoria){//lo cual viene a ser los nodos, p.ej -> doctor, examen....
        for(int numeroNodo=0; numeroNodo < categoria.getLength(); numeroNodo++ ){//es decir el numero de ocurrencia del mismo tipo de categoría...
            Node nodo = categoria.item(numeroNodo);//que aquí lo nombraron como item xD
            
            if(nodo.getNodeType()== Node.ELEMENT_NODE){//aquí reviso si es un elemnto que por lo tanto contiene atributos [es decir si p.ej es un admin con su DPI, nombre, contra y codigo...
                Element elemento = (Element) nodo;
                
                creadorRegistros.crearAdministrador(elemento.getAttribute("codigo"), elemento.getAttribute("nombre"), elemento.getAttribute("DPI"), elemento.getAttribute("contrasenia"));//no olvides que todo lo devuelve como un string...
            }                        
        }                
    }//Y ASÍ XD, ESTE ES EL PROCESO GENERAL QUE DEBERÁS SEGUIR, A LO CUAL LE AGREGARÁS LAS PERSONALIZACIONES, ES DECIR cuando requiere una op extra, pues requiere crear otra tabla, o porque el atributo en la DB es de diferente tipo... pero lo que tienes ahorita, es lo general xD
    
    private void leerDoctor(NodeList categoria){
    
    }
    
    private void leerLaboratorista(NodeList categoria){
    
    }
    
    private void leerPaciente(NodeList categoria){
    
    }
    
    private void leerExamen(NodeList categoria){
    
    }
    
    private void leerInforme(NodeList categoria){
    
    }
    
    private void descargarResultado(){
    
    }
    
    private void descargarCita(){
    
    }
    
    private void descargarConsulta(){
    
    }
 
    //para realizar las comparaciones en la lista de especialidades, deberás emplear el ignore case, puesto que solo eso podría cb entre c/u de dichos titulos...
    
}
