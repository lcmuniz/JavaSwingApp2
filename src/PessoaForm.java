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

            String nome = nomeTextField.getText();
            String email = emailTextField.getText();

            Pessoa pessoa = new Pessoa(nome, email);

            PessoaFoiAdicionada evento = new PessoaFoiAdicionada();
            evento.setPessoa(pessoa);

            EventBus.getDefault().post(evento);

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
