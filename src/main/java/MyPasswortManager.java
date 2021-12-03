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

    private char[] Passwort;
    private String sPasswort = "";
    private int iSecurityMode = 0;

    private int iSecMinSize = 0;
    private int iSecMaxSize = 32;

    public MyPasswortManager(int setSecurityMode ) {
        sPasswort = "Geheim";
        setSecurityMode(setSecurityMode);
    }
    public void setSecurityMode(int iNewSecurityMode) {
        iSecurityMode = iNewSecurityMode;
        switch (iSecurityMode)
        {
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
        sPasswort.equals(sNewPasswort);
        return false;
    }

    private boolean checkLength(String tmpPasswort) {
        if( tmpPasswort.length() < iSecMinSize )
            return false;
        return true;
    }
    private boolean checkDigits(String tmpPasswort) {

        if( tmpPasswort.matches(".*\\d.*") == true )
            return true;
        return false;
    }
    private boolean checkSymbols(String tmpPasswort) {
        String PATTERN = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])[a-zA-Z\\d@#$%]{8,20}";
        if( tmpPasswort.matches(".*!.*") == true )
            return true;
        if( tmpPasswort.matches(".*@.*") == true )
            return true;
        if( tmpPasswort.matches(".*#.*") == true )
            return true;
        if( tmpPasswort.matches(".*\\$.*") == true )
            return true;
        if( tmpPasswort.matches(".*%.*") == true )
            return true;
        if( tmpPasswort.matches(".*&.*") == true )
            return true;
        return false;
    }
 //   String PATTERN = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])[a-zA-Z\\d@#$%]{8,20}";

    public int setPasswort(String sNewPasswort) {
        if( sNewPasswort.length() == 0 )
            return ERROR_CODE_TOSHORT;
        if( sNewPasswort.length() >= iSecMaxSize )
            return ERROR_CODE_TOLONG;

        switch (iSecurityMode)
        {
            case SECURITY_MODE_STRONG:

            case SECURITY_MODE_MID:
                if( checkSymbols( sNewPasswort ) == false)
                    return ERROR_CODE_NOSYMBOLS;

            case SECURITY_MODE_LOW:
                if( checkLength( sNewPasswort ) == false)
                    return ERROR_CODE_TOSHORT;
                if( checkDigits( sNewPasswort ) == false)
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
