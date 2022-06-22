import Database.Commercial;
import Database.MongoDBProduct;
import Database.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ProductOperationServlet", value = "/ProductOperationServlet")
public class ProductOperationServlet extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file ;

    public void init( ){
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session=request.getSession();
        if (session == null || session.getAttribute("name") == null) {
            response.sendRedirect("RedirectServlet");
        }
      else if(action.equalsIgnoreCase("add")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/addproduct.jsp");
            dispatcher.forward(request,response);
        }
       else if(action.equalsIgnoreCase("edit")){
            String pid = request.getParameter("productid");
         Product pro =  MongoDBProduct.MongoGetProduct(pid);


            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/editproduct.jsp");
            dispatcher.forward(request,response);
        }
       else if(action.equalsIgnoreCase("delete")){

            String pid = request.getParameter("productid");
            File f= new File("E:\\MuratStajDosyaları\\ecommerceapp\\src\\main\\webapp\\img\\product_"+pid+".jpg");
            File fTarget =new File("E:\\MuratStajDosyaları\\ecommerceapp\\target\\ecommerceapp\\img\\product_"+ pid+".jpg");
            f.delete();
            fTarget.delete();

            MongoDBProduct.MongoRemoveProduct(pid);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/myproducts.jsp");
            dispatcher.forward(request,response);
        }

       else if(action.equalsIgnoreCase("edit-save")){
            String pid = request.getParameter("productid");
            Commercial comm = (Commercial)session.getAttribute("userObject");

            String sid1 = comm.getId();
            String name = request.getParameter("pname");
            String desc = request.getParameter("desc");
            String price = request.getParameter("price");
            String stock_quantity = request.getParameter("quantity");
            String add_date = request.getParameter("add_date");
            String ex_date = request.getParameter("ex_date");
            String category = request.getParameter("category");

            MongoDBProduct.MongoDBUpdateProduct(pid,sid1,name,desc,price,stock_quantity,add_date,ex_date,category);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/myproducts.jsp");
            dispatcher.forward(request,response);
        }

    }
}
