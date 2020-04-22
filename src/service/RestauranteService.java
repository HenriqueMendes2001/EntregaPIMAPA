package service;

import model.Restaurante;
import dao.RestauranteDAO;


public class RestauranteService {
	RestauranteDAO dao = new RestauranteDAO();
	
	public int criar(Restaurante restaurante) {
		return dao.criar(restaurante);
	}
	
	public void atualizar(Restaurante restaurante){
		dao.atualizar(restaurante);
	}
	
	public void excluir(int codRestaurante){
		dao.excluir(codRestaurante);
	}
	
	public Restaurante carregar(int codRestaurante){
		return dao.carregar(codRestaurante);
	}
}

