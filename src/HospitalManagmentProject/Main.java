package HospitalManagmentProject;
import java.util.*;


public class Main{
    static List<Patient> pat = new ArrayList<>();
    static List<Doctor> doc = new ArrayList<>();
    static List<Appointment> appoint = new ArrayList<>();
    private static void addPatient(Scanner sc) {
        sc.nextLine(); // This line to clear out any leftover newline
        System.out.println("Enter Your Name : ");
        String name = sc.nextLine();
        System.out.println("Enter Your Age : ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Your Gender : ");
        String gender = sc.nextLine();
        System.out.println("Enter Your Problem : ");
        String about = sc.nextLine();
        Patient pt = new Patient(name, age, gender, about);
        pat.add(pt);
    }
    private static void addDoctor(Scanner sc) {
        sc.nextLine(); // This line to clear out any leftover newline
        System.out.println("Enter Doctor's Name : ");
        String name = sc.nextLine();
        System.out.println("Enter Doctor's Speciality : ");
        String sp = sc.nextLine();
        Doctor dr = new Doctor(name, sp);
        doc.add(dr);
    }
    private static void showPatient() {
        System.out.println(pat);
        System.out.println("\n");
    }
    private static void showDoctor() {
        System.out.println(doc);
        System.out.println("\n");
    }
    private static void appointment(Scanner sc) {
        sc.nextLine();
        System.out.println("Enter Your Patient : ");
        int patId = sc.nextInt();
        System.out.println("Enter Doctor Id : ");
        int docId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Your Appointment's Date [dd/mm/yyyy] : ");
        String date = sc.nextLine();
        Patient pt = findPatientById(patId);
        Doctor dr = findDoctorById(docId);
        if(pt!=null && dr!=null){
            Appointment app = new Appointment(pt, dr, date);
            appoint.add(app);
        }
        else{
            System.out.println("Some Error !");
        }
    }
    private static void viewAppointment(){
        System.out.println(appoint);
        System.out.println("\n");
    }
    private static Patient findPatientById(int id){
        for(Patient pt : pat) {
            if(pt.getId() == id ) return pt;
        }
        return null;
    }
    private static Doctor findDoctorById(int id){
        for(Doctor dr : doc) {
            if(dr.getId() == id ) return dr;
        }
        return null;
    }
    private static void totalPatient() {
        Patient pt = new Patient();
        System.out.println("Total Patients Present Now : " + pt.getId());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch ;
        do{
        System.out.println("Welcome To My Hospital!");
        System.out.println("1 . Add Patient");
        System.out.println("2 . Add Doctor");
        System.out.println("3 . Schedule Appointment");
        System.out.println("4 . Show Patient");
        System.out.println("5 . Show Doctor List");
        System.out.println("6 . View Appointment");
        System.out.println("7 . Total Patient");
        System.out.println("0 . Exit");
        System.out.println("Enter Your Choice : ");
        ch = sc.nextInt();
        switch(ch){
            case 1 : addPatient(sc);
            break;
            case 2 : addDoctor(sc);
            break;
            case 3 : appointment(sc);
            break;
            case 4 : showPatient();
            break;
            case 5 : showDoctor();
            break;
            case 6 : viewAppointment();
            break;
            case 7 : totalPatient();
            break;
            case 0 : System.out.println("Exit Details !");
            break;
            default:
                System.out.println("Please , Try Again !");
        }
        }while(ch != 0);
    }
}
