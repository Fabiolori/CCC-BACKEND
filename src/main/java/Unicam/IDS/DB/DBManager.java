package Unicam.IDS.DB;


//TODO Dividere in 2 la classe tra import ed export, maybe fare una classe che si occupa solo della connessione per non ripetere codice e accorciare

import Unicam.IDS.DBConnection;

public interface  DBManager {
	public static  DBManagerRead getInstance() {
		return null;
	}
	//TODO CREDO SIA UNA PORCHETTA ASSEGNARE COSI
	public static DBConnection connector = DBConnection.getInstance();



	
}

	
