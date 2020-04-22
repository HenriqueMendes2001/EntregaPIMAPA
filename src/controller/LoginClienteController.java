package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Login;
import service.LoginClienteService;

@WebServlet("/LoginCliente.do")
public class LoginClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		
		Login loginCliente = new Login();
		loginCliente.setEmail(pEmail);
		loginCliente.setSenha(pSenha);
		LoginClienteService ls = new LoginClienteService();
		
        String paginaDestino = null;
        
        try{
        	if(ls.checaDados(loginCliente)) {
        	    paginaDestino = "Login.jsp";
        	} else {
        		request.setAttribute("loginCliente", loginCliente);
                paginaDestino = "SenhaIncorreta.jsp";
        	}
        } catch(Exception e) {
        	System.out.println(e);
        }
             
        RequestDispatcher dispatcher = request.getRequestDispatcher(paginaDestino);
        dispatcher.forward(request, response);
	}	
}