package lesson1;

public class Person implements Running, Jumpable, CanPass {

    private String name;
    private int abToRun;
    private int abToJump;


    public Person(String name, int abToRun, int abToJump) {
        this.name = name;
        this.abToRun = abToRun;
        this.abToJump = abToJump;
    }

    public String getName() {
        return name;
    }

    public int getAbToRun() {
        return abToRun;
    }

    public int getAbToJump() {
        return abToJump;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbToRun(int abToRun) {
        this.abToRun = abToRun;
    }

    public void setAbToJump(int abToJump) {
        this.abToJump = abToJump;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", abToRun=" + abToRun +
                ", abToJump=" + abToJump +
                '}';
    }

    /**
     * Метод бежать
     */
    @Override
    public void run() {
        System.out.println(name + " ran!");
    }

    /**
     * Метод прыгать
     */
    @Override
    public void jump() {
        System.out.println(name + " jump!");
    }

    /**
     * Проверяет сможет ли пробежать по беговой дорожке длинной size
     * @param runningTrack
     * @return true
     */
    @Override
    public boolean canRun(Obstacles runningTrack) {
        return runningTrack.getSize() <= abToRun;
    }

    /**
     * Проверяет сможет ли перепрыгнуть через стену высотой size
     * @param wall
     * @return true
     */
    @Override
    public boolean canJump(Obstacles wall) {
        return wall.getSize() <= abToJump;
    }


}
