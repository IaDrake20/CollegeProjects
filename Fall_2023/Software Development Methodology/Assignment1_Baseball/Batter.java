package Assign1;
/*
 * Ian Drake
 * Batters:  Do not throw.
 * Use bare hands to catch the ball.  Swing by focusing on contact.
 */
public class Batter extends Player{

    public Batter(){
        this.tb = new ThrowNoThrow();
        this.cb = new CatchByHand();
        this.bb = new SwingForContact();
    }
    @Override
    void SetName(String name) {
        this.name = name;
    }

    @Override
    void Display() {
        System.out.println("I am a batter named "+name);
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
