package lesson1;

public interface CanPass {
    default boolean canRun(Obstacles runningTrack){
        return true;
    }
    default boolean canJump(Obstacles wall){
        return true;
    }
}
