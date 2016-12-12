package Cartes;

import java.util.ArrayList;

import exceptions.InvalidPANumberException;
import pandocreon.*;

public abstract class Carte {
	protected String nom;
	protected String origine;
	protected String capacite;
	protected String [] dogmes;
	protected Partie partie;

	public Carte(Partie partie,String nom, String origine, String capacite, String [] dogmes) {
		this.nom = nom;
		this.origine = origine;
		this.capacite = capacite;
		this.dogmes = dogmes;
		this.partie = partie;
	}

	public Carte(Partie partie,String nom, String capacite) {
		this.nom = nom;
		this.origine = null;
		this.capacite = capacite;
		this.dogmes = null;
		this.partie = partie;
	}

	public Carte(Partie partie,String nom,String origine, String capacite) {
		this.nom = nom;
		this.origine = origine;
		this.capacite = capacite;
		this.dogmes = null;
		this.partie = partie;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public String getOrigine(){
		return this.origine;
	}
	
	public String getCapacite(){
		return this.capacite;
	}
	
	public String[] getDogmes(){
		for(int i=0; i<this.dogmes.length;i++){
			System.out.println(dogmes[i]);
		}
		return this.dogmes;
	}
	
	public void capacite(String capacite){
	}
	
	public void defausser(){
		 
	}
	
	public String toString(){
		String detailCarte = this.nom+" d'origine "+this.origine+" Capacité :"+this.capacite;
		return detailCarte;
	}
	
	public abstract void jouerCarte(Joueur joueur) throws InvalidPANumberException;
		
	
}