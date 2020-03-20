package blastGUI;
import java.awt.Container;

import javax.swing.*;
public class EjecutarInterfaz {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CrearInterfaz();
			}
		});
	}
	private static void CrearInterfaz() {
		JFrame frame = new JFrame("Blast");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel p = new Panel();
		p.crearPanel();
		Action accion = new Action(p);
		p.getBexecutequery().addActionListener(accion);
		Container contenedor = frame.getContentPane();
		contenedor.add(p);
		frame.pack();
		frame.setVisible(true);
	}
}
