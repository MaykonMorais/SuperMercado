package controller;

import java.net.URL;
import java.util.ResourceBundle;
import view.Principal;
import javax.swing.JOptionPane;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import beans.Carrinho;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;


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
    		gerandoPDF();
    	}
    	}
    
    
    @FXML
    void cancelar(ActionEvent event) {
    	Principal tela = new Principal();
    	tela.telaProdutos();
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
	
	public  void gerandoPDF() {
  
    	
    	try {
    		Document pdf = new Document();
    		try {
				PdfWriter.getInstance(pdf,new FileOutputStream("/home/thomas/WorkSpace/Test.pdf"));
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		pdf.open();
    		pdf.setPageSize(PageSize.A4);
    		
    		try {
    			pdf.addTitle("COMPORVANTE");
				
				
				PdfPCell cabecalho = new PdfPCell(new Paragraph("Lista de Items"));
				cabecalho.setHorizontalAlignment(Element.ALIGN_CENTER);
				cabecalho.setBorder(PdfPCell.NO_BORDER);
				cabecalho.setBackgroundColor(new BaseColor(100,150,200));
				cabecalho.setColspan(5);
				PdfPTable table = new PdfPTable(5);
				table.addCell(cabecalho);
				//Image imagem =  Image.getInstance("/home/thomas/Imagens/astronaut_on_the_moon_victory-wallpaper-1366x768.jpg");
				//imagem.scaleToFit(200,400);
				Font font9Preto = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
				
	            
	            table.getDefaultCell().setBorder(PdfPCell.BOTTOM); 
	            table.addCell(new Paragraph("ID", font9Preto));
	            table.addCell(new Paragraph("Marca", font9Preto));
	            table.addCell(new Paragraph("Quantidade", font9Preto));
	            table.addCell(new Paragraph("Valor Unitário", font9Preto));
	            table.addCell(new Paragraph("Valor Final",font9Preto));
	            double valor_total=0;
	            
	           
	           for(int k=0;k<car.getItems().size();++k) {
	            	table.addCell(""+car.getItems().get(k).getIdItem());
	            	table.addCell(car.getItems().get(k).getMarcaItem());
	            	table.addCell(""+car.getItems().get(k).getQtdEstoque());
	            	table.addCell(""+car.getItems().get(k).getPrecoItem());
	            	table.addCell("+"+car.getItems().get(k).getValorTotal());
	            	valor_total+=car.getItems().get(k).getValorTotal();
	           }
	           
	            table.addCell("");
           		table.addCell("");
           		table.addCell("");
           		table.addCell("");
	            table.addCell(""+valor_total);
				//pdf.add(imagem);
				pdf.add(table);	
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
    		pdf.close();
    	}catch(IOException ioe) {
    		ioe.printStackTrace();
    	}finally{
    		
    	}
	}
}
