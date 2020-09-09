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
public interface IArvoreBinaria<T> {
    public void inserir(T elemento);
    public No<T> consultaIterativa (T elemento);
    public No<T> consultaRecursiva (T elemento);
    public No<T> removerPreOrdem(T elemento);
    public No<T> removerPosOrdem(T elemento);
    public No<T> removerInOrdem(T elemento);
    public void preOrdem();
    public void posOrdem();
    public void inOrdem();


}
