/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

import java.util.Iterator;

/**
 *
 * @author clayl
 * @param <T>
 */
public interface IArvoreBinaria<T> {
    // Retorna a quantidade de nós da árvore
public int size();

//retorna se a árvore está vazia
public boolean isEmpty();

// Retorna um interador sobre os elementos armazenados da arvore
public Iterator<T> iterator();

//insere um element na arvore
public void insert(T element);

//remove um element da arvore
public void remove(T element);

//navegar na arvore(print)
public String navigateLRN();
public String navigateNLR();
public String navigateLNR();

//inverter arvore
public void invertTree();

//pesquisa um elemento na arvore
public boolean contains(T element);

//grau de um nó
public int getNodeDegree(No<T> node);

//profundidade de um nó
public int getNodeDepth(No<T> node);

//altura de um nó 
public int getNodeHeight(No<T> node);

//nivel de um nó
public int getNodeLevel(No<T> node);

//numero de nós recursivo
public int recursiveSize();

//printa a arvore
public void print();


}
