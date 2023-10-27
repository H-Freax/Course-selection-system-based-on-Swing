package Business.Directory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Business.Person.Employee;
import Business.Person.Person;
import Tools.MySQLConnectionUtil;

public class EmployeeDirectory {
    private ArrayList<Employee> employeeList;
    private Connection connection; // 数据库连接

    public EmployeeDirectory() {
        this.connection = MySQLConnectionUtil.getConnection();
        this.employeeList = new ArrayList<>();
        loadEmployeesFromDatabase();
    }


    // 从数据库加载Employee对象
    public void loadEmployeesFromDatabase() {
        try {
            String selectQuery = "SELECT * FROM Employee ";
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String personID = resultSet.getString("id");
                String username = resultSet.getString("username");
                String passwordHash = resultSet.getString("nowpassword");
                boolean enabled = resultSet.getString("enabled").equals("1");
                Person p = Person.loadFromDatabase(connection, personID);
                // 创建Employee对象并添加到employeeList
                Employee employee = new Employee(p.getPersonName(), personID, username, "", enabled, "employee");
                employee.setPwdHash(passwordHash);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // 处理数据库查询异常
        }
    }

    // 添加Employee对象到集合和数据库
    public void addEmployee(Employee employee) {
        // 向employeeList中添加Employee对象
        employeeList.add(employee);

        try {
            // 将Employee对象保存到数据库
            employee.saveToDatabase(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            // 处理保存到数据库的异常
        }
    }

    // 从集合和数据库删除Employee对象
    public void removeEmployee(Employee employee) {
        // 从employeeList中删除Employee对象
        employeeList.remove(employee);

        try {
            // 从数据库中删除Employee记录
            String deleteQuery = "DELETE FROM Employee WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.setString(1, employee.getPersonID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // 处理从数据库删除的异常
        }
    }

    // 更新Employee对象到集合和数据库
    public void updateEmployee(Employee employee) {
        try {
            // 更新Employee对象到数据库
            employee.updateEmployeeInDatabase(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            // 处理更新到数据库的异常
        }
    }

    public Employee findEmployeeByUsername(String username) {
        for (Employee employee : employeeList) {
            if (employee.getUsername().equals(username)) {
                return employee;
            }
        }

        return null;
    }
    // 根据PersonID查询Employee对象
    public Employee findEmployeeByID(String personID) {
        for (Employee employee : employeeList) {
            if (employee.getPersonID().equals(personID)) {
                return employee;
            }
        }

        return null;
    }

    // 获取所有Employee对象
    public ArrayList<Employee> getAllEmployees() {
        return employeeList;
    }
}
