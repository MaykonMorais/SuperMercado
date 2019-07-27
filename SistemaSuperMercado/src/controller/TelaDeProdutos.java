package controller;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import view.Principal;
import model.domain.Item;

public class TelaDeProdutos {
	private Principal tela;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Item> carrinho;

    @FXML
    private TableColumn<Item, Integer > qtd;

    @FXML
    private TableColumn<Item, String> produto;

    @FXML
    private TableColumn<Item, Double> valorProduto;

    @FXML
    private TableColumn<Item, String> codigoProduto;

    @FXML
    private TextField qtdProduto;

    @FXML
    private TextField nomeProduto;

    @FXML
    void adicionarProduto(ActionEvent event) {

    }

    @FXML
    void sair(ActionEvent event) {
    	tela = new Principal();
    	tela.telaLogin();
    }

    @FXML
    void initialize() {
    	
    }
    
}
