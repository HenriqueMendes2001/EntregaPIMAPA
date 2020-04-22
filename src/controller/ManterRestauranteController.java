package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Restaurante;
import service.RestauranteService;

@WebServlet("/ManterRestaurante.do")
public class ManterRestauranteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pCodRestaurante = request.getParameter("codRestaurante");
		String pNome = request.getParameter("nome");
		String pDescricao = request.getParameter("descricao");
		String pEnderecoRua = request.getParameter("enderecoRua");
		String pEnderecoNumero = request.getParameter("enderecoNumero");
		String pEnderecoCEP = request.getParameter("enderecoCEP");
		String pFone = request.getParameter("fone");
		String pProprietarioCNPJ = request.getParameter("ProprietarioCNPJ");
		
		int codRestaurante = -1;
		
		try {
			codRestaurante = Integer.parseInt(pCodRestaurante);
		} catch (NumberFormatException e) {

		}
		
		//instanciar o javabean
		Restaurante restaurante = new Restaurante();
		restaurante.setCodRestaurante(codRestaurante);
		restaurante.setNome(pNome);
		restaurante.setDescricao(pDescricao);
		restaurante.setEnderecoRua(pEnderecoRua);
		restaurante.setEnderecoNumero(pEnderecoNumero);
		restaurante.setEnderecoCEP(pEnderecoCEP);
		restaurante.setFone(pFone);
		restaurante.setProprietarioCNPJ(pProprietarioCNPJ);
		
		//instanciar o service
		RestauranteService rs = new RestauranteService();
		rs.criar(restaurante);
		restaurante = rs.carregar(restaurante.getCodRestaurante());
		
		//envia para o jsp
		request.setAttribute("restaurante", restaurante);
		
		RequestDispatcher view = request.getRequestDispatcher("Restaurante.jsp");
		view.forward(request, response);		
	}
}

