/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consola;

import eje04.modelo.dao.PersonaDao;
import eje04.modelo.dao.impl.PersonaDaoImpl;
import eje04.modelo.entidad.Persona;

/**
 *
 * @author Luis alberto
 */
public class Main {
 
    
    public static void main(String[] args) {
        
        Main main = new Main();
        
        main.agregar();
//        main.actualizar();
//        main.eliminar();
//        main.listarPersona();
    }
    
    public void agregar(){
        PersonaDao dao = new PersonaDaoImpl();
        Persona persona = new Persona();
        
        persona.setIdpersona("1");
        persona.setNombre("Eliazer");
        persona.setApellidoPat("Fernadez");
        persona.setApellidoMat("Guevara");
        persona.setDni("71349999");
        if (dao.agregarPersona(persona)) {
            System.out.println("Se agrego Correctamente.");
        } else {
            System.out.println("Ocurrio un Error al agregar.");
        }
    }
    
    public void actualizar(){
        PersonaDao dao = new PersonaDaoImpl();
        Persona persona = new Persona();
        
        persona.setIdpersona("1");
        persona.setNombre("Luis");
        persona.setApellidoPat("santa maria");
        persona.setApellidoMat("ticlavilca");
        persona.setDni("11121121");
        if (dao.editarPersona(persona)) {
            System.out.println("Se actualizo Correctamente.");
        } else {
            System.out.println("Ocurrio un Error al actualizar.");
        }
    }
    
    public void listarPersona(){
    
        PersonaDao dao = new PersonaDaoImpl();
        for (Persona persona : dao.listarPersona("")) {
            System.out.println("id: "+persona.getIdpersona()+" | Nombre:"+persona.getNombre()+" | app_pat:"+persona.getApellidoPat()+" | app_mat:"+persona.getApellidoMat()+" | dni:"+persona.getDni());
        }
    }
    
    public void eliminar(){
        PersonaDao dao = new PersonaDaoImpl();
        if (dao.eliminarPersona("1")) {
             System.out.println("Se elimino Correctamente.");
        } else {
            System.out.println("Ocurrio un Error al eliminar.");
        }
    }
    
}
