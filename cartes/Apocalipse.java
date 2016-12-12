package cartes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import gestionPartie.Joueur;
import gestionPartie.Partie;

public class Apocalipse extends CarteAction {
	protected Apocalipse(String nom, String origine) {
		super(nom, origine);
	}

	Partie p;

	public void jouerCarte() {
		HashMap<String, Joueur> joueurs = p.getJoueurs();

		HashMap<Joueur, Integer> pp = new HashMap<Joueur, Integer>();

		Iterator<Entry<String, Joueur>> it0 = joueurs.entrySet().iterator();
		while (it0.hasNext()) {
			Map.Entry<String, Joueur> pair = (Map.Entry<String, Joueur>) it0.next();
			pp.put(pair.getValue(), pair.getValue().getNbPointsPriere());
		}
		it0.remove();
		

		if (p.getNbJoueur() >= 4) {// eliminate the one with lowest PointsPriere

			int pointsPrierePerdu = 0;
			Joueur joueurElim = null;
			Iterator<Entry<Joueur, Integer>> it1 = pp.entrySet().iterator();// parcourir
			while (it1.hasNext()) {
				Map.Entry<Joueur, Integer> pair = (Map.Entry<Joueur, Integer>) it1.next();
				if (pointsPrierePerdu == 0) {
					pointsPrierePerdu = (int) pair.getValue();
					joueurElim = (Joueur) pair.getKey();
				} else {
					if ((int) pair.getValue() < pointsPrierePerdu) {
						pointsPrierePerdu = (int) pair.getValue();
						joueurElim = (Joueur) pair.getKey();
					}
				}
			}
			it1.remove();

			p.quitterPartie(joueurElim);
			System.out.println(joueurElim.getNom() + " est perdu! ");
		
		} else {// select the winner

			int pointsPriereGagn = 0;
			Joueur joueurGagn = null;
			Iterator<Entry<Joueur, Integer>> it2 = pp.entrySet().iterator();// parcourir
			while (it2.hasNext()) {
				Map.Entry<Joueur, Integer> pair = (Map.Entry<Joueur, Integer>) it2.next();
				if (pointsPriereGagn == 0) {
					pointsPriereGagn = (int) pair.getValue();
					joueurGagn = (Joueur) pair.getKey();
				} else {
					if ((int) pair.getValue() > pointsPriereGagn) {
						pointsPriereGagn = (int) pair.getValue();
						joueurGagn = (Joueur) pair.getKey();
					}
				}
			}
			it2.remove();
			
			System.out.println(joueurGagn.getNom() + " est gagne! ");
		}

		this.defausser();

	}

}
