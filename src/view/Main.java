/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import model.ArvoreBinaria;
import model.No;

/**
 *
 * @author clayl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        System.out.println("print");
        System.out.println("commit teste 2");
        ArvoreBinaria arvoreGenerica = new ArvoreBinaria();
        int[] toAdd = new int[]{35,40,20,30};
        for (int i : toAdd) {
            arvoreGenerica.inserir(i);
        }
        arvoreGenerica.imprimeArvore();
        //System.out.println(arvoreGenerica.navegacaoLNR());
        System.out.println("");
        System.out.println("");
        
        /*
        
        ArvoreBinaria arvoreGenerica2 = new ArvoreBinaria();
        int[] toAdd2 = new int[]{50,30,65,40,36,49, 75};
        for (int i : toAdd2) {
            arvoreGenerica2.inserir(i);
        }
        arvoreGenerica2.imprimeArvore();
        System.out.println("");
        
         ArvoreBinaria arvoreGenerica3 = new ArvoreBinaria();
        int[] toAdd3 = new int[]{50,30,65,40,35,48, 64};
        for (int i : toAdd3) {
            arvoreGenerica3.inserir(i);
        }
        arvoreGenerica3.imprimeArvore();

        System.out.println("Arvores similares:");
        System.out.println(arvoreGenerica.similar(arvoreGenerica3));
        
        */
        
        
                /*
        System.out.println("Imprimindo a Arvore:");
        arvoreGenerica.imprimeArvore();
        /*
        System.out.println("Imprimindo a Arvore:");
        arvoreGenerica.imprimeArvore();
        System.out.println("Consulta numero 50 : "+arvoreGenerica.consulta(50));
        System.out.println("Grau do no 43: "+arvoreGenerica.getGrauNo(70));
        System.out.println("profundidad:e: 46 "+ arvoreGenerica.getProfundidadeNo(46));
        System.out.println("Altura: 38 "+arvoreGenerica.getAlturaNo(38));
        System.out.println("Tamanho recursivo: "+ arvoreGenerica.numeroNosRecursivo());
        //System.out.println("Tamanho normal: "+ arvoreGenerica.tamanhoArvore());
        */
        
        /*
        System.out.println("Navegação LRN: "+ arvoreGenerica.navegacaoLRN());
        System.out.println("Navegação LNR: "+ arvoreGenerica.navegacaoLNR());
        System.out.println("Navegação NLR: "+ arvoreGenerica.navegacaoNLR());
        */
        /*
        
        System.out.println("Arvore:");
        arvoreGenerica.imprimeArvore();
        System.out.println("Remover 30");
        arvoreGenerica.remover(30);
        System.out.println("Arvore:");
        arvoreGenerica.imprimeArvore();*/
        
        /*
        System.out.println("Arvore inversa:");
        arvoreGenerica.inverterArvore();
        arvoreGenerica.imprimeArvore();
      
        */
       
        //System.out.println(arvoreGenerica.somaPar());
        
       
        
        
    }
    
}
