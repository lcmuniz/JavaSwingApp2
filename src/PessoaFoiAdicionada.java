/*
Evento que deve ser coloca no eventbus quando
uma pessoa for adicionada (o usuario clicar
no botao Adicionar de PessoaForm
 */
public class PessoaFoiAdicionada {

    // pessoa que foi adicionada
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
