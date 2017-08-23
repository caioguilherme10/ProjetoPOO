/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.Cadastro_Usuario;
import java.util.List;
import java.util.Scanner;
import modelo.Usuario;

/**
 *
 * @author HP
 */
public class ProjetoPOO_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        boolean menu = true;
        
        while(menu == true){
            Scanner ler = new Scanner(System.in);
        
            System.out.println("Para fazer o login digite 1: \n" + 
                                "Para fazer o cadastro digite 2: \n"
                                + "Para sair digite 0:");
            int quant = ler.nextInt();
            switch(quant){
                case 1:
                    ler.nextLine();
                    System.out.println("E-mail:");
                    String email = ler.nextLine();
                    ler.nextLine();
                    System.out.println("Senha:");
                    String senha = ler.nextLine();
                    if(email.isEmpty() || senha.isEmpty()){
                        System.out.println("Dados vazios!!!");
                    }else{
                        List<Usuario> usuarios = new Cadastro_Usuario().list();
                        usuarios.forEach((cad) -> {
                            if(cad.autentica(email, senha)){
                                
                            }else{
                                System.out.println("Não existe esse usuario!!!");
                            }
                        });
                    }
                    break;
                case 2:
                    boolean cadas = true;
                    while(cadas){
                        ler.nextLine();
                        System.out.println("Para preencher digite 1: \n" + 
                                            "Para sair digite 0:");
                        int quantC = ler.nextInt();
                        switch(quantC){
                            case 1:
                                System.out.println("E-mail: ");
                                String email1 = ler.nextLine();
                                ler.nextLine();
                                System.out.println("Nome: ");
                                String nome = ler.nextLine();
                                ler.nextLine();
                                System.out.println("Nascimento: ");
                                //falta atribuir
                                System.out.println("Sexo:");
                                String temp = ler.next();
                                char sexo = temp.charAt(0);
                                ler.nextLine();
                                System.out.println("Senha:");
                                String senha1 = ler.nextLine();
                                ler.nextLine();
                                System.out.println("Senha:");
                                String senha2 = ler.nextLine();
                                ler.nextLine();
                                if(senha1.equals(senha2)){
                                    
                                }else{
                                    
                                }
                                break;
                            case 0:
                                cadas = false;
                                break;
                            default:
                                System.out.println("Numero errado!!!");
                        }
                    }
                    break;
                case 0:
                    menu = false;
                    break;
                default:
                    System.out.println("Numero errado!!!");
            }
        }
    }
    
}
