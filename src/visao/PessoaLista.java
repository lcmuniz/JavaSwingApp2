package visao;

import entidade.Pessoa;
import evento.PessoaFoiAdicionada;
import evento.PessoaFoiAlterada;
import evento.PessoaFoiExcluida;
import evento.PessoaFoiSelecionada;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PessoaLista extends JPanel {

    DefaultTableModel model;
    JTable tabela;

    public PessoaLista() {

        EventBus.getDefault().register(this);

        setLayout(new GridLayout(1,1));

        // model da tabela
        model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Email");

        // adiciona duas linahas para demonstração...
        //model.addRow(new String[] {"Luiz Carlos", "lcmuniz@gmail.com"});
        //model.addRow(new String[] {"Maria das Graças", "maria@gmail.com"});

        tabela = new JTable(model); // cria a tabela a partir do modelo
        tabela.addMouseListener(aoSelecionarPessoa);

        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll);

        setBorder(BorderFactory.createTitledBorder("Lista de Pessoas"));

    }

    private final MouseListener aoSelecionarPessoa = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            if (tabela.getSelectedRow() == -1) {
                return;
            }

            int linhaSelecionada = tabela.getSelectedRow();
            String nome = (String) tabela.getModel().getValueAt(linhaSelecionada, 0);
            String email = (String) tabela.getModel().getValueAt(linhaSelecionada, 1);

            Pessoa pessoa = new Pessoa(nome, email);

            PessoaFoiSelecionada evento = new PessoaFoiSelecionada(pessoa);
            EventBus.getDefault().post(evento);

        }
    };

    @Subscribe
    public void on(PessoaFoiAdicionada evento) {
        Pessoa pessoa = evento.getPessoa();
        model.addRow( new String[] {pessoa.getNome(), pessoa.getEmail()});
    }

    @Subscribe
    public void on(PessoaFoiAlterada evento) {
        Pessoa pessoa = evento.getPessoa();
        int linhaSelecionada = tabela.getSelectedRow();
        model.removeRow(linhaSelecionada);
        model.addRow( new String[] {pessoa.getNome(), pessoa.getEmail()});
    }

    @Subscribe
    public void on(PessoaFoiExcluida evento) {
        Pessoa pessoa =evento.getPessoa();
        int linhaSelecionada = tabela.getSelectedRow();
        model.removeRow(linhaSelecionada);
    }


}
