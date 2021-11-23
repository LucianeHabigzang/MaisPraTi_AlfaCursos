/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Curso;
import Model.CursoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luciane Cunha
 */
public class CursosController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Metodo GET");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        crudCurso(request, response);
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //faz alguma coisa
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //faz alguma coisa
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
   
    protected void crudCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String msg = "";
        String exc = request.getParameter("excluir");
        try 
        {
           
            String id = request.getParameter("codigo");
            String nom = request.getParameter("nome");
            String des = request.getParameter("descricao");
            String resumo = request.getParameter("resumo");
            String val = request.getParameter("valor");
            
            Curso c1 = new Curso();
            
            c1.setNome(nom);
            c1.setDescricao(des);
            c1.setResumo(resumo);
            c1.setValor(Float.parseFloat(val));
            
            CursoDAO dao = new CursoDAO();
            
            
            
            if( exc.equalsIgnoreCase("excluir")) {
                c1.setCodigo(Long.parseLong(id));
                dao.excluir(c1);
            } else {
                if(id.equalsIgnoreCase("")) {
                    dao.inserir(c1);
                } else {
                    c1.setCodigo(Long.parseLong(id));
                    dao.atualizar(c1);
                }
            }
        }
        catch(Exception e) {
            msg = "bug catch" + e;
        }
        
        response.sendRedirect("admCursos.jsp?msg="+msg);
    }
    
    protected void listarCursos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("Sem implementação ainda... aguarde");
        } finally {
            out.close();
        }
    }

}
