package nl.tdegroot.games.nemesis;

import nl.tdegroot.games.nemesis.entity.Player;
import nl.tdegroot.games.nemesis.gfx.Camera;
import nl.tdegroot.games.nemesis.gfx.Resources;
import nl.tdegroot.games.nemesis.gfx.Screen;
import nl.tdegroot.games.nemesis.level.Level;
import nl.tdegroot.games.nemesis.ui.Dialog;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class Nemesis extends BasicGame {

	private Level level;
	private Player player;

	private Camera camera;
	@SuppressWarnings("unused")
	private Resources resources;
	InputHandler input;
	private Screen screen;

	public Nemesis() {
		super("Nemesis");
	}

	public void init(GameContainer gameContainer) throws SlickException {
		resources = new Resources();
		level = new Level("resources/levels/spawnerstest.tmx");
		player = new Player(Resources.player, 48, 47, 53, 64);
		camera = new Camera(player, new Vector2f(Display.getWidth(), Display.getHeight()), new Rectangle(0, 0, level.getPixelWidth(), level.getPixelHeight()));
		screen = new Screen(camera, gameContainer.getGraphics());
		input = new InputHandler();
		gameContainer.getInput().addMouseListener(input);
		player.init(level);
	}

	public void update(GameContainer gameContainer, int delta) throws SlickException {
		player.update(delta);
		level.update(delta);
		Dialog.update(delta);
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) stop();
	}

	public void logic(GameContainer gameContainer) {
	}

	public void render(GameContainer gameContainer, Graphics g) throws SlickException {
		float xOffset = player.getX() - Display.getWidth() / 2;
		float yOffset = player.getY() - Display.getHeight() / 2;
		level.render(g, xOffset, yOffset, screen, player);
		player.render(g, screen);
		g.drawString("Mobs Killed: " + player.getKills(), 825, 10);
		g.drawString("Score: " + player.getScore(), 1025, 10);
		g.drawString("Arrows: " + player.getArrows(), 1175, 10);
		float dialogOffset = (1280 - 900) / 2;
		g.setAntiAlias(true);
//		Resources.dialogWindow.draw(dialogOffset, 720 - 170, 1280 - dialogOffset * 2, 170);
		if (Dialog.isActive()) {
			Dialog.render(screen);
		}
//		g.fillRect(dialogOffset, 720 - 170, 1280 - dialogOffset * 2, 170);
//		Log.log("Width: " + (1280 - dialogOffset * 2) + ", Height: " + (720 - 170));
	}

	private synchronized void stop() {
		System.exit(0);
	}


}
