package pl.biltec.keymouse.ui.swing;

/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

//package misc;

import javax.swing.*;
import java.awt.*;

public class TransparentFrame extends JFrame {

	private static final Color[] COLORS = {Color.BLACK, Color.CYAN, Color.RED, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.WHITE};
	private int colorIndex = 0;

	public TransparentFrame() {
		super("TranslucentWindow");
		setLayout(new GridBagLayout());

		setUndecorated(true);
		setSize(300,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public static Color getColor(int i) {
		return COLORS[i % COLORS.length];
	}

	public void nextColor() {
		getContentPane().setBackground(getColor(colorIndex++));
	}

	//TODO remove
	public static void main(String[] args) {
//		// Determine if the GraphicsDevice supports translucency.
//		GraphicsEnvironment ge =
//				GraphicsEnvironment.getLocalGraphicsEnvironment();
//		GraphicsDevice gd = ge.getDefaultScreenDevice();
//
//		//If translucent windows aren't supported, exit.
//		if (!gd.isWindowTranslucencySupported(TRANSLUCENT)) {
//			System.err.println(
//					"Translucency is not supported");
//			System.exit(0);
//		}
//
		JFrame.setDefaultLookAndFeelDecorated(true);

		// Create the GUI on the event-dispatching thread
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				TransparentFrame tw = new TransparentFrame();

				// Set the window to 55% opaque (45% translucent).
				tw.setOpacity(0.55f);

				// Display the window.
				tw.setVisible(true);
			}
		});
	}
}