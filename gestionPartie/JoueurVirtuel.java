package pandocreon;

import strategy.Strategy;

public class JoueurVirtuel extends Joueur {

	Strategy strategie; 
	
	public JoueurVirtuel(String nom,Partie partie, Strategy strategie) {
		super(nom,partie);
		this.strategie = strategie;
	}

	public void jouer(){
		this.strategie.jouer(this);
	}
}
