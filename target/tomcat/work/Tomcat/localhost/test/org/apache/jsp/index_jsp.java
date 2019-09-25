/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-09-25 20:02:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Tomcat WebSocket</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <form>\r\n");
      out.write("        <input id=\"message\" type=\"text\">\r\n");
      out.write("        <input onclick=\"wsSendMessage();\" value=\"Echo\" type=\"button\">\r\n");
      out.write("        <input onclick=\"wsCloseConnection();\" value=\"Disconnect\" type=\"button\">\r\n");
      out.write("    </form>\r\n");
      out.write("    <br>\r\n");
      out.write("    <textarea id=\"echoText\" rows=\"10\" cols=\"80\"></textarea>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        var webSocket = new WebSocket(\"ws://localhost:8080/test/websocketendpoint\");\r\n");
      out.write("        var echoText = document.getElementById(\"echoText\");\r\n");
      out.write("        echoText.value = \"\";\r\n");
      out.write("        var message = document.getElementById(\"message\");\r\n");
      out.write("        webSocket.onopen = function(message){ wsOpen(message);};\r\n");
      out.write("        webSocket.onmessage = function(message){ wsGetMessage(message);};\r\n");
      out.write("        webSocket.onclose = function(message){ wsClose(message);};\r\n");
      out.write("        webSocket.onerror = function(message){ wsError(message);};\r\n");
      out.write("        function wsOpen(message){\r\n");
      out.write("            echoText.value += \"Connected ... \\n\";\r\n");
      out.write("        }\r\n");
      out.write("        function wsSendMessage(){\r\n");
      out.write("            webSocket.send(message.value);\r\n");
      out.write("            echoText.value += \"Message sent to the server : \" + message.value + \"\\n\";\r\n");
      out.write("            message.value = \"\";\r\n");
      out.write("        }\r\n");
      out.write("        function wsCloseConnection(){\r\n");
      out.write("            webSocket.close();\r\n");
      out.write("        }\r\n");
      out.write("        function wsGetMessage(message){\r\n");
      out.write("            if(message.data == \"JSON syntax exception occurred.\"){\r\n");
      out.write("                echoText.value += \"Server responded: \" + message.data + \"\\n\";\r\n");
      out.write("            }else{\r\n");
      out.write("                var object = JSON.parse(message.data);\r\n");
      out.write("                echoText.value += \"Server responded: \\n\"\r\n");
      out.write("                    + \"\\tname:       \" + object.name + \"\\n\"\r\n");
      out.write("                    + \"\\toccupation: \" + object.occupation + \"\\n\"\r\n");
      out.write("                    + \"\\tresponse:   \" + object.response + \"\\n\";\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        function wsClose(message){\r\n");
      out.write("            echoText.value += \"Disconnect ... \\n\";\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function wsError(message){\r\n");
      out.write("            echoText.value += \"Error ... \\n\";\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
