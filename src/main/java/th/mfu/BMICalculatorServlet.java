package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        double weight =Double.parseDouble(request.getParameter("weight"));
        double height =Double.parseDouble(request.getParameter("height"));
        //TODO: calculate bmi
        double BMI = Math.round(weight/(height*height)*100)/100;

        //TODO: determine the built from BMI
        
        String BmiInfo=null;
        if (BMI < 18.5){
            BmiInfo = "underweight";

      }else if(BMI >= 18.5 && BMI <25){
           BmiInfo = " normal";

      }else if (BMI >=25 && BMI<30){
            BmiInfo = " overweight";

      }else if(BMI >=30 && BMI <35){
           BmiInfo= " obese";

      }else if (BMI>=35){
            BmiInfo = "extremely obese";

      }
        //TODO: add bmi and built to the request's attribute
      request.setAttribute("BMI", BMI);
      request.setAttribute("BmiInfo", BmiInfo);
        //TODO: forward to jsp
           request.getRequestDispatcher("/bmi_result.jsp").forward(request,response);
    }
    
}
