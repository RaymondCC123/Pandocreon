package capacites;

import gestionPartie.De;
import gestionPartie.Partie;
import capacites.Capacites;

public class RelancerDe implements Capacites {
	
	private Partie partie;

	public void lancerCapacite() {
		De de=new De(partie);
			de.lancer();// TODO Auto-generated method stub
		
	}
}
