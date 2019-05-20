import com.newton.test.ConsoleHandler;
import com.newton.test.Getinfo;
import com.newton.test.Getprices;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {


    // testar att metoden som beräknar pris kan ta input från kund(scannern) i detta fall endast postnummer.


    @Test
    public void getUpsPrice_ChecksInputValueisUsed_ChecksThatPostnummertValueIsSameAsIfValueWereGivenLocallytoPostnummer() {

        InputStream inputStream = MainTest.class.getResourceAsStream("/testpostnummervalue.txt");
        Scanner scanner = new Scanner(inputStream);
        ConsoleHandler ch = new ConsoleHandler(scanner);

       Getinfo info = new Getinfo();
       Getprices gp = new Getprices();

       String pris = gp.getUpsPrice(info.Postnummerinfo());
       String pris2 = gp.getUpsPrice(18164);



        assertEquals(pris, pris2);


    }



}
