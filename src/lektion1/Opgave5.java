package lektion1;

public class Opgave5 {
    private int[] rainfallPrWeek = { 20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13,
            15, 10, 9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12, 0, 2, 0, 0, 78, 0,
            0, 0, 34, 12, 34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18,
            19, 21, 32, 24, 13 };

    /**
     * Returns the week number of the week of the year where the vacation should start,
     * if you want the minimum rainfall in the three weeks.
     * O(n)
     * @return index value for first given week. -1 if rainfallPrWeek contains less than 3 elements.
     */

    public int bestThreeWeeks() {
        if (rainfallPrWeek.length < 3) {
            return -1;
        }

        int bestStartIndex = 0;
        int bestSum = rainfallPrWeek[0] + rainfallPrWeek[1] + rainfallPrWeek[2];

        for (int i = 1; i <= rainfallPrWeek.length - 3; i++) {
            int sum = rainfallPrWeek[i] + rainfallPrWeek[i + 1] + rainfallPrWeek[i + 2];
            if (sum < bestSum) {
                bestSum = sum;
                bestStartIndex = i;
            }
        }

        return bestStartIndex + 1;
    }

    /**
     * Returns the week number of the week of the year where you want to start the vacation,
     * if you want the minimum rainfall in the "number" of weeks specified in the parameter.
     * O(n)
     * @return
     */

    public int bestHolidayWeekStart(int number) {
        if (number <= 0 || number > rainfallPrWeek.length) {
            return -1;
        }

        int bestStartIndex = 0;
        int currentSum = 0;
        for (int i = 0; i < number; i++) {
            currentSum += rainfallPrWeek[i];
        }
        int bestSum = currentSum;

        for (int i = number; i < rainfallPrWeek.length; i++) {
            currentSum += rainfallPrWeek[i] - rainfallPrWeek[i - number];
            if (currentSum < bestSum) {
                bestSum = currentSum;
                bestStartIndex = i - number + 1;
            }
        }

        return bestStartIndex + 1;
    }

    /**
     * Returns the week number of the first week in which precipitation has been exactly the same
     * for the most consecutive weeks
     * O(n)
     * @return
     */
    public int sameRainfall() {
        if (rainfallPrWeek.length == 0) {
            return -1;
        }

        int bestStartIndex = 0;
        int bestLength = 1;
        int currentStart = 0;
        int currentLength = 1;

        for (int i = 1; i < rainfallPrWeek.length; i++) {
            if (rainfallPrWeek[i] == rainfallPrWeek[i - 1]) {
                currentLength++;
                if (currentLength > bestLength) {
                    bestLength = currentLength;
                    bestStartIndex = currentStart;
                }
            } else {
                currentStart = i;
                currentLength = 1;
            }
        }

        return bestStartIndex + 1;
    }
}
