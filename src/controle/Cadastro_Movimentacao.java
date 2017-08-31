/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import java.util.List;
import modelo.Movimentacao;

/**
 *
 * @author HP
 */
public class Cadastro_Movimentacao {
    
    private static List<Movimentacao> movimentacao;
    
    public Cadastro_Movimentacao(){
        movimentacao = new ArrayList<>();
    }
    
    public boolean create(Movimentacao m){
        return movimentacao.add(m);
    }
    
    public List<Movimentacao> list(){
        return movimentacao;
    }
    
    public Movimentacao buscar(String email){
        for(Movimentacao a : movimentacao){
            if(a.getClass() == Movimentacao.class){
                Movimentacao mov = (Movimentacao)a;
                if(mov.getEmail().equals(email)){
                    return a;
                }
            }
        }
        return null;
    }
    
    public boolean update(Movimentacao m){
        for(int i=0; i<movimentacao.size(); i++){
            if(movimentacao.get(i).getId() == m.getId()){
                movimentacao.set(i, m);
                return true;
            }
        }
        return false;
    }
    
    public boolean delete(Movimentacao m){
        return movimentacao.remove(m);
    }
}
