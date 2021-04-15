package view.graphics;

import java.io.Serializable;

import javafx.scene.image.Image;
import model.entities.Brick;
import model.entities.GameObject;

public class BrickComponentGraphics implements ComponentGraphics, Serializable {

    private static final long serialVersionUID = -2268513013055385771L;
    private final transient Image brickImage;

    public BrickComponentGraphics(final String texturePath) {
        this.brickImage = new Image(ClassLoader.getSystemResourceAsStream(texturePath));
    }

    /**
     *  draw the paddle by passing the specific graphic information to the graphic adapter. 
     */
    @Override
    public void update(final GameObject obj, final AdapterGraphics graphicsAdapt) {
        graphicsAdapt.drawBrick((Brick) obj, this.brickImage);
    }

}
