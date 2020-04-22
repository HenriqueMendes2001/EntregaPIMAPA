package model;

import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
	private String CPF;
	private String nome;
	private String fone;
	private String email;
	private String senha;
	private String enderecoRua;
	private String enderecoNumero;
	private String enderecoCEP;

	public Cliente() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEnderecoRua() {
		return enderecoRua;
	}

	public void setEnderecoRua(String enderecoRua) {
		this.enderecoRua = enderecoRua;
	}
	
	public String getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}
	
	public String getEnderecoCEP() {
		return enderecoCEP;
	}

	public void setEnderecoCEP(String enderecoCEP) {
		this.enderecoCEP = enderecoCEP;
	}

	@Override
	public String toString() {
		return "Cliente [CPF=" + CPF + ", nome=" + nome + ", fone=" + fone
				+ ", email=" + email + ", senha=" + senha + ", endereco=" + enderecoRua + ", "
				+ enderecoNumero + " - " + enderecoCEP + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (enderecoRua == null) {
			if (other.enderecoRua != null)
				return false;
		} else if (!enderecoRua.equals(other.enderecoRua))
			return false;
		
		if (enderecoNumero == null) {
			if (other.enderecoNumero != null)
				return false;
		} else if (!enderecoNumero.equals(other.enderecoNumero))
			return false;
		
		if (enderecoCEP == null) {
			if (other.enderecoCEP != null)
				return false;
		} else if (!enderecoCEP.equals(other.enderecoCEP))
			return false;
		
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		
		if (fone == null) {
			if (other.fone != null)
				return false;
		} else if (!fone.equals(other.fone))
			return false;
		
		if (CPF != other.CPF)
			return false;
		
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}