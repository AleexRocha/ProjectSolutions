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

    public static void GerarExcel(ArrayList relatorio) {

        DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
        Date now = new Date(System.currentTimeMillis());
        String hora = dateFormat.format(now);
        String fileName = "relatorio_" + hora + ".xls";

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheetAlunos = workbook.createSheet("Relatorio");

        ArrayList<Relatorio> listaRelatorio = relatorio;

        int rowNum = 0;
        for (Relatorio itemRelatorio : listaRelatorio) {
            Row row = sheetAlunos.createRow(rowNum++);
            int cellNum = 0;

            Cell cellCodigoVenda = row.createCell(cellNum++);
            cellCodigoVenda.setCellValue(itemRelatorio.getCodigoVenda());
            Cell cellNomeProduto = row.createCell(cellNum++);
            cellNomeProduto.setCellValue(itemRelatorio.getNomeProduto());
            Cell cellCodigoProduto = row.createCell(cellNum++);
            cellCodigoProduto.setCellValue(itemRelatorio.getCodigoProduto());
            Cell cellQuantidadeProduto = row.createCell(cellNum++);
            cellQuantidadeProduto.setCellValue(itemRelatorio.getQuantidadeProduto());
            Cell cellValorTotal = row.createCell(cellNum++);
            cellValorTotal.setCellValue(itemRelatorio.getValorTotal());
            Cell cellCpfCliente = row.createCell(cellNum++);
            cellCpfCliente.setCellValue(itemRelatorio.getCpfCliente());
            Cell cellIdFilial = row.createCell(cellNum++);
            cellIdFilial.setCellValue(itemRelatorio.getIdFilial());
            Cell cellNomeFilial = row.createCell(cellNum++);
            cellNomeFilial.setCellValue(itemRelatorio.getNomeFilial());
            Cell cellIdUsuario = row.createCell(cellNum++);
            cellIdUsuario.setCellValue(itemRelatorio.getIdUsuario());
            Cell cellDataVenda = row.createCell(cellNum++);
            cellDataVenda.setCellValue(itemRelatorio.getDataVenda());
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
