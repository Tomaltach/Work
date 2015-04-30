package ie.tom.abp;

import javax.swing.SwingUtilities;

import ie.tom.abp.startup.Startup;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
        		new Startup();
            }
        });
	}
}
