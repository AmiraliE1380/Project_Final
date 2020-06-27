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
        File directory = new File("patients");
        String[] pathNames = directory.list();
        if (pathNames == null)
            return;
        for(String objectName : pathNames) {
            try {
                FileInputStream fileInputStream = new FileInputStream("patients\\" + objectName);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Patient patient = (Patient) objectInputStream.readObject();
                patients.put(patient.nationalCode, patient);
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Can't load...");
            }
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
                fileOutputStream.close();
            } catch (IOException e) {
                System.out.println("Cannot save data...");
            }
        }
    }
}
