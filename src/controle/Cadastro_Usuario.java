/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author HP
 */
public class Cadastro_Usuario {
    
    private static List<Usuario> usuarios;
    
    public Cadastro_Usuario(){
        usuarios = new ArrayList<>();
    }
    
    public boolean create(Usuario u){
        return usuarios.add(u);
    }
    
    public List<Usuario> list(){
        return usuarios;
    }
    
    public boolean update(Usuario u){
        for(int i=0; i<usuarios.size(); i++){
            if(usuarios.get(i).getEmail().equals(u.getEmail())){
                usuarios.set(i, u);
                return true;
            }
        }
        return false;
    }
    
    public boolean delete(Usuario u){
        return usuarios.remove(u);
    }
}
