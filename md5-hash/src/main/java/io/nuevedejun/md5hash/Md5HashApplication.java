package io.nuevedejun.md5hash;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.time.Duration;
import java.util.Map;
import java.util.function.Function;

import io.nuevedejun.utils.Utils;

public class Md5HashApplication {
	private static final Logger LOGGER = System.getLogger(Md5HashApplication.class.getPackageName());

	public static void main(String[] args) {
		new Md5HashApplication().start();
	}

	private void start() {
		measure(Md5HashCalculators.reference());
		measure(Md5HashCalculators.first());
	}

	private void measure(Function<String, byte[]> calculator) {
		int[] lengths = { 16, 16 * 16, 2 * 16 * 16 * 16 };
		int times = 20_000;

		for (int length : lengths) {
			String str = Utils.randomString(length);

			Duration duration = Utils.measure(() -> calculator.apply(str), times);
			LOGGER.log(Level.INFO, buildLog(calculator.toString(), length, times, duration));
		}
	}

	private CharSequence buildLog(String name, int length, int times, Duration duration) {
		return Utils.jsonLike(Map.of("name", name, "length", length, "times", times, "millis", duration.toMillis()));
	}

}
