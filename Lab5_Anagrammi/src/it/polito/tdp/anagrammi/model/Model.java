package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	private List<String> anagrammiGiusti;
	private List<String> anagrammiErrati;
	
	private List<String> anagrammi;
	
	private String parziale;
	
	private AnagrammaDAO anagrammaDAO = new AnagrammaDAO();
	
	public Model() {
		anagrammiGiusti = new ArrayList<String>();
		anagrammiErrati = new ArrayList<String>();
		anagrammi = new ArrayList<String>();
		parziale = "";
	}
	
	public List<String> getAnagrammiGiusti(String parola) {

		this.recursive(parola, parziale, 0);
		
		for(String s : anagrammi) {
			if(anagrammaDAO.isCorrect(s)==true) {
				anagrammiGiusti.add(s);
			}
			else {
				anagrammiErrati.add(s);
			}
		}
		
		return anagrammiGiusti;
	}
	
	public List<String> getAnagrammiErrati() {
		
		return anagrammiErrati;
	}
	
	
	private void recursive(String parola, String parziale, int livello) {
		
		if(livello == parola.length()) {
			anagrammi.add(parziale);
			return;
		}	
		
		for(int i = 0; i < parola.length(); i++) {
			
			if(this.conta(parola.charAt(i), parola) > this.conta(parola.charAt(i), parziale)) {
				parziale += parola.charAt(i);
				
				this.recursive(parola, parziale, livello+1);
				
				parziale =  parziale.substring(0, parziale.length()-1);	
			}
			
		}
		
	}
	

	public int conta(Character prova, String parola) {
		
		int contatore = 0; 
		
		for(int i = 0 ; i < parola.length(); i++) {
			if(prova.equals(parola.charAt(i))) {
				contatore++;
			}
		}
		
		return contatore;
	}


	public String stampa(List<String> anagrammi) {
		String result = "";
		for(String s : anagrammi) {
			result += s+"\n";
		}
		return result;
	}
	
	public void pulisci() {
		anagrammiErrati.clear();
		anagrammiGiusti.clear();
		anagrammi.clear();
	}
	
}
