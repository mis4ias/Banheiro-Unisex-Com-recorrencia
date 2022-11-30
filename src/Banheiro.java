import java.util.ArrayList;

public class Banheiro {
    BanheiroThread proximoHumano;
    BanheiroThread trocarGenero;
    private int capacidade;
    private int ocupacao;
    private char generoAtual;
    private boolean generoAlterado;

    private ArrayList<Humano> filaHomem;
    private ArrayList<Humano> filaMulher;

    public Banheiro(int banheiroCapacidade, char g) {
        this.capacidade=banheiroCapacidade;
        this.generoAtual=g;
        this.ocupacao=0;
        this.generoAlterado=false;
        this.filaHomem=new ArrayList<Humano>(100);
        this.filaMulher=new ArrayList<Humano>(100);

        this.proximoHumano=new BanheiroThread(this,1);
        this.trocarGenero= new BanheiroThread(this,2);

        this.proximoHumano.start();
        this.trocarGenero.start();

    }


    public synchronized void proximaPessoa() {
        if (generoAlterado){
            while(this.generoAlterado && this.ocupacao !=0){
                continue;
            }
            this.generoAlterado=false;
        }
        if(this.capacidade > this.ocupacao && this.generoAtual == 'M'){
            if(this.filaHomem.size()==0){
                return;
            }
            Humano h =this.filaHomem.get(0);
            this.filaHomem.remove(0);
            h.start();
            this.ocupacao++;
            System.out.println("Uma pessoa entrou no banheiro Genero: "+h.getGenero());
        }
        if(this.capacidade > this.ocupacao && this.generoAtual == 'F'){
            if(this.filaMulher.size()==0){
                return;
            }
            Humano h =this.filaMulher.get(0);
            this.filaMulher.remove(0);
            h.start();
            this.ocupacao++;
            System.out.println("Uma pessoa entrou no banheiro Genero: "+h.getGenero());
        }
    }
    public void addHumano(Humano h){
        if(h.getGenero() == 'M'){
            this.filaHomem.add(h);
        } else if (h.getGenero() == 'F') {
            this.filaMulher.add(h);
        }
    }
    public void trocarGeneroAtual() {
        if(this.generoAtual=='M'){
            this.generoAtual='F';
            this.generoAlterado = true;
        }else{
            this.generoAtual='M';
            this.generoAlterado=true;
        }
    }

    public char getGeneroAtual() {
        return this.generoAtual;
    }
    public synchronized void trocarOcupacao(int valor){

        this.ocupacao = this.ocupacao +valor;
    }
}
