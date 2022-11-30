import java.lang.Thread;
public class BanheiroThread extends Thread {
    Banheiro banheiro;
    int tipo;


    BanheiroThread(Banheiro banheiro, int tipo){
        this.banheiro = banheiro;
        this.tipo=tipo;
    }
    @Override
    public void run(){
        if(tipo==1){
            while(true){
                this.banheiro.proximaPessoa();
            }
        }else if(tipo==2){
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
