import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.sql.*;

public class RSAEncryptionDecryption {
   
    
    public static void Gen(String email) throws IOException {
		Base64.Encoder encoder = Base64.getEncoder();
                Base64.Decoder decoder = Base64.getDecoder();

		try {
			System.out.println("-------GENRATE PUBLIC and PRIVATE KEY-------------");
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(512); //1024 used for normal securities
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			System.out.println("Public Key - " + publicKey);
			System.out.println("Private Key - " + privateKey);
                        //Pullingout parameters which makes up Key
			System.out.println("\n------- PULLING OUT PARAMETERS WHICH MAKES KEYPAIR----------\n");
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			RSAPublicKeySpec rsaPubKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
			RSAPrivateKeySpec rsaPrivKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);
                        BigInteger puMod = rsaPubKeySpec.getModulus();
                        BigInteger puExp = rsaPubKeySpec.getPublicExponent();
                        BigInteger prMod = rsaPrivKeySpec.getModulus();
                        BigInteger prExp = rsaPrivKeySpec.getPrivateExponent();
			String spuMod = puMod.toString();
                        String spuExp = puExp.toString();
                        String sprMod = prMod.toString();
                        String sprExp = prExp.toString();
                        System.out.println("\n"+puMod+"\n"+puExp+"\n"+prMod+"\n"+prExp);
                        
                         BigInteger rpuMod = new BigInteger(spuMod);
                        BigInteger rpuExp = new BigInteger(spuExp);
                        KeyFactory keyFactory1 = KeyFactory.getInstance("RSA");
			RSAPublicKeySpec rsaPubKeySpec1 = new RSAPublicKeySpec(rpuMod, rpuExp);
                        PublicKey pk = keyFactory1.generatePublic(rsaPubKeySpec1);
                        System.out.println("\nPublic Key regenerated - " + pk+"\n");
                        
                         BigInteger rprMod = new BigInteger(sprMod);
                        BigInteger rprExp = new BigInteger(sprExp);
                        KeyFactory keyFactory2 = KeyFactory.getInstance("RSA");
			RSAPrivateKeySpec rsaPrivateKeySpec1 = new RSAPrivateKeySpec(rprMod, rprExp);
                        PrivateKey prk = keyFactory2.generatePrivate(rsaPrivateKeySpec1);
                        System.out.println("\nPrivate Key regenerated - " + prk+"\n");
                        int length = sprMod.length();
			System.out.println("\nPrivate Key regenerated length - " +length+"\n");
                        try{
                            
                                 

    //loading drivers for mysql
    Class.forName("com.mysql.jdbc.Driver");

//creating connection with the database
      Connection  con=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/auth","root","");

    PreparedStatement ps=con.prepareStatement
              ("insert into ky values(?,?,?,?,?)");
                ps.setString(1,email);
                ps.setString(2,spuMod);
                ps.setString(3,spuExp);  
                ps.setString(4,sprMod);
                ps.setString(5,sprExp);
               System.out.println("\n Agaya Mysql me\n");
               System.out.println("\n"+email+"\n");
               System.out.println("\n"+spuMod+"\n");
               System.out.println("\n"+spuExp+"\n");
               System.out.println("\n"+sprMod+"\n");
               System.out.println("\n"+sprExp+"\n");
                ps.executeUpdate();

                        }
                        catch(Exception e){
                        }
			
			//Share public key with other so they can encrypt data and decrypt thoses using private key(Don't share with Other
			RSAEncryptionDecryption rsaObj = new RSAEncryptionDecryption();
			
			
			//Encrypt Data using Public Key
			byte[] encryptedData = rsaObj.encryptData("Anuj Patel - Classified Information !",pk);
			
			//Descypt Data using Private Key
			rsaObj.decryptData(encryptedData,prk);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}

	}
	
	
	private byte[] encryptData(String data, PublicKey publicKey) throws IOException {
		System.out.println("\n----------------ENCRYPTION STARTED------------");
		
		System.out.println("Data Before Encryption :" + data);
		byte[] dataToEncrypt = data.getBytes();
		byte[] encryptedData = null;
		try {
			PublicKey pubKey = publicKey;
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			encryptedData = cipher.doFinal(dataToEncrypt);
			System.out.println("Encryted Data: " + encryptedData);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		System.out.println("----------------ENCRYPTION COMPLETED------------");		
		return encryptedData;
	}

	/**
	 * Encrypt Data
	 * @param data
	 * @throws IOException
	 */
	private void decryptData(byte[] data, PrivateKey privateKey) throws IOException {
		System.out.println("\n----------------DECRYPTION STARTED------------");
		byte[] descryptedData = null;
		
		try {
			PrivateKey privateKey1 = privateKey;
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey1);
			descryptedData = cipher.doFinal(data);
			System.out.println("Decrypted Data: " + new String(descryptedData));
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		System.out.println("----------------DECRYPTION COMPLETED------------");		
	}
	public BigInteger pum(){
            BigInteger b=new BigInteger("");
            
            return b;
        }
        

}
