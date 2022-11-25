package com.mygdx.maze;

public class Settings {

  public float settings_lightRadius = 1.0f; // Default = 1.0f
  public int settings_cameraZoomWidth = 500; // Default = 500
  public int settings_cameraZoomHeight = 450; // Default = 450
  public int settings_mazeWidth = 20; // Default = 20
  public int settings_mazeHeight = 20; // Default = 20
  public int settings_playerSpeed = 1; // Default = 1
  public int settings_playerWidth = 8; // Default = 10
  public int settings_playerHeight = 8; // Default = 10
  public int settings_wallThickness = 40; // Default = 20
  public int settings_playerCurrentXPosition = 0; // Default = 0
  public int settings_playerCurrentYPosition = 0; // Default = 0
  private static Settings instance = null;


  public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

  public void setLightRadius(float givenLightRadius) { this.settings_lightRadius = givenLightRadius; }
  public float getLightRadius() { return this.settings_lightRadius; }

  public void setCameraZoomWidth(int givenCameraZoomWidth) { this.settings_cameraZoomWidth = givenCameraZoomWidth; }
  public int getCameraZoomWidth() { return this.settings_cameraZoomWidth; }

  public void setCameraZoomHeight(int givenCameraZoomHeight) { this.settings_cameraZoomHeight = givenCameraZoomHeight; }
  public int getCameraZoomHeight() { return this.settings_cameraZoomHeight; }

  public void setMazeWidth(int givenMazeWidth) { this.settings_mazeWidth = givenMazeWidth; }
  public int getMazeWidth() { return this.settings_mazeWidth; }

  public void setMazeHeight(int givenMazeHeight) { this.settings_mazeHeight = givenMazeHeight; }
  public int getMazeHeight() { return this.settings_mazeHeight; }

  public void setPlayerSpeed(int givenPlayerSpeed) { this.settings_playerSpeed = givenPlayerSpeed; }
  public int getPlayerSpeed() { return this.settings_playerSpeed; }

  public void setPlayerWidth(int givenPlayerWidth) { this.settings_playerSpeed = givenPlayerWidth; }
  public int getPlayerWidth() { return this.settings_playerWidth; }

  public void setPlayerHeight(int givenPlayerHeight) { this.settings_playerSpeed = givenPlayerHeight; }
  public int getPlayerHeight() { return this.settings_playerHeight; }

  public void setWallThickness(int givenWallThickness) { this.settings_wallThickness = givenWallThickness; }
  public int getWallThickness() { return this.settings_wallThickness; }

  public void setPlayerCurrentXPosition(int givenPlayerCurrentXPosition) { this.settings_playerCurrentXPosition = givenPlayerCurrentXPosition; }
  public int getPlayerCurrentXPosition() { return this.settings_playerCurrentXPosition; }

  public void setPlayerCurrentYPosition(int givenPlayerCurrentYPosition) { this.settings_playerCurrentYPosition = givenPlayerCurrentYPosition; }
  public int getPlayerCurrentYPosition() { return this.settings_playerCurrentYPosition; }


}
