package assignment;

public class User {
    
    private String ID;
    private String fullName;
    private String address;
    private int telephoneNo;
    private int mobileNo;
    
    public User(String ID, String fullName, String address, int telephoneNo, int mobileNo) {
        this.ID = ID;
        this.fullName = fullName;
        this.address = address;
        this.telephoneNo = telephoneNo;
        this.mobileNo = mobileNo;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setTelephoneNo(int telephoneNo) {
        this.telephoneNo = telephoneNo;
    }
    
    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }
    
    public String getID() {
        return ID;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public int getTelephoneNo() {
        return telephoneNo;
    }
    
    public int getMobileNo() {
        return mobileNo;
    }
}