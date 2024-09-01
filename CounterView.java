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
 * @version 1.2 20020923
 * @author R.Smedinga@cs.rug.nl
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class CounterView extends JFrame implements Observer, ActionListener {
    private JButton up, down, reset;
    private JLabel lab;
    private JTextField txt;
    private Counter cnt;

    public CounterView() {             // just for testing...;
        cnt = new IntCounter();        //
        cnt.addObserver(this);         //
        this.init();                   //
        cnt.reset();                   //
    }


    public CounterView(Counter c) {
        ;
        cnt = c;
        this.init();
        cnt.addObserver(this);
    }


    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        contentPane.setLayout(new FlowLayout());

        this.setSize(250, 130);
        this.setTitle(cnt.getClass().getName());

        up = new JButton("Up");
        up.addActionListener(this);
        up.setForeground(Color.black);
        up.setBackground(Color.white);

        down = new JButton("Down");
        down.addActionListener(this);
        down.setForeground(Color.black);
        down.setBackground(Color.white);

        reset = new JButton("Reset");
        reset.addActionListener(this);
        reset.setForeground(Color.black);
        reset.setBackground(Color.white);

        lab = new JLabel("Counter value:");
        txt = new JTextField("", 10);
        txt.setEditable(false);
        txt.setBackground(Color.white);

        JPanel buttonPanel = new JPanel();
        JPanel textPanel = new JPanel();

        buttonPanel.add(up);
        buttonPanel.add(down);
        buttonPanel.add(reset);

        textPanel.add("Center", lab);
        textPanel.add("Center", txt);

        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(textPanel, BorderLayout.SOUTH);

        this.display();
        this.show();
    }

    private void display() {
        txt.setText(cnt.valueAsString());
    }


    /* actionPerformed implements ActionListenere-interface
     * One listener for all buttons
     */
    public void actionPerformed(ActionEvent e) {
        JButton but = (JButton) e.getSource();
        if (but == up) {
            cnt.increment();
        } else if (but == down) {
            cnt.decrement();
        } else if (but == reset) {
            cnt.reset();
        }

    }

    /* update implements `Observer' interface
     ** see also: Object Patterns, Observer
     */
    public void update(Observable o, Object arg) {
        if (o == cnt) {
            this.display();
        }
    }

    public static void main(String argv[]) {
        // just for demo/testing...
        Counter cnt = new IntCounter();
        CounterView cv1 = new CounterView(cnt);
        CounterView cv2 = new CounterView(cnt);

        Counter dcnt = new DateCounter();
        CounterView cv3 = new CounterView(dcnt);

        Counter acnt = new AsciiCounter();
        CounterView cv4 = new CounterView(acnt);

        //sequence counter
        Counter act = new SequenceCounter(new String[]{"herman", "odor", "maiko", "junta", "uganda"});
        CounterView cv5 = new CounterView(act);
    }
}
