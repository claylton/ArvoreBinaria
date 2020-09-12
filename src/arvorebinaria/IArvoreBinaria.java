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

public void inserir(T elemento);

public 

public int tamanhoArvore();

public boolean estaVazio();

// Retorna um interador sobre os elementos armazenados da arvore
public Iterator<T> iterador();

public void remover(T elemento);

public String caminhoLRN();
public String caminhoNLR();
public String caminhoLNR();

public void inverterArvore();

public boolean removerElemento(T elemento);

public int getGrauNo(No<T> node);

public int getProfundidadeNo(No<T> node);
 
public int getAlturaNo(No<T> node);

public int getNoNivel(No<T> node);

public int tamanhoRecursivo();

public void imprimeArvore();

}
