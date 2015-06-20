package br.com.estudo.exemplo.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.Persistence;

import br.com.estudo.exemplo.repository.Lancamentos;

@ApplicationScoped
public class LancamentoProducer {

	public LancamentoProducer() {
	
	}

	@Produces
	public Lancamentos createLancamentos() {
		return new Lancamentos(Persistence.createEntityManagerFactory("FinanceiroPU").createEntityManager());
	}

}