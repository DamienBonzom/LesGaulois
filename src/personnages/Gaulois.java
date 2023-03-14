package personnages;
import personnages.Romain;
import personnages.Musee;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.trophees = new Equipement[100];
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force/3)*effetPotion);
//	}
	
	public void frapper(Romain romain) { 
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom()); 
		Equipement[] tropheesFrap = romain.recevoirCoup((force / 3) * effetPotion); 
		for (int i = 0; tropheesFrap != null && i < tropheesFrap.length; i++, nbTrophees++) { 
			this.trophees[nbTrophees] = tropheesFrap[i]; 
		}  
	}


	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
	}
	
	public void faireUneDonnation(Musee musee) {
		String texte = "Je donne au musee tous mes trophees :\n";
		for(int i = 0; i < nbTrophees; i++ ) {
			System.out.println(nbTrophees);
			Trophee trop = new Trophee(this, trophees[i]);
			musee.donnerTrophees(this, trop);
			texte += "- " + trop.getEquipement().toString() + "\n";
		}
		parler(texte);
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain julesCesar = new Romain("Jules Cesar", 3);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.boirePotion(3);
		asterix.parler("Bonjour fonction parler");
		asterix.frapper(julesCesar);
		
	
}
}