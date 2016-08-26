package com.stackbuilders.model;

import java.io.Serializable;
import java.time.LocalTime;

public class FranjaHoraria implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -8482095470260120960L;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	
	public FranjaHoraria(LocalTime inicio, LocalTime fin){
		this.horaInicio = inicio;
		this.horaFin = fin;
	}
	
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalTime getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}
	
	
}
