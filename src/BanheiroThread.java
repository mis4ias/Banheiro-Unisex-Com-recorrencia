import java.lang.Thread;
public class BanheiroThread extends Thread {
    Banheiro banheiro;
    Boolean tipo;


    BanheiroThread(Banheiro banheiro, boolean tipo){
        this.banheiro = banheiro;
        this.tipo=tipo;
    }
    @Override
    public void run(){
        if(tipo==true){
            while(true){
                this.banheiro.proximaPessoa();
            }
        }else if(tipo==false){
            while(true){
                try{
                    Thread.sleep(5000);
                }
                catch(Exception e){
                    e.getMessage();
                }
                this.banheiro.trocarGeneroAtual();
            }
        }
        else{

        }
    }
}
