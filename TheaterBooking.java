import java.util.Scanner;

public class TheaterBooking {
    private static final int ROWS = 150;
    private static final int COLUMNS = 150;
    private static char[][] seats = new char[ROWS][COLUMNS];

    public static void main(String[] args) {
        initializeSeats();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTheater Booking System");
            System.out.println("1. Display seating arrangements.");
            System.out.println("2. Book a seat.");
            System.out.println("3. Cancel the booking.");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displaySeatingArrangements();
                    break;
                case 2:
                    bookSeat(scanner);
                    break;
                case 3:
                    cancelBooking(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("You entered an invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void initializeSeats() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                seats[i][j] = 'O'; // 'O' represents an available seat
            }
        }
    }

    public static void displaySeatingArrangements() {
        System.out.println("\nSeating Arrangements:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bookSeat(Scanner scanner) {
        System.out.print("Enter row number (0-4): ");
        int row = scanner.nextInt();
        System.out.print("Enter column number (0-4): ");
        int column = scanner.nextInt();

        if (row >= 0 && row < ROWS && column >= 0 && column < COLUMNS) {
            if (seats[row][column] == 'O') {
                seats[row][column] = 'X'; // 'X' represents a booked seat
                System.out.println("Seat booked successfully.");
            } else {
                System.out.println("Seat is already booked.");
            }
        } else {
            System.out.println("Invalid seat number. Please try again.");
        }
    }

    private static void cancelBooking(Scanner scanner) {
        System.out.print("Enter row number (0-4): ");
        int row = scanner.nextInt();
        System.out.print("Enter column number (0-4): ");
        int column = scanner.nextInt();

        if (row >= 0 && row < ROWS && column >= 0 && column < COLUMNS) {
            if (seats[row][column] == 'X') {
                seats[row][column] = 'O'; // 'O' represents an available seat
                System.out.println("Booking cancelled successfully.");
            } else {
                System.out.println("Seat is not booked.");
            }
        } else {
            System.out.println("Invalid seat number. Please try again.");
        }
    }
}