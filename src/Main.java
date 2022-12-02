import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int banheiroCapacidade;
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a capacidade do banheiro");
        banheiroCapacidade=s.nextInt();


        Banheiro banheiro = new Banheiro(banheiroCapacidade,'F');
        Monitor monitor =new Monitor(banheiro);
        monitor.start();

        while(true){
            continue;
        }

    }
}