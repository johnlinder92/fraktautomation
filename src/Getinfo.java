import java.util.Scanner;

public class Getinfo {

    Scanner scanner = new Scanner(System.in);
ConsoleHandler ch = new ConsoleHandler(scanner);






    public int Postnummerinfo (){



        int postNr = ch.getInt("Skriv in postnummer dit din försändelse ska");





        return postNr;

    }

    public Paket paketInformation (){

        Paket paket = new Paket(ch.getInt("Skriv hur många paket av denna sort"),
                ch.getInt("Skriv in vikt på paketet"),
               ch.getInt("Skriv in längd på paketet"),
                ch.getInt("Skriv in bredd på paketet"),
                ch.getInt("Skriv in höjd på paketet")

        );


        return paket;

    }






}
