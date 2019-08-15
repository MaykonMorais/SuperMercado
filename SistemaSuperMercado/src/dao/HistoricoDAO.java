package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.database.ConnectionFactory;
import beans.*;

public class HistoricoDAO {
	private static Connection con;
	
	public HistoricoDAO() {
		this.con = ConnectionFactory.getConnection();
	}
	
	public Historico consultaEspecifica(Historico historico) {
		Historico h = new Historico();
		String sql = "select numeroVenda, idItem from historicoVendas where numeroVenda = '" + historico.getCodigoVenda() + "' and idItem = " + historico.getIdItem() + ";";
		
		try {	
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				h.setCodigoVenda(rs.getString(1));
				h.setIdItem(rs.getInt(2));
			}
			//System.out.println(h.getCodigoVenda());
			//System.out.println(h.getIdItem());
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return h;
	}
	
	public ObservableList<Historico> consultaHistorico(String codigoVenda) {
		Historico historico = null;
		
		ObservableList<Historico> historicos = FXCollections.observableArrayList();

		String sql = "select * from historicovendas as h inner join item as i on i.idItem = h.idItem inner join tipo as t on t.idtipo=i.idtipo where h.numerovenda like '"+codigoVenda+"";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				historico = new Historico(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(5),rs.getInt(6),rs.getDouble(7),rs.getInt(8),rs.getString(10),rs.getString(11));
				historicos.add(historico);
			}
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return historicos;
	}
	
	public List<Historico> todosHistoricos(){
		
		Connection con = ConnectionFactory.getConnection();
		List<Historico> historicos = new ArrayList<Historico>();
		
		Historico historico = null;
		String sql = "select * from historicovendas;";
		String gambiarra = null;
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//if(!gambiarra.equals(rs.getString(1))) { // evita que pegue o mesmo historico varias vezes
					historico = new Historico(rs.getString(1),rs.getInt(2),rs.getString(3));
					historicos.add(historico);
					gambiarra = rs.getString(1);
			//	}
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
		DateFormat formatodata = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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
	}
	public void subtrai(Carrinho carrinho) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "select * from Item where idItem = (?)";
		
		String sql1 = "update item set qtdEstoque = (?) where idItem = (?)";
		int i=0;
		while(i<carrinho.getItems().size()) {
		
			try {
				PreparedStatement ps1 = con.prepareStatement(sql);
				ps1.setInt(1, carrinho.getItems().get(i).getIdItem());
				ResultSet rs1 = ps1.executeQuery();
				PreparedStatement ps2 = con.prepareStatement(sql1);
				while(rs1.next()) {
				ps2.setInt(1,(rs1.getInt(3) - carrinho.getItems().get(i).getQtdEstoque()) );
				ps2.setInt(2, carrinho.getItems().get(i).getIdItem());
				
				++i;
				}

				ps2.execute();
				ps1.close();
				rs1.close();
				ps2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	 
	 public List<Historico> procuraData(Historico historico) {
		 	Connection con = ConnectionFactory.getConnection();
		 	Item item;
			List<Historico> historicos = new ArrayList<Historico>();

			String sql = "select historicoVendas.numeroVenda, item.marca, historicoVendas.quantidade, (item.preco * historicoVendas.quantidade) as TotalVendido from historicoVendas inner join item using(idItem) where dataCompra like '" + historico.getDataCompra() + "%'";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) { // 1 - vendas 2 - marca(item) 3 - quantidade(historico) 4 - historico
					item = new Item(rs.getString(2));
					
				}
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return historicos;
		}
	 
	 public void atualizaHistorico(Historico hist) {// atualizando o item do historico  
		 PreparedStatement ps;
			
			String sql = "update historicoVendas set idItem = ? where numeroVenda = ?";	
			//+ hist.getCodigoVenda() + "'";
			
			try {
					ps = con.prepareStatement(sql);
					ps.setInt(1, hist.getIdItem());
					ps.setString(2, hist.getCodigoVenda());
					
					ps.execute();
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	 	}
}