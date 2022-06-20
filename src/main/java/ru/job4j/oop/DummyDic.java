package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        eng = "addictive";
        return eng;
    }

    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        String unknown = "";
        System.out.println("Неизвестное слово. " + word.engToRus(unknown));
   }
}
