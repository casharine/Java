package jp.co.vsn.training.java.base;

import java.util.ArrayList;
// itterator List Map
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * ショッピングカートを表すクラスです。（集約：全体、部分（CartItem)のインスタンスをメンバ変数として持っている）
 *
 * @author XXXXXXXa
 */
public class Cart {

    /**
     * カート内のすべての商品データ。
     * キー（Key）が商品IDで、値（Value）が CartItem オブジェクト。
     */
    private HashMap<Integer, CartItem> cartData;

    /**
     * 新しいショッピングカートを作成します。
     * Mapをnullから長さ0のMapで初期化する。これによりadd等のコレクションメソッドも使えるようになる
     */
    public Cart() {
    	this.cartData = new HashMap<>();
    }

    /**
     * カートに商品を追加します。<br/>
     * 既にカートに追加済みの商品の場合、カート内の数量を加算します。<br/>
     * 引数 item が null または amount が負数の場合、java.lang.IllegalArgumentException がスローされます。
     *
     * @param item 商品
     * @param amount 数量
     *
     * @throws IllegalArgumentException 引数 item が null または amount が負数の場合
     */
    public void add(Item item, int amount) {
    	if (item == null || amount < 0) {
    		throw new IllegalArgumentException("引数 item が null または amount が負数です。");
    	}
    	//カートデータハッシュマップに追加する（itemクラスのitemIDをキーに設定し、
    	//今回の引数を使った新たなカートアイテムを設定する）
    	else if ( hasItem (item.getItemId())) {
        	this.addAmount(item.getItemId(), amount);
    	}else {
    	cartData. put( item.getItemId(), new CartItem(item, amount) );
    	}
    }

    /**
     * カート内の商品の数量を加算します。<br/>
     * amount が負数の場合、java.lang.IllegalArgumentException がスローされます。<br/>
     * 指定された商品が存在しない場合は何もしません。
     *
     * @param itemId 商品ID
     * @param amount 追加数量
     */
    public void addAmount(Integer itemId, int amount) {
    	if (amount < 0) {
    		throw new IllegalArgumentException("引数 amount が負数です。");
    	}
    	if(hasItem(itemId)) {
    	// 商品IDが存在する時 存在するはずのitemIdを使用しインスタンスを取得。CartItemクラスのメソッドを使用する
    		cartData.get(itemId).addAmount(amount);
    	}
    }

    /**
     * カート内の商品の数量を取得します。<br/>
     * カート内に指定された商品IDが見つからない場合、-1 を返します。
     *
     * @param itemId 商品ID
     *
     * @return カート内の商品の数量
     */
    public int getAmount(Integer itemId) {
    	if(hasItem(itemId)) {
    		return cartData.get(itemId).getAmount();
    	}
    	else {
    		return -1;
    	}
    }

    /**
     * カート内の商品の数量を設定します。<br/>
     * 設定数量が 0 の場合、カートから商品を削除します。<br/>
     * amount が負数の場合、java.lang.IllegalArgumentException がスローされます。<br/>
     * 指定された商品が存在しない場合は何もしません。
     *
     * @param itemId 商品ID
     * @param amount 設定数量
     *
     * @throws IllegalArgumentException amount が負数の場合
     */
    public void setAmount(Integer itemId, int amount) {
    	if (amount < 0) {
    		throw new IllegalArgumentException("引数 amount が負数です。");
    	}
    	if(hasItem(itemId)) {
    		cartData.get(itemId).setAmount(amount);
    	}

    }

    /**
     * 指定された商品IDの商品がカート内に存在するかどうかを調べます。
     *
     * @param itemId 商品ID
     *
     * @return 商品IDが存在する場合はtrue 存在しない場合はfalse
     */
    public boolean hasItem(Integer itemId) {
        return cartData.containsKey(itemId);
    }

    /**
     * カート内のすべての商品IDのイテレータを取得します。
     *
     * @return カート内のすべての商品IDのイテレータ
     */
    public Iterator<Integer> itemIdIterator() {
    	Iterator<Integer> keyItr = cartData.keySet().iterator();
//    	 while(keyItrqq.hasNext()) {
//    		 Integer itr = (Integer) keyItr.next();
    	return keyItr;
    }

    /**
     * カート内の商品のリストを取得します。
     *
     * @return カート内の商品のリスト
     */
    public List<CartItem> getCartItemList() {
    	List<CartItem> valList = new ArrayList<CartItem>(cartData.values());
    	return valList;
    }

    /**
     * 指定された商品IDのカート内の商品情報を取得します。<br/>
     * 指定された商品が存在しない場合は null を返します。
     *
     * @param itemId 商品ID
     *
     * @return 商品IDのカート内の商品情報
     */
    public CartItem getCartItem(Integer itemId) {
    	if(hasItem(itemId)) {
    		return cartData.get(itemId);
    	}
        return null;
    }

    /**
     * カート内商品の総合計金額を計算します。
     *
     * @return カート内商品の総合計金額
     */
    public int calcTotalSum() {
    	int cts = 0;
    	for( CartItem cartItem : this.getCartItemList() ) {
    		cts += cartItem.calcTotalPrice();
//    	cts += this.getCartItemList().get(hItr.next()).calcTotalPrice();
    	}
    	return cts;
    }

    /**
     * カートの内容をクリアします。
     */
    public void clear() {
    	cartData.clear();
    }

    /**
     * カート内に追加した商品の数を取得します。<br/>
     * 各商品の数量のことでありません。
     *
     * @return カート内に追加した商品の数
     */
    public int size() {
    	return cartData.size();
    }

    /**
     * 指定された商品をカートから削除します。<br/>
     * 存在しない商品の場合は何もしません。
     *
     * @param itemId 商品ID
     */
    public void removeItem(Integer itemId) {
    	if(hasItem(itemId)) {
    	// 商品IDが存在する時 存在するはずのitemIdを使用しインスタンスを取得。CartItemクラスのメソッドを使用する
    		cartData.remove(itemId);
    	}
    }

    /**
     * 動作確認のための実行メソッドです。
     * @param args
     */
    public static void main(String[] args) {
   		 Item item = new Item();
   	        item.setItemId(10);
   	        item.setItemname("水");
   	        item.setPrice(100);
   	        item.setCategoryCode("10");
   	        item.setCategoryName("飲料");
   	        item.setExplanation("軟水");
   	        item.setImageName("wator.jpg");
   	        item.setOriginalId("W-123");

   	     Item item2 = new Item();
	        item2.setItemId(20);
	        item2.setItemname("お茶");
	        item2.setPrice(200);
	        item2.setCategoryCode("10");
	        item2.setCategoryName("飲料");
	        item2.setExplanation("軟水");
	        item2.setImageName("wator.jpg");
	        item2.setOriginalId("W-123");

	    Cart cart = new Cart();
   	        cart.add(item, 3);
   	        cart.add(item2, 5);
   	        System.out.println(cart.calcTotalSum());





    }
}
