package customer_records;

public class Customer {

    //data members
    private int id;
    private String fname;
    private String lname;
    private String country;
    private String email;

    //constructors
    public Customer(int id, String fname, String lname, String country, String email) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.country = country;
        this.email = email;
    }

    public Customer() {
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer [ID: " + id + ", first name: " + fname + ", last name: " + lname + 
                ", country: " + country + ", email: " + email + "]";
    }

}
