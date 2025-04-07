/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.EntityManager;
import jpa.HospitalJpa;
import model.Usuario;

/**
 *
 * @author zanat
 */
public class UsuarioDao {
    public void cadastrar(Usuario usuario) {
        EntityManager em = HospitalJpa.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            HospitalJpa.closeEtityManager();
        }
    }
}