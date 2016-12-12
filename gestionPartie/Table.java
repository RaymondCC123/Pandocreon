package pandocreon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import Cartes.*;

public class Table {
	
	private Partie partie;
	private HashMap<Joueur,ArrayList<GuideSpirituel>> guidesSpirituelsPoses;
	private ConcurrentHashMap<String,Joueur> joueurs;
	
	public Table(Partie partie){
		this.partie =partie;
		this.joueurs = partie.getJoueurs();
		guidesSpirituelsPoses = new HashMap<Joueur,ArrayList<GuideSpirituel>>();
		for(Iterator<String>it=joueurs.keySet().iterator();it.hasNext();){
			String key = it.next();
			Joueur joueur =joueurs.get(key);
			guidesSpirituelsPoses.put(joueur,new ArrayList<GuideSpirituel>());
		}
	}
	
	public void poserGuideSpirituel(Joueur joueur,GuideSpirituel guideSpirituel){
		System.out.println("Le guide spirituel "+guideSpirituel.getNom()+" a été posé");
		guidesSpirituelsPoses.get(joueur).add(guideSpirituel);
	}
	
	public GuideSpirituel getGuideSpirituel(Joueur joueur,int position){
		return guidesSpirituelsPoses.get(joueur).get(position-1);
	}
	

	public void voirGuidesSpirituelsJoueur(Joueur joueur){
		System.out.println("Les guides spirituels posés par "+joueur.getNom()+" sont les suivants :");
		if(guidesSpirituelsPoses.get(joueur).size()!=0){
			int i=1;
			for (Iterator it = guidesSpirituelsPoses.get(joueur).iterator();it.hasNext();){
				GuideSpirituel guideSpirituel =(GuideSpirituel)it.next();
				System.out.println("\t"+i+"-"+guideSpirituel.toString());
				System.out.println("\tCroyant attachés :");
				if(guideSpirituel.getCroyantsAttaches().size()!=0){
					for (Iterator it2 = guideSpirituel.getCroyantsAttaches().iterator();it2.hasNext();){
						Croyant croyant =(Croyant)it2.next();
						System.out.println("\t\t"+i+"-"+croyant.toString());
					}
				}else{
					System.out.println("\t\tAucun");
				}
				i++;
			}
		}else{
			System.out.println("\tAucun");
		}
	}
	
	public void voirGuidesSpirituelsPoses(){
		for(Iterator<Joueur>it=guidesSpirituelsPoses.keySet().iterator();it.hasNext();){
			Joueur key = it.next();
			this.voirGuidesSpirituelsJoueur(key);
			//Joueur joueur=guidesSpirituelsPoses.get(key);
		}
			
	}
	

}
