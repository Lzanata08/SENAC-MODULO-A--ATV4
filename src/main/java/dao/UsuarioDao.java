/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jpa.HospitalJpa;
import model.Usuario;

/**
 *
 * @author zanat
 */
public class UsuarioDao {
   
    public Usuario buscaPorUsuario(String usuario) {
        EntityManager em = HospitalJpa.getEntityManager();

        try {
            Query consulta = em.createQuery("SELECT u FROM Usuario u where u.login = :usuario");
            consulta.setParameter("usuario", usuario);
            return (Usuario) consulta.getSingleResult();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            HospitalJpa.closeEtityManager();
        }
    }
}