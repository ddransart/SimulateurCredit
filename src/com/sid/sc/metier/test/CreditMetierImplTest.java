/* Etape 1 : créer la couche métier
 * 3. Tester les méthodes implémentées : créer la classe CreditMetierImplTest */

package com.sid.sc.metier.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sid.sc.metier.CreditMetierImpl;
import com.sid.sc.metier.ICreditMetier;

public class CreditMetierImplTest {
	
	private ICreditMetier creditMetier;

	@Before
	public void setUp() throws Exception {
		creditMetier = new CreditMetierImpl();
	}

	@Test
	public void testCalculerMensualiteCredit() {
		
		double capital = 200000;
		double taux = 4.5;
		int duree = 240;
		
		double resultatAttendu = 1265.2987;
		double resultatCalculé = creditMetier.calculerMensualiteCredit(capital, taux, duree);
		
		assertEquals(resultatAttendu, resultatCalculé, 0.0001); // dernier paramètre pour la précision (on veut un résultat avec maxi 4 chiffres après la virgule.) 
		// assertTrue(resultatAttendu > resultatCalculé); on peut vérifier ce que l'on veut et comme on le souhaite
	}

}
