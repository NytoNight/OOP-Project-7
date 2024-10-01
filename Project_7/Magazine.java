// Magazine class
package Project_7;

import java.util.Scanner;

public class Magazine extends Subscription {
    private String name;
    private String deliveryType;
    private String startDate;
    private String endDate;
    private String status;

    public Magazine(String startDate, String endDate, String status, String name, String deliveryType) {
        super(startDate, endDate, status);
        this.name = name;
        this.deliveryType = deliveryType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    @Override
    protected void create() {
        System.out.println("Creating a new magazine subscription");
    }

    @Override
    protected void update() {
        System.out.println("Updating the magazine subscription");
    }

    @Override
    protected void cancel() {
        System.out.println("Canceling the magazine subscription");
    }

    @Override
    protected void history() {
        System.out.println("Showing the history of the magazine subscription");
    }

    @Override
    protected void status() {
        System.out.println("Showing the status of the magazine subscription");
    }

    public static void createMagazine(DataBase database, Scanner read) {
        System.out.print("Enter magazine name:");
        String name = read.nextLine();
        System.out.print("Enter delivery type (Online, Physical):");
        String deliveryType = read.nextLine();
        System.out.print("Enter start date (example: 2024 08 26):");
        String startDate = read.nextLine();
        System.out.print("Enter end date (example: 2024 08 26):");
        String endDate = read.nextLine();
        Magazine magazine = new Magazine(startDate, endDate, "Active", name, deliveryType);
        database.add_magazine(magazine);
        System.out.println("Added magazine to your subscriptions!!");
        System.out.println("==========================================================================================================");
    }

    public static void updateMagazine(DataBase database, Scanner read) {
        System.out.println("Enter magazine name:");
        String name = read.nextLine();
        System.out.println("Enter new delivery type (Online, Physical):");
        String deliveryType = read.nextLine();
        System.out.println("Enter new start date (example: 2024 08 26):");
        String startDate = read.nextLine();
        System.out.println("Enter new end date (example: 2024 08 26):");
        String endDate = read.nextLine();
        Magazine magazine = new Magazine(startDate, endDate, "Active", name, deliveryType);
        database.updateMagazine(magazine, 0);
        System.out.println("Updated the Magazine!!");
        System.out.println("==========================================================================================================");
    }

    public static void cancelMagazine(DataBase database, Scanner read) {
        System.out.print("Enter magazine name:");
        String name = read.nextLine();
        System.out.println("Cancelled the chosen Magazine!!");
        System.out.println("==========================================================================================================");
        Magazine magazine = new Magazine("Cancelled", "Cancelled", "Cancelled", name, "Cancelled");
        database.updateMagazine(magazine, 0);
    }

    public static void viewMagazine(DataBase database, Scanner read) {
        System.out.print("Enter magazine name:");
        String name = read.nextLine();
        for (Magazine magazine : database.getAllMagazines()) {
            if (magazine.getName().equals(name)) {
                System.out.println("The Magazine:  " +magazine.getName() +" is" + " " + magazine.getStatus());
                return;
            }
        }
        System.out.println("Magazine subscription not found.");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}