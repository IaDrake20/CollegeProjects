package Assign1;
/*
 * Ian Drake
 * Fielders: Quickly throw the ball to another fielder.
 * Catch by using a regular glove.  Swing by not batting.
 */
public class Fielder extends Player{

    public Fielder(){
        this.tb = new ThrowToFielder();
        this.bb = new SwingNoBat();
        this.cb = new CatchByGlove();

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

    @Override
    void SetName(String name) {
        this.name = name;
    }

    @Override
    void Display() {
        System.out.println("I am a fielder named "+name);
    }
}
