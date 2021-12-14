package main;

import java.util.ArrayList;

public class BoyerMooreImpl {


    // preprocessing for strong good suffix rule
    static void preprocess_strong_suffix(int []shift, int []badPosition,
                                         char []pattern, int patternLength)
    {
        int i = patternLength, j = patternLength + 1;
        badPosition[i] = j;

        while(i > 0)
        {
            while(j <= patternLength && pattern[i - 1] != pattern[j - 1])
            {
                if (shift[j] == 0)
                    shift[j] = j - i;

                j = badPosition[j];
            }
            i--; j--;
            badPosition[i] = j;
        }
    }

    static void preprocess_case2(int []shift, int []badPosition,
                                 char []pattern, int patterrnLength)
    {
        int i, j;
        j = badPosition[0];
        for(i = 0; i <= patterrnLength; i++)
        {
            if(shift[i] == 0)
                shift[i] = j;

            if (i == j)
                j = badPosition[j];
        }
    }

    public static ArrayList<Integer> findPatternPos(char[] inputString, char[] pattern) {
        ArrayList<Integer> resultPos = new ArrayList<>();
        // patternShift is shift of the pattern relative to inputString
        int patternShift = 0;
        int j;
        int patternLength = pattern.length;
        int stringLength = inputString.length;

        int []badPosition = new int[patternLength + 1];
        int []shift = new int[patternLength + 1];

        //initialize all occurrence of shift to 0
        for(int i = 0; i < patternLength + 1; i++)
            shift[i] = 0;

        //do preprocessing
        preprocess_strong_suffix(shift, badPosition, pattern, patternLength);
        preprocess_case2(shift, badPosition, pattern, patternLength);

        while(patternShift <= stringLength - patternLength)
        {
            j = patternLength - 1;

            while(j >= 0 && pattern[j] == inputString[patternShift+j])
                j--;

            if (j < 0)
            {
                resultPos.add(patternShift);
                System.out.printf("pattern occurs at position = %d\n", patternShift);
                patternShift += shift[0];
            }
            else
                patternShift += shift[j + 1];
        }
        return resultPos;
    }

    public static void main(String[] args)
    {
        char []text = "Krasnfjarrkfsaetrrkfsasarrk".toCharArray();
        char []pattern = "arrk".toCharArray();
        findPatternPos(text, pattern);
    }
}
