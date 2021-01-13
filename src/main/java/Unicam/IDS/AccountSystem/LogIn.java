package Unicam.IDS.AccountSystem;

import Unicam.IDS.DB.DBManagerRead;

import java.util.Base64;


public class LogIn {

	
	
	public static boolean autentication(String email, String password){		
		if ((Base64.getEncoder().encodeToString(password.getBytes()).matches(DBManagerRead.getPassword(email)))){
			return true;
		}
		else return false;
		
	}

		
}
