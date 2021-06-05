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

  public void atualizarEmpregado(Empregado empregado) {
    removerEmpregado(empregado);
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
      for (int i = 0; i < listaEmpregados.size(); i++) {
        jaCadastrado = listaEmpregados.get(i).getCodigoEmpregado() == empregado.getCodigoEmpregado();
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
