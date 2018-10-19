
import ch.aplu.jgamegrid.*;
import ch.aplu.util.*;
import java.awt.*;

class Player extends Actor implements GGMouseListener
{
    private Location oldLocation = new Location();

    public Player()
    {
        super("Character.png");  
    }

    public boolean mouseEvent(GGMouse mouse)
    {
        if (JavaGame.flag)
        {
            Location location = gameGrid.toLocationInGrid(mouse.getX(), mouse.getY());
            setLocation(location);
            JavaGame.flag = false;            
        }
        return true;
    }
}