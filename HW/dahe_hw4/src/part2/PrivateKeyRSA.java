package part2;

import java.math.BigInteger;
import java.security.SecureRandom;

public class PrivateKeyRSA extends KeyRSA {
    private BigInteger d;
    private BigInteger n;
    static BigInteger decryptnum;

    public PrivateKeyRSA(BigInteger N,BigInteger D){
        super(N);
        n = N;
        d = D;
    }


    public String decrypt(BigInteger cipherInt){
        decryptnum = cipherInt.modPow(d,n);
        String plaintext = new String(decryptnum.toByteArray());
        return  plaintext;
    }



    public void ownKey(KeyRSA key){
        n = key.getN();
    }


    public String toString(){
        return "KR:" + " {" + d +", " + n + "}";
    }
}
