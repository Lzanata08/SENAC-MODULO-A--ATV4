package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.Optional;
import jpa.HospitalJpa;
import model.Paciente;

public class PacienteDao {

    

    public void cadastrar(Paciente paciente) {
        EntityManager em = HospitalJpa.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(paciente);
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
            Query consulta = em.createQuery("SELECT p FROM Paciente p where p.nome = :nome");
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
            Query consulta = em.createQuery("SELECT p FROM Paciente p where p.id = :id");            
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
