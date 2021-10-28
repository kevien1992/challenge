package it.fuoricitta;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import it.fuoricitta.model.Lista;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Inserisci il path del file CSV da leggere:");
    	Scanner in = new Scanner(System.in);
    	String path = in.nextLine();
    	in.close();
    	
        try {
			List<Lista> lista = new ReaderCSV().reader(path);
			
			for (Lista l : lista) {
				if(!l.ControlloNull()) {
				System.out.println(l);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
    }
}
