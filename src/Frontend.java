import java.util.Scanner;

public class Frontend {

    Scanner scanner = new Scanner(System.in);
ConsoleHandler ch = new ConsoleHandler(scanner);

    String namn = "";
    String address= "";
    String mail = "";
    String postNr = "";
    String stad = "";
    String phone = "";


    String length = "";
    String width = "";
    String height = "";
    String weight = "";
    String value = "";



    public void fyllinformation (){


        namn = ch.getString("Skriv in namn");
        String address = ch.getString("Skriv in address");
        String mail = ch.getString("Skriv in mail");
        String postNr = ch.getString("Skriv in postnummer");
        String stad = ch.getString("Skriv in stad");
        String phone = ch.getString("Skriv in telefonnummer");


        String length = ch.getString("Skriv in längd på paketet");
        String width = ch.getString("Skriv in bredd på paketet");
        String height = ch.getString("Skriv in höjd på paketet");
        String weight = ch.getString("Skriv in vikt på paketet");
        String value = ch.getString("Skriv in estimerat värde på paketet");


        String date = ch.getString("Skriv in datum för leverans");


    }







}
