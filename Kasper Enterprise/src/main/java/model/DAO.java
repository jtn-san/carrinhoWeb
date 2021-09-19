package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
// Parametros de conexao

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://xx.xx.x.xxx:xx/dbkasper?useTimezone=true&serverTimezone=UTC";
	private String user = "dba";
	private String password = "Senac@123";

	/* Conexao */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void testarConexao() {
		try {
			Connection con = conectar();
			System.out.println("Conectado" + con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/* CRUD CREATE */
	public void inserirProduto(JavaBeans javabeans) {

		String create = "insert into meucarrinho (produto,quantidade,valor) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, javabeans.getProduto());
			pst.setString(2, javabeans.getQuantidade());
			pst.setString(3, javabeans.getValor());
			pst.executeUpdate();
			con.close();
			System.out.println("Produto adicionado");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/* CRUD READ */
	public ArrayList<JavaBeans> listarProdutos() {
		ArrayList<JavaBeans> produtos = new ArrayList<>();
		String read = "select * from meucarrinho order by produto";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery(); // Passo 3 -- 22 --
			while (rs.next()) {
				// passo 4 -- 22 --
				String idpro = rs.getString(1);
				String produto = rs.getString(2);
				String quantidade = rs.getString(3);
				String valor = rs.getString(4);
				// passo 5 -- 22 --
				// seta o construtor2 do JavaBeans(vetor)
				produtos.add(new JavaBeans(idpro, produto, quantidade, valor, valor));
			}
			con.close();
			return produtos;
		} catch (Exception e) {
			System.out.println(e);
			return (null);
		}
	}

	/* CRUD UPDATE */
	public void selecionarProduto(JavaBeans produto) {
		String read2 = "select * from meucarrinho where idpro=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, produto.getIdpro());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				produto.setIdpro(rs.getString(1));
				produto.setProduto(rs.getString(2));
				produto.setQuantidade(rs.getString(3));
				produto.setValor(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Metodo alterarContato
	public void alterarProduto(JavaBeans produto) {
		String update = "update meucarrinho set quantidade=? where idpro=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			//pst.setString(1, produto.getProduto());
			pst.setString(1, produto.getQuantidade());
			//pst.setString(3, produto.getValor());
			pst.setString(2, produto.getIdpro());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/* CRUD DELETE */
	public void deletarProduto(JavaBeans produto) {
		String delete = "delete from meucarrinho where idpro=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, produto.getIdpro());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void somarItem(JavaBeans javabeans)  {
			String somar = "select sum(quantidade * preco) from meucarrinho";
			 try {
				Connection con = conectar();
				 PreparedStatement pst = con.prepareStatement(somar);
				ResultSet rs = pst.executeQuery();			           
				 while (rs.next()) {
			 javabeans.setProduto(rs.getString(1));
			 } con.close();
			}  catch (Exception e) {
				 System.out.println(e);
			 }
	}
}
