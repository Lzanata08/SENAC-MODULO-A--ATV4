/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import jpa.HospitalJpa;
import model.Consulta;

/**
 *
 * @author zanat
 */
public class ConsultaDao {
    public void cadastrar(Consulta consulta) {
        EntityManager em = HospitalJpa.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(consulta);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            HospitalJpa.closeEtityManager();
        }
    }
    
    
    public List<Consulta> listar() {
        EntityManager em = HospitalJpa.getEntityManager();
               
        try {
            Query query = em.createQuery("SELECT c FROM consulta c");
            
            return query.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            HospitalJpa.closeEtityManager();
        }
    }
}

