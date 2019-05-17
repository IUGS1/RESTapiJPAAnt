/*TASK TextWriter*/
package TowaStandard;

import java.io.*;
import java.util.*;

//======================================================================================================================
public final class TextWriterX {

    //------------------------------------------------------------------------------------------------------------------
    public static void writeAll( //
            //                                              //Sube la totalidad de un arreglo en memoria a un archivo
            //                                              //      de texto (puede o no existir el archivo).

            //                                              //File del archivo a al cual se sube lo que se tiene en
            //                                              //      memoría.
            FileX TextFile_M,
            //                                              //arrstr, archivo de texto en formato de arreglo de Strings.
            String[] SetOfLines_I
    ) {
        if ( //
                TextFile_M == null //
                ) {
            Test.abort(Test.toLog(TextFile_M, "TextFile_M") + " can not be null");
        }

        if ( //
                SetOfLines_I == null //
                ) {
            Test.abort(Test.toLog(SetOfLines_I, "SetOfLines_I") + " can not be null");
        }

        //                                                  //Tomo el path para analizarlo y poder dar un mejor
        //                                                  //      diagnostico.
        Path syspathTextFile = TextFile_M.getPath();
        if ( //
                syspathTextFile.isDirectory()//
                ) {
            Test.abort(
                    Test.toLog(syspathTextFile.fullPath(), "syspathTextFile.FullPath") + " exists as DIRECTORY",
                    Test.toLog(TextFile_M, "TextFile_M"), Test.toLog(syspathTextFile, "syspathTextFile"));
        }

        //                                                  //Creo el stream writer.
        PrintWriter systextwriter = TextWriterX.newX(TextFile_M);

        //                                                  //Paso todo el arreglo a un solo String de líneas.
        String strTextFile = String.join("\n", SetOfLines_I);

        //                                                  //Escribo el String al archivo (un solo WriteLine).
        TextWriterX.writeLine(strTextFile, systextwriter);

        //                                                  //Es necesaro cerrar el systextwriter
        systextwriter.close();
    }

    //--------------------------------------------------------------------------------------------------------------
    public static PrintWriter newX( //
            //                                              //Genera el StreamWriter para un archivo de texto (puede ser
            //                                              //      para para escritura o reescritura, no importa si ya
            //                                              //      existía o no.

            //                                              //systextwriter, StreamWriter ready.

            //                                              //FileInfo del archivo.
            FileX TextFile_M
    ) {
        if ( //
                TextFile_M == null //
                ) {
            Test.abort(Test.toLog(TextFile_M, "TextFile_M") + " can not be null");
        }

        Path syspathTextFile = TextFile_M.getPath();
        if ( //
                syspathTextFile.isDirectory()//
                ) {
            Test.abort(
                    Test.toLog(syspathTextFile.fullPath(), "syspathTextFile.FullPath") + " exists as DIRECTORY",
                    Test.toLog(TextFile_M, "TextFile_M"), Test.toLog(syspathTextFile, "syspathTextFile"));
        }

        //                                                  //Creo el acceso al archivo.
        PrintWriter systextwriterNew;
        try {
            //                                              //Creo el stream reader.
            systextwriterNew = new PrintWriter(TextFile_M.z_TowaPrivate_fileordirThatIsAFile());
        } //
        catch (Exception sysexcepError) {
            Test.abort(Test.toLog(sysexcepError, "sysexcepError") + " error in \"new PrintWriter(TextFile_M)\"",
                    Test.toLog(syspathTextFile, "syspathTextFile"));

            systextwriterNew = null;
        }

        return systextwriterNew;
    }

    //--------------------------------------------------------------------------------------------------------------
    public static void writeLine( //
            //                                              //Escribe una línea de texto.
            //                                              //Solo son válidos los caracteres USEFUL_IN_TEXT y ESCAPE.
            //                                              //Antes se validaba que todo caracter fuera menor a 
            //                                              //  '\uD7FF' pero se cambio a la condición actual
            //                                              //Linea que se va a escribir.
            String Line_I,
            //                                              //FileWriter del archivo.
            PrintWriter TextWriter_M
    ) {
        if ( //
                Line_I == null //
                ) {
            Test.abort(Test.toLog(Line_I, "Line_I") + " can not be null");
        }

        if ( //
                TextWriter_M == null //
                ) {
            Test.abort(Test.toLog(TextWriter_M, "TextWriter_M") + " can not be null");
        }

        //                                                  //Un caracter para ser válido debe estar en USEFUL o ESCAPE
        for (int intC = 0; intC < Line_I.length(); intC = intC + 1) {
            //                                              //To easy code
            char charX = Line_I.charAt(intC);

            if (!( //
                    (Arrays.binarySearch(Std.CHARS_USEFUL_IN_TEXT, charX) >= 0)
                    || (Arrays.binarySearch(Std.arrt2charESCAPE, charX) >= 0) //
                    )) {
                Test.abort(Test.toLog(Line_I.charAt(intC), "Line_I[" + intC + "]") + " is a nonvalid character");
                //Line_I[256](x)
            }
        }

        //                                                  //Escribe una línea en el archivo.
        try {
            //                                              //Escribo una línea.
            TextWriter_M.println(Line_I);
        } //
        catch (Exception sysexcepError) {
            Test.abort(
                    Test.toLog(sysexcepError, "sysexcepError") + " error in \"TextWriter_M.println(Line_I);\"",
                    Test.toLog(TextWriter_M, "TextWriter_M"), Test.toLog(Line_I, "Line_I"));

            TextWriter_M.close();
        }
    }

    //------------------------------------------------------------------------------------------------------------------
}
//======================================================================================================================
/*END-TASK*/
