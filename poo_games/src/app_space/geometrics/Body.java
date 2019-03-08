package app_space.geometrics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import geometrics.IDrawable;

public class Body implements IDrawable {
	protected double X, Y;
	public static int SIZE;
	private String file = "nave.png";
	
	protected ImageObserver observer = null;
	public Body(int size, ImageObserver o, double x, double y) {
		Body.SIZE = size;
		this.observer = o;
		this.X = x; this.Y = y;
	}
	
	@Override
	public void draw(Graphics2D g2d, double maxX, double maxY) {
		draw(g2d, Color.WHITE);
	}
	public void draw(Graphics2D g2d, Color cor) {
		g2d.setColor(cor);
		g2d.drawArc((int) this.X, (int) this.Y, Body.SIZE, Body.SIZE, 180, 180);
		if(observer!=null) {
			Image queijo = new ImageIcon(this.getClass().getResource(file)).getImage();
			g2d.drawImage(queijo, (int)this.X, (int)this.Y, observer);
		}
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Body) {
			Body p = (Body) obj;
			return this.X==p.X && this.Y==p.Y;
		}
		return false;
	}
	public void setXY(double _x, double _y) {
		this.X = _x;
		this.Y = _y;
	}
	public void move(double _x, double _y) {
		this.X += _x;
		this.Y += _y;
	}
}