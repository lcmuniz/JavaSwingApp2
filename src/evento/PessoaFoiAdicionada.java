package evento;

import entidade.Pessoa;

/*
Evento que deve ser colocado no eventbus quando
uma pessoa for adicionada (o usuario clicar
no botao Adicionar de PessoaForm
 */
public class PessoaFoiAdicionada {

    // pessoa que foi adicionada
    private Pessoa pessoa;

    public PessoaFoiAdicionada(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
}
