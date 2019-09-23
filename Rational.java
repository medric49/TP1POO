/**
 * Rational, classe représentant les nombres rationnels
 * @author Medric
 * 2019
 */

public class Rational {
    /**Numérateur */
    private int num;
    /**Dénominateur */
    private int denom;

    /**
     * Rational, constructeur de la classe
     * @param num La valeur du numérateur
     * @param denom La valeur du dénominateur
     * @throws RuntimeException
     */
    public Rational(int num, int denom) throws RuntimeException {
        if(denom != 0) {
            if( pgcd(num, denom) != 1)
                throw new RuntimeException("La fraction est réductible");
            else {
                this.num = num;
                this.denom = denom;
            }
        }
        else
            throw new RuntimeException("Le dénomitateur est nul");
         
    }

    /**
     * Accesseur (get): Accède en lecture au numérateur
     * @return la valeur de num
     */
    public int getNum() {
        return num;
    }
    /**
     * Accesseur (get) : Accède en lecture au dénominateur
     * @return la valeur de denom
     */
    public int getDenom() {
        return denom;
    }

    /**
     * Mutateur (set) : Modifie le numérateur
     * @param num La nouvelle valeur du numérateur
     */
    public void setNum(int num) {
        this.num = num;
        reduce();
    }

    /**
     * Mutateur (set) : Modifie le dénominateur
     * @param denom La nouvelle valeur du dénominateur
     * @throws RuntimeException
     */
    public void setDenom(int denom) throws RuntimeException{
        if(denom != 0) {
            this.denom = denom;
            reduce();
        }
        else 
            throw new RuntimeException("Le dénomitateur est nul");
    }

    /**
     * Mutilplie le rationnel actuel par r
     * @param r le rationnel servant de seconde opérande 
     */
    public void mult(final Rational r) {
        this.num *= r.getNum();
        this.denom *= r.getDenom();
        reduce();
    }

    /**
     * Multiplie le rationnel actuel par un rationnel ayant pour numérateur a et pour dénominateur b
     * @param a Numérateur du rationnel servant de seconde opérande
     * @param b Dénominateur du rationnel servant de seconde opérande
     * @throws RuntimeException
     */
    public void mult(final int a, final int b) throws RuntimeException {
        if (b != 0) {
            this.num *= a;
            this.denom  *= b;
            reduce();
        }
        else throw new RuntimeException("Le dénominateur est nul");
    }
    /**
     * Additionne le rationnel actuel au rationnel r
     * @param r Le rationnel servant de seconde opérande
     */
    public void add(final Rational r) {
        this.num  = this.num*r.getDenom() + this.denom*r.getNum();
        this.denom *= this.getDenom();
        reduce();
    }

    /**
     * Additionne le rationnel actuel au rationnel ayant pour numérateur a et pour dénominateur b
     * @param a Numérateur du rationnel servant de seconde opérande
     * @param b Dénominateur du rationnel servant de seconde opérande
     * @throws RuntimeException
     */
    public void add(final int a, final int b) throws RuntimeException{
        if (b != 0) {
            this.num = this.num*b + this.denom*a;
            this.denom  *= b;
            reduce();
        }
        else throw new RuntimeException("Le dénominateur est nul");
    }

    /**
     * Méthode interne qui rend la fraction irréductible
     */
    private void reduce() {
        int pgcd = pgcd(this.num, this.denom);
        this.num /= pgcd;
        this.denom /= pgcd;
    }

    /**
     * Méthode interne qui calcule le pgcd de a et b
     * @param a
     * @param b
     * @return Le pgcd de a et b
     */
    private int pgcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return pgcd (b, a%b);
    }

    @Override
    public String toString() {
        return num+" / "+denom;
    }
    
}