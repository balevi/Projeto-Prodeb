package Controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
//import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
//import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import Model.Funcionario;
import DAO.FuncionarioDao;

@Named("funci")
@RequestScoped
public class FuncionarioMB implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	Funcionario funcionario;
	
	List<Funcionario> funcionarios;
	FuncionarioDao funcionarioDao;
	
	public FuncionarioMB () {
		funcionarioDao = new FuncionarioDao();
		funcionario = new Funcionario();
	}

	public String salvar() {
		funcionarioDao.salvar(funcionario);
		return "CadastroPessoa";
	}

	public List<Funcionario> getFuncionarios() {
		funcionarios = funcionarioDao.ListaTodos();
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}



	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;	
	}



}
