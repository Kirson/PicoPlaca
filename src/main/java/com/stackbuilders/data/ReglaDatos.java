package com.stackbuilders.data;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.stackbuilders.model.FranjaHoraria;
import com.stackbuilders.model.ReglaPico;

@Service
@PropertySource("picoplaca.properties")
public class ReglaDatos {
	
	@Autowired
	protected static PropertySourcesPlaceholderConfigurer propertyConfigurer;
	/*
	private static @Value("${hora.am.inicio}") String horaAmInicio;
	private static @Value("${hora.am.fin}") String horaAmFin;
	private static @Value("${hora.pm.inicio}") String horaPmInicio;
	private static @Value("${hora.pm.fin}") String horaPmFin;
	*/
	private static String horaAmInicio = "07:00";
	private static String horaAmFin = "09:30";
	private static String horaPmInicio = "16:00";
	private static String horaPmFin= "19:30";

	
	private static DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
	private static LocalTime am_inicio = LocalTime.parse(horaAmInicio, formatterTime);
	private static LocalTime am_fin = LocalTime.parse(horaAmFin, formatterTime);
	private static LocalTime pm_inicio = LocalTime.parse(horaPmInicio, formatterTime);
	private static LocalTime pm_fin = LocalTime.parse(horaPmFin, formatterTime);
	private static FranjaHoraria franjaAm = new FranjaHoraria(am_inicio,am_fin);
	private static FranjaHoraria franjaPm = new FranjaHoraria(pm_inicio,pm_fin);

	public static List<ReglaPico> listaReglas = new ArrayList<ReglaPico>();
	
	private static void inicializar(){
		listaReglas.add(new ReglaPico(franjaAm,franjaPm,DiaPlacaEnum.LUNES));
		listaReglas.add(new ReglaPico(franjaAm,franjaPm,DiaPlacaEnum.MARTES));
		listaReglas.add(new ReglaPico(franjaAm,franjaPm,DiaPlacaEnum.MIERCOLES));
		listaReglas.add(new ReglaPico(franjaAm,franjaPm,DiaPlacaEnum.JUEVES));
		listaReglas.add(new ReglaPico(franjaAm,franjaPm,DiaPlacaEnum.VIERNES));
	}
	
	public static List<ReglaPico> getListaReglas(){
		
		if(listaReglas.isEmpty()){
			inicializar();
		}
		
		return listaReglas;
	}
	
}
