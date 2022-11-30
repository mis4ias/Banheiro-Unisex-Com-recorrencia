import java.util.Random;
import java.lang.Thread;
public class Monitor extends Thread{
    Banheiro banheiro;

    public Monitor(Banheiro banheiro){
        this.banheiro=banheiro;
    }
    public void criarHumano(){
        Humano h;
        Random geradorAleatorio = new Random();
        int intAleatorio = geradorAleatorio.nextInt(10);

        if (intAleatorio<5){
            h = new Humano(this,'M',1000);
        }else {
            h= new Humano(this,'F',1000);
        }

        this.banheiro.addHumano(h);
        System.out.println("Uma pessoa entrou na fila, Genero: "+ h.getGenero());
    }
    public synchronized void humanoOut() {
        this.banheiro.trocarOcupacao(-1);
        System.out.println("Uma pessoa saiu do banheiro, Genero: "+this.banheiro.getGeneroAtual());
    }
    @Override
    public void run(){
        while(true){
            Random geradorAleatorio = new Random();
            int intAleatorio = geradorAleatorio.nextInt(5000);
            try{
                Thread.sleep(intAleatorio);
                this.criarHumano();
            }
            catch (Exception e){
                e.getMessage();
            }
        }
    }

}
