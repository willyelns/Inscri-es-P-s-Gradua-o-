package Negocios;

import java.util.Random;

import dominio.Formulario;
import dominio.Inscricao;

/**
 * Created by One Does Not Simply on 14/06/2015.
 */
public class ComprovantePosGrad implements Comprovante {

    public String gerarComprovante(Inscricao inscricao){

        String comprovante = new Random().nextInt() + inscricao.getResposta().getId()+ "";
        return comprovante;

    }
    public String geraComprovante(Formulario inscricao){

        int num = new Random().nextInt(Integer.MAX_VALUE)+ 1;
        String comprovante = "O seu comprovante \u00e9: " +  new Random(100000).nextInt(1000) + num;
        return  comprovante;
    }
}
