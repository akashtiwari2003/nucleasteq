
package nucleasteq.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class NucleasteqTask1 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Lenovo\\Downloads\\Employees.csv";
        List<Employee> employees = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(filePath))){
            scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            String salary = data.length > 4 ? data[4] : "0";
            employees.add(new Employee(data[0], data[1], data[2], data[3], salary));
        }
        scanner.close();
        Collections.sort(employees, Comparator.comparing(Employee::getDepartment));

        
        Map<String, List<Employee>> groupedByDepartment = new HashMap<>();
        for (Employee employee : employees) {
            String department = employee.getDepartment();
            groupedByDepartment.computeIfAbsent(department, key -> new ArrayList<>());
            groupedByDepartment.get(department).add(employee);
        }
        
        for (List<Employee> departmentEmployees : groupedByDepartment.values()) {
            departmentEmployees.sort(Comparator.comparing(Employee::getSalary));
        }
        
        for (Map.Entry<String, List<Employee>> entry : groupedByDepartment.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            for (Employee employee : entry.getValue()) {
                System.out.println(employee); 
            }
            System.out.println(); 
        }
        }catch(FileNotFoundException e){
         System.err.println("File not found: " + filePath);   
        }
    }
}
class Employee{
    private final String firstName;
        private final String lastName;
        private final String department;
        private final String position;
        private final String salary;

        public Employee(String firstName, String lastName, String department, String position, String salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.department = department;
            this.position = position;
            this.salary = salary;
        }
        public String getDepartment() {
            return department;
        }
        public String getSalary() {
        return salary;
        }
        @Override
        public  String toString() {
            return firstName + ", " + lastName + ", " + position + ", " + salary;
        }
}

