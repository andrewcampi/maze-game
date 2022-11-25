package com.mygdx.maze.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.mygdx.maze.entity.EntityManager;
import com.mygdx.maze.entity.EntityPlayer;
import com.mygdx.maze.main.Driver;
import com.mygdx.maze.maze.GenerationType;
import com.mygdx.maze.maze.Maze;
import com.mygdx.maze.maze.MazeFactory;
import com.mygdx.maze.maze.TileType;
import com.mygdx.maze.ui.GameUI;
import com.mygdx.maze.util.RenderUtil;
import com.mygdx.maze.Settings;

public class GameScreen implements Screen
{
	public MazeFactory factory;

	public Maze maze;

	public TileType tileType;

	public GenerationType genType;

	public int mazeHeight;

	public int mazeWidth;

	public EntityManager manager;

	public EntityPlayer player;

	public GameUI ui;

	private Music gameMusic;
	
	Settings global_settings = Settings.getInstance();

	public GameScreen()
	{
		this.initMaze();
		this.initEntities();

		this.ui = new GameUI(this);

		gameMusic = Gdx.audio.newMusic(Gdx.files.internal("Scent of Scarlet (LOOP).wav"));
		gameMusic.setLooping(true);

	}

	@Override
	public void render(float delta)
	{
		if(maze != null)
		{
			RenderUtil.clearScreen(this.maze.getDrawer().getBgColor());
			RenderUtil.updateCamera();

			//Update Entities
			manager.update(delta);
			ui.act(delta);

			//Draw Maze and Entities
			maze.render();
			manager.render(delta);

			//Draw UI
			ui.getViewport().apply();
			ui.draw();

			//Check if player has won
			this.checkAndHandlePlayerWin();

			//Regenerate the Maze
			if(Gdx.input.isKeyJustPressed(Keys.R))
			{
				this.createMaze(this.tileType, this.genType, this.mazeWidth, this.mazeHeight);
			}
		}
		else
		{
			this.createMaze(this.tileType, this.genType, this.mazeWidth, this.mazeHeight);
		}
	}

	public void initMaze()
	{
		this.factory = new MazeFactory();
		this.maze = null;

		this.tileType = TileType.SQUARE;
		this.genType = GenerationType.RECURSIVE_BACKTRACK;
		// Final Project ---------------------
		this.mazeWidth = global_settings.getMazeWidth();
		this.mazeHeight = global_settings.getMazeHeight();
		// -----------------------------------
	}

	public void initEntities()
	{
		this.manager = new EntityManager();
		this.player = null;
	}

	public void createMaze(TileType tileType, GenerationType genType, int width, int height)
	{
		if(this.maze != null)
		{
			this.manager.getEntities().remove(this.player);
			this.maze = null;
			this.player = null;
		}
		else
		{
			this.maze = factory.getMaze(tileType, genType, width, height);
			this.player = new EntityPlayer(this.maze, this.maze.getEntrance());

			this.manager.addEntity(player);
		}
	}

	public void checkAndHandlePlayerWin()
	{
		if(this.player.getTile().getRow() == this.maze.getExit().getRow()
				&& this.player.getTile().getColumn() == this.maze.getExit().getColumn())
		{
			this.createMaze(this.tileType, this.genType, this.mazeWidth, this.mazeHeight);
		}
	}

	@Override
	public void resize(int width, int height)
	{
		this.ui.getViewport().update(width, height);
		Driver.viewport.update(width, height, true);
		Driver.camera.update();
	}

	@Override
	public void dispose()
	{

	}

	@Override
	public void pause()
	{

	}

	@Override
	public void resume()
	{

	}

	@Override
	public void show()
	{
		gameMusic.play()
	}

	@Override
	public void hide()
	{

	}

	public Maze getMaze()
	{
		return maze;
	}

	public void setMaze(Maze maze)
	{
		this.maze = maze;
	}

	public TileType getTileType()
	{
		return tileType;
	}

	public void setTileType(TileType tileType)
	{
		this.tileType = tileType;
	}

	public GenerationType getGenType()
	{
		return genType;
	}

	public void setGenType(GenerationType genType)
	{
		this.genType = genType;
	}

	public int getMazeHeight()
	{
		return mazeHeight;
	}

	public void setMazeHeight(int mazeHeight)
	{
		this.mazeHeight = mazeHeight;
	}

	public int getMazeWidth()
	{
		return mazeWidth;
	}

	public void setMazeWidth(int mazeWidth)
	{
		this.mazeWidth = mazeWidth;
	}
}
