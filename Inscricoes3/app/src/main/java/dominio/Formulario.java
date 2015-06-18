package dominio;

import Negocios.BusinessFormulario;

/**
 * Created by One Does Not Simply on 14/06/2015.
 */
public class Formulario implements FormularioInterface{

    private PosGrad perguntas;
    private int id;

    public Formulario(String nome, String sobrenome, String email, String rg, String cpf, String telefone,
                      Endereco endereco, String nacionalidade, String reservista, String sexo,String diploma,
                      String curriculoLattes, String declaracaoConcurso, String certificados){

        perguntas = new PosGrad( nome,  sobrenome,  email,  rg,  cpf,  telefone,
                 endereco,  nacionalidade,  reservista,  sexo, diploma,
                 curriculoLattes,  declaracaoConcurso, certificados);
    }
    public Formulario(Formulario formulario){
    }

    public PosGrad getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(PosGrad perguntas) {
        this.perguntas = perguntas;
    }

    public void editarFormulario(Formulario formulario){
        BusinessFormulario.update(formulario);
    }

    @Override
    public void salvarFormulario(Formulario formulario) {
        BusinessFormulario.create(formulario);
    }

    public void criarFormulario(Formulario formulario){
        BusinessFormulario.create(formulario);
    }
    public void deletarFormulario(Formulario formulario){
        BusinessFormulario.delete(formulario.getId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
