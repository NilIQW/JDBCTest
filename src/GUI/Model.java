package GUI;

import BE.Employee;
import BLL.Logic;
import javafx.collections.ObservableList;

public class Model {
    private static Model instance;
    private Logic logic;
    private Model(){
        logic = new Logic();
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public ObservableList employeeList(){
        return logic.employeeList();
    }

    public void deleteEmployee(int Id){
        logic.deleteEmployee(Id);
    }

    public void createEmployee(Employee em){
        logic.createEmployee(em);
    }
}
