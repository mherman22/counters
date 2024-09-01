import java.util.*;

/**
 * A counter that iterates through a predefined sequence of strings.
 * The counter wraps around when it reaches the end of the sequence.
 */
public class SequenceCounter extends Counter {
    private final List<String> sequence;
    private int index;

    /**
     * Constructs a SequenceCounter with the specified sequence.
     *
     * @param sequence the list of strings to iterate through. Must not be null or empty.
     * @throws IllegalArgumentException if the sequence is null or empty.
     */
    public SequenceCounter(List<String> sequence) {
        if (sequence == null || sequence.isEmpty()) {
            throw new IllegalArgumentException("Sequence cannot be empty!");
        }
        this.sequence = new ArrayList<>(sequence);
        this.index = 0;
    }

    /**
     * Increments the counter to the next value in the sequence.
     * If the end of the sequence is reached, it wraps around to the start.
     */
    @Override
    public void increment() {
        index++;
        if (index >= sequence.size()) {
            index = 0;
        }
        changed();
    }

    /**
     * Decrements the counter to the previous value in the sequence.
     * If the start of the sequence is reached, it wraps around to the end.
     */
    @Override
    public void decrement() {
        index--;
        if (index < 0) {
            index = sequence.size() - 1;
        }
        changed();
    }

    /**
     * Resets the counter to the first value in the sequence.
     */
    @Override
    public void reset() {
        index = 0;
        changed();
    }

    /**
     * Returns the current value of the counter as a string.
     *
     * @return the current value of the counter.
     */
    @Override
    public String valueAsString() {
        return sequence.get(index);
    }
}
