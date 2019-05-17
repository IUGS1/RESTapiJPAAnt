package TowaStandard;

import java.util.Scanner;
import java.nio.file.*;
import java.nio.file.attribute.*;

//                                                          //AUTHOR: Towa (IDL-Iñaki de Atela).
//                                                          //CO-AUTHOR: Towa (GLG-Gerardo López).
//                                                          //DATE: October 27, 2018.
//
//======================================================================================================================
public class FileX extends BsysBaseSystemAbstract {

    //                                                      //Clase para manipular files.    
    //                                                      //Debe funcionar correctamente para archivos locales y en la
    //                                                      //      red.
    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/
    //------------------------------------------------------------------------------------------------------------------
    /*INITIALIZER*/
    //------------------------------------------------------------------------------------------------------------------
    static {
    }

    //------------------------------------------------------------------------------------------------------------------
    /*INSTANCE VARIABLES*/
    //                                                      //(Java) This File is required to compute some other
    //                                                      //      variables.
    private java.io.File fileordirThatIsAFile_Z;

    public java.io.File z_TowaPrivate_fileordirThatIsAFile() {
        return this.fileordirThatIsAFile_Z;
    }

    //------------------------------------------------------------------------------------------------------------------
    private BasicFileAttributes bfaGet( //
            //                                              //Method required to get attributes from disk
            ) {
        BasicFileAttributes bfaGet;
        try {
            bfaGet = Files.readAttributes(Paths.get(this.z_TowaPrivate_fileordirThatIsAFile().getPath()),
                    BasicFileAttributes.class);

        } catch (java.io.IOException sysexcepError) {
            Test.abort(Test.toLog(sysexcepError, "sysexcepError") + " error in Files.readAttributes(...);");

            bfaGet = null;
        }

        return bfaGet;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*COMPUTED VARIABLES*/

    public String name() {
        return this.fileordirThatIsAFile_Z.getName();
    }
    
    public String fullPath() {
        return this.fileordirThatIsAFile_Z.getPath();
    }

    public Path getPath() {
        String strFullPath = this.fileordirThatIsAFile_Z.getPath();
        return new Path(strFullPath);
    }

    //------------------------------------------------------------------------------------------------------------------
    /*SUPPORT METHODS FOR COMPUTED VARIABLES*/
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toLogShort() {
        String toLogShort = "<Name(" + this.z_TowaPrivate_fileordirThatIsAFile().getName() + "), "
                + Test.toLog(this.z_TowaPrivate_fileordirThatIsAFile().exists());

        if ( //
                this.z_TowaPrivate_fileordirThatIsAFile().exists() //
                ) {
            //********* PENDIENTE, los tiempos aquí mostrados deberán ser convertidos a ztime cuando este terminado
            BasicFileAttributes bfa = this.bfaGet();
            toLogShort = toLogShort + ", " + Test.toLog(bfa.creationTime().toString()) + ", " + ", "
                    + Test.toLog(bfa.lastModifiedTime().toString());
        }

        toLogShort = toLogShort + ">";

        return toLogShort;

    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public String toLogFull() {

        String toLogFull = "<FullName(" + Test.toLog(this.getPath()) + "), " + Test.toLog(this.exists(), "Exists");

        if ( //
                this.exists() //
                ) {
            //********* PENDIENTE, los tiempos aquí mostrados deberán ser convertidos a ztime cuando este terminado
            BasicFileAttributes bfa = this.bfaGet();
            toLogFull = toLogFull + ", " + Test.toLog(this.length(), "Length") + ", "
                    + Test.toLog(bfa.creationTime().toString(), "CreationTime") + ", "
                    + Test.toLog(bfa.lastModifiedTime().toString(), "LastWriteTime");
        }

        toLogFull = toLogFull + ">";

        return toLogFull;

    }

    //------------------------------------------------------------------------------------------------------------------
    /*OBJECT CONSTRUCTORS*/
    //------------------------------------------------------------------------------------------------------------------
    public FileX( //
            //                                              //Crea un File, el archivo puede no existir.

            //                                              //Path (completo y válido) del archivo a crear.
            Path filePath_I
    ) {
        super();

        if ( //
                filePath_I.isDirectory() //
                ) { 
            Test.abort(filePath_I.name() + " can not be a Directory", Test.toLog(filePath_I, "filePath_I"));
        }
        
        try {
            this.fileordirThatIsAFile_Z = new java.io.File(filePath_I.fullPath());
        } //
        catch (Exception sysexcepError) {
            Test.abort(Test.toLog(sysexcepError, "sysexcepError") + " error in \"new File(filePath_I.FullPath())\"",
                    Test.toLog(filePath_I, "FilePath_I"));

            this.fileordirThatIsAFile_Z = null;
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public FileX( //
            //                                              //Crea un File, el archivo puede no existir.

            //                                              //File that is a File (not a directory).
            java.io.File z_TowaPRIVARTE_fileordirThatIsAFile_I
    ) {
        super();

        this.fileordirThatIsAFile_Z = z_TowaPRIVARTE_fileordirThatIsAFile_I;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*TRANSFORMATION METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    public void renameOnDisk( //
            //                                              //Modifica el nombre de un file

            //                                              //Nuevo nombre del file (sin el path).
            String newName_I
    ) {
        if ( //
                !Path.isPathNameValid(newName_I) //
                ) {
            Test.abort(Test.toLog(newName_I, "newName_I") + " is not valid");
        }

        //                                                  //Crea el syspath del file, esto solo para confirmar
        //                                                  //      que todo sigue bien y tener un mejor diagnóstico en
        //                                                  //      caso de problemas.
        Path syspathFile = this.getPath();
        if ( //
                !syspathFile.isFile() //
                ) { 
            Test.abort(Test.toLog(syspathFile.name(), "syspathFile.name()") + " is not a File", 
                    Test.toLog(syspathFile, "syspathFile"));
        }

        if ( //
                newName_I.equals(this.name()) //
                ) {
            Test.abort(Test.toLog(syspathFile.name(), "syspathFile.name()") + " & "
                    + Test.toLog(newName_I, "newName_I") + " both are the same name, can not rename",
                    Test.toLog(syspathFile, "syspathFile"));
        }

        //                                                  //Crea el nuevo path para confirmar que su forma es válida.
        Path syspathFileRanamed = syspathFile.getDirectoryPath().addName(newName_I);

        if ( //
                //                                              //Verifica que no exista un archivo o directorio con el
                //                                              //       mismo nombre.
                syspathFileRanamed.exists() //
                ) {
            Test.abort(Test.toLog(newName_I, "newName_I") + " already exists",
                    Test.toLog(syspathFileRanamed, "syspathFileRanamed"));
        }

        //                                                  //Nótese que ya se hicieron muchas verificaciones para hacer
        //                                                  //      esto en forma segura.
        java.io.File fileordirThatIsAFileRenamed;
        try {
            fileordirThatIsAFileRenamed = new java.io.File(syspathFileRanamed.fullPath());
        } //
        catch (Exception sysexcepError) {
            Test.abort(
                    Test.toLog(sysexcepError, "sysexcepError")
                    + " error in \"new java.io.File(syspathFileRanamed.fullPath()\"",
                    Test.toLog(this.z_TowaPrivate_fileordirThatIsAFile().getPath(), 
                            "this.z_TowaPrivate_fileordirThatIsAFile().getPath()"),
                    Test.toLog(syspathFileRanamed.fullPath(), "syspathFileRanamed.fullPath()"));
            
            fileordirThatIsAFileRenamed = null;
        }

        try {
            this.z_TowaPrivate_fileordirThatIsAFile().renameTo(fileordirThatIsAFileRenamed);
        } //
        catch (Exception sysexcepError) {
            Test.abort(
                    Test.toLog(sysexcepError, "sysexcepError")
                    + " error in \"this.z_TowaPrivate_fileordirThatIsAFile().renameTo(fileordirThatIsAFileRenamed);\"",
                    Test.toLog(this.z_TowaPrivate_fileordirThatIsAFile().getPath(), 
                            "this.z_TowaPrivate_fileordirThatIsAFile().getPath()"),
                    Test.toLog(fileordirThatIsAFileRenamed.getPath(), "fileordirThatIsAFileRenamed.getPath()"));
        }

            this.fileordirThatIsAFile_Z = fileordirThatIsAFileRenamed;
    }

    //------------------------------------------------------------------------------------------------------------------
    public void deleteFromDisk( //
            //                                              //Elimina un file del disco
            ) {
        //                                                  //Crea el syspath del archivo, esto solo para confirmar
        //                                                  //      que todo sigue bien y tener un mejor diagnóstico en
        //                                                  //      caso de problemas.
        Path syspathFile = this.getPath();
        if ( //
                !syspathFile.isFile() //
                ) { 
            Test.abort(Test.toLog(syspathFile.name(), "syspathFile.name()") + " is not a File", 
                    Test.toLog(syspathFile, "syspathFile"));
        }

        //                                                  //Hace el delete.
        try {
            //                                              //Delete the file itself.
            Files.delete(Paths.get(this.z_TowaPrivate_fileordirThatIsAFile().getPath()));
        } //
        catch (Exception sysexcepError) {
            Test.abort(
                    Test.toLog(sysexcepError, "sysexcepError")
                    + " error in \"Files.delete(Paths.get(this.z_TowaPrivate_fileordirThatIsAFile().getPath()));\"",
                    Test.toLog(this.z_TowaPrivate_fileordirThatIsAFile(), "this.z_TowaPrivate_fileordirThatIsAFile()"));
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public void moveOnDisk( //
            //                                              //Mueve un archivo a ser parte de otro directorio,
            //                                              //      no debe existir el archivo en el nuevo padre.
            //                                              //Este move solo puede ser al mismo dispositivo.

            Directory directoryReceiving_M
    ) {
        if ( //
                directoryReceiving_M == null //
                ) {
            Test.abort(Test.toLog(directoryReceiving_M, "directoryReceiving_M") + " can not be null");
        }
        
        //                                                  //Verifica que tanto el archivo como el directorio existan.
        Path syspathFile = this.getPath();
        if ( //
                !syspathFile.isFile() //
                ) { 
            Test.abort(Test.toLog(syspathFile.name(), "syspathFile.name()") + " is not a File", 
                    Test.toLog(syspathFile, "syspathFile"));
        }
        Path syspathDirectoryReceiving = directoryReceiving_M.getPath();
        if ( //
                //                                          //Verifica que el padre sea un directorio.
                !syspathDirectoryReceiving.isDirectory() //
                ) {
            Test.abort(
                    Test.toLog(syspathDirectoryReceiving.fullPath(), "syspathDirectoryReceiving.FullPath")
                    + " is not a directory",
                    Test.toLog(directoryReceiving_M, "directoryReceiving_M"),
                    Test.toLog(syspathDirectoryReceiving, "syspathDirectoryReceiving"),
                    Test.toLog(this, "this"), Test.toLog(syspathFile, "syspathFile"));
        }

        if ( //
                //                                          //Verifica que no estén en raíces distintas.
                !syspathFile.root().equals(syspathDirectoryReceiving.root()) //
                ) {
            Test.abort(
                    Test.toLog(syspathFile.fullPath(), "syspathFile.FullPath") + " can not move to "
                    + Test.toLog(syspathDirectoryReceiving.fullPath(), "syspathDirectoryReceiving.FullPath")
                    + " they are not in the same root");
        }

        //                                                  //Forma el syspath del archivo ya movido.
        Path syspathFileMoved = syspathDirectoryReceiving.addName(syspathFile.name());

        //                                                  //Aborta si existe otro directorio o archivo con el mismo
        //                                                  //      nombre en el el disco.
        if ( //
                //                                          //El nuevo syspath, ya existe.
                syspathFileMoved.exists() //
                ) {
            Test.abort(
                    Test.toLog(syspathFile.fullPath(), "syspathFile.FullPath") + " can not move to "
                    + Test.toLog(syspathDirectoryReceiving.fullPath(), "syspathDirectoryReceiving.FullPath")
                    + " already exists (it is a directory or file with same name)",
                    Test.toLog(syspathFileMoved, "syspathFileMoved"), Test.toLog(this, "this"),
                    Test.toLog(syspathFile, "syspathFile"),
                    Test.toLog(directoryReceiving_M, "directoryReceiving_M"),
                    Test.toLog(syspathDirectoryReceiving, "syspathDirectoryReceiving"));
        }

        //                                                  //Mueve el archivo al nuevo directorio ("YaMOvido").
        //                                                  //Nótese que se mueve abajo del NewParent y que conserva el
        //                                                  //      nombre (última parte) que tenía.
        java.io.File fileordirThatIsAFileRenamed;
        try {
            fileordirThatIsAFileRenamed = new java.io.File(syspathFileMoved.fullPath());
        } //
        catch (Exception sysexcepError) {
            Test.abort(
                    Test.toLog(sysexcepError, "sysexcepError")
                    + " error in \"new java.io.File(syspathFileMoved.fullPath())\"",
                    Test.toLog(this, "this"), Test.toLog(syspathFileMoved, "syspathFileMoved"));

            fileordirThatIsAFileRenamed = null;
        }
        
        try {
            this.z_TowaPrivate_fileordirThatIsAFile().renameTo(fileordirThatIsAFileRenamed);
        } //
        catch (Exception sysexcepError) {
            Test.abort(
                    Test.toLog(sysexcepError, "sysexcepError")
                    + " error in \"this.z_TowaPrivate_fileordirThatIsAFile().renameTo(fileordirThatIsAFileRenamed);\"",
                    Test.toLog(this, "this"), Test.toLog(syspathFileMoved, "syspathFileMoved"));
        }
        
        try {
            Files.move(Paths.get(directoryReceiving_M.fullPath()), Paths.get(syspathFileMoved.fullPath()));
        } //
        catch (Exception sysexcepError) {
            Test.abort(
                    Test.toLog(sysexcepError, "sysexcepError")
                    + " error in \"Files.move(Paths.get(directoryReceiving_M.fullPath()),"
                    + " Paths.get(syspathFileMoved.fullPath()));\"",
                    Test.toLog(this, "this"), Test.toLog(syspathFileMoved, "syspathFileMoved"));
        }
        
        this.fileordirThatIsAFile_Z = fileordirThatIsAFileRenamed;
    }

    //--------------------------------------------------------------------------------------------------------------
    public void copyOnDisk( //
            //                                              //Copia un archivo a otro directorio donde puede o no
            //                                              //      Existir.
            

            Directory directoryReceiving_M,
            //                                              //File del archivo donde se va a regresar.
            O<FileX> fileWrited_O
    ) {
        if ( //
                directoryReceiving_M == null //
                ) {
            Test.abort(Test.toLog(directoryReceiving_M, "directoryReceiving_M") + " can not be null");
        }
        
        //                                                  //Verifica que el archivo y el directorio existan.
        Path syspathFile = this.getPath();
        if ( //
                !syspathFile.isFile() //
                ) {
            Test.abort(Test.toLog(syspathFile.fullPath(), "syspathFile.FullPath") + " file do not exist",
                    Test.toLog(this, "this"), Test.toLog(syspathFile, "syspathFile"));
        }

        Path syspathDirectoryReceiving = directoryReceiving_M.getPath();
        if ( //
                !syspathDirectoryReceiving.isDirectory() //
                ) {
            Test.abort(Test.toLog(syspathDirectoryReceiving.fullPath(), "syspathDirectoryReceiving.FullPath")
                    + " directory do not exist",
                    Test.toLog(directoryReceiving_M, "directoryReceiving_M"),
                    Test.toLog(syspathDirectoryReceiving, "syspathDirectoryReceiving"),
                    Test.toLog(this, "this"), Test.toLog(syspathFile, "syspathFile"));
        }

        //                                                  //Verifica que el archivo no sea un directorio.
        Path syspathFileToWrite = syspathDirectoryReceiving.addName(syspathFile.name());
        if ( //
                syspathFileToWrite.isDirectory() //
                ) {
            Test.abort(
                    Test.toLog(syspathFileToWrite.fullPath(), "syspathFileToWrite.FullPath")
                    + " already exists as DIRECTORY",
                    Test.toLog(syspathFileToWrite, "syspathFileToWrite"),
                    Test.toLog(directoryReceiving_M, "directoryReceiving_M"),
                    Test.toLog(syspathDirectoryReceiving, "syspathDirectoryReceiving"),
                    Test.toLog(this, "this"), Test.toLog(syspathFile, "syspathFile"));
        }

        try {
            Files.copy(Paths.get(this.fileordirThatIsAFile_Z.getPath()), Paths.get(syspathFileToWrite.fullPath()),
                    StandardCopyOption.REPLACE_EXISTING);
        } //
        catch (Exception sysexcepError) {
            Test.abort(
                    Test.toLog(sysexcepError, "sysexcepError")
                    + " error in \"Files.copy(Paths.get(this.fileordirThatIsAFile_Z.getPath()),"
                    + " Paths.get(syspathFileToWrite.fullPath()), StandardCopyOption.REPLACE_EXISTING);\"",
                    Test.toLog(this, "this"), Test.toLog(syspathFileToWrite, "syspathFileToWrite"));
        }

        //                                                  //Regresa el nuevo File.
        fileWrited_O.v = new FileX(syspathFileToWrite);
    }

    //------------------------------------------------------------------------------------------------------------------
    public void setReadOnly( //
            //                                              //Set ReadOnly del archivo a true.
            //                                              //File del archivo que se quiere modificar.
            ) {
        //                                                  //Crea el syspath del archivo, esto solo para confirmar
        //                                                  //      que todo sigue bien y tener un mejor diagnóstico en
        //                                                  //      caso de problemas.
        Path syspathFile = this.getPath();

        if ( //
                !syspathFile.isFile() //
                ) {
            Test.abort(Test.toLog(syspathFile, "syspathFile") + " it is not a file");
        }

        //                                                  //Modifica propiedad.
        try {
            this.fileordirThatIsAFile_Z.setWritable(false);
        } //
        catch (Exception sysexcepError) {
            Test.abort(Test.toLog(sysexcepError, "sysexcepError") + " error in \"File_M.setWritable(false);\"",
                    Test.toLog(this.fileordirThatIsAFile_Z, "File_M"));
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public void resetReadOnly( //
            //                                              //Permite que se pueda escribir en el archivo.
            //                                              //Recibe File del archivo que se quiere modificar.
            ) {
        //                                                  //Crea el syspath del archivo, esto solo para confirmar
        //                                                  //      que todo sigue bien y tener un mejor diagnóstico en
        //                                                  //      caso de problemas.
        Path syspathFile = this.getPath();

        if ( //
                !syspathFile.isFile() //
                ) {
            Test.abort(Test.toLog(syspathFile, "syspathFile") + " it is not a file");
        }

        //                                                  //Modifica propiedad.
        try {
            this.fileordirThatIsAFile_Z.setWritable(true);
        } //
        catch (Exception sysexcepError) {
            Test.abort(Test.toLog(sysexcepError, "sysexcepError") + " error in \"File_M.setWritable(true);\"",
                    Test.toLog(this.fileordirThatIsAFile_Z, "File_M"));
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public void writeAll( //
            //                                              //Sube la totalidad de un arreglo en memoria a un archivo
            //                                              //      de texto (puede o no existir el archivo).

            //                                              //arrstr, archivo de texto en formato de arreglo de Strings.
            String[] setOfLines_I
    ) {
        if ( //
                setOfLines_I == null //
                ) {
            Test.abort(Test.toLog(setOfLines_I, "setOfLines_I") + " can not be null");
        }

        //                                                  //Tomo el path para analizarlo y poder dar un mejor
        //                                                  //      diagnostico.
        Path syspathTextFile = this.getPath();
        if ( //
                //                                          //Ya existe como DIRECTORY
                syspathTextFile.isDirectory()//
                ) {
            Test.abort(
                    Test.toLog(syspathTextFile.fullPath(), "syspathTextFile.FullPath()") + " exists as DIRECTORY",
                    Test.toLog(this, "this"), Test.toLog(syspathTextFile, "syspathTextFile"));
        }

        //                                                  //Creo el stream writer.
        java.io.PrintWriter systextwriter = TextWriterX.newX(this);

        //                                                  //Paso todo el arreglo a un solo String de líneas.
        String strTextFile = String.join("\n", setOfLines_I);
        TextWriterX.writeLine(strTextFile, systextwriter);

        //                                                  //Es necesaro cerrar el systextwriter
        systextwriter.close();
    }

    //
    //------------------------------------------------------------------------------------------------------------------
    /*ACCESS METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    public boolean exists( //
            ) {
        //                                                  //Tomo el path para analizarlo y poder dar un mejor
        //                                                  //      diagnostico.
        Path syspathTextFile = this.getPath();
        if ( //
                syspathTextFile.isDirectory()//
                ) {
            Test.abort(
                    Test.toLog(syspathTextFile.fullPath(), "syspathTextFile.FullPath()") + " is a DIRECTORY",
                    Test.toLog(this, "this"), Test.toLog(syspathTextFile, "syspathTextFile"));
        }
        
        boolean boolExists;
        try {
            boolExists = this.z_TowaPrivate_fileordirThatIsAFile().exists();
        } //
        catch (Exception sysexcepError) {
            Test.abort(Test.toLog(sysexcepError, "sysexcepError")
                    + " error in \"this.z_TowaPrivate_fileordirThatIsAFile().exists()\"",
                    Test.toLog(this, "Directory_I"));

            boolExists = false;
        }

        return boolExists;
    }

    //------------------------------------------------------------------------------------------------------------------
    public long length( //
            ) {
        //                                                  //Tomo el path para analizarlo y poder dar un mejor
        //                                                  //      diagnostico.
        Path syspathTextFile = this.getPath();
        if ( //
                !syspathTextFile.isFile()//
                ) {
            Test.abort(
                    Test.toLog(syspathTextFile.fullPath(), "syspathTextFile.FullPath()") + " is not a FILE",
                    Test.toLog(this, "this"), Test.toLog(syspathTextFile, "syspathTextFile"));
        }
        
        long longLength;
        try {
            longLength = this.z_TowaPrivate_fileordirThatIsAFile().length();
        } //
        catch (Exception sysexcepError) {
            Test.abort(Test.toLog(sysexcepError, "sysexcepError")
                    + " error in \"this.z_TowaPrivate_fileordirThatIsAFile().length()\"",
                    Test.toLog(this, "this"), Test.toLog(syspathTextFile, "syspathTextFile"));

            longLength = 0;
        }

        return longLength;
    }

    //------------------------------------------------------------------------------------------------------------------
    public boolean isReadOnly( //
            ) {
        //                                                  //Tomo el path para analizarlo y poder dar un mejor
        //                                                  //      diagnostico.
        Path syspathTextFile = this.getPath();
        if ( //
                !syspathTextFile.isFile()//
                ) {
            Test.abort(
                    Test.toLog(syspathTextFile.fullPath(), "syspathTextFile.FullPath()") + " is not a FILE",
                    Test.toLog(this, "this"), Test.toLog(syspathTextFile, "syspathTextFile"));
        }
        
        boolean boolIsReadOnly;
        try {
                boolIsReadOnly = !this.fileordirThatIsAFile_Z.canWrite();
        } //
        catch (Exception sysexcepError) {
            Test.abort(Test.toLog(sysexcepError, "sysexcepError")
                    + " error in \"!this.fileordirThatIsAFile_Z.canWrite()\"",
                    Test.toLog(this, "Directory_I"));

            boolIsReadOnly = false;
        }

        return boolIsReadOnly;
    }

    //------------------------------------------------------------------------------------------------------------------
    public FileTime getCreationTime( //
            //                                              //Recibe un Directory y se obtiene el tiempo de su creación.
            //                                              //Nota: Este método regresa un FileTime y se debe modificar 
            //                                              //      posteriormente a que regrese UTC.
            ) {
        return this.bfaGet().creationTime();
    }

    //------------------------------------------------------------------------------------------------------------------
    public FileTime getLastWriteTime( //
            //                                              //Recibe un Directory y se obtiene el tiempo en que se 
            //                                              //      escribió por última vez.
            //                                              //Nota: Este método regresa un FileTime y se debe modificar 
            //                                              //      posteriormente a que regrese UTC.
            ) {
        return this.bfaGet().lastModifiedTime();
    }

    //------------------------------------------------------------------------------------------------------------------
    public String[] readAll( //
            //                                              //Carga la totalidad de un archivo de texto a memoria.
            //                                              //arrstr, archivo de texto en formato de arreglo de Strings.
            //                                              //File del archivo a cargar a memoría.
            ) {
        //                                                  //Crea el syspath del directorio, esto solo para confirmar
        //                                                  //      que todo sigue bien y tener un mejor diagnóstico en
        //                                                  //      caso de problemas.
        Path syspathTextFile = this.getPath();

        if ( //
                !syspathTextFile.isFile() //
                ) {
            Test.abort(Test.toLog(syspathTextFile.fullPath(), "syspathTextFile.FullPath") + " is not a file",
                    Test.toLog(this, "this"), Test.toLog(syspathTextFile, "syspathTextFile"));
        }

        Scanner systextreader = TextReaderX.newX(this);

        //                                                  //Paso el archivo a memoria (un String).
        String strTextFile = FileX.strReadAllLines(systextreader);

        //                                                  //Es necesaro cerrar el systextreader
        systextreader.close();

        //                                                  //Formo arreglo con lo leído.
        return Std.split(strTextFile, '\n');
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private static String strReadAllLines( //
            //                                              //Reads the contents of a file and returns them in a string.

            Scanner systextreader_M
    ) {
        //                                                  //
        String strReadAllLines = "";
        while ( //
                systextreader_M.hasNextLine() //
                ) {

            //                                                  //Paso el archivo a memoria (un String).
            String strNextLine;
            try {
                strNextLine = systextreader_M.nextLine();

            } //
            catch (Exception sysexcepError) {
                Test.abort(Test.toLog(sysexcepError, "sysexcepError") + " error in \"TextReader_M.nextLine()\"",
                        Test.toLog(systextreader_M, "TextReader_M"));

                strNextLine = null;

                systextreader_M.close();
            }

            //                                              //Add line separator              
            strReadAllLines = strReadAllLines + ((strReadAllLines.length() == 0) ? "" : "\n") + strNextLine;
        }
        
        //                                                  //ESTO ES UN PARCHE FEO que parece que es lo correcto
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

    //------------------------------------------------------------------------------------------------------------------
}

//======================================================================================================================
/*END-TASK*/
