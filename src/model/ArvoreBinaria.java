/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Controlers.IArvoreBinaria;
import java.util.Iterator;

/**
 *
 * @author clayl
 */
public class ArvoreBinaria<T extends Comparable<T>> implements IArvoreBinaria<T> {

    private No<T> raiz;
    private int tamanho;

    public ArvoreBinaria() {
        tamanho = 0;
    }

    @Override
    public void inserir(T elemento) {
        if (this.raiz == null) {
            this.raiz = new No(elemento);
            tamanho++;
        } else {
            inserirAux(raiz, elemento);
        }
    }

    @Override
    public boolean consulta(T elemento) {
        if (elemento == null) {
            return false;
        }

        return consultaAuxiliar(raiz, elemento);
    }

    @Override
    public int getGrauNo(T elemento) {
        int cont = 0;
        No<T> no = buscaAuxiliar(raiz, elemento);
        
        if (no == null) {
            return -1;
        }
        
        if (no.contemFilhoDireito()) {
            cont++;
        }
        if (no.contemFilhoEsquerdo()) {
            cont++;
        }
        return cont;
    }

    @Override
    public int getProfundidadeNo(T elemento) {
        if(elemento == null)return -1;
        No<T> no = buscaAuxiliar(raiz, elemento);
        if(no == null) return -1;
        return profundidadeAuxilar(no);
        
    }

    @Override
    public int getAlturaNo(T elemento) {
        if(elemento == null)return -1;
        No<T> no = buscaAuxiliar(raiz, elemento);
        if(no == null) return -1;
        return alturaAuxiliar(no);
    }

    @Override
    public int getNoNivel(T elemento) {
        return getProfundidadeNo(elemento);    
    }

    @Override
    public int numeroNosRecursivo() {
        if(raiz == null)return 0;
        return numeroNosRecursivoAuxiliar(raiz) + 1;
    }

    @Override
    public void remover(T elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String navegacaoLRN() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String navegacaoNLR() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String navegacaoLNR() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inverterArvore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int tamanhoArvore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean estaVazio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iterador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void imprimeArvore() {
        PrintTree.print(raiz);
    }

    public void inserirAux(No<T> no, T elemento) {
        if (no.getValor().compareTo(elemento) < 0) {
            if (!no.contemFilhoDireito()) {
                no.setDireita(new No(no, elemento));
                tamanho++;
            } else {
                inserirAux(no.getDireita(), elemento);
            }

        } else if (no.getValor().compareTo(elemento) > 0) {
            if (!no.contemFilhoEsquerdo()) {
                no.setEsquerda(new No(no, elemento));
                tamanho++;
            } else {
                inserirAux(no.getEsquerda(), elemento);
            }

        }
    }

    private boolean consultaAuxiliar(No<T> no, T elemento) {
        if (no.getValor().compareTo(elemento) == 0) {
            return true;
        }
        boolean tem = false;
        if (no.contemFilhoEsquerdo()) {
            tem = tem || consultaAuxiliar(no.getEsquerda(), elemento);
        }
        if (no.contemFilhoDireito()) {
            tem = tem || consultaAuxiliar(no.getDireita(), elemento);
        }
        return tem;
    }

    private No<T> buscaAuxiliar(No<T> no, T elemento) {
        if (no.getValor().compareTo(elemento) == 0) {
            return no;
        }
        No<T> noAux = null;
        if (no.contemFilhoEsquerdo()) {
            noAux = buscaAuxiliar(no.getEsquerda(), elemento);
        }
        
        if (no.contemFilhoDireito() && noAux == null) {
            return buscaAuxiliar(no.getDireita(), elemento);
        }
        return noAux;
    }
    
    private int profundidadeAuxilar(No<T> no){
        if(no == raiz){
            return 0;
        }
        return profundidadeAuxilar(no.getPai()) + 1;
    }
    
    private int alturaAuxiliar(No<T> no){
        int noAuxDir = 0;
        int noAuxEsq = 0;
        
        if (no.contemFilhoEsquerdo()) {
            noAuxEsq = alturaAuxiliar(no.getEsquerda()) + 1;
        }
        if (no.contemFilhoDireito()) {
            noAuxDir = alturaAuxiliar(no.getDireita()) + 1;
        }
        if (noAuxDir > noAuxEsq) {
            return noAuxDir;
        } else {
            return noAuxEsq;
        }
    }
    
    private int numeroNosRecursivoAuxiliar(No<T> no){
        int count = 0;
        
        if(no.contemFilhoEsquerdo()){
            count += numeroNosRecursivoAuxiliar(no.getEsquerda()) + 1;
        }
        if(no.contemFilhoDireito()){
            count += numeroNosRecursivoAuxiliar(no.getDireita()) + 1;
        }
        
        return count;
    }
}
