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

/**
 * RS 9 January 1998,
 * Adapted to java 1.1 by R.Smedinga
 **/


import java.util.*;

public class DateCounter extends Counter {
    GregorianCalendar value = new GregorianCalendar();  // today


    public void increment() {
        value.add(Calendar.DATE, 1);
        this.changed();
    }

    public void decrement() {
        value.add(Calendar.DATE, -1);
        this.changed();
    }

    public void reset() {
        value = new GregorianCalendar();
        this.changed();
    }

    public String valueAsString() {
        return value.get(Calendar.DAY_OF_MONTH) + "-" +
                (value.get(Calendar.MONTH) + 1) + "-" +
                value.get(Calendar.YEAR);
    }

}
