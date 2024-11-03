public class Address {
    
    private String type;
    private String location;

    public Address(String type, String location) {
        this.type = type;
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }
}
