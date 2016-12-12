package pandocreon;

import java.util.Collections;
import java.util.LinkedList;
import Cartes.*;


public class Paquet {

	private LinkedList<Carte> paquet;
	
	public Paquet(){
		this.paquet = new LinkedList<Carte>();
	}
	
	public void melanger(){
		
        Collections.shuffle(this.paquet);
	}
	
	public Carte piocher(){
		
		return this.paquet.pop();
		
	}
	
	public void ajouter(Carte carte){
		paquet.add(carte);
	}
}
