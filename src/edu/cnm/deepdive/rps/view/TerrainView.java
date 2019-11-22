package edu.cnm.deepdive.rps.view;

import edu.cnm.deepdive.rps.model.Arena;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TerrainView extends Canvas {

  private static final double MAX_HUE = 360;

  private Color[] breedColors;
  private Arena arena;

  public void setArena(Arena arena) {
    this.arena = arena;
    int numBreeds = arena.getNumBreeds();
    breedColors = new Color[numBreeds];
    for (int i = 0; i < numBreeds; i++) {
      breedColors[i] = Color.hsb(i * MAX_HUE / numBreeds, 1, 0.9);
    }
  }

  public void draw() {
    if (arena != null) {
      GraphicsContext context = getGraphicsContext2D();
      byte[][] terrain = arena.getTerrain();
      double cellWidth = getWidth() / terrain[0].length;
      double cellHeight = getHeight() / terrain.length;
      context.clearRect(0, 0, getWidth(), getHeight());
      for (int row = 0; row < terrain.length; row++) {
        for (int col = 0; col < terrain[row].length; col++) {
          context.setFill(breedColors[terrain[row][col]]);
          context.fillOval(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
        }
      }
    }
  }

}
