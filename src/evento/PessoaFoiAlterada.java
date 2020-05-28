package evento;

import entidade.Pessoa;

/*
Evento que deve ser coloca no eventbus quando
uma pessoa for adicionada (o usuario clicar
no botao Adicionar de visao.PessoaForm
 */
public class PessoaFoiAlterada {

    // pessoa que foi adicionada
    private Pessoa pessoa;

    public PessoaFoiAlterada(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
}
