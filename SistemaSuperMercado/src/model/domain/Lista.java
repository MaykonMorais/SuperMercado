package model.domain;

import java.sql.Date;
import java.util.ArrayList;

public class Lista<T>{ // generica pois no caixa eu informo a data, no carrinho eu n tenho este dado
   
    ArrayList<T> item = new ArrayList<T>();

    public void add(T t){
        item.add(t);
    }
    public void remover(int i){
        item.remove(i);
    }
    public Item list(){
        String a = "\nLista de Produtos:\n";
        for(int i=0;i<item.size();++i)
          a = a + i+1+"º - "+item.get(i);
       return a;
    }
    
}