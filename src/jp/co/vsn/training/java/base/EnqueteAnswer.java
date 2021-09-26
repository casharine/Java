package jp.co.vsn.training.java.base;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * アンケートの回答数を集計するクラスです。<br/>
 * 例えば、「好きな果物は何ですか？」という質問があり、<br/>
 *<br/>
 * Aさんの回答は、メロン<br/>
 * Bさんの回答は、イチゴ<br/>
 * Cさんの回答は、桃<br/>
 * Dさんの回答は、バナナ<br/>
 * Eさんの回答は、バナナ<br/>
 * Fさんの回答は、メロン<br/>
 * Gさんの回答は、ぶどう<br/>
 * Hさんの回答は、桃<br/>
 *<br/>
 * であったとき、以下のように回答を集計します。<br/>
 * <br/>
 * メロン(2)<br/>
 * イチゴ(1)<br/>
 * 桃(2)<br/>
 * バナナ(2)<br/>
 * ぶどう(1)<br/>
 * なお、アンケートの回答は順序性を持ち、回答された順番で追加されていきます。
 *
 * @author XXXXXXX
 */
public class EnqueteAnswer {

    /**
     * アンケートの回答とその回答数を格納します。<br/>
     * キーが回答内容で、キーに紐づく値が回答数です。<br/>
     * 回答数は {@link jp.co.vsn.training.java.base.Counter} オブジェクトです。
     */
    private Map<String, Counter> ansCountMap;

    /**
     * 新しいアンケート回答集計オブジェクトを生成します。
     */
    public EnqueteAnswer() {
    	this.ansCountMap = new LinkedHashMap<>();
    }

    /**
     * 回答を追加します。</br>
     * 既に追加済みの回答の場合、現在の回答数に +1 します。</br>
     * まだ追加されていない回答の場合、回答数を 1 で追加します。</br>
     * 指定した回答が null のとき、java.lang.NullPointerException がスローされます。
     *
     * @param ans 回答
     * @throws NullPointerException 指定した回答が null のとき
     */
    public void add(String ans) {
    	if ( ans == null) {
    		throw new NullPointerException("解答がnullです。");
    	}
    	else if ( contains (ans)) {
    		ansCountMap.put(ans, ansCountMap.get(ans).inc());
    	}else {
			ansCountMap. put( ans, new Counter(1, 1));
    	}

    }

    /**
     * 指定した回答がすでに追加されているかどうかを確認します。<br/>
     * 追加されている場合は true、追加されていない場合は false。<br/>
     * 指定した回答が null のとき、java.lang.NullPointerException がスローされます。
     *
     * @param ans 回答
     * @return 指定した回答がすでに追加されている場合 true 追加されていない場合 false
     * @throws NullPointerException 指定した回答が null のとき
     */
    public boolean contains(String ans) {
    	if ( ans == null) {
    		throw new NullPointerException("解答がnullです。");
    	}
    	return ansCountMap.containsKey(ans);
    }

    /**
     * 指定した回答を削除します。<br/>
     * 回答が見つからない場合は何もしません。<br/>
     * 指定回答が null のとき、java.lang.NullPointerException がスローされます。
     *
     * @param ans 回答
     * @throws NullPointerException 指定回答が null のとき
     */
    public void remove(String ans) {
    	if( ans == null) {
    		throw new NullPointerException("ヌルぽ");
    	}else {
    	ansCountMap.remove(ans);
    	}
    }

    /**
     * 指定回答の回答数を取得します。<br/>
     * 指定回答が存在しない場合は、IllegalArgumentException がスローされます。<br/>
     * 指定回答が null のとき、java.lang.NullPointerException がスローされます。
     *
     * @param ans 回答
     * @return 指定回答の回答数
     * @throws IllegalArgumentException 指定回答が存在しない場合
     * @throws NullPointerException 指定回答が null のとき
     */
    public int getCount(String ans) {
    	if( ans == null) {
    		throw new NullPointerException("ヌルぽ");
    	}
    	else if(contains(ans) == false ) {
    		throw new IllegalArgumentException("指定解答が存在しません");
		} else {
    	return ansCountMap.get(ans).getCount();
		}
    }

    /**
     * 指定回答の回答数を設定します。<br/>
     * 指定回答が存在しない場合は、新しく回答を設定回答数で追加します。<br/>
     * 指定回答が null のとき、NullPointerException がスローされます。<br/>
     * また、負数が設定されたとき、java.lang.IllegalArgumentException がスローされます。
     *
     * @param ans 回答
     * @param count 指定回答の回答数
     * @throws NullPointerException 指定回答が null のとき
     * @throws IllegalArgumentException 設定回答数が負数のとき
     */
    public void setCount(String ans, int count) {
    	if( ans == null) {
    		throw new NullPointerException("ansがnullです");
		} else if(count < 0) {
    		throw new IllegalArgumentException("引数 count が負数です。");
		} else {
			ansCountMap. put( ans, new Counter(count, 1));
		}
	}


    /**
     * 回答リストを返します。<br/>
     * １つも回答が追加されていないときはサイズ 0 のリストを返します。
     *
     * @return 回答リスト
     */
    public List<String> getAnswerList() {
    	if(ansCountMap.size() == 0) {
    		List<String>list = new ArrayList<String>();
    		return list;
    	} else {
	    	List<String>list = new ArrayList<String>(ansCountMap.keySet());
	    	return list;
    	}
    }

    /**
     * 回答の総数を取得します。
     * @return 回答の総数
     */
    public int total() {
    	int ansTotal = 0;
    	for(String key : getAnswerList()) {
    		ansTotal += getCount(key);
    	}
    		return  ansTotal;
    }

    /**
     * オブジェクトの文字列表現を返します。<br/>
     * １つも回答が追加されていないときは「none」という文字列を返します。</br>
     *
     * <dl>
     * <dt>フォーマット</dt>
     * <dd>回答#回答数:回答#回答数: ... :回答#回答数</dd>
     * <dt>例</dt>
     * <dd>メロン#2:イチゴ#1:桃#2:バナナ#2:ぶどう#1</dd>
     * </dl>
     *
     * @return オブジェクトの文字列表現
     */
    @Override
    public String toString() {
    	if(ansCountMap.size() == 0) {
    		return "none";
    	}else {
    		String str = "";
    		for(String key : getAnswerList()) {
    			str += key + "#" +  ansCountMap.get(key).getCount() + ":";
    		}
    		str = str.substring(0, str.length()-1);
    		return str;
    	}
    }

    /**
     * 動作確認用の実行メソッドです。
     * @param args
     */
    public static void main(String[] args) {

    }
}
