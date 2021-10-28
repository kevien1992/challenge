package it.fuoricitta.model;

import java.time.LocalDate;

import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Named
@Table
@Entity
public class Lista {
	
	@Id
	private int codice;
	private String descrizione;
	private LocalDate scadenza;
	private double valore;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idcsv", referencedColumnName = "id")
	private FileCSV idCSV;

	public FileCSV getIdCSV() {
		return idCSV;
	}

	public void setIdCSV(FileCSV idCSV) {
		this.idCSV = idCSV;
	}

	public Lista() {
		
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = Integer.parseInt(codice);
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getData() {
		return scadenza;
	}

	public void setData(String scadenza) {
		this.scadenza = LocalDate.parse(scadenza);
	}

	public double getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = Double.parseDouble(valore);
	}

	public Lista(String codice, String descrizione, String data, String valore) {
		this.codice = Integer.parseInt(codice);
		this.descrizione = descrizione;
		this.scadenza = LocalDate.parse(data);
		this.valore = Double.parseDouble(valore);
	}
	
	public boolean ControlloNull() {
		if (getCodice() == 0 ||
			getData() == null ||
			getDescrizione() == "" ||
			getValore() == 0) {
			
			System.err.println("Uno o più campi sono void.");
			System.err.println(this);
			return true;
			
		} else {
			return false;
		}
			
	}
	
	@Override
	public String toString() {
		return getCodice() + " " + getDescrizione() + " " + getData() + " " + getValore();

	}

}
