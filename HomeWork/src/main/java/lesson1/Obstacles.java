package lesson1;

public interface Obstacles {
    int a  = 0;
    default int getSize(){
        return a;
    }
}
