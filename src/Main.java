import GUI.AddEmployeeController;
import GUI.Model;
import GUI.ViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("./GUI/View.fxml"));
        Parent root = loader.load();
        ViewController viewController = loader.getController();
        Model model = Model.getInstance();
        AddEmployeeController addEmployeeController = new AddEmployeeController(model);
        addEmployeeController.setEmployeeTable(viewController.getEmployeeTable());


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}