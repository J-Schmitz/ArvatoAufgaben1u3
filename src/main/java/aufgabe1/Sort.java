package aufgabe1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;


/*
 * In der Klasse Sort ist die sortWords-Methode untergebracht, die 
 * die Namen aus zwei eingelesenen Text-Dateien in drei Listen sortiert,
 * abhängig davon, ob sie nur in Liste 1, nur in Liste 2 oder in beiden Listen 
 * vorkommen und diese Listen anschließend ausgibt. 
 */


public class Sort {
	
	private String list1Path= null;
	private String list2Path=null;
	private List <String> list1;
	private List <String> list2;
	private List <String> commonWords = new LinkedList <String>();
	private JSONObject combined = new JSONObject();

	
	
	/*Im Konstuktor werden die Namen der beiden Textdateien übergeben
	 * und anschließend die Pfade in einem try-catch-block abgegriffen. Womöglich
	 * etwas umständlich, aber ich hatte vorher noch nicht viel mit Files und Pfaden (und
	 * Maven generell) gearbeitet. 
	 */
	
	public Sort (String fileName1_txt, String fileName2_txt) {
		
		try {
			list1Path = Paths.get(Sort.class.getResource("/"+fileName1_txt).toURI()).toString();
			list2Path = Paths.get(Sort.class.getResource("/"+fileName2_txt).toURI()).toString();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	/*
	 *sortWords dient dazu, die Namen aus den einzelnen Listen in drei neue Listen zu sortieren und
	 *in ein JSON-Objekt zu schreiben sowie dieses letztendlich in der Konsole auszugeben.  
	 */
	
	public JSONObject sortWords () {
		
		
		try {
			
			/*Hier werden die Text-Files zu String-Listen ausgelesen, 
			 * damit man sie besser vergleichen kann.
			 */
            list1 = Files.readAllLines(Paths.get(list1Path), StandardCharsets.UTF_8);
            list2 = Files.readAllLines(Paths.get(list2Path), StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		
		/*
		 * Alles, was auch in Liste 1 steht, wird in commonWords, die Liste, in der später die 
		 * gemeinsamen Worte stehen sollen, geschrieben. 
		 */
		for (String word: list1) {
			commonWords.add(word);
		}
		
		
		
		
		/* Da commonWords dieselben Namen enthält wie Liste 1, werden mit "retainAll(list2)" alle Namen
		 * aus commonWords entfernt, die nicht auch in Liste 2 sind, ergo sind nur noch die geteilten
		 * Namen vorhanden. Anshcließend werden mit "removeAll(commonWords)" aus beiden Listen die 
		 * Wörter entfernt, die in beiden Listen vorkommen, sodass nur noch die jeweils einzigartigen 
		 * Namen zurückbleiben. 
		 */
		commonWords.retainAll(list2);
		list1.removeAll(commonWords);
		list2.removeAll(commonWords);
		
		
		
		/*Hier werden alle Listen einem JSON-Objekt hinzugefügt und anschließend ausgegeben.
		 * Ich habe leider keine Zeit gehabt, dafür zu sorgen, dass die Ausgabe besser lesbar
		 * formatiert ist. 
		 */
		combined.put("onlyInList1", list1);
		combined.put("onlyInList2", list2);
		combined.put("inBothLists", commonWords);
		
		
		System.out.println(combined);
		
		
		return combined;
		   
		
	
	}
	
}
