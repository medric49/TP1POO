public class Rational {
    private int num;
    private int denom;

    public Rational(int num, int denom) throws RuntimeException {
        if(denom != 0) {
            this.num = num;
            this.denom = denom;
        }
        else
            throw new RuntimeException("Le dénomitateur est nul");
        
    }

    public int getNum() {
        return num;
    }
    public int getDenom() {
        return denom;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setDenom(int denom) throws RuntimeException{
        if(denom != 0) {
            this.denom = denom;
        }
        else 
            throw new RuntimeException("Le dénomitateur est nul");
    }
    
}