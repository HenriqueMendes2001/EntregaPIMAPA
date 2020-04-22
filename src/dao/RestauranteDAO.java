package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Restaurante;


public class RestauranteDAO {
	
	public int criar(Restaurante restaurante) {
		String sqlInsert = "INSERT INTO restaurante(nomeRestaurante, descricaoRestaurante, "
				+ "enderecoRuaRestaurante, enderecoNumeroRestaurante, enderecoCEPRestaurante"
				+ ", telefoneRestaurante, Proprietario_CNPJ) VALUES (?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, restaurante.getNome());
			stm.setString(2, restaurante.getDescricao());
			stm.setString(3, restaurante.getEnderecoRua());
			stm.setString(4, restaurante.getEnderecoNumero());
			stm.setString(5, restaurante.getEnderecoCEP());
			stm.setString(6, restaurante.getFone());
			stm.setString(7, restaurante.getProprietarioCNPJ());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					restaurante.setCodRestaurante(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurante.getCodRestaurante();
	}

	public void atualizar(Restaurante restaurante) {
		String sqlUpdate = "UPDATE restaurante SET nomeRestaurante=?, descricaoRestaurante=?, " + 
				"enderecoRuaRestaurante=?, enderecoNumeroRestaurante=?, enderecoCEPRestaurante=?" + 
				", telefoneRestaurante=?, Proprietario_CNPJ=? WHERE codRestaurante=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, restaurante.getNome());
			stm.setString(2, restaurante.getDescricao());
			stm.setString(3, restaurante.getEnderecoRua());
			stm.setString(4, restaurante.getEnderecoNumero());
			stm.setString(5, restaurante.getEnderecoCEP());
			stm.setString(6, restaurante.getFone());
			stm.setString(7, restaurante.getProprietarioCNPJ());
			stm.setInt(8, restaurante.getCodRestaurante());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int codRestaurante) {
		String sqlDelete = "DELETE FROM restaurante WHERE codRestaurante = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, codRestaurante);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Restaurante carregar(int codRestaurante) {
		Restaurante restaurante = new Restaurante();
		restaurante.setCodRestaurante(codRestaurante);
		String sqlSelect = "SELECT nomeRestaurante, descricaoRestaurante, enderecoRuaRestaurante, "
				+ "enderecoNumeroRestaurante, enderecoCEPRestaurante, telefoneRestaurante,"
				+ "Proprietario_CNPJ FROM restaurante WHERE restaurante.codRestaurante = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, restaurante.getCodRestaurante());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					restaurante.setNome(rs.getString("nomeRestaurante"));
					restaurante.setDescricao(rs.getString("descricaoRestaurante"));
					restaurante.setEnderecoRua(rs.getString("enderecoRuaRestaurante"));
					restaurante.setEnderecoNumero(rs.getString("enderecoNumeroRestaurante"));
					restaurante.setEnderecoCEP(rs.getString("enderecoCEPRestaurante"));
					restaurante.setFone(rs.getString("telefoneRestaurante"));
					restaurante.setProprietarioCNPJ(rs.getString("Proprietario_CNPJ"));
					
				} else {
					restaurante.setCodRestaurante(-1);
					restaurante.setNome(null);
					restaurante.setDescricao(null);
					restaurante.setEnderecoRua(null);
					restaurante.setEnderecoNumero(null);
					restaurante.setEnderecoCEP(null);
					restaurante.setFone(null);
					restaurante.setProprietarioCNPJ(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return restaurante;
	}

}
