package com.company.pattern;

import java.util.Date;

public class FactoryApp {
    public static void main(String[] args) {
// WatchMaker maker = new DigitalWatchMaker();
 WatchMaker maker = new RomeWatchMaker();
Watch watch = maker.createWatch();
watch.showTime();
    }
}
interface Watch {
    void showTime();

}
class DigitalWatch implements Watch {
    public void showTime() {
        System.out.println(new Date());
    }
}
class RomeWatch implements Watch {
    public void showTime() {
        System.out.println("II--VV");
    }
}
interface WatchMaker {
    Watch createWatch();
}
class DigitalWatchMaker implements WatchMaker {

    public Watch createWatch() {
        return new DigitalWatch();
    }
}
class RomeWatchMaker implements WatchMaker {

    public Watch createWatch() {
        return new RomeWatch();
    }
}