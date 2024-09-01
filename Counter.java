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
import java.util.*;

public abstract class Counter extends Observable {
    public abstract void increment();

    public abstract void decrement();

    public abstract void reset();

    public abstract String valueAsString();

    protected void changed() {
        this.setChanged();
        this.notifyObservers();
    }
}
