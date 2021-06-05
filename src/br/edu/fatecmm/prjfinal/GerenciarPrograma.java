package br.edu.fatecmm.prjfinal;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GerenciarPrograma {
  public static void main(String[] args) {
    Object[] opcoes = {"Sim", "Não"};
    JFrame tela = new JFrame();
    tela.setContentPane(new EmpregadoGUI().getPanelEmpregado());
    tela.setSize(650, 350);
    tela.setResizable(false);
    tela.setLocation(900, 500);
    tela.setTitle("Cadastro Empregados");
    tela.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    tela.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        int respostaJanela = JOptionPane.showOptionDialog(
          null,
          "Tem certeza que deseja sair?",
          "Encerrando",
          JOptionPane.DEFAULT_OPTION,
          JOptionPane.QUESTION_MESSAGE,
          null,
          opcoes,
          opcoes[0]
        );
        if (respostaJanela == 0) {
          JOptionPane.showMessageDialog(
            null,
            "Encerrando aplicação...\n\nObrigado!",
            "Encerrando",
            JOptionPane.PLAIN_MESSAGE
          );
          System.exit(0);
        }
      }
    });
    tela.setVisible(true);
  }
}
