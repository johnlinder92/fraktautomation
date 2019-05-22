import com.newton.test.ConsoleHandler;
import com.newton.test.Getinfo;
import com.newton.test.Getprices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {


    // testar att metoden som beräknar pris kan ta input från kund(scannern) i detta fall endast postnummer.


    @Test
    public void getUpsPrice_ChecksInputValueisUsed_ChecksThatPostnummertValueIsSameAsIfValueWereGivenLocallytoPostnummer() {


        Getprices gp = new Getprices();


            ArrayList<Double> lista = new ArrayList();

            double a = Math.random();
            double multi = 100000;

            int priset1 = (int) (10000 + a * (multi - 10000));

            double priset= gp.getUPSPrice(priset1);
        lista.add(priset);
        if(priset <=0 || priset > 10000){
            assertTrue(false);
        }

        System.out.println(lista);


        }


    }



