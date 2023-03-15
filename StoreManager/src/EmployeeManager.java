import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager extends Menu implements learnAble {
    List<Employee> employees;
    Scanner sc = new Scanner(System.in);

    public EmployeeManager() {
        employees = new ArrayList<>();
        readFromFile();
    }

    @Override
    public void add() {
        try {
            Employee newEmployee = input();
            employees.add(newEmployee);
            saveToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() {
        try {
            FileWriter fileWriter = new FileWriter("employee.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee e : employees) {
                bufferedWriter.write(e.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFromFile() {
        employees.clear();
        try {
            FileInputStream fileInputStream = new FileInputStream("employee.txt");
            Scanner sc = new Scanner(fileInputStream);
            String line2 = "";
            while (sc.hasNextLine()) {
                line2 = sc.nextLine();
                Employee newE = xuLyLine(line2);
                if (newE != null) {
                    employees.add(newE);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Employee xuLyLine(String line) {
        try {
            String[] ss = line.split(",");
            Employee newEmployee = new Employee(ss[0], ss[1], new Date(ss[2]), Boolean.parseBoolean(ss[3]));
            return newEmployee;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi line!");
            return null;
        }
    }

    public Employee input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name:");
        String name = sc.nextLine();
        System.out.print("Enter id employee:");
        String id = sc.nextLine();

        Employee e = new Employee(name, id, new Date(), true);
        return e;
    }

    @Override
    public void update() {
        System.out.print("Enter Employee ID");
        String id = sc.nextLine();
        Employee editEmployee = searchById(id);
        if (editEmployee != null) {
            System.out.print("Enter name edit: ");
            String name = sc.nextLine();
            editEmployee.setName(name);
        }
        saveToFile();
    }

    @Override
    public void remove() {
        System.out.println("Enter Employee ID");
        String id = sc.nextLine();
        Employee removeEmployee = searchById(id);
        if (removeEmployee != null)
            employees.remove(removeEmployee);
        saveToFile();
    }

    @Override
    public void search() {
        System.out.println("Enter Employee ID");
        String id = sc.nextLine();
        Employee searchID = searchById(id);
        if (searchID != null)
            System.out.println(searchID);
    }

    private Employee searchById(String id) {
        for (Employee e : employees) {
            if (e.getId().equals(id))
                return e;
        }
        return null;
    }

    @Override
    public void displayAll() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}