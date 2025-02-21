package io.github.Oterry23;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;

    Level lvl;

    @Override
    public void create() {
        batch = new SpriteBatch();
        lvl = new Level(new FitViewport(640, 360));
        Gdx.input.setInputProcessor(lvl);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        lvl.act(Gdx.graphics.getDeltaTime());
        lvl.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
