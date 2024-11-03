import java.io.*;
import java.util.*;

public class StudentReport {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        try (Scanner studFile = new Scanner(new File("Studinfo.csv"))) {
            while (studFile.hasNextLine()) {
                String rowStudent = studFile.nextLine();
                String[] data = rowStudent.split(", ");
                String id = data[0];
                String lastName = data[1];
                String firstName = data[2];
                String degreeCode = data[3];

                Degree degree = new Degree(degreeCode);
                Student student = new Student(id, lastName, firstName, degree);

                processAddress(student);
                processParent(student);

                students.add(student);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Student information file not found.");
        }

        for (Student student : students) {
            student.printReport();
        }
    }

    private static void processAddress(Student student) {
        try (Scanner addressFile = new Scanner(new File("AddressInfo.csv"))) {
            while (addressFile.hasNextLine()) {
                String rowAddress = addressFile.nextLine();
                String[] data = rowAddress.split(", ");
                String studentId = data[0];
                String type = data[1];
                String location = data[2];

                if (student.getId().equals(studentId)) {
                    Address address = new Address(type, location);
                    student.addAddress(address);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Address information file not found.");
        }
    }

    private static void processParent(Student student) {
        try (Scanner parentFile = new Scanner(new File("ParentInfo.csv"))) {
            while (parentFile.hasNextLine()) {
                String rowParent = parentFile.nextLine();
                String[] data = rowParent.split(", ");
                String studentId = data[0];
                String type = data[1];
                String name = data[2];

                if (student.getId().equals(studentId)) {
                    Parent parent = new Parent(type, name);
                    student.addParent(parent);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Parent information file not found.");
        }
    }
}
