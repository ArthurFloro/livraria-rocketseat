import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        Autor autor1 = new Autor(
                1,
                "Machado de Assis",
                LocalDate.of(1839, 6, 21)
        );

        Autor autor2 = new Autor(
                2,
                "George Orwell",
                LocalDate.of(1903, 6, 25)
        );

        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);

        biblioteca.adicionarLivro(
                new Livro(1, "Dom Casmurro", autor1)
        );

        biblioteca.adicionarLivro(
                new Livro(2, "1984", autor2)
        );

        biblioteca.adicionarLivro(
                new Livro(3, "O Alienista", autor1)
        );

        System.out.println("=== BIBLIOTECA ===");
        System.out.print("Deseja ver os livros disponíveis? ");

        String resposta = scanner.nextLine();

        if (!resposta.equalsIgnoreCase("SIM")) {
            System.out.println("Obrigado por utilizar a biblioteca!");
            scanner.close();
            return;
        }

        List<Livro> livrosDisponiveis =
                biblioteca.listarLivrosDisponiveis();

        System.out.println("\n=== LIVROS DISPONÍVEIS ===");

        for (Livro livro : livrosDisponiveis) {

            System.out.println(
                    "ID: " + livro.getId()
                            + " | Título: " + livro.getTitulo()
                            + " | Autor: " + livro.getAutor().getNome()
            );
        }

        System.out.print("\nDigite o ID do livro: ");
        int idLivro = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite seu nome: ");
        String nomeCliente = scanner.nextLine();

        boolean emprestimoRealizado =
                biblioteca.realizarEmprestimo(
                        idLivro,
                        nomeCliente
                );

        if (emprestimoRealizado) {

            System.out.println(
                    "\nEmpréstimo realizado com sucesso!"
            );

        } else {

            System.out.println(
                    "\nNão foi possível realizar o empréstimo."
            );
        }

        System.out.println("Obrigado por utilizar a biblioteca!");

        scanner.close();
    }
}