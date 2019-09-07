package aufgabe3;


import java.util.LinkedList;
import java.util.List;


/*In dieser Klasse wird der optimale Wert auf die Brut Force-Variante ausgerechnet,
 * ergo wird rekursiv jede m�gliche Kombination von Fl�hen ermittelt. Sofern deren zusammengerechnete
 * Kosten unter dem �bergebenen Geldwert liegen und das Rating besser ist als das der 
 * vorherigen Kombination, wird beides als neuer Wert festgehalten.
 * 
 */
public class FlearValueBruteForce {
	/*
	 * Die Variablen f�r den Bestwert und die dazugeh�rige Kombination
	 * sind global festgehalten, weil es mir anders nicht gelungen ist,
	 * den rekursiv ermittelten Wert dauerhaft zu speichern. 
	 */
	
	private static int bestValue= 0;
	private static List <Flear> bestCombination = new LinkedList<Flear>();
	
	
	
	
	/*
	 * Der gr��te Rechenaufwand der getOptimalValue-Methode findet  nicht in der
	 * Methode selbst statt, sondern in der recursive_combination-Methode. getOptimalValue
	 * muss anschlie�end nur noch die Werte zuschreiben und ausgeben. 
	 */
	public static int getOptimalValue(float money, List<Flear> flears){
			
			//Einige Variablen, die sp�ter genutzt werden. 
			int res = 0;
			List<Flear> combination = new LinkedList<Flear>();
			
			recursive_combinations(combination, 0, flears, money);
					
			System.out.println();
			res=bestValue;
			System.out.println("Beste Kombination: "+bestCombination+" mit Rating "+res+".");
			
			
			return res; 
		
			}




	/*
	 * Das Grundger�st f�r die Rekursion des Algorithmus stammt von folgender Seite:
	 * https://theproductiveprogrammer.blog/GeneratingCombinations.java.php
	 * 
	 * Offensichtlich habe ich die Methode jedoch f�r meine Zwecke modifiziert und 
	 * das "float money" als �bergebenen Wert hinzugef�gt. Englische Kommentare 
	 * stammen aus dem Original-Algorithmus. 
	 */

	private static void recursive_combinations(List<Flear> combination, int ndx, List <Flear> elems,
			float money) {
		
		if(ndx == elems.size()) {
			// (reached end of list after selecting/not selecting)
			
			int combinationRes=0;
			float combinationPrice = 0;
			
			for (Flear f: combination) {
				//das Gesamtrating und der Gesamtpreis der Kombination werden aufaddiert
				combinationRes= combinationRes + f.getRating();
				combinationPrice = combinationPrice+f.getPrice();
			}
			
			//sofern der Gesamtpreis unter der Geldgrenze liegt und das Gesamtrating besser
			//als das bisherige Gesamtrating ist, werden bestValue und bestCombination aktualisiert
			if (combinationPrice<=money&&combinationRes>bestValue) {
				bestValue = combinationRes; 
				System.out.println(combination+", Price: "+combinationPrice+", Rating: "+bestValue);
				bestCombination.removeAll(bestCombination);
				bestCombination.addAll(combination);
			}
		
		
		} else {
		
		// (include element at ndx)
		combination.add(elems.get(ndx));
		recursive_combinations(combination, ndx+1, elems, money);
		
		
		// (don't include element at ndx)
		combination.remove(elems.get(ndx));
		recursive_combinations(combination, ndx+1, elems, money);
		
		}
		
		
		
	}



}
