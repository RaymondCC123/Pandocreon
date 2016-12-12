package pandocreon.carte;

public class DeuxEx extends CarteAction {
	protected DeuxEx(String nom, String origine, String capacite) {
		super(nom, origine, capacite);
	}

	@Override
	public void jouerCarte() {
		// TODO Auto-generated method stub
		capacite(this.capacite);
		this.defausser();
	}
}
