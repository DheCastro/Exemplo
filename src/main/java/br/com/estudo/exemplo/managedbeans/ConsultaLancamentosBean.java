package br.com.estudo.exemplo.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.estudo.exemplo.model.Lancamento;
import br.com.estudo.exemplo.repository.Lancamentos;
import br.com.estudo.exemplo.service.CadastroLancamentos;
import br.com.estudo.exemplo.service.NegocioException;

@Named("consultaLancamentosBean")
@ViewScoped
public class ConsultaLancamentosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private Lancamentos lancamentosRepository;
	@Inject
	private CadastroLancamentos cadastro;
	private List<Lancamento> lancamentos;
	private Lancamento lancamentoSelecionado;

	public void consultar() {
		this.lancamentos = lancamentosRepository.todos();
	}

	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.excluir(this.lancamentoSelecionado);
			this.consultar();
			context.addMessage(null, new FacesMessage(
					"Lançamento excluído com sucesso!"));
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public Lancamentos getLancamentosRepository() {
		return lancamentosRepository;
	}

	public void setLancamentosRepository(Lancamentos lancamentosRepository) {
		this.lancamentosRepository = lancamentosRepository;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}

	public CadastroLancamentos getCadastro() {
		return cadastro;
	}

	public void setCadastro(CadastroLancamentos cadastro) {
		this.cadastro = cadastro;
	}

}