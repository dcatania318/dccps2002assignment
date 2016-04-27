package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest 
{
    User user;
    
    @Before
    public void setUp()
    {
        user = new User("83294M","Connor Attard","Marsaskala",21249200,79249200);
    }
    
    @After
    public void tearDown()
    {
        user = null;
    }

    @Test
    public void testIDno()
    {
        assertEquals("83294M",user.getIDno());
        String s = "368396M";
        user.setIDno(s);
        assertEquals(s,user.getIDno());
    }

    @Test
    public void testFullName()
    {
        assertEquals("Connor Attard",user.getFullName());
        String s = "Daniel Catania";
        user.setFullName(s);
        assertEquals(s,user.getFullName());
    }

    @Test
    public void testAddress()
    {
        assertEquals("Marsaskala",user.getAddress());
        String s = "Pembroke";
        user.setAddress(s);
        assertEquals(s,user.getAddress());
    }

    @Test
    public void testTelephoneNo()
    {
        assertEquals(21249200,user.getTelephoneNo());
        int i = 21212121;
        user.setTelephoneNo(i);
        assertEquals(i,user.getTelephoneNo());
    }

    @Test
    public void testMobileNo()
    {
        assertEquals(79249200,user.getMobileNo());
        int i = 79797979;
        user.setMobileNo(i);
        assertEquals(i,user.getMobileNo());
    }
    
}
