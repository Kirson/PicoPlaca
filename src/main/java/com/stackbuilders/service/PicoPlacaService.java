package com.stackbuilders.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stackbuilders.data.DiaPlacaEnum;
import com.stackbuilders.data.ReglaDatos;
import com.stackbuilders.model.Placa;
import com.stackbuilders.model.ReglaPico;
import com.stackbuilders.vo.PlacaDiaVO;
import com.stackbuilders.vo.PlacaPredictorVO;

@Service
public class PicoPlacaService {

	public PlacaPredictorVO puedeCircular(Placa placa){
		PlacaPredictorVO ppVO = new PlacaPredictorVO();
		Boolean circula = Boolean.TRUE;
		ppVO.setCurrentTime(getCurrentHour());
		ppVO.setPlaca(placa);
		List<ReglaPico> reglas = ReglaDatos.getListaReglas();
		int dia = getCurrentDayOfWeek();
		ppVO.setDiaActual(getCurrentDia(dia));
		PlacaDiaVO placaDia = placaYDia(placa,dia);
		ppVO.setDiaPlaca(placaDia.getDiaPlaca());
		
		for(ReglaPico rp:reglas){
			//Si esta dentro de las horas
			if(placaDia.getMismoDia())
			{  
				//System.out.println("Esta en el dia");
				circula=validateHour(rp,ppVO.getCurrentTime());
				
				if(circula){
					ppVO.setMsg("Esta en el dia y fuera de horario. Puede circular");
				}else{
					ppVO.setMsg("Esta en el dia y dentro de horario. No Puede circular");
				}
				break;
			}
			else{
				//ppVO.setDiaPlaca(rp.getDiaPlaca());
				ppVO.setMsg("No esta en el dia, ni horario. Puede circular");
			}
		}
		
		ppVO.setResult(circula);
		
		return ppVO;
	}
	
	private Integer getLastNumber(Placa placa){
		try {
            int val = Integer.parseInt(placa.getNumero().substring(placa.getNumero().length() - 1));
            return val;
        } catch (NumberFormatException ex) {
            System.out.printf("%s Informacion incorrecta %n", placa.getNumero());
            throw ex;
        }
	}
	
	 private LocalTime getCurrentHour(){
		 	int hour   = LocalDateTime.now().getHour();
		 	int minute = LocalDateTime.now().getMinute();
		 	String shour = ""+hour;
		 	String sminute = ""+minute;
		 	if(hour<10){
		 		shour="0"+hour;
		 	}
		 	if(minute<10){
		 		sminute="0"+minute;
		 	}
		 	String hourMinute = shour+":"+sminute;
            
		 try {
	        	DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
	            return LocalTime.parse(hourMinute, formatterTime);
	        } catch (DateTimeParseException ex) {
	            System.out.printf("%s Informacion incorrecta %n", hourMinute);
	            throw ex;
	        }
	   }
	 
	 private int getCurrentDayOfWeek(){
	        try {
	        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	        	String reportDate = df.format(new Date());
	            LocalDate fecha = LocalDate.parse(reportDate, formatter);
	            return fecha.getDayOfWeek().getValue();
	        } catch (DateTimeParseException ex) {
	            	System.out.printf("%s Informacion incorrecta%n");
	            	throw ex;
	        }
	}
	 /**
	  * Validar la hora con la regla
	  * La hora debe estar dentro de los parametros de inicio, fin
	  * @param reglaPico
	  * @param currentHour
	  * @return
	  */
	 private Boolean validateHour(ReglaPico reglaPico,LocalTime currentHour){
		 Boolean valHour = Boolean.FALSE;
		
		 valHour = (currentHour.isBefore(reglaPico.getFranjaAM().getHoraInicio()) ||  currentHour.isAfter(reglaPico.getFranjaAM().getHoraFin())) &&  
				   (currentHour.isBefore(reglaPico.getFranjaPM().getHoraInicio()) ||  currentHour.isAfter(reglaPico.getFranjaPM().getHoraFin()));
		 return valHour;
	 }
	 
	 /**
	  * Valida si esa placa esta restringida ese dia
	  * @param placa
	  * @param dia
	  * @return
	  */
	 private PlacaDiaVO placaYDia(Placa placa, int dia){
		 PlacaDiaVO result = new PlacaDiaVO();
		 Boolean val = Boolean.FALSE;
		 System.out.println("==>> "+dia);
		 int lastNumber = getLastNumber(placa);
		 for(DiaPlacaEnum dp:DiaPlacaEnum.values()){
			 val = dp.getNumerosProhibidosList().contains(lastNumber);
			 System.out.println("==>>val>> "+val+ " " +dp);
			 if(val){
				 result.setDiaPlaca(dp);
				 System.out.println("==>>dp>> "  +dp);
			 }
			 if(dia==dp.getNumeroDia()){
				 result.setMismoDia(val);
				 break;
			 }else{
				 continue;
			 }
			
		 }
		 
		 result.setMismoDia(val);
		 return result;
	 }
	 
	 private DiaPlacaEnum getCurrentDia(int dia){
		 DiaPlacaEnum val=null;
		 for(DiaPlacaEnum dp:DiaPlacaEnum.values()){
			 if(dia==dp.getNumeroDia()){
				 val=dp;
				 break;
			 }
			
		 }
		 return val;
	 }
}
