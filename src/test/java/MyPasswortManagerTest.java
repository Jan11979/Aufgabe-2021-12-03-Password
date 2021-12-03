import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyPasswortManagerTest {

    @Test
    public void shouldCalculateTwo() {
        MyPasswortManager test = new MyPasswortManager(MyPasswortManager.SECURITY_MODE_NO);

        assertTrue(test.setPasswort("schlecht") == MyPasswortManager.ERROR_CODE_NO_ERROR );
        assertTrue(test.getPasswort().equals("schlecht"));

        assertTrue(test.setPasswort("1Besseress@sddsfdfgds@sdfgdfgdfgdfgg") == MyPasswortManager.ERROR_CODE_TOLONG );


        test.setSecurityMode(MyPasswortManager.SECURITY_MODE_LOW);
        assertTrue(test.setPasswort("Besseres@#$") == MyPasswortManager.ERROR_CODE_NONMBERS );
        assertTrue(test.setPasswort("abc123") == MyPasswortManager.ERROR_CODE_TOSHORT );
        assertTrue(test.setPasswort("Besseres123Passwort") == MyPasswortManager.ERROR_CODE_NO_ERROR );
        assertTrue(test.getPasswort().equals("Besseres123Passwort"));

        test.setSecurityMode(MyPasswortManager.SECURITY_MODE_MID);
        assertTrue(test.setPasswort("1Besseres#sdfsdsdfsdsdffs") == MyPasswortManager.ERROR_CODE_NO_ERROR );
        assertTrue(test.setPasswort("1Besseres@sddfgdfgdfgdfgfsd") == MyPasswortManager.ERROR_CODE_NO_ERROR );
        assertTrue(test.setPasswort("1Besseres#sdfdfgdfgdfgdfgfsd") == MyPasswortManager.ERROR_CODE_NO_ERROR );
        assertTrue(test.setPasswort("1Besseres$sdfdfgdfgdfgdfgdfg") == MyPasswortManager.ERROR_CODE_NO_ERROR );
        assertTrue(test.setPasswort("1Besseresdsfdfgdfgdfgdfgdfgg") == MyPasswortManager.ERROR_CODE_NOSYMBOLS );

        assertTrue(test.setPasswort("1Besseres#sdfsdsdfsdsdffs") == MyPasswortManager.ERROR_CODE_NO_ERROR );
        assertFalse(test.checkPassword("1Besseres#sdfsdsdfsdsdffs")  );
    }

}