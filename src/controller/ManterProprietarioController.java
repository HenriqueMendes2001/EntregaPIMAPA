package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Proprietario;
import service.ProprietarioService;

@WebServlet("/ManterProprietario.do")
public class ManterProprietarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pFone = request.getParameter("fone");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		String pCNPJ = request.getParameter("CNPJ");
		
		//instanciar o javabean
		Proprietario proprietario = new Proprietario();
		proprietario.setNome(pNome);
		proprietario.setFone(pFone);
		proprietario.setEmail(pEmail);
		proprietario.setSenha(pSenha);
		proprietario.setCNPJ(pCNPJ);
		
		//instanciar o service
		ProprietarioService ps = new ProprietarioService();
		ps.criar(proprietario);
		proprietario = ps.carregar(proprietario.getCNPJ());
		
		//envia para o jsp
		request.setAttribute("proprietario", proprietario);
		
		RequestDispatcher view = request.getRequestDispatcher("Proprietario.jsp");
		view.forward(request, response);		
	}
}
