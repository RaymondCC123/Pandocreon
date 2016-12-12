package exceptions;

import pandocreon.*;

public class InvalidPANumberException extends Exception{
	
	public InvalidPANumberException(Joueur joueur){
		System.out.println("Pas assez de points d'action pour jouer cette carte");
		
	}
}
