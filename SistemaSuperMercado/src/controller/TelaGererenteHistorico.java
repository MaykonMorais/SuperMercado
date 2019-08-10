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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.domain.Historico;
import model.principal.HistoricoModel;
import view.Principal;

public class TelaGererenteHistorico implements Initializable {

    @FXML
    private TextField pesquisaItem;

    @FXML
    private TextField faturamento;
    
    @FXML
    private TableView<Historico> tabelaHistorico;

    @FXML
    private TableColumn<Historico, String> codigoVenda;

    @FXML
    private TableColumn<Historico, Integer> idItem;

    @FXML
    private TableColumn<Historico, String> dataCompra;
    
    @FXML
    private DatePicker dataConsulta;

    
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
    }

	@FXML public void gerenciamentoProdutos(ActionEvent event) {
		Principal tela = new Principal();
		tela.telaGerente();
	}
	
	
}
