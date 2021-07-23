package com.dobatii.java.exams.exo1.service;

import static  com.dobatii.java.exams.exo1.utils.cons.Constant.*;

import com.dobatii.java.exams.exo1.utils.enums.CouleurEnum;
import com.dobatii.java.exams.exo1.utils.enums.TensionAlimentationEnum;
import com.dobatii.java.exams.exo1.utils.validation.DataValidation;

public class ResistanceSerieService {
	
	// Donn�es pour le calcul de la valeur de r�sistance
	private CouleurEnum couleurLed;
	private TensionAlimentationEnum tensionAlimentation;
	private Float tensionLed;
	private Float intensiteLed;
	
	public ResistanceSerieService() {
		super();	
	}
	
	/**
	 * Calcul de la r�sistance selon la formule R=(U-UI)/I en fonction de couleur LED
	 * @param couleur de la Led
	 * @return un nombre d�cimal positif ou n�gatif(donn�es invalides)
	 */
	public Float calculerValeurResistanceEnfonctionDeCouleurLed(String couleur) {
		
		System.out.print(ON_CALCULE_LA_VALEUR);
		// Si les donn�es de l'utilisateur sont valides
		couleurLed = DataValidation.validerCouleurLed(couleur);
		return null != couleurLed ? ((12 - couleurLed.getTensionLed())/0.02f) : Float.MIN_VALUE;
		
	}
	
	/**
	 * Calcul de la r�sistance selon la formule R=(U-UI)/I en fonction de couleur LED
	 * @param couleur de la Led
	 * @return un nombre d�cimal positif ou n�gatif(donn�es invalides)
	 */
	public Float calculerValeurResistanceEnfonctionDeCouleurLedEtTensionAlimentation(String couleur, String tensionAlim) {
		
		System.out.print(ON_CALCULE_LA_VALEUR);
		// Si les donn�es de l'utilisateur sont valides
		couleurLed = DataValidation.validerCouleurLed(couleur);
		tensionAlimentation = DataValidation.validerTensionAlimentation(tensionAlim);
		return null != couleurLed ? ((tensionAlimentation.getValeurTension() - couleurLed.getTensionLed())/0.02f) : -100000f;
		
	}
	
	/**
	 * Calcul de la r�sistance selon la formule R=(U-UI)/I en fonction de couleur LED
	 * @param couleur de la Led
	 * @return un nombre d�cimal positif ou n�gatif(donn�es invalides)
	 */
	/**
	 * Calcul de la r�sistance selon la formule R=(U-UI)/I en fonction de couleur LED
	 *  
	 * @param couleur
	 * @param tensionAlim
	 * @param tLed
	 * @param iLed
	 * @return un nombre d�cimal positif ou n�gatif(donn�es invalides)
	 */
	public Float calculerValeurResistanceEnfonctionDeCouleurLedTensAlimentTensLedEtIntLed(String couleur, String tensionAlim, String tLed, String iLed) { 
		
		System.out.print(ON_CALCULE_LA_VALEUR);
		// Si les donn�es de l'utilisateur sont valides
		couleurLed = DataValidation.validerCouleurLed(couleur);
		tensionAlimentation = DataValidation.validerTensionAlimentation(tensionAlim);
		tensionLed = DataValidation.validerTensionLed(tLed);
		intensiteLed = DataValidation.validerIntensiteLed(iLed);
		
		return null != couleurLed ? ((tensionAlimentation.getValeurTension() - tensionLed)/intensiteLed) : -100000f;
		
	}

}