package aufgabe1;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

public class SortTest {

	/*Testklasse für die Klasse Sort
	 */

	@Test
	public void testSortWords() {
		Sort sortTest = new Sort ("List1.txt", "List2.txt");
		JSONObject result = sortTest.sortWords();
		assertEquals ("{\"inBothLists\":[\"Maria Mustermann\",\"Meinhard Mustermann\"],\"onlyInList2\":[\"Claudia Mustermann\"],\"onlyInList1\":[\"Max Mustermann\",\"Burghard Mustermann\"]}", result.toString());
	}

}
