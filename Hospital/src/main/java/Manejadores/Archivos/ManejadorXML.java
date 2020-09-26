/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores.Archivos;

import java.io.File;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;



/**
 *
 * @author phily
 */
public class ManejadorXML {
    ClasificadorArchivo clasificador;
    
    public ManejadorXML(Connection conexionDB){//recuerda que este solo deberá ser ejecutado cuando la DB esté vacía...
        clasificador = new ClasificadorArchivo(conexionDB);
    }
    
    
    public void leerXML(String nombreArchivo){             
        
        try{
             DocumentBuilderFactory fabricaDocumento = DocumentBuilderFactory.newInstance();
             DocumentBuilder constructorDocumento = fabricaDocumento.newDocumentBuilder();
             Document documento = constructorDocumento.parse(new File(nombreArchivo));
             
             documento.getDocumentElement().normalize();
             
             
             clasificador.descargar(documento.getNodeName(), documento);
            
        }catch(ParserConfigurationException exc){
            JOptionPane.showMessageDialog(null, "No puedo transformarse el archivo", "error de conversion", JOptionPane.ERROR_MESSAGE);
        }   
        
        catch(Exception exc){
            JOptionPane.showMessageDialog(null, "Ha surgido un error al\nintentar leer el XML", "error de lectura", JOptionPane.ERROR_MESSAGE);            
        }                             
    }
    
    
    
    
    
}
/*
import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librerías
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder;
*/