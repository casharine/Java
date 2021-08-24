package jp.co.vsn.training.java.base;

/**
 * ショッピングカート内の商品を表すクラスです。（集約：全体、部分（Item)のインスタンスをメンバ変数として持っている）Cartの全体でもある）
 *
 * @author XXXXXXX
 */
public class CartItem {

    // 商品
    private Item item;
    // 数量
    private int amount;

    /**
     * 新しいショッピングカート内の商品を作成します。
     *
     * @param item 商品
     * @param amount 数量
     */
    public CartItem(Item item, int amount) {
    	this.item = item;
    	this.amount = amount;
    }

    /**
     * 商品を取得します。
     * @return 商品
     */
    public Item getItem() {
        return this.item;
    }

    /**
     * 数量を取得します。
     * @return 数量
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * 数量を設定します。<br/>
     * 引数amountが0以下の場合、java.lang.IllegalArgumentException がスローされます。
     *
     * @param amount 数量
     * @throws IllegalArgumentException 引数amountが0以下の場合
     */

    // 引数amoutが0以下（使用】テストケース（負の値）となっており、エスカレーションの上テストケースを正とした。
    public void setAmount(int amount) {
    	if (amount < 0) {
	        throw new IllegalArgumentException  ("数量が負の値です。");
    	}
    	this.amount = amount;
    }

    /**
     * 指定数量分を現在の数量に加えます。<br/>
     * 引数 amount が負数の場合、java.lang.IllegalArgumentException をスローします。
     *
     * @param amount 加える数量
     * @return 加えた後の数量
     * @throws IllegalArgumentException 引数 amount が負数の場合
     */
    public int addAmount(int amount) {
    	if (amount < 0) {
	        throw new IllegalArgumentException  ("数量が負の値です。");
    	}
    	return this.amount += amount;
    }

    /**
     * 合計金額（商品価格 × 数量）を計算します。
     * @return 合計金額
     */
    public int calcTotalPrice() {
        return this.amount * item.getPrice();

    }

    /**
     * オブジェクトの文字列表現を返します。<br/>
     * 返される文字列は、[CartItem id="商品ID" name="商品名" price="価格" amount="数量"] です。<br/>
     * 例: [CartItem id="117" name="りんご" price="100" amount="3"]
     *
     * @return オブジェクトの文字列表現
     */
    @Override
    public String toString() {
        return "[CartItem id=" +"\"" + item.getItemId() + "\" " +  "name=" + "\"" + item.getItemName() + "\" " + "price=" + "\"" + item.getPrice() + "\" "  + "amount=" + "\"" + this.amount +"\"" + "]" ;
     //   [CartItem id="100" name="プログラミング作法" price="2800" amount="5"]
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



    	CartItem cItem =  new CartItem(item, 3);
			cItem.addAmount(1);
			System.out.println(cItem);

    }
}
