package com.atm.locator.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atm.locator.pojo.AtmLocator;
import com.atm.locator.service.IAtmLocatorService;

@RestController
@RequestMapping("/atm-locator")
public class AtmLocatorRestController {
	
	@Autowired
	private IAtmLocatorService service;
	
	@GetMapping("/location")
	public List<AtmLocator> getAtmLocation(){
		return service.getAtmLocation();
	}

}
