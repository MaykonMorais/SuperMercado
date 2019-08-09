package controller;

import java.awt.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class TelaPagamento {
	@FXML
    private TextField valor_pago;

    @FXML
    private Text valorPago;
    
    @FXML
    private Text valorCompra;
    
    @FXML
    private Text result;
    
    @FXML
    void subtrai(ActionEvent event) {
    	valorPago.setText(valor_pago.getText());
    	valorCompra.setText("190.00");
    	result.setText("0.00");
    }
}
