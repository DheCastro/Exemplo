package br.com.estudo.exemplo.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

import br.com.estudo.exemplo.service.CadastroLancamentos;

@ApplicationScoped
public class CadastroLancamentoProducer {

	public CadastroLancamentoProducer() {
	
	}

	@Produces
	@RequestScoped
	public CadastroLancamentos createCadastroLancamento() {
		return new CadastroLancamentos();
	}

}