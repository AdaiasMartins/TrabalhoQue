import java.util.Iterator;
import java.util.ListIterator;

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

    public void push_back(String key, Cidade item){
        No tmp = new No();
        tmp.dado = item;
        tmp.chave = key;

        tmp.ant = Sentinela;
        tmp.prox = Sentinela.prox;

        Sentinela.prox = tmp;
        tmp.prox.ant = tmp;
        ++n;
    }

    public boolean contains(String key){
        if(key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Cidade get(String key){
        if(key == null) throw new IllegalArgumentException("argument to get() is null");
        for(No x = Sentinela.prox; x != Sentinela; x = x.prox){
            if(key.equals(x.chave))
                return x.dado;
        }
        return null;
    }

    public void delete(String key){
        if(key == null) throw new IllegalArgumentException("argument to delete() is null");
        delete(Sentinela.prox, key);
    }

    public void remove(No tmp){
        tmp.ant.prox = tmp.prox;
        tmp.prox.ant = tmp.ant;
        --n;
    }

    public void delete(No x, String key){
        if(x == Sentinela) return;
        if(key.equals(x.chave)){
            remove(x);
            return;
        }
        delete(x.prox, key);
    }

    public void put(String key, Cidade val){
        if(key == null) throw new IllegalArgumentException("first argument to put() is null");
        if(val == null){
            delete(key);
            return;
        }
        for(No x = Sentinela.prox; x!=Sentinela; x = x.prox){
            if(key.equals(x.chave)){
                x.dado = val;
                return;
            }
        }
        push_front(key, val);
    }

    public Cidade pop_front(){
        No tmp = Sentinela.prox;
        Cidade meuDado = tmp.dado;
        tmp.ant.prox = tmp.prox;
        tmp.prox.ant = tmp.ant;
        --n;
        return meuDado;
    }

    public No first(){
        if(Sentinela == Sentinela.prox) return null;
        return Sentinela.prox;
    }

    public boolean isEmpty(){return n==0;}
    public int size(){return n;}
    public ListIterator<Cidade> iterator(){
        return new DequeIterator;
    }

    public class DequeIterator implements ListIterator<Cidade>{
        private No atual = Sentinela.prox;
        private int indice = 0;
        private No acessadoUltimo = null;

        public boolean hasNext(){return indice < (n);}
        public boolean hasPrevious(){return indice > 0;};
        public int previousIndex(){ return indice - 1;}
        public int nextIndex(){ return indice; }
    }
}
