package com.leoamorimr.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leoamorimr.cursomc.domain.enums.TipoCliente;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	private String nome;
	private String email;
	private String cpf;
	private Integer tipoCliente;

	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<>();

	/*
	 * Collection do tipo Set não permite repetição de valores. Não é necessário
	 * criar uma classe Telefone neste caso só para implementar o telefone.
	 * 
	 * @JsonManagedReference para não ocorrer erro de referencia cíclica no Json.
	 */
	@JsonIgnore
	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	/**
	 * 
	 */
	public Cliente() {
	}

	/**
	 * @param cod
	 * @param nome
	 * @param email
	 * @param cpf
	 * @param tipoCliente
	 */
	public Cliente(Integer cod, String nome, String email, String cpf, TipoCliente tipoCliente) {
		this.cod = cod;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.tipoCliente = tipoCliente.getCod();
	}

	/**
	 * @return the cod
	 */
	public Integer getCod() {
		return cod;
	}

	/**
	 * @param cod the cod to set
	 */
	public void setCod(Integer cod) {
		this.cod = cod;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the tipoCliente
	 */
	public TipoCliente getTipoCliente() {
		return TipoCliente.toEnum(tipoCliente);
	}

	/**
	 * @param tipoCliente the tipoCliente to set
	 */
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente.getCod();
	}

	/**
	 * @return the enderecos
	 */
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	/**
	 * @param enderecos the enderecos to set
	 */
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	/**
	 * @return the telefones
	 */
	public Set<String> getTelefones() {
		return telefones;
	}

	/**
	 * @param telefones the telefones to set
	 */
	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cod != other.cod)
			return false;
		return true;
	}

}
