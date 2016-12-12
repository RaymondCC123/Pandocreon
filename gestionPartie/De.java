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
			attribuerPoint("Cr�puscule",1);
			break;
			
		case 3:
			System.out.println("Phase N�ant");
			attribuerPoint("Aube",1);
			attribuerPoint("Cr�puscule",1);
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
				}else if(origine.equals("Cr�puscule")){
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
