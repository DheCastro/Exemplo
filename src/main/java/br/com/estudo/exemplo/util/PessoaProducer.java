package br.com.estudo.exemplo.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.Persistence;

import br.com.estudo.exemplo.repository.Pessoas;

@ApplicationScoped
public class PessoaProducer {

	public PessoaProducer() {
	
	}

	@Produces
	public Pessoas createPessoas() {
		return new Pessoas(Persistence.createEntityManagerFactory("FinanceiroPU").createEntityManager());
	}

}