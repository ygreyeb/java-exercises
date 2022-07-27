package io.nuevedejun.isprime;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.IntPredicate;
import java.util.function.UnaryOperator;

public class PrimeFilters {
    private static final int INITIAL_PRIMES_LIMIT = 10_000;

    private PrimeFilters() {
        // prevent instantiation
    }

    public static UnaryOperator<int[]> streamFilter() {
        return create("streamFilter", numbers -> Arrays.stream(numbers).filter(isPrime()).toArray());
    }

    public static UnaryOperator<int[]> sortedStreamFilter() {
        return create("sortedStreamFilter",
                numbers -> Arrays.stream(numbers).map(i -> ~i).sorted().map(i -> ~i).filter(isPrime()).toArray());
    }

    public static UnaryOperator<int[]> parallelStreamFilter() {
        return create("parallelStreamFilter", numbers -> Arrays.stream(numbers).parallel().filter(isPrime()).toArray());
    }

    private static IntPredicate isPrime() {
        AtomicReference<WeakReference<List<Boolean>>> primesRef = new AtomicReference<>(
                new WeakReference<>(calculatePrimes(INITIAL_PRIMES_LIMIT, List.of())));
        return n -> {
            List<Boolean> primes = primesRef.get().get();
            if (primes != null) {
                if (n >= primes.size()) {
                    primes = updateReference(primesRef, n);
                }
            } else {
                primes = updateReference(primesRef, n);
            }
            return primes.get(n);
        };
    }

    private static List<Boolean> updateReference(AtomicReference<WeakReference<List<Boolean>>> primesRef, int n) {
        List<Boolean> primes = primesRef.updateAndGet(prevRef -> {
            List<Boolean> prev = prevRef.get();
            return new WeakReference<>(calculatePrimes(n, prev != null ? prev : List.of()));
        }).get();

        if (primes == null) { // last resource (unlikely branch)
            primes = calculatePrimes(n, List.of());
        }

        return primes;
    }

    private static List<Boolean> calculatePrimes(int limit, List<Boolean> prev) {
        if (limit < prev.size()) {
            return prev;
        }
        List<Boolean> primes = new ArrayList<>(limit + 1);
        primes.addAll(prev);
        for (int i = prev.size(); i <= limit; i++) {
            boolean isPrime = i > 1;
            for (int j = 1; j < i && isPrime; j++) {
                if (Boolean.TRUE.equals(primes.get(j))) {
                    isPrime = i % j > 0;
                }
            }
            primes.add(isPrime);
        }
        return List.copyOf(primes);
    }

    private static UnaryOperator<int[]> create(String name, UnaryOperator<int[]> impl) {
        return new UnaryOperator<>() {
            @Override
            public int[] apply(int[] numbers) {
                return impl.apply(numbers);
            }

            @Override
            public String toString() {
                return "PrimeFilters::" + name;
            }
        };
    }

}
