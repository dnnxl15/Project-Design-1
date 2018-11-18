package userInterface;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller 
{
	
	/**
	 * Method open view 
	 * Author: Danny Xie Li
	 * Description: The next method open view window.
	 * Last modification: 08/10/18
	 */
	public void openWindow(String pNameWindow) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource(pNameWindow));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));  
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
	}

	/**
	 * Method close view product
	 * Author: Danny Xie Li
	 * Description: The next method close view product window to watch the products.
	 * Last modification: 08/10/18
	 */
	public void closeWindow(Button pEvidence)
	{
        Stage thisStage = (Stage) pEvidence.getScene().getWindow();
        thisStage.close();
	}
	
	/**
	 * Method show alert
	 * Author: Danny Xie Li
	 * Description: The next method show alert.
	 * Last modification: 08/10/18
	 */
	public void showAlert(AlertType pType, String pHeader, String pContent)
	{
        Alert alert = new Alert(pType);
		alert.setHeaderText(pHeader);
		alert.setContentText(pContent);
		alert.showAndWait();
	}
}