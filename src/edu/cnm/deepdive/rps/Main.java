package edu.cnm.deepdive.rps;

import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  private static final String LAYOUT_RESOURCE = "rps.fxml";
  private static final String RESOURCE_BUNDLE = "strings";
  private static final String WINDOW_TITLE_KEY = "window_title";

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    ClassLoader classLoader = getClass().getClassLoader();
    ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_BUNDLE);
    FXMLLoader fxmlLoader = new FXMLLoader(classLoader.getResource(LAYOUT_RESOURCE), bundle);
    Parent root = fxmlLoader.load();
    // TODO Get reference to controller.
    Scene scene = new Scene(root);
    stage.setTitle(bundle.getString(WINDOW_TITLE_KEY));
    // TODO Load icons.
    stage.setResizable(false);
    stage.setScene(scene);
    stage.show();
  }

}
