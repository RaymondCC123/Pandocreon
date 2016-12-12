package capacites;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import cartes.GuideSpirituel;
import gestionPartie.Joueur;
import gestionPartie.Partie;
import gestionPartie.Table;

public class GuideSpirituelRevenir implements Capacites{
	
	Table table;
	Joueur joueur;// the one who can do this "GuideSpirituelRevenir"
	ArrayList<GuideSpirituel> gss;// you can choose one from these GuideSpirituels !
	GuideSpirituel gs;// the one GuideSpirituel you have choosed !

	public void lancerCapacite() {
		HashMap<String,ArrayList<GuideSpirituel>> guidesSpirituelsPoses=table.getGuidesSpirituelsPoses();
		Iterator it = guidesSpirituelsPoses.entrySet().iterator();
	    boolean touve=false;
		while (it.hasNext() && touve==false) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if(pair.getKey()==joueur.getNom()){
	        	ArrayList<GuideSpirituel> gss= (ArrayList<GuideSpirituel>) pair.getValue();
	        	Iterator<GuideSpirituel> it1= gss.iterator();
	        	while(it1.hasNext()){
	        		GuideSpirituel p=it1.next();
	        		System.out.println(p);
	        	}
	        	it1.remove();
	        	Scanner sc = new Scanner(System.in);
	        	System.out.println("\n Choisir une GuideSpirituel! ");
	        	int i = sc.nextInt();
	        	int position=i-1;
	        	gs=gss.get(position);	
	        	touve=true;
	        }
		}
	    it.remove();    
	}
		
		
		
}


