import java.util.*;

class OnlineFoodOrderingSystem {

    static String[] menu = {"Burger", "Pizza", "Pasta", "Sandwich", "Ice Cream"};
    static Queue<String> pendingOrders = new LinkedList<>();
    static Stack<String> deliveredOrders = new Stack<>();
    static LinkedList<String> orderHistory = new LinkedList<>();

    static void showMenu() {
        System.out.println("Menu:");
        for(String item : menu) {
            System.out.println("- " + item);
        }
    }

    static void placeOrder(String customerName, String item) {
        boolean available = false;
        for(String m : menu) {
            if(m.equalsIgnoreCase(item)) {
                available = true;
                break;
            }
        }
        if(available) {
            String order = customerName + " ordered " + item;
            pendingOrders.add(order);
            orderHistory.add(order);
            System.out.println("Order placed: " + order);
        } else {
            System.out.println("Item not available in menu.");
        }
    }

    static void deliverOrder() {
        if(pendingOrders.isEmpty()) {
            System.out.println("No pending orders to deliver.");
        } else {
            String order = pendingOrders.poll();
            deliveredOrders.push(order);
            System.out.println("Order delivered: " + order);
        }
    }

    static void showDeliveredOrders() {
        if(deliveredOrders.isEmpty()) {
            System.out.println("No delivered orders.");
        } else {
            System.out.println("Recently Delivered Orders:");
            Stack<String> temp = (Stack<String>) deliveredOrders.clone();
            while(!temp.isEmpty()) {
                System.out.println(temp.pop());
            }
        }
    }

    static void showOrderHistory() {
        if(orderHistory.isEmpty()) {
            System.out.println("No order history.");
        } else {
            System.out.println("Customer Order History:");
            for(String order : orderHistory) {
                System.out.println(order);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\n--- Online Food Ordering System ---");
            System.out.println("1. Show Menu");
            System.out.println("2. Place Order");
            System.out.println("3. Deliver Order");
            System.out.println("4. Show Delivered Orders");
            System.out.println("5. Show Customer Order History");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1) {
                showMenu();
            } else if(choice == 2) {
                System.out.print("Enter Customer Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Item: ");
                String item = sc.nextLine();
                placeOrder(name, item);
            } else if(choice == 3) {
                deliverOrder();
            } else if(choice == 4) {
                showDeliveredOrders();
            } else if(choice == 5) {
                showOrderHistory();
            } else if(choice == 6) {
                System.out.println("Exiting System.");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
