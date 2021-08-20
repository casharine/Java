package jp.co.vsn.training.java.base;

/**
 * 電車を表すクラスです。（親）
 *
 * @author Yoichiro Ito
 */
public class Train {

    // 路線の駅名配列
    private String[] stations;
    // 現在駅の位置（路線「stations」の添え字）
    private int currentIndex;
    // 路線名
    private String lineName;

    /**
     * 指定した路線の Train（電車）オブジェクトを構築します。<br/>
     * 現在の駅は始発駅に初期化されます。<br/>
     * stationsがnullまたは2駅未満の場合はIllegalArgumentExceptionをスローします。
     *
     * @param lineName 路線名
     * @param stations 路線の駅名配列
     *
     * @throws IllegalArgumentException stationsがnullまたは2駅未満の場合
     */
    public Train(String lineName, String[] stations) {
    	this.lineName = lineName;
    	this.stations = stations;
    	this.currentIndex = 0;

    	if (stations == null || stations.length <= 1 ) {
	        throw new IllegalArgumentException  ("stationsがnullまたは、2駅未満です");
    	}
    }
    /**
     * 路線名を取得します。
     * @return 路線名
     */
    public String getLineName() {
    	return this.lineName;
    }

    /**
     * 現在の駅名を返します。
     * @return 現在の駅名
     */
    public String getCurrentStation() {
        return this.stations[currentIndex];
    }

    /**
     * 次の駅名の文字列を返します。<br/>
     * 現在の駅が終着駅の場合は、nullを返します。
     *
     * @return 次の駅名の文字列
     */
    public String getNextStation() {
    	if( currentIndex + 1 > stations.length - 1) {
    		return null;
    	}
    	return this.stations[currentIndex + 1];
    }

    /**
     * 始発駅の駅名の文字列を返します。
     * @return 始発駅の駅名の文字列
     */
    public String getStartingStation() {
    	return stations[0];
    }

    /**
     * 終着駅の駅名の文字列を返します。
     * @return 終着駅の駅名の文字列
     */
    public String getTerminalStation() {
        return stations[stations.length - 1];
    }

    /**
     * 次の駅へ移動します。<br/>
     * 現在の駅が終着駅の場合は、何もしません。
     */
    public void goNextStation() {
    	if( this.getCurrentStation() != this.getTerminalStation()) {
    		currentIndex += 1;
    	}
    }

    /**
     * 現在の駅が始発駅かどうかを判定します。
     *
     * @return 現在の駅が始発駅のとき true、それ以外 false。
     */
    public boolean isStartingStation() {
    	if ( this.getCurrentStation() == this.getStartingStation() ) {
    		return true;
    	}
    	return false;
    }

    /**
     * 次の駅が終着駅かどうかを判定します。<br/>
     * 現在の駅が終着駅の場合は、false を返します。
     *
     * @return 次の駅が終着駅の場合は true、それ以外 false
     */
    public boolean isNextTerminalStation() {
    	if ( this.getNextStation() == this.getTerminalStation() ) {
    		return true;
    	}
    	return false;
    }

    /**
     * 現在の駅が終着駅かどうかを判定します。
     *
     * @return 現在の駅が終着駅の場合は true、それ以外 false。
     */
    public boolean isTerminalStation() {
    	if ( this.getCurrentStation() == this.getTerminalStation() ) {
    		return true;
    	}
    	return false;
    }
}
