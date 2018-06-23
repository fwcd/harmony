package com.fwcd.harmony.interval;

import static com.fwcd.harmony.interval.CommonInterval.*;
import java.util.Optional;

public enum CommonDiatonicInterval implements DiatonicInterval {
	PRIME(0, PERFECT_UNISON),
	SECOND(1, MAJOR_SECOND, MINOR_SECOND),
	THIRD(2, MAJOR_THIRD, MINOR_THIRD),
	FOURTH(3, PERFECT_FOURTH),
	FIFTH(4, PERFECT_FIFTH),
	SIXTH(5, MAJOR_SIXTH, MINOR_SIXTH),
	SEVENTH(6, MAJOR_SEVENTH, MINOR_SEVENTH),
	OCTAVE(7, PERFECT_OCTAVE);

	private final int degrees;
	private final Optional<PitchInterval> majorInterval;
	private final Optional<PitchInterval> minorInterval;
	private final Optional<PitchInterval> perfectInterval;

	private CommonDiatonicInterval(int degrees, PitchInterval perfectInterval) {
		this.degrees = degrees;
		this.perfectInterval = Optional.of(perfectInterval);
		majorInterval = Optional.empty();
		minorInterval = Optional.empty();
	}

	private CommonDiatonicInterval(
		int degrees,
		PitchInterval majorInterval,
		PitchInterval minorInterval
	) {
		this.degrees = degrees;
		this.majorInterval = Optional.of(majorInterval);
		this.minorInterval = Optional.of(minorInterval);
		perfectInterval = Optional.empty();
	}

	public Optional<PitchInterval> toMajorInterval() { return majorInterval; }

	public Optional<PitchInterval> toMinorInterval() { return minorInterval; }

	public Optional<PitchInterval> toPerfectInterval() { return perfectInterval; }

	@Override
	public int getDegrees() { return degrees; }
}
