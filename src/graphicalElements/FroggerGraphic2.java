package graphicalElements;

import gameCommons.IFrog;
import util.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FroggerGraphic2 extends JPanel implements IFroggerGraphics2, KeyListener {
	private ArrayList<Element> elementsToDisplay;
	private int pixelByCase = 16;
	private int width;
	private int height;
	private IFrog frog1;
	private IFrog frog2;
	private JFrame frame;

	public FroggerGraphic2(int width, int height) {
		this.width = width;
		this.height = height;
		elementsToDisplay = new ArrayList<Element>();

		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(width * pixelByCase, height * pixelByCase));

		JFrame frame = new JFrame("Frogger");
		this.frame = frame;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Element e : elementsToDisplay) {
			g.setColor(e.color);
			g.fillRect(pixelByCase * e.absc, pixelByCase * (height - 1 - e.ord), pixelByCase, pixelByCase - 1);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			frog1.move(Direction.up);
			break;
		case KeyEvent.VK_DOWN:
			frog1.move(Direction.down);
			break;
		case KeyEvent.VK_LEFT:
			frog1.move(Direction.left);
			break;
		case KeyEvent.VK_RIGHT:
			frog1.move(Direction.right);
			case KeyEvent.VK_W:
				frog2.move(Direction.up);
				break;
			case KeyEvent.VK_S:
				frog2.move(Direction.down);
				break;
			case KeyEvent.VK_A:
				frog2.move(Direction.left);
				break;
			case KeyEvent.VK_D:
				frog2.move(Direction.right);

		}
	}

	public void clear() {
		this.elementsToDisplay.clear();
	}

	public void add(Element e) {
		this.elementsToDisplay.add(e);
	}

	public void setFrog(IFrog frog1, IFrog frog2) {
		this.frog1 = frog1;
		this.frog2 = frog2;
	}

	public void endGameScreen(String s) {
		frame.remove(this);
		JLabel label = new JLabel(s);
		label.setFont(new Font("Verdana", 1, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setSize(this.getSize());
		frame.getContentPane().add(label);
		frame.repaint();

	}

}
