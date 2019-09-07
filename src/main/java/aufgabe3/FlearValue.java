package aufgabe3;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



/*In dieser Klasse ist die Methode "getOptimalValue" ohne Brute-Force-Ansatz,
 * also ohne das �berpr�fen jeder einzelnen Kombinationsm�glichkeit, umgesetzt.
 * Das f�hrt zu weniger �berpr�fungen, allerdings k�nnte die optimalste L�sung
 * so verloren gehen. 
 */

public class FlearValue {
	

	public static int getOptimalValue(float money, List<Flear> flears){
		
		//Einige Variablen, die sp�ter genutzt werden. 
		int res = 0;
		float currentPrice=0; 
		List<Flear> currentFlears = new LinkedList <Flear>();
		
	
		/*Mit sort wird die �bergebene Liste anhand des Preises in eine aufsteigende 
		 * Reihenfolge gebracht. Daf�r war es n�tig, in der Flear-Klasse das Comparable-
		 * Interface und die damit verbundene compareTo-Methode zu implementieren
		 * (siehe ganz unten in genannter Klasse). 
		 */
		Collections.sort(flears);
		
		
		
		
		/*
		 * Der Algorithmus pr�ft zun�chst, ob noch genug Geld vorhanden ist, um den Floh
		 * ohne Probleme in die Liste der aktuell zum Kauf ausgesuchten Fl�he (currentFlears)
		 * hinzuzuf�gen. Ist das der Fall, tut er das.
		 * Andernfalls geht er die Liste mit den bereits hinzugef�gten Fl�hen durch, um zu 
		 * �berpr�fen, ob durch die Entfernung eines zuvor hinzugef�gten Flohs und das 
		 * Hinzuf�gen des derzeitigen bei noch immer eingehaltenem
		 * Preislimit die aufsummierte Bewertung verbessert werden kann. Da die Liste
		 * zumindest anf�nglich nach aufsteigenden Ratings sortiert ist, sollte das
		 * das beste Ergebnis bei Entfernung eines einzelnen Flohs liefern. 
		 * (NIcht ber�cksichtig ist hierbei, ob das Entfernen mehrerer Fl�he gleichzeitig ein
		 * besseres Ergebnis erzielen w�rde.)
		 * Anschlie�end werden Gesamtrating und Gesamtpreis aktualisiert. 
		 */
		for (Flear fl: flears) {
			if (currentPrice+fl.getPrice()<=money) {
				res=res+fl.getRating();
				currentFlears.add(fl);
				currentPrice = currentPrice + fl.getPrice();
			
			}else {
				for (Flear cFl: currentFlears) {
					
					if ((((currentPrice-cFl.getPrice())+fl.getPrice())<=money)
							&& 
						(((res-cFl.getRating())+fl.getRating())>res)) {
						
						res=(res-cFl.getRating())+fl.getRating();
						currentPrice =(currentPrice -cFl.getPrice())+ fl.getPrice();
						currentFlears.add(fl);
						currentFlears.remove(cFl);
						break; 
						
					}
					
				}
			}
			
		}
		
		
		//Gibt Preis, Bewertung und letztendlich in der Liste vorhandene Fl�he in Konsole aus,
		//Dient vor allem zur Verbildlichung. 
		System.out.println ("Preis: "+currentPrice+"; Bewertung: "+res+"\n");
		
		for (Flear f: currentFlears) {
			
			System.out.println(f.getName()+", "+f.getPrice()+", "+f.getRating());
		}
		
		
	
		return res; 
	}
	
	
	
}
