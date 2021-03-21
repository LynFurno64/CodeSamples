package members;

public class Appointment {

    private String fullname, ph_num, email, yesno, reason, time, date, ID;

    public Appointment(String ID, String fullname, String ph_num, String email, String date, String time, String reason, String yesno) {
        this.ID = ID;
        this.fullname = fullname;
        this.ph_num = ph_num;
        this.email = email;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.yesno = yesno;
    }

    public String getID() {
        return ID;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPh_num() {
        return ph_num;
    }

    public String getEmail() {
        return email;
    }

    public String getYesno() {
        return yesno;
    }

    public String getReason() {
        return reason;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
