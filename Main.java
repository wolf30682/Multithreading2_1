package Multithreading2_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Shop shop = new Shop();
        new Thread(null, shop::sellAuto, "Покупатель 1").start();
        new Thread(null, shop::sellAuto, "Покупатель 2").start();
        new Thread(null, shop::sellAuto, "Покупатель 3").start();

        new Thread(null, shop::acceptAuto, "Производитель Volvo").start();
    }
}



