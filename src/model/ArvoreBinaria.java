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
            this.raiz.setCor("PRETO");
            tamanho++;
        } else {
            No<T> inserido = inserirAux(raiz, elemento);
            System.out.println(inserido.toString());
            if (tamanho == 2) {
                inserido.setCor("PRETO");
            }
            if (inserido.contemPai()) {
                if (inserido.getPai().getCor().equals("VERMELHO")) {
                    balancear(inserido);
                }
            }
            tamanho++;
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
        delete(no);
        /*
        if (no == null) {
            return;
        }
        No<T> irmao;
        if (no.éFilhoDireito()) {
            irmao = no.getPai().getEsquerda();
        } else {
            irmao = no.getPai().getDireita();
        }
        String noCor = no.getCor();
        No<T> sucessor = null;
        if (no.contemFilhoDireito()) {
            sucessor = menorNo(no.getDireita());
        }

        String sucessorCor = "PRETO";
        if (sucessor != null) {
            sucessorCor = sucessor.getCor();
        }

        removerAux(no);

        if (noCor.equals("PRETO") && sucessorCor.equals("PRETO")) {
            removerPretoPreto(irmao);
        } else if (noCor.equals("PRETO") && sucessorCor.equals("VERMELHO")) {
            no.setCor("PRETO");
        } else if (noCor.equals("VERMELHO") && sucessorCor.equals("PRETO")) {
            System.out.println("vermelho preto");
        }
        */
    }

    private void removerPretoPreto(No<T> no) {
        if (no == null) {
            return;
        }

        if (no.getCor().equals("PRETO")) {

        }
    }

    private void removerAux(No<T> no) {

        if (!no.contemFilhoDireito() && !no.contemFilhoEsquerdo()) {
            removerFolha(no);
        } else if (no.contemFilhoDireito() ^ no.contemFilhoEsquerdo()) {
            removerUmFilho(no);
        } else {
            String corNo = no.getCor();

            String corSucessor = removerDoisFilhos(no);

        }
    }

    @Override
    public String navegacaoLRN() {
        return "<html>" + auxLRN(raiz) + "</html>";
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
    public String imprimeArvore() {

        String s = "<html>" + PrintTree.print(raiz);
        s = colorir(s, raiz);
        return s + "</html>";
    }

    private String colorir(String s, No<T> atual) {
        if (atual == null) {
            return s;
        }
        if (atual.getCor().equals("PRETO")) {
            s = s.replaceAll("&nbsp;" + atual.getValor().toString() + "&nbsp;", "<font color=\"black\">&nbsp;" + atual.getValor().toString() + "&nbsp;</font>");
        } else {
            s = s.replaceAll("&nbsp;" + atual.getValor().toString() + "&nbsp;", "<font color=\"red\">&nbsp;" + atual.getValor().toString() + "&nbsp;</font>");
        }
        String ss = colorir(s, atual.getEsquerda());
        return colorir(ss, atual.getDireita());
    }

    public No<T> inserirAux(No<T> no, T elemento) {
        if (no.getValor().compareTo(elemento) < 0) {
            if (!no.contemFilhoDireito()) {
                No<T> temp = new No(no, elemento);
                no.setDireita(temp);
                tamanho++;
                return temp;
            } else {
                return inserirAux(no.getDireita(), elemento);
            }

        } else if (no.getValor().compareTo(elemento) > 0) {
            if (!no.contemFilhoEsquerdo()) {
                No<T> temp = new No(no, elemento);
                no.setEsquerda(temp);
                tamanho++;
                return temp;
            } else {
                return inserirAux(no.getEsquerda(), elemento);
            }

        }
        return null;
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
        if (no.getCor().equals("PRETO")) {
            elementos += "<font color=\"black\"> " + no.getValor() + " </font>,";
        } else {
            elementos += "<font color=\"red\"> " + no.getValor() + " </font>,";
        }

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

    private String removerDoisFilhos(No<T> no) {
        No<T> subDireita = no.getDireita();
        No<T> maior = menorNo(subDireita);
        no.setValor(maior.getValor());
        removerUmFilho(maior);

        return maior.getCor();
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

    private void arrayListArvore(ArrayList<T> array, No<T> no) {
        if (no.contemFilhoEsquerdo()) {
            arrayListArvore(array, no.getEsquerda());
        }
        if (no.contemFilhoDireito()) {
            arrayListArvore(array, no.getDireita());
        }
        array.add(no.getValor());
    }

    public double media() {
        return mediaAux(raiz, true);
    }

    public double mediaAux(No<T> sub, boolean taNoPrimeiro) {
        if (sub == null) {
            return 0;
        }

        double esq = mediaAux(sub.getEsquerda(), false);
        double dir = mediaAux(sub.getDireita(), false);

        if (taNoPrimeiro) {
            return (esq + dir + ((Integer) sub.getValor())) / tamanho;
        }
        return esq + dir + ((Integer) sub.getValor());
    }

    public int somaPar() {
        return somaParAux(raiz);
    }

    public int somaParAux(No sub) {
        if (sub == null) {
            return 0;
        }
        int valor = 0;
        if (((Integer) sub.getValor()) % 2 == 0) {
            valor = ((Integer) sub.getValor());
        }
        int esq = somaParAux(sub.getEsquerda());
        int dir = somaParAux(sub.getDireita());

        return esq + dir + valor;

    }

    public No<T> getRaiz() {
        return this.raiz;
    }

    public boolean similar(ArvoreBinaria<T> a2) {
        return similarAux(this.raiz, a2.getRaiz());
    }

    public boolean similarAux(No sub1, No sub2) {
        if (sub1 == null && sub2 == null) {
            return true;
        } else if ((sub1 == null || sub2 == null)) {
            return false;
        }
        boolean esq = similarAux(sub1.getEsquerda(), sub2.getEsquerda());
        boolean dir = similarAux(sub1.getDireita(), sub2.getDireita());
        if (esq && dir) {
            return true;
        }
        return false;
    }

    public T getMenor() {
        return menorNo(raiz).getValor();
    }

    private No<T> menorNo(No<T> no) {
        if(no == null)return null;
        if (no.contemFilhoEsquerdo()) {
            return menorNo(no.getEsquerda());
        }
        return no;
    }

    private void balancear(No<T> noAtual) {

        No<T> tio = noAtual.getTio();
        if (tio == null || tio.getCor().equals("PRETO")) {

            if (noAtual.éFilhoDireito() && noAtual.getPai().éFilhoDireito()) {
                simplesEsquerda(noAtual);

            } else if (noAtual.éFilhoEsquerdo() && noAtual.getPai().éFilhoEsquerdo()) {
                simplesDireita(noAtual);

            } else if (noAtual.éFilhoEsquerdo() && noAtual.getPai().éFilhoDireito()) {

                duplaEsquerda(noAtual);
            } else {
                duplaDireita(noAtual);

            }

        } else {

            inverterCores(noAtual);
        }
    }

    private void simplesEsquerda(No<T> noAtual) {

        No<T> pai = noAtual.getPai();
        No<T> filhoPai = pai.getEsquerda();
        No<T> avo = pai.getPai();
        No<T> tataravo = avo.getPai();
        if (tataravo != null) {
            if (avo.éFilhoDireito()) {
                tataravo.setDireita(pai);
            } else {
                tataravo.setEsquerda(pai);
            }
            pai.inverterCor();
        } else {
            raiz = pai;
            pai.setCor("PRETO");
        }

        avo.setPai(pai);
        pai.setPai(tataravo);
        pai.setEsquerda(avo);
        avo.setDireita(filhoPai);

        avo.inverterCor();
    }

    private void simplesDireita(No<T> noAtual) {

        No<T> pai = noAtual.getPai();
        No<T> filhoPai = pai.getDireita();
        No<T> avo = pai.getPai();
        No<T> tataravo = avo.getPai();
        if (tataravo != null) {
            if (avo.éFilhoDireito()) {
                tataravo.setDireita(pai);
            } else {
                tataravo.setEsquerda(pai);
            }
            pai.inverterCor();
        } else {
            raiz = pai;
            pai.setCor("PRETO");
        }

        avo.setPai(pai);
        pai.setPai(tataravo);
        pai.setDireita(avo);
        avo.setEsquerda(filhoPai);

        avo.inverterCor();
    }

    private void duplaEsquerda(No<T> noAtual) {

        No<T> pai = noAtual.getPai();
        No<T> filhoDireito = noAtual.getDireita();
        No<T> avo = pai.getPai();
        avo.setDireita(noAtual);
        pai.setEsquerda(filhoDireito);
        noAtual.setDireita(pai);
        noAtual.setPai(avo);

        if (filhoDireito != null) {
            filhoDireito.setPai(pai);
        }

        pai.setPai(noAtual);
        simplesEsquerda(pai);

    }

    private void duplaDireita(No<T> noAtual) {
        No<T> pai = noAtual.getPai();
        No<T> filhoEsquerdo = noAtual.getEsquerda();
        No<T> avo = pai.getPai();
        avo.setEsquerda(noAtual);
        pai.setDireita(filhoEsquerdo);
        noAtual.setEsquerda(pai);
        noAtual.setPai(avo);

        if (filhoEsquerdo != null) {
            filhoEsquerdo.setPai(pai);
        }

        pai.setPai(noAtual);
        simplesDireita(pai);
    }

    private void inverterCores(No<T> no) {
        if (no.contemPai()) {
            No<T> pai = no.getPai();

            pai.inverterCor();

            if (pai.contemPai()) {
                pai.getPai().inverterCor();
            }
            no.getTio().inverterCor();
        }
    }
    
    private void rotacaoEsquerda(No<T> x){
        if(x == null)return;
        
        No<T> y = x.getDireita();
        
        x.setDireita(y.getEsquerda());
        
        if(y.contemFilhoEsquerdo()){
            y.getEsquerda().setPai(x);
        }
        
        y.setPai(x.getPai());
        
        if(x.contemPai()){
            if(x.éFilhoEsquerdo()){
                x.getPai().setEsquerda(y);
            }else{
                x.getPai().setDireita(y);
            }
        }else{
            raiz = y;
        }
        y.setEsquerda(x);
        x.setPai(y);
    }
    
    private void rotacaoDireita(No<T> y){
        if(y == null)return;
        
        No<T> x = y.getEsquerda();
        
        y.setEsquerda(x.getDireita());
        
        if(x.contemFilhoDireito()){
            x.getDireita().setPai(y);
        }
        
        x.setPai(y.getPai());
        
        if(y.contemPai()){
            if(y.éFilhoEsquerdo()){
                y.getPai().setEsquerda(x);
            }else{
                y.getPai().setDireita(x);
            }
        }else{
            raiz = x;
        }
        x.setDireita(y);
        y.setPai(x);
    }

////////////////////////
    private void delete(No<T> v) {

        No<T> u = menorNo(v.getDireita());//sucessor

        No<T> pai = v.getPai();

        if (u == null) {
            // SE U FOR NULL ENTAO V É FOLHA
            if (v == raiz) {
                // SE V FOR RAIZ ENTAO SÓ SETA NULL
                raiz = v.getEsquerda();
                raiz.setPai(null);
                raiz.setCor("PRETO");
            } else {
                if (v.getCor().equals("PRETO")) {
                    // SE V E U FOREM PRETO
                    // COMO V É FOLHA SÓ FAZ A ROTAÇÃO DO PRETO PRETO (DUPLO PRETO)

                    duploPreto(v);
                } else {
                    //SE NÃO, U OU V É VERMELHO
                    if (v.contemIrmao()) {
                        //SE TIVER IRMAO FAZ ELE SER VERMELHO
                        v.getIrmao().setCor("VERMELHO");
                    }
                }
                //DELETA O V
                if (v.éFilhoEsquerdo()) {
                    pai.setEsquerda(null);
                } else {
                    pai.setDireita(null);
                }
            }
            return;
        }

        boolean pretoPreto = v.getCor().equals("PRETO") && u.getCor().equals("PRETO");

        if (v.contemUmFilho()) {
            //V POSSUI SOMENTE UM FILHO
            if (v == raiz) {
                //SE FOR RAIZ, SETA O VALOR DE U PARA V E DELETA O U
                v.setValor(u.getValor());
                v.setEsquerda(u.getEsquerda());
                v.setDireita(u.getDireita());
                delete(u);

            } else {
                //REMOVE O V,  SETANDO O U NO PAI DE V
                if (v.éFilhoEsquerdo()) {
                    pai.setEsquerda(u);
                } else {
                    pai.setDireita(u);
                }
                u.setPai(pai);
                if (pretoPreto) {
                    //ROTAÇÃO DO PRETO PRETO (DUPLO PRETO)
                    duploPreto(u);
                } else {
                    // TER UM VERMELHO PELO MENOS, SETA U DE PRETO
                    u.setCor("PRETO");
                }
            }
            return;
        }
        // SE CHEGAR AQUI QUER DIZER QUE V TEM DOIS FILHOS. TROCA O VALOR E CHAMA O REMOVER DE NOVO
        this.removerDoisFilhos(v);
        delete(u);

    }

    private void duploPreto(No<T> x) {
        //SE FOR RAIZ NÃO PRECISA FAZER ND
        if (x == raiz) {
            return;
        }

        No<T> irmao = x.getIrmao();
        No<T> pai = x.getPai();
        //SE X NAO TIVER IRMAO
        if (irmao == null) {
            //CHAMA DE NOVO PASSANDO O PAI
            duploPreto(pai);
        } else {
            //SE O IRMAO DE X FOR VEMELHO
            if (irmao.getCor().equals("VERMELHO")) {
                //MUDA A COR DO PAI E DO IRMAO DE X
                pai.setCor("VERMELHO");
                irmao.setCor("PRETO");
                //FAZ A ROTACAO SIMPLES DEPEDENDO DO LADO QUE X ESTÁ
                if (irmao.éFilhoEsquerdo()) {
                    rotacaoDireita(pai);
                } else {
                    rotacaoEsquerda(pai);
                }
                duploPreto(x);
            } else {
                if (irmao.contemFilhoDeCor("VERMELHO")) {
                    // SE O IRMAO TIVER PELO MENOS UM FILHO VERMELHO -> OBS: CASO TIVER DOIS FILHOS VERMELHO SÓ O PRIMEIRO IF SERA EXECUTADO
                    if (irmao.contemFilhoEsquerdo() && irmao.getEsquerda().getCor().equals("VERMELHO")) {
                        // SE O FILHO VERMELHO FOR O FILHO DA ESQUERDA
                        if (irmao.éFilhoEsquerdo()) {
                            //-> ESQUERDA ESQUERDA
                            irmao.getEsquerda().setCor(irmao.getCor());
                            irmao.setCor(pai.getCor());
                            rotacaoDireita(pai);
                        } else {
                            // -> DIREITA ESQUERDA
                            irmao.getEsquerda().setCor(pai.getCor());
                            rotacaoDireita(irmao);
                            rotacaoEsquerda(pai);
                        }
                    } else {
                        //SE O FILHO VERMELHO FOR O FILHO DA DIREITA
                        if (irmao.éFilhoEsquerdo()) {
                            // -> ESQUERDA DIREITA
                            irmao.getDireita().setCor(pai.getCor());
                            rotacaoEsquerda(irmao);
                            rotacaoDireita(pai);
                        } else {
                            // -> DIREITA DIREITA
                            irmao.getDireita().setCor(irmao.getCor());
                            irmao.setCor(pai.getCor());
                            rotacaoEsquerda(pai);
                        }
                    }
                    //MUDA A COR DO PAI PRA PRETO
                    pai.setCor("PRETO");
                } else {
                    // SE NAO, TEM DOIS FILHOS PRETOS.
                    irmao.setCor("VERMELHO");
                    //MUDA A COR DO IRMAO PARA PRETO
                    if (pai.getCor().equals("PRETO")) {
                        //SE O PAI FOR PRETO, CAI NO DUPLO PRETO DE NOVO, CHAMA PASSANDO O PAI
                        duploPreto(pai);
                    } else {
                        pai.setCor("PRETO");
                    }
                }
            }
        }
    }

}
