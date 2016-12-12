package Cartes;



import exceptions.InvalidPANumberException;
import pandocreon.*;

public abstract class CarteAction extends Carte {
	protected int coutPointAction;

	protected CarteAction(Partie partie,String nom, String capacite) {
		super(partie,nom, capacite);
		this.coutPointAction=this.calculCoutPA();
	}
	
	protected CarteAction(Partie partie,String nom, String origine, String capacite) {
		super(partie,nom, origine, capacite);
		this.coutPointAction=this.calculCoutPA();
		
	}
	
	protected CarteAction(Partie partie,String nom, String origine, String capacite, String[] dogmes) {
		super(partie,nom, origine, capacite, dogmes);
		this.coutPointAction=this.calculCoutPA();
		
	}

	public int getCoutPointAction(){
		return this.coutPointAction;
	}
	
	protected int calculCoutPA(){
		if(this.origine==null){
			return 0;
		}else if(this.origine.equals("Néant")){
			return 2;
		}else{
			return 1;
		}
	}
	@Override
	public abstract void jouerCarte(Joueur joueur) throws InvalidPANumberException;
}
