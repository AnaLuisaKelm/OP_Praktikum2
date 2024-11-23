package writers;

public class ConcreteCsvWriterCreator extends WriterCreator{

	@Override
	public WriterProduct factoryMethod() {
		return new ConcreteCsvWriterProduct();
	}

}
