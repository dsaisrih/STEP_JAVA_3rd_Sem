class Dog implements Pet {
    @Override
    public void eat() {
        System.out.println("Dog eats bones and food.");
    }

    @Override
    public void play() {
        System.out.println("Dog plays fetch.");
    }
}
