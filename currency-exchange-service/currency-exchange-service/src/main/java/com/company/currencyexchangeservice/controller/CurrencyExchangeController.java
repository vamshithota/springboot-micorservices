package com.company.currencyexchangeservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.company.currencyexchangeservice.pojo.CurrencyExchange;
import com.company.currencyexchangeservice.repositories.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	
	@Autowired
	CurrencyExchangeRepository currencyExchangeRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getExchangeValue(@PathVariable String from , @PathVariable String to) {
		
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from,to);
		if(currencyExchange== null) {
			throw new RuntimeException("Unable to find data for " + from + " to " + to);
		}
		String portNumber = env.getProperty("local.server.port");
		currencyExchange.setEnvironment(portNumber);
		return currencyExchange;
	}
	
}
