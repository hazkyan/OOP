import java.util.ArrayList;
import java.util.List;

public class Student {
   
    private String id;
    private String lastName;
    private String firstName;
    private Degree degree;
    private List<Address> addresses = new ArrayList<>();
    private List<Parent> parents = new ArrayList<>();

    public Student(String id, String lastName, String firstName, Degree degree) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.degree = degree;
    }

    public String getId() {
        return id;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public void addParent(Parent parent) {
        parents.add(parent);
    }

    public void printReport() {
        System.out.println("Student id is " + id);
        System.out.println("Student name is " + lastName.toUpperCase() + ", " + firstName);
        System.out.println("Studying " + degree.getName());

        for (Address address : addresses) {
            if (address.getType().equals("C")) {
                System.out.println("City address is " + address.getLocation());
            } else if (address.getType().equals("P")) {
                System.out.println("Provincial address is " + address.getLocation());
            }
        }

        for (Parent parent : parents) {
            switch (parent.getType()) {
                case "F":
                    System.out.println("Father's name is " + parent.getName());
                    break;
                case "M":
                    System.out.println("Mother's name is " + parent.getName());
                    break;
                case "G":
                    System.out.println("Guardian's name is " + parent.getName());
                    break;
            }
        }
        System.out.println();
    }
}
