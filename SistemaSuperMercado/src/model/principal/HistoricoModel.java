package model.principal;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dao.HistoricoDAO;
import model.domain.Carrinho;
import model.domain.Historico;
import model.domain.Item;

public class HistoricoModel {
	HistoricoDAO historico;	
	public ObservableList<Historico> exibeHistorico() {
			ObservableList<Historico> historico = FXCollections.observableArrayList();
			return historico;
		}
		public ObservableList<Historico> consultarHistorico(String nome){
			ObservableList<Historico> historico = FXCollections.observableArrayList();
			return historico;
		}
		public void adicionaHistorico(Carrinho carrinho,CarrinhoModel model) {
			historico = new HistoricoDAO();
			String str=historico.geradorAleatorioManipulado();
			
			for(int i=0;i<model.ids().size();++i) {
				historico.adicionar(str,carrinho.getItems().get(i).getIdItem());
				
			}
			model.limparCarrinho();
		}
}
