package br.edu.fatecmm.prjfinal.utils;

public class DataHandler {
  public boolean codigoOK(String codigo) throws ErrorHandler.codigoInadequado, ErrorHandler.codigoIncompleto {
    boolean estaCompleto = !codigo.isEmpty();
    boolean estaAdequado = estaCompleto && Integer.parseInt(codigo) > 0 && Integer.parseInt(codigo) <= 99999 &&
        codigo.matches("(^[0-9]{1,5}$)");
    if(estaCompleto) {
      if (estaAdequado) {
        return true;
      }
      else {
        throw new ErrorHandler.codigoInadequado();
      }
    }
    else {
      throw new ErrorHandler.codigoIncompleto();
    }
  }

  public boolean nomeOK(String nome) throws ErrorHandler.nomeInadequado, ErrorHandler.nomeIncompleto {
    boolean estaCompleto = !nome.isEmpty();
    boolean estaAdequado = nome.matches("(^[a-zA-ZáÁóÓéÉíÍÚúÃãÕõÂâÊêÎîÔôÛûçÇ ]{2,}$)+");
    if(estaCompleto) {
      if (estaAdequado) {
        return true;
      }
      else {
        throw new ErrorHandler.nomeInadequado();
      }
    }
    else {
      throw new ErrorHandler.nomeIncompleto();
    }
  }

  public boolean setorOK(String setor) throws ErrorHandler.setorInadequado, ErrorHandler.setorIncompleto {
    boolean estaCompleto = !setor.isEmpty();
    boolean estaAdequado = setor.matches("(^[a-zA-z0-9 ]+$)+");
    if(estaCompleto) {
      if (estaAdequado) {
        return true;
      }
      else {
        throw new ErrorHandler.setorInadequado();
      }
    }
    else {
      throw new ErrorHandler.setorIncompleto();
    }
  }

  public boolean salarioOK(String salario) throws ErrorHandler.limiteDoSalarioExcedido, ErrorHandler.salarioIncompleto {
    boolean estaCompleto = !salario.isEmpty();
    boolean estaAdequado = estaCompleto && Double.parseDouble(salario) >= 1_100 && Double.parseDouble(salario) <= 1_000_000_000;
    if(estaCompleto) {
      if (estaAdequado) {
        return true;
      }
      else {
        throw new ErrorHandler.limiteDoSalarioExcedido();
      }
    }
    else {
      throw new ErrorHandler.salarioIncompleto();
    }
  }
}
