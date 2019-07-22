package model.domain;

public class Carrinho {
    Lista<Item> li = new Lista<Item>();
    public void adicionar(Item i){
        li.add(i);
    }
    public void remove(int i){
        li.remover(i);
    }
    public void listaItem(){
        li.list();
    }
}