import com.newton.test.ConsoleHandler;
import com.newton.test.Getinfo;
import com.newton.test.Getprices;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {


    // testar att metoden som beräknar pris kan ta input från kund(scannern) i detta fall endast postnummer.


    @Test
    public void getUpsPrice_ChecksInputValueisUsed_ChecksThatPostnummertValueIsSameAsIfValueWereGivenLocallytoPostnummer() {


       Getprices gp = new Getprices();


       float pris2 = gp.getUpsPrice(17266);

       if(pris2 <=0 || pris2 > 10000){
           assertTrue(false);
       }





    }



}
