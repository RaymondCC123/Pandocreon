package Cartes;

import pandocreon.*;

public class Apocalypse extends CarteAction {
	
	public Apocalypse(Partie partie,String nom, String origine, String capacite) {
		super(partie,nom, origine, capacite);
	}
	
	public Apocalypse(Partie partie,String nom,String capacite) {
		super(partie,nom,capacite);
	}

	@Override
	public void jouerCarte(Joueur joueur) {
		// TODO Auto-generated method stub
		capacite(this.capacite);
		this.defausser();
	}
}