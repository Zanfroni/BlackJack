import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by munaretto on 14/06/17.
 */
public class Mao {
    private ArrayList<Carta> mao;
    private int pontos;

    public Mao() {
        this.mao = new ArrayList<Carta>();
        this.pontos = 0;
    }

    public ArrayList<Carta> getMao() {
        return mao;
    }

    public int getPontos() {
        return pontos;
    }

    public void calculaPontos(){
        if (mao.size() <= 0){
            return;
        }
        for(Carta c: mao){
            pontos = pontos + c.getValorNumerico();
        }
    }


}
