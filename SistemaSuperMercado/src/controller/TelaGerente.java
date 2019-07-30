package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.MouseEvent;

public class TelaGerente {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TreeTableView<?> tabelaProduto;

    @FXML
    private TreeTableColumn<?, ?> idProduto;

    @FXML
    private TreeTableColumn<?, ?> marca;

    @FXML
    private TreeTableColumn<?, ?> preco;

    @FXML
    private TreeTableColumn<?, ?> qtdEstoque;

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

    @FXML
    void initialize() {
        assert tabelaProduto != null : "fx:id=\"tabelaProduto\" was not injected: check your FXML file 'telaGerente.fxml'.";
        assert idProduto != null : "fx:id=\"idProduto\" was not injected: check your FXML file 'telaGerente.fxml'.";
        assert marca != null : "fx:id=\"marca\" was not injected: check your FXML file 'telaGerente.fxml'.";
        assert preco != null : "fx:id=\"preco\" was not injected: check your FXML file 'telaGerente.fxml'.";
        assert qtdEstoque != null : "fx:id=\"qtdEstoque\" was not injected: check your FXML file 'telaGerente.fxml'.";
        assert marcaProduto != null : "fx:id=\"marcaProduto\" was not injected: check your FXML file 'telaGerente.fxml'.";
        assert precoProduto != null : "fx:id=\"precoProduto\" was not injected: check your FXML file 'telaGerente.fxml'.";
        assert qtdProduto != null : "fx:id=\"qtdProduto\" was not injected: check your FXML file 'telaGerente.fxml'.";
        assert listaTipos != null : "fx:id=\"listaTipos\" was not injected: check your FXML file 'telaGerente.fxml'.";
        assert procuraItem != null : "fx:id=\"procuraItem\" was not injected: check your FXML file 'telaGerente.fxml'.";

    }
}
