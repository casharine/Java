package jp.co.vsn.training.java.base.test;

import jp.co.vsn.training.java.base.CartItem;
import jp.co.vsn.training.java.base.Item;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CartItemTest {
    CartItem citem;
    Item item;

    @Before
    public void setUp() throws Exception {
        item = new Item();
        item.setItemId(100);
        item.setItemname("プログラミング作法");
        item.setPrice(2800);
        item.setCategoryCode("B3");
        item.setCategoryName("書籍");
        item.setExplanation("この本は、プログラムに対する効果的な取り組み方を提示し、質の高いコードを作成／維持することを目標にしています。");
        item.setImageName("image-B3TPP.jpg");
        item.setOriginalId("ISBN-7561-3649-4");

        citem = new CartItem(item, 5);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetItem() {
        assertEquals("ISBN-7561-3649-4", citem.getItem().getOriginalId());
    }

    @Test
    public void testGetAmount() {
        assertEquals(5, citem.getAmount());
    }

    @Test
    public void testSetAmount() {
        citem.setAmount(10);
        assertEquals(10, citem.getAmount());

        try {
            citem.setAmount(0);
        } catch (Exception ex) {
            fail("例外が発生しました。");
        }

        try {
            citem.setAmount(-1);
            fail("例外がスローされませんでした。");
        } catch (IllegalArgumentException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("IllegalArgumentException以外の例外がスローされました。");
        }
    }

    @Test
    public void testAddAmount() {
        assertEquals(13, citem.addAmount(8));
        try {
            citem.addAmount(-6);
            fail("例外が発生しませんでした。");
        } catch (IllegalArgumentException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void testCalcTotalPrice() {
        assertEquals(2800 * 5, citem.calcTotalPrice());
    }

    @Test
    public void testToString() {
        String expectedString = "[CartItem id=\"100\" name=\"プログラミング作法\" price=\"2800\" amount=\"5\"]";
        assertEquals(expectedString, citem.toString());
    }
}
