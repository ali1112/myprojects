public abstract class Weapon {

    private String name;
    public abstract void load();
    public abstract void fire();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
