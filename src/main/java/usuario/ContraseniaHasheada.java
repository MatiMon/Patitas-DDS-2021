package usuario;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class ContraseniaHasheada {
  private byte[] hash;
  private byte[] salt = new byte[16];
  private int iteraciones = 10000;
  private int longitud = 256;

  public ContraseniaHasheada(String contrasenia) throws NoSuchAlgorithmException, InvalidKeySpecException {
    generarSaltRandom();
    this.hash = generarHashPBKDF2(contrasenia);

  }

  private void generarSaltRandom() {
    //SecureRandom es una clase que provee un generador criptograficamente fuerte de numeros aleatorios
    SecureRandom random = new SecureRandom();
    //nextBytes recibe un numero de bytes y devuelve (en esa variable que recibio por parametro) un numero aleatorio de esa cantidad de bytes
    random.nextBytes(this.salt);
  }

  private byte[] generarHashPBKDF2(String contrasenia) throws NoSuchAlgorithmException, InvalidKeySpecException {
    KeySpec key = new PBEKeySpec(contrasenia.toCharArray(), this.salt, this.iteraciones, this.longitud);
    //https://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#SecretKeyFactory
    //documentacion de los nombres estandarizados de los algoritmos que recibe la clase SecretKeyFactory
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    return factory.generateSecret(key).getEncoded();
  }

  public boolean hashMatch(String contrasenia) throws NoSuchAlgorithmException, InvalidKeySpecException {
    return Arrays.equals(this.hash, generarHashPBKDF2(contrasenia));
  }
}
