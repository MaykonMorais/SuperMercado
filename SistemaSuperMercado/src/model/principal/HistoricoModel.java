package model.principal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dao.HistoricoDAO;
import model.domain.Historico;

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
		public void adicionaHistorico() {
			historico = new HistoricoDAO();
			CarrinhoModel model = new CarrinhoModel();
			int i=0;
			//while(!model.ids().isEmpty()) {
				historico.adicionar(historico.geradorAleatorioManipulado(),15);
				//++i;
			//}
		}
}
