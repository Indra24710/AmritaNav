package amrita.design.com.amritanavigator;

import java.lang.reflect.Array;

public class ShortestPath {
    static int P = 0;
    static final int V = 87;
    static int index;
    float[] path = new float[87];

    /* Access modifiers changed, original: 0000 */
    public void printSolution(int[] iArr, int i) {
    }

    /* Access modifiers changed, original: 0000 */
    public int minDistance(float[] fArr, Boolean[] boolArr) {
        float f = Float.MAX_VALUE;
        int i = -1;
        int i2 = 0;
        while (i2 < 87) {
            if (!boolArr[i2].booleanValue() && fArr[i2] <= f) {
                f = fArr[i2];
                i = i2;
            }
            i2++;
        }
        return i;
    }

    /* Access modifiers changed, original: 0000 */
    public void printPath(int[] iArr, int i, int i2) {
        float[] fArr = this.path;
        int i3 = index;
        index = i3 + 1;
        fArr[i3] = (float) (i + 1);
        if (i != i2) {
            printPath(iArr, iArr[i], i2);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void printSolution(float[] fArr, int i, int[] iArr, int i2, int i3) {
        for (i = 0; i < 87; i++) {
            if (i == i2) {
                float[] fArr2 = this.path;
                int i4 = index;
                index = i4 + 1;
                fArr2[i4] = fArr[i];
                printPath(iArr, i, i3);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dijkstra(float[][] fArr, int i, int i2, int[] iArr) {
        int[] iArr2 = new int[87];
        float[] fArr2 = new float[87];
        Boolean[] boolArr = new Boolean[87];
        for (int i3 = 0; i3 < 87; i3++) {
            iArr2[0] = -1;
            fArr2[i3] = 2.14748365E9f;
            boolArr[i3] = Boolean.valueOf(false);
        }
        fArr2[i] = 0.0f;
        for (int i4 = 0; i4 < 86; i4++) {
            int minDistance = minDistance(fArr2, boolArr);
            boolArr[minDistance] = Boolean.valueOf(true);
            int i5 = 0;
            while (i5 < 87) {
                if (!(boolArr[i5].booleanValue() || fArr[minDistance][i5] == 0.0f || fArr2[minDistance] == 2.14748365E9f || fArr2[minDistance] + fArr[minDistance][i5] >= fArr2[i5] || iArr[i5] < P)) {
                    iArr2[i5] = minDistance;
                    fArr2[i5] = fArr2[minDistance] + fArr[minDistance][i5];
                }
                i5++;
            }
        }
        printSolution(fArr2, 87, iArr2, i2, i);
    }

    public static float[][] grapgen(float[][] fArr) {
        float[][] fArr2 = (float[][]) Array.newInstance(float.class, new int[]{87, 87});
        for (int i = 0; i < R.styleable.AppCompatTheme_textColorAlertDialogListItem; i++) {
            int i2 = ((int) fArr[i][0]) - 1;
            int i3 = ((int) fArr[i][1]) - 1;
            fArr2[i2][i3] = fArr[i][2];
            fArr2[i3][i2] = fArr[i][2];
        }
        return fArr2;
    }

    public float[] main1(int i, int i2, int i3) {
        float[][] fArr = new float[R.styleable.AppCompatTheme_textColorSearchUrl][];
        fArr[0] = new float[]{1.0f, 2.0f, 46.6763f};
        fArr[1] = new float[]{2.0f, 3.0f, 57.3335f};
        fArr[2] = new float[]{2.0f, 56.0f, 113.77f};
        fArr[3] = new float[]{3.0f, 4.0f, 83.0355f};
        fArr[4] = new float[]{3.0f, 27.0f, 100.0f};
        fArr[5] = new float[]{4.0f, 5.0f, 68.7432f};
        fArr[6] = new float[]{4.0f, 26.0f, 100.0f};
        fArr[7] = new float[]{5.0f, 8.0f, 52.0852f};
        fArr[8] = new float[]{5.0f, 6.0f, 63.4582f};
        fArr[9] = new float[]{6.0f, 7.0f, 60.0688f};
        fArr[10] = new float[]{7.0f, 9.0f, 78.5672f};
        fArr[11] = new float[]{9.0f, 10.0f, 63.7651f};
        fArr[12] = new float[]{9.0f, 24.0f, 59.0116f};
        fArr[13] = new float[]{10.0f, 11.0f, 48.3667f};
        fArr[14] = new float[]{11.0f, 12.0f, 77.2701f};
        fArr[15] = new float[]{11.0f, 22.0f, 75.2591f};
        fArr[16] = new float[]{12.0f, 14.0f, 37.5733f};
        fArr[17] = new float[]{12.0f, 15.0f, 91.477f};
        fArr[18] = new float[]{13.0f, 14.0f, 24.9234f};
        fArr[19] = new float[]{15.0f, 16.0f, 43.713f};
        fArr[20] = new float[]{15.0f, 21.0f, 27.2f};
        fArr[21] = new float[]{16.0f, 17.0f, 47.9243f};
        fArr[22] = new float[]{17.0f, 18.0f, 49.551f};
        fArr[23] = new float[]{18.0f, 19.0f, 44.7506f};
        fArr[24] = new float[]{19.0f, 20.0f, 108.5073f};
        fArr[25] = new float[]{20.0f, 21.0f, 137.7923f};
        fArr[26] = new float[]{20.0f, 32.0f, 63.9279f};
        fArr[27] = new float[]{20.0f, 87.0f, 100000.0f};
        fArr[28] = new float[]{21.0f, 22.0f, 55.4523f};
        fArr[29] = new float[]{21.0f, 87.0f, 100000.0f};
        fArr[30] = new float[]{22.0f, 23.0f, 63.7651f};
        fArr[31] = new float[]{22.0f, 87.0f, 100000.0f};
        fArr[32] = new float[]{23.0f, 24.0f, 64.6142f};
        fArr[33] = new float[]{23.0f, 28.0f, 132.2014f};
        fArr[34] = new float[]{23.0f, 87.0f, 100000.0f};
        fArr[35] = new float[]{24.0f, 25.0f, 132.2716f};
        fArr[36] = new float[]{25.0f, 26.0f, 97.585f};
        fArr[37] = new float[]{25.0f, 28.0f, 64.6142f};
        fArr[38] = new float[]{26.0f, 27.0f, 83.0355f};
        fArr[39] = new float[]{28.0f, 29.0f, 44.5319f};
        fArr[40] = new float[]{28.0f, 53.0f, 170.4407f};
        fArr[41] = new float[]{28.0f, 87.0f, 100000.0f};
        fArr[42] = new float[]{29.0f, 30.0f, 97.48f};
        fArr[43] = new float[]{29.0f, 31.0f, 167.66f};
        fArr[44] = new float[]{30.0f, 42.0f, 167.23f};
        fArr[45] = new float[]{31.0f, 32.0f, 251.4188f};
        fArr[46] = new float[]{31.0f, 33.0f, 68.8593f};
        fArr[47] = new float[]{31.0f, 87.0f, 100000.0f};
        fArr[48] = new float[]{33.0f, 34.0f, 43.3585f};
        fArr[49] = new float[]{33.0f, 36.0f, 44.3962f};
        fArr[50] = new float[]{34.0f, 41.0f, 83.7317f};
        fArr[51] = new float[]{35.0f, 41.0f, 29.793f};
        fArr[52] = new float[]{36.0f, 39.0f, 38.3346f};
        fArr[53] = new float[]{36.0f, 42.0f, 61.3038f};
        fArr[54] = new float[]{37.0f, 38.0f, 45.749f};
        fArr[55] = new float[]{37.0f, 39.0f, 74.5354f};
        fArr[56] = new float[]{39.0f, 40.0f, 43.8773f};
        fArr[57] = new float[]{40.0f, 41.0f, 43.8773f};
        fArr[58] = new float[]{42.0f, 43.0f, 92.6003f};
        fArr[59] = new float[]{43.0f, 44.0f, 47.6039f};
        fArr[60] = new float[]{43.0f, 85.0f, 133.5985f};
        fArr[61] = new float[]{44.0f, 45.0f, 40.8888f};
        fArr[62] = new float[]{44.0f, 71.0f, 35.5991f};
        fArr[63] = new float[]{45.0f, 46.0f, 79.5725f};
        fArr[64] = new float[]{45.0f, 57.0f, 52.6558f};
        fArr[65] = new float[]{45.0f, 86.0f, 133.6237f};
        fArr[66] = new float[]{46.0f, 47.0f, 59.5665f};
        fArr[67] = new float[]{47.0f, 48.0f, 104.719f};
        fArr[68] = new float[]{47.0f, 58.0f, 54.76f};
        fArr[69] = new float[]{48.0f, 49.0f, 122.9115f};
        fArr[70] = new float[]{49.0f, 50.0f, 28.117f};
        fArr[71] = new float[]{50.0f, 51.0f, 70.5694f};
        fArr[72] = new float[]{50.0f, 54.0f, 58.2495f};
        fArr[73] = new float[]{51.0f, 53.0f, 58.2495f};
        fArr[74] = new float[]{53.0f, 54.0f, 70.5694f};
        fArr[75] = new float[]{54.0f, 55.0f, 40.3341f};
        fArr[76] = new float[]{55.0f, 56.0f, 167.7545f};
        fArr[77] = new float[]{57.0f, 58.0f, 50.4504f};
        fArr[78] = new float[]{58.0f, 59.0f, 66.7424f};
        fArr[79] = new float[]{58.0f, 68.0f, 47.9328f};
        fArr[80] = new float[]{59.0f, 63.0f, 45.8039f};
        fArr[81] = new float[]{59.0f, 66.0f, 115.3197f};
        fArr[82] = new float[]{63.0f, 64.0f, 64.3942f};
        fArr[83] = new float[]{64.0f, 65.0f, 85.2614f};
        fArr[84] = new float[]{65.0f, 66.0f, 133.4083f};
        fArr[85] = new float[]{65.0f, 67.0f, 31.8369f};
        fArr[86] = new float[]{68.0f, 69.0f, 46.2821f};
        fArr[87] = new float[]{69.0f, 70.0f, 28.4187f};
        fArr[88] = new float[]{70.0f, 72.0f, 63.4213f};
        fArr[89] = new float[]{72.0f, 73.0f, 27.2162f};
        fArr[90] = new float[]{73.0f, 74.0f, 35.0169f};
        fArr[91] = new float[]{74.0f, 75.0f, 49.8145f};
        fArr[92] = new float[]{75.0f, 76.0f, 9.439f};
        fArr[93] = new float[]{75.0f, 84.0f, 31.9591f};
        fArr[94] = new float[]{76.0f, 77.0f, 147.5795f};
        fArr[95] = new float[]{77.0f, 78.0f, 202.0152f};
        fArr[96] = new float[]{78.0f, 79.0f, 155.3003f};
        fArr[97] = new float[]{79.0f, 80.0f, 55.2313f};
        fArr[98] = new float[]{80.0f, 81.0f, 66.454f};
        fArr[99] = new float[]{80.0f, 85.0f, 70.9021f};
        fArr[100] = new float[]{81.0f, 82.0f, 70.082f};
        fArr[R.styleable.AppCompatTheme_textAppearanceSearchResultTitle] = new float[]{82.0f, 83.0f, 18.1705f};
        fArr[R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu] = new float[]{83.0f, 84.0f, 18.1705f};
        fArr[R.styleable.AppCompatTheme_textColorAlertDialogListItem] = new float[]{85.0f, 86.0f, 91.0852f};
        int[] iArr = new int[]{15, 16, 17, 30, 63, 64, 68, 69, 70, 72, 73, 74, 75};
        int[] iArr2 = new int[87];
        P = i3;
        for (i3 = 0; i3 < 87; i3++) {
            iArr2[i3] = 1;
        }
        for (int i4 : iArr) {
            iArr2[i4 - 1] = 0;
        }
        ShortestPath shortestPath = new ShortestPath();
        shortestPath.dijkstra(grapgen(fArr), i - 1, i2 - 1, iArr2);
        i = index;
        if (i > 0) {
            float[] fArr2 = shortestPath.path;
            if (fArr2[i - 1] == 87.0f) {
                fArr2[0] = fArr2[0] - 100000.0f;
            }
        }
        float[] fArr3 = shortestPath.path;
        if (fArr3[1] == 87.0f) {
            fArr3[0] = fArr3[0] - 100000.0f;
        }
        fArr3 = new float[87];
        fArr3[0] = shortestPath.path[0];
        for (i2 = index; i2 > 0; i2--) {
            fArr3[index - i2] = shortestPath.path[i2];
        }
        index = 0;
        return shortestPath.path;
    }
}
