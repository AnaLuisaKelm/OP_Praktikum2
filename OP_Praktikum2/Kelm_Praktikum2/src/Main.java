

import guiGetraenkeLaeden.GetraenkeLaedenControl;
import guiTeeladen.TeeladenControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new TeeladenControl(primaryStage);
		
		Stage fensterGetraenkeLaeden = new Stage();
		new GetraenkeLaedenControl(fensterGetraenkeLaeden);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
