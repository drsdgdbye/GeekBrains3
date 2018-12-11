import Lesson_6.ArraysMain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FourAvaliableTest {
    private ArraysMain arraysMain;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5, 6}, new int[]{5, 6}},
                {new int[]{4, 9, 2, 8, 3, 7, 5, 6}, new int[]{9, 2, 8, 3, 7, 5, 6}},
                {new int[]{1, 4, 0, 9, 7, 6, 5, 4, 3, 2}, new int[]{3, 2}},
        });
    }

    int[] src;
    int[] dest;

    public FourAvaliableTest(int[] src, int[] dest) {
        this.src = src;
        this.dest = dest;
    }

    @Before
    public void init() {
        arraysMain = new ArraysMain();
    }


    @Test
    public void test1() {
        Assert.assertArrayEquals(dest, arraysMain.getTailAfterLastFour(src));
    }

    @Test(expected = RuntimeException.class)
    public void test2() {
        int[] dest = {};
        int[] src = {1, 2, 3, 5, 6, 7, 8, 9, 0};
        Assert.assertArrayEquals(dest, arraysMain.getTailAfterLastFour(src));
    }
}
