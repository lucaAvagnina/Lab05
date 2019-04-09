package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcolaAnagramma;

    @FXML
    private TextArea txtCorretto;

    @FXML
    private TextArea txtErrato;

    @FXML
    private Button btnReset;

	private Model model;

    @FXML
    void doCalcolaAnagramma(ActionEvent event) {
    	
    	txtErrato.clear();
    	txtCorretto.clear();
    	model.pulisci();
    	
    	String parolaInserita = txtParola.getText();
    	
    	parolaInserita = parolaInserita.toLowerCase();
		if(parolaInserita.matches("[a-zA-Z]+")) {
			txtCorretto.setText(model.stampa(model.getAnagrammiGiusti(parolaInserita)));
			txtErrato.setText((model.stampa(model.getAnagrammiErrati())));
		}
		else {
			txtErrato.setText("La parola inserita è errata!");
		}
    	
    	
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtCorretto.clear();
    	txtErrato.clear();
    	model.pulisci();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcolaAnagramma != null : "fx:id=\"btnCalcolaAnagramma\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorretto != null : "fx:id=\"txtCorretto\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtErrato != null : "fx:id=\"txtErrato\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    
	public void setModel(Model model) {
		this.model = model;
	}
}
