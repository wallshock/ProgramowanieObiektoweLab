package org.example.agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.print("system wystartował\n");
        run(new Direction[]{Direction.FORWARD,Direction.FORWARD});
        System.out.print("system zakończył działanie");
    }

    public static void run(Direction[] args) {
        System.out.println("Start");
        for(int i=0; i < args.length; i++) {
//            if(i!=0){
//                System.out.print(", ");
//            }
            Direction dir = args[i];
            switch (dir) {
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak skręca w lewo");
                    break;
                default:
                    System.out.println("Nieznana komenda");
                    break;

            }
        }
        System.out.println("Stop");
    }
}
