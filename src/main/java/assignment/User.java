package assignment;

public class User
{
    private String sIDno;
    private String sFullName;
    private String sAddress;
    private int iTelephoneNo;
    private int iMobileNo;
    
    public User(String sIDno, String sFullName, String sAddress, int iTelephoneNo, int iMobileNo)
    {
        this.sIDno = sIDno;
        this.sFullName = sFullName;
        this.sAddress = sAddress;
        this.iTelephoneNo = iTelephoneNo;
        this.iMobileNo = iMobileNo;
    }
    
    public void setIDno(String sIDno)
    {
        this.sIDno = sIDno;
    }
    public void setFullName(String sFullName)
    {
        this.sFullName = sFullName;
    }
    public void setAddress(String sAddress)
    {
        this.sAddress = sAddress;
    }
    public void setTelephoneNo(int iTelephoneNo)
    {
        this.iTelephoneNo = iTelephoneNo;
    }
    public void setMobileNo(int iMobileNo)
    {
        this.iMobileNo = iMobileNo;
    }
    
    public String getIDno()
    {
        return sIDno;
    }
    public String getFullName()
    {
        return sFullName;
    }
    public String getAddress()
    {
        return sAddress;
    }
    public int getTelephoneNo()
    {
        return iTelephoneNo;
    }
    public int getMobileNo()
    {
        return iMobileNo;
    }
}