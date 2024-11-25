package readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ConcreteCsvReaderProduct extends ReaderProduct{
	
	private BufferedReader ein;

	public ConcreteCsvReaderProduct() {
		
		try {
			ein = new BufferedReader(new FileReader("Teeladen.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	@Override
	public String[] leseAusDatei() throws IOException {
		
	        String line;
	        String[] records = new String[5];
	        if ((line = ein.readLine()) != null) {
	            records = line.split(";");
	        }
	        
	        return records;
	}
	
	public void schliesseDatei() throws IOException {
		ein.close();
	}

}
