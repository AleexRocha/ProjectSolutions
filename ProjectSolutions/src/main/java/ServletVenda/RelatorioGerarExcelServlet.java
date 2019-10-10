package ServletVenda;

import DAO.RelatorioDAO;
import Model.Relatorio;
import Utils.GerarExcel;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexsander.mrocha
 */
@WebServlet(name = "RelatorioGerarExcelServlet", urlPatterns = {"/venda/gerar_excel"})
public class RelatorioGerarExcelServlet extends HttpServlet {

    private void processaRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dataDe = request.getParameter("dataDe");
        String dataAte = request.getParameter("dataAte");

        if (((dataDe != null) && dataAte != null)) {
            String dataDeFormat = dataDe.concat(" 00:00:00");
            String dataAteFormat = dataAte.concat(" 23:59:59");
            ArrayList<Relatorio> relatorio = RelatorioDAO.getRelatorioData(dataDeFormat, dataAteFormat);
            request.setAttribute("listaRelatorios", relatorio);
            GerarExcel ge = new GerarExcel(relatorio);
        } else {
            ArrayList<Relatorio> relatorio = RelatorioDAO.getRelatorioGeral();
//                request.setAttribute("listaRelatorios", relatorio);
//                GerarExcel ge = new GerarExcel(relatorio);

            DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
            Date now = new Date(System.currentTimeMillis());
            String hora = dateFormat.format(now);
            String fileName = "relatorio_" + hora + ".xls";

            this.sendStringWithName(relatorio, fileName, response);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/venda/relatorio.jsp");
        dispatcher.forward(request, response);
    }

    public void sendStringWithName(ArrayList<Relatorio> send, String name, HttpServletResponse response) throws IOException {
        ArrayList<Relatorio> report = send;
        response.setContentType("application/save");
        response.setContentLength(report.size());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
        response.addHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        ServletOutputStream outputStream = response.getOutputStream();

        byte[] bytes = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        for (Relatorio element : report) {
            bytes = element.toString().getBytes();
        }

        outputStream.write(bytes, 0, report.size());
        outputStream.flush();
        outputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao("GET", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processaRequisicao("POST", req, resp);
    }

}
