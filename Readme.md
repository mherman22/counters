# Counter Project

## Overview

This project implements a variety of counters, each with different behaviors and use cases. The core concept is to provide different types of counters that can be used in various applications to track and manipulate counts in different ways. The counters include:

1. **`IntCounter`**: Counts integers.
2. **`AsciiCounter`**: Counts ASCII characters.
3. **`DateCounter`**: Counts dates (Not detailed in the provided code but is implied).
4. **`SequenceCounter`**: Counts through a predefined sequence of values.

## Counter Classes

### 1. `IntCounter`

The `IntCounter` class counts integers. It starts at zero and can be incremented or decremented. When incremented past its maximum or decremented below its minimum, it simply continues counting in the same direction.

**Methods:**
- `increment()`: Increases the count by 1.
- `decrement()`: Decreases the count by 1.
- `reset()`: Resets the count to zero.
- `valueAsString()`: Returns the current count as a string.

### 2. `AsciiCounter`

The `AsciiCounter` class counts through ASCII characters. It starts at a specified ASCII character and moves to the next character when incremented, or to the previous character when decremented. It wraps around from 'Z' to 'A' or 'z' to 'a', and vice versa.

**Methods:**
- `increment()`: Moves to the next ASCII character.
- `decrement()`: Moves to the previous ASCII character.
- `reset()`: Resets the character to 'A' or 'a', depending on initialization.
- `valueAsString()`: Returns the current ASCII character as a string.

### 3. `SequenceCounter`

The `SequenceCounter` class cycles through a user-defined sequence of values. It maintains an index into the sequence and cycles through it when incremented or decremented. It wraps around when it reaches the end or start of the sequence.

**Methods:**
- `increment()`: Moves to the next item in the sequence.
- `decrement()`: Moves to the previous item in the sequence.
- `reset()`: Resets the index to the start of the sequence.
- `valueAsString()`: Returns the current value from the sequence as a string.

**Constructor:**
- `SequenceCounter(String[] sequence)`: Initializes with a sequence of strings.

## `CounterView` Class

The `CounterView` class provides a graphical user interface (GUI) for interacting with the counters. It uses Swing components to display the current value of a counter and provides buttons to increment, decrement, and reset the counter.

**Constructor:**
- `CounterView(Counter c)`: Initializes the view with a specified counter.

**Methods:**
- `init()`: Sets up the GUI components.
- `display()`: Updates the GUI to show the current value of the counter.
- `actionPerformed(ActionEvent e)`: Handles button clicks for incrementing, decrementing, and resetting the counter.
- `update(Observable o, Object arg)`: Updates the GUI when the counter value changes.

## How to Run

1. **Compile the Code:**
    - Ensure you have the JDK installed. Navigate to the directory containing your Java files and compile them using:
      ```bash
      javac *.java
      ```

2. **Run the Application:**
    - You can run the `CounterView` with different counters to see their behavior. For example:
      ```bash
      java CounterView
      ```
    - The `CounterView` class will create and display views for several types of counters.

## Usage

To create and use different types of counters, you can modify the `main` method in the `CounterView` class or create your own testing classes. For example:

```java
public static void main(String[] args) {
    Counter intCounter = new IntCounter();
    CounterView intCounterView = new CounterView(intCounter);
    
    String[] sequence = {"First", "Second", "Third"};
    Counter sequenceCounter = new SequenceCounter(sequence);
    CounterView sequenceCounterView = new CounterView(sequenceCounter);
    
    Counter hexCounter = new HexCounter();
    CounterView hexCounterView = new CounterView(hexCounter);
}
```

## Differences Between Terminal-Based and GUI-Based Counters

### Terminal-Based Counters

- **Interaction**: Users interact with the counters through a text-based interface. You must run a `CounterDemo` class in the terminal and input choices manually.
- **Output**: The output is printed to the terminal, which may require parsing the text to understand the counter's state.
- **Functionality**: Simple interaction, with all operations (increment, decrement, reset) performed through command-line input.

### GUI-Based Counters

- **Interaction**: Users interact with the counters through a graphical interface. Buttons for incrementing, decrementing, and resetting make the interaction more intuitive.
- **Output**: The current value of the counter is displayed in a GUI, making it easier to visualize and interact with the counter's state.
- **Functionality**: Provides a more user-friendly experience with real-time updates and visual feedback. Observers update the GUI automatically when the counter changes.