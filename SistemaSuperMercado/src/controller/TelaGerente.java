package controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    	GereciamentoProdutosModel produtos = new GereciamentoProdutosModel();
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
    	
    }

    @FXML
    void removerProduto(ActionEvent event) {
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TipoModel tipos = new TipoModel();
		ObservableList<Tipo> tiposChoiceBox = FXCollections.observableArrayList(tipos.procuraTipo());
		
		listaTipos.setItems(tiposChoiceBox);
	}

}
