package personnages;

public class Musee {
	
	private Trophee[] trophees;
	private int nbTrophee;
	
	public Musee() {
		this.nbTrophee = 0;
		this.trophees = new Trophee[200];
	}

	public Trophee[] getTrophees() {
		return trophees;
	}

	public int getNbTrophee() {
		return nbTrophee;
	}
	
	public void donnerTrophees(Gaulois donateur, Trophee donation) {
		trophees[nbTrophee] = donation;
		nbTrophee++;
	}

}
