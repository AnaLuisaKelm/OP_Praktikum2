package business;

//import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import observer.Observable;
import observer.Observer;
import readers.ConcreteReaderCreator;
import readers.ReaderCreator;
import readers.ReaderProduct;

public class TeeladenModel implements Observable{
	
	private static TeeladenModel teeladenModel;
	private Tee tee;
	private ArrayList<Tee> teeladen = new ArrayList<Tee>();
	ArrayList<Observer> observers = new ArrayList<Observer>();

	private TeeladenModel() {
		
	}
	
	public void setTee(Tee tee) {
		this.tee = tee;
	}
	
	public Tee getTee() {
		return this.tee;
	}
	
	public ArrayList<Tee> getTeeladen(){
		return teeladen;
	}
	
	
	public static TeeladenModel getInstance() {
		if(teeladenModel == null) {
			teeladenModel = new TeeladenModel();
		}
		
		return teeladenModel;
	}
	
	public void schreibeTeeladenInCsvDatei() throws IOException {
		
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("TeeladenAusgabe.csv", true));
			aus.write(tee.gibTeeZurueck(';'));
			aus.close();	 
	}
	
	public void schreibeTeeladenInTxtDatei() throws IOException {

		BufferedWriter aus 
		= new BufferedWriter(new FileWriter("TeeladenAusgabe.txt", true));
		aus.write(tee.gibTeeZurueck('\n'));
		aus.close();
	}
	
	public void leseAusDatei(String typ) throws IOException {
		
		ReaderCreator readerCreator = new ConcreteReaderCreator();
		ReaderProduct reader = readerCreator.factoryMethod(typ);
		
		String[] zeile = reader.leseAusDatei();
		Tee tee = new Tee(
              Integer.parseInt(zeile[0]),
              zeile[1],                 
              zeile[2],                
              zeile[3],                  
              zeile[4].split("_")        
          );
         
          this.tee = tee; 
          teeladen.add(tee);
          reader.schliesseDatei();
		
//		if(typ.equals("csv") {
//				ReaderCreator readerCreator = new ConcreteCsvReaderCreator();
//		 		ReaderProduct reader = readerCreator.factoryMethod();
//				
//		 	    String[] zeile = reader.leseAusDatei();
//                Tee tee = new Tee(
//                    Integer.parseInt(zeile[0]),
//                    zeile[1],                 
//                    zeile[2],                
//                    zeile[3],                  
//                    zeile[4].split("_")        
//                );
//               
//                this.tee = tee; 
//                reader.schliesseDatei();
//           }
//				
//		 else if(typ.equals("txt") {
//				ReaderCreator readerCreator = new ConcreteTxtReaderCreator();
//		 		ReaderProduct reader = readerCreator.factoryMethod();
//		 		
//		 		String[] zeile = reader.leseAusDatei();
//                Tee tee = new Tee(
//                    Integer.parseInt(zeile[0]),
//                    zeile[1],                 
//                    zeile[2],                
//                    zeile[3],                  
//                    zeile[4].split("_")        
//                );
//               
//                this.tee = tee; 
//                reader.schliesseDatei();
//		 }
		
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);		
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers) {
			o.update();
		}
	}
	
//	public void leseTeeladenAusCsvDatei() throws IOException {
//		
//		ReaderCreator readerCreator = new ConcreteCsvReaderCreator();
//		ReaderProduct reader = readerCreator.factoryMethod();
//		reader.leseAusDatei();
//		
//		reader.schliesseDatei();
//	}


}
