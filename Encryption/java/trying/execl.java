import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class execl
{
    public static void main(String[] args)
    {

        String encrypted = "Brbrs/4wqWkR78rRrB8jvT/GaPMsd5fVLS14j6Ex9DM=";
        //String encrypted = args[0];
        String pass = "fifa17";

        StandardPBEStringEncryptor cryptor = new StandardPBEStringEncryptor();
        cryptor.setProvider(new BouncyCastleProvider());

        cryptor.setAlgorithm("PBEWITHSHA256AND128BITAES-CBC-BC");
        cryptor.setPassword(pass);

        String decrpted = cryptor.decrypt((encrypted));

        System.out.println(encrypted);
        System.out.println(decrpted);
    }
}
