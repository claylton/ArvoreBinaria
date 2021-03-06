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
 * @author clayl
 * @param <T>
 */
public class ArvoreBinaria<T extends Comparable<T>> implements IArvoreBinaria<T>, Iterable<T> {

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
        if (elemento == null) {
            return -1;
        }
        No<T> no = buscaAuxiliar(raiz, elemento);
        if (no == null) {
            return -1;
        }
        return profundidadeAuxilar(no);

    }

    @Override
    public int getAlturaNo(T elemento) {
        if (elemento == null) {
            return -1;
        }
        No<T> no = buscaAuxiliar(raiz, elemento);
        if (no == null) {
            return -1;
        }
        return alturaAuxiliar(no);
    }

    @Override
    public int getNoNivel(T elemento) {
        return getProfundidadeNo(elemento);
    }

    @Override
    public int numeroNosRecursivo() {
        if (raiz == null) {
            return 0;
        }
        return numeroNosRecursivoAuxiliar(raiz) + 1;
    }

    @Override
    public void remover(T elemento) {
        if (elemento == null) {
            return;
        }
        No<T> no = buscaAuxiliar(raiz, elemento);
        if (no == null) {
            return;
        }
        if (!no.contemFilhoDireito() && !no.contemFilhoEsquerdo()) {
            removerFolha(no);
        } else if (no.contemFilhoDireito() ^ no.contemFilhoEsquerdo()) {
            removerUmFilho(no);
        } else {
            removerDoisFilhos(no);
        }
    }

    @Override
    public String navegacaoLRN() {
        return auxLRN(raiz);
    }

    @Override
    public String navegacaoNLR() {
        return auxNLR(raiz);
    }

    @Override
    public String navegacaoLNR() {
        return auxLNR(raiz);
    }

    @Override
    public void inverterArvore() {
        if (raiz != null) {
            inverterArvoreAux(raiz);
        }
    }

    @Override
    public int tamanhoArvore() {
        return tamanho;
    }

    @Override
    public boolean estaVazio() {
        return raiz == null;
    }

    @Override
    public Iterator<T> iterator() {
        ArrayList<T> lista = new ArrayList();
        arrayListArvore(lista, raiz);
        return new ArvoreBinariaIterator(lista);
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

    private int profundidadeAuxilar(No<T> no) {
        if (no == raiz) {
            return 0;
        }
        return profundidadeAuxilar(no.getPai()) + 1;
    }

    private int alturaAuxiliar(No<T> no) {
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

    private int numeroNosRecursivoAuxiliar(No<T> no) {
        int count = 0;

        if (no.contemFilhoEsquerdo()) {
            count += numeroNosRecursivoAuxiliar(no.getEsquerda()) + 1;
        }
        if (no.contemFilhoDireito()) {
            count += numeroNosRecursivoAuxiliar(no.getDireita()) + 1;
        }

        return count;
    }

    private String auxLRN(No<T> no) {
        String elementos = "";
        if (no.contemFilhoEsquerdo()) {
            elementos += auxLRN(no.getEsquerda());
        }
        if (no.contemFilhoDireito()) {
            elementos += auxLRN(no.getDireita());
        }
        elementos += no.getValor() + ", ";
        return elementos;
    }

    private String auxNLR(No<T> no) {
        String elementos = "";

        elementos += no.getValor() + ", ";

        if (no.contemFilhoEsquerdo()) {
            elementos += auxNLR(no.getEsquerda());
        }
        if (no.contemFilhoDireito()) {
            elementos += auxNLR(no.getDireita());
        }
        return elementos;
    }

    private String auxLNR(No<T> no) {
        String elementos = "";
        if (no.contemFilhoEsquerdo()) {
            elementos += auxLNR(no.getEsquerda());
        }

        elementos += no.getValor() + ", ";

        if (no.contemFilhoDireito()) {
            elementos += auxLNR(no.getDireita());
        }
        return elementos;
    }

    private void removerFolha(No<T> no) {
        No pai = no.getPai();
        if (pai.contemFilhoDireito()) {
            if (pai.getDireita() == no) {
                pai.setDireita(null);
            }
        } else if (pai.contemFilhoEsquerdo()) {
            if (pai.getEsquerda() == no) {
                pai.setEsquerda(null);
            }
        }

    }

    private void removerUmFilho(No<T> no) {
        No pai = no.getPai();
        if (pai.contemFilhoDireito()) {
            if (pai.getDireita() == no) {
                if (no.contemFilhoDireito()) {
                    pai.setDireita(no.getDireita());
                } else {
                    pai.setDireita(no.getEsquerda());
                }
            } else if (pai.contemFilhoEsquerdo()) {
                if (pai.getEsquerda() == no) {
                    if (no.contemFilhoEsquerdo()) {
                        pai.setEsquerda(no.getEsquerda());
                    } else {
                        pai.setEsquerda(no.getDireita());
                    }
                }
            }
        }
    }

    private void removerDoisFilhos(No<T> no) {
        No<T> subEsquerda = no.getEsquerda();
        No<T> maior = maiorNo(subEsquerda);
        no.setValor(maior.getValor());
        removerUmFilho(maior);
    }

    private No<T> maiorNo(No<T> no) {
        if (no.contemFilhoDireito()) {
            return maiorNo(no.getDireita());
        }
        return no;
    }

    private void inverteFilho(No<T> no) {
        No<T> noAux;

        if (no.contemFilhoDireito()) {
            noAux = no.getDireita();
            no.setDireita(no.getEsquerda());
            no.setEsquerda(noAux);

        } else if (no.contemFilhoEsquerdo()) {
            noAux = no.getEsquerda();
            no.setEsquerda(no.getDireita());
            no.setDireita(noAux);
        }
    }

    private void inverterArvoreAux(No<T> no) {

        inverteFilho(no);
        
        if (no.contemFilhoEsquerdo()) {
            inverterArvoreAux(no.getEsquerda());
        }
        if (no.contemFilhoDireito()) {
            inverterArvoreAux(no.getDireita());
        }
    }
        
    private void arrayListArvore(ArrayList<T> array, No<T> no){
        if(no.contemFilhoEsquerdo()){
            arrayListArvore(array, no.getEsquerda());
        }
        if(no.contemFilhoDireito()){
            arrayListArvore(array, no.getDireita());
        }
        array.add(no.getValor());
    }
    
    public double media(){
        return mediaAux(raiz, true);
    }
    
    public double mediaAux(No<T> sub, boolean taNoPrimeiro){
	if(sub == null){
		return 0;
        }
	
	double esq = mediaAux(sub.getEsquerda(), false);
	double dir = mediaAux(sub.getDireita(), false);
	
        if(taNoPrimeiro){
            return (esq + dir + ((Integer)sub.getValor()))/tamanho;
        }
	return esq + dir + ((Integer)sub.getValor());
    }
    

    
    public int somaPar(){
        return somaParAux(raiz);
    }
    
    public int somaParAux(No sub){
	if(sub == null){
		return 0;
	}
        int valor = 0;
	if(((Integer)sub.getValor()) % 2 == 0){
            valor = ((Integer)sub.getValor());
        }
	int esq = somaParAux(sub.getEsquerda());
	int dir = somaParAux(sub.getDireita());
	
	return esq + dir + valor;

    }
    public No<T> getRaiz(){
        return this.raiz;
    }
    public boolean similar(ArvoreBinaria<T> a2){
        return similarAux(this.raiz, a2.getRaiz());
    }
    public boolean similarAux(No sub1, No sub2){
        if(sub1 == null && sub2 == null){
            return true;
        }else if ((sub1 == null || sub2 == null)){
            return false;
        }
        boolean esq = similarAux(sub1.getEsquerda(), sub2.getEsquerda());
        boolean dir = similarAux(sub1.getDireita(), sub2.getDireita());
        if(esq && dir){
            return true;
        }
        return false;
    }
    
    public T getMenor(){
        return menorNo(raiz).getValor();
    }
    private No<T> menorNo(No<T> no) {
        if (no.contemFilhoEsquerdo()) {
            return menorNo(no.getEsquerda());
        }
        return no;
    }
    
    
}
