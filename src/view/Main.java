/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
        ArvoreBinaria arvoreGenerica = new ArvoreBinaria();
        
        int[] toAdd = new int[]{50, 45, 65, 35, 46, 75, 15, 40,70, 85, 5, 38, 42, 36, 43};
        //int[] toAdd = new int[]{66 , 78 , 87 , 4 , 11 , 59 , 13 , 3 , 85 , 16 , 20 , 28 , 77 , 82 , 19 , 56 , 97 , 61 , 67 , 57};
        for (int i : toAdd) {
            arvoreGenerica.inserir(i);
        }
        System.out.println("Imprimindo a Arvore:");
        arvoreGenerica.imprimeArvore();
        System.out.println("Consulta numero : "+arvoreGenerica.consulta(50));
        System.out.println("Grau do no 43: "+arvoreGenerica.getGrauNo(43));
        System.out.println("profundidade: "+ arvoreGenerica.getProfundidadeNo(50));
        System.out.println("Altura: "+arvoreGenerica.getAlturaNo(38));
        System.out.println("Tamanho recursivo: "+ arvoreGenerica.numeroNosRecursivo());
        //System.out.println("Tamanho normal: "+ arvoreGenerica.tamanhoArvore());
        System.out.println("Navegação LRN: "+ arvoreGenerica.navegacaoLRN());
        System.out.println("Navegação LNR: "+ arvoreGenerica.navegacaoLNR());
        System.out.println("Navegação NLR: "+ arvoreGenerica.navegacaoNLR());
        
        /*
        System.out.println("Arvore:");
        arvoreGenerica.imprimeArvore();
        System.out.println("Remover 45");
        arvoreGenerica.remover(45);*/
        
        /*
        System.out.println("Arvore:");
        arvoreGenerica.imprimeArvore();
        System.out.println("Arvore inversa:");
        arvoreGenerica.inverterArvore();
        arvoreGenerica.imprimeArvore();*/
        
        /*
        System.out.println("Iterator");
        for (Object i : arvoreGenerica) {
            System.out.println(i);
        }*/
    }
    
}
