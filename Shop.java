package Multithreading2_1;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    Seller seller = new Seller(this);
    List<Auto> autos = new ArrayList<>(10);

    public synchronized Auto sellAuto() {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " зашел в автосалон");
        return seller.sellAuto();
    }

    public void acceptAuto() {
        seller.receiveAuto();
    }

    List<Auto> getAutos() {
        return autos;
    }
}
