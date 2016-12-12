package Cartes;



import pandocreon.*;

public class Divinite extends Carte {
	
	public Divinite(Partie partie, String nom, String origine, String capacite, String[] dogmes) {
		super(partie,nom, origine, capacite, dogmes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void jouerCarte(Joueur joueur) {
		// TODO Auto-generated method stub
		capacite(this.capacite);

	}

}
