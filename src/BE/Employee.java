package BE;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private boolean onLeave;
    private String phoneNumber;

    public Employee(String name, double salary, boolean onLeave, String phoneNumber) {
        this.name = name;
        this.salary = salary;
        this.onLeave = onLeave;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        salary = salary;
    }

    public boolean isOnLeave() {
        return onLeave;
    }

    public void setOnLeave(boolean onLeave) {
        onLeave = onLeave;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", onLeave=" + onLeave +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
