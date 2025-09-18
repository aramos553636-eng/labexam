package alfertramos;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Item> warehouseStack = new ArrayDeque<>();
        ArrayDeque<Truck> truckQueue = new ArrayDeque<>();

        int choice;

        do {
            System.out.println("\n=== WareHouse Loading System ===");
            System.out.println("[1] Store Item (push)");
            System.out.println("[2] View Warehouse Stack");
            System.out.println("[3] Register arriving truck (enqueue)");
            System.out.println("[4] View waiting Trucks");
            System.out.println("[5] Load next Truck (pop container + poll Truck)");
            System.out.println("[0] Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Code: ");
                    String code = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
				Item I = new Item(code, name, quantity);
                    warehouseStack.push(I);
                    System.out.println("Stored: " + I);
                    break;

                case 2:
                    System.out.println("TOP →");
                    for (Item ct : warehouseStack) {
                        System.out.println(ct);
                    }
                    System.out.println("← BOTTOM");
                    break;

                case 3:
                    System.out.print("Enter Plate: ");
                    String plate = sc.nextLine();
                    System.out.print("Enter Driver: ");
                    String driver = sc.nextLine();
                    Truck s = new Truck(plate, driver);
                    truckQueue.offer(s);
                    System.out.println("Registered: " + s);
                    break;

                case 4:
                    System.out.println("FRONT →");
                    for (Truck sh : truckQueue) {
                        System.out.println(sh);
                    }
                    System.out.println("← REAR");
                    break;

                case 5:
                    if (!warehouseStack.isEmpty() && !truckQueue.isEmpty()) {
                        Item load = warehouseStack.pop();
                        Truck target = truckQueue.poll();
                        System.out.println("Loaded: " + load + " → " + target);
                        System.out.println("Remaining Item: " + warehouseStack.size());
                        System.out.println("Remaining Truck: " + truckQueue.size());
                    } else {
                        System.out.println("No Item or Truck available!");
                    }
                    break;

                case 0:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
        sc.close();
    }
}
