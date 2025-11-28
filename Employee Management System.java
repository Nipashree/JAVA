import java.sql.*;
import java.util.Scanner;

public class EmployeeManagementSystem {
    // Database file is named "database.db"
    private static final String DB_URL = "jdbc:sqlite:database.db";

    public static void main(String[] args) {
        createTableIfNotExists();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addEmployee(sc);
                case 2 -> viewAllEmployees();
                case 3 -> searchEmployee(sc);
                case 4 -> deleteEmployee(sc);
                case 5 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Create the employee table if it doesn't exist
    private static void createTableIfNotExists() {
        String sql = """
            CREATE TABLE IF NOT EXISTS employees (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                position TEXT NOT NULL,
                salary REAL NOT NULL
            );
        """;

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    // Add a new employee
    private static void addEmployee(Scanner sc) {
        sc.nextLine(); // clear buffer
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter position: ");
        String position = sc.nextLine();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        String sql = "INSERT INTO employees(name, position, salary) VALUES(?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, position);
            pstmt.setDouble(3, salary);
            pstmt.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    // View all employees
    private static void viewAllEmployees() {
        String sql = "SELECT * FROM employees";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Employee List ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Position: %s | Salary: %.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getDouble("salary"));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching employees: " + e.getMessage());
        }
    }

    // Search employee by ID
    private static void searchEmployee(Scanner sc) {
        System.out.print("Enter employee ID to search: ");
        int id = sc.nextInt();

        String sql = "SELECT * FROM employees WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Position: %s | Salary: %.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getDouble("salary"));
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error searching employee: " + e.getMessage());
        }
    }

    // Delete employee by ID
    private static void deleteEmployee(Scanner sc) {
        System.out.print("Enter employee ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }
}
