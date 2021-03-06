package nl.tdegroot.games.nemesis.entity.projectile;

import nl.tdegroot.games.nemesis.entity.Player;
import nl.tdegroot.games.nemesis.gfx.Resources;
import nl.tdegroot.games.nemesis.gfx.Screen;
import org.newdawn.slick.geom.Rectangle;

public class Arrow extends Projectile {

	public static final int FIRE_RATE = 15;

	public Arrow(float x, float y, double dir, Player player) {
		super(x, y, dir, player);
		aoe = new Rectangle(x, y, 15, 30);
		range = 650;
		speed = 8.5f;
		damage = 25.0d;
		setSprite(Resources.entityArrow);

		nx = speed * Math.sin(angle);
		ny = speed * Math.cos(angle);
	}

	public void update(int delta) {
		move();
		aoe.setLocation(x, y);
	}

	public void move() {
		x += nx;
		y += ny;

		if (distance() > range) {
			remove();
		}
	}

	private double distance() {
		double dist;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return dist;
	}

	public void render(Screen screen) {
		screen.render(this);
	}

}
