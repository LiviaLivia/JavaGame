// MyGameGrid.java

import ch.aplu.jgamegrid.*;
import java.awt.Color;

public class MyGameGrid extends GameGrid
{
  public MyGameGrid()
  {
    super(30, 30, 60, Color.red);
    show();
  }

  public static void main(String[] args)
  {
    new MyGameGrid();
  }
}
