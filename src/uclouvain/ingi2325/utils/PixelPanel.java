package uclouvain.ingi2325.utils;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.imageio.*;
import java.io.*;

/**
 * Represents a canvas you can draw on.
 * 
 * Allows the drawing of single pixels with a given color. Typical usage in
 * render loop (assume object is called panel): panel.clear(); for each pixel to
 * be drawn: panel.drawPixel(...); panel.repaint(); panel.flush();
 * 
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
 */
public class PixelPanel extends Canvas implements ComponentListener {

	private static final long serialVersionUID = 1L;

	/**
	 * The image displayed in this canvas
	 */
	BufferedImage image;

	/**
	 * Construct a new CgPanel.
	 */
	public PixelPanel(int width, int height) {
		setSize(new Dimension(width, height));
		setPreferredSize(new Dimension(width, height));
		image = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_RGB);
		addComponentListener(this);
		componentResized(new ComponentEvent(this,
				ComponentEvent.COMPONENT_RESIZED));
	}

	/**
	 * Draw a pixel at window location x,y with color r,g,b. The coordinates x,y
	 * are supposed to be in the range [0...getWidth()[ and [0...getHeight()[
	 * respectively. The color channels r,g and b are supposed to be in the
	 * range [0...1]
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 * @param r
	 *            the red coordinate
	 * @param g
	 *            the green coordinate
	 * @param b
	 *            the blue coordinate
	 */
	public void drawPixel(int x, int y, float r, float g, float b) {
		if (x >= 0 && x < image.getWidth() && y >= 0 && y < image.getHeight())
			image.setRGB(x, y, (int) (255 * r) << 16 | (int) (255 * g) << 8
					| (int) (255 * b));
	}

	/**
	 * Clear the buffer with a black color.
	 */
	public void clear() {
		clear(0, 0, 0);
	}

	/**
	 * Clear the buffer with the given color.
	 * 
	 * @param r
	 *            the red coordinate
	 * @param g
	 *            the green coordinate
	 * @param b
	 *            the blue coordinate
	 */
	public void clear(float r, float g, float b) {
		int color = (int) (255 * r) << 16 | (int) (255 * g) << 8
				| (int) (255 * b);
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				image.setRGB(x, y, color);
			}
		}
	}

	/**
	 * Save the buffer to a file.
	 * 
	 * @param file
	 *            the filename used to save the file.
	 * @return true if image was successfully writen, false otherwise
	 */
	public boolean saveImage(String file) {
		try {
			Graphics2D g2;
			g2 = image.createGraphics();
			g2.drawImage(image, null, null);
			ImageIO.write(image, "png", new File(file));
			return true;

		} catch (Exception e) {
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Canvas#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		update(g);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Canvas#update(java.awt.Graphics)
	 */
	@Override
	public void update(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ComponentListener#componentResized(java.awt.event.
	 * ComponentEvent)
	 */
	@Override
	public void componentResized(ComponentEvent e) {
		System.out.println("Resized");
		image = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_RGB);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ComponentListener#componentHidden(java.awt.event.
	 * ComponentEvent)
	 */
	@Override
	public void componentHidden(ComponentEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ComponentListener#componentMoved(java.awt.event.ComponentEvent
	 * )
	 */
	@Override
	public void componentMoved(ComponentEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ComponentListener#componentShown(java.awt.event.ComponentEvent
	 * )
	 */
	@Override
	public void componentShown(ComponentEvent e) {
	}

}
