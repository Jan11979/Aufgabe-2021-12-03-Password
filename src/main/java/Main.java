public class Main {
    public static void main(String[] args) {
        System.out.println("Es Lebt");

        MyPasswortManager appPassword = new MyPasswortManager( MyPasswortManager.SECURITY_MODE_NO );

        appPassword.setSecurityMode(MyPasswortManager.SECURITY_MODE_LOW);
        appPassword.setPasswort("BesseresPasswort");
        appPassword.setPasswort("abc123");
        appPassword.setPasswort("Besseres123Passwort");



        System.out.println( appPassword.getPasswort() );
    }
}
/*
Schreibe eine Passwortvalidierung.
ToDo:
Klasse
    init
        Anforderungen setzen fuer die Passwörter
     Store
        Passort Speichern (Bonus! Verschlüsselt)
     setPasswort
        annehmen von Passwort mit abfrage der ANforderungen
     CheckPasswort
        prüfen ob ein passwort richtig war





Lege dir ein neues Java Github Projekt an
Überlege dir, wie die Methoden aussehen müssen.
Schreibe jeweils erst einen Test und dann die Funktionalität
Überprüfe erst die Länge des Passworts und
dann, ob Zahlen enthalten sind
Bonus:

Checke, ob kleine/große Buchstaben enthalten sind
Verbiete "schlechte" Passwörter wie "passwort" oder "123456"
Schaue dir auf GitHub Labs weitere Einsteigervideos an



 */