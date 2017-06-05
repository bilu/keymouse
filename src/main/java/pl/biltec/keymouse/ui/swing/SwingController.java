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
		this.area = api.getInitialArea();
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

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				TransparentFrame frame = new TransparentFrame(area, api.getKeyToActionBinding());
				frame.setOpacity(0.45f);
				// Display the window.
				frame.setVisible(true);

				displayArea(area, frame);

				frame.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {


						pl.biltec.keymouse.application.Action action = api.findAction(new CodeKey(e.getKeyCode())).orElse(BasicActions.UNDEFINED);


						Robot robot = null;
						try {
							robot = new Robot();
						} catch (AWTException e1) {
							e1.printStackTrace();
						}
						try {
							if (action == BasicActions.UNDEFINED) {
								System.out.println("undefined > " + e.getKeyCode() + ", " + e.getKeyChar() + ", " + e.getKeyLocation());
							} else if (action instanceof Move) {
								Move move = (Move) action;
								area = area.move(move.horizontal(), move.vertical());
								makeAMove(frame, robot, area);
								frame.updateArea(area);

							} else if (action == BasicActions.EXIT) {
								System.out.println("x = KONIEC");
								frame.dispose();
							} else if (action == BasicActions.UNDO) {
								area = area.back();
								makeAMove(frame, robot, area);
							} else if (action == BasicActions.MOUSE_LEFT_CLICK) {
								int button1DownMask = InputEvent.BUTTON1_DOWN_MASK;
								frame.dispose();
								robot.mousePress(button1DownMask);
								robot.mouseRelease(button1DownMask);
							} else if (action == BasicActions.MOUSE_MIDDLE_CLICK) {
								frame.dispose();
								robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
								robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
							} else if (action == BasicActions.MOUSE_RIGHT_CLICK) {
								frame.dispose();
								robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
								robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
							} else if (action == BasicActions.MOUSE_SCROLL_DOWN) {
								frame.dispose();
								robot.mouseWheel(1);
							} else if (action == BasicActions.MOUSE_SCROLL_UP) {
								frame.dispose();
								robot.mouseWheel(-1);
							} else {
								System.out.println("else action=" + action);
							}
//					}
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				});
			}

		});
	}

	private static void makeAMove(JFrame frame, Robot robot, Area area) throws InterruptedException {
		moveMouseToTheMiddleOfArea(area, robot);
		displayArea(area, frame);
	}


	public static void displayArea(Area area, JFrame frame) {
//		frame.setLocation(area.getLeft(), area.getTop());
//		frame.setSize(area.getWidth(), area.getHeight());

		frame.setBounds(area.getLeft(), area.getTop(), area.getWidth(), area.getHeight());
	}

	public static void moveMouseToTheMiddleOfArea(Area area, Robot robot) {
		robot.mouseMove(area.getMouseX(), area.getMouseY());
	}

}
