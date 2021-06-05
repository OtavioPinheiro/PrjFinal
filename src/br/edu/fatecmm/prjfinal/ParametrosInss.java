package br.edu.fatecmm.prjfinal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ParametrosInss {
  public static final double FAIXA1 = 0.075;
  public static final double LIMITEFAIXA1 = 1_100.0;
  public static final double FAIXA2 = 0.09;
  public static final double LIMITEFAIXA2 = 2_203.48;
  public static final double FAIXA3 = 0.12;
  public static final double LIMITEFAIXA3 = 3_300.22;
  public static final double FAIXA4 = 0.14;
  public static final double LIMITEFAIXA4 = 6_433.57;

  public static double calcularInss(double salarioBruto) {
    double recINSS = 0.0;

    if(salarioBruto <= LIMITEFAIXA1){
      recINSS = salarioBruto * FAIXA1;
    }
    else if (salarioBruto > LIMITEFAIXA1 && salarioBruto <= LIMITEFAIXA2){
      recINSS = (LIMITEFAIXA1 * FAIXA1) + ((salarioBruto - LIMITEFAIXA1) * FAIXA2);
    }
    else if (salarioBruto >= LIMITEFAIXA2 && salarioBruto <= LIMITEFAIXA3){
      recINSS = (LIMITEFAIXA1 * FAIXA1) + ((LIMITEFAIXA2 - LIMITEFAIXA1) * FAIXA2) +
          ((salarioBruto - LIMITEFAIXA2) * FAIXA3);
    }
    else if (salarioBruto >= LIMITEFAIXA3 && salarioBruto <= LIMITEFAIXA4){
      recINSS = (LIMITEFAIXA1 * FAIXA1) + ((LIMITEFAIXA2 - LIMITEFAIXA1) * FAIXA2) +
          ((LIMITEFAIXA3 - LIMITEFAIXA2) * FAIXA3) + ((salarioBruto - LIMITEFAIXA3) * FAIXA4);
    }
    else if (salarioBruto > LIMITEFAIXA4){
      recINSS = 751.99;
    }

    recINSS = new BigDecimal(recINSS).setScale(2, RoundingMode.HALF_EVEN).doubleValue();

    return recINSS;
  }
}
