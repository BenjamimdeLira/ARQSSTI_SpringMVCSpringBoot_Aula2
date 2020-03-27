package br.usjt.hellospringboot.model;

public class Temperatura {
	public double calculaTemp(double... temperaturas) {
		double m = 0;
		for (Double d : temperaturas) {
			m += d;
		}
		return m / temperaturas.length;
	}
}
