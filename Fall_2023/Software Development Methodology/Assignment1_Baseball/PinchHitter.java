package Assign1;
/*
 * Ian Drake
 * Pinch Hitter: Throw by not throwing.
 * Catch by not catching.   Swing by swinging for power.
 */
public class PinchHitter extends Player{

    public PinchHitter(){
        this.tb = new ThrowNoThrow();
        this.cb = new CatchNoCatch();
        this.bb = new SwingForPower();
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
        System.out.println("I am a pinch hitter named "+name);
    }
}
