public class Patient {
    private String name;
    private int nationalCode;
    private int age;

    public Patient(String name, int nationalCode, int age) {
        this.age = age;
        this.name =name;
        this.nationalCode = nationalCode;
    }

    public int getNationalCode() {
        return nationalCode;
    }
}
