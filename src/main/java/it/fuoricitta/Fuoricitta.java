package it.fuoricitta;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.inject.Named;

import it.fuoricitta.model.FileCSV;
import it.fuoricitta.model.Lista;

@Named
public class Fuoricitta {
	
	private SessionFactory factory;
	
	public Fuoricitta() {
		
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(FileCSV.class)
				.addAnnotatedClass(Lista.class)
				.buildSessionFactory();
	}
	
	public void insert(Lista lista, FileCSV csv) {
		
		
		try(Session session = factory.getCurrentSession()){
			FileCSV fileCSV = csv;
			Lista riga = lista;
			
			session.beginTransaction();
			session.saveOrUpdate(fileCSV);
			session.saveOrUpdate(riga);
			session.getTransaction().commit();
		} 
		
	}
	

}
