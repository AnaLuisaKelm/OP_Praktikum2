package gui;

import java.io.IOException;

import business.Tee;
import business.TeeladenModel;
import javafx.stage.Stage;

public class TeeladenControl {
	
	private TeeladenView view;
	private TeeladenModel model;
	
	public TeeladenControl(Stage primaryStage) {
		this.model = new TeeladenModel();
		this.view = new TeeladenView(primaryStage, this, this.model);
		
	}
	
	void nehmeTeeAuf(){
    	try{
    		this.model.setTee(new Tee(
    			Integer.parseInt(view.getTxtArtikelnummer()), 
   	            view.getTxtKategorie(),
   	            view.getTxtBezeichnung(),
    		    view.getTxtmitKoffein(),
    		    view.getTxtEnthalteneKraeuter().split(";")));
    		view.zeigeInformationsfensterAn("Das Tee wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
	
	void leseAusDatei(String typ){
    	try {
      		  this.model.leseAusDatei(typ);
    		
		}catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
			exc.printStackTrace();

		}
	}
	
	void schreibeTeeladenInCsvDatei() {
		try {
			model.schreibeTeeladenInCsvDatei();
		}	
		catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
			exc.printStackTrace();

		}
	}


}
