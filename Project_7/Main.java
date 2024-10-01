package Project_7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBase database = new DataBase();
        Scanner read = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Subscription Management System!");
            System.out.println("Please select the option which you want to do today:");
            System.out.println("1. Create a new subscription");
            System.out.println("2. Update an existing subscription");
            System.out.println("3. Cancel a subscription");
            System.out.println("4. View all subscriptions");
            System.out.println("5. View a specific subscription");
            System.out.println("6. End the program");
            System.out.print("Enter your choice:  "); int choice = read.nextInt();
            read.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Create a new subscription:");
                    System.out.print("Enter subscription type (Magazine, Streaming, Freemium): "); String type = read.nextLine();
                    if (type.equalsIgnoreCase("Magazine")) {
                        Magazine.createMagazine(database, read);
                    } else if (type.equalsIgnoreCase("Streaming")) {
                        Streaming.createStreaming(database, read);
                    } else if (type.equalsIgnoreCase("Freemium")) {
                        Freemium.createFreemium(database, read);
                    } else {
                        System.out.println("Invalid subscription type. Please try again.");
                    }
                    break;
                case 2:
                    System.out.println("Update an existing subscription:");
                    System.out.print("Enter subscription type (Magazine, Streaming, Freemium): ");
                    type = read.nextLine();

                    if (type.equalsIgnoreCase("Magazine")) {
                        Magazine.updateMagazine(database, read);
                    } else if (type.equalsIgnoreCase("Streaming")) {
                        Streaming.updateStreaming(database, read);
                    } else if (type.equalsIgnoreCase("Freemium")) {
                        Freemium.updateFreemium(database, read);
                    } else {
                        System.out.println("Invalid subscription type. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Cancel a subscription:");
                    System.out.print("Enter subscription type (Magazine, Streaming, Freemium): ");
                    type = read.nextLine();
                    if (type.equalsIgnoreCase("Magazine")) {
                        Magazine.cancelMagazine(database, read);
                    } else if (type.equalsIgnoreCase("Streaming")) {
                        Streaming.cancelStreaming(database, read);
                    } else if (type.equalsIgnoreCase("Freemium")) {
                        Freemium.cancelFreemium(database, read);
                    } else {
                        System.out.println("Invalid subscription type. Please try again.");
                    }
                    break;
                case 4:
                    System.out.println("View all subscriptions:");
                    database.viewAllSubscriptions();
                    break;
                case 5:
                    System.out.println("View a specific subscription Status:");
                    System.out.print("Enter subscription type (Magazine, Streaming, Freemium): "); type = read.nextLine();
                    if (type.equalsIgnoreCase("Magazine")) {
                        Magazine.viewMagazine(database, read);
                    } else if (type.equalsIgnoreCase("Streaming")) {
                        Streaming.viewStreaming(database, read);
                    } else if (type.equalsIgnoreCase("Freemium")) {
                        Freemium.viewFreemium(database, read);
                    } else {
                        System.out.println("Invalid subscription type");
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using our Subscription Management System!!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}