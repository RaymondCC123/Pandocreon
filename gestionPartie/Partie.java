package pandocreon;


import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import exceptions.*;
import Cartes.*;
import strategy.*;

public class Partie {
	
	private int nbJoueur;
	private ConcurrentHashMap<String,Joueur> joueurs;
	public static Scanner scanner = new Scanner(System.in);
	public Paquet paquetDivinite;
	public Paquet paquetCarteAction;
	public static Strategy difficulte;
	public CentreTable centreTable;
	public De de;
	public Table table;
	
	public Partie(int nbJoueur,ConcurrentHashMap<String,Joueur> joueurs){
		
		this.nbJoueur=nbJoueur;
		this.joueurs=joueurs;
		this.paquetDivinite = new Paquet();
		this.centreTable=new CentreTable();
		this.de= new De(this);
	
		
	}

	public int getNbJoueur(){
		return this.nbJoueur;
	}
	
	public ConcurrentHashMap<String,Joueur> getJoueurs(){
		return this.joueurs;
	}
	
	public void lancerPartie(Partie p, int nbJoueur){

		// CREATION DES DIVINITES
		paquetDivinite.ajouter(new Divinite(p,"Brewalen","Jour","Eclair",new String []{"Nature","Humain","Mystique"}));
		paquetDivinite.ajouter(new Divinite(p,"Drinded","Jour","Eclair",new String []{"Nature","Humain","Symboles"}));
		paquetDivinite.ajouter(new Divinite(p,"Yarstur","Jour","Eclair",new String []{"Chaos","Symboles","Mystique"}));
		paquetDivinite.ajouter(new Divinite(p,"Killinstred","Nuit","Eclair",new String []{"Nature","Mystique","Chaos"}));
		paquetDivinite.ajouter(new Divinite(p,"Llenella","Nuit","Eclair",new String []{"Nature","Mystique","Chaos"}));
		paquetDivinite.ajouter(new Divinite(p,"Pui-Tara","Nuit","Eclair",new String []{"Nature","Mystique","Symboles"}));
		paquetDivinite.ajouter(new Divinite(p,"Gwenghelen","Aube","Eclair",new String []{"Humain","Mystique","Symboles"}));
		paquetDivinite.ajouter(new Divinite(p,"Shingva","Aube","Eclair",new String []{"Humain","Mystique","Chaos"}));
		paquetDivinite.ajouter(new Divinite(p,"Gorpa","Crépuscule","Eclair",new String []{"Humain","Symboles","Chaos"}));
		paquetDivinite.ajouter(new Divinite(p,"Romtec","Crépuscule","Eclair",new String []{"Nature","Humain","Chaos"}));
		paquetDivinite.melanger();
		//
		paquetCarteAction = new Paquet();
		
		//CREATION DES CROYANTS
			//CROYANTS JOUR
		paquetCarteAction.ajouter(new Croyant(p,"Moines","Jour","Croyant",new String []{"Nature","Humain","Mystique"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Moines","Jour","Croyant",new String []{"Mystique","Humain","Chaos"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Moines","Jour","Croyant",new String []{"Symboles","Humain","Chaos"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Moines","Jour","Croyant",new String []{"Nature","Symboles","Mystique"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Moines","Jour","Croyant",new String []{"Nature","Chaos","Mystique"},2));	
		paquetCarteAction.ajouter(new Croyant(p,"Travailleurs","Jour","Croyant",new String []{"Symboles","Chaos","Humain"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Travailleurs","Jour","Croyant",new String []{"Nature","Humain","Symboles"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Travailleurs","Jour","Croyant",new String []{"Humain","Chaos","Mystique"},2));	
		paquetCarteAction.ajouter(new Croyant(p,"Ermites","Jour","Croyant",new String []{"Symboles","Nature","Symboles"},1));
		paquetCarteAction.ajouter(new Croyant(p,"Ermites","Jour","Croyant",new String []{"Chaos","Nature","Mystique"},1));		
		paquetCarteAction.ajouter(new Croyant(p,"Intégristes","Jour","Croyant",new String []{"Chaos","Nature","Humain"},1));		
		paquetCarteAction.ajouter(new Croyant(p,"Guerriers Saints","Jour","Croyant",new String []{"Mystiques","Nature","Symboles"},4));
		paquetCarteAction.ajouter(new Croyant(p,"Diplomates","Jour","Croyant",new String []{"Humain","Chaos","Symboles"},4));
		
			//CROYANTS NUIT
		paquetCarteAction.ajouter(new Croyant(p,"Démons","Nuit","Croyant",new String []{"Nature","Humain","Mystique"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Démons","Nuit","Croyant",new String []{"Mystique","Humain","Chaos"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Démons","Nuit","Croyant",new String []{"Symboles","Chaos","Mystique"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Démons","Nuit","Croyant",new String []{"Nature","Symboles","Mystique"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Démons","Nuit","Croyant",new String []{"Nature","Chaos","Mystique"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Alchimistes","Nuit","Croyant",new String []{"Nature","Chaos","Symboles"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Alchimistes","Nuit","Croyant",new String []{"Nature","Chaos","Mystique"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Alchimistes","Nuit","Croyant",new String []{"Nature","Chaos","Symboles"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Vampires","Nuit","Croyant",new String []{"Nature","Humain","Symboles"},1));
		paquetCarteAction.ajouter(new Croyant(p,"Vampires","Nuit","Croyant",new String []{"Chaos","Humain","Mystique"},1));
		paquetCarteAction.ajouter(new Croyant(p,"Lycanthropes","Nuit","Croyant",new String []{"Chaos","Humain","Nature"},4));
		paquetCarteAction.ajouter(new Croyant(p,"Illusionnistes","Nuit","Croyant",new String []{"Chaos","Humain","Symboles"},4));
		paquetCarteAction.ajouter(new Croyant(p,"Pillards","Nuit","Croyant",new String []{"Mystique","Symboles","Nature"},4));
		
			//CROYANTS NEANT
		
		paquetCarteAction.ajouter(new Croyant(p,"Esprits","Néant","Croyant",new String []{"Nature","Humain","Mystique"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Esprits","Néant","Croyant",new String []{"Mystique","Humain","Chaos"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Esprits","Néant","Croyant",new String []{"Chaos","Mystique","Symboles"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Esprits","Néant","Croyant",new String []{"Nature","Mystique","Symboles"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Esprits","Néant","Croyant",new String []{"Nature","Mystique","Chaos"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Aliénés","Néant","Croyant",new String []{"Nature","Humain","Symboles"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Aliénés","Néant","Croyant",new String []{"Mystique","Humain","Chaos"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Aliénés","Néant","Croyant",new String []{"Chaos","Humain","Symboles"},2));		
		paquetCarteAction.ajouter(new Croyant(p,"Revenants","Néant","Croyant",new String []{"Nature","Humain","Mystique"},1));
		paquetCarteAction.ajouter(new Croyant(p,"Révolutionnaires","Néant","Croyant",new String []{"Symboles","Humain","Chaos"},2));
		paquetCarteAction.ajouter(new Croyant(p,"Nihillistes","Néant","Croyant",new String []{"Symboles","Mystique","Chaos"},4));
		//

		// CREATION GUIDE SPIRITIUEL
		
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Martyrs","Jour","GuideSpirituel",new String []{"Nature","Humain"},2));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Martyrs","Nuit","GuideSpirituel",new String []{"Symboles","Humain"},2));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Martyrs","Néant","GuideSpirituel",new String []{"Nature","Chaos"},2));		
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Clerc","Jour","GuideSpirituel",new String []{"Humain","Chaos"},2));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Clerc","Nuit","GuideSpirituel",new String []{"Nature","Symboles"},2));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Clerc","Néant","GuideSpirituel",new String []{"Nature","Mystique"},2));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Clerc","Nuit","GuideSpirituel",new String []{"Mystique","Symboles"},2));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Clerc","Nuit","GuideSpirituel",new String []{"Nature","Humain"},2));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Clerc","Jour","GuideSpirituel",new String []{"Chaos","Mystique"},2));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Clerc","Jour","GuideSpirituel",new String []{"Nature","Chaos"},2));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Clerc","Néant","GuideSpirituel",new String []{"Chaos","Symbole"},2));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Shaman","Nuit","GuideSpirituel",new String []{"Nature","Symboles"},3));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Anarchiste","Nuit","GuideSpirituel",new String []{"Humain","Chaos"},3));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Paladin","Nuit","GuideSpirituel",new String []{"Humain","Mystique"},3));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Ascète","Nuit","GuideSpirituel",new String []{"Humain","Symboles"},1));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Devin","Néant","GuideSpirituel",new String []{"Nature","Mystique"},1));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Exorciste","Jour","GuideSpirituel",new String []{"Mystique","Chaos"},1));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Sorcier","Nuit","GuideSpirituel",new String []{"Mystique","Symboles"},3));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Tyran","Nuit","GuideSpirituel",new String []{"Chaos","Symboles"},3));
		paquetCarteAction.ajouter(new GuideSpirituel(p,"Messie","Jour","GuideSpirituel",new String []{"Mystique","Humain"},3));
		//
		
		//CREATION DEUS EX
		paquetCarteAction.ajouter(new DeusEx(p,"Colère Divine","Jour","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Colère Divine","Nuit","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Stase","Jour","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Ordre Céleste","Jour","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Fourberie","Jour","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Diversion","Nuit","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Concentration","Néant","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Trou noir","Néant","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Phoenix","Néant","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Influence Jour","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Influence Nuit","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Influence Néant","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Influence Nulle","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Influence Nulle","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Transe","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Mirroir","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Bouleversement","DeusEx"));
		paquetCarteAction.ajouter(new DeusEx(p,"Inquisition","DeusEx"));
		//
		//CREATION DES APOCALYPSES
		paquetCarteAction.ajouter(new Apocalypse(p,"Apocalypse","Jour","Apocalypse"));
		paquetCarteAction.ajouter(new Apocalypse(p,"Apocalypse","Nuit","Apocalypse"));
		paquetCarteAction.ajouter(new Apocalypse(p,"Apocalypse","Néant","Apocalypse"));
		paquetCarteAction.ajouter(new Apocalypse(p,"Apocalypse","Apocalypse"));
		paquetCarteAction.ajouter(new Apocalypse(p,"Apocalypse","Apocalypse"));
		
		//
		paquetCarteAction.melanger();
		
		for(Iterator<String>it=joueurs.keySet().iterator();it.hasNext();){
			String key = it.next();
			Joueur joueur=joueurs.get(key);
			joueur.addMain(paquetDivinite.piocher());				
		}
		this.table=new Table(this);
		Tour tour = new Tour(p);
		tour.debutTour();
	}
	
	public void quitterPartie(Joueur joueur)throws ExitingGameException{
		this.joueurs.remove(joueur.getNom());
		if(this.joueurs.size()==1){
			for(Iterator<String>it=joueurs.keySet().iterator();it.hasNext();){
				String key = it.next();
				Joueur joueurGagnant=joueurs.get(key);
				System.out.println("Le joueur "+joueurGagnant.getNom()+" a gagné la partie !");
			}
		}
		throw new ExitingGameException(joueur);
	}
	

	
	public static void main(String[] args) {

		ConcurrentHashMap<String,Joueur> joueurs = new ConcurrentHashMap<String,Joueur>();
		try{
		System.out.println("Veuillez saisir le nombre de joueurs physique à ajouter : ");		
		int nbJoueursPhysiques=scanner.nextInt();
		

		System.out.println("Veuillez saisir le nombre de joueurs virtuels à ajouter : ");
		
		int nbJoueursVirtuels=scanner.nextInt();
		
		Partie partie = new Partie(nbJoueursVirtuels+nbJoueursPhysiques,joueurs);

		if(nbJoueursVirtuels!=0){
			System.out.println("Difficulté des joueurs virtuels : \n1-Facile\n2-Moyen");
			int diff=scanner.nextInt();
			if(diff == 1){
				difficulte = new StrategieJoueurVirtuelFacile(partie);
			} else if (diff == 2){
				difficulte = new StrategieJoueurVirtuelMoyen(partie);
			}
		}
 
		
		for(int i=1;i<nbJoueursPhysiques+1;i++){
			System.out.println("Veuillez saisir le nom du joueur physique "+i+ ":");
			String nomJoueur = scanner.next();
			joueurs.put(nomJoueur, new Joueur(nomJoueur,partie));
		}
		
		for(int i=1;i<nbJoueursVirtuels+1;i++){
			String nomJoueursVirtuels="joueurVirtuel"+i;
			joueurs.put(nomJoueursVirtuels, new JoueurVirtuel(nomJoueursVirtuels,partie,difficulte));
		}
		
		
		System.out.println("Début de la partie");
	
		partie.lancerPartie(partie,nbJoueursVirtuels+1);
		
		scanner.close();
		}catch(InputMismatchException input){
			System.out.println("La variable précédement entrée est incorrecte, erreur lors de la création de la partie");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
