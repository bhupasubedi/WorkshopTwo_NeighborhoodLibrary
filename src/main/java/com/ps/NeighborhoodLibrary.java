package com.ps;

import java.util.Scanner;

public class NeighborhoodLibrary {

    static Scanner scanner = new Scanner(System.in);
    static Book[] inventory = new Book[20];

    public static void main(String[] args) {

        Book book1 = new Book(1, "9780-12345-678-9", "The Great Adventure", false, "");
        Book book2 = new Book(2, "9780-23456-789-0", "Mystery at Midnight", true, "Alice");
        Book book3 = new Book(3, "9780-34567-890-1", "A Journey Through Time", false, "");
        Book book4 = new Book(4, "9780-45678-901-2", "Secrets of the Forest", true, "Bob");
        Book book5 = new Book(5, "9780-56789-012-3", "The Lost City", false, "");
        Book book6 = new Book(6, "9780-67890-123-4", "Whispers in the Dark", true, "Charlie");
        Book book7 = new Book(7, "9780-78901-234-5", "The Science of Tomorrow", false, "");
        Book book8 = new Book(8, "9780-89012-345-6", "Art of Deception", true, "Dana");
        Book book9 = new Book(9, "9780-90123-456-7", "Echoes of the Past", false, "");
        Book book10 = new Book(10, "9780-01234-567-8", "Tales from the Sea", true, "Eve");
        Book book11 = new Book(11, "9780-12345-678-0", "Finding Balance", false, "");
        Book book12 = new Book(12, "9780-23456-789-1", "The Last Kingdom", true, "Frank");
        Book book13 = new Book(13, "9780-34567-890-2", "Journey of the Mind", false, "");
        Book book14 = new Book(14, "9780-45678-901-3", "Chasing Dreams", true, "Grace");
        Book book15 = new Book(15, "9780-56789-012-4", "Through the Looking Glass", false, "");
        Book book16 = new Book(16, "9780-67890-123-5", "The Power of Now", true, "Hannah");
        Book book17 = new Book(17, "9780-78901-234-6", "A World Apart", false, "");
        Book book18 = new Book(18, "9780-89012-345-7", "Beneath the Surface", true, "Ian");
        Book book19 = new Book(19, "9780-90123-456-8", "Whispers of the Wind", false, "");
        Book book20 = new Book(20, "9780-01234-567-9", "The Hidden Path", true, "Jack");

        inventory[0] = book1;
        inventory[1] = book2;
        inventory[2] = book3;
        inventory[3] = book4;
        inventory[4] = book5;
        inventory[5] = book6;
        inventory[6] = book7;
        inventory[7] = book8;
        inventory[8] = book9;
        inventory[9] = book10;
        inventory[10] = book11;
        inventory[11] = book12;
        inventory[12] = book13;
        inventory[13] = book14;
        inventory[14] = book15;
        inventory[15] = book16;
        inventory[16] = book17;
        inventory[17] = book18;
        inventory[18] = book19;
        inventory[19] = book20;

        int screen;
        do {
            System.out.println("1) Show Available Books");
            System.out.println("2) Show Checked Out Books");
            System.out.println("3) - Exit ");

            System.out.println("Enter the your choice: ");

            screen = scanner.nextInt();

            switch (screen) {
                case 1:
                    showAvailableBooks();
                    break;
                case 2:
                    CheckedOut();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("command not found! Try again");
                    break;
            }

        }

        while (screen != 3);
    }

    public static void CheckedOut() {
        for (Book book : inventory) {
            if (book.getCheckedOut()) {
                System.out.println(book);
            }

        }

        String choice;
        do {
            System.out.println("C. Select a book to check in");
            System.out.println("X. Go back to the home screen");
            choice = scanner.nextLine().trim();


            switch (choice) {
                case "C":
                    promptToCheckInBook();
                    break;
                case "X":
                    System.out.println(" Exiting the main menu");
                    break;
                default:
                    System.out.println("Invalid choice, try again");
            }

        } while (!choice.equals("X"));


    }

    public static void showAvailableBooks() {
        for (Book book : inventory) {
            if (!book.getCheckedOut()) {
                System.out.println(book);
            }
        }

        int choice;
        do {
            System.out.println("1. Select a book to checkout");
            System.out.println("2. Exit to main menu");
            choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    promptToCheckOutBook();
                    break;
                case 2:
                    System.out.println(" Exit the main menu");
                    break;
                default:
                    System.out.println("Invalid choice, try again");
            }

        } while (choice != 2);

    }

    public static void promptToCheckOutBook() {

        System.out.println("Enter the book Id");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please, enter your name to check out a book ");
        String userName = scanner.nextLine();


        for (Book book : inventory) {
            if (!book.getCheckedOut() && book.getId() == choice) {
                book.setCheckedOut(true);
                book.setCheckedOutTo(userName);
            }

        }

    }


    public static void promptToCheckInBook() {

        System.out.println("Enter the book Id");
        int choice = scanner.nextInt();
        for (Book book : inventory) {
            if (book.getCheckedOut() && book.getId() == choice) {
                book.setCheckedOut(false);
                book.setCheckedOutTo("");
            }

        }

    }


}

