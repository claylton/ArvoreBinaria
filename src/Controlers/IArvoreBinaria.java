/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import java.util.Iterator;
import model.No;
import model.No;

/**
 *
 * @author clayl
 * @param <T>
 */
public interface IArvoreBinaria<T> {

public void inserir(T elemento);

public boolean consulta(T elemento);

public int getGrauNo(T elemento);

public int getProfundidadeNo(T elemento);

public int getAlturaNo(T elemento);

public int getNoNivel(T elemento);

public int numeroNosRecursivo();

public void remover(T elemento);

public String navegacaoLRN();
public String navegacaoNLR();
public String navegacaoLNR();

public void inverterArvore();

public int tamanhoArvore();

public boolean estaVazio();

// Retorna um interador sobre os elementos armazenados da arvore
public Iterator<T> iterator();

public void imprimeArvore();

}
