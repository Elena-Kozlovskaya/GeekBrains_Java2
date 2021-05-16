package lesson1;

public class Wall implements Obstacles{
    private String name;
    private int height;

    public Wall(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    /**
     * Определяет размер препядствия, как высоту стены
     * @return height
     */
    @Override
    public int getSize() {
        return height;
    }
}
