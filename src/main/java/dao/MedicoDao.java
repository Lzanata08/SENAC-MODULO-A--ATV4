/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.Optional;
import jpa.HospitalJpa;
import model.Medico;

/**
 *
 * @author zanat
 */
public class MedicoDao {

    public void cadastrar(Medico medico) {
        EntityManager em = HospitalJpa.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(medico);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            HospitalJpa.closeEtityManager();
        }
    }
    
     public Optional getByNome(String nome){
         EntityManager em = HospitalJpa.getEntityManager();
               
        try {
            Query consulta = em.createQuery("SELECT p FROM Medico p where p.nome = :nome");
            consulta.setParameter("nome", nome);
            return consulta.getResultList().stream().findFirst();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            HospitalJpa.closeEtityManager();
        }
        
        
        
    }
     
     public Optional getById(Long id){
         EntityManager em = HospitalJpa.getEntityManager();
               
        try {
            Query consulta = em.createQuery("SELECT p FROM Medico p where p.id = :id");            
            consulta.setParameter("id", id);
            return consulta.getResultList().stream().findFirst();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            HospitalJpa.closeEtityManager();
        }
        
        
        
    }
     
     
}
