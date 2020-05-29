package evento;

import entidade.Pessoa;

/*
Evento que deve ser colocado no eventbus quando
uma pessoa for alterada (o usuario selecionar
uma pessoa em PessoaLista
 */
public class PessoaFoiAlterada {

    // pessoa que foi alterada
    private Pessoa pessoa;

    public PessoaFoiAlterada(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
}
