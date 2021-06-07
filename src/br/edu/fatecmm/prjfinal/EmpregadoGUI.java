package br.edu.fatecmm.prjfinal;

import br.edu.fatecmm.prjfinal.utils.DataHandler;
import br.edu.fatecmm.prjfinal.utils.ErrorHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;

public class EmpregadoGUI {
  private JPanel panelEmpregado;
  private JTextField textCodigoEmpregado;
  private JLabel labelCodigoEmpregado;
  private JTextField textNomeEmpregado;
  private JTextField textSetor;
  private JTextField textSalarioEmpregado;
  private JLabel labelNomeEmpregado;
  private JLabel labelSetor;
  private JLabel labelSalarioEmpregado;
  private JButton buttonCalcular;
  private JButton buttonCadastrar;
  private JButton buttonApresentar;
  private JLabel labelRecolhimento;
  private JLabel labelValorCalculado;
  private JLabel labelErroCodigo;
  private JLabel labelErroNome;
  private JLabel labelErroSetor;
  private JLabel labelErroSalario;
  public GerenciarEmpregados gerenciarEmpregados;
  public Empregado empregado;
  public DataHandler dados;
  private boolean campoCodigoOk = false;
  private boolean campoNomeOk = false;
  private boolean campoSetorOk = false;
  private boolean campoSalarioOk = false;
  private boolean campoRecolhimentoOk = false;

  public EmpregadoGUI() {
    gerenciarEmpregados = new GerenciarEmpregados();
    empregado = new Empregado();
    dados = new DataHandler();

    labelErroCodigo.setVisible(false);
    labelErroNome.setVisible(false);
    labelErroSetor.setVisible(false);
    labelErroSalario.setVisible(false);

    DesabilitarBotoes();
    HabilitarApresentar();

    textCodigoEmpregado.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        try {
          campoCodigoOk = dados.codigoOK(textCodigoEmpregado.getText());
          empregado.setCodigoEmpregado(Integer.parseInt(textCodigoEmpregado.getText()));
          labelErroCodigo.setVisible(false);
          textCodigoEmpregado.setBorder(BorderFactory.createEtchedBorder(1,
            null,
            new Color(122, 138, 153)
          ));
          HabilitarCalcular();
          HabilitarCadastrar();
          HabilitarApresentar();
        } catch (ErrorHandler.codigoInadequado |
          ErrorHandler.codigoIncompleto erro) {
          DesabilitarBotoes();
          HabilitarApresentar();
          labelErroCodigo.setText(erro.getMessage());
          labelErroCodigo.setForeground(new Color(240,9,9));
          labelErroCodigo.setVisible(true);
          textCodigoEmpregado.setBorder(BorderFactory.createLineBorder(new Color(240,9,9)));
        } catch (NumberFormatException nfe) {
          DesabilitarBotoes();
          HabilitarApresentar();
          labelErroCodigo.setText("O código deve conter apenas números.");
          labelErroCodigo.setForeground(new Color(240,9,9));
          labelErroCodigo.setVisible(true);
          textCodigoEmpregado.setBorder(BorderFactory.createLineBorder(new Color(240,9,9)));
        }
      }
    });

    textNomeEmpregado.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        try {
          campoNomeOk = dados.nomeOK(textNomeEmpregado.getText());
          empregado.setNomeEmpregado(textNomeEmpregado.getText());
          labelErroNome.setVisible(false);
          textNomeEmpregado.setBorder(BorderFactory.createEtchedBorder(1,
            null,
            new Color(122, 138, 153)
          ));
          HabilitarCalcular();
          HabilitarCadastrar();
          HabilitarApresentar();
        } catch (ErrorHandler.nomeInadequado |
          ErrorHandler.nomeIncompleto erro) {
          DesabilitarBotoes();
          HabilitarApresentar();
          labelErroNome.setText(erro.getMessage());
          labelErroNome.setForeground(new Color(240,9,9));
          labelErroNome.setVisible(true);
          textNomeEmpregado.setBorder(BorderFactory.createLineBorder(new Color(240,9,9)));
        }
      }
    });

    textSetor.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        try {
          campoSetorOk = dados.setorOK(textSetor.getText());
          empregado.setSetor(textSetor.getText());
          labelErroSetor.setVisible(false);
          textSetor.setBorder(BorderFactory.createEtchedBorder(1,
            null,
            new Color(122, 138, 153)
          ));
          HabilitarCalcular();
          HabilitarCadastrar();
          HabilitarApresentar();
        } catch (ErrorHandler.setorInadequado |
          ErrorHandler.setorIncompleto erro) {
          DesabilitarBotoes();
          HabilitarApresentar();
          labelErroSetor.setText(erro.getMessage());
          labelErroSetor.setForeground(new Color(240,9,9));
          labelErroSetor.setVisible(true);
          textSetor.setBorder(BorderFactory.createLineBorder(new Color(240,9,9)));
        }
      }
    });

    textSalarioEmpregado.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        try {
          if(textSalarioEmpregado.getText().matches("([0-9]){1,3}(\\.)([0-9])+$+")) {
            textSalarioEmpregado.setText(textSalarioEmpregado.getText().replaceAll("(\\.)",""));
          }
          campoSalarioOk = dados.salarioOK(textSalarioEmpregado.getText().replaceAll("(,)","."));
          empregado.setSalarioBruto(Double.parseDouble(textSalarioEmpregado.getText().replaceAll("(,)",".")));
          labelErroSalario.setVisible(false);
          textSalarioEmpregado.setBorder(BorderFactory.createEtchedBorder(1,
            null,
            new Color(122, 138, 153)
          ));
          HabilitarCalcular();
          HabilitarCadastrar();
          HabilitarApresentar();
        } catch (ErrorHandler.limiteDoSalarioExcedido |
          ErrorHandler.salarioIncompleto erro) {
          DesabilitarBotoes();
          HabilitarApresentar();
          labelErroSalario.setText(erro.getMessage());
          labelErroSalario.setForeground(new Color(240,9,9));
          labelErroSalario.setVisible(true);
          textSalarioEmpregado.setBorder(BorderFactory.createLineBorder(new Color(240,9,9)));
        } catch (NumberFormatException nfe) {
          DesabilitarBotoes();
          HabilitarApresentar();
          labelErroSalario.setText("Salário informado está incorreto!");
          labelErroSalario.setForeground(new Color(240,9,9));
          labelErroSalario.setVisible(true);
          textSalarioEmpregado.setBorder(BorderFactory.createLineBorder(new Color(240,9,9)));
        }
      }
    });

    buttonCalcular.addActionListener(e -> {
      empregado.setRecInss(ParametrosInss.calcularInss(empregado.getSalarioBruto()));
      labelValorCalculado.setText("R$ " + Double.toString(empregado.getRecInss()).replaceAll("(\\.)",","));
      campoRecolhimentoOk = true;
      HabilitarCadastrar();
      HabilitarApresentar();
    });

    buttonCadastrar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (buttonCadastrar.isEnabled()) {
          Object[] opcoes = {"Sim", "Não"};
          if(gerenciarEmpregados.empregadoJacadastrado(empregado)) {
            int respostaJanela = JOptionPane.showOptionDialog(
              null,
              "Este usuário já foi adicionado. Deseja atualizá-lo?",
              "Atualizar empregado",
              JOptionPane.DEFAULT_OPTION,
              JOptionPane.QUESTION_MESSAGE,
              null,
              opcoes,
              opcoes[0]
            );
            if (respostaJanela == 0) {
              gerenciarEmpregados.atualizarEmpregado(empregado);
              JOptionPane.showMessageDialog(
                null,
                "Empregado atualizado com sucesso!",
                "Tela de sucesso",
                JOptionPane.PLAIN_MESSAGE
              );
            }
          }
          else {
            gerenciarEmpregados.adicionarEmpregado(empregado);
            JOptionPane.showMessageDialog(
              null,
              "Empregado adicionado com sucesso!",
              "Tela de sucesso",
              JOptionPane.PLAIN_MESSAGE
            );
          }
          limparFormulario();
          empregado = new Empregado();
          HabilitarApresentar();
          DesabilitarBotoes();
        }
      }
    });

    buttonApresentar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (buttonApresentar.isEnabled() && !GerenciarEmpregados.listaEmpregados.isEmpty()) {
          JFrame tabela = new JFrame();
          tabela.setContentPane(new GerenciarEmpregadosGUI().getPanelTabEmpregados());
          tabela.setSize(450, 250);
          tabela.setResizable(false);
          tabela.setLocation(900, 500);
          tabela.setTitle("Tabela de Empregados");
          tabela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
          tabela.setVisible(true);
          tabela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
              HabilitarApresentar();
            }
          });
        }
      }
    });
  }

  public JPanel getPanelEmpregado() {
    return panelEmpregado;
  }

  private void HabilitarCadastrar() {
    if (campoCodigoOk &&
      campoNomeOk &&
      campoSetorOk &&
      campoSalarioOk &&
      campoRecolhimentoOk
    ) {
      buttonCadastrar.setEnabled(true);
    }
  }

  private void HabilitarApresentar() {
    buttonApresentar.setEnabled(!GerenciarEmpregados.listaEmpregados.isEmpty());
  }

  private void HabilitarCalcular() {
    if (campoCodigoOk &&
      campoNomeOk &&
      campoSetorOk &&
      campoSalarioOk
    ) {
      buttonCalcular.setEnabled(true);
    }
  }

  private void DesabilitarBotoes() {
    buttonCalcular.setEnabled(false);
    buttonCadastrar.setEnabled(false);
  }

  private void limparFormulario() {
    textCodigoEmpregado.setText("");
    textNomeEmpregado.setText("");
    textSetor.setText("");
    textSalarioEmpregado.setText("");
    labelValorCalculado.setText("R$");
    campoCodigoOk = false;
    campoNomeOk = false;
    campoSetorOk = false;
    campoSalarioOk = false;
    campoRecolhimentoOk = false;
  }
}
