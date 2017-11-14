package Servlets; 

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author strel
 */
@WebServlet(name = "Calculator_1", urlPatterns = {"/calc_1"})
public class Calculator_1 extends HttpServlet{

    @Override
    public void init() throws ServletException {
        super.init(); 
        System.out.println("Servlet \"Calculator_1\" initialization is completed.");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet \"Calculator_1\" is destroyed.");
        super.destroy(); 
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp); 
        System.out.println("Servlet \"Calculator_1\" is serviced.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet \"Calculator\" accepted GET request.");
        resp.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = resp.getWriter()){
            //Определяем массив возможных кнопок калькулятора
            String[] actions = {"btn_pls", "btn_mns", "btn_dvd", "btn_mlt", "btn_exp",
                                "btn_bin", "btn_oct", "btn_hex"};
            boolean error = false; //флаг возникновения ошибок
            String errorMsg = ""; //сообщение об ошибке
            String result = ""; //результат вычислений
            
            //проверяем пришли ли нам параметры a и b для вычисления
            //и проверяем на совпадение регулярному выражению: 
            //положит или отриц число, если типа float, то разделено или точкой, или запятой
            if (req.getParameter("a") != null && req.getParameterValues("a")[0] != "" &&
                    req.getParameter("b") != null && req.getParameterValues("b")[0] != "" &&
                    req.getParameter("a").matches("^[+-]?\\d+(?:[\\.,]\\d+)?$") && 
                    req.getParameter("b").matches("^[+-]?\\d+(?:[\\.,]\\d+)?$") ){
                
                //получаем всю строку запроса
                String query = req.getQueryString();
                int index = -1;
                //содержит ли строка запроса одну из кнопок из массива
                //определяем номер символа, с которого начинается название кнопки
                for (String btn : actions) {
                    index = query.lastIndexOf(btn);
                    if (index != -1)
                        break;
                }
                
                if (index != -1) {
                    
                    //обрезаем строку запроса, получая название операции для калькулятора
                    query = query.substring(index, index + actions[0].length());
                    float a = Float.valueOf(req.getParameter("a").replace(",", "."));
                    float b = Float.valueOf(req.getParameter("b").replace(",", "."));
                    float tmp;
                    
                    switch(query){
                        case "btn_pls":
                            tmp = a + b;
                            result = Float.toString(tmp);
                            break;
                        case "btn_mns":
                            tmp = a - b;
                            result = Float.toString(tmp);
                            break;
                        case "btn_dvd":
                            if (b == 0)
                                result += "Division by zero";
                            else{
                                tmp = a / b;
                                result = Float.toString(tmp);
                            }
                            break;
                        case "btn_mlt":
                            tmp = a * b;
                            result = Float.toString(tmp);
                            break;
                        case "btn_exp":
                            tmp = (float)Math.pow(a, b);
                            result = Float.toString(tmp);
                            break;
                        case "btn_bin":
                            result += Integer.toBinaryString((int)a) + " | " + Integer.toBinaryString((int)b);
                            break;
                        case "btn_oct":
                            result += Integer.toOctalString((int)a) + " | " + Integer.toOctalString((int)b);
                            break;
                        case "btn_hex":
                            result += Integer.toHexString((int)a) + " | " + Integer.toHexString((int)b);
                            break;
                        default:
                           error = true;
                           errorMsg = "Incorrect operation.";
                    }
                } 
                else {
                    error = true; 
                    errorMsg = "Incorrect operation.";
                } 
            }
            else {
                error = true;
                errorMsg = "Incorrect input values.";
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            if (error) 
                out.println("<h1>Error: " + errorMsg + "</h1>");
            else
                out.println("<h1>Answer: " + result + "</h1>");
            out.println("<b><a href=\"index_1.jsp\">Back to calculator</a></b>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
