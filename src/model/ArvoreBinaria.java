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
         if(elemento == null)return false;
         
         return consultaAuxiliar(raiz, elemento);
    }

    @Override
    public int getGrauNo(No<T> node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getProfundidadeNo(No<T> node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAlturaNo(No<T> node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNoNivel(No<T> node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numeroNosRecursivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public  void inserirAux(No<T> no, T elemento) {
                if(no.getValor().compareTo(elemento) < 0){
            if(!no.contemFilhoDireito()){
                no.setDireita(new No(no, elemento));
                tamanho++;
            }else{
                inserirAux(no.getDireita(), elemento);
            }
            
            
        }else if(no.getValor().compareTo(elemento) > 0){
            if(!no.contemFilhoEsquerdo()){
                no.setEsquerda(new No(no, elemento));
                tamanho++;
            }else{
                inserirAux(no.getEsquerda(), elemento);
            }
            
        }
    }
    
    private boolean consultaAuxiliar(No<T> no, T elemento){
        if(no.getValor().compareTo(elemento) == 0){
            return true;
        }
        boolean tem = false;
        if(no.contemFilhoEsquerdo()){
            tem = tem || consultaAuxiliar(no.getEsquerda(), elemento);
        }
        if(no.contemFilhoDireito()){
            tem = tem || consultaAuxiliar(no.getDireita(), elemento);
        }
        return tem;
    }
}
