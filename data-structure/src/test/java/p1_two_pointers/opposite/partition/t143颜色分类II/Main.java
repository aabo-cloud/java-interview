package p1_two_pointers.opposite.partition.t143颜色分类II;

public class Main {
    /**
     * @param colors: A list of integer
     * @param k:      An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length < 2) {
            return;
        }
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }

    private void rainbowSort(int[] colors, int left, int right, int colorFrom, int colorTo) {

        if (colorFrom == colorTo) {
            return;
        }

        int midColor = colorFrom + (colorTo - colorFrom) / 2;
        int l = left, r = right;
        while (l <= r) {

            while (l <= r && colors[l] <= midColor) {
                l++;
            }
            while (l <= r && colors[r] > midColor) {
                r--;
            }
            if (l <= r) {
                int temp = colors[l];
                colors[l] = colors[r];
                colors[r] = temp;
                l++;
                r--;
            }

        }

        rainbowSort(colors, left, r, colorFrom, midColor);
        rainbowSort(colors, l, right, midColor + 1, colorTo);

    }

}