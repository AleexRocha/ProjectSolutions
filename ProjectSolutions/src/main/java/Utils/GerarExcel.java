package Utils;

import Model.Relatorio;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Alexsander Rocha
 */
public class GerarExcel {

    public static void GerarExcel() {

        DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
        Date now = new Date(System.currentTimeMillis());
        String hora = dateFormat.format(now);
        String fileName = "relatorio_" + hora + ".xls";

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheetAlunos = workbook.createSheet("Relatorio");

        ArrayList<Relatorio> listaRelatorio = new ArrayList<>();
        listaRelatorio.add(new Relatorio(0001, 0001, "Rosa Vermelha do Acre", 0010, 1000.00, 100, "São Paulo - SP", 1234, "16/04/2019"));
        listaRelatorio.add(new Relatorio(0001, 0001, "Rosa Vermelha do Acre", 0010, 1000.00, 100, "São Paulo - SP", 1234, "16/04/2019"));
        listaRelatorio.add(new Relatorio(0001, 0001, "Rosa Vermelha do Acre", 0010, 1000.00, 100, "São Paulo - SP", 1234, "16/04/2019"));
        listaRelatorio.add(new Relatorio(0001, 0001, "Rosa Vermelha do Acre", 0010, 1000.00, 100, "São Paulo - SP", 1234, "16/04/2019"));
        listaRelatorio.add(new Relatorio(0001, 0001, "Rosa Vermelha do Acre", 0010, 1000.00, 100, "São Paulo - SP", 1234, "16/04/2019"));
        listaRelatorio.add(new Relatorio(0001, 0001, "Rosa Vermelha do Acre", 0010, 1000.00, 100, "São Paulo - SP", 1234, "16/04/2019"));
        listaRelatorio.add(new Relatorio(0001, 0001, "Rosa Vermelha do Acre", 0010, 1000.00, 100, "São Paulo - SP", 1234, "16/04/2019"));

        int rowNum = 0;
        for (Relatorio relatorio : listaRelatorio) {
            Row row = sheetAlunos.createRow(rowNum++);
            int cellNum = 0;
            Cell cellCodigoVenda = row.createCell(cellNum++);
            cellCodigoVenda.setCellValue(relatorio.getCodigoVenda());
            Cell cellCodigoProduto = row.createCell(cellNum++);
            cellCodigoProduto.setCellValue(relatorio.getCodigoProduto());
            Cell cellNomeProduto = row.createCell(cellNum++);
            cellNomeProduto.setCellValue(relatorio.getNomeProduto());
            Cell cellQuantidadeProduto = row.createCell(cellNum++);
            cellQuantidadeProduto.setCellValue(relatorio.getQuantidadeProduto());
            Cell cellValorTotal = row.createCell(cellNum++);
            cellValorTotal.setCellValue(relatorio.getValor());
            Cell cellIdFilial = row.createCell(cellNum++);
            cellIdFilial.setCellValue(relatorio.getIdFilial());
            Cell cellNomeFilial = row.createCell(cellNum++);
            cellNomeFilial.setCellValue(relatorio.getNomeFilial());
            Cell cellIdFuncionario = row.createCell(cellNum++);
            cellIdFuncionario.setCellValue(relatorio.getIdFuncionario());
            Cell cellDataVenda = row.createCell(cellNum++);
            cellDataVenda.setCellValue(relatorio.getDataVenda());
        }

        try {
            FileOutputStream saida = new FileOutputStream(new File(fileName));
            workbook.write(saida);
            saida.close();
            System.out.println("Arquivo Excel Gerado com sucesso");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro na edição do arquivo!");
        }
    }
}
