package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {
	
	public void run() {
		Model model = new Model();
		
		List<String> anagrammi = new ArrayList<String>();
		
		anagrammi = model.getAnagrammiGiusti("eat");
		
		for(String a : anagrammi) {
			System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestModel main = new TestModel();
		main.run();
	}

}
