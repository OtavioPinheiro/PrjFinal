package br.edu.fatecmm.prjfinal.utils;

public class ErrorHandler extends Exception{
  public static class codigoIncompleto extends ErrorHandler {
    @Override
    public String getMessage() {
      return "O preenchimento do campo Código é obrigatório!";
    }
  }
  public static class codigoInadequado extends ErrorHandler{
    @Override
    public String getMessage() {
      return "Código inadequado! O Código deve ser um número inteiro de até 5 dígitos.";
    }
  }
  public static class nomeIncompleto extends ErrorHandler {
    @Override
    public String getMessage() {
      return "O preenchimento do campo Nome é obrigatório!";
    }
  }
  public static class nomeInadequado extends ErrorHandler {
    @Override
    public String getMessage() {
      return "Nome inadequado! O nome não deve ter caracteres especiais ou números.";
    }
  }
  public static class setorIncompleto extends ErrorHandler {
    @Override
    public String getMessage() {
      return "O preenchimento do campo Setor é obrigatório!";
    }
  }
  public static class setorInadequado extends ErrorHandler {
    @Override
    public String getMessage() {
      return "Setor inadequado! O setor não deve ter caracteres especiais.";
    }
  }
  public static class salarioIncompleto extends ErrorHandler {
    @Override
    public String getMessage() {
      return "O preenchimento do campo Salário é obrigatório!";
    }
  }
  public static class limiteDoSalarioExcedido extends ErrorHandler {
    @Override
    public String getMessage() {
      return "Informe um salário de R$1.100,00 até R$1.000.000.000,00";
    }
  }
}
