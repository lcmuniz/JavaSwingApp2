package evento;

import entidade.Pessoa;

/*
Evento que deve ser colocado no eventbus quando
uma pessoa for selecionada em PessoaLista
 */
public class PessoaFoiSelecionada {

    // pessoa que foi selecionada
    private Pessoa pessoa;

    public PessoaFoiSelecionada(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

}
