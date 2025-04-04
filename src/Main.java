public static void main() {
    Biblioteca biblioteca = new Biblioteca();
    Scanner scanner = new Scanner(System.in);
    boolean continuar = true;

    while (continuar) {
        System.out.println("Menu:");
        System.out.println("1 - Adicionar Livro");
        System.out.println("2 - Adicionar Revista");
        System.out.println("3 - Listar Materiais");
        System.out.println("4 - Pesquisar Material");
        System.out.println("5 - Excluir Material");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha

        switch (opcao) {
            case 1: {
                // Adicionar Livro
                System.out.print("Digite o título do livro: ");
                String titulo = scanner.nextLine();
                System.out.print("Digite o autor do livro: ");
                String autor = scanner.nextLine();
                System.out.print("Digite o gênero do livro (FICCAO, ROMANCE, AVENTURA, TERROR, FANTASIA, SCI_FI, HISTORIA): ");
                Genero genero = Genero.valueOf(scanner.nextLine().toUpperCase());

                Livro livro = new Livro(titulo, autor, genero);
                biblioteca.adicionarMaterial(livro);
                System.out.println("Livro adicionado!");
                break;
            }
            case 2: {
                // Adicionar Revista
                System.out.print("Digite o título da revista: ");
                String titulo = scanner.nextLine();
                System.out.print("Digite o autor da revista: ");
                String autor = scanner.nextLine();
                System.out.print("Digite o número da revista: ");
                int numero = scanner.nextInt();

                Revista revista = new Revista(titulo, autor, numero);
                biblioteca.adicionarMaterial(revista);
                System.out.println("Revista adicionada!");
                break;
            }
            case 3: {
                // Listar materiais
                System.out.println("\nMateriais na Biblioteca:");
                biblioteca.listarMateriais();
                break;
            }
            case 4: {
                // Pesquisar material
                System.out.print("Digite o título do material a ser pesquisado: ");
                String titulo = scanner.nextLine();
                Material material = biblioteca.pesquisarPorTitulo(titulo);
                if (material != null) {
                    material.exibirDetalhes();
                } else {
                    System.out.println("Material não encontrado.");
                }
                break;
            }
            case 5: {
                // Excluir material
                System.out.print("Digite o título do material a ser excluído: ");
                String titulo = scanner.nextLine();
                boolean excluido = biblioteca.excluirPorTitulo(titulo);
                if (excluido) {
                    System.out.println("Material excluído com sucesso!");
                } else {
                    System.out.println("Material não encontrado.");
                }
                break;
            }
            case 6: {
                // Sair
                continuar = false;
                System.out.println("Saindo...");
                break;
            }
            default:
                System.out.println("Opção inválida!");
        }
    }

    scanner.close();
}
