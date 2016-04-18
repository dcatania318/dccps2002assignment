/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author dcata
 */
public class User
{
    private String sIDno;
    private String sFullName;
    private String sAddress;
    private int iTelephoneNo;
    private int iMobileNo;
    
    public User(String sIDno_in, String sFullName_in, String sAddress_in, int iTelephoneNo_in, int iMobileNo_in)
    {
        sIDno = sIDno_in;
        sFullName = sFullName_in;
        sAddress = sAddress_in;
        iTelephoneNo = iTelephoneNo_in;
        iMobileNo = iMobileNo_in;
    }
    
    public void setIDno(String sIDno_in)
    {
        sIDno = sIDno_in;
    }
    public void setFullName(String sFullName_in)
    {
        sFullName = sFullName_in;
    }
    public void setAddress(String sAddress_in)
    {
        sAddress = sAddress_in;
    }
    public void setTelephoneNo(int iTelephoneNo_in)
    {
        iTelephoneNo = iTelephoneNo_in;
    }
    public void setMobileNo(int iMobileNo_in)
    {
        iMobileNo = iMobileNo_in;
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
