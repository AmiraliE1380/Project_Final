import java.util.Date;

public class VisitTime {
    private Date beginningDate;
    private Date endDate;
    private int patientsNationalCode;

    public VisitTime(Date beginningDate, Date endDate) {
        this.beginningDate = beginningDate;
        this.endDate = endDate;
        patientsNationalCode = -1;
    }

    public void setPatientsNationalCode(int patientsNationalCode) {
        this.patientsNationalCode = patientsNationalCode;
    }

    public static void reserveTimeForPatient(Date date1, Date date2, int nationalCode) throws Exception{

    }
}
