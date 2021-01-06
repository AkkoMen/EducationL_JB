package main.java;

import java.util.*;

public class CinemaHyperSkill {

    static final Scanner sc = new Scanner(System.in);
    static final String BUY = "B", SIT = "S";
    static String[][] cinemaHall;

    static int currentIncome;
    static int numberBuyTickets;
    static int totalIncome;

    public static void main(String[] args) {
        createCinemaHall();
        cinemaConsole();
    }


    static void cinemaConsole() {
        int num;
        System.out.println();
        System.out.println("1. Show the seats" + "\n" + "2. Buy a ticket" + "\n" + "3. Statistics" + "\n" + "0. Exit");
        num = sc.nextInt();
        switch (num) {
            case 0:
                break;
            case 1:
                printCinema(cinemaHall);
            case 2:
                buySitCinema(cinemaHall);
            case 3:
                showStatistics(cinemaHall);
            default:
                System.out.println("It doesn't exist!");
        }
    }


    static void createCinemaHall() {
        System.out.println("Enter the number of rows:");
        int numberOfRows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = sc.nextInt();

        cinemaHall = new String[numberOfRows][numberOfSeats];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfSeats; j++) {
                cinemaHall[i][j] = SIT;
            }
        }
        int totalNumOfSeats = cinemaHall.length * cinemaHall[0].length;
        if (totalNumOfSeats <= 60) {
            totalIncome = totalNumOfSeats * 10;
        } else {
            int frontHalfOfRows = cinemaHall.length / 2;
            int totalFrontHalf = frontHalfOfRows * cinemaHall[0].length * 10;
            int totalBackHalf = (cinemaHall.length - frontHalfOfRows) * cinemaHall[0].length * 8;
            totalIncome = totalFrontHalf + totalBackHalf;
        }

    }


    static void showStatistics(String[][] cinemaHall) {
        System.out.println("Number of purchased tickets: " + numberBuyTickets);
        float totalNumOfSeats = cinemaHall.length * cinemaHall[0].length;
        float percentageTickets = 100 / totalNumOfSeats * numberBuyTickets;
        System.out.printf("Percentage: %.2f%s%n", percentageTickets, "%");

        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }


    static void printCinema(String[][] cinemaHall) {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= cinemaHall[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < cinemaHall.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < cinemaHall[0].length; j++) {
                System.out.print(" " + cinemaHall[i][j]);
            }
            System.out.println();
        }
        cinemaConsole();
    }

    static void buySitCinema(String[][] cinemaHall) {
        int totalNumberOfSeats = cinemaHall.length * cinemaHall[0].length;
        System.out.println();
        System.out.println("Enter a row number:");
        int seatRow = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = sc.nextInt();

        if (seatRow > cinemaHall.length || seatNumber > cinemaHall[0].length) {
            System.out.println("Wrong input!");
        } else {
            if (cinemaHall[seatRow - 1][seatNumber - 1] == BUY) {
                System.out.println("That ticket has already been purchased!");
            }
        }


        int priceTicket;
        if (totalNumberOfSeats <= 60) {
            priceTicket = 10;
        } else {
            int frontHalfOfRows = cinemaHall.length / 2;
            if (seatRow <= frontHalfOfRows) {
                priceTicket = 10;
            } else {
                priceTicket = 8;
            }
        }

        currentIncome += priceTicket;
        numberBuyTickets++;

        System.out.println("Ticket price: $" + priceTicket);
        cinemaHall[seatRow - 1][seatNumber - 1] = BUY;

        cinemaConsole();
    }
}