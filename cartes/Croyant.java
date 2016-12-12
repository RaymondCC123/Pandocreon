package Cartes;



import exceptions.InvalidPANumberException;
import pandocreon.*;

public class Croyant extends CarteAction {
	private int nbCroyant;
	

	public Croyant(Partie partie,String nom, String origine, String capacite, String[] dogmes, int nbCroyant) {
		super(partie,nom, origine, capacite, dogmes);
		this.nbCroyant = nbCroyant;
		
	}

	public int getNbCroyant() {
		return this.nbCroyant;
	}

	public String toString(){
		
		StringBuffer strbuf = new StringBuffer();
		strbuf.append(this.nom+" d'origine "+this.origine+", Sacrifice : "+this.capacite+", Nombre de croyants représentés : "+ this.nbCroyant+" Dogmes : ");
		for(int i=0;i<this.dogmes.length;i++){
			strbuf.append(dogmes[i]+" ");
		}
		return strbuf.toString();
	}
	
	@Override
	public void jouerCarte(Joueur joueur) {
		// TODO Auto-generated method stub
		try {
			if(joueur.getNbPointsAction().get(this.origine)<this.coutPointAction){
				throw new InvalidPANumberException(joueur);
			}else{
				partie.centreTable.poserAuCentre(this);
			}
		} catch (Exception e) {

		}
		
	}
}