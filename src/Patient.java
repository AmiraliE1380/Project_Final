import java.util.ArrayList;
import java.util.HashMap;

public class Patient {
    private static HashMap<Integer, Patient> patients;
    private String name;
    private int nationalCode;
    private int age;
    static {
        patients = new HashMap<>();
    }

    public Patient(String name, int nationalCode, int age) {
        this.age = age;
        this.name =name;
        this.nationalCode = nationalCode;
        patients.put(nationalCode, this);
    }

    public static Patient getPatientByNationalCode(int nationalCode) {
        return patients.get(nationalCode);
    }
}
