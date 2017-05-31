package pl.biltec;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class KeyMouseAPI {

	public static final Color[] COLORS = {Color.BLACK, Color.CYAN, Color.RED, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.WHITE};


	public static Color getColor(int i) {
		return COLORS[i % COLORS.length];
	}


	public static void main(String[] args) throws AWTException, InterruptedException, IOException {

		for (int i = 0; i < COLORS.length; i++) {
			System.out.println("i=" + i + " -> " + COLORS[i]);

		}


		System.out.println(MouseInfo.getPointerInfo().getLocation());

		JFrame frame = new JFrame();
		// Set's the window to be "always on top"
		frame.setAlwaysOnTop(true);
//		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame.setUndecorated(true);


		int height = MouseInfo.getPointerInfo().getDevice().getDisplayMode().getHeight();
		int width = MouseInfo.getPointerInfo().getDevice().getDisplayMode().getWidth();
		System.out.println(height);
		System.out.println(width);
//		System.out.println(MouseInfo.getPointerInfo().getLocation());

		Robot robot = new Robot();

		int splitLevel = 8;
		Area area = new Area(1920, 0, 1920, 1080, splitLevel);
		area2Mouse(area, robot);
		area2Frame(area, frame, 0);
		System.out.println(area);
//		Thread.sleep(500);

		Random r = new Random();

//		for (int i = 0; i < splitLevel + 1; i++) {
////			area = area.fromLeftTop(r.nextInt(splitLevel));
//			area = makeAMove(frame, robot, splitLevel, area, i);
//		}

//		//1 wwskaznik na scrollbarze
//		area = makeAMove(frame, robot, 5, area, 1);
//		area = makeAMove(frame, robot, 2, area, 2);
//		area = makeAMove(frame, robot, 7, area, 3);
//		area = makeAMove(frame, robot, 5, area, 4);
//		area = makeAMove(frame, robot, 0, area, 5);
////		area = makeAMove(frame, robot, 8, area, 6);


		//2 dwukropek przy run'ie
		area = makeAMove(frame, robot, 0, area, 1);
		area = makeAMove(frame, robot, 8, area, 2);
		area = makeAMove(frame, robot, 3, area, 3);
//		area = makeAMove(frame, robot, 5, area, 4);
//		area = makeAMove(frame, robot, 0, area, 5);
//		area = makeAMove(frame, robot, 8, area, 6);


		System.out.println(MouseInfo.getPointerInfo().getLocation());

//		JFrame frame = new JFrame();
//		// Set's the window to be "always on top"
//		frame.setAlwaysOnTop( true );
//		frame.setLocation(0, 0);
//		frame.setSize(400, 400);
//		frame.setUndecorated(true);
//		frame.setBackground(Color.yellow);
//		frame.setVisible( true );
//		frame.dispose();


		Thread.sleep(1_000);
		frame.dispose();

	}

	private static Area makeAMove(JFrame frame, Robot robot, int position, Area area, int i) throws InterruptedException {
		area = area.fromLeftTop(position);
		area2Mouse(area, robot);
		area2Frame(area, frame, i);
		System.out.println(i + ". " + area + " color " + frame.getContentPane().getBackground());
		Thread.sleep(1_000);
		return area;
	}


	public static void area2Frame(Area area, JFrame frame, int i) {
		frame.setLocation(area.getLeft(), area.getTop());
		frame.setSize(area.getWidth(), area.getHeight());
//		int x = (0 + 64 * i) % 256;
//		frame.getContentPane().setBackground(new Color(x, x, x));
		frame.getContentPane().setBackground(getColor(i));
	}

	public static void area2Mouse(Area area, Robot robot) {
		robot.mouseMove(area.getMouseX(), area.getMouseY());
	}
}
