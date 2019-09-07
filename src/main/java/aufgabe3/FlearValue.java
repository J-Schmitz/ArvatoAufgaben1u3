package aufgabe3;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



/*In dieser Klasse ist die Methode "getOptimalValue" ohne Brute-Force-Ansatz,
 * also ohne das Überprüfen jeder einzelnen Kombinationsmöglichkeit, umgesetzt.
 * Das führt zu weniger Überprüfungen, allerdings könnte die optimalste Lösung
 * so verloren gehen. 
 */

public class FlearValue {
	

	public static int getOptimalValue(float money, List<Flear> flears){
		
		//Einige Variablen, die später genutzt werden. 
		int res = 0;
		float currentPrice=0; 
		List<Flear> currentFlears = new LinkedList <Flear>();
		
	
		/*Mit sort wird die übergebene Liste anhand des Preises in eine aufsteigende 
		 * Reihenfolge gebracht. Dafür war es nötig, in der Flear-Klasse das Comparable-
		 * Interface und die damit verbundene compareTo-Methode zu implementieren
		 * (siehe ganz unten in genannter Klasse). 
		 */
		Collections.sort(flears);
		
		
		
		
		/*
		 * Der Algorithmus prüft zunächst, ob noch genug Geld vorhanden ist, um den Floh
		 * ohne Probleme in die Liste der aktuell zum Kauf ausgesuchten Flöhe (currentFlears)
		 * hinzuzufügen. Ist das der Fall, tut er das.
		 * Andernfalls geht er die Liste mit den bereits hinzugefügten Flähen durch, um zu 
		 * überprüfen, ob durch die Entfernung eines zuvor hinzugefügten Flohs und das 
		 * Hinzufügen des derzeitigen bei noch immer eingehaltenem
		 * Preislimit die aufsummierte Bewertung verbessert werden kann. Da die Liste
		 * zumindest anfänglich nach aufsteigenden Ratings sortiert ist, sollte das
		 * das beste Ergebnis bei Entfernung eines einzelnen Flohs liefern. 
		 * (NIcht berücksichtig ist hierbei, ob das Entfernen mehrerer Flöhe gleichzeitig ein
		 * besseres Ergebnis erzielen würde.)
		 * Anschließend werden Gesamtrating und Gesamtpreis aktualisiert. 
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
		
		
		//Gibt Preis, Bewertung und letztendlich in der Liste vorhandene Flöhe in Konsole aus,
		//Dient vor allem zur Verbildlichung. 
		System.out.println ("Preis: "+currentPrice+"; Bewertung: "+res+"\n");
		
		for (Flear f: currentFlears) {
			
			System.out.println(f.getName()+", "+f.getPrice()+", "+f.getRating());
		}
		
		
	
		return res; 
	}
	
	
	
}
