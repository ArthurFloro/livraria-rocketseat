import java.time.LocalDateTime;

public class Emprestimo {

    private int id;
    private Livro livro;
    private String nomeCliente;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

    public Emprestimo(int id, Livro livro, String nomeCliente) {
        this.id = id;
        this.livro = livro;
        this.nomeCliente = nomeCliente;
    }

    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

}
