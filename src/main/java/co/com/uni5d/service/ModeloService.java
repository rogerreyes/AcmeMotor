package co.com.uni5d.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



import co.com.uni5d.anotaciones.AcmeService;
import co.com.uni5d.domain.funcionPrecio;
import lombok.extern.log4j.Log4j;

@AcmeService
@Log4j
public class ModeloService {

	
	
	private static double TAU = 0.381966;
	private static double E = 1;
	private static double ITER = 15;
	private double K = 0;

	private double nuevoA;
	private double nuevoB;

	private double calculoA;
	private double calculoB;

	private double fA;
	private double fB;
	private ArrayList<funcionPrecio> listaI;
	private int fAaux;
	private int fBAaux;
	private String Sr;
	private String S;

	
	public List<funcionPrecio> calcularIntervaloTiempo(LocalDate fechaInicial, LocalDate fechafinal, int rango) {

		
		if (fechafinal.isBefore(LocalDate.now()) || fechafinal.equals(LocalDate.now())) {
			return null;
		}

		if (fechaInicial.isAfter(fechafinal)) {

			log.error("Escriba bien");
			return null;
		}

		if (fechaInicial.isBefore(LocalDate.now())) {

			fechaInicial = LocalDate.now().plusDays(1);
		}

		List<funcionPrecio> lista = new ArrayList<funcionPrecio>();

		while (fechaInicial.isBefore(fechafinal)) {

			// log.info("fechaInicial");
			lista.add(new funcionPrecio(fechaInicial, fechaInicial.plusDays(rango), 0));

			fechaInicial = fechaInicial.plusDays(1);

		}

		return lista;
	}
	
	
	public void logica(List<funcionPrecio> lista) {

		nuevoA = 1;
		nuevoB = lista.size();
		log.info("---------------------" + nuevoB);

		// calculoA = Math.round(nuevoA +(TAU*(nuevoB-nuevoA)));
		// calculoB =Math.round(nuevoA +((1-TAU)*(nuevoB-nuevoA)));

		int k = 0;
		do {

			// Sr = String.valueOf(nuevoA +(TAU*(nuevoB-nuevoA)));
			// Sr= Sr.substring(0 ,Sr.indexOf("."));
			// calculoA = Integer.parseInt(Sr);

			calculoA = nuevoA + (TAU * (nuevoB - nuevoA));

			calculoB = nuevoA + ((1 - TAU) * (nuevoB - nuevoA));

			fAaux = (int) (calculoA - 1);
			// fA = lista.get(fAaux).getPrecio();
			fA = consultarPrecio(lista.get(fAaux));

			fBAaux = (int) (calculoB - 1);
			fB = consultarPrecio(lista.get(fBAaux));

			if (!(fA <= fB)) {
				nuevoA = (int) calculoA;

			} else {
				nuevoB = (int) calculoB;

			}

			log.info(fA + " , " + fB + " , " + calculoA + " , " + calculoB + " , " + nuevoA + " , " + nuevoB);

		} while ((Math.abs(calculoB - calculoA) > 0.5));

		if (fA < fB) {
			log.info("Optimo :" + fA);
		} else {
			log.info("Optimo :" + fB);
		}

	}

	private double consultarPrecio(funcionPrecio fp) {
		
		if(fp.getPrecio()==0){
		fp.setPrecio(new Random().nextDouble() * 100);
		}
		return fp.getPrecio();

	}

}
