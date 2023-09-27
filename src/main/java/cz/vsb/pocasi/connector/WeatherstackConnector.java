package cz.vsb.pocasi.connector;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cz.vsb.pocasi.City;

import java.net.URI;
import java.net.URISyntaxException;

import cz.vsb.pocasi.dto.WeatherstackDto;


public class WeatherstackConnector {
	//http://api.weatherstack.com/current?access_key=594a0a7c245d79678b060a998e1ff19a&query=New%20York
	
	private static String baseURL ="http://api.weatherstack.com/";
	private static String params = "current?access_key=";
	private static String ApiKey ="594a0a7c245d79678b060a998e1ff19a";
	private static String url = baseURL+params+ApiKey+"&query=";
	
	public WeatherstackDto getWeatherForCity(City cityEnum) {
		RestTemplate template =new RestTemplate();
		URI uri = null;
		try {
			uri = new URI(url+cityEnum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//template.getForEntity(uri);
		
		ResponseEntity<WeatherstackDto>response=template.getForEntity(uri,WeatherstackDto.class);
		return response.getBody();		
	}

	
}
