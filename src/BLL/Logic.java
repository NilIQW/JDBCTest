package BLL;

import DAL.EmployeeDAO;
import javafx.collections.ObservableList;

public class Logic {
    private EmployeeDAO employeeDao = new EmployeeDAO();

    public ObservableList employeeList(){
        return employeeDao.getEmployeeList();

    }
}
