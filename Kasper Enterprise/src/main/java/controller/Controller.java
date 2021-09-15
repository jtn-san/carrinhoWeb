package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/calcular" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Criar objetos para acessar os metodos publicos Javabeans e DAO
	JavaBeans javabeans = new JavaBeans();
	DAO dao = new DAO();

	public Controller() {
		super();

	}

	/**
	 * Metodo principal do Servlet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Agenda está:
		// ").append(request.getContextPath());
		dao.testarConexao();
		// Encaminhamento das requisicoes
		String action = request.getServletPath();// armazena a requisicao atual
		System.out.println("Requisição: " + action);
		if (action.equals("/main")) {
			produtos(request, response);
		} else if (action.equals("/insert")) {
			novoProduto(request, response);
		} else if (action.equals("/select")) {
			listarProduto(request, response);
		} else if (action.equals("/update")) {
			editarProduto(request, response);
		} else if (action.equals("/delete")) {
			removerProduto(request, response);
		}else if (action.equals("/calcular")) {
			calculoCarrinho(request, response);
		}

	}

	// Adicionar produtos
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Receber os dados do formulario e armazenar temporarimente nas variaveis
		// javabeans
		javabeans.setProduto(request.getParameter("produto"));
		javabeans.setQuantidade(request.getParameter("quantidade"));
		javabeans.setValor(request.getParameter("valor"));

		// executar o metodo inserirContato (DAO) passando javabeans
		dao.inserirProduto(javabeans);
		response.sendRedirect("main");
	}

	// Listar produtos
	protected void produtos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<JavaBeans> lista = dao.listarProdutos();
		
		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("carrinho.jsp");
		rd.forward(request, response);
	}
	
	//Editar - Selecionar Produto
	protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idpro = request.getParameter("idpro");
		
		System.out.println(idpro);
		
		javabeans.setIdpro(idpro);
		dao.selecionarProduto(javabeans);
		request.setAttribute("idpro", javabeans.getIdpro());
		request.setAttribute("produto", javabeans.getProduto());
		request.setAttribute("quantidade", javabeans.getQuantidade());
		request.setAttribute("valor", javabeans.getValor());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	
	// Passo 2 - Editar um contato
	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		javabeans.setIdpro(request.getParameter("idpro"));
		javabeans.setProduto(request.getParameter("produto"));
		javabeans.setQuantidade(request.getParameter("quantidade"));
		javabeans.setValor(request.getParameter("valor"));
		dao.alterarProduto(javabeans);
		response.sendRedirect("main");
	}
	protected void removerProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		javabeans.setIdpro(request.getParameter("idpro"));
		dao.deletarProduto(javabeans); 
		response.sendRedirect("main");
	}
	protected void calculoCarrinho(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		javabeans.setQuantidade(request.getParameter("quantidade"));
		javabeans.setValor(request.getParameter("valor"));
		dao.calculoCarrinho(javabeans);
		//response.sendRedirect("main");
	}
	
}
