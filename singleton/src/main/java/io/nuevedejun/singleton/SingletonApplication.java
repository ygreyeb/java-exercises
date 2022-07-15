package io.nuevedejun.singleton;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class SingletonApplication {
	private static final Logger LOGGER = System.getLogger(SingletonApplication.class.getPackageName());

	public static void main(String[] args) {
		new SingletonApplication().start();
	}

	private void start() {
		Singleton singleton0 = Singleton.getSingleInstance();
		Singleton singleton1 = Singleton.getSingleInstance();

		LOGGER.log(Level.INFO, singleton0 + " = " + singleton1);
	}

}
