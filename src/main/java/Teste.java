import configuracao.Configuracao;
import model.Pessoa;
import service.Gerador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) throws IOException {

        ArrayList<String> cabecalho = new ArrayList<>();
        cabecalho.add("nome");
        cabecalho.add("email");
        cabecalho.add("telefone");

        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa p = new Pessoa();
        p.setNome("David");
        p.setEmail("david@gmail.com");
        p.setTelefone("33946018");
        pessoas.add(p);

        Pessoa p1 = new Pessoa();
        p1.setNome("David");
        p1.setEmail("david@gmail.com");
        p1.setTelefone("33946018");
        pessoas.add(p1);

        new Configuracao().configuracao("planilhaCaixaaa.xlsx", "Avaliação serviço", cabecalho, pessoas);
        new Gerador();
    }
}
