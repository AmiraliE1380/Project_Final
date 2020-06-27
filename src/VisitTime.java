import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class VisitTime implements Serializable {
    private static ArrayList<VisitTime> visitTimes;
    private Date beginningDate;
    private Date endDate;
    private int patientsNationalCode;
    private static final String ERROR = "You can't see the doctor at this time!";
    static {
        visitTimes = new ArrayList<>();
    }

    public VisitTime(Date beginningDate, Date endDate) {
        this.beginningDate = beginningDate;
        this.endDate = endDate;
        patientsNationalCode = -1;
        visitTimes.add(this);
    }

    public static String reserveTimeForPatient(Date date1, Date date2, int nationalCode) throws Exception {
        for(VisitTime visitTime : visitTimes) {
            if(visitTime.patientsNationalCode == -1) {
                if (canBeReserved(visitTime, date1, date2)) {
                    visitTime.setPatientsNationalCode(nationalCode);
                    return visitTime.beginningDate.toString() + "\n" + visitTime.endDate.toString();
                }
            }
        }
        throw new Exception(ERROR);
    }

    private static boolean canBeReserved(VisitTime visitTime, Date date1, Date date2) {
        if(date1.compareTo(visitTime.beginningDate) < 0 || date2.compareTo(visitTime.endDate) > 0) {
            return false;
        }
        return true;
    }

    public void setPatientsNationalCode(int patientsNationalCode) {
        this.patientsNationalCode = patientsNationalCode;
    }

    public static ArrayList<VisitTime> getVisitTimes() {
        return visitTimes;
    }

    @Override
    public String toString() {
        String information;
        if(patientsNationalCode != -1)
            information = String.valueOf(patientsNationalCode);
        else
            information = "";
        return information + "\n" + beginningDate.toString() + '\n' + endDate.toString() + '\n';
    }

    public static void load() {

    }

    public static void save() {
        new File("visit times").mkdir();
        int counter = 0;
        for(VisitTime visitTime : visitTimes) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("visit times\\" + counter);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(visitTime);
                objectOutputStream.close();
                fileOutputStream.close();
                counter++;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Cannot save data...");
            }
        }
    }
}
