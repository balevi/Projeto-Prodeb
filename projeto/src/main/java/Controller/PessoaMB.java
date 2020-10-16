package Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import Model.Pessoa;

@Named("bean")
@SessionScoped
public class PessoaMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa;
	
	private List<Pessoa> pessoas = new ArrayList<>();

	public String Adicionar () {
		pessoas.add(pessoa);
		
		limpar();
		return null;
	}
	
	private void limpar() {
		pessoa = new Pessoa();
	}
}
