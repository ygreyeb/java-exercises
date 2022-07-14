package io.nuevedejun.isprime;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.time.Duration;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

import io.nuevedejun.utils.Utils;

public class IsPrimeApplication {
	private static final Logger LOGGER = System.getLogger(IsPrimeApplication.class.getPackageName());

	public static void main(String[] args) {
		new IsPrimeApplication().start();
	}

	private void start() {
		measure(PrimeFilters.streamFilter());
		measure(PrimeFilters.parallelStreamFilter());
		measure(PrimeFilters.sortedStreamFilter());
	}

	private void measure(UnaryOperator<int[]> primeFilter) {
		int[] numbers = { 100, 10_000, 15_000 };
		int times = 10;

		for (int number : numbers) {
			int[] values = IntStream.range(0, number).toArray();

			Duration duration = Utils.measure(() -> primeFilter.apply(values), times);
			LOGGER.log(Level.INFO, buildLog(primeFilter.toString(), number, times, duration));
		}
	}

	private CharSequence buildLog(String name, int number, int times, Duration duration) {
		return Utils.jsonLike(Map.of("name", name, "number", number, "times", times, "millis", duration.toMillis()));
	}

}
