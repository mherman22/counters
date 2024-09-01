import java.util.*;

public class SequenceCounter extends Counter {
    private final String[] sequence;
    private int index;

    public SequenceCounter(String[] sequence) {
        if (sequence == null || sequence.length == 0) {
            throw new IllegalArgumentException("Sequence must contain at least one element.");
        }
        this.sequence = sequence;
        this.index = 0;
    }

    @Override
    public void increment() {
        index = (index + 1) % sequence.length;
        changed();
    }

    @Override
    public void decrement() {
        index = (index - 1 + sequence.length) % sequence.length;
        changed();
    }

    @Override
    public void reset() {
        index = 0;
        changed();
    }

    @Override
    public String valueAsString() {
        return sequence[index];
    }
}
