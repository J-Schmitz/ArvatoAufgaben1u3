package aufgabe3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


//Klasse nur für Zwischentests 
public class FlearMain {

	public static void main(String[] args) {
		
		
		List <Flear> fList = new LinkedList <Flear>();
		
		fList.add(new Flear ("Albert", 2f, 5));
		fList.add(new Flear ("Bethany", 0.5f, 1));
		fList.add(new Flear ("Carver", 5f, 10));
		fList.add(new Flear ("Daniel", 3f, 7));
		fList.add(new Flear ("Eldass", 2f, 6));
		fList.add(new Flear ("Franz", 4f, 6));
		fList.add(new Flear ("Gregory", 8f, 8));
		fList.add(new Flear ("Hans", 10f, 10));
		fList.add(new Flear ("Ingris", 4f, 3));
		fList.add(new Flear ("John", 4f, 4));
		
		List <Flear> bList = new LinkedList <Flear>();
		bList.add(new Flear ("Albert", 2f, 5));
		bList.add(new Flear ("Bethany", 0.5f, 1));
		bList.add(new Flear ("Carver", 5f, 10));
		bList.add(new Flear ("Daniel", 3f, 7));
		
		FlearValue fV = new FlearValue();
		//System.out.println(fV.getOptimalValue(10, fList));
		
		FlearValueBruteForce bf = new FlearValueBruteForce();
		System.out.println(bf.getOptimalValue(5, bList));

		
	}

}
