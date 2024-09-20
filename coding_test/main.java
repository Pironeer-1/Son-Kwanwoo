import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Player 클래스
class Player {
    private int hp = 50; // 초기 체력
    private int ad = 10; // 초기 공격력
    private int ap = 5;  // 초기 마법력

    public void setStatus(int point) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(point + "만큼의 스테이터스를 추가합니다. 체력, 공격력, 마법력 순으로 입력하세요");
        System.out.println("(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)");
        System.out.println("플레이어의 기본 스탯은 체력: 50, 공격력: 10, 마법력: 5입니다.\n");

        while (true) {
            try {
                String[] inputs = reader.readLine().split(" ");
                if (inputs.length != 3) {
                    System.out.println("체력, 공격력, 마법력 순으로 세 개의 값을 입력하세요.");
                    continue;
                }

                int hpPoints = Integer.parseInt(inputs[0]);
                int adPoints = Integer.parseInt(inputs[1]);
                int apPoints = Integer.parseInt(inputs[2]);

                if ((hpPoints + adPoints + apPoints) == point) {
                    this.hp += hpPoints * 3;
                    this.ad += adPoints;
                    this.ap += apPoints;
                    System.out.println("체력: " + this.hp + ", 공격력: " + this.ad + ", 마법력: " + this.ap);
                    break;
                } else {
                    System.out.println("입력한 능력치 총합이 " + point + "와 같아야 합니다. 다시 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("hp, ad, ap는 정수로 입력해야 합니다. 다시 입력해주세요.");
            }
        }
    }

    public void attack(Enemy enemy) {
        enemy.receiveDamage(ad);
    }

    public int getHp() {
        return hp;
    }
}

// Enemy 클래스
class Enemy {
    private int hp;

    public Enemy(int playerCount) {
        this.hp = playerCount * 50;
    }

    public void receiveDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) this.hp = 0;
    }

    public int getHp() {
        return hp;
    }

    public void attack(Player player) {
        Random rand = new Random();
        int damage = rand.nextInt(10) + 1; // 랜덤으로 1~10의 데미지
        System.out.println("적이 플레이어에게 " + damage + "의 데미지를 입혔습니다.");
        // 생략: 플레이어의 체력 감소
    }
}

// Game 클래스
class Game {
    private final List<Player> players = new ArrayList<>();
    private Enemy enemy;
    private final int statusPoint = 13;

    public void setPlayers(int playerCount) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < playerCount; i++) {
            Player player = new Player();
            player.setStatus(statusPoint);
            players.add(player);
        }
    }

    public void setEnemy() {
        this.enemy = new Enemy(players.size());
    }

    public boolean turnCheck() {
        players.removeIf(player -> player.getHp() <= 0);
        return !(players.isEmpty() || enemy.getHp() == 0);
    }

    public Player selectRandomPlayer() {
        Random rand = new Random();
        return players.get(rand.nextInt(players.size()));
    }

    public void startGame() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("플레이어 수를 입력하세요: ");
        int playerCount = Integer.parseInt(reader.readLine());
        setPlayers(playerCount);
        setEnemy();

        while (turnCheck()) {
            for (Player player : players) {
                player.attack(enemy);
                if (enemy.getHp() == 0) {
                    break;
                }
            }

            if (turnCheck()) {
                Player targetPlayer = selectRandomPlayer();
                enemy.attack(targetPlayer);
            } else {
                break;
            }
        }

        if (enemy.getHp() == 0) {
            System.out.println("축하합니다! 승리하셨습니다!");
        } else {
            System.out.println("아쉽지만 패배하셨습니다.");
        }
    }
}

// Main 클래스
public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.startGame();
    }
}