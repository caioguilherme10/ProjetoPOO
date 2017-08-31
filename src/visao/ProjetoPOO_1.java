/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.Cadastro_Movimentacao;
import controle.Cadastro_Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Scanner;
import modelo.Movimentacao;
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
        Cadastro_Usuario usuarios = new Cadastro_Usuario();
        
        Usuario usu1 = new Usuario("caio@gmail.com","caio",LocalDate.now(), 'm', "caio0123");
        usuarios.create(usu1);
        System.out.println(usuarios.list());
        Cadastro_Movimentacao movimentacao = new Cadastro_Movimentacao();
        Movimentacao mov1 = new Movimentacao("a",LocalDate.now(), 2000, "a", "a", "caio@gmail.com");
        Movimentacao mov2 = new Movimentacao("b",LocalDate.now(), 20, "b", "b", "caio@gmail.com");
        movimentacao.create(mov1);
        movimentacao.create(mov2);
        System.out.println(movimentacao.list());
        Scanner ler = new Scanner(System.in);
        boolean menu = true;
        
        while(menu == true){
            
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
                        Usuario cad = usuarios.buscar(email);
                            if(cad.autentica(email, senha)){
                                boolean menup = true;
                                while(menup == true){
                                    ler.nextLine();
                                    System.out.println("Para Gerenciar perfil do usuario digite 1: \n" + 
                                                        "Para Cadastrar movimentação digite 2: \n"
                                                        + "Para sair digite 0:");
                                    int quantp = ler.nextInt();
                                    switch(quantp){
                                        case 1:
                                            boolean geren = true;
                                            while(geren == true){
                                                ler.nextLine();
                                                System.out.println("Para Atualizar usuario digite 1: \n" + 
                                                                    "Para Excluir usuario digite 2: \n"
                                                                    + "Para sair digite 0:");
                                                int quantg = ler.nextInt();
                                                switch(quantg){
                                                    case 1:
                                                            //atualizar usuario
                                                            ler.nextLine();
                                                            System.out.println("Nome: ");
                                                            String nome = ler.nextLine();
                                                            ler.nextLine();
                                                            System.out.println("Nascimento: ");
                                                            String nascimento = ler.nextLine();
                                                            DateTimeFormatter fomater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                                            LocalDate nasc = LocalDate.parse(nascimento, fomater);
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
                                                                //atualizar o cadastro do usuario
                                                                Usuario usus = new Usuario(email,nome,nasc,sexo, senha1);
                                                                usuarios.update(usus);
                                                                System.out.println(usuarios.list());
                                                                System.out.println("Update feito com sucesso!!!");
                                                            }else{
                                                                System.out.println("Senhas diferentes");
                                                            }
                                                            geren = false;
                                                            menup = false;
                                                        break;
                                                    case 2:
							//excluir usuario
							Usuario usus2 = usuarios.buscar(email);
                                                        usuarios.delete(usus2);
                                                        Movimentacao movi2 = movimentacao.buscar(email);
                                                        movimentacao.delete(mov2);
                                                        System.out.println(usuarios.list());
                                                        geren = false;
                                                        menup = false;
                                                        break;
                                                    case 0:
                                                        geren = false;
                                                        break;
                                                    default:
                                                        System.out.println("Numero errado!!!");
                                                }
                                            }
                                            break;
                                        case 2:
						//cadastra movimentaçao
                                                boolean cadmovi = true;
                                                while(cadmovi == true){
                                                    ler.nextLine();
                                                    System.out.println("Para preencher digite 1: \n" + 
                                                                "Para sair digite 0:");
                                                    int quantMo = ler.nextInt();
                                                    switch(quantMo){
                                                        case 1:
                                                            ler.nextLine();
                                                            System.out.println("Descriçao: ");
                                                            String descricao = ler.nextLine();
                                                            ler.nextLine();
                                                            System.out.println("Data: ");
                                                            String data = ler.nextLine();
                                                            DateTimeFormatter fomater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                                            LocalDate datam = LocalDate.parse(data, fomater);
                                                            ler.nextLine();
                                                            System.out.println("Preço:");
                                                            float preco = ler.nextFloat();
                                                            System.out.println("Tipo: ");
                                                            String tipo = ler.nextLine();
                                                            ler.nextLine();
                                                            System.out.println("Categoria: ");
                                                            String categoria = ler.nextLine();
                                                            ler.nextLine();
                                                            Movimentacao movim = new Movimentacao(descricao,datam,preco,tipo,categoria,email);
                                                            movimentacao.create(mov1);
                                                            System.out.println(movimentacao.list());
                                                            cadmovi = false;
                                                            break;
                                                        default:
                                                            System.out.println("Numero errado!!!");       
                                                    }
                                                }
                                            break;
                                        case 0:
                                            menup = false;
                                            break;
                                        default:
                                            System.out.println("Numero errado!!!");
                                    }
                                    
                                }
                                
                            }else{
                                System.out.println("Não existe esse usuario!!!");
                            }
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
                                ler.nextLine();
                                System.out.println("E-mail: ");
                                String emailp = ler.nextLine();
                                ler.nextLine();
                                System.out.println("Nome: ");
                                String nome = ler.nextLine();
                                ler.nextLine();
                                System.out.println("Nascimento: ");
                                String nascimento = ler.nextLine();
                                DateTimeFormatter fomater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDate nasc = LocalDate.parse(nascimento, fomater);
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
                                    //adicionar o cadastro do usuario
                                    Usuario usu2 = new Usuario(emailp,nome,nasc,sexo, senha1);
                                    usuarios.create(usu2);
                                    System.out.println(usuarios.list());
                                    System.out.println("Cadastro feito com sucesso!!!");
                                }else{
                                    System.out.println("Senhas diferentes");
                                }
                                System.out.println(nasc);
                                cadas = false;
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
        ler.close();
    }
    
}
