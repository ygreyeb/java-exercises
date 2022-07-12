package io.nuevedejun.reversestring;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.time.Duration;
import java.util.function.UnaryOperator;

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

			Duration duration = measure(() -> reverser.apply(str), times);
			LOGGER.log(Level.INFO, buildLog(reverser.toString(), length, times, duration));
		}
	}

	private StringBuilder buildLog(String name, int length, int times, Duration duration) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"name\": \"").append(name).append("\", ");
		sb.append("\"length\": ").append(length).append(", ");
		sb.append("\"times\": ").append(times).append(", ");
		sb.append("\"millis\": ").append(duration.toMillis());
		sb.append("}");
		return sb;
	}

	private Duration measure(Runnable runnable, int times) {
		long elapsed = 0;
		for (int i = 0; i < times; i++) {
			long start = System.nanoTime();
			runnable.run();
			elapsed = elapsed + System.nanoTime() - start;
		}
		return Duration.ofNanos(elapsed);
	}

}
