package DAL;

import BE.Employee;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAO {
    private final Connection connection;

    public EmployeeDAO() {
        this.connection = new Connection();
    }

    ObservableList<Employee> employeeList = FXCollections.observableArrayList();

    public ObservableList<Employee> getEmployeeList() {
        try {

            java.sql.Connection con = connection.getConnection(); // You must do figure this out, this won't work. Look at previous projects

            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM EMPLOYEE");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("Id"));
                employee.setName(rs.getString("Name"));
                employee.setSalary(rs.getDouble("Salary"));
                employee.setOnLeave(rs.getBoolean("OnLeave"));
                employee.setPhoneNumber(rs.getString("PhoneNumber"));
                employeeList.add(employee);
            }

        } catch (SQLServerException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return employeeList;
    }

    public void deleteEmployee(int Id) {
        try {
            java.sql.Connection con = connection.getConnection();

            PreparedStatement pstmt = con.prepareStatement("DELETE FROM Employee WHERE Id = ?");
            pstmt.setInt(1, Id);
            pstmt.executeUpdate();


        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
