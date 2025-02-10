import java.util.Scanner;

/**
 * Main class that provides a command-line interface for interacting with the blockchain.
 * Allows users to add blocks, validate the chain, and view the blockchain.
 */
public class Main {
    /**
     * Main entry point of the application.
     * Provides a command-line menu for blockchain operations.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMini Blockchain CLI");
            System.out.println("1. Add Block");
            System.out.println("2. Delete Block");
            System.out.println("3. Validate Blockchain");
            System.out.println("4. Print Blockchain");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter block data: ");
                    String data = scanner.nextLine();
                    blockchain.addBlock(data);
                    System.out.println("Block added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Index: ");
                    int index = scanner.nextInt();
                    blockchain.DeleteBlock(index);
                    System.out.println("Block deleted successfully!");
                    break;
                case 3:
                    if (blockchain.iscahinvalid()) {
                        System.out.println("Blockchain is valid!");
                    } else {
                        System.out.println("Blockchain is NOT valid!");
                    }
                    break;
                case 4:
                    blockchain.DisplayBlockchain();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}