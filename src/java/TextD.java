
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import javax.servlet.annotation.WebServlet;




@WebServlet("/TextD")
public class TextD extends HttpServlet  {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
       
        AES a;
        try{
        a = new AES();
        String text = request.getParameter("text");
        String S = a.AESD(text);
        out.println(S);
        }
        catch(Exception e){
        
        }
        
    }
/*public static String Ende(String text) throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		cipher = Cipher.getInstance("AES");

		String plainText = "AES Symmetric Encryption Decryption";
		System.out.println("Plain Text Before Encryption: " + plainText);

		String encryptedText = encrypt(plainText, secretKey);
		System.out.println("Encrypted Text After Encryption: " + encryptedText);

		String decryptedText = decrypt(encryptedText, secretKey);
		System.out.println("Decrypted Text After Decryption: " + decryptedText);
                return encryptedText;
	}*/
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   
   
}
