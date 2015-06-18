package Negocios;

import dominio.Inscricao;

/**
 * Created by One Does Not Simply on 14/06/2015.
 */
public class ValidadorPosGrad implements StrategyValidator {
    public boolean validarDados(Inscricao inscricao){

        boolean validado = false;

        if(inscricao.getId() > 0) {
            if (inscricao.getResposta().getPerguntas().getCpf() != null && inscricao.getResposta().getPerguntas().getCpf() != "") {
                if (inscricao.getResposta().getPerguntas().getEmail() != null && inscricao.getResposta().getPerguntas().getEmail() != "") {
                    if (inscricao.getResposta().getPerguntas().getDiploma() != null && inscricao.getResposta().getPerguntas().getDiploma() != "") {
                        if (inscricao.getResposta().getPerguntas().getCurriculoLattes() != null && inscricao.getResposta().getPerguntas().getCurriculoLattes() != "") {
                            if (inscricao.getResposta().getPerguntas().getCpf() != null && inscricao.getResposta().getPerguntas().getCpf() != "") {
                                if (inscricao.getResposta().getPerguntas().getSexo().toLowerCase().equals("masculino")) {
                                    if (inscricao.getResposta().getPerguntas().getReservista() != null && inscricao.getResposta().getPerguntas().getReservista() != "") {
                                        if (inscricao.getResposta().getPerguntas().getNacionalidade() != null && inscricao.getResposta().getPerguntas().getNacionalidade() != "") {
                                            validado = true;
                                        }
                                    }
                                } else if (inscricao.getResposta().getPerguntas().getSexo().toLowerCase().equals("feminino")) {
                                    if (inscricao.getResposta().getPerguntas().getNacionalidade() != null && inscricao.getResposta().getPerguntas().getNacionalidade() != "") {
                                        validado = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        validado = validarDiploma(inscricao.getResposta().getPerguntas().getDiploma());
        return validado;
    }

    public boolean validarDiploma(String diploma){
        boolean retorno;
        if(diploma.contains("Bacharelado")){
            retorno = true;
        }else{
            retorno = false;
        }
        return retorno;
    }

    public boolean validarInscricao(Inscricao inscricao){
        return validarDados(inscricao);
    }
}

