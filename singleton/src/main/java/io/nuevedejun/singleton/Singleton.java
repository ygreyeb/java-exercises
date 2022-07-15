package io.nuevedejun.singleton;

public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private String str;

    private Singleton() {
        // prevent instantiation
    }

    public static Singleton getSingleInstance() {
        return INSTANCE;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

}
