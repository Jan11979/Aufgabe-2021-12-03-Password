import com.codahale.passpol.BreachDatabase;
import com.codahale.passpol.PasswordPolicy;
import com.codahale.passpol.Status;

import java.util.Arrays;
import java.util.Locale;


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

    String[] sBreachedPassword = {"123456", "passwort", "password", "12345678", "1234", "pussy", "12345", "dragon", "qwerty", "696969", "mustang", "letmein", "baseball", "master", "michael", "football", "shadow", "monkey", "abc123", "pass", "6969", "jordan", "harley", "ranger", "iwantu", "jennifer", "hunter", "2000", "test", "batman", "trustno1", "thomas", "tigger", "robert", "access", "love", "buster", "1234567", "soccer", "hockey", "killer", "george", "sexy", "andrew", "charlie", "superman", "asshole", "dallas", "jessica", "panties", "pepper", "1111", "austin", "william", "daniel", "golfer", "summer", "heather", "hammer", "yankees", "joshua", "maggie", "biteme", "enter", "ashley", "thunder", "cowboy", "silver", "richard", "orange", "merlin", "michelle", "corvette", "bigdog", "cheese", "matthew", "121212", "patrick", "martin", "freedom", "ginger", "blowjob", "nicole", "sparky", "yellow", "camaro", "secret", "dick", "falcon", "taylor", "111111", "131313", "123123", "bitch", "hello", "scooter", "please", "", "porsche", "guitar", "chelsea", "black", "diamond", "nascar", "jackson", "cameron", "654321", "computer", "amanda", "wizard", "xxxxxxxx", "money", "phoenix", "mickey", "bailey", "knight", "iceman", "tigers", "purple", "andrea", "horny", "dakota", "aaaaaa", "player", "sunshine", "morgan", "starwars", "boomer", "cowboys", "edward", "charles", "girls", "booboo", "coffee", "xxxxxx", "bulldog", "ncc1701", "rabbit", "peanut", "john", "johnny", "gandalf", "spanky", "winter", "brandy", "compaq", "carlos", "tennis", "james", "mike", "brandon", "fender", "anthony", "blowme", "ferrari", "cookie", "chicken", "maverick", "chicago", "joseph", "diablo", "sexsex", "hardcore", "666666", "willie", "welcome", "chris", "panther", "yamaha", "justin", "banana", "driver", "marine", "angels", "fishing", "david", "maddog", "hooters", "wilson", "butthead", "dennis", "captain", "bigdick", "chester", "smokey", "xavier", "steven", "viking", "snoopy", "blue", "eagles", "winner", "samantha", "house", "miller", "flower", "jack", "firebird", "butter", "united", "turtle", "steelers", "tiffany", "zxcvbn", "tomcat", "golf", "bond007", "bear", "tiger", "doctor", "gateway", "gators", "angel", "junior", "thx1138", "porno", "badboy", "debbie", "spider", "melissa", "booger", "1212", "flyers", "fish", "porn", "matrix", "teens", "scooby", "jason", "walter", "cumshot", "boston", "braves", "yankee", "lover", "barney", "victor", "tucker", "princess", "mercedes", "5150", "doggie", "zzzzzz", "gunner", "horney", "bubba", "2112", "fred", "johnson", "xxxxx", "tits", "member", "boobs", "donald", "bigdaddy", "bronco", "penis", "voyager", "rangers", "birdie", "trouble", "white", "topgun", "bigtits", "bitches", "green", "super", "qazwsx", "magic", "lakers", "rachel", "slayer", "scott", "2222", "asdf", "video", "london", "7777", "marlboro", "srinivas", "internet", "action", "carter", "jasper", "monster", "teresa", "jeremy", "11111111", "bill", "crystal", "peter", "pussies", "cock", "beer", "rocket", "theman", "oliver", "prince", "beach", "amateur", "7777777", "muffin", "redsox", "star", "testing", "shannon", "murphy", "frank", "hannah", "dave", "eagle1", "11111", "mother", "nathan", "raiders", "steve", "forever", "angela", "viper", "ou812", "jake", "lovers", "suckit", "gregory", "buddy", "whatever", "young", "nicholas", "lucky", "helpme", "jackie", "monica", "midnight", "college", "baby", "brian", "mark", "startrek", "sierra", "leather", "232323", "4444", "beavis", "bigcock", "happy", "sophie", "ladies", "naughty", "giants", "booty", "blonde", "golden", "0", "fire", "sandra", "pookie", "packers", "einstein", "dolphins", "0", "chevy", "winston", "warrior", "sammy", "slut", "8675309", "zxcvbnm", "nipples", "power", "victoria", "asdfgh", "vagina", "toyota", "travis", "hotdog", "paris", "rock", "xxxx", "extreme", "redskins", "erotic", "dirty", "ford", "freddy", "arsenal", "access14", "wolf", "nipple", "iloveyou", "alex", "florida", "eric", "legend", "movie", "success", "rosebud", "jaguar", "great", "cool", "cooper", "1313", "scorpio", "mountain", "madison", "987654", "brazil", "lauren", "japan", "naked", "squirt", "stars", "apple", "alexis", "aaaa", "bonnie", "peaches", "jasmine", "kevin", "matt", "qwertyui", "danielle", "beaver", "4321", "4128", "runner", "swimming", "dolphin", "gordon", "casper", "stupid", "shit", "saturn", "gemini", "apples", "august", "3333", "canada", "blazer", "cumming", "hunting", "kitty", "rainbow", "112233", "arthur", "cream", "calvin", "shaved", "surfer", "samson", "kelly", "paul", "mine", "king", "racing", "5555", "eagle", "hentai", "newyork", "little", "redwings", "smith", "sticky", "cocacola", "animal", "broncos", "private", "skippy", "marvin", "blondes", "enjoy", "girl", "apollo", "parker", "qwert", "time", "sydney", "women", "voodoo", "magnum", "juice", "abgrtyu", "777777", "dreams", "maxwell", "music", "rush2112", "russia", "scorpion", "rebecca", "tester", "mistress", "phantom", "billy", "6666", "albert"};


    private char[] Passwort;
    private String sPasswort = "";
    private static String sServerPasswort = "";
    private int iSecurityMode = 0;

    private int iSecMinSize = 0;
    private int iSecMaxSize = 32;

    // Minimal und Maximale länge frage ich separat ab um den richtigen FehlerCode zu schmeissen. (hatte ich auch eh schon gecodet)
    // Diese Klasse Funktioniert nicht, lasse die aber drin, Falls mir mal ganz langweilig wird.
    final PasswordPolicy policy = new PasswordPolicy(BreachDatabase.haveIBeenPwned(5), 1, 64);


    public MyPasswortManager(int setSecurityMode) {
        sPasswort = "***";
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
        //    String test = new String(tmpPasswort.toCharArray());
        //    System.out.println(policy.check(test));
        //    System.out.println(policy.check(tmpPasswort));
        String sTemp = tmpPasswort.toLowerCase(Locale.ROOT);
        for (int i = 0; i < sBreachedPassword.length; i++) {
            if (sTemp.equals(sBreachedPassword[i]) == true)
                return false;
        }
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
        boolean bCapital = false;
        boolean bLow = false;
        for (int i = 0; i < tmpPasswort.length(); i++) {
            if (Character.isUpperCase(tmpPasswort.charAt(i))) {
                bCapital = true;
            } else if (Character.isLowerCase(tmpPasswort.charAt(i))) {
                bLow = true;
            }
            if (bCapital && bLow)
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
