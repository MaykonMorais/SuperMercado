package model.principal;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dao.HistoricoDAO;
import model.domain.Carrinho;
import model.domain.Historico;
import model.domain.Item;

public class HistoricoModel {
	HistoricoDAO historico =  new HistoricoDAO();	
	
	public List<Historico> exibeHistorico() {
		return historico.todosHistoricos();
		
	}

	public ObservableList<Historico> consultarHistorico(String nome){
			ObservableList<Historico> historico = FXCollections.observableArrayList();
			return historico;
	}
	
	public void adicionaHistorico(Carrinho carrinho,CarrinhoModel model,String codigo) {
		
		Historico hist = new Historico(codigo);
		historico.adicionar(carrinho,hist);
		}
		public void adicionaHistorico(Carrinho carrinho,CarrinhoModel model,String codigo) {
			
			Historico hist = new Historico(codigo);
			historico.adicionar(carrinho,hist);
			historico.subtrai(carrinho);
			model.limparCarrinho();
		}
		public String getCodigo() {
		
		model.limparCarrinho();
	}
	
	public String getCodigo() {
		return historico.geradorAleatorioManipulado();
	}
	
	public List<Historico> verifica(Historico h) throws Exception {
		if(!h.getDataCompra().isEmpty()) {
			if(historico.procuraData(h) != null) {
				return historico.procuraData(h);
			}
			else {
				throw new NullPointerException();
			}
		}
		else {
			throw new Exception();
		}
	}
	
	
}
