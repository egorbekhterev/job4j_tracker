package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        eng = "addictive";
        return eng;
    }

    public static void main(String[] args) {
        String x = "";
        DummyDic peppy = new DummyDic();
        String unknown = peppy.engToRus(x);
        System.out.println("Неизвестное слово. " + unknown);
   }
}
