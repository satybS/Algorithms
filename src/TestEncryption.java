import javax.crypto.Cipher;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


//https://stackoverflow.com/questions/11410770/load-rsa-public-key-from-file
//https://stackoverflow.com/questions/5244129/use-rsa-private-key-to-generate-public-key

public class TestEncryption {


    public static void main(String[] args) throws Exception {
        byte[] encrypted = encrypt("This is a secret message");
        System.out.println(new String(decrypt(encrypted)));

    }

    public static byte[] encrypt(String message) throws Exception {
        String keyPath = "/home/sanzhar/Downloads/private_key.der";
        File privKeyFile = new File(keyPath);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(privKeyFile));
        byte[] privKeyBytes = new byte[(int) privKeyFile.length()];
        bis.read(privKeyBytes);
        bis.close();
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        KeySpec ks = new PKCS8EncodedKeySpec(privKeyBytes);
        PrivateKey privateKey = (PrivateKey) keyFactory.generatePrivate(ks);
        byte[] encrypted = encrypt(privateKey, message);
        return encrypted;

    }

    public static byte[] decrypt(byte[] encrypted) throws Exception {
        String keyPath = "/home/sanzhar/Downloads/public_key.der";
        byte[] keyBytes = Files.readAllBytes(Paths.get(keyPath));

        X509EncodedKeySpec spec =
                new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey publicKey = kf.generatePublic(spec);
        return decrypt(publicKey, encrypted);
    }


    public static byte[] encrypt(PrivateKey privateKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(message.getBytes());
    }

    public static byte[] decrypt(PublicKey publicKey, byte[] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        return cipher.doFinal(encrypted);
    }
}
