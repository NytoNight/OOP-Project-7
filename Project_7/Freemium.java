package Project_7;

import java.util.Scanner;

public class Freemium extends Subscription {
    private String name;
    private int trialPeriod;

    public Freemium(String name, String startDate, String endDate, String status, int trialPeriod) {
        super(startDate, endDate, status);
        this.name = name;
        this.trialPeriod = trialPeriod;
    }

    @Override
    public void create() {
        System.out.println("Creating a new freemium subscription...");
    }

    @Override
    public void update() {
        System.out.println("Updating the freemium subscription...");
    }

    @Override
    public void cancel() {
        System.out.println("Canceling the freemium subscription...");
    }

    @Override
    public void history() {
        System.out.println("Showing the history of the freemium subscription...");
    }

    @Override
    public void status() {
        System.out.println("Showing the status of the freemium subscription...");
    }

    public static void createFreemium(DataBase database, Scanner read) {
        System.out.print("Enter the name of the freemium site:");
        String name = read.nextLine();
        System.out.print("Enter the amount of trial days (example: 50 Days):");
        int trialPeriod = read.nextInt();
        read.nextLine();
        System.out.print("Enter start date (example: 2024 08 26):");
        String startDate = read.nextLine();
        System.out.print("Enter end date (example: 2024 08 26):");
        String endDate = read.nextLine();
        Freemium freemium = new Freemium(name, startDate, endDate, "Active", trialPeriod);
        database.addFreemium(freemium);
        System.out.println("Added Freemium Site to your subscriptions!!");
        System.out.println("==========================================================================================================");
    }

    public static void updateFreemium(DataBase database, Scanner read) {
        System.out.print("Enter the name of the freemium site:");
        String name = read.nextLine();
        System.out.print("Enter the updated  trial days (example: 50 Days):");
        int trialPeriod = read.nextInt();
        read.nextLine();
        System.out.print("Enter new start date (example: 2024 08 26):");
        String startDate = read.nextLine();
        System.out.print("Enter new end date (example: 2024 08 26):");
        String endDate = read.nextLine();
        Freemium freemium = new Freemium(name, startDate, endDate, "Active", trialPeriod);
        database.updateFreemium(freemium, 0);
        System.out.println("Updated the  Freemium Account to your subscriptions!!");
        System.out.println("==========================================================================================================");
    }

    public static void cancelFreemium(DataBase database, Scanner scanner) {
        System.out.print("Enter the name of the freemium site:");
        String name = scanner.nextLine();
        System.out.println("Enter trial period (in days):");
        int trialPeriod = scanner.nextInt();
        scanner.nextLine();
        Freemium freemium = new Freemium(name, "Cancelled", "Cancelled", "Cancelled", trialPeriod);
        database.updateFreemium(freemium, 0);
        System.out.println("Cancelled the chosen Freemium Account!!");
        System.out.println("==========================================================================================================");
    }

    public static void viewFreemium(DataBase database, Scanner read) {
        System.out.print("Enter the name of the freemium site:");
        String name = read.nextLine();
        System.out.print("Enter trial period (example: 50):");
        int trialPeriod = read.nextInt();
        read.nextLine();
        for (Freemium freemium : database.getAllFreemiums()) {
            if (freemium.getName().equals(name) && freemium.getTrialPeriod() == trialPeriod) {
                System.out.println(" The Current status for the Freemium Account: " + freemium.getName() + " with " + freemium.getTrialPeriod() + " Days" + " and is " + " " + freemium.getStatus());
                return;
            }
        }
        System.out.println("Freemium subscription not found.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrialPeriod() {
        return trialPeriod;
    }

    public void setTrialPeriod(int trialPeriod) {
        this.trialPeriod = trialPeriod;
    }
}