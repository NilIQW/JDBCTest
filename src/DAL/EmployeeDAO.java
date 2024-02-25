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


    public ObservableList<Employee> getEmployeeList() {
        ObservableList<Employee> employeeList = FXCollections.observableArrayList();

        try {

            java.sql.Connection con = connection.getConnection();

            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM EMPLOYEE");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");
                boolean onLeave = rs.getBoolean("OnLeave");
                String phoneNumber = rs.getString("PhoneNumber");

                Employee employee = new Employee(name, salary, onLeave, phoneNumber);
                employee.setId(id);
                employeeList.add(employee);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return employeeList;
    }

    public void createEmployee(Employee em) {
        try {
            java.sql.Connection con = connection.getConnection();

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Employee (name, salary, onLeave, phoneNumber) VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, em.getName());
            pstmt.setDouble(2, em.getSalary());
            pstmt.setBoolean(3, em.isOnLeave());
            pstmt.setString(4, em.getPhoneNumber());
            pstmt.execute();
            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) {
                    long generatedKey = keys.getLong(1);
                    em.setId((int) generatedKey);
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


        public void deleteEmployee(int Id){
            try {
                java.sql.Connection con = connection.getConnection();

                PreparedStatement pstmt = con.prepareStatement("DELETE FROM Employee WHERE id = ?");
                pstmt.setInt(1, Id);
                pstmt.executeUpdate();


            } catch (SQLServerException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

}
