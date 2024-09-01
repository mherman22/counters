/*
 * Copyright (c) 1997,98 E.J.Dijkstra,R.Smedinga. All Rights Reserved.
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
 * @version 1.1 19980206
 * @author R.Smedinga@cs.rug.nl
 */


import java.lang.*;

public class AsciiCounter extends Counter {
    char value = 'a';

    public void increment() {
        value = (char) (((int) value + 1) % 256);
        this.changed();
    }

    public void decrement() {
        value = (char) (((int) value - 1) % 256);
        this.changed();
    }

    public void reset() {
        value = 'a';
        this.changed();
    }

    public String valueAsString() {
        return "'" + value + "' (" + ((int) value) + ")";
    }

}
