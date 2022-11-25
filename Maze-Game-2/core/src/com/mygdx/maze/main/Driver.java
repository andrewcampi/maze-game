package com.mygdx.maze.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.maze.screen.GameScreen;
import com.mygdx.maze.Settings;

public class Driver extends Game
{
	public static SpriteBatch batch;

	public static ShapeRenderer shape;

	public static BitmapFont font;

	public static OrthographicCamera camera;

	public static FillViewport viewport;

	Settings global_settings = Settings.getInstance();

	@Override
	public void create ()
	{
		batch = new SpriteBatch();
		shape = new ShapeRenderer();
		font = new BitmapFont(true);

		camera = new OrthographicCamera();
		camera.setToOrtho(true, global_settings.getCameraZoomWidth(), global_settings.getCameraZoomHeight());
		viewport = new FillViewport(global_settings.getCameraZoomWidth(), global_settings.getCameraZoomHeight(), camera);

		this.setScreen(new GameScreen());
	}

	@Override
	public void render ()
	{
		super.render();
	}

	@Override
	public void resize(int width, int height)
	{
		super.resize(width, height);

	}

	@Override
	public void dispose ()
	{
		batch.dispose();
		shape.dispose();
		font.dispose();
	}
}
