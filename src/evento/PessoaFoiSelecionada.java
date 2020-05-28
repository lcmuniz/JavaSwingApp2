package evento;

import entidade.Pessoa;

public class PessoaFoiSelecionada {

    private Pessoa pessoa;

    public PessoaFoiSelecionada(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

}
