package strategy;

import java.util.NoSuchElementException;

import pandocreon.*;
import Cartes.*;

public class StrategieJoueurVirtuelFacile implements Strategy{
	
	Partie partie;
	
	public StrategieJoueurVirtuelFacile(Partie partie){
		this.partie = partie;
	}
	

	
	public void jouer(Joueur joueur){
		try{
			
			
			if(joueur.getNbCartes()<2){
				System.out.println(joueur.getNom()+ "a choisi de piocher");
				while(joueur.getMain().size()<8){
					Carte carte =partie.paquetCarteAction.piocher();
					joueur.addMain(carte);
				}
			}  else {
				int random = (int)(Math.random() * (joueur.getNbCartes()));
				Carte carte = joueur.getMain().get(random);
				carte.jouerCarte(joueur);
				carte = joueur.removeMain(random);
			}
		}catch(NoSuchElementException paquet){
			System.out.println("Le paquet est vide, impossible de piocher");
			try{
				partie.quitterPartie(joueur);
			}catch(Exception e){
				
			}		
		}catch(Exception e){
			System.out.println(joueur.getNom()+" passe sont tour");
		}

	}
	


}
