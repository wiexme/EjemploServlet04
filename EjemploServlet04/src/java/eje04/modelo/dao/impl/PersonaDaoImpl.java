/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje04.modelo.dao.impl;

import eje04.modelo.dao.PersonaDao;
import eje04.modelo.entidad.Persona;
import eje04.modelo.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Luis alberto
 */
public class PersonaDaoImpl implements PersonaDao{

    @Override
    public List<Persona> listarPersona(String Nombre) {
        List<Persona> lista = null;
        SessionFactory sf = null;
        Session session = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            Query query = session.createQuery("FROM Persona WHERE nombre like'"+Nombre+"%'");
            lista = query.list();
            session.close();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
            session.close();
        }
        
        return lista;
    }

    @Override
    public boolean editarPersona(Persona persona) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {          
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            Persona p = (Persona) session.get(Persona.class, persona.getIdpersona());
            p.setNombre(persona.getNombre());
            p.setApellidoPat(persona.getApellidoPat());
            p.setApellidoMat(persona.getApellidoMat());
            p.setDni(persona.getDni());
            session.update(p);
            tx.commit();
            session.close();
            flat = true;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
            tx.rollback();
            session.close();
            flat = false;
            
        }
        return flat;
    }

    @Override
    public boolean agregarPersona(Persona persona) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;

        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(persona);
            tx.commit();
            session.close();
            flat = true;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
            tx.rollback();
            session.close();
            flat = false;
            
        }
        return flat;
    }

    @Override
    public boolean eliminarPersona(String id) {
         boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            Persona p = (Persona) session.get(Persona.class, id);
            session.delete(p);
            tx.commit();
            session.close();
            flat = true;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
            tx.rollback();
            session.close();
            flat = false;
        }
        return flat;
    }
    
}
