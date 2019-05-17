package TowaStandard;

import java.util.*;
import java.io.*;
import java.text.*;
import java.time.*;
import javax.swing.*;

//======================================================================================================================
public final class Test {

    /*TASK Test.Integer(toLog)*/
    //==================================================================================================================
    public static String toLog( //
            //                                              //str, info. prepared for display.

            int integer_I,
            String text_I
    ) {
        return text_I + "(" + Test.toLog(integer_I) + ")";
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //str, info. prepared for display.

            int integer_I
    ) {
        String strInfo = (integer_I == Integer.MIN_VALUE) ? "<MIN_INTEGER>"
                : (integer_I == Integer.MAX_VALUE) ? "<MAX_INTEGER>"
                        : "";

        return Std.toText(integer_I) + strInfo;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //str, info. prepared for display.

            long longInteger_I,
            String text_I
    ) {
        return text_I + "(" + Test.toLog(longInteger_I) + ")";
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //str, info. prepared for display.

            long longInteger_I
    ) {
        String strInfo
                = (longInteger_I == Long.MIN_VALUE) ? "<MIN_LONG_INTEGER>"
                        : (longInteger_I == Long.MAX_VALUE) ? "<MAX_LONG_INTEGER>"
                                : "";

        return Std.toText(longInteger_I) + strInfo;
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Test.Number(toLog)*/
    //==================================================================================================================
    public static String toLog( //
            //                                              //str, info. prepared for display.

            double number_I,
            String text_I
    ) {
        return text_I + "(" + Test.toLog(number_I) + ")";
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //str, info. prepared for display.

            double number_I
    ) {
        String strInfo = (number_I == Double.NEGATIVE_INFINITY) ? "<NEGATIVE_INFINITY>"
                : (number_I == Std.MIN_NUMBER) ? "<MIN_NUMBER>"
                        : (number_I == Double.MAX_VALUE) ? "<MAX_NUMBER>"
                                : (number_I == Double.POSITIVE_INFINITY) ? "<POSITIVE_INFINITY>"
                                        : (number_I == Std.EPSILON) ? "<EPSILON>"
                                                : (number_I == -Std.EPSILON) ? "<-EPSILON>"
                                                        : (number_I == Math.PI) ? "<PI>"
                                                                : (Std.isNaN(number_I)) ? "<NOT_A_NUMBER>"
                                                                : "";

        return Std.toText(number_I) + strInfo;
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Test.Character(toLog)*/
    //==================================================================================================================
    /*CONSTANTS*/
    //                                                      //Caracter que será usado como substituto cuando un caracter
    //                                                      //      no sea "visible".
    private static final char charSUBSTITUTE_NO_USEFUL_IN_TEXT = '●';

    //                                                      //En font consolas, estos caracteres se muestran IGUAL (o
    //                                                      //      muy parecidos) a otros.
    //                                                      //Esta información servira para que en toLog se proporcione
    //                                                      //      una buena descripción.
    private static final T3fakecharTuple[] arrt3fakecharFAKE = {
        //                                                  //Uppercase Letter
        new T3fakecharTuple('Α', '\u0391', "Fake A(u0041)"),
        new T3fakecharTuple('А', '\u0410', "Fake A(u0041)"),
        new T3fakecharTuple('Ӑ', '\u04D0', "Fake Ă(u0102)"),
        new T3fakecharTuple('Ӓ', '\u04D2', "Fake Ä(u00C4)"),
        new T3fakecharTuple('Ᾰ', '\u1FB8', "Fake Ă(u0102)"),
        new T3fakecharTuple('Ᾱ', '\u1FB9', "Fake Ā(u0100)"),
        new T3fakecharTuple('Ε', '\u0395', "Fake E(u0045)"),
        new T3fakecharTuple('Ѐ', '\u0400', "Fake È(u00C8)"),
        new T3fakecharTuple('Ё', '\u0401', "Fake Ë(u00CB)"),
        new T3fakecharTuple('Е', '\u0415', "Fake E(u0045)"),
        new T3fakecharTuple('Ӗ', '\u04D6', "Fake Ĕ(u0114)"),
        new T3fakecharTuple('Ι', '\u0399', "Fake I(u0049)"),
        new T3fakecharTuple('Ϊ', '\u03AA', "Fake Ï(u00CF)"),
        new T3fakecharTuple('І', '\u0406', "Fake I(u0049)"),
        new T3fakecharTuple('Ї', '\u0407', "Fake Ï(u00CF)"),
        new T3fakecharTuple('Ӏ', '\u04C0', "Fake I(u0049)"),
        new T3fakecharTuple('Ῐ', '\u1FD8', "Fake Ĭ(u012C)"),
        new T3fakecharTuple('Ῑ', '\u1FD9', "Fake Ī(u012A)"),
        new T3fakecharTuple('Ο', '\u039F', "Fake O(u004F)"),
        new T3fakecharTuple('О', '\u041E', "Fake O(u004F)"),
        new T3fakecharTuple('Ӧ', '\u04E6', "Fake Ö(u00D6)"),
        new T3fakecharTuple('Β', '\u0392', "Fake B(u0042)"),
        new T3fakecharTuple('В', '\u0412', "Fake B(u0042)"),
        new T3fakecharTuple('Ϲ', '\u03F9', "Fake C(u0043)"),
        new T3fakecharTuple('С', '\u0421', "Fake C(u0043)"),
        new T3fakecharTuple('Đ', '\u0110', "Fake Ð(u00D0)"),
        new T3fakecharTuple('Ɖ', '\u0189', "Fake Ð(u00D0)"),
        new T3fakecharTuple('Η', '\u0397', "Fake H(u0048)"),
        new T3fakecharTuple('Н', '\u041D', "Fake H(u0048)"),
        new T3fakecharTuple('Ј', '\u0408', "Fake J(u004A)"),
        new T3fakecharTuple('Κ', '\u039A', "Fake K(u004B)"),
        new T3fakecharTuple('К', '\u041A', "Fake K(u004B)"),
        new T3fakecharTuple('Ḱ', '\u1E30', "Fake Ќ(u040C)"),
        new T3fakecharTuple('Μ', '\u039C', "Fake M(u004D)"),
        new T3fakecharTuple('М', '\u041C', "Fake M(u004D)"),
        new T3fakecharTuple('Ν', '\u039D', "Fake N(u004E)"),
        new T3fakecharTuple('Ρ', '\u03A1', "Fake P(u0050)"),
        new T3fakecharTuple('Р', '\u0420', "Fake P(u0050)"),
        new T3fakecharTuple('Ѕ', '\u0405', "Fake S(u0053)"),
        new T3fakecharTuple('Τ', '\u03A4', "Fake T(u0054)"),
        new T3fakecharTuple('Т', '\u0422', "Fake T(u0054)"),
        new T3fakecharTuple('Χ', '\u03A7', "Fake X(u0058)"),
        new T3fakecharTuple('Х', '\u0425', "Fake X(u0058)"),
        new T3fakecharTuple('Υ', '\u03A5', "Fake Y(u0059)"),
        new T3fakecharTuple('Ϋ', '\u03AB', "Fake Ÿ(u0178)"),
        new T3fakecharTuple('Ү', '\u04AE', "Fake Y(u0059)"),
        new T3fakecharTuple('Ζ', '\u0396', "Fake Z(u005A)"),
        new T3fakecharTuple('Ȝ', '\u021C', "Fake Ʒ(u01B7)"),
        new T3fakecharTuple('Λ', '\u039B', "Fake Ʌ(u0245)"),
        new T3fakecharTuple('Σ', '\u03A3', "Fake Ʃ(u01A9)"),
        new T3fakecharTuple('ϴ', '\u03F4', "Fake Ɵ(u019F)"),
        new T3fakecharTuple('Ͻ', '\u03FD', "Fake Ɔ(u0186)"),
        new T3fakecharTuple('П', '\u041F', "Fake Π(u03A0)"),
        new T3fakecharTuple('Ѱ', '\u0470', "Fake Ψ(u03A8)"),
        new T3fakecharTuple('Ѳ', '\u0472', "Fake Ɵ(u019F)"),
        new T3fakecharTuple('Ә', '\u04D8', "Fake Ə(u018F)"),
        new T3fakecharTuple('Ӡ', '\u04E0', "Fake Ʒ(u01B7)"),
        new T3fakecharTuple('Ө', '\u04E8', "Fake Ɵ(u019F)"),
        new T3fakecharTuple('Ԑ', '\u0510', "Fake Ɛ(u0190)"),
        new T3fakecharTuple('Ω', '\u2126', "Fake Ω(u03A9)"),
        new T3fakecharTuple('Ↄ', '\u2183', "Fake Ɔ(u0186)"),
        //                                                  //Lowercase Letter
        new T3fakecharTuple('а', '\u0430', "Fake a(u0061)"),
        new T3fakecharTuple('ӓ', '\u04D3', "Fake ä(u00E4)"),
        new T3fakecharTuple('ѐ', '\u0450', "Fake è(u00E8)"),
        new T3fakecharTuple('ё', '\u0451', "Fake ë(u00EB)"),
        new T3fakecharTuple('і', '\u0456', "Fake i(u0069)"),
        new T3fakecharTuple('ϲ', '\u03F2', "Fake c(u0063)"),
        new T3fakecharTuple('ϳ', '\u03F3', "Fake j(u006A)"),
        //                                                  //Space Separator
        new T3fakecharTuple(' ', '\u2000', "Fake blank(u0020)"),
        new T3fakecharTuple(' ', '\u2001', "Fake blank(u0020)"),
        new T3fakecharTuple(' ', '\u2002', "Fake blank(u0020)"),
        new T3fakecharTuple(' ', '\u2003', "Fake blank(u0020)"),
        new T3fakecharTuple(' ', '\u2004', "Fake blank(u0020)"),
        new T3fakecharTuple(' ', '\u2005', "Fake blank(u0020)"),
        new T3fakecharTuple(' ', '\u2006', "Fake blank(u0020)"),
        new T3fakecharTuple(' ', '\u2007', "Fake blank(u0020)"),
        new T3fakecharTuple(' ', '\u2008', "Fake blank(u0020)"),
        new T3fakecharTuple(' ', '\u2009', "Fake blank(u0020)"),
        new T3fakecharTuple(' ', '\u200A', "Fake blank(u0020)"),
        new T3fakecharTuple(' ', '\u202F', "Fake blank(u0020)"),
        new T3fakecharTuple(' ', '\u205F', "Fake blank(u0020)"),
        //                                                  //Dash Punctuation
        new T3fakecharTuple('‐', '\u2010', "Fake -(u002D)"),
        new T3fakecharTuple('–', '\u2013', "Fake ‒(u2012)"),
        new T3fakecharTuple('―', '\u2015', "Fake —(u2014)"),};

    //                                                      //The following set of characters do not print rigth (print
    //                                                      //      something in a box).
    //                                                      //Some printer print ok, some other no.
    private static final T2charDescriptionTuple[] arrt2charNONPRINTABLE = {
        //                                                  //Modifier Letter
        new T2charDescriptionTuple('ˆ', "Nonprintable, accent â"),
        new T2charDescriptionTuple('ˇ', "Nonprintable, accent ň"),
        new T2charDescriptionTuple('ˉ', "Nonprintable, accent ā"),
        //                                                  //Initial Quote Punctuation
        new T2charDescriptionTuple('‘', "Nonprintable, open curved (')quote"),
        //                                                  //Final Quote Punctuation
        new T2charDescriptionTuple('’', "Nonprintable, close curved (')quote"),
        new T2charDescriptionTuple('”', "Nonprintable, close curved (\")double quote"),
        //                                                  //Modifier Symbol
        new T2charDescriptionTuple('¯', "Nonprintable, accent ā"),
        new T2charDescriptionTuple('¸', "Nonprintable, lower accent ņ"),
        new T2charDescriptionTuple('˘', "Nonprintable, accent ă"),
        new T2charDescriptionTuple('˙', "Nonprintable, accent ċ"),
        new T2charDescriptionTuple('˚', "Nonprintable, accent å"),
        new T2charDescriptionTuple('˛', "Nonprintable, lower accent ę"),
        new T2charDescriptionTuple('˜', "Nonprintable, accent ã"),
        new T2charDescriptionTuple('˝', "Nonprintable, accent ő"),
        new T2charDescriptionTuple('῁', "Nonprintable, accent ῧ"),
        new T2charDescriptionTuple('῭', "Nonprintable, accent ῢ"),
        new T2charDescriptionTuple('΅', "Nonprintable, accent ΰ"),
        new T2charDescriptionTuple('´', "Nonprintable, accent ά"),
        //                                                  //Other Punctuation
        new T2charDescriptionTuple('·', "Nonprintable, middle dot"),};

    //                                                      //This are all character that can be keyed on keboard
    private static final String strCHAR_DO_NOT_SHOW_HEX = "0123456789"
            //                                              //Upeer case letter
            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "ÁÉÍÓÚ" + "ÀÈÌÒÙ" + "ÄËÏÖÜ" + "ÂÊÎÔÛ"
            //                                              //Lower case letter
            + "abcdefghijklmnopqrstuvwxyz" + "áéíóú" + "àèìòù" + "äëïöü" + "âêîôû"
            //                                              //Keyboard digits row (lower, upper, alt, upper alt)
            + "º'¡" + ("ª!" + '"' + "·$%&/()=?¿") + ("\\" + "|@#¢∞¬÷“”≠‚")
            //                                              //Keyboard QW... row (lower, upper, alt, upper alt)
            + "`+" + "^*" + "œæ€®†¥øπ[]" + "ŒÆ‡Øˆ±"
            //                                              //Keyboard AS... row (lower, upper, alt, upper alt).
            //                                              //'?' (2 parallel slashs) can be enter alt+G but is not in
            //                                              //      USEFUL (takes more space tha a regular character.
            //                                              //"´ç" + "¨Ç" + "å∫∂ƒ™¶§~{}" + "Å∆ﬁﬂ¯ˇ˘˜«»" ﬁﬂ are not in
            //                                              //      USEFUL
            + "´ç" + "¨Ç" + "å∫∂ƒ™¶§~{}" + "Å∆¯ˇ˘˜«»"
            //                                              //Keyboard <ZX... row (lower, upper, alt, upper alt)
            + "<,.-" + ">;:_" + "≤Ω∑©√ßµ„…–" + "≥‹›◊˙˚"
            //                                              //'▸' used as "neutral" directory separator.
            + Path.DIRECTORY_SEPARATOR_CHAR_MASKED
            //                                              //Space
            + " ";
    private static char[] arrcharDO_NOT_SHOW_HEX;

    //                                                      //En la siguiente estructura se incluyen:
    //                                                      //1. Nonprintable (only on some printers).
    //                                                      //2. Fake, description "'\u0000 ????', Fake ?(u????)".
    //                                                      //3. Escape.
    //                                                      //AT CODING, SOME VALUE IS REQUIRES BECAUSE IT CAN BE USED
    //                                                      //      BEFORE INITIALIZATION IS COMPLETE.
    private static T2charDescriptionTuple[] arrt2charDESCRIPTION;

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //str, info. prepared for display.

            char character_I,
            String text_I
    ) {
        return text_I + "(" + Test.toLog(character_I) + ")";
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //Ejemplos:
            //                                              //1 'c'.
            //                                              //2 '©'<u00A9>.
            //                                              //3 '●'<u0009, \t, Horizontal Tab>.
            //                                              //1) No tiene nada extraño, solo se añaden las comillas.
            //                                              //2) El caracter © no esta en DO_NOT_SHOW_HEX, incluyo su
            //                                              //      su hexadecimal.
            //                                              //3) El caracter esta en arrt2charDESCRITPTION, incluyo su
            //                                              //      hexadecimal y su descripción.
            //                                              //Adicionalmente, si el caracter no esta en USEFUL_IN_TEXT
            //                                              //      se substituye por '●'.
            //                                              //str, info. prepared for display.

            //                                              //Caracter a analizar.
            char character_I
    ) {
        //                                                  //Form char ('c').
        String strChar = "'"
                + ((Arrays.binarySearch(Std.CHARS_USEFUL_IN_TEXT, character_I) >= 0) ? character_I
                : charSUBSTITUTE_NO_USEFUL_IN_TEXT)
                + "'";

        //                                                  //Get diagnostic info.
        int intT2 = Arrays.binarySearch(Test.arrt2charDESCRIPTION, character_I);
        String strInfo;
        if ( //
                //                                          //Se solicita mostrar su hex
                (Arrays.binarySearch(Test.arrcharDO_NOT_SHOW_HEX, character_I) < 0)
                //                                          //De solicita mostar su descripción
                || (intT2 >= 0) //
                ) {
            //                                              //Form tuple with diagnostic info (2 options):
            //                                              //<u89FE>
            //                                              //<u89FE, description>
            strInfo = "<u" + Std.toHexText(character_I)
                    + ((intT2 >= 0) ? ", " + Test.arrt2charDESCRIPTION[intT2].strDESCRIPTION : "") + ">";
        } //
        else {
            //                                              //No aditional info
            strInfo = "";
        }

        return strChar + strInfo;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*SUPPORT METHODS FOR INITIALIZER*/
    //
    //------------------------------------------------------------------------------------------------------------------
    private static void subVerifyConstantsCharacter( //
            //                                              //Método de apoyo llamado en constructor estático.
            //                                              //Prepara las constantes para poder utilizarlas.
            //                                              //1. Inicializa proceso para evitar desplegar 2 veces el
            //                                              //      mismo objeto
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
        Test.subVerifyArrcharDoNotShowHex();

        Test.subVerifyArrt3fakecharFake();
        Test.subVerifyArrt2charNonprintable();

        Test.subVerifyArrt2charDescription();
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void subVerifyArrcharDoNotShowHex( //
            //                                              //a. Chars are USEFUL?
            //                                              //b. Sort.
            //                                              //c. No duplicates.
            ) {
        Test.abortIfOneOrMoreCharactersAreNotInSortedSet(Test.strCHAR_DO_NOT_SHOW_HEX, "Test.strCHAR_DO_NOT_SHOW_HEX",
                Std.CHARS_USEFUL_IN_TEXT, "Std.arrcharUSEFUL_IN_TEXT");

        Test.abortIfDuplicate(Test.arrcharDO_NOT_SHOW_HEX, "Test.arrcharDO_NOT_SHOW_HEX");
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void subVerifyArrt3fakecharFake( //
            //                                              //3. arrt3fakecharFAKE:
            //                                              //3a. ordenar.
            //                                              //3b. no duplicados
            //                                              //3c. charFAKE debe estar en USEFUL.
            //                                              //3d. charHEX y charFAKE debe ser el mismo.
            //                                              //3e. strDESCRIPTION debe ser "Fake blank(u0020" o
            //                                              //      "Fake ¿(u????)" donde ¿ y ???? representan el
            //                                              //      mismo caracter.
            ) {
        //                                              //Verifica no duplicados
        Test.abortIfDuplicate(Test.arrt3fakecharFAKE, "Test.arrt3fakecharFAKE");

        //                                              //Verifica chars en tupla
        for (int intT3 = 0; intT3 < arrt3fakecharFAKE.length; intT3 = intT3 + 1) {
            if (//
                    Arrays.binarySearch(Std.CHARS_USEFUL_IN_TEXT, Test.arrt3fakecharFAKE[intT3].charFAKE) < 0 //
                    ) {
                Test.abort(Test.toLog(Test.arrt3fakecharFAKE[intT3].charFAKE,
                        "Test.arrt3fakecharFAKE[" + intT3 + "].charFAKE")
                        + " do not exist in USEFUL_IN_TEXT",
                        Test.toLog(Test.arrt3fakecharFAKE[intT3], "Test.arrt3fakecharFAKE[" + intT3 + "]"),
                        Test.toLog(Test.arrt3fakecharFAKE, "Test.arrt3fakecharFAKE"));
            }

            if ( //
                    Test.arrt3fakecharFAKE[intT3].charFAKE != Test.arrt3fakecharFAKE[intT3].charHEX //
                    ) {
                Test.abort(Test.toLog(Test.arrt3fakecharFAKE[intT3].charFAKE,
                        "Test.arrt3fakecharFAKE[" + intT3 + "].charFAKE")
                        + " should be equal to"
                        + Test.toLog(Test.arrt3fakecharFAKE[intT3].charHEX,
                                "Test.arrt3fakecharFAKE[" + intT3 + "].charHEX"),
                        Test.toLog(Test.arrt3fakecharFAKE[intT3], "Test.arrt3fakecharFAKE[" + intT3 + "]"),
                        Test.toLog(Test.arrt3fakecharFAKE, "Test.arrt3fakecharFAKE"));
            }

            //                                              //Verifica descripción
            //                                              //To easy code
            String strDESCRIPTION = Test.arrt3fakecharFAKE[intT3].strDESCRIPTION;

            if ( //
                    strDESCRIPTION == null //
                    ) {
                Test.abort(
                        Test.toLog(strDESCRIPTION,
                                "arrt3fakecharFAKE[" + intT3 + "].strDESCRIPTION") + " can not be null",
                        Test.toLog(Test.arrt3fakecharFAKE[intT3], "Test.arrt3fakecharFAKE[" + intT3 + "]"),
                        Test.toLog(Test.arrt3fakecharFAKE, "Test.arrt3fakecharFAKE"));
            }

            /*CASE*/
            if ( //
                    strDESCRIPTION.compareTo("Fake blank(u0020)") == 0 //
                    ) {
                //                                          //Es una opción correcta, NO HACE NADA
            } //
            else if ( //                                    //Tiene la forma correcta
                    (strDESCRIPTION.length() == "Fake ?(u????)".length())
                    && strDESCRIPTION.startsWith("Fake ")
                    && (strDESCRIPTION.
                            substring("Fake ?".length(), "Fake ?".length() + "(u".length()).compareTo("(u") == 0)
                    && (strDESCRIPTION.charAt(strDESCRIPTION.length() - 1) == ')') //
                    ) {
                //                                          //Verifica descripción
                char charFaked = strDESCRIPTION.charAt("Fake ".length());
                String strCharFaked = Std.toHexText(charFaked);
                String strFakedHex = strDESCRIPTION.substring("Fake ?(u".length(), "Fake ?(u".length() + 4);
                if ( //
                        //                                  //? y ???? no representan el mismo caracter
                        strCharFaked.compareTo(strFakedHex) != 0 //
                        ) {
                    Test.abort(
                            Test.toLog(strDESCRIPTION, "Test.arrt3fakecharFAKE[" + intT3 + "].strDESCRIPTION")
                            + " should include hexadecimal char "
                            + "code \"????\" corresponding to \"?\" in \"Fake ?(u????)\"",
                            Test.toLog(Test.arrt3fakecharFAKE[intT3], "Test.arrt3fakecharFAKE[" + intT3 + "]"),
                            Test.toLog(Test.arrt3fakecharFAKE, "Test.arrt3fakecharFAKE"));
                }

                //                                          //Es una opción correcta, NO HACE NADA
            } //
            else {
                Test.abort(
                        Test.toLog(strDESCRIPTION, "arrt3fakecharFAKE[" + intT3 + "].strDESCRIPTION")
                        + " invalid description",
                        Test.toLog(Test.arrt3fakecharFAKE[intT3], "Test.arrt3fakecharFAKE[" + intT3 + "]"),
                        Test.toLog(Test.arrt3fakecharFAKE, "Test.arrt3fakecharFAKE"));
            }
            /*END-CASE*/
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void subVerifyArrt2charNonprintable( //
            //                                              //4. arrt2charNONPRINTABLE.
            //                                              //4a. ordenar.
            //                                              //4b. no duplicados
            //                                              //4c. debe estar en USEFUL.
            //                                              //4d. tener descripción.
            ) {
        //                                                  //Verifica no duplicados
        Test.abortIfDuplicate(Test.arrt2charNONPRINTABLE, "Test.arrt2charNONPRINTABLE");
        //                                                  //Verifica chars en tupla
        for (int intT2 = 0; intT2 < arrt2charNONPRINTABLE.length; intT2 = intT2 + 1) {

            if ( //
                    Arrays.binarySearch(Std.CHARS_USEFUL_IN_TEXT, Test.arrt2charNONPRINTABLE[intT2].charX) < 0 //
                    ) {
                Test.abort(Test.toLog(Test.arrt2charNONPRINTABLE[intT2].charX,
                        "Test.arrt2charNONPRINTABLE[" + intT2 + "].charX")
                        + " does not exist in USEFUL_IN_TEXT",
                        Test.toLog(Test.arrt2charNONPRINTABLE[intT2], "Test.arrt2charNONPRINTABLE[" + intT2 + "]"),
                        Test.toLog(Test.arrt2charNONPRINTABLE, "Test.arrt2charNONPRINTABLE"));
            }

            if ( //
                    Test.arrt2charNONPRINTABLE[intT2].strDESCRIPTION == null //
                    ) {
                Test.abort(
                        Test.toLog(Test.arrt2charNONPRINTABLE[intT2].strDESCRIPTION,
                                "Test.arrt2charNONPRINTABLE[" + intT2 + "].strDESCRIPTION")
                        + " can not be null",
                        Test.toLog(Test.arrt2charNONPRINTABLE[intT2], "Test.arrt2charNONPRINTABLE[" + intT2 + "]"),
                        Test.toLog(Test.arrt2charNONPRINTABLE, "Test.arrt2charNONPRINTABLE"));
            }

            if ( // 
                    Test.arrt2charNONPRINTABLE[intT2].strDESCRIPTION.compareTo("") == 0 //
                    ) {
                Test.abort(
                        Test.toLog(Test.arrt2charNONPRINTABLE[intT2].strDESCRIPTION,
                                "Test.arrt2charNONPRINTABLE[" + intT2 + "].strDESCRIPTION")
                        + " should have a description",
                        Test.toLog(Test.arrt2charNONPRINTABLE[intT2], "Test.arrt2charNONPRINTABLE[" + intT2 + "]"),
                        Test.toLog(Test.arrt2charNONPRINTABLE, "Test.arrt2charNONPRINTABLE"));
            }
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void subVerifyArrt2charDescription( //                                              //Se incluyen:
            //                                              //1. Nonprintable.
            //                                              //2. Fake, description "'\u0000 ????', Fake ?(u????)".
            //                                              //3. Escape.
            //                                              //Al juntarse los 3 conjuntos de descripciones no deben
            //                                              //      resultar duplicados.
            ) {
        Test.abortIfDuplicate(Test.arrt2charDESCRIPTION, "Test.arrt2charDESCRIPTION");
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Test.Boolean(toLog)*/
    //==================================================================================================================
    public static String toLog( //
            //                                              //str, info. prepared for display.

            boolean boolean_I,
            String text_I
    ) {
        return text_I + "(" + Test.toLog(boolean_I) + ")";
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //str, info. prepared for display.

            boolean boolean_I
    ) {
        return "" + boolean_I;
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Test.String(toLog)*/
    //==================================================================================================================
    /*CONSTANTS*/
    //                                                  //Si un String excede esta longitud, se muestra la longitud
    //                                                  //      ejemplo "abd def.... xyz"<88>.
    private static final int intLONG_STRING = 50;

    //                                                  //Cantidad máxima de caracteres diagnosticados que se
    //                                                  //      mostrarán al final de un string
    private static final int intMAX_DIAGNOSTIC = 100;

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog(//
            //                                              //str, info. prepared for display.

            String string_I,
            String text_I
    ) {
        return text_I + "(" + Test.toLog(string_I) + ")";
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //Prepare to display:
            //                                              //1. "this is an string"<17>.
            //                                              //2. "©XYX"<4>{ <0, '©', u00A9> }.
            //                                              //3. "●XYX"<4>{ <0, '●', u0001> }.
            //                                              //4. "●XYX"<4>{ <0, '●', u0009, \t, Horizontal Tab> }.
            //                                              //str, info. prepared for display.

            String string_I
    ) {
        String strToLog;
        if ( //
                string_I == null //
                ) {
            strToLog = "null";
        } //
        else {
            //                                              //Diagnostic each char.
            //                                              //Will produce arrcharStr and darrstrCharInfo

            //                                              //Will convert str to arrchar only if required.
            char[] arrcharStr = null;

            ArrayList<String> darrstrCharInfo = new ArrayList<>();

            for (int intI = 0; intI < string_I.length(); intI = intI + 1) {
                String strChar = Test.toLog(string_I.charAt(intI));

                //                                          //Change string if needed.
                if ( //
                        //                                  //'x' != (x in the string)
                        strChar.charAt(1) != string_I.charAt(intI) //
                        ) {
                    //                                      //Create arrchar if needed
                    arrcharStr = (arrcharStr == null) ? string_I.toCharArray() : arrcharStr;

                    arrcharStr[intI] = strChar.charAt(1);
                }

                //                                          //Add diagnotic if needed
                if ( //
                        //                                  //Has the form: 'x'<info>
                        strChar.length() > 3 //
                        ) {
                    //                                      //Transform info:
                    //                                      //'x'<info> ==> <position, 'x', info>
                    strChar = "<" + intI + ", " + strChar.substring(0, 3) + ", " + strChar.substring(4);

                    darrstrCharInfo.add(strChar);
                }
            }

            //                                              //Reduce diagnostic if needed
            if ( //
                    darrstrCharInfo.size() > Test.intMAX_DIAGNOSTIC //
                    ) {
                //                                          //Remove exceded info and add "... +N more chars"
                int intRemove = darrstrCharInfo.size() - Test.intMAX_DIAGNOSTIC;
                darrstrCharInfo.subList(Test.intMAX_DIAGNOSTIC, darrstrCharInfo.size()).clear();
                darrstrCharInfo.add("... +" + intRemove + " more chars");
            }

            String strLength = (string_I.length() <= Test.intLONG_STRING) ? "" : "<" + string_I.length() + '>';
            String strStr = '"' + ((arrcharStr == null) ? string_I : new String(arrcharStr)) + '"' + strLength;

            String strInfo = (darrstrCharInfo.size() == 0) ? ""
                    : ("{ " + String.join(", ", darrstrCharInfo.toArray(new String[0])) + " }");

            strToLog = strStr + strInfo;
        }

        return strToLog;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //
    /*TASK Test.DateTime(toLog)*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    public static String toLog(//
            //                                              //str, info. prepared for display.

            LocalDateTime dt_I,
            String text_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        return text_I + "(" + Test.toLog(dt_I) + ")";
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog( //
            //                                              //Prepares a date o dt.
            //                                              //Example: 2013-12-28T21:31:25.703-06:00.
            //                                              //str, info. prepared for display.

            LocalDateTime dt_I
    ) {
        return Std.format(dt_I, "yyyy-MM-dd HH:mm:ss");
    }

    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //
    /*TASK Test.Type(toLog)*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //str, info. prepared for display.

            Class type_I,
            String text_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        return text_I + "(" + ((type_I == null) ? "null" : "<Name(" + Std.name(type_I) + ")>") + ")";
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog( //
            //                                              //str, info. prepared for display.

            Class type_I
    ) {
        return (type_I == null) ? "null" : "<" + Std.name(type_I) + ">";
    }

    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //
    /*TASK Test.Exception(toLog)*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //str, info. prepared for display.

            Exception exception_I,
            String text_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        return text_I + "("
                + ((exception_I == null) ? "null" : "<Message(" + exception_I.toString() + ")>") + ")";
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog( //
            //                                              //str, info. prepared for display.

            Exception exception_I
    ) {
        return (exception_I == null) ? "null" : "<" + exception_I.toString() + ">";
    }

    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //
    /*TASK Test.Path(toLog)*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    private static String strFullPathAsIsOrMasked( //
            //                                              //str, full path masked.

            String FullPath_I
    ) {
        Path syspath_I = new Path(FullPath_I);

        return Test.z_TowaPRIVATE_FullPathAsIsOrMasked(syspath_I);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String z_TowaPRIVATE_FullPathAsIsOrMasked( //
            //                                              //If it is in the Test Comparable Log.
            //                                              //1. It is modified to FullPath.
            //                                              //2. Masks full path if it is in arrstrDirectoryToMask.
            //                                              //Example:
            //                                              //"/Users/glg0818/Desktop/Test SoftwareCompare/Data/Abc.txt"
            //                                              //      and "/Users/glg0818/Desktop" and it is in
            //                                              //      arrsyspathDirectoryToMask then:
            //                                              //"§§§●Test SoftwareCompare●Data●Abc.txt.
            //                                              //str, full path masked.

            Path path_I
    ) {
        String strFullPathAsIsOrMasked = path_I.fullPath();

        if ( //
                Test.boolIsComparableLog_Z //
                ) {
            //                                              //Mask is required.

            //                                              //Determines if it has to be masked
            int intX = 0;
            /*REPEAT-UNTIL*/
            while (!( //
                    (intX >= Test.arrsyspathDirectoryToMask.length)
                    //                                      //Is included in the array to mask
                    || path_I.isDirectoyIncludedInPath(Test.arrsyspathDirectoryToMask[intX]) //
                    )) {
                intX = intX + 1;
            }

            if ( //
                    //                                      //Found a directory to mask
                    intX < Test.arrsyspathDirectoryToMask.length //
                    ) {
                //                                          //To easy code
                int intLength = Test.arrsyspathDirectoryToMask[intX].fullPath().length();

                strFullPathAsIsOrMasked = Test.strMASK + path_I.fullPath().substring(intLength);
            }

            strFullPathAsIsOrMasked = strFullPathAsIsOrMasked.replace(Path.NETWORK_MARK,
                    Path.NETWORK_MARK_MASKED);
            strFullPathAsIsOrMasked = strFullPathAsIsOrMasked.replace(Path.VOLUME_SEPARATOR_CHAR,
                    Path.VOLUME_SEPARATOR_CHAR_MASKED);
            strFullPathAsIsOrMasked = strFullPathAsIsOrMasked.replace(Path.DIRECTORY_SEPARATOR_CHAR,
                    Path.DIRECTORY_SEPARATOR_CHAR_MASKED);
        }

        return strFullPathAsIsOrMasked;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //
    /*TASK Test.Directory(toLog)* /
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //str, info. prepared for display.

            Directory directory_I,
            String text_I
    ) {
            Test.abortIfNullOrEmpty(text_I, "text_I");

            String strInfo;
            if ( //
                directory_I == null //
                )
            {
                strInfo = "null";
            } //
            else
            {
                strInfo = "<FullName(" + Test.strFullPathAsIsOrMasked(sysdir_I.fullPath()) + "), " +
                    Test.ToLog(sysdir_I.exists(), "Exists");

                if ( //
                    directory_I.exists() //
                    )
                {
                    strInfo = strInfo + ", " + Test.toLog(directory_I.creationTime(), "CreationTime") + ", " +
                        Test.toLog(directory_I.lastAccessTime(), "LastAccessTime") + ", " +
                        Test.toLog(directory_I.lastWriteTime(), "LastWriteTime") + ", " +
                        Test.toLog(directory_I.getDirectories().length, "Directories") + ", " +
                        Test.toLog(directory_I.getFiles().length, "Files");
                }

                strInfo = strInfo + ">";

            }

            return text_I + "(" + strInfo + ")";
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog( //
            //                                              //str, info. prepared for display.

            Directory directory_I
    ) {
        String toLog;
        if ( //
                directory_I == null //
                ) {
            toLog = "null";
        } //
        else {
            toLog = "<Name(" + sysdir_I.name() + "), " + Test.toLog(sysdir_I.exists());

            if ( //
                    sysdir_I.exists() //
                    ) {
                toLog = toLog + ", " + Test.toLog(directory_I.creationTime()) + ", "
                        + Test.ToLog(directory_I.lastAccessTime()) + ", " + Test.toLog(sysdir_I.lastWriteTime()) + ", "
                        + Test.toLog(directory_I.getDirectories().length) + ", "
                        + Test.toLog(directory_I.getFiles().length);
            }

            toLog = toLog + ">";
        }

        return toLog;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //
    /*TASK Test.File(toLog)*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //str, info. prepared for display.

            File file_I,
            String text_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        String strInfo;
        if ( //
                file_I == null //
                ) {
            strInfo = "null";
        } //
        else {
            strInfo = "WORK IN PROGRESS";
            /*
            strInfo = "<FullName(" + Test.strFullPathAsIsOrMasked(sysfile_I.fullPath()) + "), "
                    + Test.toLog(sysfile_I.exists(), "Exists");

            if ( //
                    sysfile_I.exists() //
                    ) {
                strInfo = strInfo + ", " + Test.toLog(sysfile_I.length(), "Length") + ", "
                        + Test.toLog(sysfile_I.creationTime(), "CreationTime") + ", "
                        + Test.toLog(sysfile_I.lastAccessTime(), "LastAccessTime") + ", "
                        + Test.toLog(sysfile_I.lastWriteTime(), "LastWriteTime");
            }

            strInfo = strInfo + ">";
             */
        }

        return text_I + "(" + strInfo + ")";
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog( //
            //                                              //str, info. prepared for display.

            File file_I
    ) {
        String toLog;
        if ( //
                file_I == null //
                ) {
            toLog = "null";
        } //
        else {
            toLog = "WORK IN PROGRESS";
            /*
            toLog = "<Name(" + sysfile_I.name() + "), " + Test.toLog(sysfile_I.exists());

            if ( //
                    sysfile_I.exists() //
                    ) {
                toLog = toLog + ", " + Test.toLog(sysfile_I.length()) + ", " + Test.toLog(sysfile_I.creationTime())
                        + ", " + Test.toLog(sysfile_I.lastAccessTime()) + ", " + Test.toLog(sysfile_I.lastWriteTime());
            }

            toLog = toLog + ">";
             */
        }

        return toLog;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //
    /*TASK Test.TextReader(toLog)*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //str, info. prepared for display.

            Scanner textReader_I,
            String text_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        return text_I + "("
                + ((textReader_I == null) ? "null"
                        : "<CurrentEncoding(" + "CurrentEncoding" + "), "
                        + Test.toLog(!textReader_I.hasNext(), "EndOfStream") + ")>")
                + ")";
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog( //
            //                                              //str, info. prepared for display.

            Scanner textReader_I
    ) {
        return (textReader_I == null) ? "null"
                : "<" + "CurrentEncoding" + ", " + Test.toLog(!textReader_I.hasNext()) + ">";
    }

    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //
    /*TASK Test.TextWriter(toLog)*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //str, info. prepared for display.

            PrintWriter textWriter_I,
            String text_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        return text_I + "("
                + ((textWriter_I == null) ? "null" : "<Encoding(" + "systextwriter_I.Encoding" + ")>") + ")";
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog( //
            //                                              //str, info. prepared for display.

            PrintWriter textWriter_I
    ) {
        return (textWriter_I == null) ? "null" : "<" + "Encoding" + ">";
    }

    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //
    /*TASK Test.Enum(toLog)*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //str, info. prepared for display.

            Enum enum_I,
            String text_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        String strEnum = (enum_I == null) ? "null" : "" + enum_I;

        return text_I + "(" + strEnum + ")";
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog( //
            //                                              //str, info. prepared for display.

            Enum enum_I
    ) {
        return (enum_I == null) ? "null" : "" + enum_I;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //
    /*TASK Test.Bsys(toLog)*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //str, info. prepared for display.

            BsysBaseSystemAbstract bsys_I,
            String text_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        return text_I + "(" + ((bsys_I == null) ? "null" : bsys_I.toLogFull()) + ")";
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog( //
            //                                              //str, info. prepared for display.

            BsysBaseSystemAbstract bsys_I
    ) {
        return (bsys_I == null) ? "null" : bsys_I.toLogShort();
    }

    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //
    /*TASK Test.Btuple(toLog)*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    public static String toLog( //
            //                                              //str, info. prepared for display.

            BtupleAbstract btuple_I,
            String text_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        return text_I + "(" + ((btuple_I == null) ? "null" : btuple_I.toLogFull()) + ")";
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog( //
            //                                              //str, info. prepared for display.

            BtupleAbstract btuple_I
    ) {
        return (btuple_I == null) ? "null" : btuple_I.toLogShort();
    }

    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //
    /*TASK Test.Bclass(toLog)*/
    //==================================================================================================================
    //------------------------------------------------------------------------------------------------------------------
    public static String toLog(
            //                                              //str, info. prepared for display.

            BclassAbstract bclass_I,
            String text_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        String strToLog;
        /*CASE*/
        if ( //
                bclass_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else if ( //
                bclass_I.isDummy() //
                ) {
            //                                              //Include only objId + DUMMY
            strToLog = text_I + "(" + Test.getObjId(bclass_I) + "[DUMMY])";
        } //
        else if ( //
                //                                          //Was processed before
                Test.darrobjPreviouslyProcessed.contains(bclass_I) //
                ) {
            //                                              //Include only objId
            strToLog = Test.getObjId(bclass_I) + Test.strMessageLogBefore;
        } //
        else {
            //                                              //Register as processed
            Test.darrobjPreviouslyProcessed.add(bclass_I);

            O<String> ostrNL = new O<>();
            O<String> ostrLabel = new O<>();
            O<String> ostrToLog = new O<>();
            Test.subOpenBlock(ostrNL, ostrLabel, ostrToLog, text_I, "");

            ostrToLog.v = ostrToLog.v + bclass_I.toLogFull();

            Test.subCloseBlock(ostrNL, ostrToLog, ostrLabel.v);

            strToLog = ostrToLog.v;
        }
        /*END-CASE*/

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog( //                                              //str, info. prepared for display.

            BclassAbstract bclass_I
    ) {
        String strToLog;
        /*CASE*/
        if ( //
                bclass_I == null //
                ) {
            strToLog = "null";
        } //
        else if ( //
                bclass_I.isDummy() //
                ) {
            //                                              //Include only objId + DUMMY
            strToLog = Test.getObjId(bclass_I) + "[DUMMY]";
        } //
        else if ( //
                //                                          //Was processed before
                Test.darrobjPreviouslyProcessed.contains(bclass_I) //
                ) {
            //                                              //Include only objId
            strToLog = Test.getObjId(bclass_I) + Test.strMessageLogBefore;
        } //
        else {
            //                                              //Register as processed
            Test.darrobjPreviouslyProcessed.add(bclass_I);

            strToLog = bclass_I.toLogShort();
        }
        /*END-CASE*/

        return strToLog;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String getObjId(
            //                                              //str, Aaaaa:HashCode.

            BclassAbstract bclass_I
    ) {
        Test.abortIfNull(bclass_I, "bclass_I");

        //                                                  //Subtract class prefix (aaaaa).
        String strPrefix = Test.strPrefixEnumOrBclass(bclass_I.getClass());

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + bclass_I.hashCode();

        return strPrefix + ":" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //
    /*TASK Test.Array(toLog)*/
    //==================================================================================================================
    //
    //                                                      //Primitives in array can not be generic type, need to
    //                                                      //      be wrapped
    //
    //------------------------------------------------------------------------------------------------------------------
    public static String toLog(
            int[] array_I,
            String text_I
    ) {
        return Test.toLog(array_I, text_I, LogArrOptionEnum.HORIZONTAL);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            int[] array_I,
            String text_I,
            LogArrOptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        String strToLog;
        if ( //
                array_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            //                                              //Wrap integer array
            Integer[] arrintn = new Integer[array_I.length];
            for (int intI = 0; intI < array_I.length; intI = intI + 1) {
                arrintn[intI] = array_I[intI];
            }

            strToLog = Test.strFormatArrayOrCollection(arrintn, array_I, text_I, Test.strObjIdGet(array_I),
                    logOption_I);
        }

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            int[] array_I
    ) {
        return (array_I == null) ? "null" : Test.strObjIdGet(array_I);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static String strObjIdGet(
            //                                              //str, arrint«Size»:HashCode.

            int[] arrint_I
    ) {
        Test.abortIfNull(arrint_I, "arrint_I");

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arrint_I.hashCode();

        return "arrint«" + arrint_I.length + "»:" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog(
            long[] array_I,
            String text_I
    ) {
        return Test.toLog(array_I, text_I, LogArrOptionEnum.HORIZONTAL);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            long[] array_I,
            String text_I,
            LogArrOptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        String strToLog;
        if ( //
                array_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            //                                              //Wrap long integer array
            Long[] arrlongn = new Long[array_I.length];
            for (int intI = 0; intI < array_I.length; intI = intI + 1) {
                arrlongn[intI] = array_I[intI];
            }

            strToLog = Test.strFormatArrayOrCollection(arrlongn, array_I, text_I, Test.strObjIdGet(array_I),
                    logOption_I);
        }

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            long[] array_I
    ) {
        return (array_I == null) ? "null" : Test.strObjIdGet(array_I);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static String strObjIdGet(
            //                                              //str, arrlong«Size»:HashCode.

            long[] arrlong_I
    ) {
        Test.abortIfNull(arrlong_I, "arrlong_I");

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arrlong_I.hashCode();

        return "arrlong«" + arrlong_I.length + "»:" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog(
            double[] array_I,
            String text_I
    ) {
        return Test.toLog(array_I, text_I, LogArrOptionEnum.HORIZONTAL);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            double[] array_I,
            String text_I,
            LogArrOptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        String strToLog;
        if ( //
                array_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            //                                              //Wrap number array
            Double[] arrnumn = new Double[array_I.length];
            for (int intI = 0; intI < array_I.length; intI = intI + 1) {
                arrnumn[intI] = array_I[intI];
            }

            strToLog = Test.strFormatArrayOrCollection(arrnumn, array_I, text_I, Test.strObjIdGet(array_I),
                    logOption_I);
        }

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            double[] array_I
    ) {
        return (array_I == null) ? "null" : Test.strObjIdGet(array_I);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static String strObjIdGet(
            //                                              //str, arrnum«Size»:HashCode.

            double[] arrnum_I
    ) {
        Test.abortIfNull(arrnum_I, "arrnum_I");

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arrnum_I.hashCode();

        return "arrnum«" + arrnum_I.length + "»:" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog(
            char[] array_I,
            String text_I
    ) {
        return Test.toLog(array_I, text_I, LogArrOptionEnum.HORIZONTAL);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            char[] array_I,
            String text_I,
            LogArrOptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        String strToLog;
        if ( //
                array_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            //                                              //Wrap character array
            Character[] arrcharn = new Character[array_I.length];
            for (int intI = 0; intI < array_I.length; intI = intI + 1) {
                arrcharn[intI] = array_I[intI];
            }

            strToLog = Test.strFormatArrayOrCollection(arrcharn, array_I, text_I, Test.strObjIdGet(array_I),
                    logOption_I);
        }

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            char[] array_I
    ) {
        return (array_I == null) ? "null" : Test.strObjIdGet(array_I);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static String strObjIdGet(
            //                                              //str, arrchar«Size»:HashCode.

            char[] arrchar_I
    ) {
        Test.abortIfNull(arrchar_I, "arrchar_I");

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arrchar_I.hashCode();

        return "arrchar«" + arrchar_I.length + "»:" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog(
            boolean[] array_I,
            String text_I
    ) {
        return Test.toLog(array_I, text_I, LogArrOptionEnum.HORIZONTAL);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            boolean[] array_I,
            String text_I,
            LogArrOptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        String strToLog;
        if ( //
                array_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            //                                              //Wrap boolean array
            Boolean[] arrbooln = new Boolean[array_I.length];
            for (int intI = 0; intI < array_I.length; intI = intI + 1) {
                arrbooln[intI] = array_I[intI];
            }

            strToLog = Test.strFormatArrayOrCollection(arrbooln, array_I, text_I, Test.strObjIdGet(array_I),
                    logOption_I);
        }

        return strToLog;
    }

//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            boolean[] array_I
    ) {
        return (array_I == null) ? "null" : Test.strObjIdGet(array_I);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static String strObjIdGet(
            //                                              //str, arrbool«Size»:HashCode.

            boolean[] arrbool_I
    ) {
        Test.abortIfNull(arrbool_I, "arrbool_I");

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arrbool_I.hashCode();

        return "arrbool«" + arrbool_I.length + "»:" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <XT> String toLog(
            XT[] array_I,
            String text_I
    ) {
        LogArrOptionEnum logOption = ( //
                (array_I != null)
                //                                          //These type of array need to be VERTICAL
                && Test.boolShouldDisplayVertical(array_I.getClass().getComponentType()) //
                )
                        ? LogArrOptionEnum.VERTICAL : LogArrOptionEnum.HORIZONTAL;

        return Test.toLog(array_I, text_I, logOption);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XT> String toLog(
            XT[] array_I,
            String text_I,
            LogArrOptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        String strToLog;
        if ( //
                array_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            Class typeArray = array_I.getClass().getComponentType();
            Test.subAbortIfNonStandardArrayType(typeArray);

            LogArrOptionEnum logOption = logOption_I;
            if ( //
                    (logOption_I == LogArrOptionEnum.HORIZONTAL)
                    //                                          //These type of array need to display VERTICAL
                    && Test.boolShouldDisplayVertical(typeArray) //
                    ) {
                Test.warning(Test.toLog(typeArray, "typeArray")
                        + " will be displayed VERTICAL, to avoid this warning, "
                        + "please change HORIZONTAL log option in the toLog method call",
                        Test.toLog(logOption_I, "logOption_I"));

                logOption = LogArrOptionEnum.VERTICAL;
            }

            strToLog = Test.strFormatArrayOrCollection(array_I, array_I, text_I, Test.strObjIdGet(array_I), logOption);
        }

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XT> String toLog(
            XT[] array_I
    ) {
        String strToLog;
        if ( //
                array_I == null //
                ) {
            strToLog = "null";
        } //
        else {
            Class typeArray = array_I.getClass().getComponentType();
            Test.subAbortIfNonStandardArrayType(typeArray);

            strToLog = Test.strObjIdGet(array_I);
        }

        return strToLog;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static <XT> String strObjIdGet(
            //                                              //str, arrxxx«Size»:HashCode.

            XT[] arrxt_I
    ) {
        Test.abortIfNull(arrxt_I, "arrxt_I");

        Class typeArray = arrxt_I.getClass().getComponentType();
        Test.subAbortIfNonStandardArrayType(typeArray);

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arrxt_I.hashCode();

        return "arr" + Test.strPrefixSingleType(typeArray) + "«" + arrxt_I.length + "»:" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subAbortIfNonStandardArrayType(
            Class typeArray_L
    ) {
        if (!( //
                boolIsStandardSingle(typeArray_L) //
                )) {
            Test.abort("SOMETHING IS WRONG!!!, array of " + typeArray_L.getSimpleName() + " not implemented");
        }
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Test.DynamicArray(toLog)*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    public static <XT> String toLog(
            ArrayList<XT> dynamicArray_I,
            String text_I
    ) {
        XT xtFirstItemOrNull = Test.xtFirstItemOrNull(dynamicArray_I);
        LogArrOptionEnum logOption = ( //
                (xtFirstItemOrNull != null)
                //                                          //These type of array need to be VERTICAL
                && Test.boolShouldDisplayVertical(xtFirstItemOrNull.getClass()) //
                )
                        ? LogArrOptionEnum.VERTICAL : LogArrOptionEnum.HORIZONTAL;

        return Test.toLog(dynamicArray_I, text_I, logOption);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XT> String toLog(
            ArrayList<XT> dynamicArray_I,
            String text_I,
            LogArrOptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        XT xtFirstItemOrNull = Test.xtFirstItemOrNull(dynamicArray_I);
        Test.subAbortIfNonStandardCollectionItem(xtFirstItemOrNull);

        return Test.strToLogCollection(dynamicArray_I, xtFirstItemOrNull, text_I, logOption_I);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XT> String toLog(
            ArrayList<XT> dynamicArray_I
    ) {
        return Test.strToLogCollection(dynamicArray_I);
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Test.LinkedList(toLog)* /
    //                                                      //(Glg Sep 30, 2018) LA CLASE LinkedList QUE ESTA EN JAVA NO
    //                                                      //      SERÁ UTILIZADA, TENEMOS PENDIENTE DESARROLLAR UNA
    //                                                      //      CLASE LinkedList o LinkedListX CON FUNCIONALIDAD
    //                                                      //      SIMILAR A LA QUE TENEMOS EN C#.
    
    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Test.Stack(toLog)*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    public static <XT> String toLog(
            Stack<XT> stack_I,
            String text_I
    ) {
        XT xtFirstItemOrNull = Test.xtFirstItemOrNull(stack_I);
        LogArrOptionEnum logOption = ( //
                (xtFirstItemOrNull != null)
                //                                          //These type of array need to be VERTICAL
                && Test.boolShouldDisplayVertical(xtFirstItemOrNull.getClass()) //
                )
                        ? LogArrOptionEnum.VERTICAL : LogArrOptionEnum.HORIZONTAL;

        return Test.toLog(stack_I, text_I, logOption);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XT> String toLog(
            Stack<XT> stack_I,
            String text_I,
            LogArrOptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        XT xtFirstItemOrNull = Test.xtFirstItemOrNull(stack_I);
        Test.subAbortIfNonStandardCollectionItem(xtFirstItemOrNull);

        return Test.strToLogCollection(stack_I, xtFirstItemOrNull, text_I, logOption_I);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XT> String toLog(
            Stack<XT> stack_I
    ) {
        return Test.strToLogCollection(stack_I);
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Test.Queue(toLog)*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    public static <XT> String toLog(
            Queue<XT> queue_I,
            String text_I
    ) {
        XT xtFirstItemOrNull = Test.xtFirstItemOrNull(queue_I);
        LogArrOptionEnum logOption = ( //
                (xtFirstItemOrNull != null)
                //                                          //These type of array need to be VERTICAL
                && Test.boolShouldDisplayVertical(xtFirstItemOrNull.getClass()) //
                )
                        ? LogArrOptionEnum.VERTICAL : LogArrOptionEnum.HORIZONTAL;

        return Test.toLog(queue_I, text_I, logOption);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XT> String toLog(
            Queue<XT> queue_I,
            String text_I,
            LogArrOptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        XT xtFirstItemOrNull = Test.xtFirstItemOrNull(queue_I);
        Test.subAbortIfNonStandardCollectionItem(xtFirstItemOrNull);

        return Test.strToLogCollection(queue_I, xtFirstItemOrNull, text_I, logOption_I);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XT> String toLog(
            Queue<XT> queue_I
    ) {
        return Test.strToLogCollection(queue_I);
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Test.Collection(toLog)*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    private static <XT> String strToLogCollection(
            Collection<XT> collxt_I,
            XT xtFirstItemOrNull_I,
            String text_I,
            LogArrOptionEnum logOption_I
    ) {
        LogArrOptionEnum logOption = logOption_I;
        if ( //
                (logOption_I == LogArrOptionEnum.HORIZONTAL)
                //                                          //This type of coll need to be VERTICAL
                && (xtFirstItemOrNull_I != null) && Test.boolShouldDisplayVertical(xtFirstItemOrNull_I.getClass()) //
                ) {
            Test.warning(Test.toLog(collxt_I.getClass(), "collxt_I.Type")
                    + " will be displayed VERTICAL, to avoid this warning, please change option in the code",
                    Test.toLog(logOption_I, "logOption_I"));

            logOption = LogArrOptionEnum.VERTICAL;
        }

        Object[] arrobj = collxt_I.toArray();
        String strObjId = Test.strGetObjIdCollection(collxt_I);
        return Test.strFormatArrayOrCollection(arrobj, collxt_I, text_I, strObjId, logOption);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static <XT> String strToLogCollection(
            Collection<XT> collxt_I
    ) {
        return Test.<XT>strGetObjIdCollection(collxt_I);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static <XT> String strGetObjIdCollection(
            //                                              //str, collxxx«Size»:HashCode.

            Collection<XT> collxt_I
    ) {
        String strName = Std.name(collxt_I.getClass());
        String strPrefixColl = (strName.equals("DynamicArray")) ? "darr"
                //                                          //For Stack and Queue
                : strName.toLowerCase();

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + collxt_I.hashCode();

        return strPrefixColl + "???«" + collxt_I.size() + "»:" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static <XT> XT xtFirstItemOrNull(
            Collection<XT> collxt_I
    ) {
        XT xtFirstItemOrNull = null;
        if ( //
                collxt_I != null //
                ) {
            //                                              //Search for first item
            Iterator<XT> iteratorxt = collxt_I.iterator();
            /*WHILE-DO*/
            while ( //
                    iteratorxt.hasNext()
                    && xtFirstItemOrNull == null //
                    ) {
                xtFirstItemOrNull = iteratorxt.next();
            }
        }

        return xtFirstItemOrNull;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static void subAbortIfNonStandardCollectionItem(
            //                                              //null if collection has no items or has only null items
            Object objFirstItemOrNull_L
    ) {
        if ( //
                objFirstItemOrNull_L != null //
                ) {
            //                                              //Should a valid type
            Class typeObjFirstItem = objFirstItemOrNull_L.getClass();
            if (!( //
                    boolIsStandardWrapper(typeObjFirstItem)
                    || boolIsStandardSingle(typeObjFirstItem) //
                    )) {
                Test.abort("SOMETHING IS WRONG!!!, collection of " + typeObjFirstItem.getSimpleName()
                        + " not implemented");
            }
        }
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Test.Dictionary(toLog)*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/
    //
    //                                                  //This will be the maximun space reseved for key when strTo
    //                                                  //      display a dictionary, if we have longhest key the
    //                                                  //      content will not be aligned.
    private static final int intKEY_LEN_MAX = 50;

    //------------------------------------------------------------------------------------------------------------------
    public static <XT> String toLog(
            LinkedHashMap<String, XT> dictionary_I,
            String text_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        String ToLog;
        /*CASE*/
        if ( //
                dictionary_I == null //
                ) {
            ToLog = text_I + "(null)";
        } //
        else if ( //
                Test.darrobjPreviouslyProcessed.contains(dictionary_I) //
                ) {
            ToLog = text_I + "(" + Test.strObjIdGet(dictionary_I) + strMessageLogBefore + ")";
        } //
        else {
            //                                      //Register dic as processed
            Test.darrobjPreviouslyProcessed.add(dictionary_I);

            ToLog = Test.strFormatDictionary(dictionary_I, text_I);
        }
        /*END-CASE*/

        return ToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XT> String toLog(
            LinkedHashMap<String, XT> dictionary_I
    ) {
        return (dictionary_I == null) ? "null" : Test.strObjIdGet(dictionary_I);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static <XT> String strFormatDictionary(
            //                                              //str, dictionary info.

            LinkedHashMap<String, XT> dicxt_I,
            String text_I
    ) {
        //                                              //Separate keys and value and sort by key
        String[] arrstrKey = dicxt_I.keySet().toArray(new String[dicxt_I.size()]);
        Object[] arrtValue = dicxt_I.values().toArray(new Object[dicxt_I.size()]);
        Std.sort(arrstrKey, arrtValue);

        //                                              //Compute [key] size.
        int intLongestKey = 0;
        for (String str : arrstrKey) {
            intLongestKey = Std.maxOf(intLongestKey, str.length());
        }
        intLongestKey = intLongestKey + "[]".length();
        intLongestKey = Std.minOf(Test.intKEY_LEN_MAX, intLongestKey);

        O<String> ostrFormatDictionary = new O<>();
        O<String> ostrNL = new O<>();
        O<String> ostrLabel = new O<>();
        Test.subOpenBlock(ostrNL, ostrLabel, ostrFormatDictionary, text_I, Test.strObjIdGet(dicxt_I));

        //                                              //Produces lines to include in block.
        String[] arrstrEntry = new String[arrtValue.length];
        for (int intI = 0; intI < arrtValue.length; intI = intI + 1) {
            arrstrEntry[intI] = Std.padRight("[" + Test.strFormatKey(arrstrKey[intI]) + "]", intLongestKey) + " "
                    + Test.<XT>strToLogXT(arrtValue[intI]);
        }

        ostrFormatDictionary.v = ostrFormatDictionary.v + "{" + ostrNL.v + String.join(ostrNL.v, arrstrEntry)
                + ostrNL.v + "}";

        Test.subCloseBlock(ostrNL, ostrFormatDictionary, ostrLabel.v);

        return ostrFormatDictionary.v;
    }

    //--------------------------------------------------------------------------------------------------------------
    private static <XT> String strObjIdGet(
            //                                              //str, dic???«Size»:HashCode.

            LinkedHashMap<String, XT> dicxt_I
    ) {

        Test.abortIfNull(dicxt_I, "dicxt_I");

        String strPrefixItem = (Test.boolIsComparableLog_Z) ? Test.strMASK : "???";

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + dicxt_I.hashCode();

        return "dic" + strPrefixItem + "«" + dicxt_I.size() + "»:" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <XT> String toLog(
            Map.Entry<String, XT> keyValuePair_I,
            String text_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        //                                              //Confirm key has only visible chars
        String strKeyAnalized = Test.toLog(keyValuePair_I.getKey());
        String strKey = (strKeyAnalized.endsWith("\"")) ? strKeyAnalized.substring(1, strKeyAnalized.length() - 1)
                : strKeyAnalized;

        return text_I + "(<Key(" + strKey + "), " + Test.strToLogXT(keyValuePair_I.getValue()) + ">)";
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XT> String toLog(
            Map.Entry<String, XT> keyValuePair_I
    ) {
        return "<" + Test.strFormatKey(keyValuePair_I.getKey()) + ", " + Test.strToLogXT(keyValuePair_I.getValue())
                + ">";
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static String strFormatKey(
            //                                              //str, key to display. 
            String strKey_I
    ) {
        String strKeyAnalized = Test.toLog(strKey_I);

        String strFormatKey;
        /*CASE*/
        if ( //
                //                                          //Has just string info ("string information")
                strKeyAnalized.endsWith("\"") //
                ) {
            //                                              //Take key from "key"
            strFormatKey = strKeyAnalized.substring(1, strKeyAnalized.length() - 1);
        } //
        else if ( //                                        //Has lenght info and no diagnotic info ("string info"<nn>)
                strKeyAnalized.endsWith(">") //
                ) {
            int intMinorThanMark = strKeyAnalized.lastIndexOf("<");

            //                                              //Take key from "key"<nn>
            strFormatKey = strKeyAnalized.substring(1, intMinorThanMark - 1);
        } //
        else {
            //                                              //Include disgnostic info (or is null).
            strFormatKey = strKeyAnalized;
        }
        /*END-CASE*/

        return strFormatKey;
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Test.Matrix(toLog)*/
    //==================================================================================================================
    //
    public static String toLog(
            int[][] matrix_I,
            String text_I
    ) {
        LogArr2OptionEnum logOption = ( //
                //                                          //These type of array need to be VERTICAL
                Test.boolShouldDisplayVertical(matrix_I.getClass().getComponentType()))
                ? LogArr2OptionEnum.VERTICAL
                : LogArr2OptionEnum.MATRIX;

        return Test.toLog(matrix_I, text_I, logOption);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            int[][] matrix_I,
            String text_I,
            LogArr2OptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        LogArr2OptionEnum logOption = logOption_I;
        if ( //
                (logOption_I == LogArr2OptionEnum.HORIZONTAL)
                && //                                      //These types of collection need to be displayed VERTICALY
                Test.boolShouldDisplayVertical(matrix_I.getClass().getComponentType()) //
                ) {
            Test.warning(Test.toLog(matrix_I.getClass(), "arr2xt_I.Type")
                    + " will be displayed VERTICAL, to avoid this warning, please change option in the code",
                    Test.toLog(logOption_I, "logOption_I"));

            logOption = LogArr2OptionEnum.VERTICAL;
        }

        String strToLog;
        if ( //
                matrix_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            //                                              //Wrap integer array
            Integer[][] arr2intn = new Integer[matrix_I.length][matrix_I[0].length];
            for (int intI = 0; intI < matrix_I.length; intI = intI + 1) {
                for (int intJ = 0; intJ < matrix_I[0].length; intJ = intJ + 1) {
                    arr2intn[intI][intJ] = matrix_I[intI][intJ];
                }
            }

            strToLog = ( //
                    matrix_I == null //
                    )
                            ? "null" : Test.strToLogMatrix(arr2intn, text_I, logOption, strObjIdGet(matrix_I));
        }

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            int[][] matrix_I
    ) {
        return (matrix_I == null) ? "null" : Test.strObjIdGet(matrix_I);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static String strObjIdGet(
            //                                              //str, arrint«Size»:HashCode.

            int[][] arr2int_I
    ) {
        Test.abortIfNull(arr2int_I, "arr2xt_I");

        String strSize0 = "" + arr2int_I.length;
        String strSize1 = (strSize0.equals("0")) ? "0" : "" + arr2int_I[0].length;

        String strPrefixItem = Test.strPrefixSingleType(arr2int_I.getClass().getComponentType());

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arr2int_I.hashCode();

        return "arr2" + strPrefixItem + "«" + strSize0 + "," + strSize1 + "»:" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog(
            long[][] matrix_I,
            String text_I
    ) {
        LogArr2OptionEnum logOption = ( //
                //                                          //These type of array need to be VERTICAL
                Test.boolShouldDisplayVertical(matrix_I.getClass().getComponentType()))
                ? LogArr2OptionEnum.VERTICAL
                : LogArr2OptionEnum.MATRIX;

        return Test.toLog(matrix_I, text_I, logOption);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            long[][] matrix_I,
            String text_I,
            LogArr2OptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        LogArr2OptionEnum logOption = logOption_I;
        if ( //
                (logOption_I == LogArr2OptionEnum.HORIZONTAL)
                && //                                      //These types of collection need to be displayed VERTICALY
                Test.boolShouldDisplayVertical(matrix_I.getClass().getComponentType()) //
                ) {
            Test.warning(Test.toLog(matrix_I.getClass(), "arr2xt_I.Type")
                    + " will be displayed VERTICAL, to avoid this warning, please change option in the code",
                    Test.toLog(logOption_I, "logOption_I"));

            logOption = LogArr2OptionEnum.VERTICAL;
        }

        String strToLog;
        if ( //
                matrix_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            //                                              //Wrap integer array
            Long[][] arr2longn = new Long[matrix_I.length][matrix_I[0].length];
            for (int intI = 0; intI < matrix_I.length; intI = intI + 1) {
                for (int intJ = 0; intJ < matrix_I[0].length; intJ = intJ + 1) {
                    arr2longn[intI][intJ] = matrix_I[intI][intJ];
                }
            }

            strToLog = (matrix_I == null) ? "null"
                    : Test.strToLogMatrix(arr2longn, text_I, logOption, strObjIdGet(matrix_I));
        }

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            long[][] matrix_I
    ) {
        return (matrix_I == null) ? "null" : Test.strObjIdGet(matrix_I);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static String strObjIdGet(
            //                                              //str, arrint«Size»:HashCode.

            long[][] arr2long_I
    ) {
        Test.abortIfNull(arr2long_I, "arr2xt_I");

        String strSize0 = "" + arr2long_I.length;
        String strSize1 = (strSize0.equals("0")) ? "0" : "" + arr2long_I[0].length;

        String strPrefixItem = Test.strPrefixSingleType(arr2long_I.getClass().getComponentType());

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arr2long_I.hashCode();

        return "arr2" + strPrefixItem + "«" + strSize0 + "," + strSize1 + "»:" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog(
            double[][] matrix_I,
            String text_I
    ) {
        LogArr2OptionEnum logOption = ( //
                //                                          //These type of array need to be VERTICAL
                Test.boolShouldDisplayVertical(matrix_I.getClass().getComponentType()))
                ? LogArr2OptionEnum.VERTICAL
                : LogArr2OptionEnum.MATRIX;

        return Test.toLog(matrix_I, text_I, logOption);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            double[][] matrix_I,
            String text_I,
            LogArr2OptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        LogArr2OptionEnum logOption = logOption_I;
        if ( //
                (logOption_I == LogArr2OptionEnum.HORIZONTAL)
                && //                                      //These types of collection need to be displayed VERTICALY
                Test.boolShouldDisplayVertical(matrix_I.getClass().getComponentType()) //
                ) {
            Test.warning(Test.toLog(matrix_I.getClass(), "arr2xt_I.Type")
                    + " will be displayed VERTICAL, to avoid this warning, please change option in the code",
                    Test.toLog(logOption_I, "logOption_I"));

            logOption = LogArr2OptionEnum.VERTICAL;
        }

        String strToLog;
        if ( //
                matrix_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            //                                              //Wrap integer array
            Double[][] arr2numn = new Double[matrix_I.length][matrix_I[0].length];
            for (int intI = 0; intI < matrix_I.length; intI = intI + 1) {
                for (int intJ = 0; intJ < matrix_I[0].length; intJ = intJ + 1) {
                    arr2numn[intI][intJ] = matrix_I[intI][intJ];
                }
            }

            strToLog = (matrix_I == null) ? "null"
                    : Test.strToLogMatrix(arr2numn, text_I, logOption, strObjIdGet(matrix_I));
        }

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            double[][] matrix_I
    ) {
        return (matrix_I == null) ? "null" : Test.strObjIdGet(matrix_I);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static String strObjIdGet(
            //                                              //str, arrint«Size»:HashCode.

            double[][] arr2num_I
    ) {
        Test.abortIfNull(arr2num_I, "arr2xt_I");

        String strSize0 = "" + arr2num_I.length;
        String strSize1 = (strSize0.equals("0")) ? "0" : "" + arr2num_I[0].length;

        String strPrefixItem = Test.strPrefixSingleType(arr2num_I.getClass().getComponentType());

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arr2num_I.hashCode();

        return "arr2" + strPrefixItem + "«" + strSize0 + "," + strSize1 + "»:" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog(
            char[][] matrix_I,
            String text_I
    ) {
        LogArr2OptionEnum logOption = ( //
                //                                          //These type of array need to be VERTICAL
                Test.boolShouldDisplayVertical(matrix_I.getClass().getComponentType()) //
                )
                        ? LogArr2OptionEnum.VERTICAL
                        : LogArr2OptionEnum.MATRIX;

        return Test.toLog(matrix_I, text_I, logOption);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            char[][] matrix_I,
            String text_I,
            LogArr2OptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        LogArr2OptionEnum logOption = logOption_I;
        if ( //
                (logOption_I == LogArr2OptionEnum.HORIZONTAL)
                && //                                      //These types of collection need to be displayed VERTICALY
                Test.boolShouldDisplayVertical(matrix_I.getClass().getComponentType()) //
                ) {
            Test.warning(Test.toLog(matrix_I.getClass(), "arr2xt_I.Type")
                    + " will be displayed VERTICAL, to avoid this warning, please change option in the code",
                    Test.toLog(logOption_I, "logOption_I"));

            logOption = LogArr2OptionEnum.VERTICAL;
        }

        String strToLog;
        if ( //
                matrix_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            //                                              //Wrap integer array
            Character[][] arr2charn = new Character[matrix_I.length][matrix_I[0].length];
            for (int intI = 0; intI < matrix_I.length; intI = intI + 1) {
                for (int intJ = 0; intJ < matrix_I[0].length; intJ = intJ + 1) {
                    arr2charn[intI][intJ] = matrix_I[intI][intJ];
                }
            }

            strToLog = (matrix_I == null) ? "null"
                    : Test.strToLogMatrix(arr2charn, text_I, logOption, strObjIdGet(matrix_I));
        }

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            char[][] matrix_I
    ) {
        return (matrix_I == null) ? "null" : Test.strObjIdGet(matrix_I);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static String strObjIdGet(
            //                                              //str, arrint«Size»:HashCode.

            char[][] arr2char_I
    ) {
        Test.abortIfNull(arr2char_I, "arr2xt_I");

        String strSize0 = "" + arr2char_I.length;
        String strSize1 = (strSize0.equals("0")) ? "0" : "" + arr2char_I[0].length;

        String strPrefixItem = Test.strPrefixSingleType(arr2char_I.getClass().getComponentType());

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arr2char_I.hashCode();

        return "arr2" + strPrefixItem + "«" + strSize0 + "," + strSize1 + "»:" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog(
            boolean[][] matrix_I,
            String text_I
    ) {
        LogArr2OptionEnum logOption = ( //
                //                                          //These type of array need to be VERTICAL
                Test.boolShouldDisplayVertical(matrix_I.getClass().getComponentType()) //
                )
                        ? LogArr2OptionEnum.VERTICAL
                        : LogArr2OptionEnum.MATRIX;

        return Test.toLog(matrix_I, text_I, logOption);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            boolean[][] matrix_I,
            String text_I,
            LogArr2OptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        LogArr2OptionEnum logOption = logOption_I;
        if ( //
                (logOption_I == LogArr2OptionEnum.HORIZONTAL)
                && //                                      //These types of collection need to be displayed VERTICALY
                Test.boolShouldDisplayVertical(matrix_I.getClass().getComponentType()) //
                ) {
            Test.warning(Test.toLog(matrix_I.getClass(), "arr2xt_I.Type")
                    + " will be displayed VERTICAL, to avoid this warning, please change option in the code",
                    Test.toLog(logOption_I, "logOption_I"));

            logOption = LogArr2OptionEnum.VERTICAL;
        }

        String strToLog;
        if ( //
                matrix_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            //                                              //Wrap integer array
            Boolean[][] arr2booln = new Boolean[matrix_I.length][matrix_I[0].length];
            for (int intI = 0; intI < matrix_I.length; intI = intI + 1) {
                for (int intJ = 0; intJ < matrix_I[0].length; intJ = intJ + 1) {
                    arr2booln[intI][intJ] = matrix_I[intI][intJ];
                }
            }

            strToLog = (matrix_I == null)
                    ? "null" : Test.strToLogMatrix(arr2booln, text_I, logOption, strObjIdGet(matrix_I));
        }

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            boolean[][] matrix_I
    ) {
        return (matrix_I == null) ? "null" : Test.strObjIdGet(matrix_I);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static String strObjIdGet(
            //                                              //str, arrint«Size»:HashCode.

            boolean[][] arr2bool_I
    ) {
        Test.abortIfNull(arr2bool_I, "arr2xt_I");

        String strSize0 = "" + arr2bool_I.length;
        String strSize1 = (strSize0.equals("0")) ? "0" : "" + arr2bool_I[0].length;

        String strPrefixItem = Test.strPrefixSingleType(arr2bool_I.getClass().getComponentType());

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arr2bool_I.hashCode();

        return "arr2" + strPrefixItem + "«" + strSize0 + "," + strSize1 + "»:" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <XT> String toLog(
            XT[][] matrix_I,
            String text_I
    ) {
        LogArr2OptionEnum logOption = ( //
                //                                          //These type of array need to be VERTICAL
                Test.boolShouldDisplayVertical(matrix_I.getClass().getComponentType()))
                ? LogArr2OptionEnum.VERTICAL
                : LogArr2OptionEnum.MATRIX;

        return Test.toLog(matrix_I, text_I, logOption);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XT> String toLog(
            XT[][] matrix_I,
            String text_I,
            LogArr2OptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        LogArr2OptionEnum logOption = logOption_I;
        if ( //
                (logOption_I == LogArr2OptionEnum.HORIZONTAL)
                && //                                      //These types of collection need to be displayed VERTICALY
                Test.boolShouldDisplayVertical(matrix_I.getClass().getComponentType()) //
                ) {
            Test.warning(Test.toLog(matrix_I.getClass(), "arr2xt_I.Type")
                    + " will be displayed VERTICAL, to avoid this warning, please change option in the code",
                    Test.toLog(logOption_I, "logOption_I"));

            logOption = LogArr2OptionEnum.VERTICAL;
        }

        String strArr2t = (matrix_I == null) ? "null"
                : Test.strToLogMatrix(matrix_I, text_I, logOption, Test.strObjIdGet(matrix_I));

        return strArr2t;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XT> String toLog(
            XT[][] matrix_I_I
    ) {
        return (matrix_I_I == null) ? "null" : Test.strObjIdGet(matrix_I_I);
    }

    //--------------------------------------------------------------------------------------------------------------
    private static <XT> String strObjIdGet(
            //                                              //str, arr2xxx«Size0, Size1»:HashCode.

            XT[][] arr2xt_I
    ) {
        Test.abortIfNull(arr2xt_I, "arr2xt_I");

        String strSize0 = "" + arr2xt_I.length;
        String strSize1 = (strSize0.equals("0")) ? "0" : "" + arr2xt_I[0].length;

        XT xtFirstItemOrNull = Test.xtFirstItemOrNull(arr2xt_I);
        Test.subAbortIfNonStandardCollectionItem(xtFirstItemOrNull);

        String strPrefixItem = (xtFirstItemOrNull == null) ? "???"
                : Test.strPrefixSingleType(xtFirstItemOrNull.getClass());

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arr2xt_I.hashCode();

        return "arr2" + strPrefixItem + "«" + strSize0 + "," + strSize1 + "»:" + strHashCode;
    }

    //--------------------------------------------------------------------------------------------------------------
    private static <XT> XT xtFirstItemOrNull(
            XT[][] arr2xt_I
    ) {
        XT xtFirstItemOrNull = null;
        if ( //
                arr2xt_I != null //
                ) {
            //                                              //Search for first item
            /*WHILE-DO*/
            int intI = 0;
            while ( //
                    intI < arr2xt_I.length
                    && xtFirstItemOrNull == null //
                    ) {
                int intJ = 0;
                while ( //
                        intJ < arr2xt_I[intI].length
                        && xtFirstItemOrNull == null //
                        ) {
                    xtFirstItemOrNull = arr2xt_I[intI][intJ];

                    intJ = intJ + 1;
                }

                intI = intI + 1;
            }
        }

        return xtFirstItemOrNull;
    }

    //--------------------------------------------------------------------------------------------------------------
    private static <XT> String strToLogMatrix(
            //                                              //str, arr2xxx«Size0, Size1»:HashCode.

            XT[][] arr2xt_I,
            String text_I,
            LogArr2OptionEnum logOption_I,
            String strObjId_I
    ) {
        String strFormatMatrix;
        if ( //
                Test.darrobjPreviouslyProcessed.contains(arr2xt_I) //
                ) {
            strFormatMatrix = text_I + "(" + strObjId_I + strMessageLogBefore + ")";
        } //
        else {
            //                                          //Register matrix as processed
            Test.darrobjPreviouslyProcessed.add(arr2xt_I);

            /*CASE*/
            if ( //
                    logOption_I == LogArr2OptionEnum.VERTICAL //
                    ) {
                O<String> ostrNL = new O<>();
                O<String> ostrLabel = new O<>();
                O<String> ostrFormatMatrix = new O<>();
                Test.subOpenBlock(ostrNL, ostrLabel, ostrFormatMatrix, text_I, strObjId_I);

                ostrFormatMatrix.v = ostrFormatMatrix.v + Test.strRowMatrix(arr2xt_I, ostrNL.v);

                Test.subCloseBlock(ostrNL, ostrFormatMatrix, ostrLabel.v);
                strFormatMatrix = ostrFormatMatrix.v;
            } //
            else if ( //
                    logOption_I == LogArr2OptionEnum.MATRIX //
                    ) {
                O<String> ostrNL = new O<>();
                O<String> ostrLabel = new O<>();
                O<String> ostrFormatMatrix = new O<>();
                Test.subOpenBlock(ostrNL, ostrLabel, ostrFormatMatrix, text_I, strObjId_I);

                ostrFormatMatrix.v = ostrFormatMatrix.v + Test.strRowLineMatrix(arr2xt_I, ostrNL.v);

                Test.subCloseBlock(ostrNL, ostrFormatMatrix, ostrLabel.v);
                strFormatMatrix = ostrFormatMatrix.v;
            } //
            else {
                strFormatMatrix = text_I + "(" + strObjId_I + Test.strLineMatrix(arr2xt_I) + ")";
            }
            /*END-CASE*/
        }

        return strFormatMatrix;
    }

    //--------------------------------------------------------------------------------------------------------------
    private static <XT> String strRowMatrix(
            //                                              //Format an array to a Set of Lines(Items) inside a block.
            //                                              //Example:
            //                                              //[
            //                                              //{
            //                                              //[0] item
            //                                              //...
            //                                              //[x] item
            //                                              //}
            //                                              //]

            //                                              //str, set in block format

            XT[][] arr2xt_I,
            String strNL_I
    ) {
        int intCharsInLongestIndex = ("[" + (arr2xt_I.length - 1) + "," + (arr2xt_I[0].length - 1) + "]").length();

        String strFormatMatrix = "{";

        for (int intI = 0; intI < arr2xt_I.length; intI = intI + 1) {
            String[] arrstrIndexAndItem = new String[arr2xt_I[intI].length];
            for (int intJ = 0; intJ < arr2xt_I[intI].length; intJ = intJ + 1) {
                //                                          //Format: NL [i,j]_ item
                arrstrIndexAndItem[intJ] = strNL_I + Std.padRight("[" + intI + "," + intJ + "]", intCharsInLongestIndex)
                        + " " + Test.strToLogXT(arr2xt_I[intI][intJ]);
            }

            strFormatMatrix = strFormatMatrix + strNL_I + "{" + String.join("", arrstrIndexAndItem) + strNL_I + "}";
        }

        strFormatMatrix = strFormatMatrix + "}";

        return strFormatMatrix;
    }

    //--------------------------------------------------------------------------------------------------------------
    private static <XT> String strRowLineMatrix(
            //                                              //Format a matrix to a Set of Arrays(Lines) inside a block.
            //                                              //Example:
            //                                              //[
            //                                              //{
            //                                              //[0] { item, ..., item }
            //                                              //...
            //                                              //[x] { item, ..., item }
            //                                              //}
            //                                              //]

            XT[][] arr2xt_I,
            String strNL_I
    ) {
        //                                              //Chars required for longest index: "[x]"
        int intCharsInLongestIndex = ("Row<" + (arr2xt_I.length - 1) + ">").length();

        String[] arrstrIndexAndItem = new String[arr2xt_I.length];
        for (int intI = 0; intI < arr2xt_I.length; intI = intI + 1) {
            //                                          //Format: NL [i]_ array
            arrstrIndexAndItem[intI] = strNL_I + Std.padRight("Row<" + intI + ">", intCharsInLongestIndex) + " "
                    + Test.strLineRow(arr2xt_I[intI]);
        }

        return strNL_I + "{" + String.join("", arrstrIndexAndItem) + strNL_I + "}";
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static <XT> String strLineMatrix(
            //                                              //Produces:
            //                                              //{ { item, ..., item }, ..., { item, ..., item } }.
            //                                              //str, matrix in one line format.

            XT[][] arr2xt_I
    ) {
        //                                              //Convert arrobj to arrstr
        String strMatrix = "";
        for (int intI = 0; intI < arr2xt_I.length; intI = intI + 1) {
            strMatrix = strMatrix + Test.strLineRow(arr2xt_I[intI]) + ", ";
        }

        //                                              //Format: { item, item, ..., item }
        return "{ " + strMatrix.substring(0, strMatrix.length() - 2) + " }";
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Test.3DArray(toLog)*/
    //==================================================================================================================
    //
    public static String toLog(
            int[][][] _3DArray_I,
            String text_I
    ) {
        return Test.toLog(_3DArray_I, text_I, LogArr3OptionEnum.MATRIX);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            int[][][] _3DArray_I,
            String text_I,
            LogArr3OptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        String strToLog;
        if ( //
                _3DArray_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            //                                              //Wrap integer array
            Integer[][][] arr3int = new Integer[_3DArray_I.length][_3DArray_I[0].length][_3DArray_I[0][0].length];
            for (int intI = 0; intI < _3DArray_I.length; intI = intI + 1) {
                for (int intJ = 0; intJ < _3DArray_I[0].length; intJ = intJ + 1) {
                    for (int intK = 0; intK < _3DArray_I[0][0].length; intK = intK + 1) {
                        arr3int[intI][intJ][intK] = _3DArray_I[intI][intJ][intK];
                    }
                }
            }

            strToLog = Test.strToLog3DArray(arr3int, text_I, logOption_I, Test.strObjIdGet(_3DArray_I));
        }

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            int[][][] _3DArray_I
    ) {
        return (_3DArray_I == null) ? "null" : Test.strObjIdGet(_3DArray_I);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static String strObjIdGet(
            int[][][] arr3int_I
    ) {
        Test.abortIfNull(arr3int_I, "arr3int_I");

        String strSize0 = "" + arr3int_I.length;
        String strSize1 = (strSize0.equals("0")) ? "0" : "" + arr3int_I[0].length;
        String strSize2 = (strSize1.equals("0")) ? "0" : "" + arr3int_I[0][0].length;
        String strPrefixItem = Test.strPrefixSingleType(int.class);

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arr3int_I.hashCode();

        return "arr3" + strPrefixItem + "«" + strSize0 + ", " + strSize1 + ", " + strSize2 + "»:" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String toLog(
            long[][][] _3DArray_I,
            String text_I
    ) {
        return Test.toLog(_3DArray_I, text_I, LogArr3OptionEnum.MATRIX);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            long[][][] _3DArray_I,
            String text_I,
            LogArr3OptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        String strToLog;
        if ( //
                _3DArray_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            //                                              //Wrap integer array
            Long[][][] arr3long = new Long[_3DArray_I.length][_3DArray_I[0].length][_3DArray_I[0][0].length];
            for (int intI = 0; intI < _3DArray_I.length; intI = intI + 1) {
                for (int intJ = 0; intJ < _3DArray_I[0].length; intJ = intJ + 1) {
                    for (int intK = 0; intK < _3DArray_I[0][0].length; intK = intK + 1) {
                        arr3long[intI][intJ][intK] = _3DArray_I[intI][intJ][intK];
                    }
                }
            }

            strToLog = Test.strToLog3DArray(arr3long, text_I, logOption_I, Test.strObjIdGet(_3DArray_I));
        }

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            long[][][] _3DArray_I
    ) {
        return (_3DArray_I == null) ? "null" : Test.strObjIdGet(_3DArray_I);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static String strObjIdGet(
            long[][][] arr3long_I
    ) {
        Test.abortIfNull(arr3long_I, "arr3int_I");

        String strSize0 = "" + arr3long_I.length;
        String strSize1 = (strSize0.equals("0")) ? "0" : "" + arr3long_I[0].length;
        String strSize2 = (strSize1.equals("0")) ? "0" : "" + arr3long_I[0][0].length;

        String strPrefixItem = Test.strPrefixSingleType(long.class);

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arr3long_I.hashCode();

        return "arr3" + strPrefixItem + "«" + strSize0 + ", " + strSize1 + ", " + strSize2 + "»:" + strHashCode;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            double[][][] _3DArray_I,
            String text_I
    ) {
        return Test.toLog(_3DArray_I, text_I, LogArr3OptionEnum.MATRIX);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            double[][][] _3DArray_I,
            String text_I,
            LogArr3OptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        String strToLog;
        if ( //
                _3DArray_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            //                                              //Wrap integer array
            Double[][][] arr3num = new Double[_3DArray_I.length][_3DArray_I[0].length][_3DArray_I[0][0].length];
            for (int intI = 0; intI < _3DArray_I.length; intI = intI + 1) {
                for (int intJ = 0; intJ < _3DArray_I[0].length; intJ = intJ + 1) {
                    for (int intK = 0; intK < _3DArray_I[0][0].length; intK = intK + 1) {
                        arr3num[intI][intJ][intK] = _3DArray_I[intI][intJ][intK];
                    }
                }
            }

            strToLog = Test.strToLog3DArray(arr3num, text_I, logOption_I, Test.strObjIdGet(_3DArray_I));
        }

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            double[][][] _3DArray_I
    ) {
        return (_3DArray_I == null) ? "null" : Test.strObjIdGet(_3DArray_I);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static String strObjIdGet(
            double[][][] arr3num_I
    ) {
        Test.abortIfNull(arr3num_I, "arr3int_I");

        String strSize0 = "" + arr3num_I.length;
        String strSize1 = (strSize0.equals("0")) ? "0" : "" + arr3num_I[0].length;
        String strSize2 = (strSize1.equals("0")) ? "0" : "" + arr3num_I[0][0].length;

        String strPrefixItem = Test.strPrefixSingleType(double.class);

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arr3num_I.hashCode();

        return "arr3" + strPrefixItem + "«" + strSize0 + ", " + strSize1 + ", " + strSize2 + "»:" + strHashCode;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            char[][][] _3DArray_I,
            String text_I
    ) {
        return Test.toLog(_3DArray_I, text_I, LogArr3OptionEnum.MATRIX);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            char[][][] _3DArray_I,
            String text_I,
            LogArr3OptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        String strToLog;
        if ( //
                _3DArray_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            //                                              //Wrap integer array
            Character[][][] arr3char = new Character[_3DArray_I.length][_3DArray_I[0].length][_3DArray_I[0][0].length];
            for (int intI = 0; intI < _3DArray_I.length; intI = intI + 1) {
                for (int intJ = 0; intJ < _3DArray_I[0].length; intJ = intJ + 1) {
                    for (int intK = 0; intK < _3DArray_I[0][0].length; intK = intK + 1) {
                        arr3char[intI][intJ][intK] = _3DArray_I[intI][intJ][intK];
                    }
                }
            }

            strToLog = Test.strToLog3DArray(arr3char, text_I, logOption_I, Test.strObjIdGet(_3DArray_I));
        }

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            char[][][] _3DArray_I
    ) {
        return (_3DArray_I == null) ? "null" : Test.strObjIdGet(_3DArray_I);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static String strObjIdGet(
            char[][][] arr3char_I
    ) {
        Test.abortIfNull(arr3char_I, "arr3int_I");

        String strSize0 = "" + arr3char_I.length;
        String strSize1 = (strSize0.equals("0")) ? "0" : "" + arr3char_I[0].length;
        String strSize2 = (strSize1.equals("0")) ? "0" : "" + arr3char_I[0][0].length;

        String strPrefixItem = Test.strPrefixSingleType(char.class);

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arr3char_I.hashCode();

        return "arr3" + strPrefixItem + "«" + strSize0 + ", " + strSize1 + ", " + strSize2 + "»:" + strHashCode;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            boolean[][][] _3DArray_I,
            String text_I
    ) {
        return Test.toLog(_3DArray_I, text_I, LogArr3OptionEnum.MATRIX);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            boolean[][][] _3DArray_I,
            String text_I,
            LogArr3OptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        String strToLog;
        if ( //
                _3DArray_I == null //
                ) {
            strToLog = text_I + "(null)";
        } //
        else {
            //                                              //Wrap integer array
            Boolean[][][] arr3bool = new Boolean[_3DArray_I.length][_3DArray_I[0].length][_3DArray_I[0][0].length];
            for (int intI = 0; intI < _3DArray_I.length; intI = intI + 1) {
                for (int intJ = 0; intJ < _3DArray_I[0].length; intJ = intJ + 1) {
                    for (int intK = 0; intK < _3DArray_I[0][0].length; intK = intK + 1) {
                        arr3bool[intI][intJ][intK] = _3DArray_I[intI][intJ][intK];
                    }
                }
            }

            strToLog = Test.strToLog3DArray(arr3bool, text_I, logOption_I, Test.strObjIdGet(_3DArray_I));
        }

        return strToLog;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static String toLog(
            boolean[][][] _3DArray_I
    ) {
        return (_3DArray_I == null) ? "null" : Test.strObjIdGet(_3DArray_I);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static String strObjIdGet(
            boolean[][][] arr3bool_I
    ) {
        Test.abortIfNull(arr3bool_I, "arr3int_I");

        String strSize0 = "" + arr3bool_I.length;
        String strSize1 = (strSize0.equals("0")) ? "0" : "" + arr3bool_I[0].length;
        String strSize2 = (strSize1.equals("0")) ? "0" : "" + arr3bool_I[0][0].length;

        String strPrefixItem = Test.strPrefixSingleType(boolean.class);

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arr3bool_I.hashCode();

        return "arr3" + strPrefixItem + "«" + strSize0 + ", " + strSize1 + ", " + strSize2 + "»:" + strHashCode;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <XT> String toLog(
            XT[][][] _3DArray_I,
            String text_I
    ) {
        LogArr3OptionEnum logOption = ( //
                //                                          //These types of array need to be VERTICAL
                Test.boolShouldDisplayVertical(Test.xtFirstItemOrNull(_3DArray_I).getClass()) //
                )
                        ? LogArr3OptionEnum.VERTICAL : LogArr3OptionEnum.ARRAY;

        return Test.toLog(_3DArray_I, text_I, logOption);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XT> String toLog(
            XT[][][] _3DArray_I,
            String text_I,
            LogArr3OptionEnum logOption_I
    ) {
        Test.abortIfNullOrEmpty(text_I, "text_I");

        LogArr3OptionEnum logOption = logOption_I;
        if (!(logOption_I == LogArr3OptionEnum.VERTICAL)
                && //                                          //These types of collection need to be displayed VERTICAL
                Test.boolShouldDisplayVertical(Test.xtFirstItemOrNull(_3DArray_I).getClass())) {
            Test.warning(Test.toLog(_3DArray_I.getClass(), "arr3xt_I.Type")
                    + " will be displayed VERTICAL, to avoid this warning, please change option in the code",
                    Test.toLog(logOption_I, "logOption_I"));

            logOption = LogArr3OptionEnum.VERTICAL;
        }

        String strObjID = Test.strObjIdGet(_3DArray_I);

        String strArr3t = (_3DArray_I == null) ? "null" : Test.strToLog3DArray(_3DArray_I, text_I, logOption, strObjID);

        return strArr3t;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XT> String toLog(
            XT[][][] _3DArray_I
    ) {
        return (_3DArray_I == null) ? "null" : Test.strObjIdGet(_3DArray_I);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static <XT> String strObjIdGet(
            //                                              //str, arr3xxx«Size0, Size1, Size2»:HashCode.

            XT[][][] arr3xt_I
    ) {
        Test.abortIfNull(arr3xt_I, "arr3xt_I");

        String strSize0 = "" + arr3xt_I.length;
        String strSize1 = (strSize0.equals("0")) ? "0" : "" + arr3xt_I[0].length;
        String strSize2 = (strSize1.equals("0")) ? "0" : "" + arr3xt_I[0][0].length;

        XT xtFirstItemOrNull = Test.xtFirstItemOrNull(arr3xt_I);
        Test.subAbortIfNonStandardCollectionItem(xtFirstItemOrNull);

        String strPrefixItem = (xtFirstItemOrNull == null)
                ? "???" : Test.strPrefixSingleType(xtFirstItemOrNull.getClass());

        String strHashCode = (Test.boolIsComparableLog_Z) ? Test.strMASK : "" + arr3xt_I.hashCode();

        return "arr3" + strPrefixItem + "«" + strSize0 + ", " + strSize1 + ", " + strSize2 + "»:" + strHashCode;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static <XT> XT xtFirstItemOrNull(
            XT[][][] arr3xt_I
    ) {
        XT xtFirstItemOrNull = null;
        if ( //
                arr3xt_I != null //
                ) {
            //                                              //Search for first item
            /*WHILE-DO*/
            int intI = 0;
            while ( //
                    intI < arr3xt_I.length
                    && xtFirstItemOrNull == null //
                    ) {
                xtFirstItemOrNull = Test.xtFirstItemOrNull(arr3xt_I[intI]);

                intI = intI + 1;
            }
        }

        return xtFirstItemOrNull;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static <XT> String strToLog3DArray(
            //                                              //str, arr2xxx«Size0, Size1»:HashCode.

            XT[][][] arr3xt_I,
            String text_I,
            LogArr3OptionEnum logOption_I,
            String strObjId_I
    ) {
        O<String> ostrFormat3DArray = new O<>();
        if ( //
                Test.darrobjPreviouslyProcessed.contains(arr3xt_I) //
                ) {
            ostrFormat3DArray.v = text_I + "(" + strObjId_I + strMessageLogBefore + ")";
        } //
        else {
            //                                          //Register matrix as processed
            Test.darrobjPreviouslyProcessed.add(arr3xt_I);

            /*CASE*/
            if ( //
                    logOption_I == LogArr3OptionEnum.VERTICAL //
                    ) {
                ostrFormat3DArray.v = Test.strVertical3DArray(arr3xt_I, text_I, strObjId_I);
            } //
            else if ( //
                    logOption_I == LogArr3OptionEnum.MATRIX //
                    ) {
                O<String> ostrNL = new O<>();
                O<String> ostrLabel = new O<>();
                Test.subOpenBlock(ostrNL, ostrLabel, ostrFormat3DArray, text_I, strObjId_I);

                ostrFormat3DArray.v = ostrFormat3DArray.v + Test.strMatrix3DArray(arr3xt_I, ostrNL.v);

                Test.subCloseBlock(ostrNL, ostrFormat3DArray, ostrLabel.v);
            } //
            else {
                O<String> ostrNL = new O<>();
                O<String> ostrLabel = new O<>();
                Test.subOpenBlock(ostrNL, ostrLabel, ostrFormat3DArray, text_I, strObjId_I);

                ostrFormat3DArray.v = ostrFormat3DArray.v + Test.strRow3DArray(arr3xt_I, ostrNL.v);

                Test.subCloseBlock(ostrNL, ostrFormat3DArray, ostrLabel.v);
            }
            /*END-CASE*/
        }

        return ostrFormat3DArray.v;
    }

    //--------------------------------------------------------------------------------------------------------------
    private static <XT> String strVertical3DArray(
            //                                              //Format a 3Darray to a Set of Lines(Items) inside a block.
            //                                              //Example:
            //                                              //[
            //                                              //{
            //                                              //[0,0,0] item
            //                                              //...
            //                                              //[n,m,o] item
            //                                              //}
            //                                              //]

            //                                              //str, set in block format

            XT[][][] arr3xt_I,
            String text_I,
            String strObjId_I
    ) {

        O<String> ostrNL = new O<>();
        O<String> ostrLabel = new O<>();
        O<String> ostrFormat3DArray = new O<>();
        Test.subOpenBlock(ostrNL, ostrLabel, ostrFormat3DArray, text_I, strObjId_I);

        int intCharsInLongestIndex = ("[" + (arr3xt_I.length - 1) + "," + (arr3xt_I[0].length - 1)
                + "," + (arr3xt_I[0][0].length - 1) + "]").length();

        for (int intI = 0; intI < arr3xt_I.length; intI = intI + 1) {
            for (int intJ = 0; intJ < arr3xt_I[0].length; intJ = intJ + 1) {
                String[] arrstrIndexAndItem = new String[arr3xt_I[0][0].length];

                for (int intK = 0; intK < arr3xt_I[0][0].length; intK = intK + 1) {
                    //                                          //Format: NL [i,j,k]_ item
                    arrstrIndexAndItem[intK] = ostrNL.v
                            + Std.padRight("[" + intI + "," + intJ + "," + intK + "]", intCharsInLongestIndex) + " "
                            + Test.strToLogXT(arr3xt_I[intI][intJ][intK]);
                }

                ostrFormat3DArray.v = ostrFormat3DArray.v + String.join("", arrstrIndexAndItem)
                        + (!(intJ == arr3xt_I[0].length - 1) ? ostrNL.v : "");
            }
            ostrFormat3DArray.v = ostrFormat3DArray.v
                    + (!(intI == arr3xt_I.length - 1) ? ostrNL.v + ostrNL.v : "");
        }

        Test.subCloseBlock(ostrNL, ostrFormat3DArray, ostrLabel.v);

        return ostrFormat3DArray.v;
    }

    //--------------------------------------------------------------------------------------------------------------
    private static <XT> String strMatrix3DArray(
            //                                              //Format a 3DArray to a Set of Matrix(Lines) inside a block.
            //                                              //Example:
            //                                              //[
            //                                              //{
            //                                              //Matrix<0> { { item, item },  ..., { item, item } }
            //                                              //...
            //                                              //Matrix<n> { { item, item },  ..., { item, item } }
            //                                              //}
            //                                              //]

            XT[][][] arr3xt_I,
            String strNL_I
    ) {
        //                                              //Chars required for longest index: "Matrix<i>"
        int intCharsInLongestIndex = ("Matrix<" + (arr3xt_I.length - 1) + ">").length();

        String[] arrstrIndexAndItem = new String[arr3xt_I.length];
        for (int intI = 0; intI < arr3xt_I.length; intI = intI + 1) {
            //                                          //Format: NL Matrix<i>_ matrix
            arrstrIndexAndItem[intI] = strNL_I + Std.padRight("Matrix<" + intI + ">", intCharsInLongestIndex) + " "
                    + Test.strLineMatrix(arr3xt_I[intI]);
        }

        return strNL_I + "{" + String.join("", arrstrIndexAndItem) + strNL_I + "}";
    }

    //--------------------------------------------------------------------------------------------------------------
    private static <XT> String strRow3DArray(
            //                                              //Format a 3D array to a Set of Arrays(Lines) inside a block.
            //                                              //Example:
            //                                              //[
            //                                              //{
            //                                              //Row<0,0> { item, ..., item }
            //                                              //...
            //                                              //Row<n,m> { item, ..., item }
            //                                              //}
            //                                              //]

            XT[][][] arr3xt_I,
            String strNL_I
    ) {
        //                                              //Chars required for longest index: "Row<n,m>"
        int intCharsInLongestIndex = ("Row<" + (arr3xt_I.length - 1) + "," + (arr3xt_I[0].length - 1) + ">").length();

        String strOpenSeparator = "{";
        String strCloseSeparator = "}";
        String strFormat3DArray = "";
        for (int intI = 0; intI < arr3xt_I.length; intI = intI + 1) {
            String[] arrstrIndexAndItem = new String[arr3xt_I[0].length];

            for (int intJ = 0; intJ < arr3xt_I[0].length; intJ = intJ + 1) {
                //                                          //Format: NL Row<i,j>_ array
                arrstrIndexAndItem[intJ] = strNL_I
                        + Std.padRight("Row<" + intI + "," + intJ + ">", intCharsInLongestIndex) + " "
                        + Test.strLineRow(arr3xt_I[intI][intJ]);
            }

            strFormat3DArray = strFormat3DArray + strNL_I + strOpenSeparator + String.join("", arrstrIndexAndItem)
                    + strNL_I + strCloseSeparator;
        }

        return strNL_I + strOpenSeparator + strFormat3DArray + strCloseSeparator;
    }
    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Test.Shared Method common to several types*/
    //==================================================================================================================
    //    
    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/
    private static final String strMessageLogBefore = "|logged before|";

    //                                                      //Towa's standard system types
    private static final String[][] arr2strSINGLE_TYPE_AND_PREFIX = {
        //                                                  //Primitives
        {"int", "int"}, {"long", "long"}, {"number", "num"}, {"char", "char"}, {"bool", "bool"},
        {"String", "str"},
        //{"Double", "num"},
        //                                                  //Other single types (non system types)
        {"Type", "type"}, /*{"LocalDateTime", "ts"},*/
        //                                                  //System types
        {"Path", "syspath"}, {"Directory", "sysdir"}, {"File", "sysfile"},
        {"TextReader", "systextreader"}, {"TextWriter", "systextwriter"},
        //                                                  //Array log option Enums
        {"LogArrOptionEnum", "logoption"}, {"LogArr2OptionEnum", "logoption"},
        {"LogArr3OptionEnum", "logoption"},
        //                                                  //Path Enums
        {"PathTypeEnum", "pathtype"}, {"PathWhereEnum", "pathwhere"},};

    //                                                      //System types
    //                                                      //Both arrays order by first.
    private static String[] arrstrSINGLE_TYPE;
    private static String[] arrstrPREFIX;

    //------------------------------------------------------------------------------------------------------------------
    /*SUPPORT METHODS FOR INITIALIZER*/
    //
    //------------------------------------------------------------------------------------------------------------------
    private static void subVerifySingleTypeAndPrefix( //
            //                                              //Order and verify constants.
            ) {
        Test.abortIfDuplicate(Test.arrstrSINGLE_TYPE, "Test.arrstrSINGLE_TYPE");
    }

    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    //------------------------------------------------------------------------------------------------------------------
    private static boolean boolIsStandardWrapper(
            Object obj_L
    ) {
        return ( //
                (obj_L instanceof Integer)
                || (obj_L instanceof Long)
                || (obj_L instanceof Double)
                || (obj_L instanceof Character)
                || (obj_L instanceof Boolean) //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    private static boolean boolIsStandardSingle(
            Object obj_L
    ) {
        return ( //
                BobjBaseObjectAbstract.class.isAssignableFrom(obj_L.getClass())
                || (obj_L instanceof Class)
                || (obj_L instanceof LocalDateTime)
                //                                          //Path & Directory are included in Bobj
                || (obj_L instanceof File)
                || (obj_L instanceof Scanner)
                || (obj_L instanceof PrintWriter) //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    private static <XT> String strFormatArrayOrCollection(
            //                                              //str, collection info.

            XT[] arrxt_I,
            Object objCollection_I,
            String text_I,
            String strObjId_I,
            LogArrOptionEnum logOption_I
    ) {
        String strFormatCollection;
        if ( //
                Test.darrobjPreviouslyProcessed.contains(objCollection_I) //
                ) {
            strFormatCollection = text_I + "(" + strObjId_I + strMessageLogBefore + ")";
        } //
        else {
            //                                          //Register collection as processed
            Test.darrobjPreviouslyProcessed.add(objCollection_I);

            if ( //
                    logOption_I == LogArrOptionEnum.VERTICAL //
                    ) {
                O<String> ostrNL = new O<>();
                O<String> ostrLabel = new O<>();
                O<String> ostrFormatCollection = new O<>();
                Test.subOpenBlock(ostrNL, ostrLabel, ostrFormatCollection, text_I, strObjId_I);

                ostrFormatCollection.v = ostrFormatCollection.v + Test.strArrayOfItems(arrxt_I, ostrNL.v);

                Test.subCloseBlock(ostrNL, ostrFormatCollection, ostrLabel.v);
                strFormatCollection = ostrFormatCollection.v;
            } //
            else {
                strFormatCollection = text_I + "(" + strObjId_I + Test.strLineRow(arrxt_I) + ")";
            }
        }

        return strFormatCollection;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static <XT> String strArrayOfItems( //
            //                                              //For array of integers.
            //                                              //Format an array to a Set of Lines(Items) inside a block.
            //                                              //Example:
            //                                              //{
            //                                              //[0] item
            //                                              //[
            //                                              //...
            //                                              //[x] item
            //                                              //}
            //                                              //]

            //                                              //str, set in block format

            XT[] arrxt_I,
            String strNL_I
    ) {
        //                                                  //Chars required for longest index: "[x]"
        int intCharsInLongestIndex = ("[" + (arrxt_I.length - 1) + "]").length();

        //                                                  //Produces a Set of Lines(Items) ready to display.
        String[] arrstrIndexAndItem = new String[arrxt_I.length];
        for (int intI = 0; intI < arrxt_I.length; intI = intI + 1) {
            //                                              //Format: NL [i]_ item
            arrstrIndexAndItem[intI] = strNL_I + Std.padRight("[" + intI + "]", intCharsInLongestIndex) + " "
                    + Test.strToLogXT(arrxt_I[intI]);
        }

        return strNL_I + "{" + String.join("", arrstrIndexAndItem) + strNL_I + "}";
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static <XT> String strLineRow( //
            //                                              //For array of integers.
            //                                              //Produces:
            //                                              //{ item, ..., item }.

            //                                              //str, arr in one line format.

            XT[] arrxt_I
    ) {
        //                                                  //Convert arrint to arrstr
        String[] arrstrItem = new String[arrxt_I.length];
        for (int intI = 0; intI < arrxt_I.length; intI = intI + 1) {
            arrstrItem[intI] = Test.strToLogXT(arrxt_I[intI]);
        }

        //                                                  //Format: { item, item, ..., item }
        return Test.strVectorFromSet(arrstrItem);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static String strVectorFromSet( //
            //                                              //Produces:
            //                                              //{ stuff, ..., stuff }.
            //                                              //Posibilities:
            //                                              //Put a set of strItem in a vector (strRow).
            //                                              //Put a set of strRow in a vector (strMatrix).
            //                                              //Put a set of strMatrix in a vector (strCube).

            //                                              //str, vector format.

            //                                              //Stuff to be included in strVector.
            String[] arrstrStuff_I
    ) {
        String strRowFormatBeforeAddingBrackets = (arrstrStuff_I.length == 0) ? " "
                : " " + String.join(", ", arrstrStuff_I) + " ";

        return "{" + strRowFormatBeforeAddingBrackets + "}";
    }

    //-------------------------------------------------------------------------------------------------------------
    private static String strToLogXT(
            Object obj_I
    ) {
        String strToLogXT;
        /*CASE*/

        if ( //
                obj_I == null //
                ) {
            strToLogXT = "null";
        } //
        else if ( //
                obj_I instanceof Integer //
                ) {
            strToLogXT = Test.toLog((Integer) obj_I);
        } //
        else if ( //
                obj_I instanceof Long //
                ) {
            strToLogXT = Test.toLog((Long) obj_I);
        } //
        else if ( //
                obj_I instanceof Double //
                ) {
            strToLogXT = Test.toLog((Double) obj_I);
        } //
        else if ( //
                obj_I instanceof Character //
                ) {
            strToLogXT = Test.toLog((Character) obj_I);
        } //
        else if ( //
                obj_I instanceof Boolean //
                ) {
            strToLogXT = Test.toLog((Boolean) obj_I);
        } //
        else if ( //
                obj_I instanceof String //
                ) {
            strToLogXT = Test.toLog((String) obj_I);
        } //
        else if ( //
                obj_I instanceof Class //
                ) {
            strToLogXT = Test.toLog((Class) obj_I);
        } //
        else if ( //
                obj_I instanceof LocalDateTime //
                ) {
            strToLogXT = Test.toLog((LocalDateTime) obj_I);
        } //
        else if ( //
                obj_I instanceof Directory //
                ) {
            strToLogXT = Test.toLog((Directory) obj_I);
        } //
        else if ( //
                obj_I instanceof File //
                ) {
            strToLogXT = Test.toLog((File) obj_I);
        } //
        else if ( //
                obj_I instanceof Scanner //
                ) {
            strToLogXT = Test.toLog((Scanner) obj_I);
        } //
        else if ( //
                obj_I instanceof PrintWriter //
                ) {
            strToLogXT = Test.toLog((PrintWriter) obj_I);
        } //
        else if ( //
                obj_I instanceof Exception //
                ) {
            strToLogXT = Test.toLog((Exception) obj_I);
        } //
        else if ( //
                obj_I instanceof Enum //
                ) {
            strToLogXT = Test.toLog((Enum) obj_I);
        } //
        else if ( //
                obj_I instanceof BsysBaseSystemAbstract //
                ) {
            strToLogXT = Test.toLog((BsysBaseSystemAbstract) obj_I);
        } //
        else if ( //
                obj_I instanceof BclassAbstract //
                ) {
            strToLogXT = ((BclassAbstract) obj_I).toLogFull();
        } //
        else if ( //
                obj_I instanceof BtupleAbstract //
                ) {
            strToLogXT = ((BtupleAbstract) obj_I).toLogFull();
        } //
        else {
            Test.abort("SOMETHING IS WRONG!!!, method Test.toLog(?) for " + Test.toLog(obj_I.getClass(), "obj_I.Type")
                    + " not implemented");

            //                                              //To avoid compile error
            strToLogXT = null;
        }

        return strToLogXT;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static String z_TowaPRIVATE_ToLogXT(
            Object obj_I,
            String text_I
    ) {
        String strToLogXT;
        /*CASE*/

        if ( //
                obj_I == null //
                ) {
            strToLogXT = "null";
        } //
        else if ( //
                obj_I instanceof Integer //
                ) {
            strToLogXT = Test.toLog((Integer) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof Long //
                ) {
            strToLogXT = Test.toLog((Long) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof Double //
                ) {
            strToLogXT = Test.toLog((Double) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof Character //
                ) {
            strToLogXT = Test.toLog((Character) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof Boolean //
                ) {
            strToLogXT = Test.toLog((Boolean) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof String //
                ) {
            strToLogXT = Test.toLog((String) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof Class //
                ) {
            strToLogXT = Test.toLog((Class) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof LocalDateTime //
                ) {
            strToLogXT = Test.toLog((LocalDateTime) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof Directory //
                ) {
            strToLogXT = Test.toLog((Directory) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof File //
                ) {
            strToLogXT = Test.toLog((File) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof Scanner //
                ) {
            strToLogXT = Test.toLog((Scanner) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof PrintWriter //
                ) {
            strToLogXT = Test.toLog((PrintWriter) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof Exception //
                ) {
            strToLogXT = Test.toLog((Exception) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof Enum //
                ) {
            strToLogXT = Test.toLog((Enum) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof BsysBaseSystemAbstract //
                ) {
            strToLogXT = Test.toLog((BsysBaseSystemAbstract) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof BclassAbstract //
                ) {
            strToLogXT = Test.toLog((BclassAbstract) obj_I, text_I);
        } //
        else if ( //
                obj_I instanceof BtupleAbstract //
                ) {
            strToLogXT = Test.toLog((BtupleAbstract) obj_I, text_I);
        } //
        else {
            Test.abort("SOMETHING IS WRONG!!!, method Test.toLog(?) for " + Test.toLog(obj_I.getClass(), "obj_I.Type")
                    + " not implemented");

            //                                              //To avoid compile error
            strToLogXT = null;
        }

        return strToLogXT;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static boolean boolShouldDisplayVertical( //

            Class type_I
    ) {
        return ( // 
                BobjBaseObjectAbstract.class.isAssignableFrom(type_I)
                //                                          //Path & Directory are included in bobj
                || (type_I == File.class) //
                );
    }

    //------------------------------------------------------------------------------------------------------------------
    private static String strPrefixSingleType( //
            //                                              //Generate the varible name prefix correponding to a type.
            //                                              //Only single type, no collections.
            Class type_I
    ) {
        String strTypeName = Std.name(type_I);
        int intX = Arrays.binarySearch(Test.arrstrSINGLE_TYPE, strTypeName);

        String strPrefixSingleType = (intX >= 0) ? Test.arrstrPREFIX[intX]
                : (Enum.class.isAssignableFrom(type_I)) ? Test.strPrefixEnumOrBclass(type_I)
                : (BtupleAbstract.class.isAssignableFrom(type_I)) ? Test.strPrefixBtuple(type_I)
                : (BclassAbstract.class.isAssignableFrom(type_I)) ? Test.strPrefixEnumOrBclass(type_I) : null;

        if ( //
                strPrefixSingleType == null //
                ) {
            Test.abort("Prefix for type_I.Name(" + strTypeName + ") could not be find"/*,
                    Test.toLog(Test.arr2strSINGLE_TYPE_AND_PREFIX, "Test.arr2strSINGLE_TYPE_AND_PREFIX")*/);
        }

        return strPrefixSingleType;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static String strPrefixEnumOrBclass( //
            //                                              //Prefix for enum and bclass (AaaaaBbbbbCcccc).
            //                                              //str, prefix ("aaaaa").

            Class type_I
    ) {
        String strTypeName = Std.name(type_I);

        if ( //
                !Std.isLetterUpper(strTypeName.charAt(0)) //
                ) {
            Test.abort(strTypeName + " is not an standard enum or bclass, type name should start with A-Z",
                    Test.toLog(type_I, "type_I"), Test.toLog(strTypeName, "strTypeName"));
        }

        int intI = 1;
        /*WHILE-DO*/
        while ( //
                (intI < strTypeName.length())
                && Std.isDigitOrLetterLower(strTypeName.charAt(intI)) //
                ) {
            intI = intI + 1;
        }

        //                                                  //Subtract type prefix ("aaaaa").
        return ("" + strTypeName.charAt(0)).toLowerCase() + strTypeName.substring(1, intI);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static String strPrefixBtuple( //
            //                                              //Prefix for btuple.
            //                                              //Search for B in TnxxxBbbbbCcccc  (after 'Tn')

            Class type_I
    ) {
        String strTypeName = Std.name(type_I);

        if (!( //
                (strTypeName.charAt(0) == 'T') && Std.isDigit(strTypeName.charAt(1)) //
                )) {
            Test.abort(strTypeName + " is not an standard btuple, type name should start with 'T' and digitA-Z",
                    Test.toLog(type_I, "type_I"), Test.toLog(strTypeName, "strTypeName"));
        }

        int intI = 2;
        /*WHILE-DO*/
        while ( //
                (intI < strTypeName.length())
                //                                          //Between a-z
                && Std.isLetterLower(strTypeName.charAt(intI))) {
            intI = intI + 1;
        }

        //                                                  //Subtract type prefix ("aaaaa").
        return ("" + strTypeName.charAt(0)).toLowerCase() + strTypeName.substring(1, intI);
    }

    //==================================================================================================================
    /*END-TASK*/
    //    //
    /*TASK Test.LogAborts*/
    //==================================================================================================================
    //                                                      //Implementación de apoyos para poder efectuar pruebas de
    //                                                      //      subAbort y regitrar su información en un log.
    //                                                      //¿Cómo?.
    //                                                      //En el código "driver" para ejecutar la prueba (ej. en
    //                                                      //      Test Test01.cs), llamar al método:
    //                                                      //Sys.subSetTestAbort(); o.
    //                                                      //Test.subResetTestAbort(); o.
    //
    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/
    //
    //------------------------------------------------------------------------------------------------------------------
    /*STATIC VARIABLES*/
    //                                                      //Indicador de se desea test.
    //                                                      //This is the initial value, 
    private static boolean boolIsTestAbortOn = false;

    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    //------------------------------------------------------------------------------------------------------------------
    public static void setTestAbort( //
            //                                              //Marca que desea test.
            ) {
        Test.boolIsTestAbortOn = true;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void resetTestAbort( //
            //                                              //Marca que desea concluir test.
            ) {
        Test.boolIsTestAbortOn = false;
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK Test.Abort&Warning*/
    //==================================================================================================================
    //                                                      //Methods to abort excecution or just to send a warning.
    //                                                      //To avoid "weird" behavior of code running, methods
    //                                                      //      that are to be executed outside the control of
    //                                                      //      developer should verify its parameter (implement
    //                                                      //      fuse's) and abort if something is wrong ("my
    //                                                      //      method is not designed to manage this input).
    //                                                      //Sometimes the intention is just to warn the user.
    //
    //------------------------------------------------------------------------------------------------------------------
    public static void abort( //

            //                                              //Just the message, no additional info.
            String message_I
    ) {
        Test.abort(message_I, (String) null);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void abort( //

            String message_I,
            String... complementaryInfo_I
    ) {
        String strFullMessage = Test.strFullMessageGet("abort", message_I, complementaryInfo_I);
        Test.subShowFullMessage(strFullMessage);

        //                                                  //Existen 2 posibilidades para continuar o terminar
        if ( //
                Test.boolIsTestAbortOn //
                ) {
            try {
                //                                          //Vacio para permitir la excepción
                throw new SysexcepuserUserAbort(strFullMessage);
            } //
            catch (Exception e) {

            }
        } //
        else {
            Test.finalizeLog();

            System.exit(0);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void warning( //
            //                                              //Ejecucion al detectar situación anormal.
            //                                              //Puede ser WinForms app o Console app.

            //                                              //Mensaje descriptivo.
            String message_I
    ) {
        Test.warning(message_I, (String) null);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void warning( //
            //                                              //Ejecucion al detectar situación anormal.
            //                                              //Puede ser WinForms app o Console app.

            //                                              //Mensaje descriptivo.
            String message_I,
            //                                              //Para facilitar el diagnóstico.
            //                                              //No se incluye información complementaria
            String... complementaryInfo_I
    ) {
        String strFullMessage = Test.strFullMessageGet("warning", message_I, complementaryInfo_I);
        Test.subShowFullMessage(strFullMessage);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static String strFullMessageGet( //
            //                                              //Formatea el mensaje.
            //                                              //str, full message.

            //                                              //"Abort" or "Warning"
            String strAbortOrWarning_I,
            String strMessage_I,
            String[] arrstrComplementaryInfo_I
    ) {
        String[] arrstrMethodCall = Test.arrstrMethodCallGet(strAbortOrWarning_I);

        int intMaxNumOfChars = 62;
        arrstrMethodCall = Test.arrstrFormatMessage(arrstrMethodCall, intMaxNumOfChars);

        //                                                  //Extrae ubicación del aborto/warning (sin →)
        String strMethodCallAbortOrWarning = arrstrMethodCall[0].substring(1);

        String[] arrstrPart = Std.split(strMethodCallAbortOrWarning, '●');
        String strApplication = arrstrPart[0];
        String strRelevantPart = arrstrPart[1];
        String strClass = arrstrPart[2];
        String strMethodAndParamenters = arrstrPart[3];

        //                                                  //To easy code
        String strNL = System.lineSeparator();
        String strTextAbnormalEndOrWarning = (strAbortOrWarning_I.compareTo("abort") == 0) ? "ABNORMAL END" : "WARNING";
        String strAllComplementaryInfo
                = (arrstrComplementaryInfo_I == null) ? ""
                        : ("COMPLEMENTARY INFO:" + strNL + '→' + String.join(strNL + '→', arrstrComplementaryInfo_I))
                        + strNL;

        String strFullMessageGet
                = "<<<" + strTextAbnormalEndOrWarning + ">>>" + strNL
                + "APPLICATION: " + strApplication + strNL
                + "RELEVANT PART: " + strRelevantPart + strNL
                + "CLASS: " + strClass + strNL
                + "METHOD: " + strMethodAndParamenters + strNL
                + strTextAbnormalEndOrWarning + " MESSAGE:"
                + strNL + strMessage_I + strNL + strNL
                + "METHOD CALL SEQUENCE (from last to first):" + strNL
                + String.join(strNL, arrstrMethodCall) + strNL
                + strAllComplementaryInfo
                + "<<<END OF " + strTextAbnormalEndOrWarning + ">>>";

        return strFullMessageGet;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static String[] arrstrMethodCallGet( //
            //                                              //THIS METHOD NEED TO BE REWRITTEN FOR EACH TECHNOLOGY
            //                                              //      INSTANCE (C#, Java, Swift, etc.).
            //                                              //In Java (the same for any other instance), stack will
            //                                              //      contain a lot of information.
            //                                              //We extract only what we want to display.
            //                                              //arrstr, info stack, sequence of method call from 
            //                                              //      execution (or test start) until BEFORE Abort/Warning
            //                                              //      method was called.

            //                                              //"Abort" o "Warning"
            String strAbortOrWarning_I
    ) {

        //                                                  //La estrategia será:
        //                                                  //1. Se localiza "TowaStandard.Test.Abort" o
        //                                                  //      "TowaStandard.Test.Warning" (se toma a partir del
        //                                                  //      siguiente método).
        //                                                  //2. Localiza "Z_Testing", esto aún no es claro como será
        //                                                  //      cuando la aplicación este en operación (se toma
        //                                                  //      hasta el primer método fuera de "Z_Testing").
        //                                                  //3. De cada línea elimina la información no útil.
        //
        //                                                  //To easy code.
        StackTraceElement[] arrsteStack = Thread.currentThread().getStackTrace();
        String[] arrstrStack = new String[arrsteStack.length];
        for (int intI = 0; intI < arrsteStack.length; intI = intI + 1) {
            arrstrStack[intI] = arrsteStack[intI].toString();
        }
        int intStart = 0;
        /*UNTIL-DO*/
        while (!( //
                //                                          //Should always find
                arrstrStack[intStart].contains("TowaStandard.Test." + strAbortOrWarning_I + "(") //                
                )) {
            intStart = intStart + 1;
        }
        intStart = intStart + 1;

        int intEndPlusOne = intStart;
        /*UNTIL-DO*/
        while (!( //
                //                                          //Should always find
                arrstrStack[intEndPlusOne].contains("Z_Testing.") //                
                )) {
            intEndPlusOne = intEndPlusOne + 1;
        }

        //                                                  //Take info we are looking for (not clean).
        String[] arrstrMethodCallUnclean = new String[intEndPlusOne - intStart];
        System.arraycopy(arrstrStack, intStart, arrstrMethodCallUnclean, 0, arrstrMethodCallUnclean.length);

        //                                                  //Clean info.
        String[] arrstrMethodCallGet = new String[arrstrMethodCallUnclean.length];
        for (int intI = 0; intI < arrstrMethodCallUnclean.length; intI = intI + 1) {
            arrstrMethodCallGet[intI] = Test.strMethodCallGet(arrstrMethodCallUnclean[intI]);
        }
        return arrstrMethodCallGet;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static String strMethodCallGet( //
            //                                              //THIS METHOD NEED TO BE REWRITTEN FOR EACH TECHNOLOGY
            //                                              //      INSTANCE (C#, Java, Swift, etc.).
            //                                              //Info extracted will be in standarize format (the same for
            //                                              //      all technology instance).
            //                                              //The idea is to report:
            //                                              //1. System or Aplicación.
            //                                              //2. Subsystem, Module or Relevant Part.
            //                                              //3. Component, Program, or Class.
            //                                              //4. Method, rutine or function.
            //                                              //(Glg, August 27, 2018) This is well defined for Object
            //                                              //      Oriented, this will be:
            //                                              //1. Application (Ex. SoftwareAutomation,
            //                                              //      SoftwareAutomationCobol, SoftwareCompare, etc.). 
            //                                              //2. Relevant Part (Ex. Cod, Nvsbcod, Nvsbsol, etc.).
            //                                              //3. Class (Ex. CodCodeAbstract, CodcbCobol,
            //                                              //      NvsbcodNewVsBaseCodeComparison, etc.).
            //                                              //4. Method or 'initializer' for static constructor {Ex,
            //                                              //      subPrepareUseful(strCHAR_USEFUL_I, arrcharUSEFUL_O),
            //                                              //      subPrepareConstants(codDUMMY_I, strCHAR_USEFUL_I,
            //                                              //      ___ arrcharUSEFUL_O,
            //                                              //      ___ strCHAR_TO_CONVERT_AND_CONVERSION_I, 
            //                                              //      ___ arrcharTO_CONVERT_O, arrcharCONVERSION_O),
            //                                              //      'initializar', subTestCod1(), etc.}.
            //                                              //In Java, stack contains:
            //                                              //pack1.pack2.___.packN.class.method(???) more info.
            //                                              //%%%ns.___.ns.class.method(parameters)%%%.
            //                                              //%%% is non useful info.
            //                                              //Get its parts:
            //                                              //1. Application, first namespace.
            //                                              //2. Relevant Part, last namespace (if was the first, then
            //                                              //      Relevant Part will be messing, this should happen if
            //                                              //      Abort/Warning is in TowaStandard.
            //                                              //3. Class.
            //                                              //4. Method (only method name).
            //                                              //5. Parameters.
            //                                              //Note: In Java was not easy to get parameters.
            //                                              //Example:
            //                                              //→SoftwareAutomation●Cod●CodCodeAbstract●subPrepareUse... .
            //                                              //(Glg, July 25, 2018) paramenters (var1, ___, varN) where
            //                                              //      changed to (?).

            //                                              //Non standarized info
            String strMethodCallUnclean_I
    ) {

        String strMethodCallUnclean = strMethodCallUnclean_I;
        //                                                  //De donde a donde está el nombre del método
        int intPar = strMethodCallUnclean.lastIndexOf('(');
        int intLastDot = strMethodCallUnclean.lastIndexOf('.', intPar);
        int intMethod = intLastDot + 1;

        String strMethod = strMethodCallUnclean.substring(intMethod, intPar);

        if ( //                                             //Si es un constructor
                strMethod.compareTo("<init>") == 0 //
                ) {
            //                                              //Se ajusta a nomenclatura estandar
            strMethod = "(?)";
        } //
        else if ( //                                        //Si es inicializador estático
                strMethod.compareTo("<clinit>") == 0 //
                ) {
            strMethod = "'initializer'";
        } //
        else {
            //                                              //Número de parámetros indefinido
            strMethod = strMethod + "(?)";
        }

        //                                                  //Inicio del nombre de clase
        int intDotClass = strMethodCallUnclean.lastIndexOf('.', intLastDot - 1);
        int intClass = intDotClass + 1;

        String strClass = strMethodCallUnclean.substring(intClass, intLastDot);

        //                                                  //Inicio de parte relevante, si es que existe
        int intFirstDot = strMethodCallUnclean.indexOf('.');
        int intRelevantPart = intFirstDot + 1;

        String strRelevantPart = (intFirstDot == intDotClass)
                ? "" : strMethodCallUnclean.substring(intRelevantPart, intDotClass);

        String strApp = strMethodCallUnclean.substring(0, intFirstDot);

        return '→' + strApp + '●' + strRelevantPart + '●' + strClass + '●' + strMethod;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subShowFullMessage( //
            //                                              //Can be Windows or Console app.

            String strFullMessage_I
    ) {
        //                                                  //In "ComparableLog", test should run without human
        //                                                  //      intervention
        if ( //
                Test.boolIsComparableLog_Z //
                ) {
            //                                              //Do nothing. (no message on window or console)
        } //
        else {
            if ( //
                    //                                      //Is Windows app
                    JFrame.getFrames() != null || JFrame.getWindows() != null //
                    ) {
                //                                          //Show message on Window
                JOptionPane.showMessageDialog(null, strFullMessage_I);
            } //
            else {
                //                                          //Show message on Console
                System.out.println(strFullMessage_I);

                System.out.println("");
                System.out.println("ENTER KEY TO END");
                String strReadLine = (new Scanner(System.in)).nextLine();
            }
        }

        //                                                  //Send message to log.
        Test.log(strFullMessage_I);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static String[] arrstrFormatMessage( //
            //                                              //Formato a un conjunto de líneas para mantener un tamaño 
            //                                              //      de línea adecuado y similar a C# al momento de
            //                                              //       mostrar mensajes de aborto o advertencia.

            //                                              //Arreglo a dar formato
            String[] arrstrLinesToFormat_IO,
            //                                              //Número de caracteres permitidos por línea
            int intMaxNumOfChars_I
    ) {
        for (int intI = 0; intI < arrstrLinesToFormat_IO.length; intI = intI + 1) {
            if ( //
                    arrstrLinesToFormat_IO[intI].length() > intMaxNumOfChars_I //
                    ) {
                arrstrLinesToFormat_IO[intI] = strFormatLine(arrstrLinesToFormat_IO[intI], intMaxNumOfChars_I);
            }
        }

        return arrstrLinesToFormat_IO;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static String strFormatLine( //
            String strLineToFormat_M,
            int intMaxNumOfChars_I
    ) {
        //                                              //Indicador de donde empieza y termina cada línea
        int intLineEnd = 0;
        int intLineStart = 0;
        String strResult = "";
        //                                              //Mientras la línea se pase del máximo número de caracteres
        while (intLineEnd < strLineToFormat_M.length() / intMaxNumOfChars_I) {
            intLineEnd = intLineEnd + 1;
            strResult = strResult
                    + strLineToFormat_M.substring(intMaxNumOfChars_I * intLineStart, intMaxNumOfChars_I * intLineEnd)
                    + System.lineSeparator();
            intLineStart = intLineStart + 1;
        }

        strResult = strResult + strLineToFormat_M.substring(intLineEnd * intMaxNumOfChars_I);

        return strResult;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //                                                  //COMPARABLE TEST
    //------------------------------------------------------------------------------------------------------------------
    /*STATIC VARIABLES*/
    //                                                  //Log para mostrar información en un archivo.
    //                                                  //Este log se asigna al iniciar una prueba con el método
    //                                                  //      subInitializeLog().
    //                                                  //Se mostrará información en los siguientes casos:
    //                                                  //1. Al concluir una prueba, usando el método subLog().
    //                                                  //2. Al abortar (subAbort), si systextwriterLog != null.
    //                                                  //3. Al enviar un Warning (subWarning). similar a abortar.
    //                                                  //4. Al usar Trace.
    //                                                  //AT CODING, SOME VALUE IS REQUIRES BECAUSE IT CAN BE USED
    //                                                  //      BEFORE INITIALIZATION IS COMPLETE.
    private static PrintWriter systextwriterLog = null;

    //                                                  //Object previously processed in other strTo execution.
    //                                                  //Al inicializar la clase se establecerá { }, después podrá
    //                                                  //      ser cambiado a contener algo.
    //                                                  //AT CODING, SOME VALUE IS REQUIRES BECAUSE IT CAN BE USED
    //                                                  //      BEFORE INITIALIZATION IS COMPLETE.
    //                                                  //***** AL LIMPIAR Test, CAMBIAR A private
    private static ArrayList<Object> darrobjPreviouslyProcessed = new ArrayList<>();

    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    public static void initializeLog( //
            //                                              //NO SE DESEA ComparableLog.
            //                                              //Inicializa el log. (Al inicio de cada Test se debe
            //                                              //      ejecutar uno de estos métodos sobrecargados).

            //                                              //(Ver de descripción de parámetros en
            //                                              //      subSetParametersAndInitializeLog).
            String testerName_I,
            Path directoryPathForLogs_I,
            String test_I
    ) {
        Test.initializeLog(testerName_I, directoryPathForLogs_I, test_I, null);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void initializeLog( //
            //                                              //SE DESEA ComparableLog.
            //                                              //Inicializa el log. (Al inicio de cada Test se debe
            //                                              //      ejecutar uno de estos métodos sobrecargados).

            //                                              //Nombre de Tester (quien esta a cargo de la prueba)
            String nameTester_I,
            //                                              //Path para los logs, debe ser un directorio
            Path directoryPathForLogs_I,
            //                                              //Clave de la prueba (Ej. Cod1, Cod4Com3Com4Com5Cod3Com2).
            //                                              //Con esta clave se formará en nombre de archivo log de la
            //                                              //      prueba añadiendole .test (Ej. Cod1.test,
            //                                              //      Cod4Com3Com4Com5Cod3Com2.test).
            //                                              //Si el path DirectoryForLogs\Test.test existe se reescribe.
            String test_I,
            //                                              //Conjunto de directorios que desea ser enmascarado, esta
            //                                              //      información es utilizada en strTo de Syspath.
            //                                              //Ej.: { "\\psf\Home\Desktop", "/user/glg0818/Desk" } o
            //                                              //      { }.
            //                                              //Puede ser null, en este caso sería similar al método que
            //                                              //      no incluye este parámetro.
            T0maskTuple t0mask_L
    ) {
        if ( //
                nameTester_I == null //
                ) {
            Test.abort(Test.toLog(nameTester_I, "strNameTester_I") + " can not be null");
        }
        if ( //
                nameTester_I.compareTo("") == 0 //
                ) {
            Test.abort(Test.toLog(nameTester_I, "strNameTester_I") + " should have a value");
        }
        if ( //
                directoryPathForLogs_I == null //
                ) {
            Test.abort(Test.toLog(directoryPathForLogs_I, "syspathDirectoryForLogs_I") + " can not be null");
        }
        if ( //
                !directoryPathForLogs_I.isDirectory() //
                ) {
            Test.abort(Test.toLog(directoryPathForLogs_I, "syspathDirectoryForLogs_I")
                    + " should be a directory");
        }
        if ( // 
                test_I == null //
                ) {
            Test.abort(Test.toLog(test_I, "strFileForTestLog_I") + " can not be null");
        }
        if ( //
                test_I.compareTo("") == 0 //
                ) {
            Test.abort(Test.toLog(test_I, "strTest_I") + " should have a value");
        }

        Path syspathFileForTestLog = directoryPathForLogs_I.addName(test_I + ".test");

        if ( //
                //                                          //No esta disponible para ser FILE
                syspathFileForTestLog.isDirectory() //
                ) {
            Test.abort(Test.toLog(syspathFileForTestLog, "syspathFileForTestLog") + " can not be a directory");
        }

        //                                              //Genera log
        Test.systextwriterLog = TextWriterX.newX(new FileX(syspathFileForTestLog));

        Test.subSetComparableTestMaskingParameters(t0mask_L);

        //                                              //Cada Test inicia la secuencia de los blocks An, Bn, ...
        Test.darrobjPreviouslyProcessed = new ArrayList<>();
        Test.intStartEnd = 0;

        BclassAbstract.resetSummary();

        //                                              //Write first line in log
        String strNameTester = (Test.boolIsComparableLog_Z) ? "<Test for Automatic Verification>" : nameTester_I;
        String str = MessageFormat.format("{0}, Now({1}), {2}", strNameTester,
                Std.format(Std.dtGetNow(), "yyyy-MM-dd HH:mm"), syspathFileForTestLog.name());
        Test.log(str);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void resetLog( //
            //                                              //Reset log
            ) {
        Test.darrobjPreviouslyProcessed = new ArrayList<>();
        Test.intStartEnd = 0;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void finalizeLog( //
            //                                              //Cierra el log para UNA prueba. (Al concluir cada Test
            //                                              //      se debe ejecutar este método).
            //                                              //1. Dispose log.
            //                                              //2. Lo asinga a null.
            ) {
        //                                              //Solo si esta en una prueba
        if ( //
                //                                          //Hay un log, estamos en prueba
                Test.systextwriterLog != null //
                ) {
            Test.systextwriterLog.close();
            Test.systextwriterLog = null;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void log(
            //                                              //Genera información en el log.

            String informationToLog_I
    ) {
        //                                                  //Solo si esta en una prueba
        if ( //
                //                                          //Hay un log, estamos en prueba
                Test.systextwriterLog != null //
                ) {
            TextWriterX.writeLine(informationToLog_I, Test.systextwriterLog);
        }
    }

    //                                                  //COMPARABLE TEST
    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/
    //                                                  //To mask hashcode and other info.
    //                                                  //***** AL LIMPIAR Test, ¿SE PUEDE CAMBIAR A private?
    private static final String strMASK = "§§§";

    //------------------------------------------------------------------------------------------------------------------
    /*STATIC VARIABLES*/
    //                                                  //FOR IMPLEMENTING COMPARABLE TEST
    //                                                  //Indicador para enmastarar el HashCode en los ObjId y otra
    //                                                  //      información que es útil pero que sin embargo impide
    //                                                  //      que los logs sean comparables en forma automática.
    //                                                  //AT CODING, SOME VALUE IS REQUIRES BECAUSE IT CAN BE USED
    //                                                  //      BEFORE INITIALIZATION IS COMPLETE.
    private static boolean boolIsComparableLog_Z = false;

    public static boolean z_TowaPRIVATE_boolIsComparableLog() {
        return Test.boolIsComparableLog_Z;
    }

    //                                                  //Conjunto de directorios que desea sean enmascarados, esta
    //                                                  //      información es utilizada en strTo de Syspath.
    //                                                  //Este arreglo se debe ordenar en base a la longitud del
    //                                                  //      full path (de mayor a menor).
    //                                                  //Nótese que 2 ó más syspath pueden estár incluidos en el
    //                                                  //      path que se desea enmascarar, sin embargo debe
    //                                                  //      utilizar el de mayor longitud.
    private static Path[] arrsyspathDirectoryToMask;

    //                                                  //dtNowBase y Deltas para subtituir Now (see t0maskTupla).
    private static LocalDateTime dtNowBase;
    private static double[] arrnumDeltaSeconds;

    //                                                  //Al inicializar:
    //                                                  //1. A dtNowNext se asigna dtNowBase.
    //                                                  //2. A intDeltas se asigna 0.
    //                                                  //Al el método dtGetNowComparableTest():
    //                                                  //1. Se toma dtNowNext.
    //                                                  //2. dtNowNext+arrnumDeltaSeconds[intDeltas % arr..length].
    //                                                  //3. intDeltas + 1.
    private static LocalDateTime dtNowNext;
    private static int intDeltas;

    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //
    //------------------------------------------------------------------------------------------------------------------
    private static void subSetComparableTestMaskingParameters( //
            //                                              //Método iniciar un Test for Automatic Verification, en el
            //                                              //      cual:
            //                                              //Tester name se muestra con "<Test for Automatic
            //                                              //      Verification>".
            //                                              //Los hashcode se muestran como §§§.
            //                                              //Los full path (de syspath) que estan incluidos en
            //                                              //      arrstrDirectoryToMask_L se muestran enmascarando el
            //                                              //      directorio con §§§.

            //                                              //Conjunto de directorios que desea ser enmascarado, esta
            //                                              //      información es utilizada en strTo de Syspath.
            //                                              //Ej.: { "\\psf\Home\Desktop", "/user/glg0818/Desk" } o
            //                                              //      { }.
            //                                              //null to indicate it is not a Comparable Test.
            T0maskTuple t0mask_I
    ) {
        if ( //
                t0mask_I == null //
                ) {
            //                                          //NO SE DESEA ComparableLog.
            Test.boolIsComparableLog_Z = false;

            //                                          //It is not required to initialize other values, they should
            //                                          //      not be used
        } //
        else {
            //                                          //SE DESEA ComparableLog.
            Test.boolIsComparableLog_Z = true;

            //                                          //Order in descending length sequence
            Test.arrsyspathDirectoryToMask = t0mask_I.arrsyspathDirectory;
            Integer[] arrintLengthFullPath = new Integer[Test.arrsyspathDirectoryToMask.length];
            for (int intI = 0; intI < Test.arrsyspathDirectoryToMask.length; intI = intI + 1) {
                arrintLengthFullPath[intI] = -Test.arrsyspathDirectoryToMask[intI].fullPath().length();
            }
            Std.sort(arrintLengthFullPath, Test.arrsyspathDirectoryToMask);

            Test.dtNowBase = t0mask_I.dtNowBase;
            Test.arrnumDeltaSeconds = t0mask_I.arrnumDeltaSeconds;

            //                                          //Secuencia de dtNow
            Test.dtNowNext = Test.dtNowBase;
            Test.intDeltas = 0;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static LocalDateTime z_TowaPRIVATE_GetNowForComparableTest( //
            //                                              //Genera un dtNow para comparable Test.
            //                                              //dt, Now
            ) {
        LocalDateTime dtGetNowComparableTest = Test.dtNowNext;
        //                                                  //Prepara siguiente:
        //                                                  //intX será: 0, 1, 2, ..., 0, 1, 2, ..., 0, ...
        int intX = Test.intDeltas % Test.arrnumDeltaSeconds.length;
        long longMilliseconds = Math.round(Test.arrnumDeltaSeconds[intX] * 1000);
        Test.dtNowNext = Test.dtNowNext.plusNanos(longMilliseconds * 1000000);
        intDeltas = intDeltas + 1;

        return dtGetNowComparableTest;
    }

    //                                                      //TRACE
    //------------------------------------------------------------------------------------------------------------------
    /*STATIC VARIABLES*/
    //                                                      //¿Cómo?.
    //                                                      //En los puntos que se crea conveniente, añadir:
    //                                                      //Test.subTrace(?).
    //                                                      //Imprimir el log que contendrá el trace y otra información
    //                                                      //      de la prueba
    //                                                      //Cada Trace que se genere tendra un número único 1, 2, 3,
    //                                                      //      etc. (esto es, su secuencia).
    //                                                      //Antes de generar un nuevo trace se debe incrementar.
    private static int intTraceSequence;

    //------------------------------------------------------------------------------------------------------------------
    /*SHARED METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    private static void subInitializeTrace() {
        Test.intTraceSequence = 0;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void trace(
            //                                              //Genera un trace a writeline.

            //                                              //true, se desea generar el trace.
            //                                              //false, No se genera el trace.
            //                                              //Se incluye este parámetro para sin tener que eliminar la
            //                                              //      la ejecución del trace poder activarlo/desactivarlo.
            boolean isTraceOn_I,
            //                                              //Etiqueta para identificar el registro del trace en la
            //                                              //      impresión. Cada instrucción trace que se agregue al
            //                                              //      código debe tener una etiqueta distinta.
            String label_I,
            //                                              //Información a incluir en el trace, esta información se le
            //                                              //      da forma similar a los strTo.
            String informationToTrace_I
    ) {
        /*
        if ( //
                Test.systextwriterLog == null //
                ) {
            Test.abort(Test.toLog(Test.systextwriterLog, "Test.systextwriterLog") + " should be created and assigned");
        }
         */

        //                                                  //Solo se procesa el trace si esta en ON.
        if ( //
                isTraceOn_I
                && (Test.systextwriterLog != null) //
                ) {
            //                                              //Avanza una secuencia (esta es la secuencia única de este
            //                                              //      trace).
            intTraceSequence = intTraceSequence + 1;

            //                                              //Produce trace.
            String str = MessageFormat.format("►trace►►►►►{0}.{1}", label_I, intTraceSequence);
            Test.log(str);
            Test.log(informationToTrace_I);
        }
    }

    //==================================================================================================================
    /*END-TASK*/
    //
    /*TASK block methods*/
    //==================================================================================================================
    //
    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/
    //                                                      //If there are more than 25 levels the last value is used.
    private static int[] arrintLevelSpaces = {
        0, 4, 8, 12, 16, 20, 24, 27, 30, 33, 36, 39, 42, 44, 46, 48, 50, 52, 54, 55, 56, 57, 58, 59, 60
    };
    //                                                      //If there are more than 28 levels the last value is used.
    private final static String strLETTERS_FOR_LEVEL = "?ABCDEFGHIJKLMNOPQRSTUVWXYZ*";

    //------------------------------------------------------------------------------------------------------------------
    /*STATIC VARIABLES*/
    //                                                      //Each START-END block must be at a higher lever than its
    //                                                      //      respective base, and should be increased when 
    //                                                      //opening a block and 
    //                                                      //decreased after closing it.
    private static int intLevel = 0;

    //                                                      //This variable is used for every START-END block
    //                                                      //      and assigning a unique identification number
    //                                                      //      (Every time the value is read, 
    //                                                      //      it should be increased by 1).
    private static int intStartEnd = 0;

    //------------------------------------------------------------------------------------------------------------------
    /*STATIC METHODS*/
    //
    //------------------------------------------------------------------------------------------------------------------
    private static void subOpenBlock( //
            //                                              //Generates the required parameters for subToBlockFormat.
            //                                              //When used, block must be paired whith its respective END.
            //                                              //NL + caracteres indentación.
            O<String> ostrNL_O,
            //                                              //Label for block START_??? y END_???. (this is ???).
            O<String> ostrLabel_O,
            //                                              //String to start block information
            O<String> ostrStartBlockFormat_O,
            //                                              //Text to describe the object
            String text_I,
            //                                              //Object Id, if this block is por a bclass should be ""
            String strObjId_I
    ) {
        ostrNL_O.v = Test.strNL();

        //                                                  //Assigns next level (it will return to its original value 
        //                                                  //  after ending the block).
        Test.intLevel = Test.intLevel + 1;

        //                                                  //Assigns a unique ID.
        Test.intStartEnd = Test.intStartEnd + 1;

        //                                                  //Determines the label that corresponds to the block.
        //                                                  //After 'Z', '*' is used.
        char charLettersStartEnd = (Test.intLevel >= Test.strLETTERS_FOR_LEVEL.length()) ? '*'
                : Test.strLETTERS_FOR_LEVEL.charAt(Test.intLevel);

        //                                                  //Assigns the STARTEND label
        ostrLabel_O.v = Character.toString(charLettersStartEnd) + intStartEnd;

        //                                                  //Append Start of block.
        //                                                  //START of block should not include NewLine on "A?" block
        String strNlForStart
                = (charLettersStartEnd == 'A') ? ostrNL_O.v.substring(System.lineSeparator().length()) : ostrNL_O.v;

        ostrStartBlockFormat_O.v = strNlForStart + "##########>>>>>START_" + ostrLabel_O.v;
        ostrStartBlockFormat_O.v = ostrStartBlockFormat_O.v + ostrNL_O.v + text_I + "(" + strObjId_I;
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subCloseBlock( //
            //                                              //Termina el block StartEnd (regresa el nivel).
            //                                              //Solo se usa este método cuando block START-END.

            //                                              //NL + caracteres indentación.
            O<String> ostrNL_IO,
            //                                              //String to append information
            O<String> ostrTo_IO,
            String strLabel_I
    ) {
        //                                                  //End of Block
        ostrTo_IO.v = ostrTo_IO.v + ")" + ostrNL_IO.v + "##########<<<<<END_" + strLabel_I/* + Environment.NewLine*/;
        //                                              //Restores the level.
        Test.intLevel = Test.intLevel - 1;

        ostrNL_IO.v = Test.strNL();
    }

    //------------------------------------------------------------------------------------------------------------------
    private static String strNL( //
            //                                              //NL + caracteres indentación.
            ) {
        //                                                  //Determina el NL+indentación que corresponde al block.
        if ( //
                Test.intLevel < 0 //
                ) {
            Test.abort(Test.toLog(Test.intLevel, "intNivel") + " should be 0 or positive");
        }

        //                                                  //Determines the needed spaces for indentation.
        int intSpaces = (Test.intLevel >= Test.arrintLevelSpaces.length)
                ? Test.arrintLevelSpaces[arrintLevelSpaces.length - 1] : Test.arrintLevelSpaces[intLevel];

        //                                                  //Return NL with required spacing.
        return System.lineSeparator() + Std.padRight("", intSpaces);
    }

    //------------------------------------------------------------------------------------------------------------------
    /*END-TASK*/
    //

    /*TASK TestingTools*/
    //==============================================================================================================
    //                                                  //Support testing.
    //--------------------------------------------------------------------------------------------------------------
    /*STATIC METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    public static void abortIfNull(
            Object object_I,
            String identifier_I
    ) {
        if ( //
                identifier_I == null //
                ) {
            Test.abort("identifier_I(null) can not be null");
        }
        if ( //
                identifier_I.length() == 0 //
                ) {
            Test.abort("identifier_I(" + identifier_I + ") can not be empty string");
        }
        if ( //
                object_I == null //
                ) {
            Test.abort(identifier_I + "(null) can not be null");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void abortIfNullOrNotDummy( //

            BclassAbstract bclass_I,
            String identifier_I
    ) {
        Test.abortIfNull(identifier_I, "identifier_I");
        Test.abortIfNull(bclass_I, identifier_I);
        if ( //
                !bclass_I.isDummy() //
                ) {
            Test.abort(Test.toLog(bclass_I.isDummy(), identifier_I + ".IsDummy") + " should be DUMMY",
                    Test.toLog(bclass_I));
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void abortIfNullOrEmpty(
            String string_I,
            String identifier_I
    ) {
        Test.abortIfNull(identifier_I, "identifier_I");
        if ( //
                identifier_I.length() == 0 //
                ) {
            Test.abort("identifier_I(" + identifier_I + ") can not be empty string");
        }
        Test.abortIfNull(string_I, identifier_I);
        if ( //
                string_I.length() == 0 //
                ) {
            Test.abort(identifier_I + "(" + string_I + ") can not be empty string");
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static void abortIfNullOrEmpty(
            int[] integerArray_L,
            String arrayIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNull(integerArray_L, arrayIdentifier_I);
        if ( //
                integerArray_L.length == 0 //
                ) {
            Test.abort(Test.toLog(integerArray_L, arrayIdentifier_I) + " should contains at least 1 item");
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static void abortIfNullOrEmpty(
            long[] longArray_L,
            String arrayIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNull(longArray_L, arrayIdentifier_I);
        if ( //
                longArray_L.length == 0 //
                ) {
            Test.abort(Test.toLog(longArray_L, arrayIdentifier_I) + " should contains at least 1 item");
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static void abortIfNullOrEmpty(
            double[] numberArray_L,
            String arrayIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNull(numberArray_L, arrayIdentifier_I);
        if ( //
                numberArray_L.length == 0 //
                ) {
            Test.abort(Test.toLog(numberArray_L, arrayIdentifier_I) + " should contains at least 1 item");
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static void abortIfNullOrEmpty(
            char[] characterArray_L,
            String arrayIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNull(characterArray_L, arrayIdentifier_I);
        if ( //
                characterArray_L.length == 0 //
                ) {
            Test.abort(Test.toLog(characterArray_L, arrayIdentifier_I) + " should contains at least 1 item");
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XT> void abortIfNullOrEmpty(
            XT[] array_L,
            String arrayIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNull(array_L, arrayIdentifier_I);
        if ( //
                array_L.length == 0 //
                ) {
            Test.abort(Test.toLog(array_L, arrayIdentifier_I) + " should contains at least 1 item");
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static <XC extends Comparable> void abortIfAnyItemIsNotComprable( //

            //                                              //item could be String or any object (or struct) that
            //                                              //      implement Comparable).
            XC[] array_I,
            //                                              //Ej: arrxxxx¿Name? (xxxx = type prefix)
            String arrayIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNull(array_I, arrayIdentifier_I);

        for (int intI = 0; intI < array_I.length; intI = intI + 1) {
            if ( //
                    array_I[intI] == null //
                    ) {
                Test.abort(
                        Test.z_TowaPRIVATE_ToLogXT(array_I[intI], arrayIdentifier_I + "[" + intI + "]")
                        + " can not be null",
                        Test.toLog(array_I, arrayIdentifier_I));
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void abortIfDuplicate( //
            int[] arraySorted_I,
            //                                              //"arrint¿Name?"
            String arrayIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNull(arraySorted_I, arrayIdentifier_I);

        if ( //
                arraySorted_I == null //
                ) {
            Test.abort(Test.toLog(arraySorted_I, arrayIdentifier_I) + " can not be null");
        }

        for (int intI = 1; intI < arraySorted_I.length; intI = intI + 1) {
            if (!( //
                    arraySorted_I[intI - 1] < arraySorted_I[intI] //
                    )) {
                Test.abort(
                        Test.toLog(arraySorted_I[intI], arrayIdentifier_I + "[" + intI + "]")
                        + " is not in ascending order",
                        Test.toLog(arraySorted_I, arrayIdentifier_I));
            }
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static void abortIfDuplicate( //
            long[] arraySorted_I,
            //                                              //"arrlong¿Name?"
            String arrayIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNull(arraySorted_I, arrayIdentifier_I);

        if ( //
                arraySorted_I == null //
                ) {
            Test.abort(Test.toLog(arraySorted_I, arrayIdentifier_I) + " can not be null");
        }

        for (int intI = 1; intI < arraySorted_I.length; intI = intI + 1) {
            if (!( //
                    arraySorted_I[intI - 1] < arraySorted_I[intI] //
                    )) {
                Test.abort(
                        Test.toLog(arraySorted_I[intI], arrayIdentifier_I + "[" + intI + "]")
                        + " is not in ascending order",
                        Test.toLog(arraySorted_I, arrayIdentifier_I));
            }
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static void abortIfDuplicate( //
            char[] arraySorted_I,
            //                                              //"arrchar¿Name?
            String arrayIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNull(arraySorted_I, arrayIdentifier_I);

        if ( //
                arraySorted_I == null //
                ) {
            Test.abort(Test.toLog(arraySorted_I, arrayIdentifier_I) + " can not be null");
        }

        for (int intI = 1; intI < arraySorted_I.length; intI = intI + 1) {
            if (!( //
                    arraySorted_I[intI - 1] < arraySorted_I[intI] //
                    )) {
                Test.abort(
                        Test.toLog(arraySorted_I[intI], arrayIdentifier_I + "[" + intI + "]")
                        + " is not in ascending order",
                        Test.toLog(arraySorted_I, arrayIdentifier_I));
            }
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XC extends Comparable> void abortIfDuplicate( //
            //                                              //comp could be String, bclass (that implement Comparable),
            //                                              //      btuple or bsys (that implement Comparable).
            XC[] arraySorted_I,
            //                                              //Ej: arrxxxx¿Name? (xxxx = type prefix)
            String arrayIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNull(arraySorted_I, arrayIdentifier_I);

        for (int intI = 1; intI < arraySorted_I.length; intI = intI + 1) {
            if (!( //
                    arraySorted_I[intI - 1].compareTo(arraySorted_I[intI]) < 0 //
                    )) {
                Test.abort(Test.z_TowaPRIVATE_ToLogXT(arraySorted_I[intI], arrayIdentifier_I + "[" + intI + "]")
                        + " is not in ascending order",
                        Test.toLog(arraySorted_I, arrayIdentifier_I));
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                  //ABORT IF IS (OR IS NOT) IN SET
    //------------------------------------------------------------------------------------------------------------------
    public static void abortIfItemIsInSortedSet( //
            int item_I,
            //                                              //"int¿Name?"
            String itemIdentifier_I,
            int[] sortedSet_I,
            //                                              //"arrint¿Name?"
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(itemIdentifier_I, "itemIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(item_I, itemIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        if ( //
                Std.isInSortedSet(item_I, sortedSet_I) //
                ) {
            Test.abort(Test.toLog(item_I, itemIdentifier_I) + " IS in " + sortedSetIdentifier_I,
                    Test.toLog(sortedSet_I, sortedSetIdentifier_I));
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static void abortIfItemIsInSortedSet( //
            long item_I,
            String itemIdentifier_I,
            long[] sortedSet_I,
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(itemIdentifier_I, "itemIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(item_I, itemIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        if ( //
                Std.isInSortedSet(item_I, sortedSet_I) //
                ) {
            Test.abort(Test.toLog(item_I, itemIdentifier_I) + " IS in " + sortedSetIdentifier_I,
                    Test.toLog(sortedSet_I, sortedSetIdentifier_I));
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static void abortIfItemIsInSortedSet( //
            char item_I,
            String itemIdentifier_I,
            char[] sortedSet_I,
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(itemIdentifier_I, "itemIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(item_I, itemIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        if ( //
                Std.isInSortedSet(item_I, sortedSet_I) //
                ) {
            Test.abort(Test.toLog(item_I, itemIdentifier_I) + " IS in " + sortedSetIdentifier_I,
                    Test.toLog(sortedSet_I, sortedSetIdentifier_I));
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XCA extends Comparable, XC extends Comparable> void abortIfItemIsInSortedSet( //
            XCA item_I,
            String itemIdentifier_I,
            XC[] sortedSet_I,
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(itemIdentifier_I, "itemIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(item_I, itemIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        if ( //
                Std.isInSortedSet(item_I, sortedSet_I) //
                ) {
            Test.abort(itemIdentifier_I + "(" + Test.strToLogXT(item_I) + ") IS in "
                    + sortedSetIdentifier_I,
                    Test.toLog(sortedSet_I, sortedSetIdentifier_I));
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void abortIfItemIsNotInSortedSet( //
            int item_I,
            String itemIdentifier_I,
            int[] sortedSet_I,
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(itemIdentifier_I, "itemIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(item_I, itemIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        if (!( //
                Std.isInSortedSet(item_I, sortedSet_I //
                ) //
                )) {
            Test.abort(Test.toLog(item_I, itemIdentifier_I) + " IS NOT in " + sortedSetIdentifier_I,
                    Test.toLog(sortedSet_I, sortedSetIdentifier_I));
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static void abortIfItemIsNotInSortedSet( //
            long item_I,
            String itemIdentifier_I,
            long[] sortedSet_I,
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(itemIdentifier_I, "itemIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(item_I, itemIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        if (!( //
                Std.isInSortedSet(item_I, sortedSet_I //
                ) //
                )) {
            Test.abort(Test.toLog(item_I, itemIdentifier_I) + " IS NOT in " + sortedSetIdentifier_I,
                    Test.toLog(sortedSet_I, sortedSetIdentifier_I));
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static void abortIfItemIsNotInSortedSet( //
            char item_I,
            String itemIdentifier_I,
            char[] sortedSet_I,
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(itemIdentifier_I, "itemIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(item_I, itemIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        if (!( //
                Std.isInSortedSet(item_I, sortedSet_I //
                ) //
                )) {
            Test.abort(Test.toLog(item_I, itemIdentifier_I) + " IS NOT in " + sortedSetIdentifier_I,
                    Test.toLog(sortedSet_I, sortedSetIdentifier_I));
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XCA extends Comparable, XC extends Comparable> void abortIfItemIsNotInSortedSet( //
            XCA item_I,
            String itemIdentifier_I,
            XC[] sortedSet_I,
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(itemIdentifier_I, "itemIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(itemIdentifier_I, itemIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        if ( //
                !Std.isInSortedSet(item_I, sortedSet_I //
                )) {
            Test.abort(itemIdentifier_I + "(" + Test.strToLogXT(item_I) + ") IS NOT in " + sortedSetIdentifier_I,
                    Test.toLog(sortedSet_I, sortedSetIdentifier_I));
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //                                                  //ABORT IF ONE OR MORE ARE (OR ARE NOT) IN SET
    //------------------------------------------------------------------------------------------------------------------
    public static void abortIfOneOrMoreCharactersAreInSortedSet( //
            String string_I,
            String identifier_I,
            char[] characterArraySorted_I,
            String characterArrayIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(identifier_I, "identifier_I");
        Test.abortIfNullOrEmpty(characterArrayIdentifier_I, "characterArrayIdentifier_I");
        Test.abortIfNull(string_I, identifier_I);
        Test.abortIfNull(characterArraySorted_I, characterArrayIdentifier_I);

        for (int intI = 0; intI < string_I.length(); intI = intI + 1) {
            if ( //
                    Std.isInSortedSet(string_I.charAt(intI), characterArraySorted_I) //
                    ) {
                Test.abort(
                        Test.toLog(string_I.charAt(intI), identifier_I + "[" + intI + "]") + " is in "
                        + characterArrayIdentifier_I,
                        Test.toLog(characterArraySorted_I, characterArrayIdentifier_I));
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void abortIfOneOrMoreCharactersAreNotInSortedSet( //
            String string_I,
            String identifier_I,
            char[] characterArraySorted_I,
            String characterArrayIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(identifier_I, "stringIdentifier_I");
        Test.abortIfNullOrEmpty(characterArrayIdentifier_I, "sortedSetIdentifierS_I");
        Test.abortIfNull(string_I, identifier_I);
        Test.abortIfNull(characterArraySorted_I, characterArrayIdentifier_I);

        for (int intI = 0; intI < string_I.length(); intI = intI + 1) {
            if ( //
                    !Std.isInSortedSet(string_I.charAt(intI), characterArraySorted_I) //
                    ) {
                Test.abort(
                        Test.toLog(string_I.charAt(intI), identifier_I + "[" + intI + "]") + " is in "
                        + characterArrayIdentifier_I,
                        Test.toLog(characterArraySorted_I, characterArrayIdentifier_I));
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void abortIfOneOrMoreItemsAreInSortedSet( //
            int[] array_I,
            String arrayIdentifier_I,
            int[] sortedSet_I,
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(array_I, arrayIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        for (int intI = 0; intI < array_I.length; intI = intI + 1) {
            if ( //
                    Std.isInSortedSet(array_I[intI], sortedSet_I) //
                    ) {
                Test.abort(
                        Test.toLog(array_I[intI], arrayIdentifier_I + "[" + intI + "]") + " is in "
                        + sortedSetIdentifier_I,
                        Test.toLog(sortedSet_I, sortedSetIdentifier_I));
            }
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static void abortIfOneOrMoreItemsAreInSortedSet( //
            long[] array_I,
            String arrayIdentifier_I,
            long[] sortedSet_I,
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(array_I, arrayIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        for (int intI = 0; intI < array_I.length; intI = intI + 1) {
            if ( //
                    Std.isInSortedSet(array_I[intI], sortedSet_I) //
                    ) {
                Test.abort(
                        Test.toLog(array_I[intI], arrayIdentifier_I + "[" + intI + "]") + " is in "
                        + sortedSetIdentifier_I,
                        Test.toLog(sortedSet_I, sortedSetIdentifier_I));
            }
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static void abortIfOneOrMoreItemsAreInSortedSet( //
            char[] array_I,
            String arrayIdentifier_I,
            char[] sortedSet_I,
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(array_I, arrayIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        for (int intI = 0; intI < array_I.length; intI = intI + 1) {
            if ( //
                    Std.isInSortedSet(array_I[intI], sortedSet_I) //
                    ) {
                Test.abort(
                        Test.toLog(array_I[intI], arrayIdentifier_I + "[" + intI + "]") + " is in "
                        + sortedSetIdentifier_I,
                        Test.toLog(sortedSet_I, sortedSetIdentifier_I));
            }
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XCA extends Comparable, XC extends Comparable> void abortIfOneOrMoreItemsAreInSortedSet( //
            XCA[] array_I,
            String arrayIdentifier_I,
            XC[] sortedSet_I,
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(array_I, arrayIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        for (int intI = 0; intI < array_I.length; intI = intI + 1) {
            if ( //
                    Std.isInSortedSet(array_I[intI], sortedSet_I) //
                    ) {
                Test.abort(Test.z_TowaPRIVATE_ToLogXT(array_I[intI], arrayIdentifier_I + "[" + intI + "]") + " is in "
                        + sortedSetIdentifier_I,
                        Test.toLog(sortedSet_I, sortedSetIdentifier_I));
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void abortIfOneOrMoreItemsAreNotInSortedSet( //
            int[] array_I,
            String arrayIdentifier_I,
            int[] sortedSet_I,
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(array_I, arrayIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        for (int intI = 0; intI < array_I.length; intI = intI + 1) {
            if ( //
                    !Std.isInSortedSet(array_I[intI], sortedSet_I) //
                    ) {
                Test.abort(
                        Test.toLog(array_I[intI], arrayIdentifier_I + "[" + intI + "]") + " is in "
                        + sortedSetIdentifier_I,
                        Test.toLog(sortedSet_I, sortedSetIdentifier_I));
            }
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static void abortIfOneOrMoreItemsAreNotInSortedSet( //
            long[] array_I,
            String arrayIdentifier_I,
            long[] sortedSet_I,
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(array_I, arrayIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        for (int intI = 0; intI < array_I.length; intI = intI + 1) {
            if ( //
                    !Std.isInSortedSet(array_I[intI], sortedSet_I) //
                    ) {
                Test.abort(
                        Test.toLog(array_I[intI], arrayIdentifier_I + "[" + intI + "]") + " is in "
                        + sortedSetIdentifier_I,
                        Test.toLog(sortedSet_I, sortedSetIdentifier_I));
            }
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static void abortIfOneOrMoreItemsAreNotInSortedSet( //
            char[] array_I,
            String arrayIdentifier_I,
            char[] sortedSet_I,
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(array_I, arrayIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        for (int intI = 0; intI < array_I.length; intI = intI + 1) {
            if ( //
                    !Std.isInSortedSet(array_I[intI], sortedSet_I) //
                    ) {
                Test.abort(
                        Test.toLog(array_I[intI], arrayIdentifier_I + "[" + intI + "]") + " is in "
                        + sortedSetIdentifier_I,
                        Test.toLog(sortedSet_I, sortedSetIdentifier_I));
            }
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static <XCA extends Comparable, XC extends Comparable> void abortIfOneOrMoreItemsAreNotInSortedSet( //
            XCA[] array_I,
            String arrayIdentifier_I,
            XC[] sortedSet_I,
            String sortedSetIdentifier_I
    ) {
        Test.abortIfNullOrEmpty(arrayIdentifier_I, "arrayIdentifier_I");
        Test.abortIfNullOrEmpty(sortedSetIdentifier_I, "sortedSetIdentifier_I");
        Test.abortIfNull(array_I, arrayIdentifier_I);
        Test.abortIfNull(sortedSet_I, sortedSetIdentifier_I);

        for (int intI = 0; intI < array_I.length; intI = intI + 1) {
            if ( //
                    !Std.isInSortedSet(array_I[intI], sortedSet_I) //
                    ) {
                Test.abort(Test.z_TowaPRIVATE_ToLogXT(array_I[intI], arrayIdentifier_I + "[" + intI + "]") + " is in "
                        + sortedSetIdentifier_I,
                        Test.toLog(sortedSet_I, sortedSetIdentifier_I));
            }
        }
    }

    //==============================================================================================================
    /*END-TASK*/
//
    //------------------------------------------------------------------------------------------------------------------
    /*INITIALIZER*/
    //
    //------------------------------------------------------------------------------------------------------------------
    static {
        //                                              //PREPARE CONSTANTS (Verify later).

        //                                              //Prepare constant character
        Test.arrcharDO_NOT_SHOW_HEX = Test.strCHAR_DO_NOT_SHOW_HEX.toCharArray();
        Arrays.sort(Test.arrcharDO_NOT_SHOW_HEX);
        Arrays.sort(Test.arrt3fakecharFAKE);
        Arrays.sort(Test.arrt2charNONPRINTABLE);
        Test.arrt2charDESCRIPTION
                = new T2charDescriptionTuple[Test.arrt2charNONPRINTABLE.length + Test.arrt3fakecharFAKE.length
                + Std.arrt2charESCAPE.length];
        System.arraycopy(Test.arrt2charNONPRINTABLE, 0, Test.arrt2charDESCRIPTION, 0,
                Test.arrt2charNONPRINTABLE.length);
        int intDesp = Test.arrt2charNONPRINTABLE.length;
        for (int intT3 = 0; intT3 < Test.arrt3fakecharFAKE.length; intT3 = intT3 + 1) {
            Test.arrt2charDESCRIPTION[intDesp + intT3] = new T2charDescriptionTuple(
                    Test.arrt3fakecharFAKE[intT3].charFAKE, Test.arrt3fakecharFAKE[intT3].strDESCRIPTION);
        }
        System.arraycopy(Std.arrt2charESCAPE, 0, Test.arrt2charDESCRIPTION,
                Test.arrt2charNONPRINTABLE.length + Test.arrt3fakecharFAKE.length, Std.arrt2charESCAPE.length);
        Arrays.sort(Test.arrt2charDESCRIPTION);

        //                                              //Prepare Single Type and Prefix character
        Test.arrstrSINGLE_TYPE = new String[Test.arr2strSINGLE_TYPE_AND_PREFIX.length];
        Test.arrstrPREFIX = new String[Test.arrstrSINGLE_TYPE.length];
        for (int intI = 0; intI < Test.arrstrSINGLE_TYPE.length; intI = intI + 1) {
            Test.arrstrSINGLE_TYPE[intI] = Test.arr2strSINGLE_TYPE_AND_PREFIX[intI][0];
            Test.arrstrPREFIX[intI] = Test.arr2strSINGLE_TYPE_AND_PREFIX[intI][1];
        }
        Std.sort(Test.arrstrSINGLE_TYPE, Test.arrstrPREFIX);

        //                                              //VERIFY CONSTANTS.
        Test.subVerifyConstantsCharacter();
        Test.subVerifySingleTypeAndPrefix();
    }

    //------------------------------------------------------------------------------------------------------------------
}

//======================================================================================================================
