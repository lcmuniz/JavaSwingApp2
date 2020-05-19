import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(String title) {

        setTitle(title);
        setLayout(new BorderLayout());
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container container = getContentPane();

        PessoaForm form = new PessoaForm();
        PessoaLista  lista = new PessoaLista();

        container.add(form, BorderLayout.WEST);
        container.add(lista, BorderLayout.EAST);

        setVisible(true);

    }

}
