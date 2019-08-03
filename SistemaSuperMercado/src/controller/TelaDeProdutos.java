package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.dao.ItemDAO;
import model.domain.Carrinho;
import model.domain.Item;
import model.principal.CarrinhoModel;
import view.Principal;
import model.dao.CarrinhoDAO;


public class TelaDeProdutos {

    @FXML
    private TableView<Item> carrinho;
    
    @FXML
    private TableColumn<Item, Integer> qtd;
    
    @FXML 
    private TableColumn<Item, Integer> idProduto;
    
    @FXML
    private TableColumn<Item, String> marca;

    @FXML
    private TableColumn<Item, Double> valorProduto;

    @FXML
    private TextField nomeProduto;

    @FXML
    private TextField valorTotal;
    
    @FXML
   private TextField quantidadeProduto;
    
    Double valTot = 0.0;
    int indice = 0;
    
   private ItemDAO i;	
   private Item I;
   private CarrinhoDAO CD;
   private Carrinho C = new Carrinho();
   private CarrinhoModel carro = new CarrinhoModel();
   @FXML
    void adicionarProduto(ActionEvent event) {
    	
    	valorTotal.setDisable(true);
    		
    	i = new ItemDAO();
    	
    	int quantidade = Integer.parseInt(quantidadeProduto.getText());
    	C.setQtdItem(quantidade);
    	String nome=nomeProduto.getText();

    	ObservableList<Item> x  =  i.itemProcura(nome);
    	ObservableList<Item> p = x;
    	carro.adicionar(p, C, quantidade);
    			//FXCollections.observableArrayList(i.itemProcura(nomeProduto.getText()));
    	
    	valTot += x.get(0).getPrecoItem();
    	
    	if(!p.isEmpty()) {
    		valorTotal.setText(valTot.toString().format("%.2f", valTot));
    		
    		idProduto.setCellValueFactory(new PropertyValueFactory<>("idItem"));
    		marca.setCellValueFactory(new PropertyValueFactory<>("marcaItem"));
    		valorProduto.setCellValueFactory(new PropertyValueFactory<>("precoItem"));
        	
        	carrinho.getItems().addAll(p);
        	
    	}
    }

    @FXML
    void sair(ActionEvent event) {
    	Principal tela = new Principal();
    	tela.telaLogin();
    }

    
    @FXML
    void finalizarCompra(ActionEvent event) {
    	
    }

    @FXML
    void cancelar(ActionEvent event) {
    	carrinho.getItems().removeAll();
    	
    }


}

