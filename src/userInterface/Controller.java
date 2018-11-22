package userInterface;

import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import library.IConstant;

public class Controller implements IConstant
{
	
	/**
	 * Method open view 
	 * Author: Danny Xie Li
	 * Description: The next method open view window.
	 * Last modification: 08/10/18
	 */
	public void openWindow(String pNameWindow, int pHeight, int pWidth, String pIcon, String pTitle) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource(pNameWindow));
        Stage stage = new Stage();
        stage.setScene(new Scene(root, pHeight, pWidth));  
        stage.setResizable(false);
        stage.initStyle(StageStyle.DECORATED);
        stage.getIcons().add(new Image(pIcon));
        stage.setTitle(pTitle);
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
	public boolean showAlert(AlertType pType, String pHeader, String pContent)
	{
        Alert alert = new Alert(pType);
		alert.setHeaderText(pHeader);
		alert.setContentText(pContent);
		alert.setTitle(CONFIRMATION);
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get() == ButtonType.OK)
		{
			return true;
		}
		else if(result.get() == ButtonType.CANCEL)
		{
			return false;
		}
		return false;
	}
}