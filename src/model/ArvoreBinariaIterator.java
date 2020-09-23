/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jonatas
 * @param <T>
 */
public class ArvoreBinariaIterator <T extends Comparable<T>> implements Iterator<T> {

    final private ArrayList<T> array;
    private int posicao;
    public ArvoreBinariaIterator(ArrayList<T> array){
        this.array = array;
        this.posicao = 0;
    }
    
    @Override
    public boolean hasNext() {
        return this.posicao < this.array.size();
    }

    @Override
    public T next() {
        return this.array.get(posicao++);
    }
    
}
