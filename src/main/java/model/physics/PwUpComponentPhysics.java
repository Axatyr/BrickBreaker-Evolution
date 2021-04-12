package model.physics;

import java.util.Optional;

import controller.event.HitEvent;
import model.entities.GameBoardImpl;
import model.entities.GameObject;
import model.entities.PowerUp;
import model.utilities.Boundaries;
import model.utilities.DirVector;
import model.utilities.GameObjStatus;
import model.utilities.Pair;

public class PwUpComponentPhysics implements ComponentPhysics {

    /**
     * 
     */
    @Override
    public void update(final int timeElapsed, final GameObject gameObject, final GameBoardImpl board) {
        final PowerUp powerUp = (PowerUp) gameObject;
        final DirVector dirVectPwUp = powerUp.getDirVector();
        if (powerUp.getStatus().equals(GameObjStatus.DROP_POWERUP)) {
            powerUp.setPos(powerUp.getPos().sum(dirVectPwUp.mul(timeElapsed * powerUp.getSpeed())));
        }

        final Optional<Boundaries> sideCollisionInfo = board.checkGameObjCollisionsWithWall(powerUp);
        if (sideCollisionInfo.isPresent()) {
            board.eventListener(new HitEvent(Optional.of(powerUp), Optional.of(sideCollisionInfo.get())));
        }

        final Optional<Pair<PowerUp, Boundaries>> paddleCollisionInfo = board.checkPowerUpCollisionsWithPaddle(powerUp);
        if (paddleCollisionInfo.isPresent()) {
            board.eventListener(new HitEvent(Optional.of(paddleCollisionInfo.get().getX()), Optional.empty()));
        }
    }

}
