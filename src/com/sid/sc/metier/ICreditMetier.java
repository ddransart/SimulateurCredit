package com.sid.sc.metier;

/* Etape 1 : créer la couche métier
 * 1. Créer l'interface ICreditMetier */

public interface ICreditMetier {
	
	public double calculerMensualiteCredit(double capital, double taux, int duree);
	

}
