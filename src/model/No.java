/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author clayl
 */
public class No<T> {
    
    private T valor;
    private No<T> pai;
    private No<T> esquerda;
    private No<T> direita;
    private String cor;

    public No(T valor) {
        this.valor = valor;
        this.cor = "VERMELHO";
    }

    public No(No<T> pai,T valor) {
        this.valor = valor;
        this.pai = pai;
        this.cor = "VERMELHO";
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    
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
    
    public boolean contemFilhoDireito(){
        return direita != null;
    }
    
    public boolean contemFilhoEsquerdo(){
        return esquerda != null;
    }
    
    public boolean contemFilhos(){
        return contemFilhoDireito() || contemFilhoEsquerdo();
    }
    
    public boolean contemUmFilho(){
        return contemFilhoDireito() ^ contemFilhoEsquerdo();
    }
    
    public boolean contemFilhoDeCor(String cor){
        if(contemFilhoEsquerdo() && esquerda.getCor().equals(cor)){
            return true;
        }
        if(contemFilhoDireito() && direita.getCor().equals(cor)){
            return true;
        }
        return false;
    }
    
    public boolean contemPai(){
        return pai != null;
    }
    
    public boolean éFilhoDireito(){
        if(contemPai()){
            No<T> pai = getPai();
            return pai.getDireita() == this;
        }
        return false;
    }
     public boolean éFilhoEsquerdo(){
        if(contemPai()){
            No<T> pai = getPai();
            return pai.getEsquerda() == this;
        }
        return false;
    }
    
    public No<T> getIrmao(){
        if(pai == null)return null;
        
        if(éFilhoEsquerdo()){
            return  pai.getDireita();
        }
        return pai.getEsquerda();
    }
    
    public boolean contemIrmao(){
        return getIrmao() != null;
    }
    
    public No<T> getTio() {
        if(contemPai()){
            No<T> pai = getPai();
            if(pai.contemPai()){
                No<T> avo = pai.getPai();
                if(pai.éFilhoDireito()){
                    return avo.getEsquerda();
                }else{
                    return avo.getDireita();
                }
            }
        }
        return null;
    }
    
    public void inverterCor(){
        if(pai == null)return;
        
        if(cor.equals("VERMELHO")){
            cor = "PRETO";
        }else{
            cor = "VERMELHO";
        }
    }

    @Override
    public String toString() {
        return "No{" + "valor=" + valor  + ", cor=" + cor + '}';
    }
    
}
