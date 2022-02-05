package pack;

public class User {
    private String name;
    private int age;
    private boolean activated;

    public User() {
    }

    public User(String name, int age, boolean activated) {
        this.name = name;
        this.age = age;
        this.activated = activated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", activated=" + activated +
                '}';
    }
}
