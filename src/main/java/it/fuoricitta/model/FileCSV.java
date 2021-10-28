package it.fuoricitta.model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Named
@Table
@Entity
public class FileCSV {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private long dimensione;
	
	@OneToMany(mappedBy = "idCSV", orphanRemoval = true, cascade = CascadeType.MERGE)
	private List<Lista> lista = new ArrayList<>();
	
	public List<Lista> getLista() {
		return lista;
	}

	public void setLista(List<Lista> lista) {
		this.lista = lista;
	}

	public FileCSV() {
		
	}
	
	public FileCSV(String nome, long dimensione) {
		this.nome = nome;
		this.dimensione = dimensione;	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getDimensione() {
		return dimensione;
	}

	public void setDimensione(long dimensione) {
		this.dimensione = dimensione;
	}
}
