package Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Model.Pessoa;

@Named("bean")

@SessionScoped
public class PessoaMb implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private Pessoa pessoa;
	
	private List<Pessoa> pessoas = new ArrayList<>();

	public String adicionar () {
		pessoas.add(pessoa);
		
		limpar();
		return null;
	}
	
	private void limpar() {
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	
}
