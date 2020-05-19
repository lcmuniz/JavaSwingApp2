import com.sun.imageio.plugins.jpeg.JPEGStreamMetadataFormat;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PessoaLista extends JPanel {

    public PessoaLista() {

        // registra o eventbus para assinar os eventos
        EventBus.getDefault().register(this);

        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setLayout(new GridLayout(1,1));

        // model da tabela
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Email");

        // adiciona duas linahas para demonstração...
        model.addRow(new String[] {"Luiz Carlos", "lcmuniz@gmail.com"});
        model.addRow(new String[] {"Maria das Graças", "maria@gmail.com"});

        JTable tabela = new JTable(model); // cria a tabela a partir do modelo
        add(tabela);

        setBorder(BorderFactory.createTitledBorder("Lista de Pessoas"));
    }

    @Subscribe
    public void on(PessoaFoiAdicionada evento) {
        // este método é executado sempre que um evento do tipo PessoaFoiAdicionada
        // for enviado ao eventbus (ver botão adicionar de PessoaForm)

        // mostra a pessoa do evento no console
        System.out.println("A PESSOA " + evento.getPessoa() + " FOI ADICIONADA");
    }

}
