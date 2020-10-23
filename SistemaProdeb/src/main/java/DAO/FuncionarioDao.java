package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Funcionario;

public class FuncionarioDao {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public FuncionarioDao() {
		emf = Persistence.createEntityManagerFactory("prodeb");
		em = emf.createEntityManager();
	}
	
	
	
	public Funcionario obterPorId(int id) {
		em.getTransaction().begin();
		Funcionario funcionario = em.find(Funcionario.class,id);
		em.getTransaction().commit();
		emf.close();
		return funcionario;
	}
	
	public void salvar(Funcionario funcionario) {
		em.getTransaction().begin();
		em.merge(funcionario);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Funcionario funcionario) {
		em.getTransaction().begin();
		em.remove(funcionario);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> ListaTodos() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("select funcionario from Funcionario funcionario");
		List<Funcionario> funcionario = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return funcionario;
	}
}
