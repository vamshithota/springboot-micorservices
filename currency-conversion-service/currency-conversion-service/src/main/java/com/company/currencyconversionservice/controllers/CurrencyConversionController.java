package com.company.currencyconversionservice.controllers;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.company.currencyconversionservice.CurrencyExchangeProxy;
import com.company.currencyconversionservice.pojo.CurrencyConversion;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		// create map for uri varaiables
		HashMap<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
     ResponseEntity<CurrencyConversion> response = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class,uriVariables);
	 CurrencyConversion conversion =  response.getBody();
	 return new CurrencyConversion(conversion.getId(),from,to,
			 quantity,conversion.getConversionMultiple(),
			 quantity.multiply(conversion.getConversionMultiple()),
			 conversion.getEnvironment()+" "+ "rest template");
	}
	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {

		CurrencyConversion conversion = proxy.getExchangeValue(from, to);
		 return new CurrencyConversion(conversion.getId(),from,to,
				 quantity,conversion.getConversionMultiple(),
				 quantity.multiply(conversion.getConversionMultiple()),
				 conversion.getEnvironment()+" "+ "Feign Client");
			
	}
}
