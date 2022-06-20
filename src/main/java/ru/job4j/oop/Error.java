package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {

    }

    public void printError() {
        System.out.println("Активность: " + active);
        System.out.println("Состояние: " + status);
        System.out.println("Код ошибки: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error(true, 2, "Error 404.");
        error.printError();
        Error errorDefault = new Error();
        errorDefault.printError();
    }
}
