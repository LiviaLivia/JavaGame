import java.awt.Color;
import java.awt.Font;
import ch.aplu.jgamegrid.*;
import ch.aplu.util.*;
import java.awt.*;

public class JavaGame extends GameGrid implements GGActorCollisionListener, GGMouseListener
{
  private final Location startLocation = new Location(40, 100);
  TextActor start = new TextActor("Klick to start", Color.white, new Color(255,255,255,0),new Font("Arial", Font.BOLD, 15));
  TextActor text = new TextActor("Level"+level , Color.white, new Color(255,255,255,0),new Font("Arial",0, 20));
  TextActor lifes = new TextActor("Lives: "+hearts , Color.red, new Color(255,255,255,0),new Font("Arial",0, 20));
  
  public static boolean flag = false;
  public static int level = 1;
  public static int hearts = 3;
  public static int simPeriode = 15;
  public static int h= 0;
  public JavaGame()
  {
    super(700, 200, 1, null, "Stone2.png", false);
    setTitle("Get the Cristal while avoiding the Bats");
    setSimulationPeriod(simPeriode);
    //text
    addActor(start, new Location(20, 70));
    addActor(text, new Location(2,10));
    addActor(lifes, new Location(500,10));
    Player player = new Player();
    addActor(player, new Location(40, 100));
    addMouseListener (this ,GGMouse.lPress); 
    addMouseListener(player, GGMouse.move);    
    player.addActorCollisionListener(this);
    Crystal crystal = new Crystal();
    addActor(crystal, new Location(680, 100));
    player.addCollisionActor(crystal);
    
    for (int i = 0; i < 7; i++)
    {  
      Npc bat = new Npc();
      int j = 50;
      while (j <100||j>620)j = ((int) Math.round( 700*Math.random() +1));
      int k = ((int) Math.round(200*Math.random() +1));
      addActor(bat, new Location((int)j , (int)k),90);
      player.addCollisionActor(bat);
    }
    show();
    doRun();
  }

  public boolean mouseEvent(GGMouse mouse)
  {
    flag = true;
    startText();
    return false; 
  }
  
  public int collide(Actor player, Actor actor2 )
  {
    if (player.getLocation().x > 660)
        {
            if(h==0)
            {
                Npc bat = new Npc();
                int j = 50;
                while (j <100||j>620)j = ((int) Math.round( 700*Math.random() +1));
                int k = ((int) Math.round(200*Math.random() +1));
                addActor(bat, new Location((int)j , (int)k),90);
                player.addCollisionActor(bat);
                h=1;
            }
            else
            {
                simPeriode--;
                setSimulationPeriod(simPeriode);
                
                h=0;
            } 
           level++;
           levelText();
        }
    else
    {
        if(hearts==0)
        {
            player.removeSelf();
            text.removeSelf();
            lifes.removeSelf();  
            TextActor score = new TextActor("Score: Level "+ level , Color.red, new Color(255,255,255,0),new Font("Arial",Font.BOLD, 20));
            addActor(score, new Location(10,100));
            doPause();
        }
        
        else
        {
        lifeText();
        hearts--;
        }
    }
    
    
    
    player.setLocation(startLocation);
    flag = false;
    return 0;
  }
 
  public void startText()
  {
      if(flag)
      {
         start.removeSelf();
      }
      else
      {      
         TextActor start = new TextActor("Klick to start", Color.white, new Color(255,255,255,0),new Font("Arial", Font.BOLD, 10));
         addActor(text,new Location(20,70));
      }
  }
  
  public void levelText()
  {
      text.removeSelf();
      text = new TextActor("Level "+level,Color.white,new Color(255,255,255,0),new Font("Arial",0,20));
      addActor(text, new Location(2,10));
  }
 
  public void fail(Player player)
  {
      if(hearts==0)
      {
         player.removeSelf();
      }
  
      
  }
  public void lifeText()
  {
      lifes.removeSelf();
      lifes = new TextActor("Lives: "+hearts,Color.red,new Color(255,255,255,0),new Font("Arial",0,20));
      addActor(lifes, new Location(500,10));
  }
  
  public static void main(String[] args)
  {
    new JavaGame();
    
  }
  

}