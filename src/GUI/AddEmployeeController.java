package GUI;

import BE.Employee;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddEmployeeController implements Initializable {
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField salaryField;
    @FXML
    private TextField nameField;
    @FXML
    private ChoiceBox<Boolean> onLeaveChoicebox;
    private Model model;

    @FXML
    private TableView<Employee> employeeTable;
    public void setModel(Model model) {
        this.model = model;
    }
    public AddEmployeeController() {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = Model.getInstance();
        onLeaveChoicebox.getItems().addAll(true, false);
        onLeaveChoicebox.setValue(false);

    }
    public void setEmployeeTable(TableView<Employee> employeeTable) {
        this.employeeTable = employeeTable;
    }
    public AddEmployeeController(Model model) {
        this.model = model;
    }

    public void addEmployee(ActionEvent actionEvent) {
        double salary = Double.parseDouble(salaryField.getText());
        boolean onLeave = onLeaveChoicebox.getValue();

        Employee e = new Employee(nameField.getText(), salary, onLeaveChoicebox.getValue(), phoneNumberField.getText());
        model.createEmployee(e);

         clearFields();
        refreshTableView();


        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    private void refreshTableView() {
        if (employeeTable != null) {
            ObservableList<Employee> employeeList = model.employeeList();
            employeeTable.getItems().clear();
            employeeTable.setItems(employeeList);
        } else {
            System.out.println("Error: TableView instance is null.");
        }
    }

    private void clearFields() {
        nameField.clear();
        salaryField.clear();
        phoneNumberField.clear();
        // You may also want to reset the choice box to its default value
        onLeaveChoicebox.setValue(false);
    }



    public void cancel(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
