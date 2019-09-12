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
        return "BOLAG: " + name +" -"+"PRIS:"  + price + "kr";


    }

    public PriceList(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public PriceList[] Bubblesort(PriceList arr[]) {

        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j].getPrice() > arr[j + 1].getPrice()) {
                    // swap arr[j+1] and arr[i]
                    PriceList temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        return arr;

    }

    public void printArray(PriceList arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");

    }
}




