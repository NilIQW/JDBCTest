package BE;

public class Employee {
    private int Id;
    private String Name;
    private double Salary;
    private boolean OnLeave;
    private String PhoneNumber;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public boolean isOnLeave() {
        return OnLeave;
    }

    public void setOnLeave(boolean onLeave) {
        OnLeave = onLeave;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Salary=" + Salary +
                ", OnLeave=" + OnLeave +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
}
