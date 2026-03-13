import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        
        DAO dao = new DAO();
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        
        if (!dao.conectar()) {
            System.out.println("Erro ao conectar ao banco de dados!");
            return;
        }

        while (opcao != 5) {
            System.out.println("\n==== MENU CRUD ====");
            System.out.println("1) Listar");
            System.out.println("2) Inserir");
            System.out.println("3) Excluir");
            System.out.println("4) Atualizar");
            System.out.println("5) Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    Usuario[] lista = dao.getUsuarios();
                    if (lista != null) {
                        for (Usuario u : lista) {
                            System.out.println(u.toString());
                        }
                    }
                    break;

                case 2:
                    System.out.print("Codigo: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String n = sc.nextLine();
                    System.out.print("Sobrenome: ");
                    String s = sc.nextLine();
                    System.out.print("Sexo (M/F): ");
                    char sx = sc.nextLine().charAt(0);
                    
                    Usuario novo = new Usuario(id, n, s, sx);
                    if (dao.inserirUsuario(novo)) {
                        System.out.println("Inserido com sucesso!");
                    }
                    break;

                case 3:
                    System.out.print("Informe o codigo para excluir: ");
                    int codExcluir = sc.nextInt();
                    if (dao.excluirUsuario(codExcluir)) {
                        System.out.println("Excluido com sucesso!");
                    }
                    break;

                case 4:
                    System.out.print("Informe o codigo do usuario a atualizar: ");
                    int codAtu = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo Nome: ");
                    String novoN = sc.nextLine();
                    System.out.print("Novo Sobrenome: ");
                    String novoS = sc.nextLine();
                    System.out.print("Novo Sexo (M/F): ");
                    char novoSx = sc.nextLine().charAt(0);
                    
                    Usuario atu = new Usuario(codAtu, novoN, novoS, novoSx);
                    if (dao.atualizarUsuario(atu)) {
                        System.out.println("Atualizado com sucesso!");
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        
        dao.close();
        sc.close();
    }
}