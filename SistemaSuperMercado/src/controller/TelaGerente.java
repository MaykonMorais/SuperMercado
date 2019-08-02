package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.domain.Item;
import model.principal.GereciamentoProdutosModel;

public class TelaGerente {

    @FXML
    private TextField marcaProduto;

    @FXML
    private TextField precoProduto;

    @FXML
    private TextField qtdProduto;
    
    @FXML
    private ChoiceBox<?> listaTipos;

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

    @FXML
    void adicionarProduto(ActionEvent event) {
    	
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
		carrinho.getItems().addAll(listaItems);
    	
    }

    @FXML
    void procurarProduto(ActionEvent event) {
    	
    }

    @FXML
    void removerProduto(ActionEvent event) {

    }

}
