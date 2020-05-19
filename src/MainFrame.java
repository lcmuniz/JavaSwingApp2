import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(String title) {

        setTitle(title);
        setLayout(new BorderLayout());
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // centraliza janela na tela

        Container container = getContentPane();

        PessoaForm form = new PessoaForm();  // formulário de pessoas
        PessoaLista  lista = new PessoaLista();  // tabela de pessoas

        container.add(form, BorderLayout.WEST);  // formulário à esquerda
        container.add(lista, BorderLayout.EAST); // tabela à direita

        setVisible(true);

    }

}
