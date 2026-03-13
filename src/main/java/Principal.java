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
            System.out.println("\n==== MENU CARROS ====");
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
                    Carro[] lista = dao.getCarros();
                    if (lista != null) {
                        for (Carro c : lista) {
                            System.out.println(c.toString());
                        }
                    }
                    break;

                case 2:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Modelo: ");
                    String mod = sc.nextLine();
                    System.out.print("Marca: ");
                    String mar = sc.nextLine();
                    System.out.print("Tipo (S/H/U): ");
                    char t = sc.nextLine().charAt(0);
                    
                    Carro novo = new Carro(id, mod, mar, t);
                    if (dao.inserirCarro(novo)) {
                        System.out.println("Inserido com sucesso!");
                    }
                    break;

                case 3:
                    System.out.print("Informe o ID para excluir: ");
                    int idExcluir = sc.nextInt();
                    if (dao.excluirCarro(idExcluir)) {
                        System.out.println("Excluido com sucesso!");
                    }
                    break;

                case 4:
                    System.out.print("Informe o ID do carro a atualizar: ");
                    int idAtu = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo Modelo: ");
                    String novoMod = sc.nextLine();
                    System.out.print("Nova Marca: ");
                    String novaMar = sc.nextLine();
                    System.out.print("Novo Tipo (S/H/U): ");
                    char novoT = sc.nextLine().charAt(0);
                    
                    Carro atu = new Carro(idAtu, novoMod, novaMar, novoT);
                    if (dao.atualizarCarro(atu)) {
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