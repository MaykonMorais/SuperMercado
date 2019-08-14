package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.pdfjet.Letter;
import com.pdfjet.PDF;
import com.pdfjet.Page;

import javafx.stage.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class TelaPagamento  implements Initializable {
	@FXML
    private TextField valor_pago;

    @FXML
    private Text valorPago;
    
    @FXML
    private Text valorCompra;
    
    @FXML
    private Text result;
    
    @FXML
    
    private JFileChooser fc = new JFileChooser();
    
    @FXML
    void subtrai(ActionEvent event) {
    	valorPago.setText(valor_pago.getText());
    	
    	result.setText("0.00");
    	try {
    		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    		int i = fc.showSaveDialog(null);
    		if (i == 1) {
    	    } else {
    	        File arquivo = fc.getSelectedFile();
    	        String caminho = arquivo.getPath();
    	        try {
					FileOutputStream fos=new FileOutputStream(caminho);
					PDF pdf = new PDF(fos);
					
					Page page =new Page(pdf,Letter.LANDSCAPE);
					pdf.close();
					fos.flush();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	    }
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Compra Realizada Com Sucesso!\n Porfavor aguarde enquanto Imprimimos seu Comprovante");
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		valorCompra.setDisable(true);
		valorCompra.setText("190.00");
	}
		
	
}
