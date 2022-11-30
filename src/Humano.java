import java.util.Random;

public class Humano extends Thread {
    private char genero;
    private int tempoMaximo;
    private Monitor monitor;


    public char getGenero() {
        return this.genero;
    }
    public void setGenero(char genero) {
        this.genero = genero;
    }
    public Humano(Monitor monitor, char g, int i){
        this.monitor=monitor;
        this.genero=g;
        this.tempoMaximo=i;
    }
    public Humano(Monitor monitor){
        this.monitor=monitor;
    }
    @Override
    public void run(){
        Random geradorAleatorio = new Random();
        int intAleatorio = geradorAleatorio.nextInt(tempoMaximo);
        try{
            Thread.sleep((intAleatorio));
        }catch (Exception e){
            e.getMessage();
        }
        monitor.humanoOut();
    }
}
