package part2;


import java.math.BigInteger;

public class KeyPairRSA {
   private PublicKeyRSA pubkey;
   private PrivateKeyRSA prikey;
   private BigInteger d;
   private BigInteger n;
   private BigInteger e;
    public KeyPairRSA(BigInteger D,BigInteger N,BigInteger E){
        d = D;
        n = N;
        e = E;
        pubkey = new PublicKeyRSA(n,e);
        prikey = new PrivateKeyRSA(n,d);

    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }

    public PublicKeyRSA getPublicKey() {
        return pubkey;
    }

    public PrivateKeyRSA getPrivateKey() {
       return prikey;
    }
    public String toString(){
        return pubkey.toString() + '\n'+ prikey.toString();
    }
}
