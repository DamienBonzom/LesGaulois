package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		assert force >= 0;
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int forcetemp = force;
		force -= forceCoup;
		if(force>0) {
			parler("Aïe");
		}else {
			parler("J'abandonne...");
		}
		assert force < forcetemp;
	}
	
	public static void main(String[] args) {
		Romain julesCesar = new Romain("Jules Cesar", 3);
		julesCesar.parler("Bonjour fonction parler");
		julesCesar.recevoirCoup(10);
	}

}
