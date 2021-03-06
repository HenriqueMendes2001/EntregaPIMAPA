package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;

@WebServlet("/ManterCliente.do")
public class ManterClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pFone = request.getParameter("fone");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		String pCPF = request.getParameter("CPF");
		String pEnderecoRua = request.getParameter("enderecoRua");
		String pEnderecoNumero = request.getParameter("enderecoNumero");
		String pEnderecoCEP = request.getParameter("enderecoCEP");
		
		//instanciar o javabean
		Cliente cliente = new Cliente();
		cliente.setNome(pNome);
		cliente.setFone(pFone);
		cliente.setEmail(pEmail);
		cliente.setSenha(pSenha);
		cliente.setCPF(pCPF);
		cliente.setEnderecoRua(pEnderecoRua);
		cliente.setEnderecoNumero(pEnderecoNumero);
		cliente.setEnderecoCEP(pEnderecoCEP);
		
		//instanciar o service
		ClienteService cs = new ClienteService();
		cs.criar(cliente);
		cliente = cs.carregar(cliente.getCPF());
		
		//envia para o jsp
		request.setAttribute("cliente", cliente);
		
		RequestDispatcher view = request.getRequestDispatcher("Cliente.jsp");
		view.forward(request, response);		
	}
}
