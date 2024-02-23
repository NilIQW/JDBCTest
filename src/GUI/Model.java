package GUI;

import BLL.Logic;
import javafx.collections.ObservableList;

public class Model {
    Logic logic = new Logic();

    public ObservableList employeeList(){
        return logic.employeeList();
    }
}
