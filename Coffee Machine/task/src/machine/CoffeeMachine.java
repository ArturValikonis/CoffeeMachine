package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private Scanner scanner;

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    private CoffeeMachine() {
        this.scanner = new Scanner(System.in);
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        boolean workingProcess = true;

        while (workingProcess)
            workingProcess = coffeeMachine.processAction();
    }

    private boolean processAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.next();

        switch (action) {
            case "buy":
                this.processBuy();
                break;
            case "fill":
                this.processFill();
                break;
            case "take":
                this.processTake();
                break;
            case "remaining":
                this.processCountingRemainings();
                break;
            case "exit":
                return false;
        }
        return true;
    }

    private void processBuy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeSelection = scanner.next();

        if (coffeeSelection.equals("back")) return;
        else
            this.buy(Integer.valueOf(coffeeSelection));
    }

    private void buy(int coffeeSelection) {
        int waterForOneCup = 0;
        int milkForOneCup = 0;
        int beansForOneCup = 0;
        int pricePerCup = 0;

        switch (coffeeSelection) {
            case 1:
                waterForOneCup = 250;
                milkForOneCup = 0;
                beansForOneCup = 16;
                pricePerCup = 4;
                break;
            case 2:
                waterForOneCup = 350;
                milkForOneCup = 75;
                beansForOneCup = 20;
                pricePerCup = 7;
                break;
            case 3:
                waterForOneCup = 200;
                milkForOneCup = 100;
                beansForOneCup = 12;
                pricePerCup = 6;
                break;
            default:
                System.out.println("Input error!");
                break;
        }

        if (this.water < waterForOneCup) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < milkForOneCup) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.beans < beansForOneCup) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (this.cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= waterForOneCup;
            this.milk -= milkForOneCup;
            this.beans -= beansForOneCup;
            this.cups--;
            this.money += pricePerCup;
        }
    }

    private void processFill() {
        System.out.println("Write how many ml of water do you want to add:");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        this.beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        this.cups += scanner.nextInt();
    }

    private void processTake() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }

    private void processCountingRemainings() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.beans + " of coffee beans");
        System.out.println(this.cups + " of disposable cups");
        System.out.println("$" + this.money + " of money");
    }
}
