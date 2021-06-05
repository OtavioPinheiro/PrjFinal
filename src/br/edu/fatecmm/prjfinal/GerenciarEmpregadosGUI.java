package br.edu.fatecmm.prjfinal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciarEmpregadosGUI extends JFrame {
  private JTable jTableEmpregados;
  private JPanel panelTabEmpregados;
  private JButton buttonRemover;
  private JButton buttonRemoverEmpregados;

  public GerenciarEmpregadosGUI() {
    criarTabela();
    buttonRemover.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        habilitarBotoes(!GerenciarEmpregados.listaEmpregados.isEmpty());
        int[] empregadosSelecionados = jTableEmpregados.getSelectedRows();
        if (empregadosSelecionados == null) {
          JOptionPane.showMessageDialog(
              null,
              "Selecione um empregado para remove-lo!",
              "Remover empregado",
              JOptionPane.WARNING_MESSAGE
          );
        }
        else {
          DefaultTableModel dadosTabelaEmpregados = (DefaultTableModel) jTableEmpregados.getModel();
          GerenciarEmpregados gerenciarEmpregados = new GerenciarEmpregados();
          for (int empregadoSelecionado : empregadosSelecionados) {
            int codigoEmpregado = Integer.parseInt(
                String.valueOf(dadosTabelaEmpregados.getValueAt(empregadoSelecionado, 0)));
            gerenciarEmpregados.removerEmpregado(gerenciarEmpregados.buscarEmpregado(codigoEmpregado));
          }
          criarTabela();
          habilitarBotoes(!GerenciarEmpregados.listaEmpregados.isEmpty());
          JOptionPane.showMessageDialog(
              null,
              "Empregado removido com sucesso!",
              "Remover empregado",
              JOptionPane.PLAIN_MESSAGE
          );
          fecharTabela(e);
        }
      }
    });
  }

  public JPanel getPanelTabEmpregados() {
    return panelTabEmpregados;
  }

  private void criarTabela() {
    String[][] dados = new String[GerenciarEmpregados.listarEmpregados().size()][5];
    int i = 0;

    for (Empregado empregado:
         GerenciarEmpregados.listarEmpregados()) {
      dados[i][0] = String.valueOf(empregado.getCodigoEmpregado());
      dados[i][1] = empregado.getNomeEmpregado();
      dados[i][2] = empregado.getSetor();
      dados[i][3] = String.valueOf(empregado.getSalarioBruto());
      dados[i][4] = String.valueOf(empregado.getRecInss());
      i++;
    }

    jTableEmpregados.setModel(new DefaultTableModel(
        dados,
        new String[]{"Código", "Nome", "Setor", "Salário", "Recolhimento"}
    ));
  }

  private void fecharTabela(ActionEvent e) {
    if (GerenciarEmpregados.listaEmpregados.isEmpty()) {
      dispose();
      JOptionPane.showMessageDialog(
          null,
          "Não há nenhum empregado na lista.",
          "Fechando tabela",
          JOptionPane.PLAIN_MESSAGE
      );
      JComponent comp = (JComponent) e.getSource();
      Window win = SwingUtilities.getWindowAncestor(comp);
      win.dispose();
    }
  }

  private void habilitarBotoes(boolean habilitar) {
    buttonRemover.setEnabled(habilitar);
    buttonRemoverEmpregados.setEnabled(habilitar);
  }
}
