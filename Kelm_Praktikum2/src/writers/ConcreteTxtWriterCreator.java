package writers;

public class ConcreteTxtWriterCreator extends WriterCreator{

	@Override
	public WriterProduct factoryMethod() {
		return new ConcreteTxtWriterProduct();
	}

}
