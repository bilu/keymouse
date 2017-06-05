package pl.biltec.keymouse.ui.swing;

import pl.biltec.keymouse.application.KeyToActionBinding;
import pl.biltec.keymouse.domain.Area;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class TransparentFrame extends JFrame {

	private final React component;
	private final KeyToActionBinding map;
	private int colorIndex = 0;


	public TransparentFrame(Area area, KeyToActionBinding map) {
		super("TranslucentWindow");
		this.map = map;

		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.component = new React(area, map);
		add(component);
	}

	public void updateArea(Area area) {
		component.updateArea(area);
		repaint();
		invalidate();
	}

	public static class React extends JPanel {

		private Area area;
		private final KeyToActionBinding map;


		public React(Area area, KeyToActionBinding map) {
			this.area = area;
			this.map = map;
			setBackground(Color.BLACK);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			System.out.println("PAINT:" + area);


			g.setColor(Color.WHITE);
//			g.setXORMode(Color.GREEN);


			Stream.of(area)
					.flatMap(a -> levelDown(a, "").stream())
					.flatMap(a -> a.getArea().level() <= 2 ? levelDown(a).stream() : Arrays.asList(a).stream())
//					.flatMap(a -> levelDown(a).stream())
//					.flatMap(a -> levelDown(a).stream())
					.forEach(awb -> {
						Area area = awb.getArea();
						draw(g, area);
						g.drawString(awb.getBinding(), area.getMouseX()- 7, area.getMouseY());
					});

		}

		public void updateArea(Area newArea) {
			this.area = newArea;
			invalidate();
			repaint();
		}

		private List<AreaWitBinding> levelDown(Area area, String parentBindin) {
			int splitHorizontal = area.getSplitHorizontal();
			int splitVertical = area.getSplitVertical();

			List<AreaWitBinding> results = new LinkedList<>();

			for (int v = 0; v < splitVertical; v++) {
				for (int h = 0; h < splitHorizontal; h++) {
					Area loverLevelArea = area.move(h, v);
					results.add(new AreaWitBinding(loverLevelArea, parentBindin + " " + map.getKeyName(new MatrixMove(h, v))));
				}
			}

			return results;
		}

		private List<AreaWitBinding> levelDown(AreaWitBinding areaWitBinding) {
			return levelDown(areaWitBinding.getArea(), areaWitBinding.getBinding());

		}

		private void draw(Graphics g, Area area) {
			g.drawRect(area.getLeft(), area.getTop(), area.getWidth(), area.getHeight());
		}
	}

}