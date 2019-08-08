package controller;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.domain.Carrinho;
import model.domain.Item;
import view.Principal;
import model.principal.*;

public class TelaDeProdutos implements Initializable{
	
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
    
    @FXML
    private TextField IdCompra;
    
    
    Double valTot = 0.00;
    int indice = 0;
   private GereciamentoProdutosModel g = new GereciamentoProdutosModel(); 
   
   private Carrinho C = new Carrinho();
   private CarrinhoModel carro = new CarrinhoModel();
   private HistoricoModel historico = new HistoricoModel();
   
   @FXML
    void adicionarProduto(ActionEvent event) {
    	
    	valorTotal.setDisable(true);
    		
    	int quantidade = Integer.parseInt(quantidadeProduto.getText());
    	String nome=nomeProduto.getText();
    	
    	Item I = new Item(nome,quantidade);
   
    	ObservableList<Item> x  = g.procura(I); 
    	ObservableList<Item> p = x;
    	
    	carro.adicionar(I,C);
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
    	historico.adicionaHistorico(C,carro,IdCompra.getText());
    	valTot = 0.00;
    	valorTotal.clear();
    	carrinho.getItems().clear();
    	IdCompra.setText(historico.getCodigo());
    }

    @FXML
    void cancelar(ActionEvent event) {
    	carro.limparCarrinho();
    	valTot = 0.00;
    	valorTotal.clear();
    	carrinho.getItems().clear();
    }

    @FXML
    void cancelarItem(ActionEvent event) {
    	
    	ObservableList<Item> allItems,removeItem;
    	allItems = carrinho.getItems();	
    	removeItem = carrinho.getSelectionModel().getSelectedItems();
    	valTot -= carrinho.getSelectionModel().getSelectedItems().get(0).getValorTotal();
    	valorTotal.setText(valTot.toString().format("%.2f", valTot));
    	carro.remover(carrinho.getSelectionModel().getSelectedItem());
    	removeItem.forEach(allItems::remove);
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		IdCompra.setDisable(true);
		IdCompra.setText(historico.getCodigo());	
	}

}
