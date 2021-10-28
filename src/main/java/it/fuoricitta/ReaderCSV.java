package it.fuoricitta;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

import it.fuoricitta.model.FileCSV;
import it.fuoricitta.model.Lista;

public class ReaderCSV {
	
	private Fuoricitta fuoricitta = new Fuoricitta();
	
	public List<Lista> reader(String path) throws IOException{
		List<Lista> list = new ArrayList<>();
		try (Reader reader = Files.newBufferedReader(Paths.get(path))){
			try (CSVParser csvParser = new CSVParser(
					reader, CSVFormat.DEFAULT.withFirstRecordAsHeader()
											 .withIgnoreHeaderCase()
											 .withDelimiter(';'))){
				
				FileCSV csv = new FileCSV(new File(path).getPath(), new File(path).length());
				for(CSVRecord record : csvParser) {
					Lista riga = new Lista(
							record.get("CODICE"),
							record.get("DESCRIZIONE"),
							record.get("SCADENZA"),
							record.get("VALORE")
						);
					riga.setIdCSV(csv);
					list.add(riga);
					fuoricitta.insert(riga, csv);
				}
			}
		}
		return list;
	}
}
