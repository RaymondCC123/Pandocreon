package capacites;

import gestionPartie.Joueur;
import capacites.Capacites;

public class DonnerPointAction implements Capacites{
	
	public void setPointAction(String origine,int nbPointAction,Joueur joueur){
		joueur.setNbPointsAction(origine,nbPointAction);
	}

	public void lancerCapacite() {
		// TODO Auto-generated method stub
		
	}

	
	

	
	

}
