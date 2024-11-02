import java.util.Random;


class Die {
    private Random random = new Random();

    public Die() {
        this.random = new Random();
    }

 
    public int roll() {
        return random.nextInt(6) + 1;
    }
}


class Player {

    
    private String name;
    private int score = 0; 
     

    public Player(String name) {
        this.name = name;
    }

    

    public void rollDice(Die die1, Die die2, ScoreCalculator scoreCalculator) {
        int roll1 = die1.roll();
        int roll2 = die2.roll();
        
        System.out.println(name + " rolled: " + roll1 + " and " + roll2);
        int roundScore = scoreCalculator.calculateScore(roll1, roll2);
        score += roundScore;
        score = Math.max(score, 0);

        if (roll1 + roll2 == 10) {

                System.out.println("You landed on The WereWall, pay 80 bucks, Lucky for you i can roll again");
                score -= 80;
                score = Math.max(score, 0);
                rollDice(die1, die2, scoreCalculator); // Recursive call for extra roll
                
        }
    }

     


    
    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

}





class ScoreCalculator {

        public int calculateScore(int roll1, int roll2){

            int sum = roll1 + roll2;
            int score = 0;
            score = Math.max(score, 0);

            if(sum == 2){

                System.out.println("You landed on Tower, You won 250");
                score += 250;
                score = Math.max(score, 0);

            }

            else if (sum == 3){ 

                System.out.println("You landed on Crater, you need to pay 100");
                score -= 100;
                score = Math.max(score, 0);

            }
            else if (sum == 4){ 

                System.out.println("You landed on Palace Gates, you won 100");
                score += 100;
                score = Math.max(score, 0);

            }
            else if (sum == 5){ 

                System.out.println("You landed on Cold Desert, you need to pay 20");
                score -= 20;
                score = Math.max(score, 0);

            }

            else if (sum == 6){ 

                System.out.println("You landed on score City, you won 180");
                score += 180;
                score = Math.max(score, 0);

            }
            else if (sum == 7){ 

                System.out.println("You landed on Monastery, you can take a break");
                score += 0;
                score = Math.max(score, 0);

            }
            else if (sum == 8){ 

                System.out.println("You landed on Black Cave, you need to pay 70");
                score -= 70;
                score = Math.max(score, 0);

            }
            else if (sum == 9){ 

                System.out.println("You landed on Huts In The Mountins, you won 60");
                score += 60;
                score = Math.max(score, 0);

            }
           
            else if (sum == 11){ 

                System.out.println("You landed on The Pit, you need to pay 50");
                score -= 50;
                score = Math.max(score, 0);

            }

            else if (sum == 12){ 

                System.out.println("YOU HIT THE JACKPOT, YOU FOUND A GOLD MINE");
                score += 650;
                score = Math.max(score, 0);

            }

        return score;
        }   
}

class Game {
    private Player player1;
    private Player player2;
    private Die die1;
    private Die die2;
    private ScoreCalculator scoreCalculator;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.die1 = new Die();
        this.die2 = new Die();
        this.scoreCalculator = new ScoreCalculator();
    }

    public void play() {
        while (player1.getScore() < 3000 && player2.getScore() < 3000){
    
            player1.rollDice(die1, die2, scoreCalculator);
            player2.rollDice(die1, die2, scoreCalculator);
            System.out.println(player1.getName() + " Score: " + player1.getScore());
            System.out.println(player2.getName() + " Score: " + player2.getScore());
            System.out.println();
        }
        if (player1.getScore() >= 3000){
            System.out.println("player one has won with a score of " + player1.getScore());
        } 
        if (player2.getScore() >= 3000){
            System.out.println("player two has won with a score of " + player2.getScore());
        }
    }
}





public class cdio2 {
    public static void main(String[] args) {
       

        simpleTestScoreNeverGoesNegative();
    }
public static void simpleTestScoreNeverGoesNegative() {
        // Initialize objects for the test
        Player testPlayer = new Player("TestPlayer");
        Die die1 = new Die();
        Die die2 = new Die();
        ScoreCalculator scoreCalculator = new ScoreCalculator();

        // Simulate rolling dice multiple times
        boolean scoreNeverNegative = true;
        for (int i = 0; i < 100; i++) {
            testPlayer.rollDice(die1, die2, scoreCalculator);
            if (testPlayer.getScore() < 0) {
                scoreNeverNegative = false;
                break;
            }
        }

        // Output the result of the test
        if (scoreNeverNegative) {
            System.out.println("Test passed - The score never went negative");
        } else {
            System.out.println("Test failed - The score went negative");
        }
    }

}
