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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.domain.Item;
import model.domain.Tipo;
import model.principal.GereciamentoProdutosModel;
import model.principal.TipoModel;

public class TelaGerente implements Initializable {

    @FXML
    private TextField marcaProduto;
    
    @FXML
    private Button btnAdicionar;
    
    @FXML
    private Button confirmar;
    
    @FXML 
    private TextField pesquisaInterna;
    
    @FXML
    private TextField nomeProduto; // procura item
    
    @FXML
    private TextField precoProduto;

    @FXML
    private TextField codigoProduto; 
    
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
    Alert alert;
    
    @FXML
    void adicionarProduto(ActionEvent event) {// funcionando
    	try {
    		Item item = new Item(marcaProduto.getText(), Integer.parseInt(qtdProduto.getText()),Double.parseDouble(precoProduto.getText()), listaTipos.getSelectionModel().getSelectedItem());
    	  	GereciamentoProdutosModel model = new GereciamentoProdutosModel();
       		model.adicionar(item);
       		
    	} catch (Exception e) {
    		//e.printStackTrace();
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Erro");
    		alert.setHeaderText(null);
    		alert.setContentText("Por favor, insira os dados corretamente");
    		alert.show();
    	}  
    	
    	carrinho.refresh();
    }

    // passing atributes to textField to edit product
    @FXML
    void editarProduto(ActionEvent event) { // ainda aceita indice que não existe no banco 
    	try {
    		Item item; 
    	
    		item = produtos.procuraItem(new Item(Integer.parseInt(pesquisaInterna.getText())));
    		
    		codigoProduto.setText("" + item.getIdItem());
    		marcaProduto.setText(item.getMarcaItem());
    		precoProduto.setText("" + item.getPrecoItem());
    		qtdProduto.setText("" + item.getQtdEstoque());
    		
    	} catch (Exception e) {
    		alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Erro");
    		alert.setHeaderText(null);
    		alert.setContentText("Por favor, insira o código corretamente");
    		alert.show();
    		
    	}
    	btnAdicionar.setDisable(true);
    	confirmar.setDisable(false);
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
    	try {
    		Item i = new Item(Integer.parseInt(pesquisaInterna.getText()));
    		produtos.removerItem(i); // transferindo objeto para camada model
    		
    		alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Remoção de produtos");
    		alert.setHeaderText(null);
    		alert.setContentText("Produto removido com sucesso");
    		alert.show();
    		
    	} catch(Exception e) {
    		alert = new Alert(AlertType.ERROR);
    		alert.setTitle("ERRO");
    		alert.setHeaderText(null);
    		alert.setContentText("Produto não encontrado!");
    		alert.show();
    	} 
    }
    
    @FXML
    void editConfirma(ActionEvent event) {
    	try {
    		Item item = new Item(Integer.parseInt(codigoProduto.getText()),marcaProduto.getText(), Integer.parseInt(qtdProduto.getText()),Double.parseDouble(precoProduto.getText()), listaTipos.getSelectionModel().getSelectedItem());
    		produtos.atualiza(item);

    		alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Sucesso");
    		alert.setHeaderText(null);
    		alert.setContentText("Produto Editado com sucesso.");
    		alert.show();
    		
    	} catch(Exception e) {
    		alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Erro");
    		alert.setHeaderText(null);
    		alert.setContentText("Por favor, insira o código corretamente");
    		alert.show();
    	}
    	btnAdicionar.setDisable(false);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TipoModel tipos = new TipoModel();
		ObservableList<Tipo> tiposChoiceBox = FXCollections.observableArrayList(tipos.procuraTipo());
		
		listaTipos.setItems(tiposChoiceBox);
		codigoProduto.setDisable(true);
		confirmar.setDisable(true);
	}
}
