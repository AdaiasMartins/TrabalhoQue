import java.util.Iterator;

public class DequeCity implements Iterable<Cidade>{

    private int n;
    private No Sentinela;

    public DequeCity(){
        n = 0;
        Sentinela =  new No();
        Sentinela.prox = Sentinela;
        Sentinela.ant = Sentinela;
    }

    private class No{
        private Cidade dado;
        private String chave;
        private No prox;
        private No ant;
    }

    public void push_front(String key, Cidade item){
        
        No tmp = new No();
        tmp.dado = item;
        tmp.chave = key;

    }
    @Override
    public Iterator<Cidade> iterator() {
        return null;
    }
}
