package hxq.pt.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by banlen on 2017/4/14.
 */
@WebServlet(name = "TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        if (path.contains("test/queryex")){
            doJsonEx(request,response);
        }else {
            doJson(request,response);
        }
    }

    private void doJson(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String strMs = request.getParameter("ms");
        int ms = 0;
        if (strMs != null){
            try {
                ms = Integer.parseInt(strMs);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String strNow = df.format(new Date()); //获取当前系统时间
        PrintWriter pw = response.getWriter();
        pw.write(strNow);
    }

    private void doJsonEx(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String strMs = request.getParameter("ms");
        int ms = 0;
        if (strMs != null){
            try {
                ms = Integer.parseInt(strMs);
                Thread.sleep(ms);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String strNow = df.format(new Date()); //获取当前系统时间
        String result ="{\"nowtime\":\""+ strNow +"\",\"ms\":"+ms+"}";
        response.setContentType("application/json; charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(result);
    }

}
