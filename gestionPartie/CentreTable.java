package pandocreon;

import java.util.ArrayList;
import java.util.Iterator;

import Cartes.*;

public class CentreTable {

	private ArrayList<Croyant>carteCentreTable;
	
	public CentreTable(){
		carteCentreTable=new ArrayList<Croyant>();
	}
	
	public void poserAuCentre(Croyant croyant){
		System.out.println("La carte "+croyant.getNom()+" a été posé au centre de la table");
		carteCentreTable.add(croyant);
	}
	
	public void retirerCarte(Croyant croyant){

		this.carteCentreTable.remove(croyant);

		System.out.println("La carte "+croyant.getNom()+" a été retiré du centre de la table");

	}
	
	public Croyant getCroyant(int position){
		Croyant croyant =carteCentreTable.get(position-1);
		return croyant;
	}
	
	public String VoirCartesAuCentre(){
		StringBuffer stbuf = new StringBuffer();
		stbuf.append("Les cartes aux centre de la table sont :");
		int i=1;
		for(Iterator it=carteCentreTable.iterator();it.hasNext();){
			Carte carte=(Carte)it.next();
			stbuf.append("\n\t"+i+"-"+carte.toString());
			i++;
		}
		return stbuf.toString();
	}
	
	
}
