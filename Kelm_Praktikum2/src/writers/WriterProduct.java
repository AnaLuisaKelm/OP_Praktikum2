package writers;

import java.io.IOException;

import business.Tee;

public abstract class WriterProduct {
	public abstract void schreibeTeeladenInDatei(Tee tee) throws IOException;
}
