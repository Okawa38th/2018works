package part2;

import java.math.BigInteger;

public class PublicKeyRSA extends KeyRSA {
    private BigInteger e;
    private BigInteger n;
    private BigInteger plaintextnumerically;
    private  KeyPairRSA keypair;

    public  PublicKeyRSA(BigInteger N,BigInteger E){
        super(N);
        n = N;
        e = E;
    }


    public void ownKey(KeyRSA key){

    }
    public  BigInteger encrypt(String plaintext){
        plaintextnumerically = new BigInteger(plaintext.getBytes());
        if(plaintextnumerically.compareTo(n)!=-1){
            return n;
        }else {
            BigInteger a = plaintextnumerically.modPow(e, n);
            return a;
        }
    }
    public BigInteger getE() {
        return e;
    }

    public String toString(){
        return "KU"+" {" + getE() +","+ getN() + "}";
    }
}
