package Assign1;
/*
Ian Drake
Pitchers:  Throw by throwing the ball to the catcher.
Catch by using a regular glove.  Swing by not batting.
 */
public class Pitcher extends Player {

    public Pitcher() {
        this.tb = new ThrowByPitch();
        this.cb = new CatchByGlove();
        this.bb = new SwingNoBat();

    }

    @Override
    void SetName(String name) {
        this.name = name;
    }

    @Override
    void Display() {
        System.out.println("I am a pitcher named " + name);
    }

    @Override
    void setBatterBehavior(BatterBehavior bb) {
        this.bb = bb;
    }

    @Override
    void setCatcherBehavior(CatcherBehavior cb) {
        this.cb = cb;
    }

    @Override
    void setThrowBehavior(ThrowBehavior tb) {
        this.tb = tb;
    }
}
