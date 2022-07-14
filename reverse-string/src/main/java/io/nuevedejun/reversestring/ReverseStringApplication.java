package io.nuevedejun.reversestring;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.time.Duration;
import java.util.Map;
import java.util.function.UnaryOperator;

import io.nuevedejun.utils.Utils;

public class ReverseStringApplication {
	private static final Logger LOGGER = System.getLogger(ReverseStringApplication.class.getPackageName());

	public static void main(String[] args) {
		new ReverseStringApplication().start();
	}

	private void start() {
		measure(StringReversers.reference());
		measure(StringReversers.reverseIterateWithCharAt());
		measure(StringReversers.reverseHalfIterateWithCharAt());
	}

	private void measure(UnaryOperator<String> reverser) {
		int[] lengths = { 16, 16 * 16, 2 * 16 * 16 * 16 };
		int times = 20_000;

		for (int length : lengths) {
			String str = Utils.randomString(length);

			Duration duration = Utils.measure(() -> reverser.apply(str), times);
			LOGGER.log(Level.INFO, buildLog(reverser.toString(), length, times, duration));
		}
	}

	private CharSequence buildLog(String name, int length, int times, Duration duration) {
		return Utils.jsonLike(Map.of("name", name, "length", length, "times", times, "millis", duration.toMillis()));
	}

}
