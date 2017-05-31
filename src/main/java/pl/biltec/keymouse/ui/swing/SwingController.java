package pl.biltec.keymouse.ui.swing;

import pl.biltec.keymouse.application.*;
import pl.biltec.keymouse.domain.Area;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSPARENT;
import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;

public class SwingController {
	//TODO DI via constructor
	final KeyMouseAPI api;
	//TODO static fix
	static Area area;


	public SwingController(KeyMouseAPI api) {
		this.api = api;
	}

	public void start() {
		// Determine what the GraphicsDevice can support.
		GraphicsEnvironment ge =
				GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		final boolean isTranslucencySupported =
				gd.isWindowTranslucencySupported(TRANSLUCENT);

		//If shaped windows aren't supported, exit.
		if (!gd.isWindowTranslucencySupported(PERPIXEL_TRANSPARENT)) {
			System.err.println("Shaped windows are not supported");
			System.exit(0);
		}

		//If translucent windows aren't supported,
		//create an opaque window.
		if (!isTranslucencySupported) {
			System.out.println(
					"Translucency is not supported, creating an opaque window");
		}

		// Create the GUI on the event-dispatching thread
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				JFrame frame = new TransparentFrame();

				frame.setOpacity(0.55f);
				// Display the window.
				frame.setVisible(true);

				//titile bar
				frame.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {


						pl.biltec.keymouse.application.Action action = api.findAction(new IntegerKey(e.getKeyCode()));




						Robot robot = null;
						try {
							robot = new Robot();
						} catch (AWTException e1) {
							e1.printStackTrace();
						}
						try {
							if (action == BasicActions.UNDEFINED) {
								System.out.println("undefined > " + e.getKeyCode() + ", " + e.getKeyChar() + ", " + e.getKeyLocation());

							} else if (action == BasicActions.EXIT) {
								System.out.println("x = KONIEC");
								frame.dispose();
							} else if (action == BasicActions.UNDO) {
								area = area.back();
								makeAMove(frame, robot, area);
							} else if (action.equals(new IntegerMove(0))) {
								area = area.fromLeftTop(0);
								makeAMove(frame, robot, area);
							} else if (action.equals(new IntegerMove(1))) {
								area = area.fromLeftTop(1);
								makeAMove(frame, robot, area);
							} else if (action == BasicActions.MOUSE_LEFT_CLICK) {
								frame.dispose();
								robot.mousePress(InputEvent.BUTTON1_MASK);
								robot.mouseRelease(InputEvent.BUTTON1_MASK);
							} else if (action == BasicActions.MOUSE_MIDDLE_CLICK) {
								frame.dispose();
								robot.mousePress(InputEvent.BUTTON3_MASK);
								robot.mouseRelease(InputEvent.BUTTON3_MASK);
							} else if (action == BasicActions.MOUSE_RIGHT_CLICK) {
								frame.dispose();
								robot.mousePress(InputEvent.BUTTON2_MASK);
								robot.mouseRelease(InputEvent.BUTTON2_MASK);
							} else {
								System.out.println("else action=" + action);
							}
//					}
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				});


				int height = MouseInfo.getPointerInfo().getDevice().getDisplayMode().getHeight();
				int width = MouseInfo.getPointerInfo().getDevice().getDisplayMode().getWidth();
				System.out.println(height);
				System.out.println(width);


//				robot = new Robot();
				int splitLevel = 2;
				//2 ekrany
//		area = new Area(1920, 0, 1920, 1080, splitLevel);
				//tylko laptop
				area = new Area(0, 0, 1920, 1080, splitLevel);
//				area2Mouse(area, robot);
				area2Frame(area, frame);
				System.out.println(area);


				System.out.println(MouseInfo.getPointerInfo().getLocation());

			}

		});
	}

	private static void makeAMove(JFrame frame, Robot robot, Area area) throws InterruptedException {
		area2Mouse(area, robot);
		area2Frame(area, frame);
		((TransparentFrame)frame).nextColor();
		System.out.println(area + " color " + frame.getContentPane().getBackground());
	}


	public static void area2Frame(Area area, JFrame frame) {
		frame.setLocation(area.getLeft(), area.getTop());
		frame.setSize(area.getWidth(), area.getHeight());
	}

	public static void area2Mouse(Area area, Robot robot) {
		robot.mouseMove(area.getMouseX(), area.getMouseY());
	}

}
