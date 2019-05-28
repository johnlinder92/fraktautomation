package com.newton.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PriceList {

    public double price;
    private String name;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "pris: " + price + "kr"+ "\n" +
                "bolag: " + name;

    }

    public PriceList(double price, String name) {
        this.price = price;
        this.name = name;
    }
    /*public ArrayList priceSort(PriceList a, PriceList b, PriceList c){

        ArrayList<PriceList> prislista = new ArrayList();

        prislista.add(a);
        prislista.add(b);
        prislista.add(c);

        for(int j =0; j< (prislista.size()); j++)
            if( prislista.get((prislista.size()-1)-j).getPrice() < prislista.get(j).getPrice()){

                PriceList objectvidsistaindex= prislista.get(((prislista.size()-1)-j));
                int indexj = 0+j;
                int sistaindex = 2;
                int
                PriceList objektvidindexj = (prislista.get(j));

                prislista.set(indexj,objectvidsistaindex);
                prislista.set(sistaindex, objektvidindexj);

            }

        return prislista;
    }*/

    public PriceList sortdouble(PriceList a, PriceList b){
        PriceList sorteratpris= new PriceList(0.0,"Default");

        if(a.getPrice()>b.getPrice()) {
           sorteratpris=  b;
        }else{
           sorteratpris= a;

        }
        return sorteratpris;
    }

}




