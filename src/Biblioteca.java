import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livros;
    private List<Autor> autores;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivrosDisponiveis() {
        return livros.stream()
                .filter(Livro::isDisponivel)
                .toList();
    }

    public boolean realizarEmprestimo(int idLivro, String nomeCliente) {
        Livro livroEncontrado = livros.stream()
                .filter(livro -> livro.getId() == idLivro)
                .findFirst()
                .orElse(null);


        if (livroEncontrado == null) {
            return false;
        }

        if (!livroEncontrado.isDisponivel()) {
            return false;
        }

        livroEncontrado.emprestar();

        Emprestimo emprestimo = new Emprestimo(
                emprestimos.size() + 1,
                livroEncontrado,
                nomeCliente
        );

        emprestimos.add(emprestimo);

        return true;
    }
}
