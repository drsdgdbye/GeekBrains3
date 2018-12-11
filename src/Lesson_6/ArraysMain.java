package Lesson_6;

public class ArraysMain {

    public int[] getTailAfterLastFour(int[] sourceArr) {
        int a = 0;
        for (int i = 0; i < sourceArr.length; i++) {
            if (sourceArr[i] == 4) {
                a = i + 1;
            }
        }
        if (a == 0){
            throw new RuntimeException();
        }
        int[] destArr = new int[sourceArr.length - a];
        System.arraycopy(sourceArr, a, destArr, 0, destArr.length);
        return destArr;
    }

   public boolean isOneAndFourRow(int[] sourceArr) {
        for (int i = 0; i < sourceArr.length; i+=2) {
            for (int j = i + 1; j < sourceArr.length; j+=2) {
                if (sourceArr[i] != 1 && sourceArr[j] != 4){
                    return false;
                }
            }
        }
        return true;
    }
}
