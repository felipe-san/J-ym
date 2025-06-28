package br.cefet;
import java.util.Random;

import br.cefet.model.Aluno;
import br.cefet.model.Assinatura;
import br.cefet.model.Atendente;
import br.cefet.model.Avaliacao;
import br.cefet.model.Contato;
import br.cefet.model.Documento;
import br.cefet.model.Endereco;
import br.cefet.model.Pessoa;
import br.cefet.model.Plano;
import br.cefet.model.TipoContato;
import br.cefet.model.TipoContrato;
import br.cefet.model.TipoDocumento;
import br.cefet.model.TipoPlano;
import br.cefet.model.TipoTurno;
import br.cefet.model.Treinador;
import br.cefet.view.ScanAtendente;

public class Main {
    
    public static int sortearNumero(String[] nomes){
        Random rand = new Random();
        return rand.nextInt(nomes.length);
    }

    public static void testarPessoa(Pessoa pessoa){
        System.out.printf("\nNome: %s", pessoa.getNome());
        System.out.printf("\nData nascimento: %s", pessoa.getDataNascimento());
        System.out.printf("\nMatricula: %s", pessoa.getMatricula());
        
        System.out.printf("\nGenero: %s", pessoa.getGenero());

        for(Documento documento: pessoa.getDocumentos()){
            System.out.printf("\nTipo de documento: %s - Conteudo: %s", documento.getTipo(), documento.getConteudo());
        }

        for(Contato contato: pessoa.getContatos()){
            System.out.printf("\nTipo de contato: %s - Conteudo: %s", contato.getTipo(), contato.getConteudo());
        }

        System.out.printf("\nEndereço: %s %d %s - %s, %s, %s - CEP: %s", pessoa.getEndereco().getLogradouro(), pessoa.getEndereco().getNumero(), pessoa.getEndereco().getComplemento(), pessoa.getEndereco().getBairro(), pessoa.getEndereco().getCidade(), pessoa.getEndereco().getEstado(), pessoa.getEndereco().getCep());

    }

    public static void main(String[] args){
        ScanAtendente viewAtendente = new ScanAtendente();
        
    }

    
}

