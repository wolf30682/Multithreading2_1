package Multithreading2_1;

public class Seller {
    private Shop shop;

    public Seller(Shop shop) {
        this.shop = shop;
    }

    public synchronized void receiveAuto() {
        try {
            for (int i = 0; i < 3; i++) {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + " выпустил 1 новое авто");
                Thread.sleep(3000);
                shop.getAutos().add(new Auto());
                System.out.println("Автосалон: Авто готово к продаже!");
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Auto sellAuto() {
        try {
            System.out.println("Автосалон: Продаю авто");
            while (shop.getAutos().size() == 0) {
                System.out.println("Машин нет");
                wait();
            }
            Thread.sleep(1000);
            System.out.println("Автосалон: Продано");
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + " уехал на новеньком авто!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return shop.getAutos().remove(0);
    }
}