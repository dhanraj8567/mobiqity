package com.atm.locator.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.atm.locator.pojo.AtmLocator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

@Service
public class AtmLocatorServiceImpl implements IAtmLocatorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AtmLocatorServiceImpl.class);

	@Value("${atm.locator.url}")
	private String atmLocatorURL;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<AtmLocator> getAtmLocation() {
		List<AtmLocator> atmLocationList = null;
		try {
			ResponseEntity<String> response = restTemplate.getForEntity(atmLocatorURL, String.class);
			String strResponse = response.getBody().toString().split("\n")[1];
			LOGGER.info("Response string : " + strResponse);
			ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			TypeFactory typeFactory = objectMapper.getTypeFactory();
			CollectionType collectionType = typeFactory.constructCollectionType(List.class, AtmLocator.class);

			atmLocationList = objectMapper.readValue(strResponse, collectionType);

		} catch (HttpClientErrorException e) {
			LOGGER.info("Exeption occured while connecting to:" + atmLocatorURL+" with error msg:"+e.getMessage());
		} catch (HttpServerErrorException e) {
			LOGGER.info("Exeption occured while connecting to:" + atmLocatorURL+" with error msg:"+e.getMessage());
		} catch (Exception e) {
			LOGGER.info("Exeption occured while connecting to:" + atmLocatorURL+" with error msg:"+e.getMessage());
		}
		return atmLocationList;
	}

}
