package GUI;

import BE.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.util.*;

public class ViewController implements Initializable {
    @FXML
    private TableColumn idColumn;
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn salaryColumn;
    @FXML
    private TableColumn onLeaveColumn;
    @FXML
    private TableColumn phoneNumberColumn;
    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TextField searchField;

    Model model = new Model();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeColumns();

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filterEmployees(newValue); // Call filterMovies method whenever the text changes
        });

        //deleteField.textProperty().addListener((observable, oldValue, newValue) -> {
        //    deleteId(newValue); // Call filterMovies method whenever the text changes
        //});

        employeeTable.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.BACK_SPACE && !employeeTable.getSelectionModel().isEmpty()) {
                handleDeleteAction();
            }
        });
    }

    private void handleDeleteAction() {
        Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
        model.deleteEmployee(selectedEmployee.getId());
        employeeTable.getItems().clear();
        employeeTable.setItems(model.employeeList());
    }

    private void initializeColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        onLeaveColumn.setCellValueFactory(new PropertyValueFactory<>("onLeave"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        employeeTable.setItems(model.employeeList());
    }


    private void filterEmployees(String searchTerm) {
        List<Employee> allEmployees = model.employeeList();

        Set<Integer> addedEmployeeIds = new HashSet<>();

        List<Employee> filteredEmployees = new ArrayList<>();

        for (Employee employee : allEmployees) {
            if (String.valueOf(employee.getId()).toLowerCase().trim().contains(String.valueOf(searchTerm).toLowerCase().trim())
                    || employee.getName().toLowerCase().trim().contains(searchTerm.toLowerCase().trim())
                    || String.valueOf(employee.getSalary()).toLowerCase().trim().contains(searchTerm.toLowerCase().trim())
                    || String.valueOf(employee.getPhoneNumber()).toLowerCase().trim().contains(searchTerm.toLowerCase().trim())) {
                if (!addedEmployeeIds.contains(employee.getId())) {
                    filteredEmployees.add(employee);
                    addedEmployeeIds.add(employee.getId());
                }

            }
        }

        ObservableList<Employee> observableFiltered = FXCollections.observableArrayList(filteredEmployees);

        employeeTable.setItems(observableFiltered);


    }


    //public void deleteId(String deleteTerm) {
    //    List<Employee> allEmployees = model.employeeList();
    //    Set<Integer> addedEmployeeIds = new HashSet<>();
//
    //    List<Employee> filterEmployeesById = new ArrayList<>();
    //    for (Employee employee : allEmployees) {
    //        if (String.valueOf(employee.getId()).toLowerCase().trim().contains(String.valueOf(deleteTerm).toLowerCase().trim())) {
    //            if(!addedEmployeeIds.contains(employee.getId())){
    //                filterEmployeesById.add(employee);
    //                addedEmployeeIds.add(employee.getId());
    //            }
    //        }
    //    }
    //    ObservableList<Employee> observableFilteredId = FXCollections.observableArrayList(filterEmployeesById);
//
    //    employeeTable.setItems(observableFilteredId);
    //}
}

