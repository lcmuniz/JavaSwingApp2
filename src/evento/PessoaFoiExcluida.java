package evento;

import entidade.Pessoa;

/*
Evento que deve ser colocado no eventbus quando
uma pessoa for excluída (o usuario clicar
no botao Excluir de PessoaForm
 */
public class PessoaFoiExcluida {

    // pessoa que foi excluida
    private Pessoa pessoa;

    public PessoaFoiExcluida(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
}
