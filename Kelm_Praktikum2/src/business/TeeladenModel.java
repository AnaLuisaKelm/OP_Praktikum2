package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
		// WriterCreator writerCreator = new ConcreteCsvWriterCreator();
		// WriterProduct writer = writerCreator.factoryMethod();
		// writer.schreibeTeeladenInCsvDatei();
		
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("TeeladenAusgabe.csv", true));
			aus.write(tee.gibTeeZurueck(';'));
			aus.close();	 
	}
	
	public void schreibeTeeladenInTxtDatei() throws IOException {
		// WriterCreator writerCreator = new ConcreteTxtWriterCreator();
		// WriterProduct writer = writerCreator.factoryMethod();
		// writer.schreibeTeeladenInCsvDatei();
		
		BufferedWriter aus 
		= new BufferedWriter(new FileWriter("TeeladenAusgabe.txt", true));
		aus.write(tee.gibTeeZurueck('\n'));
		aus.close();
	}
	
	public void leseAusDatei(String typ) throws IOException {
		// if(typ.equals("csv") {
		//		ReaderCreator readerCreator = new ConcreteCsvReaderCreator();
		// 		ReaderProduct reader = readerCreator.factoryMethod();
		//		reader.leseAusDatei();
		// else if(typ.equals("txt") {
		//		ReaderCreator readerCreator = new ConcreteTxtReaderCreator();
		// 		ReaderProduct reader = readerCreator.factoryMethod();
		//		reader.leseAusDatei();
		// }
		
	    if ("csv".equals(typ)) {
	        BufferedReader ein = new BufferedReader(new FileReader("Teeladen.csv"));
	        String line;
	        if ((line = ein.readLine()) != null) {
	            String[] records = line.split(";");
	            for (String record : records) {
	                String[] zeile = record.split("_");
	                Tee tee = new Tee(
	                    Integer.parseInt(zeile[0]),
	                    zeile[1],                 
	                    zeile[2],                
	                    zeile[3],                  
	                    zeile[4].split("_")        
	                );
	               
	                this.tee = tee; 
	            }
	        }
	        ein.close();
	    }
	}


}
