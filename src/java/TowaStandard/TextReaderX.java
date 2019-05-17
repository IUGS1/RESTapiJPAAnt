/*TASK TextReader*/
package TowaStandard;

import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.*;

//======================================================================================================================
public final class TextReaderX {

    //--------------------------------------------------------------------------------------------------------------
    public static String[] readAll( //
            //                                              //Carga la totalidad de un archivo de texto a memoria.

            //                                              //arrstr, archivo de texto en formato de arreglo de Strings.

            //                                              //File del archivo a cargar a memoría.
            FileX TextFile_M
    ) {
        if ( //
                TextFile_M == null //
                ) {
            Test.abort(Test.toLog(TextFile_M, "TextFile_M") + " can not be null");
        }

        //                                                  //Crea el syspath del directorio, esto solo para confirmar
        //                                                  //      que todo sigue bien y tener un mejor diagnóstico en
        //                                                  //      caso de problemas.
        Path syspathTextFile = TextFile_M.getPath();

        if ( //
                !syspathTextFile.isFile() //
                ) {
            Test.abort(Test.toLog(syspathTextFile.fullPath(), "syspathTextFile.FullPath") + " is not a file",
                    Test.toLog(TextFile_M, "TextFile_M"), Test.toLog(syspathTextFile, "syspathTextFile"));
        }

        Scanner systextreader = TextReaderX.newX(TextFile_M);

        //                                                  //Paso el archivo a memoria (un String).
        String strTextFile = TextReaderX.strReadAllLines(systextreader);

        //                                                  //Es necesaro cerrar el systextreader
        systextreader.close();

        //                                                  //Formo arreglo con lo leído.
        return Std.split(strTextFile, '\n');
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static String strReadAllLines( //
            //                                              //Reads the contents of a file and returns them in a string.

            Scanner TextReader_M
    ) {
        //                                                  //
        String strReadAllLines = "";
        while ( //
                TextReader_M.hasNextLine() //
                ) {

            //                                                  //Paso el archivo a memoria (un String).
            String strNextLine;
            try {
                strNextLine = TextReader_M.nextLine();

            } //
            catch (Exception sysexcepError) {
                Test.abort(Test.toLog(sysexcepError, "sysexcepError") + " error in \"TextReader_M.nextLine()\"",
                        Test.toLog(TextReader_M, "TextReader_M"));

                strNextLine = null;

                TextReader_M.close();
            }

            //                                              //Add line separator              
            strReadAllLines = strReadAllLines + ((strReadAllLines.length() == 0) ? "" : "\n") + strNextLine;
        }
        //                                                  //ESTO ES UN PARCHE FEO
        int int0 = 0;
        if ( //
                strReadAllLines.length() > 0 //
                ) {
            char char0 = strReadAllLines.charAt(0);
            int0 = (int) char0;
        }

        if ( //
                int0 == 65279 //
                ) {
            strReadAllLines = strReadAllLines.substring(1);
        }

        return strReadAllLines;
    }

    //--------------------------------------------------------------------------------------------------------------
    public static Scanner newX( //
            //                                              //Genera el Scanner para un archivo de texto, si no
            //                                              //      existe abortará.

            //                                              //systextreader, Scanner ready.

            //                                              //File del archivo.
            FileX TextFile_M
    ) {
        if ( //
                TextFile_M == null //
                ) {
            Test.abort(Test.toLog(TextFile_M, "TextFile_M") + " can not be null");
        }

        //                                                  //Confirma la existencia el archivo.
        Path syspathTextFile = TextFile_M.getPath();
        if ( //
                //                                          //No existe como archivo.
                !syspathTextFile.isFile() //
                ) {
            Test.abort(Test.toLog(syspathTextFile.fullPath(), "syspathTextFile.FullPath") + " file do not exist",
                    Test.toLog(TextFile_M, "TextFile_M"), Test.toLog(syspathTextFile, "syspathTextFile"));
        }

        String strCharsetName = TextReaderX.strCharsetName(TextFile_M);

        //                                                  //Creo el acceso al archivo.
        Scanner systextreaderNewTextReader;
        try {
            //                                              //Creo el stream reader con el charset necesario de acuerdo
            //                                              //      a su encoding.
            systextreaderNewTextReader = new Scanner(TextFile_M.z_TowaPrivate_fileordirThatIsAFile(), strCharsetName);
        } //
        catch (Exception sysexcepError) {
            Test.abort(
                    Test.toLog(sysexcepError, "sysexcepError")
                    + " error in \"new Scanner(TextFile_M, strCharsetName)\"",
                    Test.toLog(TextFile_M, "TextFile_M"), Test.toLog(strCharsetName, "strCharsetName"));

            systextreaderNewTextReader = null;
        }

        return systextreaderNewTextReader;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static String strCharsetName( //
            //                                              //Gets the adequate charset for a certain file by testing
            //                                              //      them one by one. Right now only 3 charset are
            //                                              //      tested.
            //                                              //The file from which the correct encoding must be found.
            FileX sysfileInputTextFile_M
    ) {
        //                                                  //The charset to be tested.
        String[] arrstrCharsetToBeTested = {"UTF-8", "ANSI", "windows-1252", "ISO-8859-7"};

        int intI = 0;
        /*REPEAT-WHILE*/
        while ( //
                //                                          //There are more charsets to be tested
                (intI < arrstrCharsetToBeTested.length)
                //                                          //The charset is not the correct one
                && (!boolCharsetIsCorrect(sysfileInputTextFile_M, arrstrCharsetToBeTested[intI])) //
                ) {
            intI = intI + 1;
        }

        int intX = (intI < arrstrCharsetToBeTested.length) ? intI : 0;

        //                                                  //(Glg 19Ago2018) REVISAR COMO FUNCIONA ESTO, el new
        //                                                  //      String("UTF-8").
        //                                                  //¿Porque esto no fue necesario en ReadAll?
        return new String(arrstrCharsetToBeTested[intX]);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static boolean boolCharsetIsCorrect( //
            //                                              //(Glg 19Ago2018) REVISAR
            //                                              //Test if a file has a specific charset.
            //                                              //The file from on which the charset will be tested.
            FileX sysfileInputTextFile_I,
            //                                              //Name of the charset to be tested.
            String strCharsetToTest_I
    ) {
        //                                                  //Indicate if the charset to be tested is the correct one
        //                                                  //      for the file.
        boolean boolCharsetIsCorrect = false;
        try {
            //                                              //Get the charset with the name.
            Charset charsetToTest = Charset.forName(strCharsetToTest_I);
            BufferedInputStream buffInput = 
                    new BufferedInputStream(new FileInputStream(sysfileInputTextFile_I.z_TowaPrivate_fileordirThatIsAFile()));

            CharsetDecoder charsetDecoder = charsetToTest.newDecoder();
            charsetDecoder.reset();

            byte[] buffer = new byte[512];

            /*REPEAT-WHILE*/
            while ( //
                    (buffInput.read(buffer) != -1)
                    && !boolCharsetIsCorrect //
                    ) {
                try {
                    charsetDecoder.decode(ByteBuffer.wrap(buffer));
                    boolCharsetIsCorrect = true;
                } //
                catch (CharacterCodingException e) {
                    boolCharsetIsCorrect = false;
                }
            }
            buffInput.close();
        } //
        catch (Exception e) {
            boolCharsetIsCorrect = false;
        }

        return boolCharsetIsCorrect;
    }

    //--------------------------------------------------------------------------------------------------------------
    public static String readLine( //
            //                                              //Leer una línea de texto.

            //                                              //str, Línea leída.

            //                                              //Scanner del archivo.
            Scanner TextReader_M
    ) {
        if ( //
                TextReader_M == null //
                ) {
            Test.abort(Test.toLog(TextReader_M, "TextReader_M") + " can not be null");
        }

        //                                                  //Leo una línea del archivo.
        String strReadLine;
        try {
            //                                              //Leo una línea.
            strReadLine = TextReader_M.nextLine();
        } //
        catch (Exception sysexcepError) {
            Test.abort(Test.toLog(sysexcepError, "sysexcepError") + " error in \"TextReader_M.v.nextLine()\"",
                    Test.toLog(TextReader_M, "TextReader_M"));

            strReadLine = null;

            TextReader_M.close();
        }

        return strReadLine;
    }

    //------------------------------------------------------------------------------------------------------------------
}
//======================================================================================================================
/*END-TASK*/
