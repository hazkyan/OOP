public class Degree {
    
    private String code;
    private String name;

    public Degree(String code) {
        this.code = code;
        switch (code) {
            case "BSCS":
                this.name = "BS Computer Science";
                break;
            case "BSIE":
                this.name = "BS Industrial Engineering";
                break;
            case "BSCE":
                this.name = "BS Civil Engineering";
                break;
            case "BSECE":
                this.name = "BS Electronics Engineering";
                break;
            default:
                this.name = "Unknown Degree";
        }
    }

    public String getName() {
        return name;
    }
}
