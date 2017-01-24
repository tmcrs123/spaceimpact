package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Player extends Ship {

    private ProjectileFactory projectileFactory;
    private int lives;
    private int fireBuffer;

    public Player(Representable representation, ProjectileFactory projectileFactory) {
        super(representation);
        this.projectileFactory = projectileFactory;
        setSpeed(200); // TODO: change this to a more reasonable value
    }

    @Override
    public void fire() {
        if (fireBuffer == 0) {
            projectileFactory.createProjectile(GameObjectType.PROJECTILE,true,100);
            fireBuffer = 10;
        }
    }

    public void decreaseFireBuffer() {
        if (fireBuffer > 0) fireBuffer--;
    }

    public void playerMove(MoveDirection moveDirection) {
        switch (moveDirection) {
            case UP:
                move(0, -getSpeed());
                break;
            case DOWN:
                move(0, getSpeed());
                break;
            case LEFT:
                move(-getSpeed(), 0);
                break;
            case RIGHT:
                move(getSpeed(), 0);
                break;
        }
    }

    @Override
    public String toString() {
        return getX() + " " + getY();
    }
}
