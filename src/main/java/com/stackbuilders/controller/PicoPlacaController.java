package com.stackbuilders.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackbuilders.model.Placa;
import com.stackbuilders.service.PicoPlacaService;
import com.stackbuilders.vo.PlacaPredictorVO;



@RestController
@RequestMapping(value = "/picoPlaca")
public class PicoPlacaController {
	
	@Autowired
	PicoPlacaService service;

	@RequestMapping(value = "/validarPlaca{placaNumero}", method = RequestMethod.GET)
	public  ResponseEntity<PlacaPredictorVO> validarPlaca(@PathVariable("placaNumero")String placaNumero){
		    
			Placa placa = new Placa(placaNumero);
		
			PlacaPredictorVO result = service.puedeCircular(placa);
			
	    	return new ResponseEntity<PlacaPredictorVO>(result,HttpStatus.OK);
	    
	}
}
