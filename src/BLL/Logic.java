package BLL;

import BE.Employee;
import DAL.EmployeeDAO;
import javafx.collections.ObservableList;

public class Logic {
    private EmployeeDAO employeeDao = new EmployeeDAO();

    public ObservableList employeeList(){
        return employeeDao.getEmployeeList();
    }
    public void createEmployee(Employee em){
        employeeDao.createEmployee(em);
    }

    public void deleteEmployee(int Id){
        employeeDao.deleteEmployee(Id);
    }
}
