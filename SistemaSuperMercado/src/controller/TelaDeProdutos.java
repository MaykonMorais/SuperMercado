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
import model.principal.HistoricoModel;
import view.Principal;
import model.dao.CarrinhoDAO;


public class TelaDeProdutos {

    @FXML
    private TableView<Item> carrinho;
    
    @FXML 
    private TableColumn<Item, Integer> idProduto;
    
    @FXML
    private TableColumn<Item, String> marca;

    @FXML
    private TableColumn<Item, Double> valorProduto;
    
    @FXML
    private TableColumn<Item, Integer> Quantidade;
    
    @FXML
    private TableColumn<Item, Double> Valor;
    
    @FXML
    private TextField nomeProduto;

    @FXML
    private TextField valorTotal;
    
    @FXML
   private TextField quantidadeProduto;
    
    @FXML
    private TextField idItem;
    
    Double valTot = 0.0;
    int indice = 0;
    
   private ItemDAO i;	
   private Item item;
   private Carrinho C = new Carrinho();
   private CarrinhoModel carro = new CarrinhoModel();
   private HistoricoModel historico = new HistoricoModel();
   @FXML
    void adicionarProduto(ActionEvent event) {
    	
    	valorTotal.setDisable(true);
    		
    	i = new ItemDAO();
    	
    	int quantidade = Integer.parseInt(quantidadeProduto.getText());
    
    	String nome=nomeProduto.getText();
    	
    	ObservableList<Item> x  = i.itemProcura(nome, quantidade); 
    	ObservableList<Item> p = x;
    	carro.adicionar(p, C, quantidade);
    			//FXCollections.observableArrayList(i.itemProcura(nomeProduto.getText()));
    	
    	valTot += x.get(0).getValorTotal();
    	
    	if(!p.isEmpty()) {
    		valorTotal.setText(valTot.toString().format("%.2f", valTot));
    		
    		idProduto.setCellValueFactory(new PropertyValueFactory<>("idItem"));
    		marca.setCellValueFactory(new PropertyValueFactory<>("marcaItem"));
    		valorProduto.setCellValueFactory(new PropertyValueFactory<>("precoItem"));
    		Quantidade.setCellValueFactory(new PropertyValueFactory<>("qtdEstoque"));
    		Valor.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
    		
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
    	historico.adicionaHistorico(C,carro);
    }

    @FXML
    void cancelar(ActionEvent event) {
    	carro.limparCarrinho();
    }

    @FXML
    void cancelarItem(ActionEvent event) {
    	ObservableList<Item> allItems,removeItem;
    	allItems = carrinho.getItems();	
    	removeItem = carrinho.getSelectionModel().getSelectedItems();
    	removeItem.forEach(allItems::remove);
    	carro.remover(Integer.parseInt(idItem.getText()));
    }

}

