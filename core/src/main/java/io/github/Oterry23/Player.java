package io.github.Oterry23;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;


public class Player extends Actor{
    Sprite sprite;
    Texture texture;

    Vector2 position;
    Vector2 velocity;

    private final float speed = 100f;


    public Player(float x, float y){
        texture = new Texture(Gdx.files.internal("placeholderPlayer.png"));
        sprite = new Sprite(texture, texture.getWidth(), texture.getHeight());
        
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);

        sprite.setPosition(position.x, position.y);
        setPosition(sprite.getX(),sprite.getY());
    }

    @Override
    public void act(float delta){

        move(delta);
        super.act(delta);
    }

    @Override
    public void positionChanged(){
        sprite.setPosition(getX(), getY());
        super.positionChanged();
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        sprite.draw(batch);
    }

    public void move(float delta){
        velocity.set(0, 0);

        if(Gdx.input.isKeyPressed(Input.Keys.W) && getX() < Gdx.graphics.getHeight()-sprite.getHeight()){
            velocity.y = speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S) && getX() >= 0){
            velocity.y = -speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D) && getX() < Gdx.graphics.getWidth()-sprite.getWidth()){
            velocity.x = speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) && getX() >= 0){
            velocity.x = -speed;
        }
        position.add(velocity.x * delta, velocity.y * delta);
        setPosition(position.x, position.y);
    }
}
