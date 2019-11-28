import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    public static Hippodrome game;

    Hippodrome(List<Horse> horseList){
        horses = horseList;
    }

    public List<Horse> getHorses(){
        return horses;
    }

    public void run() throws InterruptedException{
        for(int i = 0; i < 100; i++){
            this.move();
            this.print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for(Horse horse : horses){
            horse.move();
        }
    }

    public void print(){
        for(Horse horse : horses){
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        Horse winner = null;
        winner = (horses.get(0).getDistance() > horses.get(1).getDistance())? horses.get(0) : horses.get(1);
        winner = (winner.getDistance() > horses.get(2).getDistance())? winner : horses.get(2);
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException{
        Horse horse1 = new Horse("Horse_1", 3, 0);
        Horse horse2 = new Horse("Horse_2", 3, 0);
        Horse horse3 = new Horse("Horse_3", 3, 0);
        List<Horse> list = new ArrayList<>();
        list.add(horse1);
        list.add(horse2);
        list.add(horse3);
        game = new Hippodrome(list);
        game.run();
        game.printWinner();
    }
}
