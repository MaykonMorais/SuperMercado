package model.principal;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dao.HistoricoDAO;
import model.domain.Carrinho;
import model.domain.Historico;
import model.domain.Item;

public class HistoricoModel {
	HistoricoDAO historico =  new HistoricoDAO();	
	public ObservableList<Historico> exibeHistorico() {
			ObservableList<Historico> historico = FXCollections.observableArrayList();
			return historico;
		}
		public ObservableList<Historico> consultarHistorico(String nome){
			ObservableList<Historico> historico = FXCollections.observableArrayList();
			return historico;
		}
		public void adicionaHistorico(Carrinho carrinho,CarrinhoModel model,String codigo) {
		
			Historico hist = new Historico(codigo);
			historico.adicionar(carrinho,hist);
			
			model.limparCarrinho();
		}
		public String getCodigo() {
		
			return historico.geradorAleatorioManipulado();
		}
}
