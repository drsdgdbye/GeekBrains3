import Lesson_6.ArraysMain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OneAndFourRowTest {
    private ArraysMain arraysMain;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 4, 1,4,1,4,}, true},
                {new int[]{4, 1, 1, 4, 4, 1}, false},
                {new int[]{1, 4, 1, 4, 1}, true}
        });
    }

    int[] src;
    boolean dest;

    public OneAndFourRowTest(int[] src, boolean dest) {
        this.src = src;
        this.dest = dest;
    }

    @Before
    public void init() {
        arraysMain = new ArraysMain();
    }


    @Test
    public void test1() {
        Assert.assertEquals(dest, arraysMain.isOneAndFourRow(src));
    }
}
