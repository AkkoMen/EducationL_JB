package main.java;

import java.util.Scanner;

public class OldTask {

    public static void partScan(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int nextDet;
        int larger = 0, smaller = 0, perfect = 0;
        for(int i = 0; i < num; i++){
            nextDet = sc.nextInt();
            if(nextDet == 1)
                larger++;

            else if(nextDet == -1)
                smaller++;

            else if(nextDet == 0)
                perfect++;
        }
        System.out.println(perfect + " " + larger + " " + smaller);
    }

    public static void maxNum(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int nextNum;
        int maxNum = 0;
        int i = 0;
        while (i < num){
            nextNum = sc.nextInt();
            i++;
            if(nextNum % 4 == 0){
                if(nextNum > maxNum)
                    maxNum = nextNum;
            }
        }
        System.out.println(maxNum);
    }

    public static void squaresNum(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i * i <= n; i++) {
            System.out.println(i * i);
        }
    }

    public static void crashBus(){
        Scanner sc = new Scanner(System.in);
        int heightBrdge = 0;
        int carHeight = sc.nextInt();
        int numBridge = sc.nextInt();

        int i = numBridge;
        boolean crash = false;
        for (i = 0; i < numBridge; i++) {
            heightBrdge = sc.nextInt();
            if (carHeight >= heightBrdge) {
                crash = true;
                break;
            }
        }
        if(crash){
            System.out.println("Will crash on bridge " + i);
        } else {
            System.out.println("Will not crash");
        }
    }

}
