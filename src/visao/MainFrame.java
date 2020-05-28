package visao;

import evento.AplicacaoFoiFinalizada;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(String title) {

        EventBus.getDefault().register(this);

        setTitle(title);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setJMenuBar(new MenuBar());

        Container container = getContentPane();

        PessoaForm form = new PessoaForm();  // formulário de pessoas
        PessoaLista  lista = new PessoaLista();  // tabela de pessoas

        container.add(form, BorderLayout.WEST);  // formulário à esquerda
        container.add(lista, BorderLayout.CENTER); // tabela no centro

        setPreferredSize(new Dimension(600, 300));
        pack();
        setLocationRelativeTo(null);  // centraliza janela na tela
        setVisible(true);

    }

    @Subscribe
    public void on(AplicacaoFoiFinalizada evento) {
        System.exit(0);
    }

}
