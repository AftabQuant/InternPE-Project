package HospitalManagmentProject;

public class Patient {
    private static int count = 1;
    private int id;
    private String name;
    private int age;
    private String gender;
    private String about;
    public Patient(String name, int age, String gender, String about) {
        id = count++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.about = about;
    }
    public Patient(){

    }
    public int getId() {
        return id;
    }
    public String toString(){
        return "Patient Id : "+ id+ " Name : " + name + " Age : " + age + " gender : " + gender +" About : " + about;
    }
}
