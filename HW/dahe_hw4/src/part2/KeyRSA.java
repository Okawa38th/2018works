package part2;

import java.math.BigInteger;

public abstract class KeyRSA {
    private BigInteger n;

    public KeyRSA(BigInteger N){
        n = N;
    }


    public BigInteger getN() {
        return n;
    }

    public abstract void ownKey(KeyRSA key);
}
