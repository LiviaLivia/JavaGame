
import ch.aplu.jgamegrid.*;
import ch.aplu.util.*;
import java.awt.*;

class Dart extends Actor implements GGMouseListener
{
    private Location oldLocation = new Location();

    public Dart()
    {
        super("logo_circle.png");  
    }

    public boolean mouseEvent(GGMouse mouse)
    {
        if (JGameEx28.flag)
        {
            Location location =
                gameGrid.toLocationInGrid(mouse.getX(), mouse.getY());
            setLocation(location);
        }
        return true;
    }
}