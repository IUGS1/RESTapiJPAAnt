package TowaStandard;

import java.io.*;
import java.util.*;
import java.time.*;

//                                                          //AUTHOR: Towa (GLG-Gerardo López).
//                                                          //CO-AUTHOR: Towa ().
//                                                          //DATE: 19-Febrero-2014.
//
//======================================================================================================================
public class Path extends BsysBaseSystemAbstract implements Comparable {

    //                                                      //Clase para manipular path.
    //                                                      //Debe funcionar correctamente para archivos y directorios
    //                                                      //      locales y en la red.
    //                                                      //Nótese que estos objetos (syspath) solo son una referencia
    //                                                      //      a un archivo o directorio que están en disco (podría
    //                                                      //      ser una referencia que ni siquiera esta en el
    //                                                      //      disco).
    //                                                      //La información que recolecta solo es válida en el momento
    //                                                      //      de la construcción del objeto (Ej. en el momento de
    //                                                      //      la construcción podría ser una referencia a un
    //                                                      //      archivo que existe, sin embargo unos momento después
    //                                                      //      "alguién" borra del disco el archivo y el contenido
    //                                                      //      de este objeto syspath ya no es preciso).
    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/
    //                                                      //En teoria el conjunto de caracteres válidos en los path
    //                                                      //      names es muy extenso, sin embargo, en la realidad,
    //                                                      //      cuando se desea mover archivos y directorios entre
    //                                                      //      diferentes sistemas operativos (windows, unix, ios
    //                                                      //      de mac, etc.) suelen suceder problemas.
    //                                                      //Por estándar Towa optamos por permitir un conjunto MUY
    //                                                      //      CONSERVADOR DE CARACTERES.
    //                                                      //CONFORME ENTENDAMOS MEJOR ESTA PROBLEMATICA, ESTA LISTA
    //                                                      //      DE CARACTERES SERÁ AMPLIADA O RECORTADA.
    private static final String strCHAR_IN_PATH_NAME
            //                                              //Dígitos y letras sin acentos.
            = "0123456789" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz"
            //                                              //Espacio.
            + " "
            //                                              //GLG 27Feb2017, opte por incluir como posibilidad acentos
            //                                              //      en español y las Ñ ñ.
            + "ÁÉÍÓÚÜ" + "áéíóúü" + "Ññ"
            //                                              //Algunos caracteres especiales.
            + ",._()[]{}$@+-" + "%&#*";

    //                                                      //Información anterior en un arreglo ordenado.
    private static char[] arrcharIN_PATH_NAME;

    private static final String strCHAR_IN_NETWORK_NAME
            //                                              //Dígitos y letras sin acentos.
            //                                              //Estos caracteres deben ser un subconjunto de
            //                                              //      strCHAR_IN_PATH_NAME.
            = "0123456789" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";

    private static char[] arrcharIN_NETWORK_NAME;

    //                                                      //Podra ser : (windows), ¿ (IOS) o ??.
    //                                                      //(GLG.19Mar2018) EN REALIDAD AÚN NO ENTIENDO COMO ES ESTO
    //                                                      //      IOS O UNIX.
    public static final char VOLUME_SEPARATOR_CHAR = ':';

    //                                                      //Podra ser \\ (windows), // (IOS) o ??.
    //                                                      //(GLG.19Mar2018) EN REALIDAD AÚN NO ENTIENDO COMO ES ESTO
    //                                                      //      IOS O UNIX.
    public static String NETWORK_MARK = "" + File.separatorChar + File.separatorChar;

    //                                                      //Podra ser \ (windows), / (IOS) o ??
    public static char DIRECTORY_SEPARATOR_CHAR = File.separatorChar;

    //                                                      //String to be used as "neutral" volume mark.
    public static final char VOLUME_SEPARATOR_CHAR_MASKED = ':';

    //                                                      //String to be used as "neutral" network mark.
    public static final String NETWORK_MARK_MASKED = "■■";

    //                                                      //Character to be used as "neutral" directory separator.
    public static final char DIRECTORY_SEPARATOR_CHAR_MASKED = '▸';

    //                                                      //Requerido para varificar que los chars del full path sean
    //                                                      //      al menos válidos.
    private static char[] arrcharIN_FULLPATH;

    //------------------------------------------------------------------------------------------------------------------
    /*INITIALIZER*/
    //------------------------------------------------------------------------------------------------------------------
    static {
        //                                                  //Prepara las constantes.
        //                                                  //1. Prepara, verifica y ordena CHAR_IN_PATH_NAME.
        //                                                  //2. Prepara, verifica y ordena CHAR_IN_SERVER_NAME.
        //                                                  //3. Verifica charVOLUME_MARK, strNETWORK_MARK y
        //                                                  //      charDIRECTORY_SEPARATOR.
        //                                                  //4. Ordenar posibles caracteres en fullpath

        //                                                  //1. Prepara, verifica y ordena CHAR_IN_PATH_NAME.
        Path.arrcharIN_PATH_NAME = Path.strCHAR_IN_PATH_NAME.toCharArray();
        Arrays.sort(Path.arrcharIN_PATH_NAME);

        Test.abortIfDuplicate(Path.arrcharIN_PATH_NAME, "SyspathPath.arrcharIN_PATH_NAME");
        Test.abortIfOneOrMoreItemsAreNotInSortedSet(Path.arrcharIN_PATH_NAME,
                "SyspathPath.arrcharIN_PATH_NAME", Std.CHARS_USEFUL_IN_TEXT, "Std.arrcharUSEFUL_IN_TEXT");

        //                                                  //2. Prepara, verifica y ordena CHAR_IN_SERVER_NAME.
        Path.arrcharIN_NETWORK_NAME = Path.strCHAR_IN_NETWORK_NAME.toCharArray();
        Arrays.sort(Path.arrcharIN_NETWORK_NAME);

        Test.abortIfDuplicate(Path.arrcharIN_NETWORK_NAME, "SyspathPath.arrcharIN_SERVER_NAME");

        //                                                  //3. Verifica charVOLUME_MARK, strNETWORK_MARK y
        //                                                  //      charDIRECTORY_SEPARATOR
        Test.abortIfItemIsInSortedSet(Path.VOLUME_SEPARATOR_CHAR, "Path.VOLUME_SEPARATOR_CHAR",
                Path.arrcharIN_PATH_NAME, "arrcharIN_PATH_NAME");
        Test.abortIfOneOrMoreCharactersAreInSortedSet(Path.NETWORK_MARK, "Path.NETWORK_MARK", Path.arrcharIN_PATH_NAME,
                "arrcharIN_PATH_NAME");
        Test.abortIfItemIsInSortedSet(Path.DIRECTORY_SEPARATOR_CHAR, "Path.DIRECTORY_SEPARATOR_CHAR",
                Path.arrcharIN_PATH_NAME, "arrcharIN_PATH_NAME");
        Test.abortIfItemIsInSortedSet(Path.VOLUME_SEPARATOR_CHAR_MASKED, "Path.VOLUME_SEPARATOR_CHAR_MASKED",
                Path.arrcharIN_PATH_NAME, "arrcharIN_PATH_NAME");
        Test.abortIfOneOrMoreCharactersAreInSortedSet(Path.NETWORK_MARK_MASKED, "Path.NETWORK_MARK_MASKED",
                Path.arrcharIN_PATH_NAME, "arrcharIN_PATH_NAME");
        Test.abortIfItemIsInSortedSet(Path.DIRECTORY_SEPARATOR_CHAR_MASKED, "Path.DIRECTORY_SEPARATOR_CHAR_MASKED",
                Path.arrcharIN_PATH_NAME, "arrcharIN_PATH_NAME");

        //                                                  //4. Ordenar posibles caracteres en fullpath
        String strCHAR_IN_FULLPATH = Path.strCHAR_IN_PATH_NAME + Path.NETWORK_MARK
                + Path.VOLUME_SEPARATOR_CHAR + Path.DIRECTORY_SEPARATOR_CHAR;
        Path.arrcharIN_FULLPATH = strCHAR_IN_FULLPATH.toCharArray();
        Arrays.sort(arrcharIN_FULLPATH);
    }

    //------------------------------------------------------------------------------------------------------------------
    /*STATIC METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    public static String maskFullPath( //
            //                                              //Transform an OS specific full path to masked full path.
            //                                              //From: \\Abc\Xyz To: ■■Abc▸Xyz.
            //                                              //str, full path mask

            String FullPath_I
    ) {
        if ( //
                FullPath_I == null //
                ) {
            Test.abort(Test.toLog(FullPath_I, "strFullPath_I") + " can not be null");
        }

        String strFullPathOsToStd;

        String strRestOfOsFullPath;
        /*CASE*/
        if ( //
                (FullPath_I.length() >= 2) && (FullPath_I.charAt(1) == Path.VOLUME_SEPARATOR_CHAR) //
                ) {
            strFullPathOsToStd = "" + FullPath_I.charAt(0) + Path.VOLUME_SEPARATOR_CHAR_MASKED;

            strRestOfOsFullPath = FullPath_I.substring(2);
        } //
        else if ( //
                FullPath_I.startsWith(Path.NETWORK_MARK) //
                ) {
            strFullPathOsToStd = Path.NETWORK_MARK_MASKED;

            strRestOfOsFullPath = FullPath_I.substring(Path.NETWORK_MARK.length());
        } //
        else {
            //                                          //No se tiene volumen y esta en red.
            //                                          //Esto sucede al menos en Mac IOS.
            strFullPathOsToStd = "";

            strRestOfOsFullPath = FullPath_I;
        }
        /*END-CASE*/

        return strFullPathOsToStd
                + strRestOfOsFullPath.replace(Path.DIRECTORY_SEPARATOR_CHAR,
                        Path.DIRECTORY_SEPARATOR_CHAR_MASKED);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void subAbortIfRootAndFullPathIsInvalid( //
            //                                              //Aborta si Standard Root and FullPath es invalido.
            //                                              //Se podría usar el método para verificar que TODO sea
            //                                              //      válido, sin embargo el diagnóstico sería muy pobre.
            //                                              //Se opto por diagnosticar en cada una de las partes que
            //                                              //      componen el Standard Root and FullPath.

            String strRootAndFullPathToVerify_I,
            String strRoot_I
    ) {
        if ( //
                strRootAndFullPathToVerify_I == null //
                ) {
            Test.abort(Test.toLog(strRootAndFullPathToVerify_I, "strRootAndFullPathToVerify_I")
                    + " can not be null");
        }
        if ( //
                strRootAndFullPathToVerify_I.length() == 0 //
                ) {
            Test.abort(Test.toLog(strRootAndFullPathToVerify_I, "strRootAndFullPathToVerify_I")
                    + " has no characters");
        }
        if ( //
                strRoot_I == null //
                ) {
            Test.abort(Test.toLog(strRoot_I, "strRoot_I") + " can not be null");
        }
        if ( //
                strRoot_I.length() == 0 //
                ) {
            Test.abort(Test.toLog(strRoot_I, "strRoot_I") + " has no characters");
        }


        /*CASE*/
        if ( //
                (strRootAndFullPathToVerify_I.length() >= 2)
                && (strRootAndFullPathToVerify_I.charAt(1) == Path.VOLUME_SEPARATOR_CHAR) //
                ) {
            Path.subAbortIfVolumeAndFullPathIsInvalid(strRootAndFullPathToVerify_I);
        } //
        else if ( //
                strRootAndFullPathToVerify_I.startsWith(Path.NETWORK_MARK) //
                ) {
            Path.subAbortIfNetworkAndFullPathIsInvalid(strRootAndFullPathToVerify_I, strRoot_I);
        } //
        else {
            //                                          //No se tiene volumen ni esta en red.
            //                                          //Esto sucede al menos en Mac IOS.
            Path.subAbortIfFullPathIsInvalid(strRootAndFullPathToVerify_I);
        }
        /*END-CASE*/
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void subAbortIfVolumeAndFullPathIsInvalid( //
            //                                              //Aborta si Volume and FullPath es invalido.

            String strVolumeAndFullPathToVerify_I
    ) {
        String strVolume = strVolumeAndFullPathToVerify_I.substring(0, 2);

        if (!( //
                Path.boolIsVolumeValid(strVolume) //
                )) {
            Test.abort(Test.toLog(strVolume, "strVolume") + " Volume is invalid",
                    Test.toLog(strVolumeAndFullPathToVerify_I, "strVolumeAndFullPathToVerify_I"));
        }

        if ( //
                //                                      //Es el caso especial (c:\)
                strVolumeAndFullPathToVerify_I.length() == 3 //
                ) {
            if (!( //
                    strVolumeAndFullPathToVerify_I.charAt(2) == Path.DIRECTORY_SEPARATOR_CHAR //
                    )) {
                Test.abort(Test.toLog(strVolumeAndFullPathToVerify_I, "strVolumeAndFullPathToVerify_I")
                        + " should have the form c:" + Path.DIRECTORY_SEPARATOR_CHAR);
            }
        } //
        else {
            String strFullPath = strVolumeAndFullPathToVerify_I.substring(2);

            //SyspathPath.subAbortIfFullPathIsInvalid(strFullPath);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void subAbortIfNetworkAndFullPathIsInvalid( //
            //                                              //Aborta si Network and FullPath es invalido.

            String strNetworkAndFullPathToVerify_I,
            String strNetwork_I
    ) {
        Path.subAbortIfNetworkIsInvalid(strNetwork_I);

        String strFullPath = strNetworkAndFullPathToVerify_I.substring(strNetwork_I.length());

        //                                              //Si se tiene solo la raíz es valido
        if ( //
                strFullPath.length() > 0 //
                ) {
            Path.subAbortIfFullPathIsInvalid(strFullPath);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void subAbortIfNetworkIsInvalid( //
            //                                              //Aborta si Network es invalido.

            //                                              //Ej. \\psf\home
            String strNetwork_I
    ) {

        if (!( //
                strNetwork_I.startsWith(Path.NETWORK_MARK) //
                )) {
            Test.abort(Test.toLog(strNetwork_I, "strNetwork_I") + " do not start with network mark "
                    + Test.toLog(Path.NETWORK_MARK, "SyspathPath.strNETWORK_MARK"));
        }

        //                                          //Obtiene los nombres (ignora el primer separador)
        String str2Paths = strNetwork_I.substring(Path.NETWORK_MARK.length());
        String[] arrstrPath = Std.split(str2Paths, Path.DIRECTORY_SEPARATOR_CHAR);

        if ( //
                arrstrPath.length != 2 //
                ) {
            Test.abort(Test.toLog(strNetwork_I, "strNetwork_I") + " should have 2 parts");
        }

        Test.abortIfOneOrMoreCharactersAreNotInSortedSet(arrstrPath[0], "arrstrPath[0]", Path.arrcharIN_NETWORK_NAME,
                "arrcharIN_NETWORK_NAME");
        Test.abortIfOneOrMoreCharactersAreNotInSortedSet(arrstrPath[1], "arrstrPath[1]", Path.arrcharIN_NETWORK_NAME,
                "arrcharIN_NETWORK_NAME");
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void subAbortIfNoVolumeNoNetworkAndFullPathIsInvalid( //
            //                                              //Aborta si (no volumen, no network) and FullPath es
            //                                              //      invalido.

            String strNoVolumeNoNetworkAndFullPathToVerify_I
    ) {
        if ( //
                //                                          //Es el caso especial (/)
                strNoVolumeNoNetworkAndFullPathToVerify_I.length() == 1 //
                ) {
            if (!( //
                    strNoVolumeNoNetworkAndFullPathToVerify_I.charAt(0) == Path.DIRECTORY_SEPARATOR_CHAR //
                    )) {
                Test.abort(Test.toLog(strNoVolumeNoNetworkAndFullPathToVerify_I,
                        "strNoVolumeNoNetworkAndFullPathToVerify_I")
                        + " should have the form " + Path.DIRECTORY_SEPARATOR_CHAR);
            }
        } else {
            Path.subAbortIfFullPathIsInvalid(strNoVolumeNoNetworkAndFullPathToVerify_I);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static void subAbortIfFullPathIsInvalid(
            //                                              //Aborta si FullPath es invalido.

            String strFullPathToVerify_I
    ) {
        //                                                  //Verify first separator
        if (!( //
                (strFullPathToVerify_I.length() >= 1)
                && (strFullPathToVerify_I.charAt(0) == Path.DIRECTORY_SEPARATOR_CHAR) //
                )) {
            Test.abort(Test.toLog(strFullPathToVerify_I, "strFullPathToVerify_I") + " do not start with "
                    + Test.toLog(Path.DIRECTORY_SEPARATOR_CHAR, "SyspathPath.charDIRECTORY_SEPARATOR"));
        }

        //                                                  //Obtiene los nombres (ignora el primer separador)
        String strAllPathNames = strFullPathToVerify_I.substring(1);

        //                                                  //Puede no tener nombres, en cuyo caso no hay nada que
        //                                                  //      verificar
        if ( //
                strAllPathNames.length() > 0 //
                ) {
            String[] arrstrPathName = Std.split(strAllPathNames, Path.DIRECTORY_SEPARATOR_CHAR);

            for (int intI = 0; intI < arrstrPathName.length; intI = intI + 1) {
                if (!( //
                        Path.isPathNameValid(arrstrPathName[intI]) //
                        )) {
                    Test.abort(
                            Test.toLog(strFullPathToVerify_I, "strFullPathToVerify_I") + " is a not valid Name",
                            Test.toLog(arrstrPathName[intI], "arrstrPathName[" + intI + "]"),
                            Test.toLog(strAllPathNames, "strAllPathNames"));
                }
            }
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static boolean boolIsVolumeValid(
            //                                              //Verifica que el volumen (c:) sea válido.
            //                                              //bool, true es válido.

            //                                              //c: (should be only 2 chars)
            String strVolume_I
    ) {
        return ( //
                (strVolume_I.length() == 2) && Std.isLetter(strVolume_I.charAt(0))
                && (strVolume_I.charAt(1) == Path.VOLUME_SEPARATOR_CHAR) //
                );
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public static boolean isPathNameValid(
            //                                              //Verifica que el path name sea válido.
            //                                              //bool, true es válido.

            String PathNameToVerify_I
    ) {
        boolean boolIsPathNameValid = ( //
                PathNameToVerify_I.length() >= 1 //
                );

        if ( //
                boolIsPathNameValid //
                ) {
            int intI = 0;
            /*WHILE-UNTIL*/
            while (!( //
                    (intI >= PathNameToVerify_I.length())
                    || !Std.isInSortedSet(PathNameToVerify_I.charAt(intI), Path.arrcharIN_PATH_NAME) //
                    )) {
                intI = intI + 1;
            }

            boolIsPathNameValid = ( //
                    //                                      //All character are valid
                    intI >= PathNameToVerify_I.length() //
                    );
        }

        return boolIsPathNameValid;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*INSTANCE VARIABLES*/
    //                                                      //(Java) This File is required to compute somo other
    //                                                      //      variables.
    private final File sysxxxFileOrDirectory;

    //                                                      //Si es válido y se tiene acceso, contiene el Full Path.
    //                                                      //En su defecto, contiene el Path tal se proporciono y no
    //                                                      //      se deben tomar sus propiedades (aborta).
    //                                                      //Ejemplos:
    //                                                      //[
    //                                                      //c:\ (caso especial que es la raiz)
    //                                                      //c:\Abc
    //                                                      //c:\Abc\Xyz
    //                                                      //\\network\home
    //                                                      //\\network\home\Abc
    //                                                      //\\network\home\Abc\Xyz
    //                                                      //(ios, ¿unix, linus, etc?)
    //                                                      /// (caso especial que es la raiz)
    //                                                      ///Abc
    //                                                      ///Abc/Xyz
    //                                                      //]
    private final String strFullPath_Z;

    public String fullPath() {
        return this.strFullPath_Z;
    }

    //                                                      //ts del momento en que se construye este objeto.
    //                                                      //RECUERDESE que este es un syspath que puede o no
    //                                                      //      corresponder a un FILE o DIRECTORY que  existe.
    private final LocalDateTime dtCreationTime_Z;

    public LocalDateTime creationTime() {
        return this.dtCreationTime_Z;
    }

    //                                                      //syspath de la raíz.
    //                                                      //Ejemplos:
    //                                                      //[
    //                                                      //c:\
    //                                                      //\\network\home
    //                                                      /// (ios, ¿unix, linus, etc?)
    //                                                      //]
    private final String strRoot_Z;

    public String root() {
        return this.strRoot_Z;
    }

    //                                                      //DO_NOT_EXIST_ON_DISK, DIRECTORY, FILE or ROOT
    private final PathTypeEnum syspathtype_Z;

    public PathTypeEnum pathType() {
        return this.syspathtype_Z;
    }

    /*(20Mar2018, GLG) SE ELIMINA, POSIBLEMENTE LO REGRESE CUANDO ENTIENDA COMO FUNCIONA ESTO
        //                                                  //Determina si se tiene acceso a un Nombre, Path o Full Path
        //                                                  //      (File or Directory).
        //                                                  //Se utiliza Path.GetFullPath(strFileName_I) para
        //                                                  //      verificarlo.
        //                                                  //Si recibe un SecurityException indica que no tiene acceso.
        //                                                  //El path debe ser válido.
        private readonly boolean boolHaveAccessTo_Z;
        public boolean boolHaveAccessTo { get { return this.boolHaveAccessTo_Z; } }
     */
    //                                                      //LOCAL o NETWORK.
    //                                                      //\\psf\home que es como parallels accesa la información
    //                                                      //      LOCAL que esta en Mac IOS será registrada como 
    //                                                      //      LOCAL.
    //                                                      //Nótese que esto causa que se tenga path \\psf (que parece
    //                                                      //      ser NETWORK) que será LOCAL.
    private final PathWhereEnum syspathwhere_Z;

    public PathWhereEnum pathWhere() {
        return this.syspathwhere_Z;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*COMPUTED VARIABLES*/
    //                                                      //Es un Full Path local (esta en este equipo).
    private Boolean boolnIsLocal_Z = null;

    public boolean isLocal() {
        if ( //
                this.boolnIsLocal_Z == null //
                ) {
            this.boolnIsLocal_Z = ( //
                    this.pathWhere() == PathWhereEnum.LOCAL //
                    );
        }

        return (boolean) this.boolnIsLocal_Z;
    }

    //                                                      //Es un Full Path que esta en red.
    private Boolean boolnIsNetwork_Z = null;

    public boolean isNetwork() {
        if ( //
                this.boolnIsNetwork_Z == null //
                ) {
            this.boolnIsNetwork_Z = ( //
                    this.pathWhere() == PathWhereEnum.NETWORK //
                    );
        }

        return (boolean) this.boolnIsNetwork_Z;
    }

    //                                                      //Corresponde a un File o Directory que existe.
    private Boolean boolnExists_Z = null;

    public boolean exists() {
        if ( //
                this.boolnExists_Z == null //
                ) {
            this.boolnExists_Z = ( //
                    this.pathType() != PathTypeEnum.DO_NOT_EXIST_ON_DISK //
                    );
        }

        return (boolean) this.boolnExists_Z;
    }

    //                                                      //Es un Directory.
    private Boolean boolnIsDirectory_Z = null;

    public boolean isDirectory() {
        if ( //
                this.boolnIsDirectory_Z == null //
                ) {
            this.boolnIsDirectory_Z = ( //
                    this.pathType() == PathTypeEnum.DIRECTORY //
                    );
        }

        return (boolean) this.boolnIsDirectory_Z;
    }

    //                                                      //Es un File.
    private Boolean boolnIsFile_Z = null;

    public boolean isFile() {
        if ( //
                this.boolnIsFile_Z == null //
                ) {
            this.boolnIsFile_Z = ( //
                    this.pathType() == PathTypeEnum.FILE //
                    );
        }

        return (boolean) this.boolnIsFile_Z;
    }

    //                                                      //Es un Root Directory.
    private Boolean boolnIsRoot_Z = null;

    public boolean isRoot() {
        if ( //
                this.boolnIsRoot_Z == null //
                ) {
            this.boolnIsRoot_Z = ( //
                    this.pathType() == PathTypeEnum.ROOT //
                    );
        }

        return (boolean) this.boolnIsRoot_Z;
    }

    //                                                      //Nombre del archivo o directorio (sin el directorio que lo
    //                                                      //      contiene).
    //                                                      //Can not be root.
    private String strName_Z = null;

    public String name() {
        if ( //
                this.strName_Z == null //
                ) {
            if ( //
                    this.pathType() == PathTypeEnum.ROOT //
                    ) {
                Test.abort(Test.toLog(this.pathType(), "PathType") + " do not have Name", Test.toLog(this, "this"));
            }

            this.strName_Z = this.sysxxxFileOrDirectory.getName();
        }

        return this.strName_Z;
    }

    //                                                      //SOLO SI ES UN FILE O AUN NO EXISTE.
    //                                                      //Si se solicitan cuando es un directorio va a abortar.
    //                                                      //File extension.
    private String strFileExtension_Z = null;

    public String fileExtension() {
        if ( //
                this.strFileExtension_Z == null //
                ) {
            if ( //
                    this.isDirectory() //
                    ) {
                Test.abort(Test.toLog(this.pathType(), "PathType") + " should be a FILE", Test.toLog(this, "this"));
            }

            String strFileName = this.name();
            int intDot = strFileName.lastIndexOf('.');
            if ( //
                    //                                      //Do not have file extension
                    intDot < 0 //
                    ) {
                this.strFileExtension_Z = "";
            } //
            else {
                this.strFileExtension_Z = strFileName.substring(intDot);
            }
        }

        return this.strFileExtension_Z;
    }

    //                                                      //Nombre sin el file extensión.
    private String strFileNameWithoutExtension_Z = null;

    public String fileNameWithoutExtension() {
        if ( //
                this.strFileNameWithoutExtension_Z == null //
                ) {
            if ( //
                    !this.isFile() //
                    ) {
                Test.abort(Test.toLog(this.pathType(), "PathType") + " should be a FILE", Test.toLog(this, "this"));
            }

            String strFileName = this.name();
            String strFileExtension = this.fileExtension();

            this.strFileNameWithoutExtension_Z = strFileName.substring(0,
                    strFileName.length() - strFileExtension.length());
        }

        return this.strFileNameWithoutExtension_Z;
    }

    private String strFullPathMasked_Z = null;

    public String fullPathMasked() {
        if ( //
                this.strFullPathMasked_Z == null //
                ) {
            this.strFullPathMasked_Z = Test.z_TowaPRIVATE_FullPathAsIsOrMasked(this);
        }

        return this.strFullPathMasked_Z;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*SUPPORT METHODS FOR COMPUTED VARIABLES*/
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toLogShort() {
        return "<" + Test.toLog(this.name()) + ", " + Test.toLog(this.creationTime()) + ", "
                + Test.toLog(Test.z_TowaPRIVATE_FullPathAsIsOrMasked(new Path(this.root()))) + ", "
                + Test.toLog(this.pathType()) + ", " + Test.toLog(this.pathWhere()) + ">";
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public String toLogFull() {
        return "<" + Test.toLog(Test.z_TowaPRIVATE_FullPathAsIsOrMasked(this), "FullPath") + ", "
                + Test.toLog(this.creationTime(), "CreationTime") + ", "
                + Test.toLog(Test.z_TowaPRIVATE_FullPathAsIsOrMasked(new Path(this.root())), "Root") + ", "
                + Test.toLog(this.pathType(), "PathType") + ", " + Test.toLog(this.pathWhere(), "PathWhere") + ">";
    }

    //------------------------------------------------------------------------------------------------------------------
    /*OBJECT CONSTRUCTORS*/
    //------------------------------------------------------------------------------------------------------------------
    public Path(
            //                                              //Crea un objeto Path.
            //                                              //this.*[O], asigna valores.

            //                                              //OS full paht (con :, /, \, ?)
            String FullPath_I
    ) {
        super();

        Test.abortIfNull(FullPath_I, "FullPath_I");

        Test.abortIfOneOrMoreCharactersAreNotInSortedSet(FullPath_I, "FullPath_I", Path.arrcharIN_FULLPATH,
                "SyspathPath.arrcharIN_FULLPATH");

        //                                                  //(Java) Required to compute somo other variables.
        this.sysxxxFileOrDirectory = new File(FullPath_I);

        this.strFullPath_Z = FullPath_I;

        this.dtCreationTime_Z = Std.dtGetNow();

        this.strRoot_Z = this.strRootGet();

        this.syspathtype_Z = this.syspathtypeGet();

        this.syspathwhere_Z = this.syspathwhereGet();

        //                                                  //Nótese que se construyo con la información que tenía.
        //                                                  //Aborta si no es válido.
        Path.subAbortIfRootAndFullPathIsInvalid(this.fullPath(), this.root());
    }

    //------------------------------------------------------------------------------------------------------------------
    /*SUPPORT METHODS FOR CONSTRUCTORS*/
    //------------------------------------------------------------------------------------------------------------------
    private String strRootGet( //
            //                                              //Calcula el strRot.
            //                                              //Puede tener la forma: "a:" o "\\xxx\yyy"
            //                                              //this[I], acces info.
            ) {
        //                                                  //To easy code
        String strFullPath = this.fullPath();

        String strRootGet;
        /*CASE*/
        if ( //
                Std.isLetter(strFullPath.charAt(0)) && (strFullPath.charAt(1) == ':') // 
                ) {
            strRootGet = strFullPath.substring(0, 2);
        } //
        else if ( //
                strFullPath.startsWith(Path.NETWORK_MARK) //
                ) {
            //                                              //The opcions are:
            //                                              //"\\xxxx\yyyy" ==> "\\xxxx\yyyy"
            //                                              //"\\xxxx\yyyy\????" ==> "\\xxxx\yyyy"

            //                                              //Find "\yyyy????" or 
            int intSlashYyyy = strFullPath.indexOf(Path.DIRECTORY_SEPARATOR_CHAR, Path.NETWORK_MARK.length());

            //                                              //Find end or "\????"
            int intSlash = strFullPath.indexOf(Path.DIRECTORY_SEPARATOR_CHAR, intSlashYyyy + 1);

            strRootGet = (intSlash < 0) ? strFullPath : strFullPath.substring(0, intSlash);
        } //
        else {
            Test.abort(Test.toLog(this.fullPath(), "this.FullPath") + " SOMETHING IS WRONG, WE COULD NOT GET ROOT");

            strRootGet = null;
        }
        /*END-CASE*/

        return strRootGet;

        /*THIS CODE WAS CANCELED: July 1, 2018 (GLG)
        File[] arrsysdirRoot = File.listRoots();

        //                                                  //La posibles raices deben ser ordenadas, de mayor a menor,
        //                                                  //      por la longitud de su strFullParh para identificar
        //                                                  //      primero el de mayor longitud.
        Integer[] arrintMinusFullPathLength = new Integer[arrsysdirRoot.length];
        for (int intI = 0; intI < arrsysdirRoot.length; intI = intI + 1) {
            arrintMinusFullPathLength[intI] = -arrsysdirRoot[intI].getPath().length();
        }
        Std.sort(arrintMinusFullPathLength, arrsysdirRoot);

        //                                                  //Localiza el Root que corresponda
        int intX = 0;
        /*UNTIL-DO* /
        if (!( //
                this.strFullPath().startsWith(arrsysdirRoot[intX].getPath()) //
                )) {
            intX = intX + 1;
        }

        return arrsysdirRoot[intX].getPath();
         */
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private PathTypeEnum syspathtypeGet( //
            //                                              //Calcula el syspathtype (DIRECTORY, FILE or
            //                                              //      DO_NOT_EXIST_ON_DISK).
            //                                              //this[I], acces info.
            ) {
        //
        PathTypeEnum syspathtypeGet;
        /*CASE*/
        if ( //
                //                                          //Reconoce como directorio.
                this.sysxxxFileOrDirectory.isDirectory() //
                ) {
            syspathtypeGet
                    = (this.fullPath().toLowerCase().equals(this.root().toLowerCase())) ? PathTypeEnum.ROOT
                    : PathTypeEnum.DIRECTORY;
        } //
        else if ( //
                //                                          //Reconoce como archivo.
                this.sysxxxFileOrDirectory.isFile() //
                ) {
            syspathtypeGet = PathTypeEnum.FILE;
        } //
        else {
            syspathtypeGet = PathTypeEnum.DO_NOT_EXIST_ON_DISK;
        }
        /*END-CASE*/

        return syspathtypeGet;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private PathWhereEnum syspathwhereGet( //
            //                                              //Calcula el syspathwhere (LOCAL or NETWORK).
            //                                              //this[I], acces info.
            ) {
        //                                                  //\\psf\Home
        String strPARALLELS_PSF = "\\\\psf\\Home";

        PathWhereEnum syspathwhereGet;
        /*CASE*/
        if ( //
                (this.fullPath().length() >= 2)
                && (this.fullPath().charAt(1) == Path.VOLUME_SEPARATOR_CHAR) //
                ) {
            syspathwhereGet = PathWhereEnum.LOCAL;
        } //
        else if ( //
                this.fullPath().startsWith(Path.NETWORK_MARK) //
                ) {
            syspathwhereGet
                    = (this.root().compareToIgnoreCase(strPARALLELS_PSF) == 0) ? PathWhereEnum.LOCAL
                    : PathWhereEnum.NETWORK;
        } //
        else {
            //                                              //No tiene volumen ni network (Ej /....)
            syspathwhereGet = PathWhereEnum.LOCAL;
        }
        /*END-CASE*/

        return syspathwhereGet;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*TRANSFORMATION METHODS*/
    //
    //------------------------------------------------------------------------------------------------------------------
    /*ACCESS METHODS*/
    //
    //------------------------------------------------------------------------------------------------------------------
    public Path addName(
            //                                              //Genera OTRO syspath añadiendo un nombre a un syspath de un
            //                                              //      directorio.
            //                                              //this[I], debe ser un directorio, toma información.

            //                                              //syspath, nuevo syspath ya combinado.

            //                                              //Nombre a combinar con el path del this.
            String NameToAdd_I
    ) {
        if (!( //
                this.isDirectory() || this.isRoot()//
                )) {
            Test.abort(Test.toLog(this.pathType(), "PathType") + " should be DIRECTORY or ROOT",
                    Test.toLog(this, "this"));
        }
        if (!( //
                Path.isPathNameValid(NameToAdd_I) //
                )) {
            Test.abort(Test.toLog(NameToAdd_I, "strNameToAdd_I") + " is not valid");
        }

        //                                                  //En algunos caso no requiere otro separador
        String strFullPathPlusName = this.fullPath();
        if ( //
                this.fullPath().charAt(this.fullPath().length() - 1) == Path.DIRECTORY_SEPARATOR_CHAR //
                ) {
            //                                              //No hace nada, no se requiere otro separador
        } //
        else {
            strFullPathPlusName = strFullPathPlusName + Path.DIRECTORY_SEPARATOR_CHAR;
        }
        strFullPathPlusName = strFullPathPlusName + NameToAdd_I;

        //                                                  //Regresa la combinación.
        return new Path(strFullPathPlusName);
    }

    //--------------------------------------------------------------------------------------------------------------
    public Path getDirectoryPath( //
            //                                              //Genera OTRO syspath con el directorio que contiene el
            //                                              //      syspath.
            //                                              //this[I], can not be root.
            ) {
        if ( //
                this.isRoot() //
                ) {
            Test.abort(Test.toLog(this, "this")
                    + " is a Root Directory, can not get its directory");
        }

        return new Path(this.sysxxxFileOrDirectory.getParent());
    }

    //------------------------------------------------------------------------------------------------------------------
    public boolean isDirectoyIncludedInPath(
            //                                              //Determina si un directorio esta incluido en otro path.
            //                                              //Esta incluido, si:
            //                                              //1. Ambos son el mismo directorio.
            //                                              //2. En el padre que contiene el path (ya sea un file u otro
            //                                              //      directorio.
            //                                              //3. El path esta contenido en el directorio a cualquier
            //                                              //      nivel.
            //                                              //true, si esta incluido.

            //                                              //this, info del objeto

            //                                              //Para verificar si esta contenido.
            Path DirectoryPath_L
    ) {
        if (!( //
                DirectoryPath_L.isDirectory() || DirectoryPath_L.isRoot()//
                )) {
            Test.abort(
                    Test.toLog(DirectoryPath_L.pathType(), "DirectoryPath_L.PathType") + " should be DIRECTORY or ROOT",
                    Test.toLog(this, "this"), Test.toLog(DirectoryPath_L, "DirectoryPath_L"));
        }

        String strThisFullPathLower = this.fullPath().toLowerCase();
        String strDirectoryFullPathLower = DirectoryPath_L.fullPath().toLowerCase();

        return (strThisFullPathLower.equals(strDirectoryFullPathLower)
                //                                          //Tiene la forms: Directory\...
                || strThisFullPathLower.startsWith(strDirectoryFullPathLower)
                && (strThisFullPathLower.charAt(strDirectoryFullPathLower.length()) == Path.DIRECTORY_SEPARATOR_CHAR));
    }

    //------------------------------------------------------------------------------------------------------------------
    public String restOfPath(
            //                                              //Extrae lo que queda del path al quitarle del principio el
            //                                              //      path de un directorio que lo contiene.
            //                                              //Ej, tengo path que contiene  "C:/DirA/DirB/DirC/DirOFile",
            //                                              //      al cual que quiero quitar "C:/DirA/DirB", el
            //                                              //      resultado será el string "/DirC/DirOFile".
            //                                              //str, (Ej. "/DirC/DirOFile").

            //                                              //this, info del objeto

            Path syspathDirectoryContainingThisPath_I
    ) {
        if (!( //
                this.isDirectoyIncludedInPath(syspathDirectoryContainingThisPath_I) //
                )) {
            Test.abort(
                    Test.toLog(syspathDirectoryContainingThisPath_I, "syspathDirectoryContainingThisPath_I")
                    + " IS NOT contained in " + Test.toLog(this, "this"));
        }

        return this.fullPath().substring(syspathDirectoryContainingThisPath_I.fullPath().length());
    }

    //------------------------------------------------------------------------------------------------------------------
    public String maskRestOfPath(
            //                                              //Igual a strRestOfPath pero masked si esta con
            //                                              //      comparable log.
            //                                              //str, (Ej. "▸DirC▸DirOFile").

            //                                              //this, info del objeto

            Path DirectoryContainingThisPath_I
    ) {
        String strMaskRestOfPath = this.restOfPath(DirectoryContainingThisPath_I);

        if ( //
                Test.z_TowaPRIVATE_boolIsComparableLog() //
                ) {
            strMaskRestOfPath = strMaskRestOfPath.replace(Path.DIRECTORY_SEPARATOR_CHAR,
                    Path.DIRECTORY_SEPARATOR_CHAR_MASKED);
        }

        return strMaskRestOfPath;
    }

    //------------------------------------------------------------------------------------------------------------------
    public int compareTo(
            //                                              //Required for sort, BinarySearch and CompareTo.

            //                                              //this[I], object key info.

            //                                              //syspath or str
            Object obj_I
    ) {
        String strFullPathToCompare;
        /*CASE*/
        if ( //
                obj_I instanceof Path //
                ) {
            strFullPathToCompare = ((Path) obj_I).fullPath();;
        } //
        else if ( //
                obj_I instanceof String //
                ) {
            strFullPathToCompare = (String) obj_I;
        } //
        else {
            Test.abort(
                    Test.toLog(obj_I.getClass(), "obj_I.type")
                    + " is not a compatible CompareTo argument, the options are: syspath & str",
                    Test.toLog(this.getClass(), "this.type"));

            strFullPathToCompare = null;
        }
        /*END-CASE*/

        return this.fullPath().compareToIgnoreCase(strFullPathToCompare);
    }

    //------------------------------------------------------------------------------------------------------------------
}

//======================================================================================================================
/*END-TASK*/
