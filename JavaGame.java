


// JGameEx28.java

import ch.aplu.jgamegrid.*;
import ch.aplu.util.*;
import java.awt.*;

public class JavaGame extends GameGrid implements GGActorCollisionListener, GGMouseListener
{
  private final Location startLocation = new Location(100, 100);
  public static boolean flag = false;
  
  public JavaGame()
  {
    super(700, 200, 1, null, "Stone2.png", false);
    setTitle("Don't touch the Bats");
    setSimulationPeriod(50);
    Player player = new Player();
    addActor(player, new Location(80, 100));  
    addMouseListener (this ,GGMouse.lPress); 
    addMouseListener(player, GGMouse.move);
    player.addCollisionActor(player); 
    Crystal crystal = new Crystal();
    addActor(crystal, new Location(680, 100));
    
    for (int i = 0; i < 6; i++)
    {  
      Npc bat = new Npc();
      int j = 50;
      while (j <120)j = ((int) Math.round( 700*Math.random() +1));
      int k = ((int) Math.round(200*Math.random() +1));
      addActor(bat, new Location((int)j , (int)k));
      player.addCollisionActor(bat);
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
  
  public int collide(Actor player, Actor bat)
  {
    player.setLocation(startLocation);
    flag = false;
    return 0;
  }

  public static void main(String[] args)
  {
    new JavaGame();
  }
}


