package readers;
import java.io.BufferedReader;

public class ConcreteCsvReaderCreator extends ReaderCreator{
	
	@Override
	public ReaderProduct factoryMethod(BufferedReader ein) {
		
		return new ConcreteCsvReaderProduct(ein);
		
	}

}
