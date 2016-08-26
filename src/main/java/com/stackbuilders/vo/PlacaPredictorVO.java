package com.stackbuilders.vo;

import java.time.LocalTime;

import com.stackbuilders.data.DiaPlacaEnum;
import com.stackbuilders.model.Placa;

public class PlacaPredictorVO {

	private Placa placa;
	private Boolean result;
	private LocalTime currentTime;
	private DiaPlacaEnum diaPlaca;
	private DiaPlacaEnum diaActual;
	private String msg;
	
	public Placa getPlaca() {
		return placa;
	}
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	public LocalTime getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(LocalTime currentTime) {
		this.currentTime = currentTime;
	}
	public DiaPlacaEnum getDiaPlaca() {
		return diaPlaca;
	}
	public void setDiaPlaca(DiaPlacaEnum diaPlaca) {
		this.diaPlaca = diaPlaca;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public DiaPlacaEnum getDiaActual() {
		return diaActual;
	}
	public void setDiaActual(DiaPlacaEnum diaActual) {
		this.diaActual = diaActual;
	}
	
	
	
}
