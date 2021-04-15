package model.entities;

import controller.input.ComponentInputEmpty;
import controller.input.ControllerInput;
import model.physics.BallComponentPhysics;
import model.utilities.DirVector;
import model.utilities.GameObjStatus;
import model.utilities.Position;
import view.graphics.AdapterGraphics;
import view.graphics.BallComponentGraphics;

public final class Ball extends GameObjectImpl {

<<<<<<< HEAD
    private static final long serialVersionUID = 9139431443544241120L;

=======
    private static final long serialVersionUID = 6752058765184851106L;
>>>>>>> 046d617928b6b08cc75b7c3f830a37ea7fee837c
    private final String texturePath;

    private Ball(final Position pos, final DirVector dir, final double speed, final int height, final int width, final String tPath) {
        super(pos, dir, speed, height, width, new BallComponentPhysics(), new ComponentInputEmpty(), new BallComponentGraphics(tPath), 
                GameObjStatus.NOT_DESTRUCTIBLE);
        this.texturePath = tPath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updatePhysics(final int timeElapsed, final GameBoardImpl world) {
        this.getComponentPhysics().update(timeElapsed, this, world);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateInput(final ControllerInput controller) {
        this.getComponentInput().update(this, controller);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateGraphics(final AdapterGraphics graphicsAdapter) {
        this.getComponentGraphics().update(this, graphicsAdapter);
    }

    /**
     * 
     * Sets the new direction relative to the Y axis.
     */
    public void setDirOnY() {
        this.setDirVector(new DirVector(this.getDirVector().getX(), -this.getDirVector().getY()));
    }

    /**
     * 
     * Sets the new direction relative to the X axis.
     */
    public void setDirOnX() {
        this.setDirVector(new DirVector(-this.getDirVector().getX(), this.getDirVector().getY()));
    }

    /**
     * 
     * @return texture path
     */
    public String getTexturePath() {
        return texturePath;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((texturePath == null) ? 0 : texturePath.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ball other = (Ball) obj;
        if (texturePath == null) {
            if (other.texturePath != null) {
                return false;
            }
        } else if (!texturePath.equals(other.texturePath)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ball [texturePath=" + texturePath + "]";
    }

    public static class Builder {

        private int height;
        private int width;
        private double speed;
        private String tPath;
        private Position pos;
        private DirVector dir;

        /**
         * @param dir
         * @return return himself
         */
        public Builder direction(final DirVector dir) {
            this.dir = dir;
            return this;
        }

        /**
         * 
         * @param speed
         * @return return himself
         */
        public Builder speed(final double speed) {
            this.speed = speed;
            return this;
        }

        /**
         * 
         * @param height
         * @return return himself
         */
        public Builder height(final int height) {
            this.height = height;
            return this;
        }

        /**
         * 
         * @param tPath
         * @return return himself
         */
        public Builder path(final String tPath) {
            this.tPath = tPath;
            return this;
        }

        /**
         * 
         * @param width
         * @return himself
         */
        public Builder width(final int width) {
            this.width = width;
            return this;
        }

        /**
         * 
         * @param pos
         * @return return himself
         */
        public Builder position(final Position pos) {
            this.pos = pos;
            return this;
        }

        /**
         * builds the ball if the characteristics are valid.
         * @return the new Ball object
         */
        public Ball build() {
            if (this.dir == null || this.height <= 0 || this.width <= 0 || this.speed < 0 || this.pos == null || this.tPath == null) {
                throw new IllegalStateException();
            }
            return new Ball(this.pos, this.dir, this.speed, this.height, this.width, this.tPath);
        }
    }

}
