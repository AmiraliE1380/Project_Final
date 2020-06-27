import java.util.ArrayList;
import java.util.Date;

public class VisitTime {
    private static ArrayList<VisitTime> visitTimes;
    private Date beginningDate;
    private Date endDate;
    private int patientsNationalCode;
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
        return null;
    }

    public void setPatientsNationalCode(int patientsNationalCode) {
        this.patientsNationalCode = patientsNationalCode;
    }
}
