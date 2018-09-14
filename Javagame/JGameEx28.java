// JGameEx28.java

import ch.aplu.jgamegrid.*;
import ch.aplu.util.*;
import java.awt.*;

public class JGameEx28 extends GameGrid implements GGActorCollisionListener, GGMouseListener
{
  private final Location startLocation = new Location(100, 100);
  public static boolean flag = false;
  
  public JGameEx28()
  {
    super(700, 200, 1, null, "black.gif", false);
    setTitle("Don't touch the rings.");
    setSimulationPeriod(50);
    Player player = new Player();
    addActor(player, new Location(100, 100));  
    addMouseListener (this ,GGMouse.lPress); 
    addMouseListener(player, GGMouse.move);
    player.addCollisionActor(player); 
    Crystal crystal = new Crystal();
    addActor(crystal, new Location(680, 100));
    
    for (int i = 0; i < 8; i++)
    {  
      Actor ring = new Actor("circle_ballon.png");
      int j = 50;
      while (j <100)j = ((int) Math.round( 700*Math.random() +1));
      int k = ((int) Math.round(200*Math.random() +1));
      addActor(ring, new Location((int)j , (int)k));
      player.addCollisionActor(ring);
      player.addActorCollisionListener(this);

    }
    show();
    doRun();
  }

  public boolean mouseEvent(GGMouse mouse)
  {
    flag = true;
    return true; 
  }
  
  public int collide(Actor player, Actor ring)
  {
    player.setLocation(startLocation);
    flag = false;
    return 0;
  }

  public static void main(String[] args)
  {
    new JGameEx28();
  }
}


