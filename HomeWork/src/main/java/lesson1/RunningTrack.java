package lesson1;

public class RunningTrack implements Obstacles{
    private String name;
    private int length;

    public RunningTrack(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    /**
     * Определяет размер препядствия, как длинну беговой дорожки
     * @return length
     */
    @Override
    public int getSize() {
        return length;
    }

}
