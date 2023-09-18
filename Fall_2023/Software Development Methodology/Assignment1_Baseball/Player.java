package Assign1;

public abstract class Player {
    BatterBehavior bb;
    CatcherBehavior cb;
    ThrowBehavior tb;

    String name;

    public Player() {

    }

    abstract void setBatterBehavior(BatterBehavior bb);// {this.bb = bb;}
    abstract void setCatcherBehavior(CatcherBehavior cb);// {this.cb = cb;}
    abstract void setThrowBehavior(ThrowBehavior tb);// {this.tb = tb;}

    abstract void SetName(String name);

    abstract void Display();

    public void PerformThrow() {tb.PerformThrow();}
    public void PerformBat() {bb.PerformBat();}
    public void PerformCatch() {cb.PerformCatch();}

}
