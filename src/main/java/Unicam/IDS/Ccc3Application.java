package Unicam.IDS;

import Unicam.IDS.DB.DBManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ccc3Application {

	public static void main(String[] args) {
		SpringApplication.run(Ccc3Application.class, args);
		DBConnection dbConnection = DBConnection.getInstance();
		dbConnection.setDBConnection("jdbc:mysql://localhost:3306/phpMyAdmin", "root","");
		dbConnection.DBtest();
		DBManager dbManager = DBManager.getInstance();
		Catalogo c = new Catalogo();
		OrdersManager om = new OrdersManager();

		// INTERFACCIA GRAFICA
		// CARICO IL CATALOGO?
		// CARICO TUTTI GLI ORDINI
		// CHI CARICA I NEGOZI, I CLIENTI, I CORRIERI E LE ALTRE INFO CHE SONO SUL DATABASE?
	}

}
