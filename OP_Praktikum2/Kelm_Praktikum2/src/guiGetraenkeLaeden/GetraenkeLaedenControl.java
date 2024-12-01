package guiGetraenkeLaeden;

import business.TeeladenModel;
import javafx.stage.Stage;
import observer.Observer;

public class GetraenkeLaedenControl implements Observer{
	
	private GetraenkeLaedenView getraenkeLaedenView;
	private TeeladenModel teeladenModel;
	
	public GetraenkeLaedenControl(Stage primaryStage) {
		this.teeladenModel = TeeladenModel.getInstance();
		this.getraenkeLaedenView = new GetraenkeLaedenView(this, primaryStage, teeladenModel);
		teeladenModel.addObserver(this);
	}

	@Override
	public void update() {
		getraenkeLaedenView.zeigeGetraenkeLaedenAn();
	}

}
