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
    Vector2 direction;
    float rotation;
    
    private final float speed = 100f;


    public Player(float x, float y){
        texture = new Texture(Gdx.files.internal("placeholderPlayer.png"));
        sprite = new Sprite(texture, texture.getWidth(), texture.getHeight());
        
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);

        setPosition(position.x, position.y);
    }

    @Override
    public void setPosition(float x, float y){
        sprite.setPosition(x, y);
        super.setPosition(x, y);
    }

    @Override
    public void act(float delta){
        move(delta);
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        sprite.draw(batch);
    }

    public void rotate(Vector2 direction){
        rotation = direction.angleDeg();
        sprite.setRotation(rotation);
    }

    public void move(float delta){
        direction = new Vector2(Gdx.input.getX() - getX(), Gdx.graphics.getHeight() - Gdx.input.getY() - getY());
        rotate(direction);

        velocity.set(0, 0);


        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            direction.nor().scl(speed * delta);
            setPosition(getX() + direction.x, getY() + direction.y);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            direction.nor().scl(-speed * delta);
            setPosition(getX() + direction.x, getY() + direction.y);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) { // Strafe right
            Vector2 right = new Vector2(direction.y, -direction.x).nor().scl(speed * delta);
            setPosition(getX() + right.x, getY() + right.y);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) { // Strafe left
            Vector2 left = new Vector2(-direction.y, direction.x).nor().scl(speed * delta);
            setPosition(getX() + left.x, getY() + left.y);
        }
    }
}
