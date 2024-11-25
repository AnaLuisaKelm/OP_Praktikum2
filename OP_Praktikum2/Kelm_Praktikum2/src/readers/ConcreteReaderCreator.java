package readers;

public class ConcreteReaderCreator extends ReaderCreator{
	
	@Override
	public ReaderProduct factoryMethod(String typ) {
		
		if(typ.equals("csv")) {
			return new ConcreteCsvReaderProduct();
		} else  {
			return new ConcreteTxtReaderProduct();
		}	
	}

}
