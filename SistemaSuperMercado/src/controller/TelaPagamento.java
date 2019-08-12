package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import view.Principal;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.domain.Carrinho;
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
    private Carrinho car = new Carrinho();
    @FXML
    void subtrai(ActionEvent event) {
    	valorPago.setText(valor_pago.getText());
    	
    	double calculo = Double.parseDouble(valor_pago.getText()) - Double.parseDouble(valorCompra.getText());
    	if(0>calculo) {
    		result.setText(""+(calculo));
    		JOptionPane.showMessageDialog(null,"\nValor insuficiente\n Faltam:"+(calculo*-1)+"R$.");
    	}else {
    		JOptionPane.showMessageDialog(null, "Compra Realizada Com Sucesso!\n Porfavor aguarde enquanto Imprimimos seu Comprovante");
    	result.setText("Troco: "+calculo);
    	
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
					page.setDefaultLineWidth();
					page.closePath();
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
    		Principal tela = new Principal();
        	tela.telaProdutos(null);
    	}
    }
    
    @FXML
    void cancelar(ActionEvent event) {
    	Principal tela = new Principal();
    	tela.telaProdutos(null);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Principal.addOnChangeScreenListener(new Principal.OnChangeScreen() {
			
			@Override
			public void onScreenChanged(String newScreen, Object userData) {
				// TODO Auto-generated method stub
				
					valorCompra.setDisable(true);
					if(car instanceof Carrinho) { 
					car = (Carrinho) userData;
						valorCompra.setText(""+car.getPrecoTotal());
					}	
			}
		});
	}
		
	
}
