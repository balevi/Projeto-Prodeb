package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Funcionario;

public class FuncionarioDao {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public FuncionarioDao() {
		emf = Persistence.createEntityManagerFactory("prodeb");
		//em = emf.createEntityManager();
	}
	
	
	
	public Funcionario obterPorId(int id) {
		try {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Funcionario funcionario = em.find(Funcionario.class,id);
		em.getTransaction().commit();
		em.close();
		return funcionario;
		} catch (Exception e) {
			System.out.println("Erro interno ao tentar inserir no banco!");
		}
		return null;
	}
	
	public void salvar(Funcionario funci) {
		try {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		//em.persist(funci);
		em.merge(funci);
		em.getTransaction().commit();
		em.close();
		} catch (Exception e) {
			System.out.println("Erro interno ao tentar inserir no banco!");
		}
	}
	
	public void remover(Funcionario funcionario) {
		try {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(Funcionario.class, funcionario.getId()));
		em.getTransaction().commit();
		em.close();
		} catch (Exception e) {
			System.out.println("Erro interno ao tentar excluir no banco!");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> listaTodos() {
		try {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Funcionario> funcionarios = em.createQuery("select	f from Funcionario f").getResultList();
		em.getTransaction().commit();
		em.close();
		return funcionarios;
		} catch (Exception e) {
			System.out.println("Erro interno ao tentar listar no banco!");
		}
		return null;
	}
}
