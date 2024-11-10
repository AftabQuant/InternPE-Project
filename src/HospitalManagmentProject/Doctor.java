package HospitalManagmentProject;

public class Doctor {
    static int count = 1;
    private int id ;
    private String name;
    private String speciality;
    public Doctor(String name, String speciality){
        id = count++;
        this.name = name;
        this.speciality = speciality;
    }
    public int getId(){
        return id;
    }
    public String toString(){
        return "Doctor Name : " + name +" Speciality : " + speciality;
    }
}
