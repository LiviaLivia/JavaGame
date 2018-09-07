// JGameEx28.java

import ch.aplu.jgamegrid.*;
import ch.aplu.util.*;
import java.awt.*;

public class JGameEx28 extends GameGrid implements GGActorCollisionListener, GGMouseListener
{
  private final Location startLocation = new Location(100, 300);
  public static boolean flag = false;
  public JGameEx28()
  {
    super(600, 600, 1, null, "black.gif", false);
    setTitle("Don't touch the rings.");
    setSimulationPeriod(50);
    Dart dart = new Dart();
    addActor(dart, new Location(100, 300));
    addMouseListener (this ,GGMouse.lPress); 
    addMouseListener(dart, GGMouse.move);
    
      
    dart.setCollisionSpot(new Point(0, 0)); 
    
    for (int i = 0; i < 20; i++)
    {  
      Actor ring = new Actor("circle_ballon.png");
      addActor(ring, new Location((int)(600*Math.random() + 1), 
                                     (int)(600*Math.random() + 1)));
      dart.addCollisionActor(ring);
      dart.addActorCollisionListener(this);
    }
    show();
    doRun();
  }

  public boolean mouseEvent(GGMouse mouse)
  {
    flag = true;
    return true; 
  }
  
  public int collide(Actor actor1, Actor actor2)
  {
    actor1.setLocation(startLocation);
    flag = false;
    return 0;
  }

  public static void main(String[] args)
  {
    new JGameEx28();
  }
}


