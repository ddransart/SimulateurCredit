/* Etape 2 : créer la couche web
 * 3. créer le CONTROLLER */

package com.sid.sc.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sid.sc.metier.CreditMetierImpl;
import com.sid.sc.metier.ICreditMetier;


@WebServlet(name="CreditControllerServlet")
public class CreditControllerServlet extends HttpServlet {
	
	//private static final String ATT_CREDIT_MODEL = "creditModel";
	private static final String VUE = "/WEB-INF/vues/VueCredit.jsp";
	private static final long serialVersionUID = 1L;
	
	private ICreditMetier creditMetier;
       
   
    public CreditControllerServlet() {
        creditMetier = new CreditMetierImpl();
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setAttribute("creditModel", new CreditModel());
		request.getRequestDispatcher(VUE).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 
		 * 1. Lire les données de la requete (renseignées dans le formulaire)
		 */
		double montant = Double.parseDouble(request.getParameter("montant"));
		double taux = Double.parseDouble(request.getParameter("taux"));
		int duree = Integer.parseInt(request.getParameter("duree"));
		
		/*
		 * 2. Valider les données
		 */
		
		/* 
		 * 2. Stocker les données saisies dans le MODEL
		 */
		
		CreditModel creditModel = new CreditModel();
		creditModel.setMontant(montant);
		creditModel.setTaux(taux);
		creditModel.setDuree(duree);
		
		/* 
		 * 3. Faire appel à la couche METIER pour effectuer les traitements et récupérer les résultats 
		 */
		double resultat = creditMetier.calculerMensualiteCredit(montant, taux, duree);
		
		/* 
		 * 4. Stocker les résultats dans le Modèle
		 */
		creditModel.setMensualite(resultat);
		
		/*
		 *  5. Stocker le MODELE dans l'objet request
		 */
		request.setAttribute("creditModel", creditModel);
		
		/* 
		 * 5. Transmettre la requete et la réponse à la Vue JSP
		 */
		request.getRequestDispatcher(VUE).forward(request, response);
	}

}
