import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int banheiroCapacidade;
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a capacidade do banheiro");
        banheiroCapacidade=s.nextInt();

        Banheiro b = new Banheiro(banheiroCapacidade,'F');
        Monitor m =new Monitor(b);
        m.start();

        while(true){
            continue;
        }

    }
}