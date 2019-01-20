package service;

import configuracao.Configuracao;
import model.Pessoa;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Gerador {

    public Gerador() throws IOException {

        //CRIANDO ARQUIVO PARA ESCRITA
        FileOutputStream file = new FileOutputStream(new File(Configuracao.nomeArquivo));

        //CRIANDO PASTA DE TRABALHO
        Workbook wb = new HSSFWorkbook();

        //CRIANDO A PLANILHA
        Sheet planilha = wb.createSheet(Configuracao.nomePlanilha);

        Row linha = planilha.createRow(0);
        Cell celula = linha.createCell(0);
        planilha.addMergedRegion(new CellRangeAddress(0, 1, 0,2));
        celula.setCellValue("PLANILHA DE PESSOAS");

        //CRIANDO A LINHA
        Row linha1 = planilha.createRow(2);

        for (int i = 0; i < Configuracao.cabecalho.size(); i++) {
            CellStyle style = wb.createCellStyle();

            Font font = wb.createFont();
            font.setBold(true);
            font.setFontName(HSSFFont.FONT_ARIAL);

            style.setFont(font);

            //CRIANDO A CELULA
            Cell celula1 = linha1.createCell(i);
            celula1.setCellValue(Configuracao.cabecalho.get(i).toUpperCase());

            linha1.getCell(i).setCellStyle(style);
        }

        int i = 3;
        for (Pessoa pessoa: Configuracao.lista) {
            //CRIANDO A LINHA
            Row linha2 = planilha.createRow(i);

            Cell celula2 = linha2.createCell(0);
            celula2.setCellValue(pessoa.getNome());

            Cell celula3 = linha2.createCell(1);
            celula3.setCellValue(pessoa.getEmail());

            Cell celula4 = linha2.createCell(2);
            celula4.setCellValue(pessoa.getTelefone());
            i++;
        }

        //ESCREVENDO O STREAM NO ARQUIVO
        wb.write(file);

        //FECHANDO O ARQUIVO
        file.close();

    }

}
