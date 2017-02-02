package co.com.uni5d.service;

import java.net.URI;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import co.com.uni5d.anotaciones.AcmeService;
import co.com.uni5d.dao.AppDao;
import co.com.uni5d.domain.Respuesta;
import co.com.uni5d.util.Util;

@AcmeService
public class AppService {

	@Autowired
	@Qualifier("mirest")
	RestOperations restTemplate;
	@Autowired
	AppDao appDao;

	
	
	public Respuesta consultarVuelos (HttpEntity<Object> entity){
		
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		URI url = restTemplate.postForLocation(Util.URL_BASE_LIVE_PRICES, entity);
		
		try {
		    Thread.sleep(5000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		Respuesta respuesta = restTemplate.getForObject(url.toString() + "?apiKey=" + Util.API_KEY, Respuesta.class);
		
		return respuesta;
	}
	
	
	
	
//	public Future<Respuesta> consultarVuelos(HttpEntity<Object> entity) {
//		
//		URI url = restTemplate.postForLocation(Util.URL_BASE_LIVE_PRICES, entity);
//		Respuesta respuesta = restTemplate.getForObject(url.toString() + "?apiKey=" + Util.API_KEY, Respuesta.class);
//	
//		return new AsyncResult<Respuesta>(respuesta);
//	}
//	
//	public synchronized Future<Respuesta> consultarVuelos(HttpEntity<Object> entity) {
//		URI url = restTemplate.postForLocation(Util.URL_BASE_LIVE_PRICES, entity);
//		Respuesta respuesta = restTemplate.getForObject(url.toString() + "?apiKey=" + Util.API_KEY, Respuesta.class);
//		return new AsyncResult<Respuesta>(respuesta);
//	}
	
	
	public void SalvarJson(Respuesta respuesta){
		
		appDao.salvarJson(respuesta);
		
	}
	
}
