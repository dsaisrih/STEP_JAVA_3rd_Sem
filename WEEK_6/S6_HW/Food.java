public abstract class Food {
    // Template method
    public final void prepare() {
        wash();
        cook();
        serve();
        System.out.println("----");
    }

    protected abstract void wash();
    protected abstract void cook();
    protected abstract void serve();
}
