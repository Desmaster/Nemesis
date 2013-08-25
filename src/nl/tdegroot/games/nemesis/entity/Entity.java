package nl.tdegroot.games.nemesis.entity;

import nl.tdegroot.games.nemesis.gfx.Screen;
import nl.tdegroot.games.nemesis.level.Level;
import nl.tdegroot.games.nemesis.map.MapLayer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Entity {

	Image sprite;
	protected Level level;

	protected float x, y;

	protected int width = 0;
	protected int height = 0;
	protected boolean removed = false;

	public Entity() {

	}

	public Entity(Image image, float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void init(Level level) {
		setLevel(level);
		positionate();
	}

	public void initPlayer(Level level) {
		setLevel(level);
		positionate();
	}


	protected void positionate() {
		x *= level.tileSize;
		y *= level.tileSize;
	}



	public void remove() {
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void update(int delta) {
	}

	public void render(Screen screen) {
		screen.renderEntity(this);
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
