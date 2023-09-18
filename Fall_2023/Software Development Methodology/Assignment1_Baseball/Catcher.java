package Assign1;
/*
 * Ian Drake
 * Catcher:  Throw by throwing the ball back to the pitcher.
 * Catch by catching the balls thrown by a pitcher.  Swing by not batting.
 */
public class Catcher extends Player{


    public Catcher(){
        this.cb = new CatchFromPitcher();
        this.bb = new SwingNoBat();
        this.tb = new ThrowToPitcher();
    }
    @Override
    void SetName(String name) {
        this.name = name;
    }

    @Override
    void Display() {
        System.out.println("I am a catcher named "+name);
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
