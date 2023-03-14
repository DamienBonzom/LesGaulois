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
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup > 0;
//		int forcetemp = force;
//		force -= forceCoup;
//		if(force>0) {
//			parler("A�e");
//		}else {
//			parler("J'abandonne...");
//		}
//		assert force < forcetemp;
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) { 
		Equipement[] equipementEjecte = null; 
		// pr�condition 
		assert force > 0; 
		int oldForce = force; 
		forceCoup = calculResistanceEquipement(forceCoup); 
		force -= forceCoup; 
		// if (force > 0) { 
		//  	parler("A�e"); 
		// } else { 
		//  	equipementEjecte = ejecterEquipement(); 
		//  	parler("J'abandonne..."); 
		// }
		if (force == 0) {
			parler("A�e");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}

		// post condition la force a diminu�e 
		assert force < oldForce;
		return equipementEjecte;
	}
	

	private int calculResistanceEquipement(int forceCoup) { 
		String texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup; 
		int resistanceEquipement = 0; 
		if (nbEquipement != 0) { 
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de "; 
			for (int i = 0; i < nbEquipement; i++) { 
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) { 
					resistanceEquipement += 8; 
				} else { 
					System.out.println("Equipement casque"); 
					resistanceEquipement += 5; 
				}  
			} 
			texte += resistanceEquipement + "!"; 
		} 
		parler(texte); 
		forceCoup -= resistanceEquipement;
		return forceCoup; 
	}

	private Equipement[] ejecterEquipement() { 
		Equipement[] equipementEjecte = new Equipement[nbEquipement]; 
		System.out.println("L'�quipement de " + nom.toString() + " s'envole sous la force du coup.");  
		int nbEquipementEjecte = 0; 
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) { 
				equipementEjecte[nbEquipementEjecte] = equipements[i]; 
				nbEquipementEjecte++; equipements[i] = null; 
			} 
		} 
		return equipementEjecte; 
	}
		
	

	
	public void sEquiper(Equipement equip) {
		switch(nbEquipement) {
		case 0:
			equipements[nbEquipement] = equip;
			nbEquipement++;
			System.out.println("Le soldat " + this.getNom() + " s'�quipe avec un " + equip.toString());
			break;
		case 1:
			Equipement premierEquip = equipements[0];
			if (premierEquip != equip) {
				equipements[nbEquipement] = equip;
				nbEquipement++;
				System.out.println("Le soldat " + this.getNom() + " s'�quipe avec un " + equip.toString());
			}else {
				System.out.println("Le soldat " + this.getNom() + " poss�de d�j� un " + equip.toString());
			}
			break;
		case 2:
			System.out.println("Le soldat " + this.getNom() + " est d�j� bien prot�g� !");
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
