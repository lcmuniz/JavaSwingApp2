import org.greenrobot.eventbus.EventBus;

import javax.swing.*;
import java.awt.*;

public class PessoaForm extends JPanel {

    public PessoaForm() {

        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Detalhes da Pessoa"));

        setLayout(new GridBagLayout());

        JLabel nomeLabel = new JLabel("Nome ");
        JTextField nomeTextField = new JTextField(10);

        JLabel emailLabel = new JLabel("Email ");
        JTextField emailTextField = new JTextField(10);

        JButton adicionarButton = new JButton("Adicionar");

        adicionarButton.addActionListener(evt -> {

            // ao clicar em adicionar...

            // pega os dados que o usuário digitou...
            String nome = nomeTextField.getText();
            String email = emailTextField.getText();

            // cria um objeto pessoa
            Pessoa pessoa = new Pessoa(nome, email);

            // cria um evento 'pessoa foi adicionada'...
            PessoaFoiAdicionada evento = new PessoaFoiAdicionada();
            evento.setPessoa(pessoa);  // seta a pessoa que foi adicionada

            EventBus.getDefault().post(evento); // envia o evento ao eventbus
            // quem assinar esse evento irá recebê-lo (no caso, o painel com a tabela)

        });

        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 0;
        gc.gridy = 0;
        add(nomeLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(emailLabel, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        add(nomeTextField, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(emailTextField, gc);

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.weighty = 10;
        gc.gridx = 1;
        gc.gridy = 2;
        add(adicionarButton, gc);

    }

}
