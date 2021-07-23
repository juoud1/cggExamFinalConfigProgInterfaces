package  com.dobatii.java.exams.exo1.utils.enums;

/**
 * Enumération des couleurs suivant 
 * http://fantaisyland.fr/calcul-resistance-led/
 * 
 * @author Juoud1
 *
 */

public enum CouleurEnum {
	
	ROUGE(1, "Rouge", 2.2f), 
	ORANGE(2, "Orange", 3.3f), 
	JAUNE(3, "Jaune", 2.2f), 
	VERT(4, "Vert", 3.2f), 
	BLEU(5, "Bleu", 3.1f), 
	ROSE(6, "Rose", 3.3f), 
	UV(7, "UV", 3.3f),
	BLANC(8, "Blanc", 3.3f);
	
	private int couleurId;
	private String couleurName;
	private float tensionLed; //Moyenne des tensions indiquées sur le site
	
	private CouleurEnum() {
		
	}
	
	private CouleurEnum(int couleurId, String couleurName, float tensionLed) {
		this.couleurId = couleurId;
		this.couleurName = couleurName;
		this.tensionLed = tensionLed;
	}

	public int getCouleurId() {
		return couleurId;
	}

	public String getCouleurName() {
		return couleurName;
	}
	public float getTensionLed() {
		return tensionLed;
	}
	
}
