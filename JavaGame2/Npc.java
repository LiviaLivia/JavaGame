 
import ch.aplu.jgamegrid.*;
import ch.aplu.util.*;
import java.awt.*;

public class Npc extends Actor
{

    public Npc()
    {
        super("Bat.png");
        setCollisionSpot(new Point(0, 18));
    }
    
    public void act()
    {
        move(1);         
        if (isNearBorder())
            turn(180);
        
        
    }
}
