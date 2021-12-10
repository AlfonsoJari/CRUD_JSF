/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import entidades.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author alfon
 */
public class UsuariosModel {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    /*public boolean create(Usuario user) {
        boolean result = true;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            result = false;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }*/

    public Usuario get(Usuario user) {
        //boolean result = true;
        Usuario userVal;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            userVal = (Usuario) session.get(Usuario.class, user.getUsuario());
            transaction.commit();
        } catch (Exception e) {
            userVal = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return userVal;
    }
    
}
