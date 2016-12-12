package pandocreon;


import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import Cartes.*;


public class De {

	private Random nombreAleatoire;
	private int resultat ;
	private Partie partie;
	
	public De(Partie partie){
		this.partie=partie;
	}
	

	public void lancer(){
		
		nombreAleatoire= new Random();
		resultat = nombreAleatoire.nextInt(3) + 1;
		
		switch(resultat){
		
		case 1:
			System.out.println("Phase Jour");
			attribuerPoint("Jour",2);
			attribuerPoint("Aube",1);
			break;
			
		case 2:
			System.out.println("Phase Nuit");
			attribuerPoint("Nuit",2);
			attribuerPoint("Crépuscule",1);
			break;
			
		case 3:
			System.out.println("Phase Néant");
			attribuerPoint("Aube",1);
			attribuerPoint("Crépuscule",1);
			break;
		}
	}
	
	private void attribuerPoint(String origine,int nbPoints){
		
		ConcurrentHashMap<String,Joueur> joueurs = partie.getJoueurs();
		
		for(Iterator<String>it=joueurs.keySet().iterator();it.hasNext();){
			String key = it.next();
			Joueur joueur=joueurs.get(key);
			Carte diviniteJoueur = joueur.getMain().get(0);
			if(diviniteJoueur.getOrigine().equals(origine)){
				if(origine.equals("Aube")){
					joueur.setNbPointsAction("Jour", nbPoints);
					System.out.println(joueur.getNom()+" obtient "+nbPoints+" points d'action d'origine Jour");					
				}else if(origine.equals("Crépuscule")){
					joueur.setNbPointsAction("Nuit", nbPoints);
					System.out.println(joueur.getNom()+" obtient "+nbPoints+" points d'action d'origine Nuit");					
				}else{
					joueur.setNbPointsAction(origine, nbPoints);
					System.out.println(joueur.getNom()+" obtient "+nbPoints+" points d'action d'origine "+origine);
				}
			}
			
		}
		
	}
		
}
