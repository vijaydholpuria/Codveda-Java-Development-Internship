import java.util.*;

class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id,String name, double salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }

    public void displayEmployee(){
        System.out.println("________________________________");
        System.out.println("Employee ID: "+id);
        System.out.println("Employee Name: "+name);
        System.out.println("Employee Salary: "+salary);
    }
}

class EmployeeManager{
    private ArrayList<Employee> employees= new ArrayList<>();
    public void addEmployee(int id,String name,double salary){
        for(Employee emp: employees){
            if(emp.getId()==id){
                System.out.println("________________________________________");
                System.out.println("Employee with ID "+id+" already exists.");
                return;
            }
        }
        employees.add(new Employee(id,name,salary));
        System.out.println("Employee Added successfully.");
    }

    public void viewEmployee(){
        if(employees.isEmpty()){
            System.out.println("________________________________________");
            System.out.println("No Employee found.");
            return;
        }
        for(Employee emp: employees){
            emp.displayEmployee();
        }

    }
    
    public void searchEmployee(int id){
        for(Employee emp: employees){
            if(emp.getId()==id){
                System.out.println("________________________________________");
                System.out.println("Employee Found:");
                emp.displayEmployee();
                return;
            }
        }
        System.out.println("________________________________________");
        System.out.println("\nEmployee with ID "+id+" not found.");
    }

    public void updateEmployee(int id,String name,double salary){
        for(Employee emp: employees){
            if(emp.getId()==id){
                emp.setName(name);
                emp.setSalary(salary);
                System.out.println("________________________________________");
                System.out.println("Employee Updated successfully.");
                return;
            }
        }
        System.out.println("________________________________________");
        System.out.println("Employee with ID "+id+" not found.");
    }

    public void deleteEmployee(int id){
        for(Employee emp: employees){
            if(emp.getId()==id){
                employees.remove(emp);
                System.out.println("________________________________________");
                System.out.println("Employee Deleted successfully.");
                return;
            }
        }
        System.out.println("________________________________________");
        System.out.println("Employee with ID "+id+" not found.");
    }
}

public class EmployeeManagementSystem{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        EmployeeManager manager= new EmployeeManager();
        while(true){
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if(!sc.hasNextInt()){
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.err.println("======ADD EMPLOYEE======");
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();
                    manager.addEmployee(id,name,salary);
                    break;
                case 2:
                    System.err.println("======VIEW EMPLOYEES======");
                    manager.viewEmployee();
                    break;

                case 3:
                    System.err.println("======SEARCH EMPLOYEE======");
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();
                    manager.searchEmployee(searchId);
                    break;
                case 4:
                    System.err.println("======UPDATE EMPLOYEE======");
                    System.out.print("Enter Employee ID to update: ");  
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Employee Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new Employee Salary: ");
                    double newSalary = sc.nextDouble();
                    manager.updateEmployee(updateId, newName, newSalary);
                    break;
                case 5:
                    System.err.println("======DELETE EMPLOYEE======");
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = sc.nextInt();
                    manager.deleteEmployee(deleteId);
                    break;
                case 6:
                    
                    System.out.println("Exiting Employee Management System. Goodbye!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");    
            }
        }
    }
}