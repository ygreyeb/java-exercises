package io.nuevedejun.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SingletonTests {

    @Test
    void testSingleton() {
        Singleton singleton0 = Singleton.getSingleInstance();

        singleton0.setStr("str");

        Singleton singleton1 = Singleton.getSingleInstance();
        assertEquals(singleton1, singleton0);
        assertEquals("str", singleton1.getStr());
    }

}
