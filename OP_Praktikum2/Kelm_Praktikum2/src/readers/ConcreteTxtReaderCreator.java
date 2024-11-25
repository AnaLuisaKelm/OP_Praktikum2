package readers;

import java.io.BufferedReader;

public class ConcreteTxtReaderCreator extends ReaderCreator {

	@Override
	public ReaderProduct factoryMethod(BufferedReader ein) {
		
		return new ConcreteTxtReaderProduct(ein);
	}

}
