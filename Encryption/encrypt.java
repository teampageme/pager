import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class encrypt
{
    public static void main(String[] args)
    {

	String msg = args[0];	
	//String msg  = "hello world";
        String pass = "fifa17";

        StandardPBEStringEncryptor cryptor = new StandardPBEStringEncryptor();
        cryptor.setProvider(new BouncyCastleProvider());

        cryptor.setAlgorithm("PBEWITHSHA256AND128BITAES-CBC-BC");
        cryptor.setPassword(pass);

        String encrypted = cryptor.encrypt(msg);

        System.out.println(msg);
        System.out.println(encrypted);

    }
}

