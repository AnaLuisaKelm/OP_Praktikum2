package writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Tee;

public class ConcreteCsvWriterProduct extends WriterProduct{

	@Override
	public void schreibeTeeladenInDatei(Tee tee) throws IOException {
		BufferedWriter aus 
		= new BufferedWriter(new FileWriter("TeeladenAusgabe.csv", true));
			aus.write(tee.gibTeeZurueck(';'));
			aus.close();
	
	}		
}
