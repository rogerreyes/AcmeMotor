package co.com.uni5d;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Mod;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import co.com.uni5d.domain.Respuesta;
import co.com.uni5d.domain.funcionPrecio;
import co.com.uni5d.service.AppService;
import co.com.uni5d.service.ModeloService;
import co.com.uni5d.util.Util;
import lombok.extern.log4j.Log4j;

@SpringBootApplication
@Log4j

public class AcmeMotorApplication extends SpringBootServletInitializer implements CommandLineRunner {

	private LocalDate fechaInicial;
	private LocalDate fechafinal;

	private int rango = 9;

	@Autowired
	AppService appService;

	@Autowired
	ModeloService modeloService;



	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AcmeMotorApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AcmeMotorApplication.class, args);

	}

	@Override
	public void run(String... arg0) throws Exception {

		List<funcionPrecio> lista = modeloService.calcularIntervaloTiempo(LocalDate.of(2017, Month.MARCH, 1),
				LocalDate.of(2017, Month.MARCH, 30), 5);

		if (lista != null) {

			for (funcionPrecio fp : lista) {

			log.info(fp);
			}

			modeloService.logica(lista);
			
			for (funcionPrecio fp : lista) {

				log.info(fp);
				}

	}

		// this.fechaInicial = LocalDate.of(2017, Month.FEBRUARY, 10);
		// this.fechafinal = LocalDate.of(2017, Month.FEBRUARY, 12);
		//
		// HttpHeaders headers = new HttpHeaders();
		// headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		// headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		//
		// MultiValueMap<String, String> map = new LinkedMultiValueMap<String,
		// String>();
		// map.add("apiKey", Util.API_KEY);
		// map.add("country", "US");
		// map.add("currency", "USD");
		// map.add("locale", "En-US");
		// map.add("originplace", "BOG-sky");
		// map.add("destinationplace", "JFK-sky");
		// map.add("outbounddate", fechaInicial.toString());
		// map.add("adults", "1");
		// map.add("inbounddate", fechafinal.toString());
		//
		// int x = 1;
		//
		// while (fechaInicial.isBefore(fechafinal)) {
		//
		// map.get("outbounddate").clear();
		// map.get("outbounddate").add(fechaInicial.toString());
		//
		// map.get("inbounddate").clear();
		// map.get("inbounddate").add(fechaInicial.plusDays(rango).toString());
		//
		// System.out.println(
		// "Desde: " + fechaInicial.toString() + " Hasta: " +
		// fechaInicial.plusDays(rango).toString());
		//
		// HttpEntity<Object> entity = new HttpEntity<Object>(map, headers);
		//
		// Respuesta r = null;
		//
		// try {
		//
		// if (x <= 3) {
		// r = appService.consultarVuelos(entity);
		// x = 0;
		// } else if (x == 4) {
		// x = 1;
		// fechaInicial = fechaInicial.plusDays(1);
		// continue;
		// }
		// } catch (Exception e) {
		// x = x + 1;
		// System.out.println(e);
		// continue;
		// }
		//
		// if (r != null) {
		//
		// r.setFechaInicial(
		// Date.from(((LocalDate)
		// fechaInicial).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		// r.setFechaFinal(Date.from(
		// ((LocalDate)
		// fechaInicial.plusDays(rango)).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		// r.setMes(fechaInicial.getMonth().toString());
		//
		// System.out.println(r.getSessionKey());
		// appService.SalvarJson(r);
		// } else {
		// System.out.println("\t***********Respuesta Nula***************");
		// }
		// fechaInicial = fechaInicial.plusDays(1);
	}

	

	/*
	 * 
	 * private void init() {
	 * 
	 * this.fechaInicial = LocalDate.of(2017, Month.FEBRUARY, 1);
	 * this.fechafinal = LocalDate.of(2017, Month.JULY, 30);
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	 * headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	 * 
	 * MultiValueMap<String, String> map = new LinkedMultiValueMap<String,
	 * String>(); map.add("apiKey", Util.API_KEY); map.add("country", "CO");
	 * map.add("currency", "COP"); map.add("locale", "ES-es");
	 * map.add("originplace", "BOG-sky"); map.add("destinationplace",
	 * "CTG-sky"); map.add("outbounddate", fechaInicial.toString());
	 * map.add("adults", "1"); map.add("inbounddate", fechafinal.toString());
	 * 
	 * 
	 * 
	 * while (fechaInicial.isBefore(fechafinal)) {
	 * 
	 * map.get("outbounddate").clear();
	 * map.get("outbounddate").add(fechaInicial.toString());
	 * 
	 * map.get("inbounddate").clear();
	 * map.get("inbounddate").add(fechaInicial.plusDays(rango).toString());
	 * 
	 * System.out.println("Desde: "+fechaInicial.toString()+"  Hasta: "
	 * +fechaInicial.plusDays(rango).toString());
	 * 
	 * 
	 * HttpEntity<Object> entity = new HttpEntity<Object>(map, headers);
	 * 
	 * 
	 * Respuesta r = appService.consultarVuelos(entity); if(r!=null){
	 * 
	 * 
	 * r.setFechaInicial(Date.from(((LocalDate)
	 * fechaInicial).atStartOfDay(ZoneId.systemDefault()).toInstant()));
	 * r.setFechaFinal(Date.from(((LocalDate)
	 * fechaInicial.plusDays(rango)).atStartOfDay(ZoneId.systemDefault()).
	 * toInstant())); r.setMes(fechaInicial.getMonth().toString());
	 * 
	 * System.out.println(r.getSessionKey()); appService.SalvarJson(r); }else{
	 * System.out.println("\t***********Respuesta Nula***************"); }
	 * fechaInicial = fechaInicial.plusDays(1); }}
	 */

}
