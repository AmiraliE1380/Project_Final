import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Patient implements Serializable {
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

    public static void load() {
        boolean isMoreObjects = true;
        while(isMoreObjects) {

        }
    }

    public static void save() {
        new File("patients").mkdir();
        for(Patient patient : patients.values()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("patients\\" +
                        String.valueOf(patient.nationalCode));
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(patient);
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("Cannot save data...");
            }
        }
    }
}
