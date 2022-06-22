import Database.Commercial;
import Database.MongoDBProduct;
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
import java.nio.file.Files;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import com.oreilly.servlet.MultipartRequest;

@WebServlet(name = "FileUploadServlet", value = "/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file ;

    public void init( ){
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
            HttpSession session = request.getSession();
        MultipartRequest m = new MultipartRequest(request, "E:\\MuratStajDosyaları\\ecommerceapp\\src\\main\\webapp\\img");
        Commercial comm = (Commercial)session.getAttribute("userObject");
              String sid1 = comm.getId();
             String name = m.getParameter("pname");
              String desc = m.getParameter("desc");
            String price = m.getParameter("price");
              String stock_quantity = m.getParameter("quantity");
              String add_date = m.getParameter("add_date");
              String ex_date = m.getParameter("ex_date");
        String category = m.getParameter("category");
        String pid= "";
        String action = m.getParameter("action");
        if(action.equalsIgnoreCase("add-save")){
            pid = MongoDBProduct.mongoInsert(sid1,name,desc,price,stock_quantity,add_date,ex_date,category);
        }
        else if(action.equalsIgnoreCase("edit-save")){
            pid = m.getParameter("productid");
            MongoDBProduct.MongoDBUpdateProduct(pid,sid1,name,desc,price,stock_quantity,add_date,ex_date,category);
        }

        File o=m.getFile("image");
        File n=new File("E:\\MuratStajDosyaları\\ecommerceapp\\src\\main\\webapp\\img\\product_"+ pid+".jpg");
        File nTarget =new File("E:\\MuratStajDosyaları\\ecommerceapp\\target\\ecommerceapp\\img\\product_"+ pid+".jpg");
        n.delete();
        o.renameTo(n);
        System.out.println(m.getOriginalFileName("image")+"this is after originalfilename, new N:"+o.getPath()+" "+n.getPath());
        try {
        Files.copy(n.toPath(), nTarget.toPath());
        } catch (IOException ex) {
            nTarget.delete();
            Files.copy(n.toPath(), nTarget.toPath());
        }

      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-seller/myproducts.jsp");
       dispatcher.forward(request,response);
    }
}




