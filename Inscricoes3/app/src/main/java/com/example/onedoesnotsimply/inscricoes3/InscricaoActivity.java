package com.example.onedoesnotsimply.inscricoes3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import Negocios.BusinessInscricao;
import Negocios.ComprovantePosGrad;
import dominio.Endereco;
import dominio.Formulario;
import dominio.Inscricao;


public class InscricaoActivity extends Activity {

    Formulario respostas;
    EditText nome;
    EditText sobrenome;
    EditText email;
    EditText rg;
    EditText cpf;
    EditText telefone;
    EditText rua;
    EditText numero;
    EditText bairro;
    EditText cidade;
    EditText estado;
    EditText complemento;
    EditText nacionalidade;
    EditText sexo;
    EditText diploma;
    EditText reservista;
    EditText curriculoLattes;
    EditText declaracao;
    EditText certificados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscricao);

        nome = (EditText) findViewById(R.id.editNome);
        sobrenome = (EditText) findViewById(R.id.editSobrenome);
        email = (EditText) findViewById(R.id.editEmail);
        rg = (EditText) findViewById(R.id.editRg);
        cpf = (EditText) findViewById(R.id.editCpf);
        telefone = (EditText) findViewById(R.id.editTelefone);
        rua = (EditText) findViewById(R.id.EditRua);
        numero = (EditText) findViewById(R.id.EditNumero);
        bairro = (EditText) findViewById(R.id.EditBairro);
        cidade = (EditText) findViewById(R.id.EditCidade);
        estado = (EditText) findViewById(R.id.EditEstado);
        complemento = (EditText) findViewById(R.id.EditComplemento);
        nacionalidade = (EditText) findViewById(R.id.EditNacionalidade);
        sexo = (EditText) findViewById(R.id.EditSexo);
        diploma = (EditText) findViewById(R.id.EditDiploma);
        reservista = (EditText) findViewById(R.id.EditReservista);
        curriculoLattes = (EditText) findViewById(R.id.EditCurriculo);
        declaracao = (EditText) findViewById(R.id.EditDeclaracao);
        certificados = (EditText) findViewById(R.id.EditCertificado);
    }

    public boolean validarDados() {
        boolean retorno;
        if (nome.getText().toString().isEmpty()) {
            nome.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (sobrenome.getText().toString().isEmpty()) {
            sobrenome.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (email.getText().toString().isEmpty()) {
            email.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (rg.getText().toString().isEmpty()) {
            rg.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (cpf.getText().toString().isEmpty()) {
            cpf.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (telefone.getText().toString().isEmpty()) {
            telefone.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (rua.getText().toString().isEmpty()) {
            rua.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (bairro.getText().toString().isEmpty()) {
            bairro.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (complemento.getText().toString().isEmpty()) {
            complemento.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (numero.getText().toString().isEmpty()) {
            numero.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (cidade.getText().toString().isEmpty()) {
            cidade.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }
        if (estado.getText().toString().isEmpty()) {
            estado.setError("Preencha este Campo");
            retorno = false;
        } else {
            retorno = true;
        }if(nacionalidade.getText().toString().isEmpty()) {
            nacionalidade.setError("Preencha este Campo");
            retorno = false;
        }else{
            retorno = true;
        }if(diploma.getText().toString().isEmpty()) {
            diploma.setError("Preencha este Campo");
            retorno = false;
        }else{
            retorno = true;
        }if(sexo.getText().toString().isEmpty()) {
            sexo.setError("Preencha este Campo");
            retorno = false;
        }else{
            retorno = true;
        }if(reservista.getText().toString().isEmpty()) {
            reservista.setError("Preencha este Campo");
            retorno = false;
        }else{
            retorno = true;
        }if(curriculoLattes.getText().toString().isEmpty()) {
            curriculoLattes.setError("Preencha este Campo");
            retorno = false;
        }else{
            retorno = true;
        }if(declaracao.getText().toString().isEmpty()) {
            declaracao.setError("Preencha este Campo");
            retorno = false;
        }else{
            retorno = true;
        }if(certificados.getText().toString().isEmpty()) {
            certificados.setError("Preencha este Campo");
            retorno = false;
        }else{
            retorno = true;
        }

        return retorno;
    }

    public void criaInscricao() {

        BusinessInscricao acessoDao = new BusinessInscricao();

        String nomeString = nome.getText().toString();
        String sobrenomeString = sobrenome.getText().toString();
        String emailString = email.getText().toString();
        String rgString = rg.getText().toString();
        String cpfString = cpf.getText().toString();
        Endereco endereco = new Endereco(rua.getText().toString(), numero.getText().toString(), complemento.getText().toString(), bairro.getText().toString(),
                cidade.getText().toString(), estado.getText().toString());
        respostas = new Formulario(nomeString,sobrenomeString,emailString,rgString,cpfString,telefone.getText().toString(),endereco,nacionalidade.getText().toString()
                ,reservista.getText().toString(),sexo.getText().toString(),diploma.getText().toString(),curriculoLattes.getText().toString(),declaracao.getText().toString()
                ,certificados.getText().toString());
        try {
            Inscricao insc = new Inscricao(respostas);
            acessoDao.create(insc);

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "O sistema n\u00e3o conseguiu salvar a Inscri\u00e7\u00e3o, tente novamente mais tarde.", Toast.LENGTH_SHORT);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inscricao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_salvar) {
            //salva e volta ao menu.
            if(validarDados()){
                ComprovantePosGrad comprovantePosGrad = new ComprovantePosGrad();
                criaInscricao();
                Toast.makeText(getApplicationContext(),comprovantePosGrad.geraComprovante(respostas), Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(getApplicationContext(), "NÃO SALVOU", Toast.LENGTH_SHORT).show();
            }
        }
        if(id == R.id.action_cancelar){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
