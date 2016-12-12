package exceptions;

import pandocreon.Joueur;

public class ExitingGameException extends Exception {

	public ExitingGameException(Joueur joueur){
		System.out.println(joueur.getNom()+ " quitte la partie");
	}
}
