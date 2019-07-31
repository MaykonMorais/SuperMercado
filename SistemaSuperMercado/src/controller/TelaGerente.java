package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.dao.ItemDAO;
import model.domain.Item;
import model.domain.Tipo;

public class TelaGerente implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TreeTableView<Item> tabelaProduto;
    @FXML
    private TreeTableColumn<Item, Integer> idProduto;

    @FXML
    private TreeTableColumn<Item, String> marca;

    @FXML
    private TreeTableColumn<Item, Double> preco;

    @FXML
    private TreeTableColumn<Item, Integer> qtdEstoque;

    // opção de edição 
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
    void adicionarProduto(ActionEvent event) {

    }

    @FXML
    void editarProduto(ActionEvent event) {

    }

    @FXML
    void pesquisar(MouseEvent event) {

    }

    @FXML
    void removerProduto(ActionEvent event) {

    }
    
    ObservableList<Item> items;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ItemDAO i = new ItemDAO();
		items = i.consultaTotal();
		
		idProduto.setCellValueFactory();
		
	}
}
