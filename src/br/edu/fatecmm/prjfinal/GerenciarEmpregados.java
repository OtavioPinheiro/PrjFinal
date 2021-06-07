package br.edu.fatecmm.prjfinal;

import java.util.ArrayList;
import java.util.List;

public class GerenciarEmpregados {
  public static List<Empregado> listaEmpregados = new ArrayList<>();

  GerenciarEmpregados(){
  }

  public void adicionarEmpregado(Empregado empregado){
    listaEmpregados.add(empregado);
  }

  public void removerEmpregado(Empregado empregado){
    if (verificarExistencia(empregado)){
      listaEmpregados.remove(empregado);
    }
  }

  public void removerTodosEmpregados(){
    listaEmpregados.removeAll(listaEmpregados);
  }

  public void atualizarEmpregado(Empregado empregado) {
    removerEmpregado(buscarEmpregado(empregado.getCodigoEmpregado()));
    adicionarEmpregado(empregado);
  }

  public static List<Empregado> listarEmpregados(){
    return listaEmpregados;
  }

  private boolean verificarExistencia(Empregado empregado){
    return listaEmpregados.contains(empregado);
  }

  public boolean empregadoJacadastrado(Empregado empregado) {
    boolean jaCadastrado = false;
    if (!listaEmpregados.isEmpty()) {
      for (Empregado empregadoCadastrado : listaEmpregados) {
        jaCadastrado = empregadoCadastrado.getCodigoEmpregado() == empregado.getCodigoEmpregado();
      }
    }
    return jaCadastrado;
  }

  public Empregado buscarEmpregado(int codigo) {
    Empregado empregadoEncontrado = null;
    for (Empregado empregado :
        listaEmpregados) {
      if (empregado.getCodigoEmpregado() == codigo) {
        empregadoEncontrado = empregado;
      }
    }
    return empregadoEncontrado;
  }
}
