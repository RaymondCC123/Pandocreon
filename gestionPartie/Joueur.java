package pandocreon;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import exceptions.*;
import Cartes.*;


public class Joueur {
	
	private String nom;
	private HashMap<String,Integer> nbPointsAction;
	private int nbPointsPriere;
	private int nbCartes;
	private ArrayList<Carte> main;
	private Scanner scannerJoueur ;
	private Partie partie;
	
	
	public Joueur(String nom,Partie partie){
		
		this.partie = partie;
		scannerJoueur = partie.scanner;
		this.nom = nom;
		this.nbPointsPriere=0;
		this.nbCartes=0;
		this.main = new ArrayList<Carte>();
		this.nbPointsAction = new HashMap<String,Integer>();
		this.nbPointsAction.put("Jour", 0);
		this.nbPointsAction.put("Nuit", 0);
		this.nbPointsAction.put("Néant", 0);
		
	}
	
	public void jouer(){
		try{
			
			System.out.println("\nVos cartes sont :"+voirMain());
			System.out.println("\nVos points d'actions sont : "+nbPointsAction);
			System.out.println("\nQue voulez vous faire ?\n1-Piocher des cartes"
					+ "\n2-Jouer des cartes \n3-Voir la table \n4-Ajouter des croyant à un guide spirituel"
					+ "\n5-Sacrifier une carte \n6-Passer son tour \n7-Quitter la partie");
			
			int action = scannerJoueur.nextInt();
			
			switch(action){
			
				case 1 : 
					if(this.nbCartes < 8){
						while(this.main.size()<8){
							Carte carte =partie.paquetCarteAction.piocher();
							this.addMain(carte);
							System.out.println("Vous avez pioché : "+carte.toString());
						}
					} else {
						System.out.println("Votre main est déjà pleine");
						this.jouer();
					}
					break;
					
				case 2 :
					System.out.println("Saisissez la carte à jouer :");
					int position = scannerJoueur.nextInt();
					Carte carte = this.main.get(position);
					carte.jouerCarte(this);
					//System.out.println();
					carte = this.removeMain(position);
					break;
				
				case 3 :
					System.out.println("================");
					String cartesAuCentre = partie.centreTable.VoirCartesAuCentre();
					System.out.println(cartesAuCentre);
					partie.table.voirGuidesSpirituelsPoses();
					System.out.println("================");
					this.jouer();
					break;
					
				case 4 :
					partie.table.voirGuidesSpirituelsJoueur(this);
					System.out.println("Saisissez le guide spirituel :");
					int positionGuide = scannerJoueur.nextInt();
					GuideSpirituel guideSpirituel = partie.table.getGuideSpirituel(this, positionGuide);
					String croyantsAuCentre = partie.centreTable.VoirCartesAuCentre();
					System.out.println(croyantsAuCentre);
					System.out.println("Saisissez croyant :");
					int positionCroyant = scannerJoueur.nextInt();
					Croyant croyant = partie.centreTable.getCroyant(positionCroyant);
					guideSpirituel.ajouterCroyant(croyant);
					jouer();
					break;
					
				case 5:
					break;
					
				case 6:
					break;
					
				case 7:
					partie.quitterPartie(this);
					break;
					
				default :
					System.out.println("Commande non reconnue");
					this.jouer();
			
			}
		}
			
			
			catch(InvalidPANumberException PA){
				
				this.jouer();
			}catch(IndexOutOfBoundsException index){
			System.out.println("La carte choisie n'est pas valide");
			this.jouer();
		}catch(NullPointerException pointer){
			System.out.println("Impossible de trouver l'objet");
			this.jouer();
		}catch(InputMismatchException input){
			System.out.println("Entrée non valide");
			this.jouer();
		}catch(NoSuchElementException paquet){
			System.out.println("Le paquet est vide, impossible de piocher");
			this.jouer();
		}catch(Exception e){
			System.out.println(e);
		}

	}
	
	public void setNbPointsAction(String originePoint, int nbPoints){
		this.nbPointsAction.put(originePoint, nbPointsAction.get(originePoint) + nbPoints);
	}
	
	public void setNbCartes(int nbCartes){
		this.nbCartes=nbCartes;
	}
	
	public void setNbPointsPriere(int nbPointsPriere){
		this.nbPointsPriere=nbPointsPriere;
	}
	
	public int getNbPointsPriere(){
		return this.nbPointsPriere;
	}
	
	public int getNbCartes(){
		return this.nbCartes;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public HashMap<String,Integer> getNbPointsAction(){
		return this.nbPointsAction;
	}
	
	public ArrayList<Carte> getMain(){
		return this.main;
	}
	
	private String voirMain(){
		
		StringBuffer stbuf = new StringBuffer();
		int i=0;
		for(Iterator it=main.iterator();it.hasNext();){
			stbuf.append("\n\t");
			Carte carte =(Carte)it.next();
			stbuf.append(i+"-"+carte.toString());
			i++;
		}
		return stbuf.toString();
	}
	
	public void addMain(Carte carte){
		this.main.add(carte);
		this.nbCartes++;
	}
	
	public Carte removeMain(int position){
		Carte carte = this.main.get(position);
		this.main.remove(carte);
		this.nbCartes--;
		return carte;
	}
}
