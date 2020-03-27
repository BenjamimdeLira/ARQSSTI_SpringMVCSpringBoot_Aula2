package br.usjt.hellospringboot.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PrevisaoTempo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	private String diaSemana;
	private int tempMax;
	private int tempMin;
	private String descricao;

	public long id() {
		return id;
		}
	public String diaSemana() {
		return diaSemana;
		}
	public int tempMax() {
		return tempMax;
		}
	public int tempMin() {
		return tempMin;
		}
	public String descricao() {
		return descricao;
		}
	
	public void setid(long id) {
		this.id = id;
		}
	public void setdiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
		}
	public void settempMax(int tempMax) {
		this.tempMax = tempMax;
		}
	public void settempMin(int tempMin) {
		this.tempMin = tempMin;
		}
	public void setdescricao(String descricao) {
		this.descricao = descricao;
		}
	public void setTemperaturaMedia(double calculaTemp) {
		// TODO Auto-generated method stub
		
	}
}


