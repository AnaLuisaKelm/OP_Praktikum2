package guiGetraenkeLaeden;


import business.TeeladenModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;


public class GetraenkeLaedenView {
	//---Anfang Attribute der grafischen Oberflaeche---
	private TeeladenModel teeladenModel;
	private GetraenkeLaedenControl getraenkeLaedenControl;
	
	private Pane pane = new  Pane();
	private Label lblAnzeigeGetraenkeLaeden   = new Label("Anzeige Getraenkelaeden");
	private TextArea txtAnzeigeGetraenkeLaeden  = new TextArea();
	private Button btnAnzeigeGetraenkeLaeden = new Button("Anzeige");
	//-------Ende Attribute der grafischen Oberflaeche-------

	public GetraenkeLaedenView(GetraenkeLaedenControl getraenkeLaedenControl,Stage primaryStage, TeeladenModel teeladenModel ){
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von st�dtischen " 
			+ "Einrichtungen");
		primaryStage.show();
		this.getraenkeLaedenControl = getraenkeLaedenControl;
	   	this.teeladenModel = teeladenModel;
    	this.initKomponenten();
    	this.initListener();
	}

	private void initKomponenten(){
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeGetraenkeLaeden.setLayoutX(310);
		lblAnzeigeGetraenkeLaeden.setLayoutY(40);
		lblAnzeigeGetraenkeLaeden.setFont(font);
		lblAnzeigeGetraenkeLaeden.setStyle("-fx-font-weight: bold;"); 
   	pane.getChildren().add(lblAnzeigeGetraenkeLaeden);    
    	


//Textbereich	
    	txtAnzeigeGetraenkeLaeden.setEditable(false);
 		txtAnzeigeGetraenkeLaeden.setLayoutX(310);
		txtAnzeigeGetraenkeLaeden.setLayoutY(90);
 		txtAnzeigeGetraenkeLaeden.setPrefWidth(220);
		txtAnzeigeGetraenkeLaeden.setPrefHeight(185);
   	pane.getChildren().add(txtAnzeigeGetraenkeLaeden);        	
    	// Button
      	btnAnzeigeGetraenkeLaeden.setLayoutX(310);
    	btnAnzeigeGetraenkeLaeden.setLayoutY(290);
    	pane.getChildren().add(btnAnzeigeGetraenkeLaeden); 
}

	private void initListener() {
	    btnAnzeigeGetraenkeLaeden.setOnAction(
				new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeGetraenkeLaedenAn();
	        	} 
		    });
	}

	public void zeigeGetraenkeLaedenAn(){
			if(teeladenModel.getTeeladen().size() > 0){
				//txtAnzeigeGetraenkeLaeden.setText(buergerameterModel.getBuergeramte().gibBuergeramtZurueck(' '));
				StringBuffer text = new StringBuffer();
				
				teeladenModel.getTeeladen().forEach(Tee -> text.append(Tee.gibTeeZurueck(' ') + "\n"));
				txtAnzeigeGetraenkeLaeden.setText(text.toString());
			}
			else{
				zeigeInformationsfensterAn("Bisher wurde kein Getränkeladen aufgenommen!");
			}
	}	

	private void zeigeInformationsfensterAn(String meldung){
		  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
	           	"Information", meldung).zeigeMeldungsfensterAn();
	}	



}
