package main.java;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        System.out.println("Cinema:");
        System.out.println("  " + "1 2 3 4 5 6 7 8");
        for(int i = 1; i < 8; i++){
            System.out.println(i + " S S S S S S S S");
        }
        priceCinema();
    }

    static void priceCinema(){
        Scanner sc = new Scanner(System.in);
        int price = 0, frontRows = 0, backRows = 0, priceFront = 0, priceBack = 0;

        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();

        if(rows * seats <= 60){
            price = 10;
            System.out.println("$" + (rows * seats) * price);
        } else {
            price = 8;
            frontRows = rows / 2;
            backRows = rows - frontRows;

            priceFront = frontRows * seats * 10;
            priceBack = backRows * seats * 8;
            System.out.println("Total income:" + "\n" + "$" + (priceFront + priceBack));
        }
    }
}