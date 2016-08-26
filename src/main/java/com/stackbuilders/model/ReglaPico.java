package com.stackbuilders.model;

import java.io.Serializable;

import com.stackbuilders.data.DiaPlacaEnum;

public class ReglaPico implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4550413635794979145L;
	private FranjaHoraria franjaAM;
	private FranjaHoraria franjaPM;
	private DiaPlacaEnum diaPlaca;
	
	public ReglaPico(FranjaHoraria franjaAm, FranjaHoraria franjaPm, DiaPlacaEnum diaPlaca){
		this.franjaAM = franjaAm;
		this.franjaPM = franjaPm;
		this.diaPlaca = diaPlaca;
	}
	
	public FranjaHoraria getFranjaAM() {
		return franjaAM;
	}
	public void setFranjaAM(FranjaHoraria franjaAM) {
		this.franjaAM = franjaAM;
	}
	public FranjaHoraria getFranjaPM() {
		return franjaPM;
	}
	public void setFranjaPM(FranjaHoraria franjaPM) {
		this.franjaPM = franjaPM;
	}

	public DiaPlacaEnum getDiaPlaca() {
		return diaPlaca;
	}

	public void setDiaPlaca(DiaPlacaEnum diaPlaca) {
		this.diaPlaca = diaPlaca;
	}
	
	
	
}
