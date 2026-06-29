package gui;

import javax.swing.JFrame;

public class DrawingApp {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Drawing OOIT");
		frame.setSize(800,600);
		
		DrawingPanel drawingPanel = new DrawingPanel();
		frame.getContentPane().add(drawingPanel);
		
		frame.setVisible(true);
	}

}
