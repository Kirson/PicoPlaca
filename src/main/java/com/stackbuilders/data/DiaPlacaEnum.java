package com.stackbuilders.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum DiaPlacaEnum {

	LUNES(1,new ArrayList<Integer>(Arrays.asList(1,2))),
	MARTES(2,new ArrayList<Integer>(Arrays.asList(3,4))),
	MIERCOLES(3,new ArrayList<Integer>(Arrays.asList(5,6))),
	JUEVES(4,new ArrayList<Integer>(Arrays.asList(7,8))),
	VIERNES(5,new ArrayList<Integer>(Arrays.asList(0,9))),
	SABADO(6,new ArrayList<Integer>()),
	DOMINGO(7,new ArrayList<Integer>());
	
	private Integer numeroDia;
	private List<Integer> numerosProhibidosList;
	
	DiaPlacaEnum(Integer numeroDia, List<Integer> numerosProhibidosList){
		this.numeroDia = numeroDia;
		this.numerosProhibidosList = numerosProhibidosList;
	}

	public Integer getNumeroDia() {
		return numeroDia;
	}

	public void setNumeroDia(Integer numeroDia) {
		this.numeroDia = numeroDia;
	}

	public List<Integer> getNumerosProhibidosList() {
		return numerosProhibidosList;
	}

	public void setNumerosProhibidosList(List<Integer> numerosProhibidosList) {
		this.numerosProhibidosList = numerosProhibidosList;
	}
	
	
}
