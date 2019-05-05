package part2;

import java.math.BigInteger;
import java.security.SecureRandom;

public class KeyPairGeneratorRSA {
    private  BigInteger n;
    private  BigInteger num;
    private  BigInteger one;
    private  BigInteger p;
    private  BigInteger q;
    private  BigInteger e;
    private  BigInteger d;
    private int Keysize;

    public KeyPairGeneratorRSA(int keysize){
        Keysize = keysize;
    }

    public KeyPairRSA generateKeyPair(){
        p = new BigInteger(Keysize,100, new SecureRandom());
        q = new BigInteger(Keysize,100, new SecureRandom());
        one = new BigInteger("1");
        n = p.multiply(q);
        num = (p.subtract(one)).multiply(q.subtract(one));
        e = new BigInteger(Keysize-1,100,new SecureRandom());
        while(!(e.gcd(num)).equals(one)){
            e = new BigInteger(Keysize-1,100,new SecureRandom());
        }
        d = e.modPow(one.negate(),num);
        KeyPairRSA temp = new KeyPairRSA(d,n,e);
        return temp;
    }

}
