package jp.co.vsn.training.java.base;

/**
 * 数値のカウントを行うカウンタのクラスです。
 *
 * @author Yoichiro Ito
 */
public class Counter extends Exception {

	// カウント数
    private int count;

    // １カウントで変化する数（変化量）
    private int unit;

    /**
     * カウント数を 0、変化量を 1 で初期化したCounterオブジェクトを構築します。
     */
    public Counter() {
    	this.count = 0;
    	this.unit = 1;
    }

    /**
     * カウント数、変化量をそれぞれ指定した値で初期化したCounterオブジェクトを構築します。
     *
     * @param count カウント数
     * @param unit 変化量
     */
    public Counter(int count, int unit) {
    	this.count = count;
    	this.unit = unit;
    }

    /**
     * 現在のカウント数を取得します。
     *
     * @return カウント数
     */
    public int getCount() {
        return count;
    }


    /**
     * 現在の変化量を取得します。
     *
     * @return 変化量
     */
    public int getUnit() {
        return unit;
    }


    /**
     * 変化量を指定した値にします。
     *
     * @param unit 変化量
     */
    public void setUnit(int unit) {
    	this.unit = unit;
    }


    /**
     * 現在のカウント数に変化量分増やします。
     *
     * @return 自分自身のCounterインスタンス,計算結果を返すわけではない
     *
     */


    public Counter inc() {
    	this.count += this.unit;
    	return this;
     }


    /**
     * 現在のカウント数に変化量分減らします。
     *
     * @return 自分自身のCounterインスタンス
     */
    public Counter dec() {
    	this.count -= this.unit;
    	return this;
     }

    /**
     * 現在のカウント数が指定範囲内かどうか判定します。
     *
     * @param a 最小値
     * @param b 最大値
     * @return 現在のカウント数が a 以上 b 以下のとき true, そうでないとき false
     */
    public boolean between(int a, int b) {
    	if(this.count >= a  && this.count <= b){
    		return true;
    	}
        return false;

       // return count >= a && count <= b:
    }


    /**
     * オブジェクトの文字列表現を返します。<br/>
     * 文字列表現の書式は「カウンタ値:変化量」です。<br/>
     * 例えば、カウント数が「123」、変化量が「3」のオブジェクトの文字列表現は「123:3」です。
     *
     * @return オブジェクトの文字列表現
     */
    @Override
    public String toString() {
    	return this.count + ":" + this.unit;
    }


    /**
     * 引数で指定されたCounterオブジェクトの文字列表現「カウンタ値:変化量」を解析し、
     * カウント数、変化量を設定します。<br/>
     * 解析に失敗した場合、例外java.lang.IllegalArgumentExceptionをスローします。
     *
     * @param objStr Counterオブジェクトの文字列表現「カウンタ値1:変化量」
     *
     * @throws IllegalArgumentException 解析に失敗した場合
     */

    public void parse(String objStr) {
    		if (objStr == null || objStr.isEmpty() ) {
    	        throw new IllegalArgumentException  ("objStrはnullまたは空白文字です。例外java.lang.IllegalArgumentException");
    		}
    		String[] obj = objStr.split(":");
    		try{
    		this.count = Integer.parseInt(obj[0]);
    		this.unit = Integer.parseInt(obj[1]);
    		}
    		catch (NumberFormatException nfe) {
    			 throw new IllegalArgumentException("objStrは数字に変換できません。例外java.lang.IllegalArgumentException");
    		}
    	    catch (ArrayIndexOutOfBoundsException aob) {
    	    	 throw new IllegalArgumentException("objStrは配列要素の範囲外です。例外java.lang.IllegalArgumentException");
    	    }
    }
//String[] fruit = str.split(",", 0);


    /**
     * 動作確認用の実行メソッドです。
     *
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
    	Counter h = new Counter(1,2);
    	h.getCount();
    	System.out.println(h.count);
    	h.getUnit();
    	System.out.println(h.unit);
    	h.inc();
    	System.out.println(h.count);
    	h.dec();
    	System.out.println(h.count);
    	h.between(1, 20);
    	h.toString();
    	System.out.println(h);
    	h.parse("45,A");
    	System.out.println(h);
    	h.parse("45,1");
    	System.out.println(h);
    	h.parse("45");
    	System.out.println(h);
    	h.parse(null);
    	System.out.println(h);
    }
}