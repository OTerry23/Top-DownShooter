package io.github.Oterry23;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;


public class Player extends Actor{
    Sprite sprite;
    Texture texture;

    Vector2 direction;
    float rotation;
    
    private final float speed = 80f;
    private final float rotationSpeed = 100f;


    public Player(float x, float y){
        texture = new Texture(Gdx.files.internal("placeholderPlayer.png"));
        sprite = new Sprite(texture, texture.getWidth(), texture.getHeight());
        
        setPosition(x, y);
    }

    @Override
    public void setPosition(float x, float y){
        sprite.setPosition(x, y);
        super.setPosition(x, y);
    }

    @Override
    public void act(float delta){
        move(delta);
        shoot();
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        sprite.draw(batch);
    }

    public void move(float delta){

        float angleRad = (float) Math.toRadians(sprite.getRotation());
        direction = new Vector2((float) Math.cos(angleRad),(float) Math.sin(angleRad));
        float dx = direction.x * speed * delta;
        float dy = direction.y * speed * delta;

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            setPosition(getX() + dx, getY() + dy);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            setPosition(getX() - dx/2, getY() - dy/2);        
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) { // Turn right
            sprite.rotate(-rotationSpeed * delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) { // Turn left
            sprite.rotate(rotationSpeed * delta);
        }
    }

    Projectiles projectiles;
    Projectile proj;
    public void shoot(){
        if(projectiles == null){
            projectiles = new Projectiles();
        }
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            proj = new Projectile(getX(), getY(), direction);
            getStage().addActor(proj);
        }
    }
}
