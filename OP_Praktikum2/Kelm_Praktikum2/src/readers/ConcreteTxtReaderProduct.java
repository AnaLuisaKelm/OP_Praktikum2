package readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteTxtReaderProduct extends ReaderProduct{
	
	private BufferedReader ein;
	
	public ConcreteTxtReaderProduct() {
		try {
			ein = new BufferedReader(new FileReader("Teeladen.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
		
		String[] ergebniszeile = new String[5];
		String zeile = ein.readLine();
		int i = 0;
		while(i < ergebniszeile.length) {
			ergebniszeile[i] = zeile;
			zeile = ein.readLine();
			i++;
		}
		
		return ergebniszeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
	}

}
