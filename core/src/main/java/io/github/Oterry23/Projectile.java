package io.github.Oterry23;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Projectile extends Actor {
    Vector2 direction;
    public float projSpeed = 200f;

    Sprite sprite;
    Texture texture;

    public Projectile(float x, float y, Vector2 dir){
        texture = new Texture(Gdx.files.internal("placeholderProjectile.png"));
        sprite = new Sprite(texture);
        direction = new Vector2(dir);
        setPosition(x, y);
    }

    public void move(float delta){
        direction.nor().scl(projSpeed * delta);
        setPosition(getX() + direction.x, getY() + direction.y);
    }

    @Override
    public void act(float delta){
        move(delta);
    }

    @Override
    public void setPosition(float x, float y){
        sprite.setPosition(x, y);
        super.setPosition(x, y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        sprite.draw(batch);
    }
}
