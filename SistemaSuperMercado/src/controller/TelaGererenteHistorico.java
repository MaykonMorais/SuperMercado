package controller;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.domain.Historico;
import model.domain.Item;
import model.principal.GereciamentoProdutosModel;
import model.principal.HistoricoModel;
import view.Principal;

public class TelaGererenteHistorico implements Initializable {
    @FXML
    private TextField pesquisaItem;
    
    @FXML
    private TextField idProduto;
    
    // pesquisa item historico para troca
    @FXML 
    private TextField codigoPesquisa;
    
    @FXML
    private TextField idProdutoPesquisa;
    
    // seleciona produto pra troca
    @FXML
    private TextField codigoVendaPesquisa;
    
    @FXML
    private TextField pesquisaTroca;
    
    @FXML
    private TableView<Historico> tabelaHistorico;

    @FXML
    private TableColumn<Historico, String> codigoVenda;

    @FXML
    private TableColumn<Historico, Integer> idItem;

    @FXML
    private TableColumn<Historico, String> dataCompra;
    
   
    // verifica a pesquisa do codigo para troca
    @FXML 
    private void verifica(ActionEvent event) {
    	try {
    		Historico h = new Historico(codigoPesquisa.getText(), Integer.parseInt(idProdutoPesquisa.getText()));
    		h = modelHistorico.consultarHistorico(h);
    		
    		codigoVendaPesquisa.setText(h.getCodigoVenda());
    		idProduto.setText(""+h.getIdItem());
    		
    		
    	} catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Digite corretamente os campos");
    		codigoVendaPesquisa.clear();
    		idProduto.clear();
    		e.printStackTrace();
    	}
    }
    
    @FXML
    public void pesquisaTroca(ActionEvent event) {
    	GereciamentoProdutosModel produtosModel = new GereciamentoProdutosModel();
    	
    	try {
    		Item item = new Item(pesquisaTroca.getText());
    		item = produtosModel.procura(item).get(0);
    		
    		Historico hist = new Historico(codigoVendaPesquisa.getText(), Integer.parseInt(idProduto.getText()));
    		System.out.println(hist.getCodigoVenda());
    		System.out.println(hist.getIdItem());
    		modelHistorico.atualizaHistorico(hist);
    		
    	} catch (Exception e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Troca");
    		alert.setHeaderText(null);
    		alert.setContentText("Impossivel trocar produto");
    		alert.show();
    		e.printStackTrace();
    	}
    }
    
    @FXML
    public void confirmaTroca(ActionEvent event) {
    	
    }
        
    @FXML
    void cadastrarFuncionario(ActionEvent event) {
    	
    }

    @FXML
    void sair(ActionEvent event) {
    	
    }

    @FXML
    void verHistorico(ActionEvent event) {
    	
    }

    HistoricoModel modelHistorico = new HistoricoModel();
	
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	ObservableList<Historico> historico = FXCollections.observableArrayList(modelHistorico.exibeHistorico());
		
		codigoVenda.setCellValueFactory(new PropertyValueFactory<Historico, String>("codigoVenda"));
		idItem.setCellValueFactory(new PropertyValueFactory<Historico, Integer>("idItem"));
		dataCompra.setCellValueFactory(new PropertyValueFactory<Historico, String>("dataCompra"));
		
		
		tabelaHistorico.getItems().addAll(historico);
		codigoVendaPesquisa.setDisable(true);
		idProduto.setDisable(true);
    }

	@FXML public void gerenciamentoProdutos(ActionEvent event) {
		Principal tela = new Principal();
		tela.telaGerente();
		
	}
}

/*
@FXML 
public void verifica(ActionEvent event)  {
	try {
		String date = dataConsulta.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Historico h = new Historico(date);
		
		List<Historico> listaProcurados = new ArrayList<Historico>(modelHistorico.verifica(h));
		
		Double valor = 0.0;
		
	
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Por favor, digite procure uma data válida");
	}
}

*/
