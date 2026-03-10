package altn72.TpFilRouge.model.tmp;

public class Programmer {

    private int idProgrammer;
    private String name;
    private String firstname;
    private String address;
    private String langageExpertise;
    private String preferedBook;
    private double salary;

    public Programmer(int idProgrammer, String firstname, String name, String address, double salary, String preferedBook, String langageExpertise) {
        this.name = name;
        this.salary = salary;
        this.preferedBook = preferedBook;
        this.langageExpertise = langageExpertise;
        this.firstname = firstname;
        this.address = address;
        this.idProgrammer = idProgrammer;
    }


    public String getPreferedBook() {
        return preferedBook;
    }

    public void setPreferedBook(String preferedBook) {
        this.preferedBook = preferedBook;
    }

    public int getIdProgrammer() {
        return idProgrammer;
    }

    public void setIdProgrammer(int idProgrammer) {
        this.idProgrammer = idProgrammer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public String getLangageExpertise() {
        return langageExpertise;
    }

    public void setLangageExpertise(String langageExpertise) {
        this.langageExpertise = langageExpertise;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "idProgrammer=" + idProgrammer +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", adress='" + address + '\'' +
                ", langageExpertise='" + langageExpertise + '\'' +
                ", preferedBook='" + preferedBook + '\'' +
                ", salary=" + salary +
                '}';
    }

}
