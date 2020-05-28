package visao;

import evento.AplicacaoFoiFinalizada;
import org.greenrobot.eventbus.EventBus;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {

    public MenuBar() {

        JMenu arquivo = new JMenu("Arquivo");

        arquivo.add(new JMenuItem("Abrir"));
        arquivo.add(new JMenuItem("Salvar"));
        arquivo.add(new JSeparator());

        JMenuItem arquivoSair = new JMenuItem("Sair");
        arquivoSair.addActionListener(aoSair);
        arquivo.add(arquivoSair);

        JMenu ajuda = new JMenu("Ajuda");

        JMenuItem sobre = new JMenuItem("Sobre");
        ajuda.add(sobre);

        add(arquivo);
        add(ajuda);
    }

    private final ActionListener aoSair = evt-> {
        AplicacaoFoiFinalizada evento = new AplicacaoFoiFinalizada();
        EventBus.getDefault().post(evento);
    };


}
