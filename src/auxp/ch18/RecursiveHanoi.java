package auxp.ch18;

public class RecursiveHanoi {

    public static void main(String[] args) {
        recursiveHanoi(15);

    }

    public static void recursiveHanoi(int discs) {
        recursiveHanoi(discs, 'A', 'B', 'C');
    }

    private static void recursiveHanoi(int discs, char fromTower, char toTower, char auxTower) {
        if(discs == 1)
            System.out.println(String.format("Move disk %d from %c to %c", discs,fromTower,toTower));
        else{
            recursiveHanoi(discs-1, fromTower, auxTower, toTower);
            System.out.println(String.format("Move disk %d from %c to %c", discs,fromTower,toTower));
            recursiveHanoi(discs-1, auxTower, toTower, fromTower);
        }

    }
}
