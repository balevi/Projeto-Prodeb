package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
//import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
//import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import Model.Funcionario;
import DAO.FuncionarioDao;

@Named("funci")
@RequestScoped
public class FuncionarioMB {

	@Inject
	Funcionario funcionario = new Funcionario();
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	FuncionarioDao funcionarioDao = new FuncionarioDao();
	
	public FuncionarioMB () {
		funcionarios = funcionarioDao.listaTodos();
	}

	public String salvar() {
		funcionarioDao.salvar(funcionario);
		limparObjeto();
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Salvo com sucesso!"));

		this.getFuncionarios();
		return "CadastroPessoa";
	}
	
	public String editar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Atualizado com sucesso!"));
		return "EditaPessoa";
	}
	
	public String excluir() {
		funcionarioDao.remover(funcionario);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Excluido com sucesso!"));
		this.getFuncionarios();
		return "CadastroPessoa";
	}
	
	public void limparObjeto() {
		funcionario = new Funcionario();
		
	}
	

	public List<Funcionario> getFuncionarios() {
		funcionarios = funcionarioDao.listaTodos();
		return funcionarios;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;	
	}

}
