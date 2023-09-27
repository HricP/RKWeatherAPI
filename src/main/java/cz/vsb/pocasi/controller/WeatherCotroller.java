package cz.vsb.pocasi.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.vsb.pocasi.City;
import cz.vsb.pocasi.connector.WeatherstackConnector;
import cz.vsb.pocasi.dto.WeatherDto;
import cz.vsb.pocasi.service.WeatherService;
import java.util.ArrayList;

import cz.vsb.pocasi.City;

@RestController
public class WeatherCotroller {
	@RequestMapping("/weather")
	public Collection<WeatherDto> getWeather() {
		//myAdditions
		
		ArrayList<WeatherDto> wdtoList = new ArrayList<WeatherDto>();
		WeatherService service=new WeatherService();
		for (City city: City.values()){
			WeatherDto weatherDto = service.getWeatherForCity(city);
			wdtoList.add(weatherDto);
		}
		//myAdditions - End
		return wdtoList;
	}
	@RequestMapping("weather/{city}")
	@CrossOrigin
	public WeatherDto getWeatherForCity(@PathVariable String city) {
		City cityEnum = City.valueOf(city.toUpperCase());
		/*
		WeatherstackConnector connector = new WeatherstackConnector();
		WeatherDto wdto =new WeatherDto();
		String cty = connector.getWeatherForCity(cityEnum);
		wdto.setLocation(cty);
		return wdto;
		*/
		WeatherService weatherService = new WeatherService();
		return weatherService.getWeatherForCity(cityEnum);
				
	}
	
	@RequestMapping("/weather/bruntal")
	public String getWeatherForCity() {
		return "<h1>Bruntál nenalezen</h1> <img src='http://www.zubatezaby.cz/files/IMG_24.jpg'";
	}
	@RequestMapping("/")
	public String home() {
		return "<h1> Home Sweet Home</h1>";
	}
	
}
