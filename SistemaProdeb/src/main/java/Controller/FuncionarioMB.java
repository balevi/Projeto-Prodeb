package Controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import Model.Funcionario;
import DAO.FuncionarioDao;

@ManagedBean(name="funci")
@RequestScoped
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
	return "index";
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
