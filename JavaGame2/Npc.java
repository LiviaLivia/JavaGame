 
import ch.aplu.jgamegrid.*;
import ch.aplu.util.*;
import java.awt.*;

public class Npc extends Actor
{

    public Npc()
    {
        super("Bat.png");

    }
    
    public void act()
    {
        move(1);         
        if (isNearBorder())
            turn(180);
        
        
    }
}
