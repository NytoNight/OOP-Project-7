package Project_7;

import java.util.Scanner;

public class Streaming extends Subscription {
    private String name;
    private int deviceLimit;
    private String plan;

    public Streaming(String startDate, String endDate, String status, String name, int deviceLimit, String plan) {
        super(startDate, endDate, status);
        this.name = name;
        this.deviceLimit = deviceLimit;
        this.plan = plan;
    }

    @Override
    protected void create() {
        System.out.println("Creating a new streaming subscription...");
    }

    @Override
    protected void update() {
        System.out.println("Updating the streaming subscription...");
    }

    @Override
    protected void cancel() {
        System.out.println("Canceling the streaming subscription...");
    }

    @Override
    protected void history() {
        System.out.println("Showing the history of the streaming subscription...");
    }

    @Override
    protected void status() {
        System.out.println("Showing the status of the streaming subscription...");
    }

    public static void createStreaming(DataBase database, Scanner read) {
        System.out.print("Enter streaming name:");
        String name = read.nextLine();
        System.out.print("Enter device limit:");
        int deviceLimit = read.nextInt();
        read.nextLine();
        System.out.print("Enter plan (Solo, Family, etc.): ");
        String plan = read.nextLine();
        System.out.print("Enter start date (example: 2024-08-26): ");
        String startDate = read.nextLine();
        System.out.print("Enter end date (example: 2024-08-26): ");
        String endDate = read.nextLine();
        Streaming streaming = new Streaming(startDate, endDate, "Active", name, deviceLimit, plan);
        database.addStreaming(streaming);
        System.out.println("Added Streaming Site to your subscriptions!!");
        System.out.println("==========================================================================================================");
    }

    public static void updateStreaming(DataBase database, Scanner read) {
        System.out.println("Enter streaming name:");
        String name = read.nextLine();
        System.out.println("Enter new device limit:");
        int deviceLimit = read.nextInt();
        read.nextLine();
        System.out.println("Enter new plan (Solo, Family, etc.):");
        String plan = read.nextLine();
        System.out.println("Enter new start date (example: 2024-08-26):");
        String startDate = read.nextLine();
        System.out.println("Enter new end date (example: 2024-08-26):");
        String endDate = read.nextLine();
        Streaming streaming = new Streaming(startDate, endDate, "Active", name, deviceLimit, plan);
        database.updateStreaming(streaming, 0);
        System.out.println("Updated the Chosen Streaming Site to your subscriptions!!");
        System.out.println("==========================================================================================================");
    }

    public static void cancelStreaming(DataBase database, Scanner read) {
        System.out.println("Enter streaming site name (Example Netflix):");
        String name = read.nextLine();
        Streaming streaming = new Streaming("Cancelled", "Cancelled", "Cancelled", name, 0, "Cancelled");
        database.updateStreaming(streaming, 0);
        System.out.println("Cancelled the chosen Streaming Site!!");
        System.out.println("==========================================================================================================");
    }

    public static void viewStreaming(DataBase database, Scanner scanner) {
        System.out.println("Enter streaming name (Example Netflix):"); String name = scanner.nextLine();
        for (Streaming streaming : database.getAllStreamings()) {
            if (streaming.getName().equals(name)) {
                System.out.println("The Magazine:  " +streaming.getName() +" is" + " " + streaming.getStatus());
                return;
            }
        }
        System.out.println("Streaming subscription not found.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeviceLimit() {
        return deviceLimit;
    }

    public void setDeviceLimit(int deviceLimit) {
        this.deviceLimit = deviceLimit;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}