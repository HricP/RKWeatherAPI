
package cz.vsb.pocasi.service;

import org.springframework.stereotype.Service;
import cz.vsb.pocasi.dto.WeatherDto;
import cz.vsb.pocasi.dto.WeatherstackDto;
import cz.vsb.pocasi.connector.WeatherstackConnector;

import cz.vsb.pocasi.City;

@Service
public class WeatherService {
	public WeatherDto getWeatherForCity(City cityEnum) {
		WeatherstackConnector connector = new WeatherstackConnector();		
		WeatherstackDto weatherstackData= connector.getWeatherForCity(cityEnum);		
		return transformDto(weatherstackData);		
	}
	
	private WeatherDto transformDto(WeatherstackDto weatherstackData) {
		WeatherDto wdto = new WeatherDto();
		wdto.setLocation(weatherstackData.getLocation().getName());
		wdto.setRel_humidity(weatherstackData.getCurrent().getHumidity());
		//mojeDodělávky
		wdto.setTemp_celsius(weatherstackData.getCurrent().getTemperature());
		wdto.setTimestamp(weatherstackData.getCurrent().getObservation_time());
		wdto.setWeatherDescription(weatherstackData.getCurrent().getWeather_descriptions().toString());
		wdto.setWindDirection(weatherstackData.getCurrent().getWind_dir());
		wdto.setWindSpeed_mps(weatherstackData.getCurrent().getWind_speed()/3.6 );
		//mojeDodělávky - End
		return wdto;
	}
}

