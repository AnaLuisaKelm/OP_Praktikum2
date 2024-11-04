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
		return tee;
	}
	
	public TeeladenModel() {
		
	}
	
	public void schreibeTeeladenInCsvDatei() throws IOException {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("TeeladenAusgabe.csv", true));
			aus.write(tee.gibTeeZurueck(';'));
			aus.close();	 
	}
	
	public void leseAusDatei(String typ) throws IOException{
      	if("csv".equals(typ)){
      		BufferedReader ein = new BufferedReader(new FileReader("Teeladen.csv"));
      		String[] zeile = ein.readLine().split(";");
      			this.tee = (new Tee(Integer.parseInt(zeile[0]), 
      				zeile[1], 
      				zeile[2], 
      				zeile[3], zeile[4].split("_")));
      				ein.close();
      		}

	}

}
