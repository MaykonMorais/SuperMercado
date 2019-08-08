package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.database.ConnectionFactory;
import model.domain.Carrinho;
import model.domain.Historico;

public class HistoricoDAO {
	public ObservableList<Historico> consultaHistorico(String codigoVenda) {
		Connection con = ConnectionFactory.getConnection();
		Historico historico = null;
		
		ObservableList<Historico> historicos = FXCollections.observableArrayList();

		String sql = "select * from historicovendas as h inner join item as i on i.idItem = h.idItem inner join tipo as t on t.idtipo=i.idtipo where h.numerovenda like '"+codigoVenda+"";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				historico = new Historico(rs.getString(1),rs.getInt(2),rs.getDate(3),rs.getString(5),rs.getInt(6),rs.getDouble(7),rs.getInt(8),rs.getString(10),rs.getString(11));
				historicos.add(historico);
			}
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return historicos;
	}
	public ObservableList<Historico> todosHistoricos(){
		Connection con = ConnectionFactory.getConnection();
		ObservableList<Historico> historicos = FXCollections.observableArrayList();
		Historico historico = null;
		String sql = "select * from historivendas;";
		String gambiarra = null;
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				if(!gambiarra.equals(rs.getString(1))) { // evita que pegue o mesmo historico varias fezes
					historico = new Historico(rs.getString(1),rs.getInt(2),rs.getDate(3));
					historicos.add(historico);
					gambiarra = rs.getString(1);
				}
			}
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return historicos;
	}
	public void adicionar(Carrinho carrinho,Historico historico) {
		Connection con = ConnectionFactory.getConnection();
		int i=0;
		Date date = Calendar.getInstance().getTime();
		DateFormat formatodata = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String da = formatodata.format(date);
		String sql = "insert into historicovendas values(?,?,?,?)";
		while(i<carrinho.getItems().size()) {
	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,historico.getCodigoVenda());
			ps.setInt(2, carrinho.getItems().get(i).getIdItem());
			ps.setString(3,da);
			ps.setInt(4, carrinho.getItems().get(i).getQtdEstoque());
			// falta a data
			ps.execute();
			ps.close();
			
			}catch(SQLException e){
				e.printStackTrace();
			}
		++i;
		}
		carrinho.getItems().clear();
	}
	
	public String geradorAleatorioManipulado() {
		
		String aleatorio = gerarStringAleatoria();
		boolean result = true;
		
		while(result) {
			result = comparadorString(aleatorio);
			if(result) {aleatorio = gerarStringAleatoria();}
		}
		return aleatorio;
	}
	
	public boolean comparadorString(String string) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "select * from historicovendas;";
		
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			
			while(rs.next()) {// consertar String aleatoria para n repetir uma existente
					if(string.equals(rs.getString(1))) {
						return true;
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	
	}
	
	 public String gerarStringAleatoria() {
	        int qtdeMaximaCaracteres = 10;
	        String[] caracteres = {  "1", "2", "4", "5", "6", "7", "8",
	                "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
	                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
	                "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I",
	                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
	                "V", "W", "X", "Y", "Z" };
	      
	        StringBuilder senha = new StringBuilder();

	        for (int i = 0; i < qtdeMaximaCaracteres; i++) {
	            int posicao = (int) (Math.random() * caracteres.length);
	            senha.append(caracteres[posicao]);
	        }
	        return senha.toString();
	 } 
}