/*TASK Std Support for OO Coding Standard*/
package TowaStandard;

import java.util.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.concurrent.*;

//                                                          //AUTHOR: Towa (GLG-Gerardo Lopez).
//                                                          //CO-AUTHOR: Towa ().
//                                                          //DATE: March 18, 2017.
//                                                          //PURPOSE:
//                                                          //Tools to support standard coding C# OO instance
//                                                          //      technology.
//                                                          //Some standards are meet just with coding translation from
//                                                          //      one OO instance to the other.
//                                                          //Other standards requires "different" content, this tools
//                                                          //      are for this purpose.
//======================================================================================================================
public final class Std {

    /*TASK Std.Generic Generic methods*/
    //==================================================================================================================
    //                                                      //LITERAL
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //DECLARATION AND ASSIGNMENT
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSIONS
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSION TO TEXT
    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTES*/
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //RELATIONAL OPERATORS*/
    //
    //--------------------------------------------------------------------------------------------------------------
    public static <XC extends Comparable> boolean isBetween( //
            //                                              //bool, true if is in set.

            XC xc_I,
            XC StartInclusive_I,
            XC EndInclusive_I
    ) {
        return ( //
                //                                          //Is between
                (xc_I.compareTo(StartInclusive_I) >= 0) && (xc_I.compareTo(EndInclusive_I) <= 0) //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //EQUALITY OPERATORS
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //********************************OTHER OPERATORS
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TERNARY CONDITIONAL OPERATOR
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //MINIMUM AND MAXIMUM
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
 /*
    //------------------------------------------------------------------------------------------------------------------
    public static <T extends Comparable> T MinOf(
            //                                              //Get minimum value.
            //                                              //T, MIN value.

            T... arrt_I
    ) {
        if ( //
                arrt_I == null //
                ) {
            Test.subAbort(Test.strTo(arrt_I, "arrt_I") + " can not be null");
        }
        if ( //
                arrt_I.length == 0 //
                ) {
            Test.subAbort(Test.strTo(arrt_I, "arrt_I") + " should have at least 1 item");
        }

        T tMinOf = arrt_I[0];

        for (int intI = 1; intI < arrt_I.length; intI = intI + 1) {
            if ( //
                    //                                      //a < b (remember, null is less than other object)
                    (arrt_I[intI] == null) ? true : (arrt_I[intI].compareTo(tMinOf) < 0) //
                    ) {
                tMinOf = arrt_I[intI];
            }
        }

        return tMinOf;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <T extends Comparable> T MaxOf(
            //                                              //Get maximum value.
            //                                              //T, MAX value.

            T... arrt_I
    ) {
        if ( //
                arrt_I == null //
                ) {
            Test.subAbort(Test.strTo(arrt_I, "arrint_I") + " can not be null");
        }
        if ( //
                arrt_I.length == 0 //
                ) {
            Test.subAbort(Test.strTo(arrt_I, "arrint_I") + " should have at least 1 item");
        }

        T tMaxOf = arrt_I[0];

        for (int intI = 1; intI < arrt_I.length; intI = intI + 1) {
            if ( //
                    //                                      //a > b (remember, null is less than other object)
                    (arrt_I[intI] == null) ? false : (arrt_I[intI].compareTo(tMaxOf) > 0) //
                    ) {
                tMaxOf = arrt_I[intI];
            }
        }

        return tMaxOf;
    }
     */
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //MATHEMATICAL FUNCTIONS
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TOOLS FOR DEBUGGING
    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Std.Integer*/
    //==================================================================================================================
    //                                                      //LITERAL
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //DECLARATION AND ASSIGNMENT
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSIONS
    //
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    //------------------------------------------------------------------------------------------------------------------
    public static boolean isInt( //
            //                                              //Verify if it within the range of integer.
            //                                              //bool, true = it is

            //                                              //Ej. "123"
            long long_I
    ) {
        return ( //
                (long_I >= Integer.MIN_VALUE) && (long_I <= Integer.MAX_VALUE) //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSION TO TEXT
    //
    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/
    //
    //
    //                                                      //Valid integer (and long integer) picture.
    //                                                      //Initializer should order (ascending).
    //                                                      //Sorted array is used only to verify standard pictures.
    public static final String[] INTEGER_PICTURES = {"0", "#,##0"};
    private static String[] arrstrINT_PICTURE_SORTED;

    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    //------------------------------------------------------------------------------------------------------------------
    public static String toText(
            //                                              //str, integer to text

            int int_I
    ) {
        return Std.toText(int_I, "#,##0");
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toText(
            //                                              //str, integer to text

            int int_I,
            String strPicture_I
    ) {
        if ( //
                strPicture_I == null //
                ) {
            Test.abort(Test.toLog(strPicture_I, "strPicture_I") + " can not be null");
        }

        if ( //
                Arrays.binarySearch(Std.arrstrINT_PICTURE_SORTED, strPicture_I) < 0 //
                ) {
            Test.abort(Test.toLog(strPicture_I, "strPicture_I") + " is not a valid picture",
                    Test.toLog(Std.INTEGER_PICTURES, "Std.arrstrINT_PICTURE"));
        }

        return (new DecimalFormat(strPicture_I)).format(int_I);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toTextBlankWhenZero(
            //                                              //str, integer to text

            int int_I,
            String strPicture_I
    ) {
        return ( //
                int_I == 0 //
                ) ? "" : Std.toText(int_I, strPicture_I);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isParsableToInt( //
            //                                              //Verify if it is parsable to integer.
            //                                              //bool, true = it is

            //                                              //Ej. "123"
            String str_I
    ) {
        if ( //
                str_I == null //
                ) {
            Test.abort(Test.toLog(str_I, "str_I") + " can not be null");
        }

        String strClean = Std.trim(str_I, ' ').replace(",", "");
        boolean boolIsParsableToInt = true;
        try {
            Integer.parseInt(strClean);
        } //
        catch (NumberFormatException sysexcepError) {
            boolIsParsableToInt = false;
        }

        return boolIsParsableToInt;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static int parseToInt( //
            //                                              //Text to integer
            //                                              //int, value

            //                                              //Ej. "123"
            String str_I
    ) {
        if ( //
                str_I == null //
                ) {
            Test.abort(Test.toLog(str_I, "str_I") + " can not be null");
        }

        String strClean = Std.trim(str_I, ' ').replace(",", "");

        int intParseToInt;
        boolean boolOk;
        try {
            intParseToInt = Integer.parseInt(strClean);
            boolOk = true;
        } //
        catch (NumberFormatException sysexcepError) {
            boolOk = false;
            Test.abort(Test.toLog(str_I, "str_I") + " can not be parsed to int",
                    Test.toLog(strClean, "strClean"), Test.toLog(boolOk, "boolOk"));

            intParseToInt = -1;
        }

        return intParseToInt;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toText(
            //                                              //str, long integer to text
            long long_I
    ) {
        return Std.toText(long_I, "#,##0");
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toText(
            //                                              //str, long integer to text

            long long_I,
            String strPicture_I
    ) {
        if ( //
                strPicture_I == null //
                ) {
            Test.abort(Test.toLog(strPicture_I, "strPicture_I") + " can not be null");
        }

        if ( //
                Arrays.binarySearch(Std.arrstrINT_PICTURE_SORTED, strPicture_I) < 0 //
                ) {
            Test.abort(Test.toLog(strPicture_I, "strPicture_I") + " is not a valid picture",
                    Test.toLog(Std.INTEGER_PICTURES, "Std.arrstrINT_PICTURE"));
        }

        return (new DecimalFormat(strPicture_I)).format(long_I);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toTextBlankWhenZero(
            //                                              //str, long integer to text

            long long_I,
            String strPicture_I
    ) {
        return ( //
                long_I == 0 //
                ) ? "" : Std.toText(long_I, strPicture_I);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isParsableToLong( //
            //                                              //Verify if it is parsable to long integer.
            //                                              //bool, true = it is

            //                                              //Ej. "123"
            String str_I
    ) {
        if ( //
                str_I == null) {
            Test.abort(Test.toLog(str_I, "str_I") + " can not be null");
        }

        String strClean = Std.trim(str_I, ' ').replace(",", "");
        boolean boolIsParsableToLong = true;
        try {
            Long.parseLong(strClean);
        } //
        catch (NumberFormatException sysexcepError) {
            boolIsParsableToLong = false;
        }

        return boolIsParsableToLong;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static long parseToLong( //
            //                                              //Text to long integer
            //                                              //long, value

            //                                              //Ej. "123"
            String str_I
    ) {
        if ( //
                str_I == null) {
            Test.abort(Test.toLog(str_I, "str_I") + " can not be null");
        }

        String strClean = Std.trim(str_I, ' ').replace(",", "");
        long longParseToLong;
        boolean boolOk;
        try {
            longParseToLong = Long.parseLong(strClean);
            boolOk = true;
        } //
        catch (NumberFormatException sysexcepError) {
            boolOk = false;
            Test.abort(Test.toLog(str_I, "str_I") + " can not be parsed to long",
                    Test.toLog(strClean, "strClean"), Test.toLog(boolOk, "boolOk"));

            longParseToLong = -1;
        }

        return longParseToLong;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //RELATIONAL OPERATORS*/
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //EQUALITY OPERATORS
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //********************************OTHER OPERATORS
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TERNARY CONDITIONAL OPERATOR
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //MAXIMUN AND MINIMUM
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    public static int minOf( //
            //                                              //Get minimum value.
            //                                              //int, MIN value.

            int... arrint_I
    ) {
        if ( //
                arrint_I == null //
                ) {
            Test.abort(Test.toLog(arrint_I, "arrint_I") + " can not be null");
        }
        if ( //
                arrint_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrint_I, "arrint_I") + " should have at least 1 item");
        }

        int intMinOf = arrint_I[0];

        for (int intI = 1; intI < arrint_I.length; intI = intI + 1) {
            if ( //
                    arrint_I[intI] < intMinOf //
                    ) {
                intMinOf = arrint_I[intI];
            }
        }

        return intMinOf;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static int maxOf(
            //                                              //Get maximum value.
            //                                              //int, MAX value.

            int... arrint_I
    ) {
        if ( //
                arrint_I == null //
                ) {
            Test.abort(Test.toLog(arrint_I, "arrint_I") + " can not be null");
        }
        if ( //
                arrint_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrint_I, "arrint_I") + " should have at least 1 item");
        }

        int intMaxOf = arrint_I[0];

        for (int intI = 1; intI < arrint_I.length; intI = intI + 1) {
            if ( //
                    arrint_I[intI] > intMaxOf //
                    ) {
                intMaxOf = arrint_I[intI];
            }
        }

        return intMaxOf;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static long minOf(
            //                                              //Get minimum value.
            //                                              //long, MIN value.

            long... arrlong_I
    ) {
        if ( //
                arrlong_I == null //
                ) {
            Test.abort(Test.toLog(arrlong_I, "arrlong_I") + " can not be null");
        }
        if ( //
                arrlong_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrlong_I, "arrlong_I") + " should have at least 1 item");
        }

        long longMinOf = arrlong_I[0];

        //                                                  //for (Object o : arrlongToAnalize_I)
        for (int intI = 1; intI < arrlong_I.length; intI = intI + 1) {
            if ( //
                    arrlong_I[intI] < longMinOf //
                    ) {
                longMinOf = arrlong_I[intI];
            }
        }

        return longMinOf;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static long maxOf(
            //                                              //Get maximum value.
            //                                              //long, MAX value.

            long... arrlong_I
    ) {
        if ( //
                arrlong_I == null //
                ) {
            Test.abort(Test.toLog(arrlong_I, "arrlong_I") + " can not be null");
        }
        if ( //
                arrlong_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrlong_I, "arrlong_I") + " should have at least 1 item");
        }

        long longMaxOf = arrlong_I[0];

        for (int intI = 1; intI < arrlong_I.length; intI = intI + 1) {
            if ( //
                    arrlong_I[intI] > longMaxOf //
                    ) {
                longMaxOf = arrlong_I[intI];
            }
        }

        return longMaxOf;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //MATHEMATICAL FUNCTIONS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TOOLS FOR DEBUGGING
    //
    //------------------------------------------------------------------------------------------------------------------
    /*SUPPORT METHODS FOR INITIALIZER*/
    //
    //------------------------------------------------------------------------------------------------------------------
    private static void subVerifyConstantsInteger() {
        if ( //
                Std.INTEGER_PICTURES == null //
                ) {
            Test.abort(Test.toLog(Std.INTEGER_PICTURES, "Std.arrstrINT_PICTURE") + " can not be null");
        }
        if ( //
                Std.INTEGER_PICTURES.length == 0 //
                ) {
            Test.abort(Test.toLog(Std.INTEGER_PICTURES, "Std.arrstrINT_PICTURE")
                    + " should contains at least 1 picture");
        }

        //                                              //Verify it works
        for (int intI = 0; intI < Std.INTEGER_PICTURES.length; intI = intI + 1) {
            String strInt;
            try {
                //                                      //int.strText(str) can not be used, initialization should be
                //                                      //      finished before.
                strInt = (new DecimalFormat(Std.INTEGER_PICTURES[intI])).format(123456789);
            } catch (Exception sysexceptError) {
                Test.abort(Test.toLog(Std.INTEGER_PICTURES[intI], "Std.arrstrINT_PICTURE[" + intI + "]"),
                        "can not be an standard picture, it do not work",
                        Test.toLog(sysexceptError, "sysexceptError"),
                        Test.toLog(Std.INTEGER_PICTURES, "Std.arrstrINT_PICTURE"));

                strInt = null;
            }

            if ( //
                    Std.INTEGER_PICTURES[intI].contains(";") //
                    ) {
                Test.abort(
                        Test.toLog(Std.INTEGER_PICTURES[intI], "Std.arrstrINT_PICTURE[" + intI + "]")
                        + "can not contain ';' (picture separator), should include just ONE picture",
                        Test.toLog(Std.INTEGER_PICTURES, "Std.arrstrINT_PICTURE"));
            }
        }

        Test.abortIfDuplicate(Std.arrstrINT_PICTURE_SORTED, "Std.arrstrINT_PICTURE_SORTED");
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Std.Number*/
    //==================================================================================================================
    //                                                      //LITERALS
    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/
    public static double MIN_NUMBER = -Double.MAX_VALUE;

    //                                                      //Notice that in Java this is confusing, but MIN_VALUE
    //                                                      //      (which is positive) contains this info.
    public static double EPSILON = Double.MIN_VALUE;

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //DECLARATION AND ASSIGNMENT 
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //ROUND
    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/
    //                                                      //Factor to be usesed in numRound (form 0 to 15)
    private static final double[] arrnum10S_FACTOR = {1, 10, 100, 1000, 1.0E+4, 1.0E+5, 1.0E+6, 1.0E+7, 1.0E+8, 1.0E+9,
        1.0E+10, 1.0E+11, 1.0E+12, 1.0E+13, 1.0E+14, 1.0E+15};

    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    public static double round( //
            //                                              //Rounds similar to Excel, but with Bankers Rounding
            //                                              //num, number rounded.

            double num_I,
            //                                              //Decimals to round (can be negative)
            int intDigits_I
    ) {
        int intMAX_DIGITS_TO_ROUND = Std.arrnum10S_FACTOR.length - 1;

        if (!( //
                (intDigits_I >= -intMAX_DIGITS_TO_ROUND) && (intDigits_I <= intMAX_DIGITS_TO_ROUND) //
                )) {
            Test.abort(Test.toLog(intDigits_I, "intDigits_I")
                    + " should be in the range " + -intMAX_DIGITS_TO_ROUND + " up to " + intMAX_DIGITS_TO_ROUND);
        }

        double numFactor = Std.arrnum10S_FACTOR[Math.abs(intDigits_I)];

        double numRound;
        if ( //
                intDigits_I >= 0 //
                ) {
            //                                              //To round, move point right
            numRound = Math.rint(num_I * numFactor) / numFactor;
        } //
        else {
            //                                              //To round, move point left
            numRound = Math.rint(num_I / numFactor) * numFactor;
        }

        return numRound;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static double truncate( //
            double num_I //
    ) {
        double numTruncate;
        /*CASE*/
        if ( //
                num_I == Double.POSITIVE_INFINITY || num_I == Double.NEGATIVE_INFINITY || Std.isNaN(num_I) //  
                ) {
            numTruncate = num_I;
        } //
        else if ( //
                num_I >= 0.0 //
                ) {
            numTruncate = Math.floor(num_I);
        } //
        else {
            numTruncate = Math.ceil(num_I);
        }
        /*END-CASE*/

        return numTruncate;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSIONS
    //
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED MODULES*/
    //------------------------------------------------------------------------------------------------------------------
    public static boolean isInt( //
            //                                              //Verify if it does not have decimal part and is within the
            //                                              //      range of integer.
            //                                              //bool, true = it is

            //                                              //Ej. "123.o"
            double num_I
    ) {
        return ((num_I == Std.truncate(num_I))
                //                                          //In range
                && (num_I >= (double) Integer.MIN_VALUE) && (num_I <= (double) Integer.MAX_VALUE) //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isLong(
            //                                              //Verify if it does not have decimal part and is within the
            //                                              //      range -999,999,999,999,999 and 999,999,999,999,999
            //                                              //Values outside this range can not be converted to long
            //                                              //      integer without loosing some digits.
            //                                              //bool, true = it is

            //                                              //Ej. "123.o"
            double num_I
    ) {
        return ((num_I == Std.truncate(num_I))
                //                                          //In range
                && (num_I >= -999999999999999.0) && (num_I <= 999999999999999.0) //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSION TO TEXT
    //--------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/
    //                                                      //Valid number picture
    //                                                      //Initializer should order (ascending)
    //                                                      //Sorted array is used only to verify standard pictures.
    public static final String[] NUMBER_PICTURES = {
        //                                                  //Only digits (1 to 7 decimals)
        "0.0", "0.00", "0.000", "0.0000", "0.00000", "0.000000", "0.0000000",
        //                                                  //Include ,'s and digits (1 to 7 decimals)
        "#,##0.0", "#,##0.00", "#,##0.000", "#,##0.0000", "#,##0.00000", "#,##0.000000", "#,##0.0000000",
        //                                                  //Mantissa picture, 1 to 14 decimals
        "0.0E+0", "0.00E+0", "0.000E+0", "0.0000E+0", "0.00000E+0", "0.000000E+0", "0.0000000E+0", "0.00000000E+0",
        "0.000000000E+0", "0.0000000000E+0", "0.00000000000E+0", "0.000000000000E+0", "0.0000000000000E+0",
        "0.00000000000000E+0",
        //                                                  //Percentage (1 to 5 decimal, equivalente to up to 7 decimal
        //                                                  //      in number)
        "0.0%", "0.00%", "0.000%", "0.0000%", "0.00000%"};
    private static String[] arrstrNUM_PICTURE_SORTED;

    //                                                      //Java display 16 digits but C# just 15
    //                                                      //Should be in range 10-15.
    private static final int intNUM_MAXIMUM_DIGITS = 15;

    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    public static String toText(
            //                                              //Text to 15 significant digits.
            //                                              //str, number.

            double num_I
    ) {
        return Std.toText(num_I, Std.intNUM_MAXIMUM_DIGITS);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toText(
            //                                              //Text to 2 up to 15 significant digits.
            //                                              //Examples (x = 6):
            //                                              //1,234.56 or -1,234.56
            //                                              //0.000123456 or -0.000123456.
            //                                              //1.23456E+18 or -1.23456E+18.
            //                                              //1.23456E-6 or -1.23456E-6.
            //                                              //str, Formatted number.

            double num_I,
            //                                              //Significant digits to display (2 to max))
            int intDigits_I
    ) {
        if (!( //
                (intDigits_I >= 2) && (intDigits_I <= Std.intNUM_MAXIMUM_DIGITS) //
                )) {
            Test.abort(Test.toLog(intDigits_I, "intDigits_I") + " should be in the range 2-"
                    + Std.intNUM_MAXIMUM_DIGITS);
        }

        //                                                  //Get x digits mantissa picture.
        //                                                  //Number will be rounded to x meaningful digits
        String strPicture = "0." + Std.padRight("", intDigits_I - 1, '0') + "E+0";
        String strToText = Std.toText(num_I, strPicture);

        //                                                  //May not have 'E'
        int intE = strToText.indexOf('E');

        if ( //
                intE >= 0 //
                ) {
            //                                              //Get exponent.
            String strExponent = strToText.substring(intE + 1);
            int intExponent = Std.parseToInt(strExponent);

            if ( //
                    //                                      //Decimal point can be move up to 4 position left and _____
                    //                                      //      (x - 2) rigth.
                    //                                      //At least 2 digits (0.0) should stay
                    (intExponent >= -4) && (intExponent <= (intDigits_I - 2)) //
                    ) {
                //                                          //Separate Sign and All Digits
                String strSign;
                String strAllDigits;
                if ( //
                        strToText.charAt(0) == '-') {
                    strSign = "-";
                    strAllDigits = strToText.charAt(1) + strToText.substring(3, intE);
                } //
                else {
                    strSign = "";
                    strAllDigits = strToText.charAt(0) + strToText.substring(2, intE);
                }

                //                                          //Move point left or right (remove 0s).
                //                                          //At least 2 digits (0.0) should remain
                strToText = (intExponent < 0)
                        ? "0." + Std.padRight("", -intExponent - 1, '0') + Std.trimEnd(strAllDigits, '0')
                        : strAllDigits.substring(0, 1 + intExponent) + '.' + strAllDigits.charAt(1 + intExponent)
                        + Std.trimEnd(strAllDigits.substring(2 + intExponent), '0');

                strToText = strSign + strToText;
            }
        }

        return strToText;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toText(
            //                                              //Text to picture.
            //                                              //str, number.

            double num_I,
            String strPicture_I
    ) {
        if ( //
                strPicture_I == null //
                ) {
            Test.abort(Test.toLog(strPicture_I, "strPicture_I") + " can not be null");
        }
        if ( //
                Arrays.binarySearch(Std.arrstrNUM_PICTURE_SORTED, strPicture_I) < 0 //
                ) {
            Test.abort(Test.toLog(strPicture_I, "strPicture_I") + " is not a valid picture",
                    Test.toLog(Std.NUMBER_PICTURES, "Std.arrstrNUM_PICTURE"));
        }

        String strToText;
        /*CASE*/
        if ( //
                (num_I == Double.POSITIVE_INFINITY) || (num_I == Double.NEGATIVE_INFINITY) || Std.isNaN(num_I) //
                ) {
            strToText = (num_I == Double.POSITIVE_INFINITY) ? "∞" : (num_I == Double.NEGATIVE_INFINITY) ? "-∞" : "NaN";
        } //
        else if ( //
                //                                          //Mantissa picture
                strPicture_I.contains("E")) {
            strToText = Std.strTextWithE(num_I, strPicture_I);
        } //
        else {
            //                                              //Normal picture
            strToText = Std.strTextWithoutE(num_I, strPicture_I);
        }
        /*END-CASE*/

        return strToText;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toTextBlankWhenZero(
            //                                              //Text to picture.
            //                                              //str, number.

            double num_I,
            //                                              //Could be normal or mantissa with Ed.., E+d.. or E-d..
            String strPicture_I
    ) {
        return ( //
                num_I == 0.0 //
                ) ? "" : Std.toText(num_I, strPicture_I);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static String strTextWithE( //
            //                                              //str, number.

            double num_I,
            String strPicture_I
    ) {
        String strTextWithE;
        if ( //
                Math.abs(num_I) <= 202402253307310.0 * Std.EPSILON //
                ) {
            //                                              //It is a very small number, significat digists should be
            //                                              //      reduced (2 to 15 digits)
            strTextWithE = Std.strTextVerySmall(num_I);
        } //
        else {
            //                                              //Java does not accept picture with E+ so it is replaced
            String strPicture = strPicture_I.replace("E+", "E");

            strTextWithE = (new DecimalFormat(strPicture)).format(num_I);

            //                                              //Change ...Ed.. to ...E+d.. (...E-d.. do not change)
            strTextWithE = Std.strCorrectE(strTextWithE);
        }

        return strTextWithE;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static String strTextVerySmall( //
            //                                              //E-323 and 324 display 1
            //                                              //E-322 displays 2 decimals.
            //                                              //.....
            //                                              //E-312 displays 12 decimals.
            //                                              //E-311 displays 13 decimals.
            //                                              //E-310 displays 14 decimals.
            //                                              //str, Reformated number.

            //                                              //x digits mantissa format. (E-310 to E-324)
            double num_I
    ) {
        double numAbs = Math.abs(num_I);
        String strSign = (num_I < 0.0) ? "-" : "";

        String strTextVerySmall;
        if (numAbs <= Std.EPSILON * 2.0) {
            //                                              //Rounding is special
            strTextVerySmall = strSign + ((numAbs == Std.EPSILON) ? "4.9" : "9.8") + "E-324";
        } //
        else {
            //                                              //Move point left 324 positions, round and get text for
            //                                              //      digits 
            double numNoDecimals = numAbs * 1.0E+300 * 1.0E+24;
            long longNoDecimals = (long) Math.rint(numNoDecimals);
            String strDigits = "" + longNoDecimals;

            //                                              //Form Text, 15==>1.5E-323, 123==>1.23E-322, ....,
            //                                              //      12345678901234==>1.2345678901234E-311,
            //                                              //      123456789012345==>1.23456789012345E-310,
            strTextVerySmall = strSign + strDigits.charAt(0) + '.' + strDigits.substring(1) + "E-"
                    + (325 - strDigits.length());
        }

        return strTextVerySmall;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static String strTextWithoutE( //
            //                                              //str, number.

            double num_I,
            String strPicture_I
    ) {
        String strTextWithoutE;
        if ( //
                //                                          //Requires more than 15 integer digits
                Math.abs(num_I) >= 1.0E+15 //
                ) {
            //                                              //Use mantissa with 14 decimals
            strTextWithoutE = (new DecimalFormat("0.00000000000000E0")).format(num_I);

            //                                              //Change ...Ed.. to ...E+d.. (...E-d.. do not change)
            strTextWithoutE = Std.strCorrectE(strTextWithoutE);
        } //
        else {
            String strTemporaryFormat = (new DecimalFormat(strPicture_I)).format(num_I);
            strTextWithoutE = Std.trimEnd(strTemporaryFormat, '0').compareTo("-0.") == 0
                    ? Std.trimStart(strTemporaryFormat, '-') : strTemporaryFormat;
        }

        return strTextWithoutE;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static String strCorrectE( //
            //                                              //Change ...Ed.. to ...E+d.. (...E-d.. do not change)
            //                                              //str, number.

            String strText_I
    ) {
        //                                                  //For sure there is 'E'
        int intE = strText_I.indexOf("E");

        //                                                  //Change ...Ed.. to ...E+d.. (...E-d.. do not change)
        return (strText_I.charAt(intE + 1) != '-') ? strText_I.replace("E", "E+") : strText_I;
    }

    //--------------------------------------------------------------------------------------------------------------
    public static boolean isParsableToNum(
            //                                              //Verify has the form:
            //                                              //[+-]d*[.d*][E[+-]d+], at least 1 digit before 'E', integer
            //                                              //      part may include ,'s, should remove before verify.
            //                                              //NOTE: (Glg 24Jul2018) in the near future, this method
            //                                              //      should be simplify using "regex" (regex "neutral"),
            //                                              //      we will execute a efficiency test comparing this
            //                                              //      implementation an regex implementation.
            //                                              //bool, true if ok

            String str_I
    ) {
        if ( //
                str_I == null //
                ) {
            Test.abort(Test.toLog(str_I, "str_I") + " can not be null");
        }

        //                                                  //Remove space on both sides.
        String strClean = Std.trim(str_I, ' ');

        boolean boolIsParsableToNum;
        if ( //
                //                                          //Non digits valid texts to produce a num
                (strClean.compareTo("Infinity") == 0) || (strClean.compareTo("+Infinity") == 0)
                || (strClean.compareTo("-Infinity") == 0) || (strClean.compareTo("∞") == 0)
                || (strClean.compareTo("+∞") == 0) || (strClean.compareTo("-∞") == 0)
                || (strClean.compareTo("NaN") == 0) //
                ) {
            boolIsParsableToNum = true;
        } //
        else {
            //                                              //Will mark to false
            boolIsParsableToNum = true;

            //                                              //Verify exponent and extract mantissa
            String strMantissa;
            int intE = strClean.indexOf('E');
            if ( //
                    intE >= 0 //
                    ) {
                //                                          //Mantissa + Exponent.
                String strExponent = strClean.substring(intE + 1);
                boolIsParsableToNum = Std.boolIsOnlyDigits(strExponent, true);
                strMantissa = strClean.substring(0, intE);
            } //
            else {
                //                                          //Only Mantissa
                strMantissa = strClean;
            }

            //                                              //Only if ok, continue with mantissa
            if ( //
                    boolIsParsableToNum //
                    ) {
                int intPoint = strMantissa.indexOf('.');

                //                                          //Need to include at least 1 digit before or after the
                //                                          //      point or, if no point, al least 1 digit at the end.
                if ( //
                        intPoint >= 0 //
                        ) {
                    boolIsParsableToNum = ( //
                            //                              //Digit before.
                            ((intPoint - 1) >= 0) && Std.isDigit(strMantissa.charAt(intPoint - 1))
                            //                              //Digit after
                            || ((intPoint + 1) < strMantissa.length())
                            && Std.isDigit(strMantissa.charAt(intPoint + 1)) //
                            );
                } //
                else {
                    boolIsParsableToNum = ( //
                            (strMantissa.length() > 0)
                            && (Std.isDigit(strMantissa.charAt(strMantissa.length() - 1))) //
                            );
                }

                //                                          //Verify decimal part
                if ( //
                        boolIsParsableToNum && (intPoint >= 0) //
                        ) {
                    String strDecimals = strMantissa.substring(intPoint + 1);
                    boolIsParsableToNum = Std.boolIsOnlyDigits(strDecimals, false);
                }

                //                                          //Verify integer part
                if ( //
                        boolIsParsableToNum //
                        ) {
                    String strInteger = (intPoint < 0) ? strMantissa : strMantissa.substring(0, intPoint);

                    //                                      //Exclude sign
                    if ( //
                            (strInteger.length() > 0)
                            && ((strInteger.charAt(0) == '+') || (strInteger.charAt(0) == '-')) //
                            ) {
                        strInteger = strInteger.substring(1);
                    }

                    //                                      //Integer part (no sign) can have the form: "" (empty), 1 
                    //                                      //      digit, digit + optional(digits and ,'s) + digits.
                    boolIsParsableToNum = (strInteger.compareTo("") == 0) ? true
                            : (strInteger.length() == 1) ? Std.isDigit(strInteger.charAt(0))
                            //                              //Start and End with digit
                            : (Std.isDigit(strInteger.charAt(0))
                            && Std.isDigit(strInteger.charAt(strInteger.length() - 1))
                            //                              //In the middle, only digits and ,'s
                            && Std.boolIsOnlyDigits(strInteger.substring(1, strInteger.length() - 1).replace(",", ""),
                                    false) //
                            );
                }
            }
        }
        return boolIsParsableToNum;
    }

    //--------------------------------------------------------------------------------------------------------------
    public static double parseToNum(
            //                                              //Text to number.
            //                                              //num, value

            //                                              //Ej. "123.456"
            String str_I
    ) {
        if ( //
                str_I == null //
                ) {
            Test.abort(Test.toLog(str_I, "str_I") + " can not be null");
        }
        if (!Std.isParsableToNum(str_I) //
                //
                //
                ) {
            Test.abort(Test.toLog(str_I, "str_I") + " can not parse to number");
        }

        //                                                  //Remove space on both sides
        String strClean = Std.trim(str_I, ' ');

        double numParseToNum;
        /*CASE*/
        if ( //
                (strClean.compareTo("Infinity") == 0) || (strClean.compareTo("+Infinity") == 0)
                || (strClean.compareTo("∞") == 0) || (strClean.compareTo("+∞") == 0) //
                ) {
            numParseToNum = Double.POSITIVE_INFINITY;
        } //
        else if ( //
                (strClean.compareTo("-Infinity") == 0) || (strClean.compareTo("-∞") == 0) //
                ) {
            numParseToNum = Double.NEGATIVE_INFINITY;
        } //
        else if ( //
                (strClean.compareTo("NaN") == 0) //
                ) {
            numParseToNum = Double.NaN;
        } //
        else {
            int intDecimalPoint = strClean.indexOf('.');

            //                                              //Remove commas (,) from integer part.
            //                                              //Ex. 1,234,567.123,45 => 1234567.123,45
            strClean = (intDecimalPoint < 0) ? strClean.replace(",", "")
                    : strClean.substring(0, intDecimalPoint).replace(",", "")
                    + strClean.substring(intDecimalPoint);

            boolean boolOk;

            try {
                numParseToNum = Double.parseDouble(strClean);
                boolOk = true;
            } //
            catch (NumberFormatException sysexcepError) {
                boolOk = false;
                Test.abort(Test.toLog(str_I, "str_I") + " can not be parsed to number",
                        Test.toLog(strClean, "strClean"), Test.toLog(boolOk, "boolOk"));
                numParseToNum = 0.0;
            }
        }
        /*END-CASE*/

        return numParseToNum;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static boolean boolIsOnlyDigits(
            //                                              //+ or - sign is optional.
            //                                              //bool, true if Ok

            String str_I,
            boolean boolOptionalSign_I
    ) {
        //                                                  //Advance sign
        int intI = ((str_I.length() >= 1) && ((str_I.charAt(0) == '+') || (str_I.charAt(0) == '-'))) ? 1 : 0;
        /*WHILE*/
        while ( //
                (intI < str_I.length()) && Std.isDigit(str_I.charAt(intI)) //
                ) {
            intI = intI + 1;
        }

        return ( //
                //                                          //Only digits
                intI >= str_I.length() //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //RELATIONAL OPERATORS*/
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //EQUALITY OPERATORS
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    public static boolean isNaN(
            //                                              //Verify if it is NaN (numNOT_A_NUMBER).
            //                                              //By IEEE 754 standard definition.
            //                                              //NOT_A_NUMBER == num is FALSE for all values including
            //                                              //      NOT_A_NUMBER.
            //                                              //A number has 2 posibibilities:
            //                                              //1. Beetwen NEGATIVE_INFINITY and POSITIVE_INFINITY.
            //                                              //2. NOT_A_NUMBER.
            //                                              //bool, true (NaN).

            //                                              //Ej. "123.456" o NaN
            double num_I
    ) {
        return (!( //
                (num_I >= Double.NEGATIVE_INFINITY) || (num_I <= Double.POSITIVE_INFINITY) //
                ));
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //********************************OTHER OPERATORS
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TERNARY CONDITIONAL OPERATOR
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //MINIMUM AND //MAXIMUM
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    public static double minOf(
            //                                              //Determina el valor mínimo.

            //                                              //num, MIN value.

            double... arrnum_I
    ) {
        if ( //
                arrnum_I == null //
                ) {
            Test.abort(Test.toLog(arrnum_I, "arrnum_I") + " can not be null");
        }
        if ( //
                arrnum_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrnum_I, "arrnum_I") + " should have at least 1 item");
        }

        double numMinOf = arrnum_I[0];

        for (int intI = 1; intI < arrnum_I.length; intI = intI + 1) {
            if ( //
                    arrnum_I[intI] < numMinOf //
                    ) {
                numMinOf = arrnum_I[intI];
            }
        }

        return numMinOf;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static double maxOf(
            //                                              //Determina el valor máximo.

            //                                              //num, MAX value.

            double... arrnum_I
    ) {
        if ( //
                arrnum_I == null //
                ) {
            Test.abort(Test.toLog(arrnum_I, "arrnum_I") + " can not be null");
        }
        if ( //
                arrnum_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrnum_I, "arrnum_I") + " should have at least 1 item");
        }

        double numMaxOf = arrnum_I[0];

        for (int intI = 1; intI < arrnum_I.length; intI = intI + 1) {
            if ( //
                    arrnum_I[intI] > numMaxOf //
                    ) {
                numMaxOf = arrnum_I[intI];
            }
        }

        return numMaxOf;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //MATHEMATICAL FUNCTIONS
    //
    //--------------------------------------------------------------------------------------------------------------
    public static double pow(
            //                                              //Math.Pow(1.0, ∞) ==> NaN.
            //                                              //Math.Pow(1.0, -∞) ==> NaN.
            //                                              //But it do not work.

            double num_I,
            double numExponent_I
    ) {

        return (Std.isNaN(num_I) && numExponent_I == 0.0) ? Double.NaN : Math.pow(num_I, numExponent_I);
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TRIGONOMETRICAL FUCNTIONS
    //                                                      //***** ESPERAR A VER LA PRUEBA COMPARATIVA PARA DECIDIR
    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/
    //
    /*
    private static final int intROUND_TRIGONOMETRICAL_FUCNTIONS = 6;
     */
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    /*
    //------------------------------------------------------------------------------------------------------------------
    private static double numSin( //
            double num_I
    ) {
        return Round(Math.sin(num_I), intROUND_TRIGONOMETRICAL_FUCNTIONS);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static double numCos( //
            double num_I
    ) {
        return Round(Math.cos(num_I), intROUND_TRIGONOMETRICAL_FUCNTIONS);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static double numTan( //
            double num_I
    ) {
        return Round(Math.tan(num_I), intROUND_TRIGONOMETRICAL_FUCNTIONS);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static double numAsin( //
            double num_I
    ) {
        return Round(Math.asin(num_I), intROUND_TRIGONOMETRICAL_FUCNTIONS);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static double numAcos( //
            double num_I
    ) {
        return Round(Math.acos(num_I), intROUND_TRIGONOMETRICAL_FUCNTIONS);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static double numAtan( //
            double num_I
    ) {
        return Round(Math.atan(num_I), intROUND_TRIGONOMETRICAL_FUCNTIONS);
    }
     */
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TOOLS FOR DEBUGGING
    //
    //------------------------------------------------------------------------------------------------------------------
    /*SUPPORT METHODS FOR INITIALIZER*/
    //
    //------------------------------------------------------------------------------------------------------------------
    private static void subVerifyConstantsNumber() {
        Std.subVerifyConstantsNumberRound();
        Std.subVerifyConstantsNumberConversionToText();
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static void subVerifyConstantsNumberRound() {
        if ( //
                Std.arrnum10S_FACTOR == null //
                ) {
            Test.abort(Test.toLog(Std.arrnum10S_FACTOR, "Std.arrnum10S_FACTOR") + " can not be null");
        }
        if ( //
                Std.arrnum10S_FACTOR.length == 0 //
                ) {
            Test.abort(Test.toLog(Std.arrnum10S_FACTOR, "Std.arrnum10S_FACTOR")
                    + " should contains at least 1 picture");
        }

        for (int intF = 1; intF < Std.arrnum10S_FACTOR.length; intF = intF + 1) {
            //                                      //Verify it is 10 times the previous
            if ( //
                    Std.arrnum10S_FACTOR[intF] != (10.0 * Std.arrnum10S_FACTOR[intF - 1]) //
                    ) {
                Test.abort(
                        Test.toLog(Std.arrnum10S_FACTOR[intF], "Std.arrnum10S_FACTOR[" + intF + "]")
                        + " should be 10 times "
                        + Test.toLog(arrnum10S_FACTOR[intF - 1], "Std.arrnum10S_FACTOR[" + (intF - 1) + "]"),
                        Test.toLog(Std.arrnum10S_FACTOR, "Std.arrnum10S_FACTOR"));
            }
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static void subVerifyConstantsNumberConversionToText() {
        if ( //
                Std.NUMBER_PICTURES == null //
                ) {
            Test.abort(Test.toLog(Std.NUMBER_PICTURES, "Std.arrstrNUM_PICTURE") + " can not be null");
        }
        if ( //
                Std.NUMBER_PICTURES.length == 0 //
                ) {
            Test.abort(Test.toLog(Std.NUMBER_PICTURES, "Std.arrstrNUM_PICTURE")
                    + " should contains at least 1 picture");
        }

        //                                                  //Verify it works
        for (int intI = 0; intI < Std.NUMBER_PICTURES.length; intI = intI + 1) {
            try {
                //                                          //num.strText(str) can not be used, initialization should be
                //                                          //      finished before.
                String str = (new DecimalFormat(Std.NUMBER_PICTURES[intI].replace("E+", "E"))).format(12345.6789);
            } // //
            catch (Exception sysexceptError) {
                Test.abort(Test.toLog(Std.NUMBER_PICTURES[intI], "Std.arrstrNUM_PICTURE[" + intI + "]")
                        + "can not be an standard picture, it do not work",
                        Test.toLog(Std.NUMBER_PICTURES, "Std.arrstrNUM_PICTURE"));
            }

            if ( //
                    Std.NUMBER_PICTURES[intI].contains(";") //
                    ) {
                Test.abort(Test.toLog(Std.NUMBER_PICTURES[intI], "Std.arrstrNUM_PICTURE_I[" + intI + "]")
                        + " can not contains ';' (picture separator), should include just ONE picture",
                        Test.toLog(Std.NUMBER_PICTURES, "Std.arrstrNUM_PICTURE_I"));
            }
        }

        Test.abortIfDuplicate(Std.arrstrNUM_PICTURE_SORTED, "Std.arrstrNUM_PICTURE_SORTED");

        //                                              //Verify limit
        if (!( //
                (Std.intNUM_MAXIMUM_DIGITS >= 10) && (Std.intNUM_MAXIMUM_DIGITS <= 15) //
                )) {
            Test.abort(
                    Test.toLog(Std.intNUM_MAXIMUM_DIGITS, "Std.intNUM_MAXIMUM_DIGITS")
                    + " should be in the range 10-15");
        }
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Std.Character*/
    //==================================================================================================================
    //                                                      //LITERAL
    //
    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/
    //                                                      //Se incluyen todos los caracteres del mismo tamaño que A
    //                                                      //      (SizeF en font consolas 10 points).
    //                                                      //Para efectos de entendimiento y documentación se agrupan
    //                                                      //      por UccUnicodeCategory (ascencente), también los
    //                                                      //      caracteres están en orden ascendente.
    //                                                      //Nótese que blank no está en este conjunto dado que su
    //                                                      //      SizeF es diferente.
    //                                                      //ES PROBABLE QUE EN OTRO FONT (diferente de consolas) ESTOS
    //                                                      //      CARACTERES SE MUESTREN DISTINTO.
    //                                                      //DADO QUE EL ESTÁNDAR ES USAR consolas PARA VISUALIZAR EL
    //                                                      //      CÓDIGO TANTO EN PANTALLA COMO EN IMPRESORA SE
    //                                                      //      UTILIZO ESTE FONT.
    //                                                      //TODAS ESTAS CONSTANTES PRETENDEN SER UNA AYUDA PARA
    //                                                      //      CODIFICAR Y PROBAR EL CÓDIGO.
    //                                                      //NÓTESE QUE:
    //                                                      //1. Cualquier caracter de x0000-xFFFF puede ser utilizado.
    //                                                      //2. Solo los caracteres en este conjunto y el blank
    //                                                      //      pueden ser visualizado en pantalla o en texto
    //                                                      //3. Solo loc caracteres en este conjunto, el blank y los de
    //                                                      //      escape pueden ser escritos en archivos de texto.
    //                                                      //4. Los métodos strTo hacen lo necesario para poner mostrar
    //                                                      //      todos los caracteres x0000-xFFFF en font consolas.
    private static final T2uccCategoryAndCharsTuple[] arrt2uccCHAR_USEFUL_IN_TEXT = {
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.UPPERCASE_LETTER,
        "ABCDEFGHIJKLMNOPQRSTUVWXYZÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞĀĂĄĆĈĊČĎĐĒĔĖĘĚĜĞĠĢĤĦĨĪĬĮİĲĴĶĹĻĽĿŁŃŅŇŊŌŎŐŒŔŖŘ"
        + "ŚŜŞŠŢŤŦŨŪŬŮŰŲŴŶŸŹŻŽƁƂƄƆƇƉƊƋƎƏƐƑƓƔƖƗƘƜƝƟƠƢƤƦƧƩƬƮƯƱƲƳƵƷƸƼǄǇǊǍǏǑǓǕǗǙǛǞǠǢǤǦǨǪǬǮǱǴǶǷǸǺǼǾȀȂȄȆȈȊȌȎȐȒȔȖȘȚȜȞȠ"
        + "ȢȤȦȨȪȬȮȰȲȺȻȽȾɁɃɄɅɆɈɊɌɎΆΈΉΊΌΎΏΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩΪΫϒϓϔϘϚϜϞϠϢϤϦϨϪϬϮϴϷϹϺϽϾϿЀЁЂЃЄЅІЇЈЉЊЋЌЍЎЏАБВГДЕЖ"
        + "ЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯѠѢѤѦѨѪѬѮѰѲѴѶѸѺѼѾҀҊҌҎҐҒҔҖҘҚҜҞҠҢҤҦҨҪҬҮҰҲҴҶҸҺҼҾӀӁӃӅӇӉӋӍӐӒӔӖӘӚӜӞӠӢӤӦӨӪӬӮӰӲӴӶӸӺӼ"
        + "ӾԀԂԄԆԈԊԌԎԐԒḀḂḄḆḈḊḌḎḐḒḔḖḘḚḜḞḠḢḤḦḨḪḬḮḰḲḴḶḸḺḼḾṀṂṄṆṈṊṌṎṐṒṔṖṘṚṜṞṠṢṤṦṨṪṬṮṰṲṴṶṸṺṼṾẀẂẄẆẈẊẌẎẐẒẔẠẢẤẦẨẪẬẮẰẲẴẶẸẺ"
        + "ẼẾỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴỶỸἈἉἊἋἌἍἎἏἘἙἚἛἜἝἨἩἪἫἬἭἮἯἸἹἺἻἼἽἾἿὈὉὊὋὌὍὙὛὝὟὨὩὪὫὬὭὮὯᾸᾹᾺΆῈΈῊΉῘῙῚΊῨῩῪΎῬῸΌῺΏ"
        + "ΩℲↃ"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.LOWERCASE_LETTER,
        "abcdefghijklmnopqrstuvwxyzªµºßàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿāăąćĉċčďđēĕėęěĝğġģĥħĩīĭįıĳĵķĸĺļľŀłńņňŉŋ"
        + "ōŏőœŕŗřśŝşšţťŧũūŭůűųŵŷźżžſƀƃƅƈƌƍƒƕƙƚƛƞơƣƥƨƪƫƭưƴƶƹƺƽƾƿǆǉǌǎǐǒǔǖǘǚǜǝǟǡǣǥǧǩǫǭǯǰǳǵǹǻǽǿȁȃȅȇȉȋȍȏȑȓȕȗșțȝȟȡȣȥ"
        + "ȧȩȫȭȯȱȳȴȵȶȷȸȹȼȿɀɂɇɉɋɍɏɐɑɒɓɔɕɖɗɘəɚɛɜɝɞɟɠɡɢɣɤɥɦɧɨɩɪɫɬɭɮɯɰɱɲɳɴɵɶɷɸɹɺɻɼɽɾɿʀʁʂʃʄʅʆʇʈʉʊʋʌʍʎʏʐʑʒʓʕʖʗʘʙʚʛʜʝʞ"
        + "ʟʠʡʢʣʤʥʦʧʨʩʪʫʬʭʮʯͻͼͽΐάέήίΰαβγδεζηθικλμνξοπρςστυφχψωϊϋόύώϐϑϕϖϗϙϛϝϟϡϣϥϧϩϫϭϯϰϱϲϳϵϸϻϼабвгдежзийклмнопрст"
        + "уфхцчшщъыьэюяѐёђѓєѕіїјљњћќѝўџѡѣѥѧѩѫѭѯѱѳѵѷѹѻѽѿҁҋҍҏґғҕҗҙқҝҟҡңҥҧҩҫҭүұҳҵҷҹһҽҿӂӄӆӈӊӌӎӏӑӓӕӗәӛӝӟӡӣӥӧөӫӭӯӱӳӵ"
        + "ӷӹӻӽӿԁԃԅԇԉԋԍԏԑԓḁḃḅḇḉḋḍḏḑḓḕḗḙḛḝḟḡḣḥḧḩḫḭḯḱḳḵḷḹḻḽḿṁṃṅṇṉṋṍṏṑṓṕṗṙṛṝṟṡṣṥṧṩṫṭṯṱṳṵṷṹṻṽṿẁẃẅẇẉẋẍẏẑẓẕẖẗẘẙẚẛạảấầ"
        + "ẩẫậắằẳẵặẹẻẽếềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹἀἁἂἃἄἅἆἇἐἑἒἓἔἕἠἡἢἣἤἥἦἧἰἱἲἳἴἵἶἷὀὁὂὃὄὅὐὑὒὓὔὕὖὗὠὡὢὣὤὥὦὧὰάὲέὴήὶ"
        + "ίὸόὺύὼώᾀᾁᾂᾃᾄᾅᾆᾇᾐᾑᾒᾓᾔᾕᾖᾗᾠᾡᾢᾣᾤᾥᾦᾧᾰᾱᾲᾳᾴᾶᾷιῂῃῄῆῇῐῑῒΐῖῗῠῡῢΰῤῥῦῧῲῳῴῶῷℓⅎↄﬁﬂ"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.TITLECASE_LETTER,
        //                                                  //Las siguiente ᾼῌῼ parecen iguales, sin embargo NO LO SON
        //                                                  //      las primeras 8 de cada grupo tienen antes arriba un
        //                                                  //      pequeño acento que las hace diferentes.
        //                                                  //NO SE PORQUE AQUÍ NO SE VE, sin embargo al separarlas como
        //                                                  //      char para forma sus t3fake aparecieron los acentos.
        "ǅǈǋǲᾈᾉᾊᾋᾌᾍᾎᾏᾘᾙᾚᾛᾜᾝᾞᾟᾨᾩᾪᾫᾬᾭᾮᾯᾼῌῼ"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.MODIFIER_LETTER,
        "ʰʱʲʳʴʵʶʷʸʹʺʻʼʽʾʿˀˁˆˇˈˉˊˋˌˍˎˏːˑˠˡˢˣˤˬˮʹͺⁱⁿₐₑₒₓₔ"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.OTHER_LETTER, "ƻǀǁǂǃʔ"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.NON_SPACING_MARK,
        //                                                  //Se eliminarnos 7 caracteres que parecen tener el mismo
        //                                                  //      tamaño que A, sin embargo se muestra hacía arriba.
        ""),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.SPACING_COMBINING_MARK, ""),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.ENCLOSING_MARK, ""),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.DECIMAL_DIGIT_NUMBER, "0123456789"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.LETTER_NUMBER, ""),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.OTHER_NUMBER,
        "²³¹¼½¾⁰⁴⁵⁶⁷⁸⁹₀₁₂₃₄₅₆₇₈₉⅓⅔⅕⅖⅗⅘⅙⅚⅛⅜⅝⅞①②③④⑤⑥⑦⑧⑨⑩⑪⑫⑬⑭⑮⑯⑰⑱⑲⑳⓫⓬⓭⓮⓯⓰⓱⓲⓳⓴⓿❶❷❸❹❺❻❼❽❾❿"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.SPACE_SEPARATOR, "             "),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.LINE_SEPARATOR, ""),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.PARAGRAPH_SEPARATOR, ""),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.CONTROL, ""),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.FORMAT, ""),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.SURROGATE, ""),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.PRIVATE_USE, ""),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.CONNECTOR_PUNCTUATION, "_"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.DASH_PUNCTUATION, "-‐‒–—―"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.OPEN_PUNCTUATION, "([{‚„⁽₍"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.CLOSE_PUNCTUATION, ")]}⁾₎"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.INITIAL_QUOTE_PUNCTUATION, "«‘‛“‟‹"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.FINAL_QUOTE_PUNCTUATION, "»’”›"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.OTHER_PUNCTUATION,
        "!\"#%&'*,./:;?@\\¡·¿;·‖‗†‡•…‰′″‴‼‽‾⁃⁞"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.MATH_SYMBOL,
        "+<=>|~¬±×÷϶⁄⁺⁻⁼₊₋₌←↑→↓↔∂∆∏∑−∕∙√∞∟∩∫≈≠≡≤≥⌠⌡"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.CURRENCY_SYMBOL, "$¢£¤¥₠₡₢₣₤₥₦₧₨₩₫€₭₮₯₰₱₲₳₴₵₸₹₺"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.MODIFIER_SYMBOL,
        "^`¨¯´¸˂˃˄˅˒˓˔˕˖˗˘˙˚˛˜˝˟˪˫˭˯˰˱˲˳˴˵˶˷˸˹˺˻˼˽˾˿͵΄΅᾽᾿῀῁῍῎῏῝῞῟῭΅`´῾"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.OTHER_SYMBOL,
        "¦§©®°¶҂℅№℗™℮⅍↕↨⌂⌐─│┌┐└┘├┤┬┴┼═║╒╓╔╕╖╗╘╙╚╛╜╝╞╟╠╡╢╣╤╥╦╧╨╩╪╫╬▀▄█▌▐"
        + "■□▪▫▬▲▴▸►▼▾◂◄◊○◌●◘◙◦☺☻☼♀♂♠♣♥♦♪♫✶"),
        new T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum.OTHER_NOT_ASSIGNED, "₼₽₾"),};

    //                                                      //Conjunto de caracteres escapados no visibles.
    //                                                      //Estos caracteres no deben existir en USEFUL y el
    //                                                      //      initializer los debe ordenar.
    public static final T2charDescriptionTuple[] arrt2charESCAPE
            = {
                new T2charDescriptionTuple('\0', "\\0 Zero"),
                new T2charDescriptionTuple('\b', "\\b Backspace"),
                new T2charDescriptionTuple('\f', "\\f Formfeed"),
                new T2charDescriptionTuple('\n', "\\n New Line"),
                new T2charDescriptionTuple('\r', "\\r Carriage Return"),
                new T2charDescriptionTuple('\t', "\\t Horizontal Tab"),};

    public static char[] CHARS_USEFUL_IN_TEXT;

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //DECLARATION AND ASSIGNMENT
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSIONS
    //
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    //------------------------------------------------------------------------------------------------------------------
    public static boolean isChar(
            //                                              //Checks wether an int can be converted to a char

            int int_I
    ) {
        return 0 <= int_I && int_I <= 65535;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSION TO HEXADECIMAL TEXT
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    public static String toHexText(
            //                                              //Convert character to hexadecimal.

            //                                              //str, 4 hexadecimal (Ej. 0129).

            char char_I
    ) {
        int intChar = (int) char_I;
        String str1To4Hex = String.format("%1$x", intChar);
        str1To4Hex = str1To4Hex.toUpperCase();
        String strToHexText = Std.padLeft(str1To4Hex, 4, '0');

        return strToHexText;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //RELATIONAL OPERATORS*/
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //EQUALITY OPERATORS
    //
    //                                                      //En .net existen las funciones Char.IsDigits,
    //                                                      //      Char.IsLetter y Char.IsLetterOrDigit, estas
    //                                                      //      reconocen como válidos los dígitos y letras en
    //                                                      //      TODOS los lenguajes implementados en .net.
    //                                                      //310 digits y 47,672 letters. By the time is changing
    //                          
    //                                                      //Aquí se implementas funciones para reconocer dígito (solo
    //                                                      //      0-9), letras (solo A-Z y a-z).
    //
    //------------------------------------------------------------------------------------------------------------------
    public static boolean isDigit(
            //                                              //bool, true if 0-9.

            char char_I
    ) {
        return ( //
                (char_I >= '0') && (char_I <= '9') //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isLetter(
            //                                              //bool, true if A-Z o a-z.

            char char_I
    ) {
        return ( //
                (char_I >= 'A') && (char_I <= 'Z')
                || (char_I >= 'a') && (char_I <= 'z') //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isDigitOrLetter(
            //                                              //bool, true if 0-9, A-Z or a-z.
            char char_I
    ) {
        return ( //
                (char_I >= '0') && (char_I <= '9')
                || (char_I >= 'A') && (char_I <= 'Z')
                || (char_I >= 'a') && (char_I <= 'z') //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isLetterUpper(
            //                                              //bool, true if A-Z.
            char char_I
    ) {
        return ( //
                (char_I >= 'A') && (char_I <= 'Z') //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isLetterLower(
            //                                              //bool, true if a-z.

            char char_I
    ) {
        return ( //
                (char_I >= 'a') && (char_I <= 'z') //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isDigitOrLetterUpper(
            //                                              //bool, true if 0-9 o A-Z.

            char char_I
    ) {
        return ( //
                (char_I >= '0') && (char_I <= '9')
                || (char_I >= 'A') && (char_I <= 'Z') //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isDigitOrLetterLower(
            //                                              //bool, true if 0-9 o a-z.
            char char_I
    ) {
        return ( //
                (char_I >= '0') && (char_I <= '9')
                || (char_I >= 'a') && (char_I <= 'z') //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //********************************OTHER OPERATORS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TERNARY CONDITIONAL OPERATOR
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //MINIMUM AND //MAXIMUM
    //
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    //------------------------------------------------------------------------------------------------------------------
    public static char minOf(
            //                                              //Determina el valor mínimo.

            //                                              //char, MIN value.

            char... arrchar_I
    ) {
        if ( //
                arrchar_I == null //
                ) {
            Test.abort(Test.toLog(arrchar_I, "arrchar_I") + " can not be null");
        }
        if ( //
                arrchar_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrchar_I, "arrchar_I") + " should have at least 1 item");
        }

        char charMinOf = arrchar_I[0];

        for (int intI = 1; intI < arrchar_I.length; intI = intI + 1) {
            if ( //
                    arrchar_I[intI] < charMinOf //
                    ) {
                charMinOf = arrchar_I[intI];
            }
        }

        return charMinOf;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static char maxOf(
            //                                              //Determina el valor máximo.

            //                                              //char, MAX value.

            char... arrchar_I
    ) {
        if ( //
                arrchar_I == null //
                ) {
            Test.abort(Test.toLog(arrchar_I, "arrchar_I") + " can not be null");
        }
        if ( //
                arrchar_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrchar_I, "arrchar_I") + " should have at least 1 item");
        }

        char charMaxOf = arrchar_I[0];

        for (int intI = 1; intI < arrchar_I.length; intI = intI + 1) {
            if ( //
                    arrchar_I[intI] > charMaxOf //
                    ) {
                charMaxOf = arrchar_I[intI];
            }
        }

        return charMaxOf;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TOOLS FOR DEBUGGING
    //
    //------------------------------------------------------------------------------------------------------------------
    /*SUPPORT METHODS FOR INITIALIZER*/
    //
    //------------------------------------------------------------------------------------------------------------------
    private static void subVerifyConstantsCharacter( //                                              //Método de apoyo llamado en constructor estático.
            //                                              //Prepara las constantes para poder utilizarlas.
            //                                              //2. arrt2uccCHAR_USEFUL_IN_TEXT:
            //                                              //2a. Este ordenada por ucc, sin duplicados.
            //                                              //2b. Dentro de cada ucc, este ordenada por la secuencia del
            //                                              //      caracter, sin duplicados
            //                                              //2c. Todos sean <= al caracter xD7FF.
            //                                              //2d. En forma global, no haya caracteres duplicados.
            //                                              //3. arrt3fakecharFAKE:
            //                                              //3a. ordenar.
            //                                              //3b. no duplicados
            //                                              //3c. charFAKE debe estar en USEFUL.
            //                                              //3d. charHEX y charFAKE debe ser el mismo.
            //                                              //3e. strDESCRIPTION "..... ?(u????)", el x???? debe ser la
            //                                              //      correspondiente al caracter ?.
            //                                              //4. arrt2charNONPRINTABLE.
            //                                              //4a. ordenar.
            //                                              //4b. no duplicados
            //                                              //4c. debe estar en USEFUL.
            //                                              //4d. tener descripción.
            //                                              //5. arrt2charESCAPE.
            //                                              //5a. ordenar.
            //                                              //5b. no duplicados
            //                                              //5c. NO debe estar en USEFUL.
            //                                              //5d. tener descripción.
            ) {
        Std.subVerifyArrt2uccCharUsefulInText();

        Std.subVerifyArrt2charEscape();
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void subVerifyArrt2uccCharUsefulInText( //                                              //2. arrt2uccCHAR_USEFUL_IN_TEXT:
            //                                              //2a. Este ordenada por ucc, sin duplicados.
            //                                              //2b. Dentro de cada ucc, este ordenada por la secuencia del
            //                                              //      caracter, sin duplicados
            //                                              //2c. Todos sean <= al caracter xD7FF.
            //                                              //2d. En forma global, no haya caracteres duplicados.
            ) {
        //                                                  //To easy code
        T2uccCategoryAndCharsTuple[] arrt2ucc = Std.arrt2uccCHAR_USEFUL_IN_TEXT;

        //                                                  //Verifica secuencia de cada ucc
        for (int intUcc = 1; intUcc < arrt2ucc.length; intUcc = intUcc + 1) {
            if ( //
                    //                                      //No estan en orden ascendente
                    arrt2ucc[intUcc - 1].ucc.compareTo(arrt2ucc[intUcc].ucc) >= 0 //
                    ) {
                Test.abort(
                        Test.toLog(arrt2ucc[intUcc].ucc, "arrt2ucc[" + intUcc + "].ucc")
                        + " should be in ascending order",
                        Test.toLog(arrt2ucc, "arrt2ucc"));
            }
        }

        //                                                  //Verifica chars en cada ucc
        for (int intUcc = 0; intUcc < arrt2ucc.length; intUcc = intUcc + 1) {
            String strChars = arrt2ucc[intUcc].strChars;

            //                                              //Verify ascending sequence
            for (int intC = 1; intC < strChars.length(); intC = intC + 1) {
                if ( //
                        strChars.charAt(intC - 1) >= strChars.charAt(intC) //
                        ) {
                    Test.abort(
                            Test.toLog(strChars.charAt(intC), "arrt2ucc[" + intUcc + "].strChars[" + intC + "]")
                            + " should be in ascending order",
                            Test.toLog(strChars, "arrt2ucc[" + intUcc + "].strChars"));
                }
            }
        }

        Test.abortIfDuplicate(Std.CHARS_USEFUL_IN_TEXT, "Std.arrcharUSEFUL_IN_TEXT");
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void subVerifyArrt2charEscape( //                                              //5. arrt2charESCAPE.
            //                                              //5a. ordenar.
            //                                              //5b. no duplicados
            //                                              //5c. NO debe estar en USEFUL.
            //                                              //5d. tener descripción.
            ) {
        //                                                  //Verifica no duplicados
        Test.abortIfDuplicate(Std.arrt2charESCAPE, "Std.arrt2charESCAPE");

        //                                                  //Verifica chars en tupla
        for (int intT2 = 0; intT2 < arrt2charESCAPE.length; intT2 = intT2 + 1) {
            if (Std.isInSortedSet(Std.arrt2charESCAPE[intT2].charX, Std.CHARS_USEFUL_IN_TEXT)) {
                Test.abort(
                        Test.toLog(Std.arrt2charESCAPE[intT2].charX, "Std.arrt2charESCAPE[" + intT2 + "].charX")
                        + " exists in USEFUL_IN_TEXT",
                        Test.toLog(Std.arrt2charESCAPE[intT2], "Std.arrt2charESCAPE[" + intT2 + "]"),
                        Test.toLog(Std.arrt2charESCAPE, "Std.arrt2charESCAPE"));
            }

            Test.abortIfItemIsInSortedSet(Std.arrt2charESCAPE[intT2].charX,
                    "Std.arrt2charESCAPE[" + intT2 + "].charX",
                    Std.CHARS_USEFUL_IN_TEXT, "(Std.arrcharUSEFUL_IN_TEXT");
            Test.abortIfNullOrEmpty(Std.arrt2charESCAPE[intT2].strDESCRIPTION,
                    "Std.arrt2charESCAPE[intT2].strDESCRIPTION");
            /*
            if ( //
                    Std.arrt2charESCAPE[intT2].strDESCRIPTION == null //
                    ) {
                if ( //
                        Arrays.binarySearch(Std.arrcharUSEFUL_IN_TEXT, Std.arrt2charESCAPE[intT2].charX) >= 0 //
                        ) {
                    Test.abort(
                            Test.toLog(Std.arrt2charESCAPE[intT2].strDESCRIPTION,
                                    "Std.arrt2charESCAPE[" + intT2 + "].strDESCRIPTION")
                            + " can not be null",
                            Test.toLog(Std.arrt2charESCAPE[intT2], "Std.arrt2charESCAPE[" + intT2 + "]"),
                            Test.toLog(Std.arrt2charESCAPE, "Std.arrt2charESCAPE"));
                }
            }

            if ( //
                    Std.arrt2charESCAPE[intT2].strDESCRIPTION.compareTo("") == 0 //
                    ) {
                Test.abort(
                        Test.toLog(Std.arrt2charESCAPE[intT2].strDESCRIPTION,
                                "Std.arrt2charESCAPE[" + intT2 + "].strDESCRIPTION")
                        + " should have a description",
                        Test.toLog(Std.arrt2charESCAPE[intT2], "Std.arrt2charESCAPE[" + intT2 + "]"),
                        Test.toLog(Std.arrt2charESCAPE, "Std.arrt2charESCAPE"));
            }
             */
        }
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Std.Boolean*/
    //==================================================================================================================
    //                                                      //LITERALS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //DECLARATION AND ASSIGNMENT
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSION TO TEXT
    //
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    //--------------------------------------------------------------------------------------------------------------
    public static String toText(
            //                                              //str, boolean to text ("true" or "false").

            boolean bool_I
    ) {
        return (bool_I) ? "true" : "false";
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isParsableToBool( //
            //                                              //Tries to parse a String to determine if its a bool
            //                                              //      primitive.
            //                                              //bool, true it represente  a boolean

            String str_I
    ) {
        String strClean = Std.trim(str_I, ' ').toLowerCase();

        return ( //
                (strClean.compareTo("true") == 0) || (strClean.compareTo("false") == 0) //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean parseToBool( //
            //                                              //Parses a valid String to determine what boolean it is.
            //                                              //bool, true if represent "true", false it "false"
            //                                              //String to parse

            String str_I
    ) {
        String strClean = Std.trim(str_I, ' ').toLowerCase();

        if (!( //
                //                                          //Is parsable
                (strClean.compareTo("true") == 0) || (strClean.compareTo("false") == 0) //
                )) {
            Test.abort(Test.toLog(str_I, "str_I") + " is not parsable to boolean");
        }

        return ( //
                strClean.compareTo("true") == 0 //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //UNARY OPERATOR*/
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //EQUALITY OPERATORS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //********************************OTHER OPERATORS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TOOLS FOR DEBUGGING
    //
    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Std.String*/
    //==================================================================================================================
    //                                                      //LITERALS
    //------------------------------------------------------------------------------------------------------------------
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //MINIMUM AND //MAXIMUM
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    public static String minOf(
            //                                              //Determina el valor mínimo.
            //                                              //Nótese que 4,512 valores tienen .CompareTo() == 0 con
            //                                              //      "\x0000" que es uno de los strMIN.
            //                                              //strLOW_VALUE es "\x0000".
            //                                              //Muchos valores puede ser iguales en .CompareTo(), se
            //                                              //      reconocera como MIN el primero que se encuentre.

            //                                              //str, MIN value ("A" es antes que "A ").

            String... arrstr_I
    ) {
        if ( //
                arrstr_I == null //
                ) {
            Test.abort(Test.toLog(arrstr_I, "arrstr_I") + " can not be null");
        }
        if ( //
                arrstr_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrstr_I, "arrstr_I") + " should have at least 1 item");
        }

        String strMinOf = arrstr_I[0];

        for (int intI = 1; intI < arrstr_I.length; intI = intI + 1) {
            if ( //
                    arrstr_I[intI].compareTo(strMinOf) < 0 //
                    ) {
                strMinOf = arrstr_I[intI];
            }
        }

        return strMinOf;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String maxOf(
            //                                              //Determina el valor máximo.
            //                                              //Nótese que determinará el máximo conforme a la secuencia
            //                                              //      del mismo orden que se genera en Array.Sort(arrstr),
            //                                              //      en este orden "\xFFFF" no es el valor máximo.
            //                                              //strHIGH_VALUE es "\x3034".
            //                                              //Nótese que 15 valores tienen .CompareTo() == 0 con
            //                                              //      "\xFF70" que es uno de los strMAX.
            //                                              //strHIGH_VALUE es "\xFF70".
            //                                              //Muchos valores puede ser iguales en .CompareTo(), se
            //                                              //      reconocera como MAX el primero que se encuentre.

            //                                              //str, MAX value. ("A " es despues que "A").

            String... arrstr_I
    ) {
        if ( //
                arrstr_I == null //
                ) {
            Test.abort(Test.toLog(arrstr_I, "arrstr_I") + " can not be null");
        }
        if ( //
                arrstr_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrstr_I, "arrstr_I") + " should have at least 1 item");
        }

        String strMaxOf = arrstr_I[0];

        for (int intI = 1; intI < arrstr_I.length; intI = intI + 1) {
            if ( //
                    arrstr_I[intI].compareTo(strMaxOf) > 0 //
                    ) {
                strMaxOf = arrstr_I[intI];
            }
        }

        return strMaxOf;
    }
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //SECTION???

    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    public static int searchWord(
            //                                              //Busca una "palabra" en un String, una "palabra" es un
            //                                              //      conjunto de caracteres (diferentes de espacios)
            //                                              //      DELIMITED por el inicio o fin del String o por uno
            //                                              //      o varios espacios. Ej. en el String "__ABC___ZYZ" se
            //                                              //      tiene las palabras "ABC" y XYZ" (ojo en el String se
            //                                              //      uso _ como sustituto de espacio).

            //                                              //int, posición (base 0) donde encuentra la palabra, -1 si
            //                                              //      no encontró.

            //                                              //String sobre el cual se buscará la palabra.
            String str_I,
            //                                              //Palabra que se buscará. (Deben ser caracteres continuos
            //                                              //      sin espacios).
            String strWord_I
    ) {
        //Inicializa resultado a NO ENCONTRO
        int intSearchWord = -1;

        int intStart = 0;

        /*LOOP*/
        while (true) {
            //                                              //Se cicla para buscar el incial de las siguiente palabra en
            //                                              //      String, termina cuando:
            /*UNTIL-DO*/
            while (!( //
                    //                                      //Llego al fin del String.
                    (intStart >= str_I.length())
                    //                              //Encuentra el inicio de una palabra
                    || (str_I.charAt(intStart) != ' ')) //
                    ) {
                intStart = intStart + 1;
            }

            /*EXIT-IF*/
            if ( //
                    //                                          //En el ciclo anterior encontro la palabra
                    (intSearchWord >= 0)
                    //                              //LLego al fin del String.
                    || (intStart >= str_I.length()) //
                    ) {
                break;
            }

            //                                              //Se cicla para buscar el fin de la palabra que inicia en
            //                                              //      intIni.
            int intEnd = intStart;
            /*UNTIL-DO*/
            while (!( //
                    //                                      //Llego al fin del String
                    (intEnd >= str_I.length())
                    //                              //Encontró el fin de la palabra
                    || (str_I.charAt(intEnd) == ' ')) //
                    ) {
                intEnd = intEnd + 1;
            }

            if ( //
                    str_I.substring(intStart, intEnd - intStart).compareTo(strWord_I) == 0 //
                    ) {
                //                                          //Pasa la posición de la palabra
                intSearchWord = intStart;
            }

            intStart = intEnd + 1;
        }
        /*END-LOOP*/

        return intSearchWord;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String trimStart(
            //                                              //Removes all leading occurrences of a set of characters
            //                                              //      from a string. Uses varargs for the set of
            //                                              //      characters, meaning that it can receive from 0 to N
            //                                              //      different chars. Method may be called like:
            //                                              //      trimStart("aabbcc", 'a'), which will return "bbcc",
            //                                              //      or may be called like:
            //                                              //      trimStart("aabbcc", 'a', 'b'), which will return
            //                                              //      "cc". If the method is called with no chars, it will
            //                                              //      return the same string that was sent as input (it
            //                                              //      would have no sense to call the method with no
            //                                              //      chars).

            //                                              //The String to trim.
            String strToTrim_I,
            //                                              //The set of leading chars to be trimmed.
            char... arrcharToTrim_I
    ) {
        if ( //
                //
                arrcharToTrim_I == null //
                ) {
            Test.abort(Test.toLog(arrcharToTrim_I, "arrcharToTrim_I") + " can not be null");
        }
        if ( //
                //
                arrcharToTrim_I.length == 0 //
                ) {
            Test.abort(Test.toLog(strToTrim_I, "strToTrim_I") + ", "
                    + Test.toLog(arrcharToTrim_I.length, "arrcharToTrim_I.length") + " should have at least 1 element");
        }

        //                                                  //Find length to trim
        int intLengthToTrim = 0;
        /*WHILE-DO*/
        while ( //
                (intLengthToTrim < strToTrim_I.length())
                && Std.isInSortedSet(strToTrim_I.charAt(intLengthToTrim), arrcharToTrim_I) //
                ) {
            intLengthToTrim = intLengthToTrim + 1;
        }

        return strToTrim_I.substring(intLengthToTrim);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String trimEnd(
            //                                              //Removes all trailing occurrences of a set of characters
            //                                              //      from a string.

            //                                              //The string to trim.
            String strToTrim_I,
            //                                              //The set of trailing chars to be trimmed.
            char... arrcharToTrim_I
    ) {
        if ( //
                //
                arrcharToTrim_I == null //
                ) {
            Test.abort(Test.toLog(arrcharToTrim_I, "arrcharToTrim_I") + " can not be null");
        }
        if ( //
                //
                arrcharToTrim_I.length == 0 //
                ) {
            Test.abort(Test.toLog(strToTrim_I, "strToTrim_I") + ", "
                    + Test.toLog(arrcharToTrim_I.length, "arrcharToTrim_I.length") + " should have at least 1 element");
        }

        //                                                  //Find length to trim
        int intLengthToTrim = 0;
        /*WHILE-DO*/
        while ( //
                (intLengthToTrim < strToTrim_I.length())
                && Std.isInSortedSet(strToTrim_I.charAt(strToTrim_I.length() - 1 - intLengthToTrim),
                        arrcharToTrim_I) //
                ) {
            intLengthToTrim = intLengthToTrim + 1;
        }

        return strToTrim_I.substring(0, strToTrim_I.length() - intLengthToTrim);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String trim(
            //                                              //Removes all leading and trailing occurrences of a set of
            //                                              //      characters from a string.

            //                                              //The string to trim.
            String strToTrim_I,
            //                                              //The set of chars to be trimmed.
            char... arrcharToTrim_I
    ) {
        if ( //
                //
                strToTrim_I == null //
                ) {
            Test.abort(Test.toLog(strToTrim_I, "strToTrim_I") + " can not be null");
        }
        if ( //
                //
                arrcharToTrim_I == null //
                ) {
            Test.abort(Test.toLog(arrcharToTrim_I, "arrcharToTrim_I") + " can not be null");
        }
        if ( //
                //
                arrcharToTrim_I.length == 0 //
                ) {
            Test.abort(Test.toLog(strToTrim_I, "strToTrim_I") + ", "
                    + Test.toLog(arrcharToTrim_I.length, "arrcharToTrim_I.length") + " should have at least 1 element");
        }

        String strTrim;
        if ( //
                //
                //                                          //Es el caso especial de str.trim()
                (arrcharToTrim_I.length == 1) && (arrcharToTrim_I[0] == ' ') //
                ) {
            strTrim = strToTrim_I.trim();
        } //
        else {
            strTrim = Std.trimStart(strToTrim_I, arrcharToTrim_I);
            strTrim = Std.trimEnd(strTrim, arrcharToTrim_I);
        }

        return strTrim;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String trimExcel(
            //                                              //Hace un Trim similar al lo que hace Excel, esto es,
            //                                              //      elimina los espacios al principio y al final y solo
            //                                              //      deja un espacio entre las palabras que contenga, una
            //                                              //      palabra es un conjunto de caracteres contiguos
            //                                              //      diferentes a espacio.

            //                                              //str, ya sin espacios en exceso (Trim EXCEL).

            //                                              //String para hacer el Trim EXCEL
            String str_I
    ) {
        //                                                  //Se cicla para buscar el inicio de la primera palabra, sale
        //                                                  //      cuando
        int intIni = 0;
        /*UNTIL-DO*/
        while (!( //
                //                                          //Llego al fin del String
                (intIni >= str_I.length())
                //                                          //Encuentra caracter diferente de espacio
                || (str_I.charAt(intIni) != ' ')) //
                ) {
            intIni = intIni + 1;
        }

        String strTrimExcel = "";

        Oint ointIni = new Oint(intIni);
        O<String> ostrWord = new O<>();
        //                                                  //Se cicla para procesar cada palabra
        /*LOOP*/
        while (true) {
            //                                              //Extrae la siguiente palabra del String
            Std.subWord(str_I, ointIni, ostrWord);

            //                                              //Concatena la palabra
            strTrimExcel = strTrimExcel + ostrWord.v;

            /*EXIT-IF*/
            if ( //
                    //                                          //sale cuando llega al fin del String
                    ointIni.v >= str_I.length() //
                    ) {
                break;
            }

            strTrimExcel = strTrimExcel + " ";
        }
        /*END-LOOP*/

        return strTrimExcel;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void subWord(
            //                                              //Procesa una palabra del String.

            //                                              //String que contiene las palabras.
            String str_I,
            //                                              //Posición donde inicia la palabra que se procesará, regresa
            //                                              //      la posición del inicio de la siguiente palabra, o la
            //                                              //      posición inmediata al fin del String.
            Oint ointI_IO,
            //                                              //Palabra procesada.
            O<String> ostrWord_O
    ) {
        //                                                  //Se cicla buscando el fin de la palabra, sale cuando;
        int intFin = ointI_IO.v;
        /*UNTIL-DO*/
        while (!( //
                //                                          //Llega al fin del String
                (intFin >= str_I.length())
                //                                  //Encontró un espacio (fin de palabra)
                || (str_I.charAt(intFin) == ' ')) //
                ) {
            intFin = intFin + 1;
        }

        ostrWord_O.v = str_I.substring(ointI_IO.v, intFin);

        //                                                  //Se cicla buscando el inicio de la siguiente palabra, hasta
        ointI_IO.v = intFin;
        /*UNTIL-DO*/
        while (!( //
                //                                          //Llega al fin del String
                (ointI_IO.v >= str_I.length())
                //                                          //Encontró el inicio de la siguiente palabra
                || (str_I.charAt(ointI_IO.v) != ' ')) //
                ) {
            ointI_IO.v = ointI_IO.v + 1;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/
    //                                                      //Blank string to easy pading (1,000 blanks)
    private static final String strBlanks
            = "                                                                                                    "
            + "                                                                                                    "
            + "                                                                                                    "
            + "                                                                                                    "
            + "                                                                                                    "
            + "                                                                                                    "
            + "                                                                                                    "
            + "                                                                                                    "
            + "                                                                                                    "
            + "                                                                                                    ";

    //------------------------------------------------------------------------------------------------------------------
    private static String strToAdd( //
            //                                              //Genera los espacios to add (PadLeft or PadRight)
            int intLength_I,
            char charFiller_I
    ) {
        String strToAdd;
        if ( //
                intLength_I <= Std.strBlanks.length() //
                ) {
            strToAdd = Std.strBlanks.substring(0, intLength_I);
        } //
        else {
            //                                              //Es necesario generar más blancos
            int intModule = intLength_I % Std.strBlanks.length();
            int intTimes = intLength_I / Std.strBlanks.length();

            strToAdd = Std.strBlanks.substring(0, intModule);
            for (int intX = 1; intX <= intTimes; intX = intX + 1) {
                strToAdd = strToAdd + Std.strBlanks;
            }
        }

        if ( //
                charFiller_I != ' ' //
                ) {
            strToAdd = strToAdd.replace(' ', charFiller_I);
        }

        return strToAdd;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String padLeft(
            String strToPad_I,
            int intLength_I
    ) {
        return Std.padLeft(strToPad_I, intLength_I, ' ');
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static String padLeft(
            String strToPad_I,
            int intLength_I,
            char charRight_I
    ) {
        String strPadLeft = strToPad_I;
        if ( //
                intLength_I > strToPad_I.length() //
                ) {
            //                                              //Need to pad
            String strToAddLeft = Std.strToAdd(intLength_I - strToPad_I.length(), charRight_I);

            strPadLeft = strToAddLeft + strPadLeft;
        }

        return strPadLeft;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String padRight(
            String strToPad_I,
            int intLength_I
    ) {
        return Std.padRight(strToPad_I, intLength_I, ' ');
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static String padRight(
            String strToPad_I,
            int intLength_I,
            char charLeft_I
    ) {
        String strPadRight = strToPad_I;
        if ( //
                intLength_I > strToPad_I.length() //
                ) {
            //                                              //Need to pad
            String strToAddRight = Std.strToAdd(intLength_I - strToPad_I.length(), charLeft_I);

            strPadRight = strPadRight + strToAddRight;
        }

        return strPadRight;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String center(
            //                                              //Centra el texto y lo edita.
            //                                              //Si el filler es impar, el relleno del lado derecho será un
            //                                              //      caracter de relleno un caracter mayor al de la
            //                                              //      izquierda.

            //                                              //str, texto centrado conforme a los parámetros, si excede
            //                                              //      la longitud deseada se trunca y se deja como último
            //                                              //      caracter '…'.

            //                                              //Texto que debe ser alineado.
            String strText_I,
            //                                              //Longitud del texto nuevo que se debe producir.
            int intLength_I,
            //                                              //Caracter para relleno a la izquierda.
            char charLeft_I,
            //                                              //Caracter para relleno a la derecha.
            char charRight_I
    ) {
        //                                                  //Para formar el nuevo String.
        String strCenter = strText_I;

        //                                                  //Si excede el tamaño deseado lo trunca del lado derecho.
        if ( //
                //                                              //Excede el tamaño
                strText_I.length() > intLength_I //
                ) {
            //                                              //Corta la parte excedente.
            strCenter = strCenter.substring(0, intLength_I - 1) + '…';
        }

        //                                                  //Calcula la cantidad de caracteres de inicio y fin.
        int intFiller = intLength_I - strCenter.length();

        //                                                  //Si el valor en impar lo redondea hacia abajo.
        int intLeft = intFiller / 2;
        int intRigth = intFiller - intLeft;

        //                                                  //Genera el texto con los inicio y fin y el texto alineado.
        //                                                  //Nótese que es indistinto usar PadLeft o PadRight
        strCenter = padLeft("", intLeft, charLeft_I) + strCenter + padLeft("", intRigth, charRight_I);

        return strCenter;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String pluralS(
            //                                              //Text "s" for plural.
            //                                              //str, "s" or "".

            int int_I
    ) {
        return (int_I == 1) ? "" : "s";
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String pluralEs(
            //                                              //Text "es" for plural.
            //                                              //str, "es" or "".

            int int_I
    ) {
        return (int_I == 1) ? "" : "es";
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Std.Type*/
    //==================================================================================================================

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isSubclassof( //
            //                                              //Only for user defined type.
            //                                              //bool, true if first is a subclass of second

            Class typeFirst_I,
            //                                              //Should be abstract (to be true, more abstract than the
            //                                              //      first
            Class typeSecond_I
    ) {
        if (!( //
                BobjBaseObjectAbstract.class.isAssignableFrom(typeFirst_I) //
                )) {
            Test.abort(Std.name(typeFirst_I) + " should be a user defined type",
                    Test.toLog(typeFirst_I, "typeFirst_I"),
                    Test.toLog(BobjBaseObjectAbstract.class, "typeof(BobjBaseObjectAbstract)"));
        }
        if (!( //
                BobjBaseObjectAbstract.class.isAssignableFrom(typeSecond_I) //
                )) {
            Test.abort(Std.name(typeSecond_I) + " should be a user defined type",
                    Test.toLog(typeSecond_I, "typeSecond_I"),
                    Test.toLog(BobjBaseObjectAbstract.class, "typeof(BobjBaseObjectAbstract)"));
        }

        return ( //
                //                                          //Is assignable but not the same
                typeSecond_I.isAssignableFrom(typeFirst_I) || (typeFirst_I != typeSecond_I) //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String name(
            //                                              //Neutralize type name.
            //                                              //str, standard name.

            Class type_I
    ) {
        String strName;
        /*CASE*/
        if ( //
                type_I.isArray() //
                ) {
            //                                              //3 options: obj[], obj[][] and  obj[][][] 

            Class typeComponent1 = type_I.getComponentType();

            //                                              //Component1 has 3 options: obj, obj[] and  obj[][] 
            if ( //
                    !typeComponent1.isArray() //
                    ) {
                //                                          //Component1 ==> obj
                strName = typeComponent1.getSimpleName() + "[]";
            } //
            else {
                Class typeComponent2 = typeComponent1.getComponentType();

                //                                          //Component2 has 2 options: obj and obj[] 
                if ( //
                        !typeComponent2.isArray() //
                        ) {
                    //                                      //Component2 ==> obj
                    strName = typeComponent2.getSimpleName() + "[,]";
                } //
                else {
                    Class typeComponent3 = typeComponent2.getComponentType();

                    //                                      //Component3 has just 1 option: obj 
                    strName = typeComponent3.getSimpleName() + "[,,]";
                }
            }
        } //
        else if ( //
                //                                          //CORREGIR.
                //                                          //No supe como saber si e "generic", es necesario leer más
                //                                          //      y/o PROBAR
                type_I.isAnonymousClass() //
                ) {
            strName = type_I.getSimpleName();

            //                                              //Convert some names to standard generic name
            strName = (strName.equals("ArrayList")) ? "DynamicArray"
                    : (strName.equals("HashMap")) ? "Directory"
                    : strName;

            strName = "Should be a generic type, WORK IN PROGRESS!! " + strName + "<>";
        } //
        else {
            strName = type_I.getSimpleName();

            //                                              //Convert some names to standard name
            strName = (strName.equals("Integer")) ? "int"
                    : (strName.equals("Long")) ? "long"
                    : (strName.equals("Double")) ? "number"
                    : (strName.equals("Character")) ? "char"
                    : (strName.equals("Boolean")) ? "bool"
                    : (strName.equals("Class")) ? "Type"
                    : (strName.equals("DateX")) ? "Date"
                    : (strName.equals("FileX")) ? "File"
                    : (strName.equals("Scanner")) ? "TextReader"
                    : (strName.equals("PrintWriter")) ? "TextWriter"
                    : strName;
        }
        /*END-CASE*/

        return strName;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isAbstract( //
            //                                              //Only for user defined type.
            //                                              //bool, true if abstract

            Class type_I
    ) {
        if (!( //
                BobjBaseObjectAbstract.class.isAssignableFrom(type_I) //
                )) {
            Test.abort(Std.name(type_I) + " should be a user defined type",
                    Test.toLog(type_I, "type_I"),
                    Test.toLog(BobjBaseObjectAbstract.class, "typeof(BobjBaseObjectAbstract)"));
        }

        String strFullName = type_I.getName();

        //                                                  //[Glg, 19Abr2019] I did nol like to use "name" but I could
        //                                                          not find other option.
        //                                                  //As long as standard requiere "...Abtract" this work fine
        return strFullName.endsWith("Abstract");
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String applicationName( //
            //                                              //Only for user defined type.
            //                                              //str, Application Name (Ex. Softwara Automation)

            Class type_I
    ) {
        if (!( //
                BobjBaseObjectAbstract.class.isAssignableFrom(type_I) //
                )) {
            Test.abort(Std.name(type_I) + " should be a user defined type",
                    Test.toLog(type_I, "type_I"),
                    Test.toLog(BobjBaseObjectAbstract.class, "typeof(BobjBaseObjectAbstract)"));
        }

        String strFullName = type_I.getName();
        int intFirstDot = strFullName.indexOf('.');

        return strFullName.substring(0, intFirstDot);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String relevantPartName( //
            //                                              //Only for user defined type.
            //                                              //str, Relevant Part Name (Ex. Cod)

            Class type_I
    ) {
        if (!( //
                BobjBaseObjectAbstract.class.isAssignableFrom(type_I) //
                )) {
            Test.abort(Std.name(type_I) + " should be a user defined type",
                    Test.toLog(type_I, "type_I"),
                    Test.toLog(BobjBaseObjectAbstract.class, "typeof(BobjBaseObjectAbstract)"));
        }

        String strFullName = type_I.getName();
        int intFirstDot = strFullName.indexOf('.');
        int intSecondDot = strFullName.indexOf('.', intFirstDot + 1);

        return strFullName.substring(intFirstDot + 1, intSecondDot - (intFirstDot + 1));
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Std.StringSplit*/
    //==================================================================================================================
    //------------------------------------------------------------------------------------------------------------------
    public static String[] split( //
            String str_I,
            char... arrcharSeparator_I
    ) {
        if ( //
                arrcharSeparator_I == null //
                ) {
            Test.abort(Test.toLog(arrcharSeparator_I, "arrcharSeparator_I") + " can not be null");
        }
        if ( //
                arrcharSeparator_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrcharSeparator_I, "arrcharSeparator_I") + " should have at least 1 item");
        }

        return str_I.split(Std.strSeparators(arrcharSeparator_I), -1);

    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static String strSeparators(
            //                                              //These methods are required to implement String split in
            //                                              //      Java
            //                                              //In Java, Splits are implemented using regex to match
            //                                              //      split separator, this can be char, chars set, string
            //                                              //      or an string set. (Regex can be MUCH MORE complex,
            //                                              //      but Towa Standard, accept just these 4
            //                                              //      possibilities).
            //                                              //Regex can include "special characters" to define a regex.
            //                                              //"special characters" as up today are:
            //                                              //^[-&.\{}$?*+|()<>: but at the same time specify that ALL
            //                                              //      OTHER chars except a-z, A-Z and 0-9 can be used in
            //                                              //      the future.
            //                                              //Then to include any "special" character as part of the
            //                                              //      regex definition, should be rscaped (\x).
            //                                              //This stuff IS NOT WELL DEFINED, because:
            //                                              //1. "\?\ñ" is 2 set of escaped character (each one requires
            //                                              //      takes 2 character) to represente "?ñ" as part of a
            //                                              //      regex.
            //                                              //2. "\t\u0009" is at compilation time converted to "ªª"
            //                                              //      where each ª represent just ONE horizontal tab char,
            //                                              //      should these 2 chars be escaped ("\ª\ª").
            //                                              //NOTICE: regex IS NOT STANDARD, but regex will be useded to
            //                                              //      implement string split.

            //                                              //Form a regex to have one or many chars as separator.
            //                                              //str, regex with character separators.

            char[] arrcharSeparator_I
    ) {
        String[] arrstrRegexSeparator = new String[arrcharSeparator_I.length];

        //                                                  //Review and correct chars
        for (int intI = 0; intI < arrcharSeparator_I.length; intI = intI + 1) {
            if (Std.isDigitOrLetter(arrcharSeparator_I[intI]) //
                    ) {
                arrstrRegexSeparator[intI] = "" + arrcharSeparator_I[intI];
            } //
            else {
                //                                          //Form \c
                arrstrRegexSeparator[intI] = "\\" + arrcharSeparator_I[intI];
            }
        }

        //                                                  //Form separator with char set (or just 1)
        String strSeparators;
        if ( //
                arrstrRegexSeparator.length == 1 //
                ) {
            //                                              //Form: c* (c* could be char or \char)
            strSeparators = arrstrRegexSeparator[0];
        } //
        else {
            //                                              //Form: [c*c*...c*]
            strSeparators = "[" + String.join("", arrstrRegexSeparator) + "]";
        }

        return strSeparators;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static String[] split( //
            String str_I,
            String... arrstrSeparator_I
    ) {
        if ( //
                arrstrSeparator_I == null //
                ) {
            Test.abort(Test.toLog(arrstrSeparator_I, "arrstrSeparator_I") + " can not be null");
        }
        if ( //
                arrstrSeparator_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrstrSeparator_I, "arrstrSeparator_I") + " should have at least 1 item");
        }

        return str_I.split(Std.strSeparators(arrstrSeparator_I), -1);

    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static String strSeparators(
            //                                              //Form a regex to have one or many strings as separator.
            //                                              //str, regex with characters separators.

            String[] arrstrSeparator_I
    ) {
        if ( //
                arrstrSeparator_I == null //
                ) {
            Test.abort(Test.toLog(arrstrSeparator_I, "arrstrSeparator_I") + " can not be null");
        }
        if ( //
                arrstrSeparator_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrstrSeparator_I, "arrstrSeparator_I") + " should have at least 1 item");
        }

        String[] arrstrRegexSeparator = new String[arrstrSeparator_I.length];

        //                                                  //Review and correct strings
        for (int intI = 0; intI < arrstrSeparator_I.length; intI = intI + 1) {
            arrstrRegexSeparator[intI] = Std.strRegexSeparator(arrstrSeparator_I[intI]);
        }

        //                                                  //Form separator with string set (or just 1)
        String strSeparators;
        if ( //
                arrstrRegexSeparator.length == 1 //
                ) {
            //                                              //Form: str* (str* could include escaped chars)
            strSeparators = arrstrRegexSeparator[0];
        } //
        else {
            //                                              //Form: (str*|str*|...|str)
            strSeparators = "(" + String.join("|", arrstrRegexSeparator) + ")";
        }

        return strSeparators;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static String strRegexSeparator(
            //                                              //Form a regex string separator (escape "special" chars).
            //                                              //str, one separator as required by regex.

            String strSeparator_I
    ) {
        String strRegexSeparator = strSeparator_I;
        //                                                  //To easy code, string is revised backwoard.
        for (int intChar = strSeparator_I.length() - 1; intChar >= 0; intChar = intChar - 1) {
            if ( //
                    Std.isDigitOrLetter(strRegexSeparator.charAt(intChar)) //
                    ) {
                //                                          //Do nothing
            } //
            else {
                //                                          //Insert an escape (\) before the character
                strRegexSeparator = strRegexSeparator.substring(0, intChar) + "\\"
                        + strRegexSeparator.substring(intChar);
            }
        }

        return strRegexSeparator;
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Std.DateTime*/
    //==================================================================================================================
    //                                                      //Las siguientes constantes y métodos son necesarios para
    //                                                      //      estandarizar el comportamiento.
    //
    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/
    //
    public static LocalDateTime dateMIN = LocalDateTime.of(0001, 01, 01, 0, 0);
    public static LocalDateTime dateMAX = LocalDateTime.of(9999, 12, 31, 0, 0);
    public static LocalDateTime dtMIN = LocalDateTime.of(0001, 01, 01, 0, 0, 0, 0);
    public static LocalDateTime dtMAX = LocalDateTime.of(9999, 12, 31, 23, 59, 59, 999 * 1000000);

    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    //------------------------------------------------------------------------------------------------------------------
    public static LocalDateTime dtGetNow( //
            //                                              //Genera un dtNow, si estamos en comparable Test, lo genera
            //                                              //      masked
            //                                              //dt, Now
            ) {
        LocalDateTime dtGetNow;
        if ( //
                //                                          //Estamos en un prueba que se desea comparar
                Test.z_TowaPRIVATE_boolIsComparableLog() //
                ) {
            dtGetNow = Test.z_TowaPRIVATE_GetNowForComparableTest();
        } //
        else {
            //                                              //Prueba normal, no se altera el dtNow
            dtGetNow = LocalDateTime.now();
        }

        return dtGetNow;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean boolIsDate(
            //                                              //Valida sea una fecha.

            //                                              //bool, true si es fecha.

            //                                              //Fecha a validar.
            LocalDateTime date_I
    ) {
        return ( //
                //                                         //Con excepción de la fecha todo esta en ceros.
                (date_I.getHour() == 0) && (date_I.getMinute() == 0) && (date_I.getSecond() == 0)
                && (date_I.getNano() == 0) //
                );
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Std.Array*/
    //==============================================================================================================
    //--------------------------------------------------------------------------------------------------------------
    //                                                      //LITERALS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //DECLARATION AND ASSIGNMENT
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONSTRUCTION
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSIONS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //EQUALITY OPERATORS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //ACCESS
    //
    //                                                      //WARNING!!, paramenters of sequentialSearch in Java ARE
    //                                                      //      INVERTED to SequentialSearch en C#
    //------------------------------------------------------------------------------------------------------------------
    public static int sequentialSearch(
            //                                              //Do not need to be ins ascending sequence
            int[] arrint_I,
            //                                              //Argument to search, should be able to compare to XC
            int intArgument_I
    ) {
        Test.abortIfNull(arrint_I, "arrint_I");

        int intI = 0;
        /*UNTIL-DO*/
        while (!( //
                (intI >= arrint_I.length)
                || arrint_I[intI] == intArgument_I) //
                ) {
            intI = intI + 1;
        }

        //                                              //-1 if not found
        return ( //
                intI < arrint_I.length //
                ) ? intI : - 1;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static int sequentialSearch(
            //                                              //Do not need to be ins ascending sequence
            long[] arrlong_I,
            //                                              //Argument to search, should be able to compare to XC
            long longArgument_I
    ) {
        Test.abortIfNull(arrlong_I, "arrlong_I");

        int intI = 0;
        /*UNTIL-DO*/
        while (!( //
                (intI >= arrlong_I.length)
                || arrlong_I[intI] == longArgument_I) //
                ) {
            intI = intI + 1;
        }

        //                                              //-1 if not found
        return ( //
                intI < arrlong_I.length //
                ) ? intI : - 1;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static int sequentialSearch(
            //                                              //Do not need to be ins ascending sequence
            char[] arrchar_I,
            //                                              //Argument to search, should be able to compare to XC
            char charArgument_I
    ) {
        Test.abortIfNull(arrchar_I, "arrchar_I");

        int intI = 0;
        /*UNTIL-DO*/
        while (!( //
                (intI >= arrchar_I.length)
                || (arrchar_I[intI] == charArgument_I) //
                )) {
            intI = intI + 1;
        }

        //                                              //-1 if not found
        return ( //
                intI < arrchar_I.length //
                )
                        ? intI : - 1;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XA, XB> int sequentialSearch(
            //                                              //Do not need to be ins ascending sequence
            XB[] arrxb_I,
            //                                              //Argument to search, should be able to compare to XC
            XA xaArgument_I
    ) {
        Test.abortIfNull(xaArgument_I, "xaArgument_I");
        Test.abortIfNull(arrxb_I, "arrxb_I");

        int intI = 0;
        /*UNTIL-DO*/
        while (!( //
                (intI >= arrxb_I.length)
                //                                          //item can be null, but can never equals argument
                || (arrxb_I[intI] != null) && arrxb_I[intI].equals(xaArgument_I)) //
                ) {
            intI = intI + 1;
        }

        //                                                  //-1 if not found
        return ( //
                intI < arrxb_I.length //
                ) ? intI : - 1;
    }

    /*[Dec.26, 2018] Parece que cuando la variable generica es "Comparable" si acepta los "primitivos"
    //------------------------------------------------------------------------------------------------------------------
    public static boolean isInSet(
            //                                              //bool, true if is in set.

            int int_I,
            int... arrintSet_I
    ) {
        Test.abortIfNull(arrintSet_I, "arrintSet_I");

        return ( //
                //                                          //Is in set
                Std.sequentialSearch(int_I, arrintSet_I) >= 0 //
                );
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static boolean isInSet(
            //                                              //bool, true if is in set.

            long long_I,
            long... arrlongSet_I
    ) {
        Test.abortIfNull(arrlongSet_I, "arrlongSet_I");

        return ( //
                //                                          //Is in set
                Std.sequentialSearch(long_I, arrlongSet_I) >= 0 //
                );
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static boolean isInSet(
            //                                              //bool, true if is in set.

            char char_I,
            char... arrcharSet_I
    ) {
        Test.abortIfNull(arrcharSet_I, "arrcharSet_I");

        return ( //
                //                                          //Is in set
                Std.sequentialSearch(char_I, arrcharSet_I) >= 0 //
                );
    }
     */
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XA, XB> boolean isInSet(
            //                                              //bool, true if is in set.

            XA xaArgument_I,
            XB... arrxbSet_I
    ) {
        return ( //
                //                                          //Is in set
                Std.sequentialSearch(arrxbSet_I, xaArgument_I) >= 0 //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isInSortedSet(
            //                                              //bool, true if is in set.

            int int_I,
            int[] arrintSortedSet_I
    ) {
        Test.abortIfNull(arrintSortedSet_I, "arrintSortedSet_I");

        return ( //
                //                                          //Is in set
                Arrays.binarySearch(arrintSortedSet_I, int_I) >= 0 //
                );
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static boolean isInSortedSet(
            //                                              //bool, true if is in set.

            long long_I,
            long[] arrlongSortedSet_I
    ) {
        Test.abortIfNull(arrlongSortedSet_I, "arrlongSortedSet_I");

        return ( //
                //                                          //Is in set
                Arrays.binarySearch(arrlongSortedSet_I, long_I) >= 0 //
                );
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static boolean isInSortedSet(
            //                                              //bool, true if is in set.

            char char_I,
            char[] arrcharSortedSet_I
    ) {
        Test.abortIfNull(arrcharSortedSet_I, "arrcharSortedSet_I");

        return ( //
                //                                          //Is in set
                Arrays.binarySearch(arrcharSortedSet_I, char_I) >= 0 //
                );
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XCA extends Comparable, XC extends Comparable> boolean isInSortedSet(
            //                                              //bool, true if is in set.

            XCA xca_I,
            XC[] arrxcSortedSet_I
    ) {
        Test.abortIfNull(xca_I, "xca_I");
        Test.abortIfNull(arrxcSortedSet_I, "arrxcSortedSet_I");

        return ( //
                //                                          //Is in set
                Arrays.binarySearch(arrxcSortedSet_I, xca_I) >= 0 //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //MANIPULATION
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //Generic methods can not include primitives, then:
    //                                                      //We need 5 sets of sort menthods (int, long, num, char & obj).
    //                                                      //Each of these sets include 6 method to process as second
    //                                                      //      array (int, long, num, char, bool & obj)
    //
    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            int[] arrintBase_M,
            int[] arrintSecond_M
    ) {
        Std.subAbortIfNull(arrintBase_M, "arrintBase_M");
        Std.subAbortIfNull(arrintSecond_M, "arrintSecond_M");
        Std.subAbortIfNotSameLength(arrintBase_M.length, "arrintBase_M", arrintSecond_M.length, "arrintSecond_M");

        Std.subMainQuickSort(arrintBase_M, arrintSecond_M);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            int[] arrintBase_M,
            long[] arrlongSecond_M
    ) {
        Std.subAbortIfNull(arrintBase_M, "arrintBase_M");
        Std.subAbortIfNull(arrlongSecond_M, "arrlongSecond_M");
        Std.subAbortIfNotSameLength(arrintBase_M.length, "arrintBase_M", arrlongSecond_M.length, "arrlongSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrlongSecond_M.length);
        Std.subMainQuickSort(arrintBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrlongSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            int[] arrintBase_M,
            double[] arrnumSecond_M
    ) {
        Std.subAbortIfNull(arrintBase_M, "arrintBase_M");
        Std.subAbortIfNull(arrnumSecond_M, "arrnumSecond_M");
        Std.subAbortIfNotSameLength(arrintBase_M.length, "arrintBase_M", arrnumSecond_M.length, "arrnumSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrnumSecond_M.length);
        Std.subMainQuickSort(arrintBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrnumSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            int[] arrintBase_M,
            char[] arrcharSecond_M
    ) {
        Std.subAbortIfNull(arrintBase_M, "arrintBase_M");
        Std.subAbortIfNull(arrcharSecond_M, "arrcharSecond_M");
        Std.subAbortIfNotSameLength(arrintBase_M.length, "arrintBase_M", arrcharSecond_M.length, "arrcharSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrcharSecond_M.length);
        Std.subMainQuickSort(arrintBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrcharSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            int[] arrintBase_M,
            boolean[] arrboolSecond_M
    ) {
        Std.subAbortIfNull(arrintBase_M, "arrintBase_M");
        Std.subAbortIfNull(arrboolSecond_M, "arrboolSecond_M");
        Std.subAbortIfNotSameLength(arrintBase_M.length, "arrintBase_M", arrboolSecond_M.length, "arrboolSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrboolSecond_M.length);
        Std.subMainQuickSort(arrintBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrboolSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <XT> void sort( //
            //                                          //Sorts both arrays based on the first one.

            int[] arrintBase_M,
            XT[] arrxtSecond_M
    ) {
        Std.subAbortIfNull(arrintBase_M, "arrintBase_M");
        Std.subAbortIfNull(arrxtSecond_M, "arrobjSecond_M");
        Std.subAbortIfNotSameLength(arrintBase_M.length, "arrintBase_M", arrxtSecond_M.length, "arrxtSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrxtSecond_M.length);
        Std.subMainQuickSort(arrintBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrxtSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            long[] arrlongBase_M,
            int[] arrintSecond_M
    ) {
        Std.subAbortIfNull(arrlongBase_M, "arrlongBase_M");
        Std.subAbortIfNull(arrintSecond_M, "arrintSecond_M");
        Std.subAbortIfNotSameLength(arrlongBase_M.length, "arrlongBase_M", arrintSecond_M.length, "arrintSecond_M");

        Std.subMainQuickSort(arrlongBase_M, arrintSecond_M);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            long[] arrlongBase_M,
            long[] arrlongSecond_M
    ) {
        Std.subAbortIfNull(arrlongBase_M, "arrlongBase_M");
        Std.subAbortIfNull(arrlongSecond_M, "arrlongSecond_M");
        Std.subAbortIfNotSameLength(arrlongBase_M.length, "arrlongBase_M", arrlongSecond_M.length, "arrlongSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrlongSecond_M.length);
        Std.subMainQuickSort(arrlongBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrlongSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            long[] arrlongBase_M,
            double[] arrnumSecond_M
    ) {
        Std.subAbortIfNull(arrlongBase_M, "arrlongBase_M");
        Std.subAbortIfNull(arrnumSecond_M, "arrnumSecond_M");
        Std.subAbortIfNotSameLength(arrlongBase_M.length, "arrlongBase_M", arrnumSecond_M.length, "arrnumSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrnumSecond_M.length);
        Std.subMainQuickSort(arrlongBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrnumSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            long[] arrlongBase_M,
            char[] arrcharSecond_M
    ) {
        Std.subAbortIfNull(arrlongBase_M, "arrlongBase_M");
        Std.subAbortIfNull(arrcharSecond_M, "arrcharSecond_M");
        Std.subAbortIfNotSameLength(arrlongBase_M.length, "arrlongBase_M", arrcharSecond_M.length, "arrcharSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrcharSecond_M.length);
        Std.subMainQuickSort(arrlongBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrcharSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            long[] arrlongBase_M,
            boolean[] arrboolSecond_M
    ) {
        Std.subAbortIfNull(arrlongBase_M, "arrlongBase_M");
        Std.subAbortIfNull(arrboolSecond_M, "arrboolSecond_M");
        Std.subAbortIfNotSameLength(arrlongBase_M.length, "arrlongBase_M", arrboolSecond_M.length, "arrboolSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrboolSecond_M.length);
        Std.subMainQuickSort(arrlongBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrboolSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <XT> void sort( //
            //                                          //Sorts both arrays based on the first one.

            long[] arrlongBase_M,
            XT[] arrxtSecond_M
    ) {
        Std.subAbortIfNull(arrlongBase_M, "arrlongBase_M");
        Std.subAbortIfNull(arrxtSecond_M, "arrxtSecond_M");
        Std.subAbortIfNotSameLength(arrlongBase_M.length, "arrlongBase_M", arrxtSecond_M.length, "arrxtSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrxtSecond_M.length);
        Std.subMainQuickSort(arrlongBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrxtSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            double[] arrnumBase_M,
            int[] arrintSecond_M
    ) {
        Std.subAbortIfNull(arrnumBase_M, "arrnumBase_M");
        Std.subAbortIfNull(arrintSecond_M, "arrintSecond_M");
        Std.subAbortIfNotSameLength(arrnumBase_M.length, "arrnumBase_M", arrintSecond_M.length, "arrintSecond_M");

        Std.subMainQuickSort(arrnumBase_M, arrintSecond_M);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            double[] arrnumBase_M,
            long[] arrlongSecond_M
    ) {
        Std.subAbortIfNull(arrnumBase_M, "arrnumBase_M");
        Std.subAbortIfNull(arrlongSecond_M, "arrlongSecond_M");
        Std.subAbortIfNotSameLength(arrnumBase_M.length, "arrnumBase_M", arrlongSecond_M.length, "arrlongSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrlongSecond_M.length);
        Std.subMainQuickSort(arrnumBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrlongSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            double[] arrnumBase_M,
            double[] arrnumSecond_M
    ) {
        Std.subAbortIfNull(arrnumBase_M, "arrnumBase_M");
        Std.subAbortIfNull(arrnumSecond_M, "arrnumSecond_M");
        Std.subAbortIfNotSameLength(arrnumBase_M.length, "arrnumBase_M", arrnumSecond_M.length, "arrnumSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrnumSecond_M.length);
        Std.subMainQuickSort(arrnumBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrnumSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            double[] arrnumBase_M,
            char[] arrcharSecond_M
    ) {
        Std.subAbortIfNull(arrnumBase_M, "arrnumBase_M");
        Std.subAbortIfNull(arrcharSecond_M, "arrcharSecond_M");
        Std.subAbortIfNotSameLength(arrnumBase_M.length, "arrnumBase_M", arrcharSecond_M.length, "arrcharSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrcharSecond_M.length);
        Std.subMainQuickSort(arrnumBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrcharSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            double[] arrnumBase_M,
            boolean[] arrboolSecond_M
    ) {
        Std.subAbortIfNull(arrnumBase_M, "arrnumBase_M");
        Std.subAbortIfNull(arrboolSecond_M, "arrboolSecond_M");
        Std.subAbortIfNotSameLength(arrnumBase_M.length, "arrnumBase_M", arrboolSecond_M.length, "arrboolSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrboolSecond_M.length);
        Std.subMainQuickSort(arrnumBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrboolSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <XT> void sort( //
            //                                          //Sorts both arrays based on the first one.

            double[] arrnumBase_M,
            XT[] arrxtSecond_M
    ) {
        Std.subAbortIfNull(arrnumBase_M, "arrnumBase_M");
        Std.subAbortIfNull(arrxtSecond_M, "arrxtSecond_M");
        Std.subAbortIfNotSameLength(arrnumBase_M.length, "arrnumBase_M", arrxtSecond_M.length, "arrxtSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrxtSecond_M.length);
        Std.subMainQuickSort(arrnumBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrxtSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            char[] arrcharBase_M,
            int[] arrintSecond_M
    ) {
        Std.subAbortIfNull(arrcharBase_M, "arrcharBase_M");
        Std.subAbortIfNull(arrintSecond_M, "arrintSecond_M");
        Std.subAbortIfNotSameLength(arrcharBase_M.length, "arrcharBase_M", arrintSecond_M.length, "arrintSecond_M");

        Std.subMainQuickSort(arrcharBase_M, arrintSecond_M);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            char[] arrcharBase_M,
            long[] arrlongSecond_M
    ) {
        Std.subAbortIfNull(arrcharBase_M, "arrcharBase_M");
        Std.subAbortIfNull(arrlongSecond_M, "arrlongSecond_M");
        Std.subAbortIfNotSameLength(arrcharBase_M.length, "arrcharBase_M", arrlongSecond_M.length, "arrlongSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrlongSecond_M.length);
        Std.subMainQuickSort(arrcharBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrlongSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            char[] arrcharBase_M,
            double[] arrnumSecond_M
    ) {
        Std.subAbortIfNull(arrcharBase_M, "arrcharBase_M");
        Std.subAbortIfNull(arrnumSecond_M, "arrnumSecond_M");
        Std.subAbortIfNotSameLength(arrcharBase_M.length, "arrcharBase_M", arrnumSecond_M.length, "arrnumSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrnumSecond_M.length);
        Std.subMainQuickSort(arrcharBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrnumSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            char[] arrcharBase_M,
            char[] arrcharSecond_M
    ) {
        Std.subAbortIfNull(arrcharBase_M, "arrcharBase_M");
        Std.subAbortIfNull(arrcharSecond_M, "arrcharSecond_M");
        Std.subAbortIfNotSameLength(arrcharBase_M.length, "arrcharBase_M", arrcharSecond_M.length, "arrcharSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrcharSecond_M.length);
        Std.subMainQuickSort(arrcharBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrcharSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void sort( //
            //                                          //Sorts both arrays based on the first one.

            char[] arrcharBase_M,
            boolean[] arrboolSecond_M
    ) {
        Std.subAbortIfNull(arrcharBase_M, "arrcharBase_M");
        Std.subAbortIfNull(arrboolSecond_M, "arrboolSecond_M");
        Std.subAbortIfNotSameLength(arrcharBase_M.length, "arrcharBase_M", arrboolSecond_M.length, "arrboolSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrboolSecond_M.length);
        Std.subMainQuickSort(arrcharBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrboolSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <XT> void sort( //
            //                                          //Sorts both arrays based on the first one.

            char[] arrcharBase_M,
            XT[] arrxtSecond_M
    ) {
        Std.subAbortIfNull(arrcharBase_M, "arrcharBase_M");
        Std.subAbortIfNull(arrxtSecond_M, "arrxtSecond_M");
        Std.subAbortIfNotSameLength(arrcharBase_M.length, "arrcharBase_M", arrxtSecond_M.length, "arrxtSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrxtSecond_M.length);
        Std.subMainQuickSort(arrcharBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrxtSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <XC extends Comparable> void sort( //
            //                                          //Sorts both arrays based on the first one.

            XC[] arrxcBase_M,
            int[] arrintSecond_M
    ) {
        Std.subAbortIfNull(arrxcBase_M, "arrxcBase_M");
        Std.subAbortIfNull(arrintSecond_M, "arrintSecond_M");
        Std.subAbortIfNotSameLength(arrxcBase_M.length, "arrxcBase_M", arrintSecond_M.length, "arrintSecond_M");

        Std.subMainQuickSort(arrxcBase_M, arrintSecond_M);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <XC extends Comparable> void sort( //
            //                                          //Sorts both arrays based on the first one.

            XC[] arrxcBase_M,
            long[] arrlongSecond_M
    ) {
        Std.subAbortIfNull(arrxcBase_M, "arrxcBase_M");
        Std.subAbortIfNull(arrlongSecond_M, "arrlongSecond_M");
        Std.subAbortIfNotSameLength(arrxcBase_M.length, "arrxcBase_M", arrlongSecond_M.length, "arrlongSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrlongSecond_M.length);
        Std.subMainQuickSort(arrxcBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrlongSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <XC extends Comparable> void sort( //
            //                                          //Sorts both arrays based on the first one.

            XC[] arrxcBase_M,
            double[] arrnumSecond_M
    ) {
        Std.subAbortIfNull(arrxcBase_M, "arrxcBase_M");
        Std.subAbortIfNull(arrnumSecond_M, "arrnumSecond_M");
        Std.subAbortIfNotSameLength(arrxcBase_M.length, "arrxcBase_M", arrnumSecond_M.length, "arrnumSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrnumSecond_M.length);
        Std.subMainQuickSort(arrxcBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrnumSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <XC extends Comparable> void sort( //
            //                                          //Sorts both arrays based on the first one.

            XC[] arrxcBase_M,
            char[] arrcharSecond_M
    ) {
        Std.subAbortIfNull(arrxcBase_M, "arrxcBase_M");
        Std.subAbortIfNull(arrcharSecond_M, "arrcharSecond_M");
        Std.subAbortIfNotSameLength(arrxcBase_M.length, "arrxcBase_M", arrcharSecond_M.length, "arrcharSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrcharSecond_M.length);
        Std.subMainQuickSort(arrxcBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrcharSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <XC extends Comparable> void sort( //
            //                                          //Sorts both arrays based on the first one.

            XC[] arrxcBase_M,
            boolean[] arrboolSecond_M
    ) {
        Std.subAbortIfNull(arrxcBase_M, "arrxcBase_M");
        Std.subAbortIfNull(arrboolSecond_M, "arrboolSecond_M");
        Std.subAbortIfNotSameLength(arrxcBase_M.length, "arrxcBase_M", arrboolSecond_M.length, "arrboolSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrboolSecond_M.length);
        Std.subMainQuickSort(arrxcBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrboolSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <XC extends Comparable, XT> void sort( //
            //                                          //Sorts both arrays based on the first one.

            XC[] arrxcBase_M,
            XT[] arrxtSecond_M
    ) {
        Std.subAbortIfNull(arrxcBase_M, "arrxcBase_M");
        Std.subAbortIfNull(arrxtSecond_M, "arrxtSecond_M");
        Std.subAbortIfNotSameLength(arrxcBase_M.length, "arrxcBase_M", arrxtSecond_M.length, "arrxtSecond_M");

        int[] arrintSequence = Std.arrintSequence(arrxtSecond_M.length);
        Std.subMainQuickSort(arrxcBase_M, arrintSequence);
        Std.subResequenceSecondArray(arrxtSecond_M, arrintSequence);
    }

    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    //------------------------------------------------------------------------------------------------------------------
    private static void subAbortIfNull( //

            int[] arrint_L,
            String strIdentifier_I
    ) {
        if ( //
                arrint_L == null //
                ) {
            Test.abort(Test.toLog(arrint_L, strIdentifier_I) + " can not be null");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subAbortIfNull( //

            long[] arrlong_L,
            String strIdentifier_I
    ) {
        if ( //
                arrlong_L == null //
                ) {
            Test.abort(Test.toLog(arrlong_L, strIdentifier_I) + " can not be null");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subAbortIfNull( //

            double[] arrnum_L,
            String strIdentifier_I
    ) {
        if ( //
                arrnum_L == null //
                ) {
            Test.abort(Test.toLog(arrnum_L, strIdentifier_I) + " can not be null");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subAbortIfNull( //

            char[] arrchar_L,
            String strIdentifier_I
    ) {
        if ( //
                arrchar_L == null //
                ) {
            Test.abort(Test.toLog(arrchar_L, strIdentifier_I) + " can not be null");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subAbortIfNull( //

            boolean[] arrbool_L,
            String strIdentifier_I
    ) {
        if ( //
                arrbool_L == null //
                ) {
            Test.abort(Test.toLog(arrbool_L, strIdentifier_I) + " can not be null");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static <XT> void subAbortIfNull( //

            XT[] arrxt_L,
            String strIdentifier_I
    ) {
        if ( //
                arrxt_L == null //
                ) {
            Test.abort(Test.toLog(arrxt_L, strIdentifier_I) + " can not be null");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subAbortIfNotSameLength( //

            int intBaseLength_I,
            String strBaseIdentifier_I,
            int intSecontLength_I,
            String strSecondIdentifier_I
    ) {
        if ( //
                intBaseLength_I != intSecontLength_I //
                ) {
            Test.abort("Arrays must be of the same length:",
                    Test.toLog(intBaseLength_I, strBaseIdentifier_I + ".Length"),
                    Test.toLog(intSecontLength_I, strSecondIdentifier_I + ".Length"));
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static int[] arrintSequence( //
            //                                              //arrint, { 0, 1, 2, etc. }

            int intLength_I
    ) {
        int[] arrintSequence = new int[intLength_I];
        for (int intI = 0; intI < intLength_I; intI = intI + 1) {
            arrintSequence[intI] = intI;
        }

        return arrintSequence;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subMainQuickSort( //

            int[] arrintBase_M,
            int[] arrintSecond_M
    ) {
        if ( //
                arrintBase_M.length > 0 //
                ) {
            Std.subQuickSort(arrintBase_M, arrintSecond_M, 0, arrintBase_M.length - 1);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static void subQuickSort( //

            int[] arrintBase_M,
            int[] arrintSecond_M,
            //                                              //Sort within this limits
            int intStart_I,
            int intEnd_I
    ) {
        int intLow = intStart_I;
        int intHigh = intEnd_I;

        int intPivot = arrintBase_M[intStart_I];

        /*LOOP*/
        while (true) {
            //                                              //Search for next pair of values to exchange

            if ( //
                    intLow <= intHigh //
                    ) {
                //                                          //Search for next high (from start) to exchange.
                /*UNTIL-DO*/
                while (!( //
                        arrintBase_M[intLow] >= intPivot //
                        )) {
                    intLow = intLow + 1;
                }
                //                                          //Search for next low (backwards from end) to exchange.
                /*UNTIL-DO*/
                while (!( //
                        arrintBase_M[intHigh] <= intPivot //
                        )) {
                    intHigh = intHigh - 1;
                }
            }

            /*EXIT-IF*/
            if ( //
                    //                                      //No more pair of values to exchange.
                    //                                      //It is the same element or did not find values in range
                    intLow > intHigh //
                    ) {
                break;
            }

            Std.subExchangeValuesInArray(arrintBase_M, intLow, intHigh);
            Std.subExchangeValuesInArray(arrintSecond_M, intLow, intHigh);

            //                                              //Reduce Range
            intLow = intLow + 1;
            intHigh = intHigh - 1;
        }
        /*END-LOOP*/

        if ( //
                //                                          //Lower half require to be sorted
                intStart_I < intHigh //
                ) {
            Std.subQuickSort(arrintBase_M, arrintSecond_M, intStart_I, intHigh);
        }

        if ( //
                //                                          //Upper half require to be sorted
                intLow < intEnd_I //
                ) {
            Std.subQuickSort(arrintBase_M, arrintSecond_M, intLow, intEnd_I);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subMainQuickSort( //

            long[] arrlongBase_M,
            int[] arrintSecond_M
    ) {
        if ( //
                arrlongBase_M.length > 0 //
                ) {
            Std.subQuickSort(arrlongBase_M, arrintSecond_M, 0, arrlongBase_M.length - 1);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static void subQuickSort( //

            long[] arrlongBase_M,
            int[] arrintSecond_M,
            //                                              //Sort within this limits
            int intStart_I,
            int intEnd_I
    ) {
        int intLow = intStart_I;
        int intHigh = intEnd_I;

        long longPivot = arrlongBase_M[intStart_I];

        /*LOOP*/
        while (true) {
            //                                              //Search for next pair of values to exchange

            if ( //
                    intLow <= intHigh //
                    ) {
                //                                          //Search for next high (from start) to exchange.
                /*UNTIL-DO*/
                while (!( //
                        arrlongBase_M[intLow] >= longPivot //
                        )) {
                    intLow = intLow + 1;
                }
                //                                          //Search for next low (backwards from end) to exchange.
                /*UNTIL-DO*/
                while (!( //
                        arrlongBase_M[intHigh] <= longPivot //
                        )) {
                    intHigh = intHigh - 1;
                }
            }

            /*EXIT-IF*/
            if ( //
                    //                                      //No more pair of values to exchange.
                    //                                      //It is the same element or did not find values in range
                    intLow > intHigh //
                    ) {
                break;
            }

            Std.subExchangeValuesInArray(arrlongBase_M, intLow, intHigh);
            Std.subExchangeValuesInArray(arrintSecond_M, intLow, intHigh);

            //                                              //Reduce Range
            intLow = intLow + 1;
            intHigh = intHigh - 1;
        }
        /*END-LOOP*/

        if ( //
                //                                          //Lower half require to be sorted
                intStart_I < intHigh //
                ) {
            Std.subQuickSort(arrlongBase_M, arrintSecond_M, intStart_I, intHigh);
        }

        if ( //
                //                                          //Upper half require to be sorted
                intLow < intEnd_I //
                ) {
            Std.subQuickSort(arrlongBase_M, arrintSecond_M, intLow, intEnd_I);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subMainQuickSort( //

            double[] arrnumBase_M,
            int[] arrintSecond_M
    ) {
        if ( //
                arrnumBase_M.length > 0 //
                ) {
            Std.subQuickSort(arrnumBase_M, arrintSecond_M, 0, arrnumBase_M.length - 1);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static void subQuickSort( //

            double[] arrnumBase_M,
            int[] arrintSecond_M,
            //                                              //Sort within this limits
            int intStart_I,
            int intEnd_I
    ) {
        int intLow = intStart_I;
        int intHigh = intEnd_I;

        double numPivot = arrnumBase_M[intStart_I];

        /*LOOP*/
        while (true) {
            //                                              //Search for next pair of values to exchange

            if ( //
                    intLow <= intHigh //
                    ) {
                //                                          //Search for next high (from start) to exchange.
                /*UNTIL-DO*/
                while (!( //
                        arrnumBase_M[intLow] >= numPivot //
                        )) {
                    intLow = intLow + 1;
                }
                //                                          //Search for next low (backwards from end) to exchange.
                /*UNTIL-DO*/
                while (!( //
                        arrnumBase_M[intHigh] <= numPivot //
                        )) {
                    intHigh = intHigh - 1;
                }
            }

            /*EXIT-IF*/
            if ( //
                    //                                      //No more pair of values to exchange.
                    //                                      //It is the same element or did not find values in range
                    intLow > intHigh //
                    ) {
                break;
            }

            Std.subExchangeValuesInArray(arrnumBase_M, intLow, intHigh);
            Std.subExchangeValuesInArray(arrintSecond_M, intLow, intHigh);

            //                                              //Reduce Range
            intLow = intLow + 1;
            intHigh = intHigh - 1;
        }
        /*END-LOOP*/

        if ( //
                //                                          //Lower half require to be sorted
                intStart_I < intHigh //
                ) {
            Std.subQuickSort(arrnumBase_M, arrintSecond_M, intStart_I, intHigh);
        }

        if ( //
                //                                          //Upper half require to be sorted
                intLow < intEnd_I //
                ) {
            Std.subQuickSort(arrnumBase_M, arrintSecond_M, intLow, intEnd_I);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subMainQuickSort( //

            char[] arrcharBase_M,
            int[] arrintSecond_M
    ) {
        if ( //
                arrcharBase_M.length > 0 //
                ) {
            Std.subQuickSort(arrcharBase_M, arrintSecond_M, 0, arrcharBase_M.length - 1);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static void subQuickSort( //

            char[] arrcharBase_M,
            int[] arrintSecond_M,
            //                                              //Sort within this limits
            int intStart_I,
            int intEnd_I
    ) {
        int intLow = intStart_I;
        int intHigh = intEnd_I;

        char charPivot = arrcharBase_M[intStart_I];

        /*LOOP*/
        while (true) {
            //                                              //Search for next pair of values to exchange

            if ( //
                    intLow <= intHigh //
                    ) {
                //                                          //Search for next high (from start) to exchange.
                /*UNTIL-DO*/
                while (!( //
                        arrcharBase_M[intLow] >= charPivot //
                        )) {
                    intLow = intLow + 1;
                }
                //                                          //Search for next low (backwards from end) to exchange.
                /*UNTIL-DO*/
                while (!( //
                        arrcharBase_M[intHigh] <= charPivot //
                        )) {
                    intHigh = intHigh - 1;
                }
            }

            /*EXIT-IF*/
            if ( //
                    //                                      //No more pair of values to exchange.
                    //                                      //It is the same element or did not find values in range
                    intLow > intHigh //
                    ) {
                break;
            }

            Std.subExchangeValuesInArray(arrcharBase_M, intLow, intHigh);
            Std.subExchangeValuesInArray(arrintSecond_M, intLow, intHigh);

            //                                              //Reduce Range
            intLow = intLow + 1;
            intHigh = intHigh - 1;
        }
        /*END-LOOP*/

        if ( //
                //                                          //Lower half require to be sorted
                intStart_I < intHigh //
                ) {
            Std.subQuickSort(arrcharBase_M, arrintSecond_M, intStart_I, intHigh);
        }

        if ( //
                //                                          //Upper half require to be sorted
                intLow < intEnd_I //
                ) {
            Std.subQuickSort(arrcharBase_M, arrintSecond_M, intLow, intEnd_I);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static <XC extends Comparable> void subMainQuickSort( //

            XC[] arrxcBase_M,
            int[] arrintSecond_M
    ) {
        if ( //
                arrxcBase_M.length > 0 //
                ) {
            Std.subQuickSort(arrxcBase_M, arrintSecond_M, 0, arrxcBase_M.length - 1);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static <XC extends Comparable> void subQuickSort( //

            XC[] arrxcBase_M,
            int[] arrintSecond_M,
            //                                              //Sort within this limits
            int intStart_I,
            int intEnd_I
    ) {
        int intLow = intStart_I;
        int intHigh = intEnd_I;

        XC xcPivot = arrxcBase_M[intStart_I];

        /*LOOP*/
        while (true) {
            //                                              //Search for next pair of values to exchange

            if ( //
                    intLow <= intHigh //
                    ) {
                //                                          //Search for next high (from start) to exchange.
                /*UNTIL-DO*/
                while (!( //
                        arrxcBase_M[intLow].compareTo(xcPivot) >= 0 //
                        )) {
                    intLow = intLow + 1;
                }
                //                                          //Search for next low (backwards from end) to exchange.
                /*UNTIL-DO*/
                while (!( //
                        arrxcBase_M[intHigh].compareTo(xcPivot) <= 0 //
                        )) {
                    intHigh = intHigh - 1;
                }
            }

            /*EXIT-IF*/
            if ( //
                    //                                      //No more pair of values to exchange.
                    //                                      //It is the same element or did not find values in range
                    intLow > intHigh //
                    ) {
                break;
            }

            Std.subExchangeValuesInArray(arrxcBase_M, intLow, intHigh);
            Std.subExchangeValuesInArray(arrintSecond_M, intLow, intHigh);

            //                                              //Reduce Range
            intLow = intLow + 1;
            intHigh = intHigh - 1;
        }
        /*END-LOOP*/

        if ( //
                //                                          //Lower half require to be sorted
                intStart_I < intHigh //
                ) {
            Std.subQuickSort(arrxcBase_M, arrintSecond_M, intStart_I, intHigh);
        }

        if ( //
                //                                          //Upper half require to be sorted
                intLow < intEnd_I //
                ) {
            Std.subQuickSort(arrxcBase_M, arrintSecond_M, intLow, intEnd_I);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subExchangeValuesInArray( //

            int[] arrint_M,
            //                                              //Positions to exchange
            int intA_I,
            int intB_I
    ) {
        int intSaveValueInA = arrint_M[intA_I];
        arrint_M[intA_I] = arrint_M[intB_I];
        arrint_M[intB_I] = intSaveValueInA;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subExchangeValuesInArray( //

            long[] arrlong_M,
            //                                              //Positions to exchange
            int intA_I,
            int intB_I
    ) {
        long longSaveValueInA = arrlong_M[intA_I];
        arrlong_M[intA_I] = arrlong_M[intB_I];
        arrlong_M[intB_I] = longSaveValueInA;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subExchangeValuesInArray( //

            double[] arrnum_M,
            //                                              //Positions to exchange
            int intA_I,
            int intB_I
    ) {
        double numSaveValueInA = arrnum_M[intA_I];
        arrnum_M[intA_I] = arrnum_M[intB_I];
        arrnum_M[intB_I] = numSaveValueInA;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subExchangeValuesInArray( //

            char[] arrchar_M,
            //                                              //Positions to exchange
            int intA_I,
            int intB_I
    ) {
        char charSaveValueInA = arrchar_M[intA_I];
        arrchar_M[intA_I] = arrchar_M[intB_I];
        arrchar_M[intB_I] = charSaveValueInA;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static <XT> void subExchangeValuesInArray( //

            XT[] arrxt_M,
            //                                              //Positions to exchange
            int intA_I,
            int intB_I
    ) {
        XT xtSaveValueInA = arrxt_M[intA_I];
        arrxt_M[intA_I] = arrxt_M[intB_I];
        arrxt_M[intB_I] = xtSaveValueInA;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subResequenceSecondArray( //

            long[] arrlong_M,
            int[] arrintSequence_I
    ) {
        long[] arrlongTemp = new long[arrlong_M.length];
        System.arraycopy(arrlong_M, 0, arrlongTemp, 0, arrlong_M.length);

        for (int intI = 0; intI < arrintSequence_I.length; intI = intI + 1) {
            arrlong_M[intI] = arrlongTemp[arrintSequence_I[intI]];
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subResequenceSecondArray( //

            double[] arrnum_M,
            int[] arrintSequence_I
    ) {
        double[] arrnumTemp = new double[arrnum_M.length];
        System.arraycopy(arrnum_M, 0, arrnumTemp, 0, arrnum_M.length);

        for (int intI = 0; intI < arrintSequence_I.length; intI = intI + 1) {
            arrnum_M[intI] = arrnumTemp[arrintSequence_I[intI]];
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subResequenceSecondArray( //

            char[] arrchar_M,
            int[] arrintSequence_I
    ) {
        char[] arrcharTemp = new char[arrchar_M.length];
        System.arraycopy(arrchar_M, 0, arrcharTemp, 0, arrchar_M.length);

        for (int intI = 0; intI < arrintSequence_I.length; intI = intI + 1) {
            arrchar_M[intI] = arrcharTemp[arrintSequence_I[intI]];
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subResequenceSecondArray( //

            boolean[] arrbool_M,
            int[] arrintSequence_I
    ) {
        boolean[] arrboolTemp = new boolean[arrbool_M.length];
        System.arraycopy(arrbool_M, 0, arrboolTemp, 0, arrbool_M.length);

        for (int intI = 0; intI < arrintSequence_I.length; intI = intI + 1) {
            arrbool_M[intI] = arrboolTemp[arrintSequence_I[intI]];
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    private static <XT> void subResequenceSecondArray( //

            XT[] arrxt_M,
            int[] arrintSequence_I
    ) {
        //                                                  //Java do not allow new XT[n].
        Object[] arrobjTemp = new Object[arrxt_M.length];
        System.arraycopy(arrxt_M, 0, arrobjTemp, 0, arrxt_M.length);

        for (int intI = 0; intI < arrintSequence_I.length; intI = intI + 1) {
            arrxt_M[intI] = (XT) arrobjTemp[arrintSequence_I[intI]];
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TOOLS FOR DEBUGGING
    //
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    //==================================================================================================================
    /*END-TASK*/
    //
    //
    /*TASK Std.DynamicArray*/
    //==============================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //DECLARATION AND ASSIGNMENT
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONSTRUCTION
    //
    //------------------------------------------------------------------------------------------------------------------
    public static ArrayList newDynamicArray( // 
            int[] arrint_I
    ) {
        ArrayList<Integer> newDynamicArray = new ArrayList<>();
        for (int intItem : arrint_I) {
            newDynamicArray.add(intItem);
        }

        return newDynamicArray;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static ArrayList newDynamicArray( // 
            long[] arrlong_I
    ) {
        ArrayList<Long> newDynamicArray = new ArrayList<>();
        for (long longItem : arrlong_I) {
            newDynamicArray.add(longItem);
        }

        return newDynamicArray;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static ArrayList newDynamicArray( // 
            double[] arrnum_I
    ) {
        ArrayList<Double> newDynamicArray = new ArrayList<>();
        for (double numItem : arrnum_I) {
            newDynamicArray.add(numItem);
        }

        return newDynamicArray;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static ArrayList newDynamicArray( // 
            char[] arrchar_I
    ) {
        ArrayList<Character> newDynamicArray = new ArrayList<>();
        for (char charItem : arrchar_I) {
            newDynamicArray.add(charItem);
        }

        return newDynamicArray;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static ArrayList newDynamicArray( // 
            boolean[] arrbool_I
    ) {
        ArrayList<Boolean> newDynamicArray = new ArrayList<>();
        for (boolean boolItem : arrbool_I) {
            newDynamicArray.add(boolItem);
        }

        return newDynamicArray;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static <XT> ArrayList<XT> newDynamicArray( // 
            XT[] arrxt_I
    ) {
        ArrayList<XT> newDynamicArray = new ArrayList<>();
        for (XT xtItem : arrxt_I) {
            newDynamicArray.add(xtItem);
        }

        return newDynamicArray;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static <XT> ArrayList<XT> newDynamicArray( //
            Collection<XT> collxt_I
    ) {
        ArrayList<XT> newDynamicArray = new ArrayList<>();
        for (XT xtItem : collxt_I) {
            newDynamicArray.add(xtItem);
        }

        return newDynamicArray;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSIONS
    //
    //------------------------------------------------------------------------------------------------------------------
    public static int[] toIntArray( // 
            ArrayList<Integer> darrint_I
    ) {
        int[] arrint = new int[darrint_I.size()];
        for (int intI = 0; intI < darrint_I.size(); intI = intI + 1) {
            arrint[intI] = darrint_I.get(intI);
        }

        return arrint;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static long[] toLongArray( // 
            ArrayList<Long> darrlong_I
    ) {
        long[] arrlong = new long[darrlong_I.size()];
        for (int intI = 0; intI < darrlong_I.size(); intI = intI + 1) {
            arrlong[intI] = darrlong_I.get(intI);
        }

        return arrlong;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static double[] toNumArray( // 
            ArrayList<Double> darrnum_I
    ) {
        double[] arrnum = new double[darrnum_I.size()];
        for (int intI = 0; intI < darrnum_I.size(); intI = intI + 1) {
            arrnum[intI] = darrnum_I.get(intI);
        }

        return arrnum;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static boolean[] toBoolArray( // 
            ArrayList<Boolean> darrbool_I
    ) {
        boolean[] arrbool = new boolean[darrbool_I.size()];
        for (int intI = 0; intI < darrbool_I.size(); intI = intI + 1) {
            arrbool[intI] = darrbool_I.get(intI);
        }

        return arrbool;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static char[] toCharArray( // 
            ArrayList<Character> darrchar_I
    ) {
        char[] arrchar = new char[darrchar_I.size()];
        for (int intI = 0; intI < darrchar_I.size(); intI = intI + 1) {
            arrchar[intI] = darrchar_I.get(intI);
        }

        return arrchar;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //ACCESS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //MANIPULATION
    //
    //[GLG 22Feb2019] 1. Cambiar nombre addArray to addCollection, 2. añadir un método similar para collections
    //------------------------------------------------------------------------------------------------------------------
    public static void addArray( //
            ArrayList<Integer> darrint_I,
            int[] arrint_I
    ) {
        for (int intItem : arrint_I) {
            darrint_I.add(intItem);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static void addArray( //
            ArrayList<Long> darrlong_I,
            long[] arrlong_I
    ) {
        for (long longItem : arrlong_I) {
            darrlong_I.add(longItem);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static void addArray( //
            ArrayList<Double> darrnum_I,
            double[] arrnum_I
    ) {
        for (double numItem : arrnum_I) {
            darrnum_I.add(numItem);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static void addArray( //
            ArrayList<Character> darrchar_I,
            char[] arrchar_I
    ) {
        for (char charItem : arrchar_I) {
            darrchar_I.add(charItem);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static void addArray( //
            ArrayList<Boolean> darrbool_I,
            boolean[] arrbool_I
    ) {
        for (boolean boolItem : arrbool_I) {
            darrbool_I.add(boolItem);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static <XT> void addArray( //
            ArrayList<XT> darrxt_I,
            XT[] arrxt_I
    ) {
        for (XT xtItem : arrxt_I) {
            darrxt_I.add(xtItem);
        }
    }

    //                                                      //TOOLS FOR DEBUGGING
    //
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Std.LinkedList*/
    //==============================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //DECLARATION AND ASSIGNMENT
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONSTRUCTION
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSIONS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //ACCESS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //MANIPULATION
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TOOLS FOR DEBUGGING
    //
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Std.Stack*/
    //==============================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //DECLARATION AND ASSIGNMENT
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONSTRUCTION
    //
    //------------------------------------------------------------------------------------------------------------------
    public static Stack<Integer> newStack( // 
            int[] arrint_I
    ) {
        Stack<Integer> newStack = new Stack<>();
        for (int intItem : arrint_I) {
            newStack.add(intItem);
        }

        return newStack;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static Stack<Long> newStack( // 
            long[] arrlong_I
    ) {
        Stack<Long> newStack = new Stack<>();
        for (long longItem : arrlong_I) {
            newStack.add(longItem);
        }

        return newStack;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static Stack<Double> newStack( // 
            double[] arrnum_I
    ) {
        Stack<Double> newStack = new Stack<>();
        for (double numItem : arrnum_I) {
            newStack.add(numItem);
        }

        return newStack;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static Stack<Character> newStack( // 
            char[] arrchar_I
    ) {
        Stack<Character> newStack = new Stack<>();
        for (char charItem : arrchar_I) {
            newStack.add(charItem);
        }

        return newStack;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static Stack<Boolean> newStack( // 
            boolean[] arrbool_I
    ) {
        Stack<Boolean> newStack = new Stack<>();
        for (boolean boolItem : arrbool_I) {
            newStack.push(boolItem);
        }

        return newStack;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static <XT> Stack<XT> newStack( //
            XT[] arrxt_I
    ) {
        Stack<XT> newStack = new Stack<>();
        for (XT xtItem : arrxt_I) {
            newStack.push(xtItem);
        }

        return newStack;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static <XT> Stack<XT> newStack( //
            Collection<XT> collxt_I
    ) {
        Stack<XT> newStack = new Stack<>();
        for (XT xtItem : collxt_I) {
            newStack.push(xtItem);
        }

        return newStack;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSIONS
    //
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static int[] toIntArray( // 
            Stack<Integer> stackint_I
    ) {
        int[] arrint = new int[stackint_I.size()];
        for (int intI = 0; intI < stackint_I.size(); intI = intI + 1) {
            arrint[intI] = stackint_I.elementAt(intI);
        }

        return arrint;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static long[] toLongArray( // 
            Stack<Long> stacklong_I
    ) {
        long[] arrlong = new long[stacklong_I.size()];
        for (int intI = 0; intI < stacklong_I.size(); intI = intI + 1) {
            arrlong[intI] = stacklong_I.elementAt(intI);
        }

        return arrlong;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static double[] toNumArray( // 
            Stack<Double> stacknum_I
    ) {
        double[] arrnum = new double[stacknum_I.size()];
        for (int intI = 0; intI < stacknum_I.size(); intI = intI + 1) {
            arrnum[intI] = stacknum_I.elementAt(intI);
        }

        return arrnum;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static boolean[] toBoolArray( // 
            Stack<Boolean> stackbool_I
    ) {
        boolean[] arrbool = new boolean[stackbool_I.size()];
        for (int intI = 0; intI < stackbool_I.size(); intI = intI + 1) {
            arrbool[intI] = stackbool_I.elementAt(intI);
        }

        return arrbool;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static char[] toCharArray( // 
            Stack<Character> stackchar_I
    ) {
        char[] arrchar = new char[stackchar_I.size()];
        for (int intI = 0; intI < stackchar_I.size(); intI = intI + 1) {
            arrchar[intI] = stackchar_I.elementAt(intI);
        }

        return arrchar;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //ACCESS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //MANIPULATION
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TOOLS FOR DEBUGGING
    //
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Std.Queue*/
    //==============================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //DECLARATION AND ASSIGNMENT
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONSTRUCTION
    //
    //------------------------------------------------------------------------------------------------------------------
    public static Queue<Integer> newQueue( //
            int[] arrint_I
    ) {
        Queue<Integer> newQueue = new ConcurrentLinkedDeque();
        for (int intItem : arrint_I) {
            newQueue.add(intItem);
        }

        return newQueue;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static Queue<Long> newQueue( //
            long[] arrlong_I
    ) {
        Queue<Long> newQueue = new ConcurrentLinkedDeque();
        for (long longItem : arrlong_I) {
            newQueue.add(longItem);
        }

        return newQueue;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static Queue<Double> newQueue( //
            double[] arrnum_I
    ) {
        Queue<Double> newQueue = new ConcurrentLinkedDeque();
        for (double numItem : arrnum_I) {
            newQueue.add(numItem);
        }

        return newQueue;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static Queue<Character> newQueue( //
            char[] arrchar_I
    ) {
        Queue<Character> newQueue = new ConcurrentLinkedDeque();
        for (char charItem : arrchar_I) {
            newQueue.add(charItem);
        }

        return newQueue;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static Queue<Boolean> newQueue( //
            boolean[] arrbool_I
    ) {
        Queue<Boolean> newQueue = new ConcurrentLinkedDeque();
        for (boolean boolItem : arrbool_I) {
            newQueue.add(boolItem);
        }

        return newQueue;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static <XT> Queue<XT> newQueue( //
            XT[] arrxt_I
    ) {
        Queue<XT> newQueue = new ConcurrentLinkedDeque();
        for (XT xtItem : arrxt_I) {
            newQueue.add(xtItem);
        }

        return newQueue;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static <XT> Queue<XT> newQueue( //
            Collection<XT> collxt_I
    ) {
        Queue<XT> newQueue = new ConcurrentLinkedDeque();
        for (XT xtItem : collxt_I) {
            newQueue.add(xtItem);
        }

        return newQueue;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSIONS
    //
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static int[] toIntArray( //
            Queue<Integer> queueint_I
    ) {
        int[] arrint = new int[queueint_I.size()];
        for (int intI = 0; intI < queueint_I.size(); intI += 1) {
            arrint[intI] = queueint_I.poll();
        }

        return arrint;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static long[] toLongArray( //
            Queue<Long> queuelong_I
    ) {
        long[] arrlong = new long[queuelong_I.size()];
        for (int intI = 0; intI < queuelong_I.size(); intI += 1) {
            arrlong[intI] = queuelong_I.poll();
        }

        return arrlong;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static double[] toNumArray( //
            Queue<Double> queuenum_I
    ) {
        double[] arrnum = new double[queuenum_I.size()];
        for (int intI = 0; intI < queuenum_I.size(); intI += 1) {
            arrnum[intI] = queuenum_I.poll();
        }

        return arrnum;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static boolean[] toBoolArray( //
            Queue<Boolean> queuebool_I
    ) {
        boolean[] arrbool = new boolean[queuebool_I.size()];
        for (int intI = 0; intI < queuebool_I.size(); intI += 1) {
            arrbool[intI] = queuebool_I.poll();
        }

        return arrbool;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static char[] toCharArray( //
            Queue<Character> queuechar_I
    ) {
        char[] arrchar = new char[queuechar_I.size()];
        for (int intI = 0; intI < queuechar_I.size(); intI += 1) {
            arrchar[intI] = queuechar_I.poll();
        }

        return arrchar;
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                      //ACCESS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //MANIPULATION
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TOOLS FOR DEBUGGING
    //
    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Std.XXXXX*/
    //==================================================================================================================
    //                                                      //LITERAL
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //DECLARATION, CONSTRUCTION AND ASSIGNMENT
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSIONS
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //RELATIONAL OPERATORS*/
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //EQUALITY OPERATORS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //********************************OTHER OPERATORS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TERNARY CONDITIONAL OPERATOR
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //MINIMUM AND //MAXIMUM
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TOOLS FOR DEBUGGING
    //
    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Std.MinOrMax methods to compute min o max value*/
    //==================================================================================================================
    //                                                      //En Java existen las funciones ___.min() y ___.max(), sin
    //                                                      //      embargo estas aceptan solo 2 valores.
    //                                                      //Adicionalmente se desea tener strMinOf(), enumMinOf(),
    //                                                      //      benumMinOf() y btupleMinOf().
    //------------------------------------------------------------------------------------------------------------------
    public static Enum minOf(
            //                                              //Determina el valor mínimo.

            //                                              //enum, MIN value.

            Enum... arrenum_I
    ) {
        if ( //
                arrenum_I == null //
                ) {
            Test.abort(Test.toLog(arrenum_I, "arrenum_I") + " can not be null");
        }
        if ( //
                arrenum_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrenum_I, "arrenum_I") + " should have at least 1 item");
        }

        Enum enumMinOf = arrenum_I[0];

        for (int intI = 1; intI < arrenum_I.length; intI = intI + 1) {
            if ( //
                    arrenum_I[intI].compareTo(enumMinOf) < 0 //
                    ) {
                enumMinOf = arrenum_I[intI];
            }
        }

        return enumMinOf;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static Enum maxOf(
            //                                              //Determina el valor máximo.

            //                                              //enum, MAX value.

            Enum... arrenum_I
    ) {
        if ( //
                arrenum_I == null //
                ) {
            Test.abort(Test.toLog(arrenum_I, "arrenum_I") + " can not be null");
        }
        if ( //
                arrenum_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrenum_I, "arrenum_I") + " should have at least 1 item");
        }

        Enum enumMaxOf = arrenum_I[0];

        for (int intI = 1; intI < arrenum_I.length; intI = intI + 1) {
            if ( //
                    arrenum_I[intI].compareTo(enumMaxOf) > 0 //
                    ) {
                enumMaxOf = arrenum_I[intI];
            }
        }

        return enumMaxOf;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static BtupleAbstract minOf(
            //                                              //Determina el valor mínimo.

            //                                              //btuple, MIN value.

            BtupleAbstract... arrbtuple_I
    ) {
        if ( //
                arrbtuple_I == null //
                ) {
            Test.abort(Test.toLog(arrbtuple_I, "arrbtuple_I") + " can not be null");
        }
        if ( //
                arrbtuple_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrbtuple_I, "arrbtuple_I") + " should have at least 1 item");
        }

        BtupleAbstract btupleMinOf = arrbtuple_I[0];

        for (int intI = 1; intI < arrbtuple_I.length; intI = intI + 1) {
            if ( //
                    //                                      //btuple < btupleMinOf
                    arrbtuple_I[intI].compareTo(btupleMinOf) < 0 //
                    ) {
                btupleMinOf = arrbtuple_I[intI];
            }
        }

        return btupleMinOf;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static BtupleAbstract maxOf(
            //                                              //Determina el valor máximo.

            //                                              //btuple, MAX value.

            BtupleAbstract... arrbtuple_I
    ) {
        if ( //
                arrbtuple_I == null //
                ) {
            Test.abort(Test.toLog(arrbtuple_I, "arrbtuple_I") + " can not be null");
        }
        if ( //
                arrbtuple_I.length == 0 //
                ) {
            Test.abort(Test.toLog(arrbtuple_I, "arrbtuple_I") + " should have at least 1 item");
        }

        BtupleAbstract btupleMaxOf = arrbtuple_I[0];

        for (int intI = 1; intI < arrbtuple_I.length; intI = intI + 1) {
            if ( //
                    //                                          //btuple < btupleMaxOf
                    arrbtuple_I[intI].compareTo(btupleMaxOf) > 0 //
                    ) {
                btupleMaxOf = arrbtuple_I[intI];
            }
        }

        return btupleMaxOf;
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Std.Constants*/
    //==================================================================================================================
    //                                                      //***** SECCIÓN PENDIENTE DE ORDENAR
    //------------------------------------------------------------------------------------------------------------------
    /*CONTANTS*/
    public static String OO_INST = "Java";

    //                                                      //Ordenando TODOS los caracteres en forma de string con
    //                                                      //      Array.Sort(arrstr) se determinaron los siguientes
    //                                                      //      Valores.
    //                                                      //¿¿Será igual en Java y en Swift??
    //==================================================================================================================
    /*END-TASK*/
    //
    //==================================================================================================================
    //
    /*TASK Std.Format Format int, long & num to text*/
    //==================================================================================================================
    //------------------------------------------------------------------------------------------------------------------
    public static String format(
            //                                              //Formatea.

            //                                              //str, timestamp formateado.

            LocalDateTime dt_I,
            String strPicture_I
    ) {
        return dt_I.format(DateTimeFormatter.ofPattern(strPicture_I));
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    //==================================================================================================================
    /*END-TASK*/
    //------------------------------------------------------------------------------------------------------------------

    /*TASK Std.Parse Create Matrix */
    //==================================================================================================================
    public static <T> T[][] arr2New( //
            //                                              //Creates an Array and aborts if they arent the same length
            T[][] arr2New
    ) {

        for (int intI = 0; intI < arr2New.length; intI = intI + 1) {
            //                                              //Recorre los columnas de la Matriz
            if ( //
                    //                                      //Compara el tamaño de cada elemento con el tamaño
                    //                                      //      del primer elemento
                    arr2New[0].length != arr2New[intI].length) {
                //                                          //Aborta si no son del mismo tamaño
                Test.abort("Arreglo: " + Arrays.deepToString(arr2New) + " no es rectangular");
            }
        }

        return (arr2New);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static int[][] arr2New( //
            //                                              //Creates an Array and aborts if they arent the same length

            int[][] arr2New
    ) {

        for (int intI = 0; intI < arr2New.length; intI = intI + 1) {
            //                                              //Recorre los elementos de la Matriz
            if ( //
                    //                                      //Compara el tamaño de cada elemento con el tamaño
                    //                                      //      del primer elemento
                    arr2New[0].length != arr2New[intI].length) {
                //                                          //Aborta si no son del mismo tamaño
                Test.abort("Arreglo: " + Arrays.deepToString(arr2New) + " no es rectangular");
            }
        }

        return (arr2New);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static long[][] arr2New( //
            //                                              //Creates an Array and aborts if they arent the same length

            long[][] arr2New
    ) {

        for (int intI = 0; intI < arr2New.length; intI = intI + 1) {
            //                                              //Recorre los elementos de la Matriz
            if ( //
                    //                                      //Compara el tamaño de cada elemento con el tamaño
                    //                                      //      del primer elemento
                    arr2New[0].length != arr2New[intI].length) {
                //                                          //Aborta si no son del mismo tamaño
                Test.abort("Arreglo: " + Arrays.deepToString(arr2New) + " no es rectangular");
            }
        }

        return (arr2New);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static double[][] arr2New( //
            //                                              //Creates an Array and aborts if they arent the same length

            double[][] arr2New
    ) {

        for (int intI = 0; intI < arr2New.length; intI = intI + 1) {
            //                                              //Recorre los elementos de la Matriz
            if ( //
                    //                                      //Compara el tamaño de cada elemento con el tamaño
                    //                                      //      del primer elemento
                    arr2New[0].length != arr2New[intI].length) {
                //                                          //Aborta si no son del mismo tamaño
                Test.abort("Arreglo: " + Arrays.deepToString(arr2New) + " no es rectangular");
            }
        }

        return (arr2New);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static boolean[][] arr2New( //
            //                                              //Creates an Array and aborts if they arent the same length

            boolean[][] arr2New
    ) {

        for (int intI = 0; intI < arr2New.length; intI = intI + 1) {
            //                                              //Recorre los elementos de la Matriz
            if ( //
                    //                                      //Compara el tamaño de cada elemento con el tamaño
                    //                                      //      del primer elemento
                    arr2New[0].length != arr2New[intI].length) {
                //                                          //Aborta si no son del mismo tamaño
                Test.abort("Arreglo: " + Arrays.deepToString(arr2New) + " no es rectangular");
            }
        }

        return (arr2New);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static char[][] arr2New( //
            //                                              //Creates an Array and aborts if they arent the same length

            char[][] arr2New
    ) {

        for (int intI = 0; intI < arr2New.length; intI = intI + 1) {
            //                                              //Recorre los elementos de la Matriz
            if ( //
                    //                                      //Compara el tamaño de cada elemento con el tamaño
                    //                                      //      del primer elemento
                    arr2New[0].length != arr2New[intI].length) {
                //                                          //Aborta si no son del mismo tamaño
                Test.abort("Arreglo: " + Arrays.deepToString(arr2New) + " no es rectangular");
            }
        }

        return (arr2New);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //------------------------------------------------------------------------------------------------------------------
    /*TASK Std.Parse 2D Matrix Length*/
    //==================================================================================================================
    public static <T> int getLength( //
            //                                              //Gives the Lenght of an Array

            T[][] arr2New,
            //                                              //The "rank" desired to get Length
            int intRank
    ) {
        int intLenght;

        /*CASE*/
        if ( //
                //
                intRank == 0//
                ) {
            //
            intLenght = arr2New.length;
        } //
        else if ( //
                intRank == 1 //
                ) {
            //
            intLenght = arr2New[0].length;
        } //
        else {
            //
            Test.abort("Solo se acepta rangos 0 y 1 en arreglos de 2 dimensiones");
            intLenght = 0;
        }
        /*END-CASE*/

        return intLenght;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static int getLength( //
            //                                              //Gives the Lenght of an Array

            int[][] arr2New,
            //                                              //The "rank" desired to get Length
            int intRank
    ) {
        int intLenght;

        /*CASE*/
        if ( //
                //
                intRank == 0//
                ) {
            //
            intLenght = arr2New.length;
        } //
        else if ( //
                intRank == 1 //
                ) {
            //
            intLenght = arr2New[0].length;
        } //
        else {
            //
            Test.abort("Solo se acepta rangos 0 y 1 en arreglos de 2 dimensiones");
            intLenght = 0;
        }
        /*END-CASE*/

        return intLenght;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static int getLength( //
            //                                              //Gives the Lenght of an Array

            int[][] arr2New,
            //                                              //The "rank" desired to get Length
            long intRank
    ) {
        int intLenght;

        /*CASE*/
        if ( //
                //
                intRank == 0//
                ) {
            //
            intLenght = arr2New.length;
        } //
        else if ( //
                intRank == 1 //
                ) {
            //
            intLenght = arr2New[0].length;
        } //
        else {
            //
            Test.abort("Solo se acepta rangos 0 y 1 en arreglos de 2 dimensiones");
            intLenght = 0;
        }
        /*END-CASE*/

        return intLenght;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static int getLength( //
            //                                              //Gives the Lenght of an Array

            int[][] arr2New,
            //                                              //The "rank" desired to get Length
            double intRank
    ) {
        int intLenght;

        /*CASE*/
        if ( //
                //
                intRank == 0//
                ) {
            //
            intLenght = arr2New.length;
        } //
        else if ( //
                intRank == 1 //
                ) {
            //
            intLenght = arr2New[0].length;
        } //
        else {
            //
            Test.abort("Solo se acepta rangos 0 y 1 en arreglos de 2 dimensiones");
            intLenght = 0;
        }
        /*END-CASE*/

        return intLenght;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static int getLength( //
            //                                              //Gives the Lenght of an Array

            boolean[][] arr2New,
            //                                              //The "rank" desired to get Length
            int intRank
    ) {
        int intLenght;

        /*CASE*/
        if ( //
                //
                intRank == 0//
                ) {
            //
            intLenght = arr2New.length;
        } //
        else if ( //
                intRank == 1 //
                ) {
            //
            intLenght = arr2New[0].length;
        } //
        else {
            //
            Test.abort("Solo se acepta rangos 0 y 1 en arreglos de 2 dimensiones");
            intLenght = 0;
        }
        /*END-CASE*/

        return intLenght;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static int getLength( //
            //                                              //Gives the Lenght of an Array

            char[][] arr2New,
            //                                              //The "rank" desired to get Length
            int intRank
    ) {
        int intLenght;

        /*CASE*/
        if ( //
                //
                intRank == 0//
                ) {
            //
            intLenght = arr2New.length;
        } //
        else if ( //
                intRank == 1 //
                ) {
            //
            intLenght = arr2New[0].length;
        } //
        else {
            //
            Test.abort("Solo se acepta rangos 0 y 1 en arreglos de 2 dimensiones");
            intLenght = 0;
        }
        /*END-CASE*/

        return intLenght;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //
    /*TASK Std.Parse Create 3D Matrix */
    //==================================================================================================================
    public static <T> T[][][] arr3New( //
            //                                              //Creates an Array and aborts if they arent the same length
            T[][][] arr3New
    ) {

        for (int intI = 0; intI < arr3New.length; intI = intI + 1) {
            //                                              //Recorre los columnas de la Matriz
            if ( //
                    //                                      //Compara el tamaño de cada elemento con el tamaño
                    //                                      //      del primer elemento
                    arr3New[0].length != arr3New[intI].length) {
                //                                          //Aborta si no son del mismo tamaño
                Test.abort("Arreglo: " + Arrays.deepToString(arr3New) + " no es rectangular");
            }
        }

        return (arr3New);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static int[][][] arr3New( //
            //                                              //Creates an Array and aborts if they arent the same length

            int[][][] arr3New
    ) {

        for (int intI = 0; intI < arr3New.length; intI = intI + 1) {
            //                                              //Recorre los elementos de la Matriz
            if ( //
                    //                                      //Compara el tamaño de cada elemento con el tamaño
                    //                                      //      del primer elemento
                    arr3New[0].length != arr3New[intI].length) {
                //                                          //Aborta si no son del mismo tamaño
                Test.abort("Arreglo: " + Arrays.deepToString(arr3New) + " no es rectangular");
            }
        }

        return (arr3New);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static long[][][] arr3New( //
            //                                              //Creates an Array and aborts if they arent the same length

            long[][][] arr3New
    ) {

        for (int intI = 0; intI < arr3New.length; intI = intI + 1) {
            //                                              //Recorre los elementos de la Matriz
            if ( //
                    //                                      //Compara el tamaño de cada elemento con el tamaño
                    //                                      //      del primer elemento
                    arr3New[0].length != arr3New[intI].length) {
                //                                          //Aborta si no son del mismo tamaño
                Test.abort("Arreglo: " + Arrays.deepToString(arr3New) + " no es rectangular");
            }
        }

        return (arr3New);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static double[][][] arr3New( //
            //                                              //Creates an Array and aborts if they arent the same length

            double[][][] arr3New
    ) {

        for (int intI = 0; intI < arr3New.length; intI = intI + 1) {
            //                                              //Recorre los elementos de la Matriz
            if ( //
                    //                                      //Compara el tamaño de cada elemento con el tamaño
                    //                                      //      del primer elemento
                    arr3New[0].length != arr3New[intI].length) {
                //                                          //Aborta si no son del mismo tamaño
                Test.abort("Arreglo: " + Arrays.deepToString(arr3New) + " no es rectangular");
            }
        }

        return (arr3New);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static boolean[][][] arr3New( //
            //                                              //Creates an Array and aborts if they arent the same length

            boolean[][][] arr3New
    ) {

        for (int intI = 0; intI < arr3New.length; intI = intI + 1) {
            //                                              //Recorre los elementos de la Matriz
            if ( //
                    //                                      //Compara el tamaño de cada elemento con el tamaño
                    //                                      //      del primer elemento
                    arr3New[0].length != arr3New[intI].length) {
                //                                          //Aborta si no son del mismo tamaño
                Test.abort("Arreglo: " + Arrays.deepToString(arr3New) + " no es rectangular");
            }
        }

        return (arr3New);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static char[][][] arr3New( //
            //                                              //Creates an Array and aborts if they arent the same length

            char[][][] arr3New
    ) {

        for (int intI = 0; intI < arr3New.length; intI = intI + 1) {
            //                                              //Recorre los elementos de la Matriz
            if ( //
                    //                                      //Compara el tamaño de cada elemento con el tamaño
                    //                                      //      del primer elemento
                    arr3New[0].length != arr3New[intI].length) {
                //                                          //Aborta si no son del mismo tamaño
                Test.abort("Arreglo: " + Arrays.deepToString(arr3New) + " no es rectangular");
            }
        }

        return (arr3New);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //------------------------------------------------------------------------------------------------------------------
    /*TASK Std.Parse 3D Matrix Length*/
    //==================================================================================================================
    public static <T> int getLength( //
            //                                              //Gives the Lenght of an Array

            T[][][] arr3New,
            //                                              //The "rank" desired to get Length
            int intRank
    ) {
        int intLenght;

        /*CASE*/
        if ( //
                //
                intRank == 0//
                ) {
            //
            intLenght = arr3New.length;
        } //
        else if ( //
                intRank == 1 //
                ) {
            //
            intLenght = arr3New[0].length;
        } //
        else if ( //
                intRank == 2 //
                ) {
            //
            intLenght = arr3New[0][0].length;
        } //
        else {
            //
            Test.abort("Solo se acepta rangos 0, 1 y 2 en arreglos de3 dimensiones");
            intLenght = 0;
        }
        /*END-CASE*/

        return intLenght;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static int getLength( //
            //                                              //Gives the Lenght of an Array

            int[][][] arr3New,
            //                                              //The "rank" desired to get Length
            int intRank
    ) {
        int intLenght;

        /*CASE*/
        if ( //
                //
                intRank == 0//
                ) {
            //
            intLenght = arr3New.length;
        } //
        else if ( //
                intRank == 1 //
                ) {
            //
            intLenght = arr3New[0].length;
        } //
        else if ( //
                intRank == 2 //
                ) {
            //
            intLenght = arr3New[0][0].length;
        } //
        else {
            //
            Test.abort("Solo se acepta rangos 0, 1 y 2 en arreglos de3 dimensiones");
            intLenght = 0;
        }
        /*END-CASE*/

        return intLenght;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static int getLength( //
            //                                              //Gives the Lenght of an Array

            int[][][] arr3New,
            //                                              //The "rank" desired to get Length
            long intRank
    ) {
        int intLenght;

        /*CASE*/
        if ( //
                //
                intRank == 0//
                ) {
            //
            intLenght = arr3New.length;
        } //
        else if ( //
                intRank == 1 //
                ) {
            //
            intLenght = arr3New[0].length;
        } //
        else if ( //
                intRank == 2 //
                ) {
            //
            intLenght = arr3New[0][0].length;
        } //
        else {
            //
            Test.abort("Solo se acepta rangos 0, 1 y 2 en arreglos de3 dimensiones");
            intLenght = 0;
        }
        /*END-CASE*/

        return intLenght;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static int getLength( //
            //                                              //Gives the Lenght of an Array

            int[][][] arr3New,
            //                                              //The "rank" desired to get Length
            double intRank
    ) {
        int intLenght;

        /*CASE*/
        if ( //
                //
                intRank == 0//
                ) {
            //
            intLenght = arr3New.length;
        } //
        else if ( //
                intRank == 1 //
                ) {
            //
            intLenght = arr3New[0].length;
        } //
        else if ( //
                intRank == 2 //
                ) {
            //
            intLenght = arr3New[0][0].length;
        } //
        else {
            //
            Test.abort("Solo se acepta rangos 0, 1 y 2 en arreglos de3 dimensiones");
            intLenght = 0;
        }
        /*END-CASE*/

        return intLenght;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static int getLength( //
            //                                              //Gives the Lenght of an Array

            boolean[][][] arr3New,
            //                                              //The "rank" desired to get Length
            int intRank
    ) {
        int intLenght;

        /*CASE*/
        if ( //
                //
                intRank == 0//
                ) {
            //
            intLenght = arr3New.length;
        } //
        else if ( //
                intRank == 1 //
                ) {
            //
            intLenght = arr3New[0].length;
        } //
        else if ( //
                intRank == 2 //
                ) {
            //
            intLenght = arr3New[0][0].length;
        } //
        else {
            //
            Test.abort("Solo se acepta rangos 0, 1 y 2 en arreglos de3 dimensiones");
            intLenght = 0;
        }
        /*END-CASE*/

        return intLenght;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static int getLength( //
            //                                              //Gives the Lenght of an Array

            char[][][] arr3New,
            //                                              //The "rank" desired to get Length
            int intRank
    ) {
        int intLenght;

        /*CASE*/
        if ( //
                //
                intRank == 0//
                ) {
            //
            intLenght = arr3New.length;
        } //
        else if ( //
                intRank == 1 //
                ) {
            //
            intLenght = arr3New[0].length;
        } //
        else if ( //
                intRank == 2 //
                ) {
            //
            intLenght = arr3New[0][0].length;
        } //
        else {
            //
            Test.abort("Solo se acepta rangos 0, 1 y 2 en arreglos de3 dimensiones");
            intLenght = 0;
        }
        /*END-CASE*/

        return intLenght;
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    //
    /*TASK Std.System*/
    //==================================================================================================================
    //                                                      //LITERAL
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //DECLARATION, CONSTRUCTION AND ASSIGNMENT
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //CONVERSIONS
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //RELATIONAL OPERATORS*/
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //EQUALITY OPERATORS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //********************************OTHER OPERATORS
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TERNARY CONDITIONAL OPERATOR
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //MINIMUM AND //MAXIMUM
    //
    //------------------------------------------------------------------------------------------------------------------
    //                                                      //TOOLS FOR DEBUGGING
    //
    //------------------------------------------------------------------------------------------------------------------
    public static void sleep( //

            int Milliseconds
    ) {
        try {
            Thread.sleep(50);
        } //
        catch (InterruptedException e) {
        };
    }

    //==================================================================================================================
    /*END-TASK*/
    //------------------------------------------------------------------------------------------------------------------
    /*INITIALIZER*/
    //
    //------------------------------------------------------------------------------------------------------------------
    static {
        //                                              //PREPARE CONSTANTS (Verify later).
        //                                              //WARNING: intentionaly I use Array.Sort intead of Std.Sort
        //                                              //      to avoid the use of Test before completing Std
        //                                              //      initialization process.

        Std.arrstrINT_PICTURE_SORTED = new String[Std.INTEGER_PICTURES.length];
        System.arraycopy(Std.INTEGER_PICTURES, 0, Std.arrstrINT_PICTURE_SORTED, 0, Std.INTEGER_PICTURES.length);
        Arrays.sort(Std.arrstrINT_PICTURE_SORTED);

        Std.arrstrNUM_PICTURE_SORTED = new String[Std.NUMBER_PICTURES.length];
        System.arraycopy(Std.NUMBER_PICTURES, 0, Std.arrstrNUM_PICTURE_SORTED, 0, Std.NUMBER_PICTURES.length);
        Arrays.sort(Std.arrstrNUM_PICTURE_SORTED);

        String strCHAR_USEFUL_IN_TEXT = " ";
        for (T2uccCategoryAndCharsTuple t2ucc : Std.arrt2uccCHAR_USEFUL_IN_TEXT) {
            strCHAR_USEFUL_IN_TEXT = strCHAR_USEFUL_IN_TEXT + t2ucc.strChars;
        }
        Std.CHARS_USEFUL_IN_TEXT = strCHAR_USEFUL_IN_TEXT.toCharArray();
        Arrays.sort(Std.CHARS_USEFUL_IN_TEXT);
        Arrays.sort(Std.arrt2charESCAPE);

        //                                              //VERIFY CONSTANTS.
        Std.subVerifyConstantsCharacter();
        Std.subVerifyConstantsInteger();
        Std.subVerifyConstantsNumber();
    }

    //==================================================================================================================
}
//======================================================================================================================
