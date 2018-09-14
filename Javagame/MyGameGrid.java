// MyGameGrid.java

import ch.aplu.jgamegrid.*;
import java.awt.Color;

public class MyGameGrid extends GameGrid
{
  public MyGameGrid()
  {
    super(10, 40, 60, Color.red);
    show();
  }

  public static void main(String[] args)
  {
    new MyGameGrid();
  }
}
