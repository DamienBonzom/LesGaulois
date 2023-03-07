package personnages;

public class Village {
	
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.villageois = new Gaulois[nbVillageoisMaximum];
		this.nom = nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois personne) {
		villageois[nbVillageois] = personne;
		nbVillageois += 1;
	}
	
	public Gaulois trouverHabitant(int numero_villageois) {
		return villageois[numero_villageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans " + nom + " du chef " + chef.getNom() + " vivent les légendaires gaulois : ");
		for(int i = 0 ; i<nbVillageois ; i++ ) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		// Gaulois gaulois = village.trouverHabitant(30);
		// On a en exception "ArrayIndexOutOfBoundsExcepetion" car il l'indice maximum de la liste est 29
		
		Chef chef_village = new Chef("Abraracourcix", 6, village);
		village.setChef(chef_village);
		
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
		
		//Gaulois gaulois = village.trouverHabitant(1);
		//System.out.println(gaulois);
		//On a "null" en résultat car il ne se trouve rien à cette case, le gaulois se trouve dans le case 0
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		
	}
	
}