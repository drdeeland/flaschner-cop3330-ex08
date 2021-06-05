/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Dillon Flaschner
 */

package base;

import java.util.Scanner;

public class App {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        String peopleString = myApp.setPeople();
        String pizzaString = myApp.setPizza();
        String slicesString = myApp.setSlices();

        int people = Integer.parseInt(peopleString);
        int pizza = Integer.parseInt(pizzaString);
        int slicesPerPizza = Integer.parseInt(slicesString);
        int totalSlices = pizza * slicesPerPizza;

        myApp.outputStats(people, pizza, totalSlices);

        int slicesPerPerson = myApp.slicesPerPersonCalc(people, totalSlices);
        int leftoverPieces = myApp.leftoverPiecesCalc(totalSlices, slicesPerPerson, people);

        myApp.slicesPerPersonOutput(slicesPerPerson);
        myApp.leftoverPiecesOutput(leftoverPieces);
    }

    public String setPeople() {
        System.out.print("How many people? ");
        return input.nextLine();
    }

    public String setPizza() {
        System.out.print("How many pizzas do you have? ");
        return input.nextLine();
    }

    public String setSlices() {
        System.out.print("How many slices per pizza? ");
        String slices = input.nextLine();

        int slicesInt = Integer.parseInt(slices);

        if (slicesInt%2 == 0) {
            return slices;
        } else {
            System.out.println("Ensure that the number of pieces are even.");
            return setSlices();
        }

    }

    public void outputStats(int people, int pizza, int slices) {
        System.out.println(people + " people with " + pizza + " pizzas (" +slices + " slices)");
    }

    //slices per person calc
    public int slicesPerPersonCalc(int people, int totalSlices) {
        return totalSlices/people;
    }

    //leftover pieces calc
    public int leftoverPiecesCalc(int totalSlices, int slicesPerPerson, int people) {
        return totalSlices - (slicesPerPerson * people);
    }

    //slices per person output
    public void slicesPerPersonOutput(int slicesPerPerson) {
        System.out.println("Each person gets " + slicesPerPerson + " pieces of pizza.");
    }

    //leftover output
    public void leftoverPiecesOutput(int leftoverPieces) {
        System.out.println("There are " + leftoverPieces + " leftover pieces.");
    }
}
