package pl.biltec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

public class KeyMouseAPI {

	static int ITERATION = 0;
	static Area area;
	static Robot robot;

	public static final Color[] COLORS = {Color.BLACK, Color.CYAN, Color.RED, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.WHITE};


	public static Color getColor(int i) {
		return COLORS[i % COLORS.length];
	}


	public static void main(String[] args) throws AWTException, InterruptedException, IOException {


		//potrzbne do transfluenta
		JFrame.setDefaultLookAndFeelDecorated(true);

		for (int i = 0; i < COLORS.length; i++) {
			System.out.println("i=" + i + " -> " + COLORS[i]);

		}


		System.out.println(MouseInfo.getPointerInfo().getLocation());


		JFrame.setDefaultLookAndFeelDecorated(true);


		JFrame frame = new TransparentFrame();

//		JPanel p = new JPanel();
//		p.setOpaque(false);
//		p.setLayout(null);
		// Set's the window to be "always on top"
//		frame.setAlwaysOnTop(true);
//		frame.setUndecorated(true);
//		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setOpacity(0.55f);
		// Display the window.
		frame.setVisible(true);

		//titile bar
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					switch (e.getKeyCode()) {
						case 74: //'k':
							System.out.println("ok > " + e.getKeyCode() + ", " + e.getKeyChar() + ", " + e.getKeyLocation() + ", " + e.getExtendedKeyCode());

							area = area.fromLeftTop(0);
							makeAMove(frame, robot, area, ITERATION++);
							break;
						case 75: //'j':
							System.out.println("ok > " + e.getKeyCode() + ", " + e.getKeyChar() + ", " + e.getKeyLocation() + ", " + e.getExtendedKeyCode());

							area = area.fromLeftTop(1);
							makeAMove(frame, robot, area, ITERATION++);
							break;
						case 78: //'n':
							System.out.println("ok > " + e.getKeyCode() + ", " + e.getKeyChar() + ", " + e.getKeyLocation() + ", " + e.getExtendedKeyCode());
							//minimize
							frame.dispose();
							//action
							robot.mousePress(InputEvent.BUTTON1_MASK);
							robot.mouseRelease(InputEvent.BUTTON1_MASK);
							//restore
//							frame.setState(Frame.NORMAL);
							break;
						case 77: //'m':
							System.out.println("ok > " + e.getKeyCode() + ", " + e.getKeyChar() + ", " + e.getKeyLocation() + ", " + e.getExtendedKeyCode());
							//minimize
							frame.dispose();
//							frame.setState(Frame.ICONIFIED);
							//action
							robot.mousePress(InputEvent.BUTTON2_MASK);
							robot.mouseRelease(InputEvent.BUTTON2_MASK);
							//restore
//							frame.setState(Frame.NORMAL);
							break;
						case 44: //',':
							System.out.println("ok > " + e.getKeyCode() + ", " + e.getKeyChar() + ", " + e.getKeyLocation() + ", " + e.getExtendedKeyCode());
							//minimize
							frame.dispose();
							//action
							robot.mousePress(InputEvent.BUTTON3_MASK);
							robot.mouseRelease(InputEvent.BUTTON3_MASK);
							//restore
//							frame.setState(Frame.NORMAL);
							break;

						case 8: //backspace
							System.out.println("ok > " + e.getKeyCode() + ", " + e.getKeyChar() + ", " + e.getKeyLocation() + ", " + e.getExtendedKeyCode());

							area = area.back();
							makeAMove(frame, robot, area, ITERATION++);
							break;
						case 27: //ESC
							System.out.println("x = KONIEC");
							frame.dispose();
							break;
						default:
							System.out.println("undefined > " + e.getKeyCode() + ", " + e.getKeyChar() + ", " + e.getKeyLocation() + ", " + e.getExtendedKeyCode());

					}
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame.setUndecorated(true);


		int height = MouseInfo.getPointerInfo().getDevice().getDisplayMode().getHeight();
		int width = MouseInfo.getPointerInfo().getDevice().getDisplayMode().getWidth();
		System.out.println(height);
		System.out.println(width);
//		System.out.println(MouseInfo.getPointerInfo().getLocation());


		robot = new Robot();
		int splitLevel = 2;
		area = new Area(1920, 0, 1920, 1080, splitLevel);
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


//		//2 dwukropek przy run'ie
//		area = makeAMove(frame, robot, 0, area, 1);
//		area = makeAMove(frame, robot, 8, area, 2);
//		area = makeAMove(frame, robot, 3, area, 3);
////		area = makeAMove(frame, robot, 5, area, 4);
////		area = makeAMove(frame, robot, 0, area, 5);
////		area = makeAMove(frame, robot, 8, area, 6);


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

	}

	private static void makeAMove(JFrame frame, Robot robot, Area area, int i) throws InterruptedException {
//		area = area.fromLeftTop(position);
		area2Mouse(area, robot);
		area2Frame(area, frame, i);
		System.out.println(i + ". " + area + " color " + frame.getContentPane().getBackground());
//		Thread.sleep(1_000);
//		return area;
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
