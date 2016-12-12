package pandocreon;


import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;


public class Tour {
	
	private int compteurTour;
	private	Joueur joueurActuel;
	private ConcurrentHashMap<String,Joueur> joueurs;
	Partie partie;
	
	public Tour(Partie partie){
		this.compteurTour=0;
		this.partie = partie;
		this.joueurs = partie.getJoueurs();
		
	}
	
	public int getCompteurTour(){
		return this.compteurTour;
	}
	
	public void setJoueurActuel(Joueur joueur){
		this.joueurActuel=joueur;
		
	}

	public Joueur getJoueurActuel(){
		return this.joueurActuel;
	}
	
	public void debutTour(){
		while(joueurs.size()>1){ 

				compteurTour++;
				System.out.println("=====================================Tour "+compteurTour+"=====================================");
				partie.de.lancer();
				for(Iterator<String>it=joueurs.keySet().iterator();it.hasNext();){
						String key = it.next();
					joueurActuel=joueurs.get(key);
					System.out.println("=====================================Tour du joueur : "+joueurActuel.getNom()+"=====================================");
					
						joueurActuel.jouer();		

					}
				System.out.println("=====================================Fin du tour de jeu " + compteurTour+"=====================================");
				
		}
				

		

		}
	
	
	
}
