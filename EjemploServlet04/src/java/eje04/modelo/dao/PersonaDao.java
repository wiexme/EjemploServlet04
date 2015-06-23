/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje04.modelo.dao;

import eje04.modelo.entidad.Persona;
import java.util.List;

/**
 *
 * @author Luis alberto
 */
public interface PersonaDao {
    
    public List<Persona> listarPersona(String Nombre);
    public boolean editarPersona(Persona persona);
    public boolean agregarPersona(Persona persona);
    public boolean eliminarPersona(String id);
    
}
