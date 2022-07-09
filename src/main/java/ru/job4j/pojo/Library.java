package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book donQuixote = new Book("Don Quixote", 764);
        Book theCatherInTheRye = new Book("The Cather in the Rye", 257);
        Book theFellowshipOfTheRing = new Book("The Fellowship of the Ring", 479);
        Book cleanCode = new Book("Clean Code", 0);
        Book[] books = new Book[4];
        books[0] = donQuixote;
        books[1] = theCatherInTheRye;
        books[2] = theFellowshipOfTheRing;
        books[3] = cleanCode;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getNumberOfPages());
        }

        System.out.println("\nReplace Don for Clean \n");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getNumberOfPages());
        }

        System.out.println("\nShown only clean coded books \n");
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if ("Clean Code".equals(bk.getName())) {
                System.out.println(bk.getName() + " - " + bk.getNumberOfPages());
            }
        }
    }
}
