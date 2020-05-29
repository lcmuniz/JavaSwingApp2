package visao;

import entidade.Pessoa;
import evento.PessoaFoiAdicionada;
import evento.PessoaFoiAlterada;
import evento.PessoaFoiExcluida;
import evento.PessoaFoiSelecionada;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PessoaForm extends  JPanel {

    private JTextField nomeTextField;
    private JTextField emailTextField;
    private JButton adicionarButton;
    private JButton excluirButton;

    public PessoaForm() {

        EventBus.getDefault().register(this);

        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Detalhes da entidade"));

        setLayout(new GridBagLayout());

        JLabel nomeLabel = new JLabel("Nome ");
        nomeTextField = new JTextField(15);

        JLabel emailLabel = new JLabel("Email ");
        emailTextField = new JTextField(10);

        adicionarButton = new JButton("Adicionar");
        adicionarButton.addActionListener(aoAdicionarPessoa);

        excluirButton = new JButton("Excluir");
        excluirButton.setVisible(false);
        excluirButton.addActionListener(aoExcluirPessoa);

        GridBagConstraints gc = new GridBagConstraints();

        // linhas e colunas tem o mesmo peso (mesma altura e largura)
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.anchor = GridBagConstraints.LINE_END;   // componentes alinhados à direita
        gc.gridx = 0;
        gc.gridy = 0;
        add(nomeLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(emailLabel, gc);

        gc.anchor = GridBagConstraints.LINE_START; // componentes alinhados à esquerda
        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridwidth = 2;
        add(nomeTextField, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(emailTextField, gc);

        gc.anchor = GridBagConstraints.FIRST_LINE_START; // componentes alinhados à esquerda e no topo
        gc.weighty = 10;   // linha mas alta que as demais (faz as demais diminuírem)
        gc.gridx = 1;
        gc.gridy = 2;
        gc.gridwidth = 1;
        add(adicionarButton, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        add(excluirButton, gc);

    }

    // metodo a ser execugtado quando o usuario clicar no
    // botao Adicionar (Salvar)
    private final ActionListener aoAdicionarPessoa = evt -> {

        // ao clicar em adicionar...

        // pega os dados que o usuário digitou...
        String nome = nomeTextField.getText();
        String email = emailTextField.getText();

        if (nome.equals("") || email.equals("")) {
            return;
        }

        // cria um objeto pessoa
        Pessoa pessoa = new Pessoa(nome, email);

        if (adicionarButton.getText().equals("Adicionar")) {
            // clicou em Adicionar, emite o evento PessoaFoiAdicionada
            PessoaFoiAdicionada evento = new PessoaFoiAdicionada(pessoa);
            EventBus.getDefault().post(evento);
        }
        else {
            // clicou em Salvar, emite o evento PessoaFoiAlterada
            PessoaFoiAlterada evento = new PessoaFoiAlterada(pessoa);
            EventBus.getDefault().post(evento);
            adicionarButton.setText("Adicionar");
            excluirButton.setVisible(false);
        }

        nomeTextField.setText("");
        emailTextField.setText("");

        nomeTextField.grabFocus();

    };

    // metodo a ser executado quando o usuario clicar no
    // botão Excluir
    private final ActionListener aoExcluirPessoa = evt -> {

        String nome = nomeTextField.getText();
        String email = emailTextField.getText();
        Pessoa pessoa = new Pessoa(nome, email);
        PessoaFoiExcluida evento = new PessoaFoiExcluida(pessoa);
        EventBus.getDefault().post(evento);

        nomeTextField.setText("");
        emailTextField.setText("");
        adicionarButton.setText("Adicionar");
        excluirButton.setVisible(false);

    };

    // metodo a ser executado quando um evento PessoaFoiSelecioanada
    // for incluido no EventBus
    @Subscribe
    public void on(PessoaFoiSelecionada evento) {
        nomeTextField.setText(evento.getPessoa().getNome());
        emailTextField.setText(evento.getPessoa().getEmail());
        adicionarButton.setText("Salvar");
        excluirButton.setVisible(true);
    }

}
