package io.github.Oterry23;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;


public class Level extends Stage{

    public Player player;
    public FitViewport viewport;

    public Level(FitViewport v){
        viewport = v;
        player = new Player(0, 0);
        addActor(player);
    }

    public void act(){
        for(Actor actor : getActors()){
            if(actor.getX() < 0 || actor.getX() > viewport.getWorldWidth()){
                actor.remove();
            }
            else if(actor.getY() < 0 || actor.getY() > viewport.getWorldHeight()){
                actor.remove();
            }
        }
    }
}
