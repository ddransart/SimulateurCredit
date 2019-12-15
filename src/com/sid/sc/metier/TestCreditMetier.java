package com.sid.sc.metier;

public class TestCreditMetier {

	public static void main(String[] args) {
	
		CreditMetierImpl monCredit = new CreditMetierImpl();
		
		double capital = 200000;
		double taux = 4.5;
		int duree = 240;
		
		double resultat = monCredit.calculerMensualiteCredit(capital, taux, duree);
		
		System.out.println(resultat);

	}

}
