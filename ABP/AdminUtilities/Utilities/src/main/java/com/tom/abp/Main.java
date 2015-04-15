package com.tom.abp;

import javax.swing.SwingUtilities;

import com.tom.abp.gui.GUI;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                 new GUI();
            }
       });
	}
}
