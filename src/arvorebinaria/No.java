/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

/**
 *
 * @author clayl
 */
public class No<T> {
    
    private T valor;
    private No<T> pai;
    private No<T> esquerda;
    private No<T> direita;

/*    public No(T valor, No<T> pai, No<T> esquerda, No<T> direita) {
        this.valor = valor;
        this.pai = pai;
        this.esquerda = null;
        this.direita = null;
    }*/

    
    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getPai() {
        return pai;
    }

    public void setPai(No<T> pai) {
        this.pai = pai;
    }

    public No<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No<T> esquerda) {
        this.esquerda = esquerda;
    }

    public No<T> getDireita() {
        return direita;
    }

    public void setDireita(No<T> direita) {
        this.direita = direita;
    }
    
    
}
