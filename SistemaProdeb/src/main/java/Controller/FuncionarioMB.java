package Controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Model.Funcionario;
import DAO.FuncionarioDao;

@ManagedBean(name="funci")
@SessionScoped
public class FuncionarioMB {
	Funcionario funcionario;
	List<Funcionario> funcionarios;
	FuncionarioDao funcionarioDao;
	
public FuncionarioMB () {
		funcionarioDao = new FuncionarioDao();
		funcionario = new Funcionario();
	}

public String salvar() {
	funcionarioDao.salvar(funcionario);
	return "CadastroPessoa.xhtml";
}

public Funcionario getFuncionario() {
	return funcionario;
}



public void setFuncionario(Funcionario funcionario) {
	this.funcionario = funcionario;
}



public List<Funcionario> getFuncionarios() {
	return funcionarios;
}

public void setFuncionarios(List<Funcionario> funcionarios) {
	this.funcionarios = funcionarios;
}



}
