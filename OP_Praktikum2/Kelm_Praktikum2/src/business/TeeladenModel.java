package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import readers.ConcreteReaderCreator;
import readers.ReaderCreator;
import readers.ReaderProduct;

public class TeeladenModel {
	
	private Tee tee;
	
	public void setTee(Tee tee) {
		this.tee = tee;
	}
	
	public Tee getTee() {
		return this.tee;
	}
	
	public TeeladenModel() {
		
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
	
//	public void leseTeeladenAusCsvDatei() throws IOException {
//		
//		ReaderCreator readerCreator = new ConcreteCsvReaderCreator();
//		ReaderProduct reader = readerCreator.factoryMethod();
//		reader.leseAusDatei();
//		
//		reader.schliesseDatei();
//	}


}
