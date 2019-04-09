package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	private Set<String> anagrammiGiusti;
	private Set<String> anagrammiErrati;
	
	private List<String> anagrammi;
	
	private String parziale;
	
	private AnagrammaDAO anagrammaDAO = new AnagrammaDAO();
	
	public Model() {
		anagrammiGiusti = new HashSet<String>();
		anagrammiErrati = new HashSet<String>();
		anagrammi = new ArrayList<String>();
		parziale = "";
	}
	
	public Set<String> getAnagrammiGiusti(String parola) {

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
	
	public Set<String> getAnagrammiErrati() {
		
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


	public String stampa(Set<String> set) {
		String result = "";
		for(String s : set) {
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
