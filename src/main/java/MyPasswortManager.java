import com.codahale.passpol.BreachDatabase;
import com.codahale.passpol.PasswordPolicy;
import com.codahale.passpol.Status;


public class MyPasswortManager {

    public static final int SECURITY_MODE_NO = 0;
    public static final int SECURITY_MODE_LOW = 1;
    public static final int SECURITY_MODE_MID = 2;
    public static final int SECURITY_MODE_STRONG = 3;

    public static final int ERROR_CODE_NO_ERROR = 0;
    public static final int ERROR_CODE_TOLONG = 1;
    public static final int ERROR_CODE_TOSHORT = 2;
    public static final int ERROR_CODE_NONMBERS = 3;
    public static final int ERROR_CODE_NOSYMBOLS = 4;
    public static final int ERROR_CODE_NOCAPITELLETTER = 5;
    public static final int ERROR_CODE_BREACHED = 6;

    private char[] Passwort;
    private String sPasswort = "";
    private int iSecurityMode = 0;

    private int iSecMinSize = 0;
    private int iSecMaxSize = 32;

    // Minimal und Maximale länge frage ich separat ab um den richtigen FehlerCode zu schmeissen. (hatte ich auch eh schon gecodet)
    final PasswordPolicy policy = new PasswordPolicy(BreachDatabase.haveIBeenPwned( 5 ), 1, 64);



    public MyPasswortManager(int setSecurityMode) {
        sPasswort = "Geheim";
        setSecurityMode(setSecurityMode);
    }

    public void setSecurityMode(int iNewSecurityMode) {
        iSecurityMode = iNewSecurityMode;
        switch (iSecurityMode) {
            case SECURITY_MODE_STRONG:
                iSecMinSize = 24;
                break;
            case SECURITY_MODE_MID:
                iSecMinSize = 16;
                break;
            case SECURITY_MODE_LOW:
                iSecMinSize = 8;
                break;
            case SECURITY_MODE_NO:
                iSecMinSize = 1;
                break;
        }
    }

    public boolean checkPassword(String sNewPasswort) {
        return sPasswort.equals(sNewPasswort);
    }
    private boolean checkBreached(String tmpPasswort) {
    //    if( policy.check(tmpPasswort) == Status.BREACHED )
    //        return false;
    //    if(policy.check(tmpPasswort).equals("BREACHED") == true )
    //        return false;
        System.out.println(policy.check(tmpPasswort));
        return true;

    }


    private boolean checkLength(String tmpPasswort) {
        if (tmpPasswort.length() < iSecMinSize)
            return false;
        return true;
    }

    private boolean checkDigits(String tmpPasswort) {

        if (tmpPasswort.matches(".*\\d.*") == true)
            return true;
        return false;
    }

    private boolean checkCapitalLetter(String tmpPasswort) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        for(int i=0;i < tmpPasswort.length();i++) {
            ch = tmpPasswort.charAt(i);
            if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if(capitalFlag && lowerCaseFlag)
                return true;
        }
        return false;
    }

    private boolean checkSymbols(String tmpPasswort) {
    //    String PATTERN = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])[a-zA-Z\\d@#$%]{8,20}";
        if (tmpPasswort.matches(".*!.*") == true)
            return true;
        else if (tmpPasswort.matches(".*@.*") == true)
            return true;
        else if (tmpPasswort.matches(".*#.*") == true)
            return true;
        else if (tmpPasswort.matches(".*\\$.*") == true)
            return true;
        else if (tmpPasswort.matches(".*%.*") == true)
            return true;
        else if (tmpPasswort.matches(".*&.*") == true)
            return true;
        return false;
    }
    //   String PATTERN = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])[a-zA-Z\\d@#$%]{8,20}";

    public int setPasswort(String sNewPasswort) {
        if (sNewPasswort.length() == 0)
            return ERROR_CODE_TOSHORT;
        if (sNewPasswort.length() >= iSecMaxSize)
            return ERROR_CODE_TOLONG;

        switch (iSecurityMode) {
            case SECURITY_MODE_STRONG:
                if (checkBreached(sNewPasswort) == false)
                    return ERROR_CODE_BREACHED;
                if (checkSymbols(sNewPasswort) == false)
                    return ERROR_CODE_NOSYMBOLS;


            case SECURITY_MODE_MID:

                if (checkCapitalLetter(sNewPasswort) == false)
                    return ERROR_CODE_NOCAPITELLETTER;

            case SECURITY_MODE_LOW:
                if (checkLength(sNewPasswort) == false)
                    return ERROR_CODE_TOSHORT;
                if (checkDigits(sNewPasswort) == false)
                    return ERROR_CODE_NONMBERS;

            case SECURITY_MODE_NO:
                sPasswort = sNewPasswort;
        }
        return ERROR_CODE_NO_ERROR;
    }


    // ToDo!!!!!
    // Das kommt noch Raus
    public String getPasswort() {
        return sPasswort;
    }

}
