package io.github.Oterry23;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;


public class Level extends Stage{

    public Player player;

    public Level(FitViewport viewport){
        player = new Player(viewport.getWorldWidth()/2, 0);
        addActor(player);
    }
}
