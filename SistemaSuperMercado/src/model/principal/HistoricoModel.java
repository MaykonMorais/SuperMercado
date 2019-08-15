package model.principal;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import dao.*;
import beans.*;

public class HistoricoModel {
	HistoricoDAO historico =  new HistoricoDAO();	
	
	public List<Historico> exibeHistorico() {
		return historico.todosHistoricos();
		
	}

	public Historico consultarHistorico(Historico h) throws NullPointerException {
			//System.out.println(historico.consultaEspecifica(h).getCodigoVenda());
			
			if(!historico.consultaEspecifica(h).getCodigoVenda().isEmpty()) {
				return historico.consultaEspecifica(h);
			} else {
				throw new NullPointerException();
			}
	}
	
	public void adicionaHistorico(Carrinho carrinho,CarrinhoModel model,String codigo) {
			
			Historico hist = new Historico(codigo);
			historico.adicionar(carrinho,hist);
			historico.subtrai(carrinho);
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
	public void atualizaHistorico(Historico hist) throws Exception {
		if(hist.getCodigoVenda().isEmpty()) {
			throw new Exception();
		}
		else {
			historico.atualizaHistorico(hist);
		}
	}
	
	
}