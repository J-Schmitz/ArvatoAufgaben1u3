package aufgabe3;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class FlearValueTest2 {
	
	/*
	 * Test mit Beispiel, das bei den beiden Lösungen unterschiedliche Werte 
	 * erzielt und so zeigt, dass BruteForce möglicherweise eine bessere
	 * Antwort gibt. 
	 * Der Algorithmus funktioniert schon so, wie er soll, nur werden wie in der betreffenden
	 * Klasse erwähnt damit nicht alle Optionen abgedeckt. 
	 */

	@Test
	public void test() {
		
		
		List <Flear> testList= new LinkedList<Flear>();
		testList.add(new Flear ("Flear 1", 2.5f, 4));
		testList.add(new Flear ("Flear 2", 0.5f, 2));
		testList.add(new Flear ("Flear 3", 3f, 7));
		
		
		FlearValue testFV = new FlearValue();
		int result = testFV.getOptimalValue(3f, testList);
		assertEquals(7, result);
		
		 
	}

}
