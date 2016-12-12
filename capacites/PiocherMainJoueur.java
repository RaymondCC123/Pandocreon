package capacites;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import gestionPartie.Joueur;
import gestionPartie.Partie;
import capacites.Capacites;
import cartes.Carte;
import cartes.GuideSpirituel;

public class PiocherMainJoueur implements Capacites{
	
	public void lancerCapacite(Partie partie, int nbPiocher, Joueur joueur1) {//joueur1 c'est qui fait l'action
		// HashMap<String,Joueur> joueurs=partie.getJoueurs();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nom de joueur dont tu veux piocher：");
		String nom_joueurHasard = sc.nextLine();
		
		HashMap<String,Joueur> allJoueur=partie.getJoueurs(); //get information of all the joueurs
		
		Iterator<Entry<String, Joueur>> it0 = allJoueur.entrySet().iterator();
		Joueur joueurChoisi=null;//the joueur we choose
		boolean touve=false;// pour savoir si on l'a trouvé 
	    
		while (it0.hasNext() && touve==false) {// parcour  "allJoueur" pour trouver le joueur correspondant
	        Map.Entry<String, Joueur> pair = (Map.Entry<String, Joueur>)it0.next();
	        if(pair.getKey()==nom_joueurHasard){
	        	joueurChoisi=pair.getValue();// we get the joueur we want !
	        	touve=true;
	        }
		}
		it0.remove();
	

		joueurChoisi.getMain();// we begin to piocher une carte from his hand !
		int nbCartesPiochees=0;// number of cartes on a déjà piochées	
		while(nbCartesPiochees<=nbPiocher){
			int random=(int) Math.round((Math.random() * (joueurChoisi.getMain().size()-1)));
			Carte cartePiochee = joueurChoisi.getMain().get(random);
			joueur1.getMain().add(cartePiochee);
			joueurChoisi.getMain().remove(random);
			nbCartesPiochees++;
		}
	}

	@Override
	public void lancerCapacite() {}

}

	
