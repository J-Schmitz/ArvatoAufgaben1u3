package aufgabe3;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class FlearValueTest1 {
	
	/*Testklasse für die Klasse FlearValue.
	 */

	@Test
	public void test() {
		
		//Test mit Beispiel, das beiden Version (FlearValue und FlearValueBruteForce) gleiches Ergebnis erzielt
		List <Flear> testList= new LinkedList<Flear>();
		testList.add(new Flear ("Flear 1", 2f, 5));
		testList.add(new Flear ("Flear 2", 1.3f, 2));
		testList.add(new Flear ("Flear 3", 3.3f, 7));
		testList.add(new Flear ("Flear 4", 0.7f, 3));
		testList.add(new Flear ("Flear 5", 4.7f, 10));
		
		FlearValue testFV = new FlearValue();
		int result = testFV.getOptimalValue(5f, testList);
		assertEquals(10, result);
		
		 
	}

}
