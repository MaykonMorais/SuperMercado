package controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dao.ItemDAO;
import model.domain.Item;
import model.domain.Tipo;
import model.principal.GereciamentoProdutosModel;
import model.principal.TipoModel;

public class TelaGerente implements Initializable {

    @FXML
    private TextField marcaProduto;
    
    @FXML 
    private TextField pesquisaInterna;
    
    @FXML
    private TextField nomeProduto; // procura item
    
    @FXML
    private TextField precoProduto;

    @FXML
    private TextField qtdProduto;
    
    @FXML
    private ChoiceBox<Tipo> listaTipos;

    @FXML
    private TextField procuraItem;

    @FXML
    private TableView<Item> carrinho;

    @FXML
    private TableColumn<Item, Integer> idProduto;
    
    @FXML
    private TableColumn<Item, Integer> estoque;
    
    @FXML
    private TableColumn<Item, String> marca;

    @FXML
    private TableColumn<Item, Double> valorProduto;
    
    ObservableList<Item> listaItems;
    Tipo tipo = new Tipo();
    GereciamentoProdutosModel produtos = new GereciamentoProdutosModel();
   
    @FXML
    void adicionarProduto(ActionEvent event) {
    	GereciamentoProdutosModel model = new GereciamentoProdutosModel();
    	model.adicionar(marcaProduto.getText(), Double.parseDouble(precoProduto.getText()), Integer.parseInt(qtdProduto.getText()), listaTipos.getSelectionModel().getSelectedItem());
    	
    	carrinho.refresh();
    }

    @FXML
    void editarProduto(ActionEvent event) {
    	
    }

    @FXML
    void listarTodos(ActionEvent event) {
    	
    	listaItems = FXCollections.observableArrayList(produtos.listarItems());
    	
    	idProduto.setCellValueFactory(new PropertyValueFactory<>("idItem"));
		marca.setCellValueFactory(new PropertyValueFactory<>("marcaItem"));
		valorProduto.setCellValueFactory(new PropertyValueFactory<>("precoItem"));
		estoque.setCellValueFactory(new PropertyValueFactory<>("qtdEstoque"));;
		
		carrinho.getItems().clear();
		carrinho.getItems().addAll(listaItems);
    }

    @FXML
    void procurarProduto(ActionEvent event) {
    	listaItems = FXCollections.observableArrayList(produtos.procuraItem(nomeProduto.getText()));
    	
    	idProduto.setCellValueFactory(new PropertyValueFactory<>("idItem"));
		marca.setCellValueFactory(new PropertyValueFactory<>("marcaItem"));
		valorProduto.setCellValueFactory(new PropertyValueFactory<>("precoItem"));
		estoque.setCellValueFactory(new PropertyValueFactory<>("qtdEstoque"));;
		
    	carrinho.getItems().clear();
    	carrinho.getItems().addAll(listaItems);
    }

    @FXML
    void removerProduto(ActionEvent event) {
    	Alert alert;
    	if(produtos.removerItem(Integer.parseInt(pesquisaInterna.getText()))) {
    		alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Remoção de produtos");
    		alert.setHeaderText(null);
    		alert.setContentText("Produto removido com sucesso");
    		alert.show();
    		
    	}
    	else {
    		alert = new Alert(AlertType.ERROR);
    		alert.setTitle("ERRO");
    		alert.setHeaderText(null);
    		alert.setContentText("Produto não encontrado!");
    		alert.show();
    		
    		carrinho.getItems().clear();
        	carrinho.getItems().addAll(listaItems);
    		
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TipoModel tipos = new TipoModel();
		ObservableList<Tipo> tiposChoiceBox = FXCollections.observableArrayList(tipos.procuraTipo());
		
		listaTipos.setItems(tiposChoiceBox);
	}
}
