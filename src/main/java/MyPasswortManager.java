public class MyPasswortManager {
    private char[] Passwort;
    private String sPasswort = "***";

    public MyPasswortManager() {
        sPasswort = "Geheim";
    }
    public String getPasswort() {
        return sPasswort;
    }

}
