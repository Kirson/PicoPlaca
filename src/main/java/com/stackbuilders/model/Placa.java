package com.stackbuilders.model;

import java.io.Serializable;

public class Placa implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 2361834088606052398L;
	private String numero;
	
	public Placa(String numero){
		this.numero= numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
