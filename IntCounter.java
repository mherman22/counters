/*
 * Copyright (c) 1997 E.J.Dijkstra / R.Smedinga. All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and without
 * fee is hereby granted provided that this copyright notice
 * appears in all copies.
 *
 * This Java source code is part of a course on Object Oriented Techniques
 * developed by E.J.Dijkstra and R.Smedinga for PTS Software, Bussum.
 */
/*
 * @version 1.1 19980109
 * @author R.Smedinga@cs.rug.nl
 */


public class IntCounter extends Counter {
    int value = 0;

    public void increment() {
        value = value + 1;
        this.changed();
    }

    public void decrement() {
        value = value - 1;
        this.changed();
    }

    public void reset() {
        value = 0;
        this.changed();
    }

    public String valueAsString() {
        return Integer.toString(value);
    }

}
