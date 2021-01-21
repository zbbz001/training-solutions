package week12d01;

import org.junit.Test;

import static org.junit.Assert.*;

public class GoodsPackerTest {

    @Test
    public void goodsPackerTest() {
        GoodsPacker gp = new GoodsPacker();

        assertEquals(555, gp.packGoods(new int[][]{{7, 160}, {3, 90}, {2, 15}}, 20));
    }
}