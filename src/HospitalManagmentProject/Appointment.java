package HospitalManagmentProject;

public class Appointment {
    private Patient pt;
    private Doctor dr;
    private String date;
    public Appointment(Patient pt, Doctor dr, String date){
        this.pt = pt;
        this.dr = dr;
        this.date = date;
    }
    public String toString(){
        return "Appointment : [patient:  "+ pt +" Doctor: " + dr + " Date: " + date;
    }
}
