package configuracao;

import model.Pessoa;

import java.util.List;

public class Configuracao {

    public static String nomeArquivo;
    public static String nomePlanilha;
    public static List<String> cabecalho;
    public static List<Pessoa> lista;

    public void configuracao(String nomeArquivo, String nomePlanilha, List<String> cabecalho, List<Pessoa> lista){
        this.nomeArquivo = nomeArquivo;
        this.nomePlanilha = nomePlanilha;
        this.cabecalho = cabecalho;
        this.lista = lista;
    }
}
