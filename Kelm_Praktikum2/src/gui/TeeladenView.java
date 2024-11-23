package gui;

import business.TeeladenModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class TeeladenView {
	
	private TeeladenModel model;
	private TeeladenControl control;
	
	 //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblArtikelnummer 					= new Label("Artikelnummer:");
    private Label lblBezeichnung   		= new Label("Bezeichnung");
    private Label lblKategorie  	 		= new Label("Kategorie");
    private Label lblmitKoffein   			= new Label("Mit Koffein");
    private Label lblEnthalteneKraeuter  		= new Label("Enthaltene Kraeuter:");
    private TextField txtArtikelnummer 	 			= new TextField(); 
	private TextField txtBezeichnung		= new TextField();
    private TextField txtKategorie		= new TextField();
    private TextField txtmitKoffein			= new TextField();
    private TextField txtEnthalteneKraeuter	= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    public String getTxtArtikelnummer() {
  		return txtArtikelnummer.getText();
  	}

  	public String getTxtBezeichnung() {
  		return txtBezeichnung.getText();
  	}

  	public String getTxtKategorie() {
  		return txtKategorie.getText();
  	}

  	public String getTxtmitKoffein() {
  		return txtmitKoffein.getText();
  	}

  	public String getTxtEnthalteneKraeuter() {
  		return txtEnthalteneKraeuter.getText();
  	}

    
   
	public TeeladenView(Stage primaryStage, TeeladenControl control, TeeladenModel model) {
		this.control = control;
		this.model = model;
		
		Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung vom Teeladen");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
		
	}
	
	 private void initKomponenten(){
	       	// Labels
	    	lblEingabe.setLayoutX(20);
	    	lblEingabe.setLayoutY(40);
	    	Font font = new Font("Arial", 24); 
	    	lblEingabe.setFont(font);
	    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
	    	lblAnzeige.setLayoutX(400);
	    	lblAnzeige.setLayoutY(40);
	      	lblAnzeige.setFont(font);
	       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
	       	lblArtikelnummer.setLayoutX(20);
	    	lblArtikelnummer.setLayoutY(90);
	    	lblBezeichnung.setLayoutX(20);
	    	lblBezeichnung.setLayoutY(130);
	    	lblKategorie.setLayoutX(20);
	    	lblKategorie.setLayoutY(170);
	    	lblmitKoffein.setLayoutX(20);
	    	lblmitKoffein.setLayoutY(210);
	    	lblEnthalteneKraeuter.setLayoutX(20);
	    	lblEnthalteneKraeuter.setLayoutY(250);    	
	       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
	       		lblArtikelnummer, lblBezeichnung, lblKategorie,
	       		lblmitKoffein, lblEnthalteneKraeuter);
	    
	    	// Textfelder
	     	txtArtikelnummer.setLayoutX(170);
	    	txtArtikelnummer.setLayoutY(90);
	    	txtArtikelnummer.setPrefWidth(200);
	    	txtBezeichnung.setLayoutX(170);
	    	txtBezeichnung.setLayoutY(130);
	    	txtBezeichnung.setPrefWidth(200);
	    	txtKategorie.setLayoutX(170);
	    	txtKategorie.setLayoutY(170);
	    	txtKategorie.setPrefWidth(200);
	      	txtmitKoffein.setLayoutX(170);
	    	txtmitKoffein.setLayoutY(210);
	    	txtmitKoffein.setPrefWidth(200);
	    	txtEnthalteneKraeuter.setLayoutX(170);
	    	txtEnthalteneKraeuter.setLayoutY(250);
	    	txtEnthalteneKraeuter.setPrefWidth(200);
	      	pane.getChildren().addAll( 
	     		txtArtikelnummer, txtBezeichnung, txtKategorie,
	     		txtmitKoffein, txtEnthalteneKraeuter);
	     	
	        // Textbereich	
	        txtAnzeige.setEditable(false);
	     	txtAnzeige.setLayoutX(400);
	    	txtAnzeige.setLayoutY(90);
	     	txtAnzeige.setPrefWidth(270);
	    	txtAnzeige.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeige); 
	       	
	        // Buttons
	        btnEingabe.setLayoutX(20);
	        btnEingabe.setLayoutY(290);
	        btnAnzeige.setLayoutX(400);
	        btnAnzeige.setLayoutY(290);
	        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
	        
	 		// Menue
	  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
	  	    this.mnDatei.getItems().add(mnItmCsvImport);
	  	    this.mnDatei.getItems().add(mnItmTxtImport);
	  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
	  	    this.mnDatei.getItems().add(mnItmCsvExport);
	 	    pane.getChildren().add(mnbrMenuLeiste);
	   }
	   
	   private void initListener() {
		    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	        	    control.nehmeTeeAuf();
	            }
		    });
		    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		            zeigeTeeladenAn();
		        } 
	   	    });
		    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		       	 	control.leseAusDatei("csv");
		    	}
		    });
		    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
			    public void handle(ActionEvent e) {
			     	control.leseAusDatei("txt");
			    }
	    	});
		    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					control.schreibeTeeladenInCsvDatei();
				}	
		    });
	    }
	   
	   private void zeigeTeeladenAn(){
	    	if(this.model.getTee() != null){
	    		txtAnzeige.setText(
	    			this.model.getTee().gibTeeZurueck(' '));
	    	}
	    	else{
	    		zeigeInformationsfensterAn("Bisher wurde kein Tee aufgenommen!");
	    	}
	    }    
	   
	   void zeigeInformationsfensterAn(String meldung){
	    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
	    		"Information", meldung).zeigeMeldungsfensterAn();
	    }	
	    
	    void zeigeFehlermeldungsfensterAn(String meldung){
	       	new MeldungsfensterAnzeiger(AlertType.ERROR,
	        	"Fehler", meldung).zeigeMeldungsfensterAn(); 
	    }

}
