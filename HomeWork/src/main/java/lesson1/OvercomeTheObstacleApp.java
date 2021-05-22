package lesson1;

public class OvercomeTheObstacleApp {
    public static void main(String[] args) {

        Person person = new Person("Person Chuck", 1000, 3);
        Cat cat = new Cat("Cat Tom", 900, 2);
        Robot robot = new Robot("Robot R2D2", 2000, 1);
        Wall wall = new Wall("Wall", 2);
        RunningTrack runningTrack = new RunningTrack("Running track", 1000);
        Obstacles obstacle1 = runningTrack;
        Obstacles obstacle2 = wall;
        Obstacles[] obstacles = new Obstacles[]{obstacle1, obstacle2};
        CanPass canPasser = person;
        CanPass canPasser1 = cat;
        CanPass canPasser2 = robot;
        CanPass[] canPassers = new CanPass[]{canPasser, canPasser1, canPasser2};


        Running runner = person;
        Running runner1 = cat;
        Running runner2 = robot;
        Running[] runners = new Running[] {runner, runner1, runner2};

        Jumpable jumper = person;
        Jumpable jumper1 = cat;
        Jumpable jumper2 = robot;
        Jumpable[] jumpers = new Jumpable[] {jumper, jumper1, jumper2};

        for (Running r : runners) {
            r.run();
        }

        for (Jumpable j : jumpers) {
            j.jump();
        }


        for (int i = 0; i < canPassers.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j] == obstacle1) {
                    if (canPassers[i].canRun(obstacles[j])) {
                        System.out.println(canPassers[i] + " passed running track!");
                    } else {
                        System.out.println(canPassers[i] + "not passed running track!");
                        break;
                    }
                } else {
                    if (canPassers[i].canJump(obstacles[j])) {
                        System.out.println(canPassers[i] + " passed wall!");
                    } else {
                        System.out.println(canPassers[i] + "not passed wall!");
                        break;
                    }
                }
            }
        }
    }
}
