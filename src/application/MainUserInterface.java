package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import library.*;

public class MainUserInterface extends Application implements IConstant 
{
	/**
	 * Attributes of the window
	 */
	private double xOffset;
	private double yOffset;
	
	/**
	 * Method start the application.
	 * Author: Danny Xie Li
	 * Description: The next method open the window.
	 * Created: 01/11/17
	 * Last modification: 01/11/17
	 */
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource(MAIN_WINDOW_UI));
		    Scene scene = new Scene(root);
		    root.setOnMousePressed(new EventHandler<MouseEvent>() 
		    {
	            @Override
	            public void handle(MouseEvent event) 
	            {
	                xOffset = event.getSceneX();
	                yOffset = event.getSceneY();
	            }
	        });
		    primaryStage.initStyle(StageStyle.DECORATED);
			primaryStage.setScene(scene);
			primaryStage.show();
			root.setOnMouseDragged(new EventHandler<MouseEvent>() 
			{
	            @Override
	            public void handle(MouseEvent event) 
	            {
	            	primaryStage.setX(event.getScreenX() - xOffset);
	            	primaryStage.setY(event.getScreenY() - yOffset);
	            }
	        });
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}