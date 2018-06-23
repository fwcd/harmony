package com.fwcd.harmony.test;

import static org.junit.Assert.fail;

import java.util.Optional;

final class TestUtils {
	private TestUtils() {}

	@FunctionalInterface
	public static interface ThrowingRunnable {
		void run() throws Throwable;
	}

	private static Optional<Throwable> runAndGetThrown(ThrowingRunnable code) {
		try {
			code.run();
			return Optional.empty();
		} catch (Throwable e) {
			return Optional.of(e);
		}
	}

	public static void assertThrows(ThrowingRunnable code, Class<? extends Throwable> throwableClass) {
		Optional<Throwable> exception = runAndGetThrown(code);
		if (exception.isPresent()) {
			Throwable unwrappedException = exception.orElse(null);
			if (!unwrappedException.getClass().equals(throwableClass)) {
				fail("Code does not throw " + throwableClass.getName() + ", but rather " + unwrappedException.getClass().getName() + " (message: " + unwrappedException.getMessage() + ")");
			}
		} else {
			fail("Code does not throw " + throwableClass.getName());
		}
	}
}
