package view;

import dao.UsuarioDAO;
import dao.ContribuicaoDAO;
import model.Usuario;
import model.Contribuicao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ContribuicaoDAO contribuicaoDAO = new ContribuicaoDAO();
        int opcao = -1;

        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Listar usuários");
            System.out.println("2. Adicionar usuário");
            System.out.println("3. Listar contribuições");
            System.out.println("4. Adicionar contribuição");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1 -> usuarioDAO.listarUsuarios();
                    case 2 -> {
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        usuarioDAO.adicionarUsuario(new Usuario(nome, email));
                    }
                    case 3 -> contribuicaoDAO.listarContribuicoes();
                    case 4 -> {
                        System.out.print("Título: ");
                        String titulo = sc.nextLine();
                        System.out.print("Descrição: ");
                        String descricao = sc.nextLine();
                        System.out.print("ODS: ");
                        String ods = sc.nextLine();
                        System.out.print("Autor: ");
                        String autor = sc.nextLine();
                        contribuicaoDAO.adicionarContribuicao(new Contribuicao(titulo, descricao, ods, autor));
                    }
                    case 0 -> {
                        System.out.println("Saindo...");
                        break;
                    }
                    default -> System.out.println("Opção inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
            }

        } while (opcao != 0);
        sc.close();
    }
}


