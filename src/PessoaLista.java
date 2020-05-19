import com.sun.imageio.plugins.jpeg.JPEGStreamMetadataFormat;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PessoaLista extends JPanel {

    public PessoaLista() {

        EventBus.getDefault().register(this);

        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setLayout(new GridLayout(1,1));

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Email");

        model.addRow(new String[] {"Luiz Carlos", "lcmuniz@gmail.com"});
        model.addRow(new String[] {"Maria das Graças", "maria@gmail.com"});

        JTable tabela = new JTable(model);

        add(tabela);

        setBorder(BorderFactory.createTitledBorder("Lista de Pessoas"));
    }

    @Subscribe
    public void on(PessoaFoiAdicionada evento) {
        System.out.println("A PESSOA " + evento.getPessoa() + " FOI ADICIONADA");
    }

}
