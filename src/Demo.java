import javax.swing.*;

import uclouvain.ingi2325.utils.PixelPanel;
import uclouvain.ingi2325.utils.Scene;
import uclouvain.ingi2325.utils.SceneBuilder;

/**
 * The demo :-)
 *
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
 */
public class Demo {

	public static void main(String[] args) {
		new Demo();
	}

	private JFrame frame;
	private PixelPanel panel;

	public Demo() {
		try {
			SceneBuilder sceneBuilder = new SceneBuilder();
			Scene scene = sceneBuilder.loadScene("XML/example.sdl");
		} catch (Exception e) {
			e.printStackTrace();
		}

		panel = new PixelPanel(640, 480);
		frame = new JFrame();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		draw();
	}

	public void drawPixels() {
		panel.clear(0, 0, 1);
		for (int y = 10; y < panel.getHeight() - 10; y++) {
			for (int x = 10; x < panel.getWidth() - 10; x++) {
				if ((x / 20) % 2 == 0) {
					if ((y / 20) % 2 == 0)
						panel.drawPixel(x, y, 1, 0, 0);
					else
						panel.drawPixel(x, y, 0.5f, 0, 0);
				} else {
					if ((y / 20) % 2 == 0)
						panel.drawPixel(x, y, 1, 0.5f, 0);
					else
						panel.drawPixel(x, y, 0.5f, 0.25f, 0);
				}
			}
		}
	}

	public void draw() {
		drawPixels();
		panel.repaint();
		panel.saveImage("image.png");
	}
}
