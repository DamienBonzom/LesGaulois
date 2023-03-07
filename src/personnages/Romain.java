package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert force >= 0;
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
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
	
	public void sEquiper(Equipement equip) {
		switch(nbEquipement) {
		case 0:
			equipements[nbEquipement] = equip;
			nbEquipement++;
			System.out.println("Le soldat " + this.getNom() + " s'équipe avec un " + equip.toString());
			break;
		case 1:
			Equipement premierEquip = equipements[0];
			if (premierEquip != equip) {
				equipements[nbEquipement] = equip;
				nbEquipement++;
				System.out.println("Le soldat " + this.getNom() + " s'équipe avec un " + equip.toString());
			}else {
				System.out.println("Le soldat " + this.getNom() + " possède déjà un " + equip.toString());
			}
			break;
		case 2:
			System.out.println("Le soldat " + this.getNom() + " est déjà bien protégé !");
			break;
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}

}
