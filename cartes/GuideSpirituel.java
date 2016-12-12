package Cartes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import exceptions.*;
import pandocreon.Joueur;
import pandocreon.Partie;
import pandocreon.Table;

public class GuideSpirituel extends CarteAction {
	
	private int nbCroyantsMax;
	private int nbCroyantsAttaches;
	private ArrayList<Croyant> croyantsAttaches;

	public GuideSpirituel(Partie partie,String nom, String origine, String capacite,String[] dogmes, int nbCroyantsMax) {
		super(partie,nom, origine, capacite, dogmes);
		this.nbCroyantsMax = nbCroyantsMax;
		this.nbCroyantsAttaches = 0;
		this.croyantsAttaches = new ArrayList<Croyant>();
		this.partie = partie;
	}

	public void ajouterCroyant(Croyant croyant) {
		boolean dogmesCompatibles = false; ;
		for(int i=0;i<this.dogmes.length;i++){
			for(int j=0;j<croyant.dogmes.length;j++){
				if(this.dogmes[i].equals(croyant.dogmes[j])){
					dogmesCompatibles=true;
					break;
				}
			}
			
		}
		if (nbCroyantsAttaches + croyant.getNbCroyant() <= nbCroyantsMax && dogmesCompatibles==true) {
			partie.centreTable.retirerCarte(croyant);
			croyantsAttaches.add(croyant);
			nbCroyantsAttaches += croyant.getNbCroyant();
			System.out.println("Le croyant "+croyant.getNom()+" a été ajouté au guide spirituel "+this.getNom());
		} else {
			System.out.println("On ne peut pas ajouter ce croyant.");
		}
	}

	public void retirerCroyant(Croyant croyant) {
		if (croyantsAttaches.size() != 0) {
			croyantsAttaches.remove(croyant);
			nbCroyantsAttaches -= croyant.getNbCroyant();
		} else {
			System.out.println("Le tableau est vide.");
		}
	}
	
	public int getNbCroyantsAttaches() {
		return this.nbCroyantsAttaches;
	}

	public int getNbCroyantsMax() {
		return this.nbCroyantsMax;
	}
	
	public ArrayList<Croyant> getCroyantsAttaches(){
		return this.croyantsAttaches;
	}

	@Override
	public void jouerCarte(Joueur joueur) throws InvalidPANumberException {
		
			if(joueur.getNbPointsAction().get(this.origine)<this.coutPointAction){
				throw new InvalidPANumberException(joueur);
			}else{
				partie.table.poserGuideSpirituel(joueur, this);
			}
		
		
	}
	
	public String toString(){
		StringBuffer strbuf = new StringBuffer();
				strbuf.append(this.nom+" d'origine "+this.origine+", Sacrifice : "+this.capacite+", Nombre de croyants pouvants être rattachés à ce guide : "+ this.nbCroyantsMax+" Dogmes : ");
		for(int i=0;i<this.dogmes.length;i++){
			strbuf.append(dogmes[i]+" ");
		}
		
		return strbuf.toString();
	}
	
	//


}
