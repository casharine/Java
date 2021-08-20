package jp.co.vsn.training.java.base;

/**
 * 車掌を表すクラスです。(子）
 *
 * @author XXXXXXX
 */
public class Conductor {

    // 電車
    private Train train;

    /**
     * 指定された Train オブジェクトを保持した Conductor（車掌）オブジェクトを構築します。
     *
     * @param train 電車
     */
    //集約により,外部にあるTrainクラスを自クラスのTrainクラス型のtrain変数に格納する
    public Conductor(Train train) {
    	this.train = train;
    }

    /**
     * <p>次の形式のアナウンスを行います。</p>
     * <p>＜アナウンス形式＞</p>
     * <p>
     * <dl>
     *
     *
     * <dt>現在の駅が終着一つ前の駅のとき：</dt>
     * <dd>(現在駅名)、(現在駅名)、この電車は(終着駅名)行きです。次は(終着駅名)、終点です。</dd>
     * <dt>現在の駅が終着駅のとき：</dt>
     * <dd>(現在駅名)、(現在駅名)、終点です。ご利用ありがとうございました。</dd>
     * <dt>現在の駅が上記以外の駅のとき：</dt>
     * <dd>(現在駅名)、(現在駅名)、この電車は(終着駅名)行きです。次は(次の停車駅名)です。</dd>
     * </dl>
     * </p>
     *
     * @return アナウンス文字列
     */
    public String announce() {
    	if (train.isNextTerminalStation() == true) {
    		return ( train.getCurrentStation() + "、" + train.getCurrentStation() + "、この電車は" + train.getTerminalStation() + "行きです。次は" + train.getTerminalStation() + "、終点です。" );
    	}
    	else if (train.isTerminalStation() == true ) {
    		return ( train.getCurrentStation() + "、" + train.getCurrentStation() + "、" + "終点です。ご利用ありがとうございました。" );
    	}
    	else {
    		return ( train.getCurrentStation() + "、" + train.getCurrentStation() + "、この電車は" + train.getTerminalStation() + "行きです。次は" + train.getNextStation() + "です。" );
    	}
    }

    /**
     * 動作確認用の実行メソッドです。
     * @param args
     */

    // mainメソッドを宣言したクラスが実行時に最初に呼び出される
    public static void main(String[] args) {

    	String[] stations = {"東京", "有楽町", "新橋", "浜松町"};
        Train train = new Train("山の手線", stations);
        Conductor con = new Conductor(train);
        System.out.println(con.announce());
    }
}
