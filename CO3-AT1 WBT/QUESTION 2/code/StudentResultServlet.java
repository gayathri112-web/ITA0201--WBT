package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentResultServlet")
public class StudentResultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Read form values
        String name = request.getParameter("name");
        String registerNumber = request.getParameter("registerNumber");
        String mark1String = request.getParameter("mark1");
        String mark2String = request.getParameter("mark2");
        String mark3String = request.getParameter("mark3");

        // Validate missing values
        if (name == null || name.trim().isEmpty()
                || registerNumber == null || registerNumber.trim().isEmpty()
                || mark1String == null || mark1String.trim().isEmpty()
                || mark2String == null || mark2String.trim().isEmpty()
                || mark3String == null || mark3String.trim().isEmpty()) {

            out.println("<html>");
            out.println("<body>");
            out.println("<h2 style='color:red;'>Error: All fields are required.</h2>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        try {

            // Convert marks to integers
            int mark1 = Integer.parseInt(mark1String);
            int mark2 = Integer.parseInt(mark2String);
            int mark3 = Integer.parseInt(mark3String);

            // Validate marks
            if (mark1 < 0 || mark1 > 100
                    || mark2 < 0 || mark2 > 100
                    || mark3 < 0 || mark3 > 100) {

                out.println("<html>");
                out.println("<body>");
                out.println("<h2 style='color:red;'>Error: Marks must be between 0 and 100.</h2>");
                out.println("</body>");
                out.println("</html>");

                return;
            }

            // Calculations
            int total = mark1 + mark2 + mark3;

            double average = total / 3.0;

            int highest = Math.max(mark1, Math.max(mark2, mark3));

            // Pass / Fail
            String status;

            if (mark1 >= 40 && mark2 >= 40 && mark3 >= 40) {
                status = "PASS";
            } else {
                status = "FAIL";
            }

            // Start HTML
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");

            out.println("<meta charset='UTF-8'>");

            out.println("<title>Student Result</title>");

            // CSS
            out.println("<style>");

            out.println("body {");
            out.println("font-family: Arial, sans-serif;");
            out.println("margin: 0;");
            out.println("padding: 30px;");
            out.println("background: linear-gradient(135deg, #667eea, #764ba2);");
            out.println("min-height: 100vh;");
            out.println("display: flex;");
            out.println("justify-content: center;");
            out.println("align-items: center;");
            out.println("}");

            out.println(".result-card {");
            out.println("background: white;");
            out.println("width: 500px;");
            out.println("padding: 35px;");
            out.println("border-radius: 20px;");
            out.println("box-shadow: 0 15px 40px rgba(0,0,0,0.25);");
            out.println("}");

            out.println("h1 {");
            out.println("text-align: center;");
            out.println("color: #333;");
            out.println("margin-bottom: 5px;");
            out.println("}");

            out.println(".subtitle {");
            out.println("text-align: center;");
            out.println("color: #777;");
            out.println("margin-bottom: 25px;");
            out.println("}");

            out.println(".student-info {");
            out.println("background: #f5f7ff;");
            out.println("padding: 15px;");
            out.println("border-radius: 10px;");
            out.println("margin-bottom: 20px;");
            out.println("}");

            out.println(".row {");
            out.println("display: flex;");
            out.println("justify-content: space-between;");
            out.println("padding: 10px 5px;");
            out.println("border-bottom: 1px solid #ddd;");
            out.println("}");

            out.println(".result-box {");
            out.println("margin-top: 20px;");
            out.println("background: #fafafa;");
            out.println("padding: 15px;");
            out.println("border-radius: 10px;");
            out.println("}");

            out.println(".pass {");
            out.println("color: #006400;");
            out.println("font-weight: bold;");
            out.println("font-size: 22px;");
            out.println("}");

            out.println(".fail {");
            out.println("color: #d00000;");
            out.println("font-weight: bold;");
            out.println("font-size: 22px;");
            out.println("}");

            out.println(".back-button {");
            out.println("display: block;");
            out.println("text-align: center;");
            out.println("margin-top: 25px;");
            out.println("padding: 12px;");
            out.println("background: #667eea;");
            out.println("color: white;");
            out.println("text-decoration: none;");
            out.println("border-radius: 8px;");
            out.println("font-weight: bold;");
            out.println("}");

            out.println("</style>");

            out.println("</head>");

            out.println("<body>");

            out.println("<div class='result-card'>");

            out.println("<h1>🎓 Student Result</h1>");

            out.println("<p class='subtitle'>Result Processing Summary</p>");

            // Student information
            out.println("<div class='student-info'>");

            out.println("<div class='row'>");
            out.println("<b>Name</b>");
            out.println("<span>" + name + "</span>");
            out.println("</div>");

            out.println("<div class='row'>");
            out.println("<b>Register Number</b>");
            out.println("<span>" + registerNumber + "</span>");
            out.println("</div>");

            out.println("</div>");

            // Marks and result
            out.println("<div class='result-box'>");

            out.println("<div class='row'>");
            out.println("<b>Subject 1</b>");
            out.println("<span>" + mark1 + "</span>");
            out.println("</div>");

            out.println("<div class='row'>");
            out.println("<b>Subject 2</b>");
            out.println("<span>" + mark2 + "</span>");
            out.println("</div>");

            out.println("<div class='row'>");
            out.println("<b>Subject 3</b>");
            out.println("<span>" + mark3 + "</span>");
            out.println("</div>");

            out.println("<div class='row'>");
            out.println("<b>Total</b>");
            out.println("<span>" + total + "</span>");
            out.println("</div>");

            out.println("<div class='row'>");
            out.println("<b>Average</b>");
            out.println("<span>" + String.format("%.2f", average) + "</span>");
            out.println("</div>");

            out.println("<div class='row'>");
            out.println("<b>Highest Mark</b>");
            out.println("<span>" + highest + "</span>");
            out.println("</div>");

            out.println("</div>");

            // Pass / Fail
            if (status.equals("PASS")) {

                out.println("<p class='pass' style='text-align:center;'>");
                out.println("✓ PASS");
                out.println("</p>");

            } else {

                out.println("<p class='fail' style='text-align:center;'>");
                out.println("✗ FAIL");
                out.println("</p>");
            }

            // Back button
            out.println("<a class='back-button' href='index.html'>");
            out.println("← Back to Form");
            out.println("</a>");

            out.println("</div>");

            out.println("</body>");
            out.println("</html>");

        } catch (NumberFormatException e) {

            out.println("<html>");
            out.println("<body>");

            out.println("<h2 style='color:red;'>");
            out.println("Error: Please enter valid numeric marks.");
            out.println("</h2>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}