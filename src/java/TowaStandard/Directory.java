package TowaStandard;

import java.util.ArrayList;
import java.nio.file.*;
import java.nio.file.attribute.*;

//                                                          //AUTHOR: Towa (IDL-Iñaki de Atela).
//                                                          //CO-AUTHOR: Towa (GLG-Gerardo López).
//                                                          //DATE: September 21, 2018.
//
//======================================================================================================================
public class Directory extends BsysBaseSystemAbstract {

    //                                                      //Clase para manipular directories.    
    //                                                      //Debe funcionar correctamente para archivos y directorios
    //                                                      //      locales y en la red.
    //------------------------------------------------------------------------------------------------------------------
    /*CONSTANTS*/

    //------------------------------------------------------------------------------------------------------------------
    /*INITIALIZER*/
    //------------------------------------------------------------------------------------------------------------------
    static {
    }

    //------------------------------------------------------------------------------------------------------------------
    /*INSTANCE VARIABLES*/
    //                                                      //(Java) This File is required to compute somo other
    //                                                      //      variables.
    private java.io.File fileordirThatIsADirectory_Z;

    public java.io.File z_TowaPrivate_fileordirThatIsADirectory() {
        return this.fileordirThatIsADirectory_Z;
    }

    //------------------------------------------------------------------------------------------------------------------
    private BasicFileAttributes bfaGet( //
            //                                              //Method required to get attributes
            ) {
        BasicFileAttributes bfaGet;
        try {
            bfaGet = Files.readAttributes(Paths.get(this.z_TowaPrivate_fileordirThatIsADirectory().getPath()),
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
        return this.fileordirThatIsADirectory_Z.getName();
    }

    public String fullPath() {
        return this.z_TowaPrivate_fileordirThatIsADirectory().getPath();
    }

    public Path getPath( //
            //                                              //Extrae el syspath correspondiente al directorio.
            //                                              //syspath, similar al que se uso para crear el sysdir con su
            //                                              //      estado actualizado.
            //                                              //sysdir o sysfile del cual se quiere información.
            ) {
        //                                                  //Regresa el path con su estado actualizado.
        String strFullPath = this.fullPath();
        return new Path(strFullPath);
    }

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toLogShort() {

        String toLogShort = "<Name(" + this.name() + "), " + Test.toLog(this.exists());

        if ( //
                this.z_TowaPrivate_fileordirThatIsADirectory().exists() //
                ) {
            BasicFileAttributes bfa = this.bfaGet();
            toLogShort = toLogShort + ", " + Test.toLog(this.getCreationTime().toString()) + ", "
                    + Test.toLog(bfa.lastAccessTime().toString()) + ", "
                    + Test.toLog(bfa.lastModifiedTime().toString()) + ", "
                    + Test.toLog(this.getDirectories().length) + ", " + Test.toLog(this.getFiles().length);
        }

        toLogShort = toLogShort + ">";

        return toLogShort;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public String toLogFull() {

        String strInfo = "<FullName(" + Test.toLog(this.getPath()) + "), "
                + Test.toLog(this.exists(), "Exists");

        if ( //
                this.z_TowaPrivate_fileordirThatIsADirectory().exists() //
                ) {
            BasicFileAttributes bfa = this.bfaGet();
            strInfo = strInfo + ", " + Test.toLog(this.getCreationTime().toString(), "CreationTime") + ", "
                    + Test.toLog(bfa.lastAccessTime().toString(), "LastAccessTime") + ", "
                    + Test.toLog(bfa.lastModifiedTime().toString(), "LastWriteTime") + ", "
                    + Test.toLog(this.getDirectories().length, "Directories") + ", "
                    + Test.toLog(this.getFiles().length, "Files");
        }

        strInfo = strInfo + ">";

        return strInfo;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*OBJECT CONSTRUCTORS*/
    //------------------------------------------------------------------------------------------------------------------
    public Directory(
            //                                              //Crea un objeto Directory con un syspath.
            //                                              //this.*[O], asigna valores.

            Path directoryPath_I
    ) {
        super();

        //                                                  //Se crea el File.            
        try {
            this.fileordirThatIsADirectory_Z = new java.io.File(directoryPath_I.fullPath());
        } //
        catch (Exception sysexcepError) {
            Test.abort(
                    Test.toLog(sysexcepError, "sysexcepError")
                    + " error in \"new Directory(DirectoryPath_I.FullPath())\"",
                    Test.toLog(directoryPath_I, "directoryPath_I"));

            this.fileordirThatIsADirectory_Z = null;
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private Directory( //
            //                                              //Crea un Directory, el directorio puede no existir.

            //                                              //File that is a Directory (not a File).
            java.io.File z_TowaPRIVARTE_fileordirThatIsADirectory_I
    ) {
        super();

        this.fileordirThatIsADirectory_Z = z_TowaPRIVARTE_fileordirThatIsADirectory_I;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static Directory getCurrent( //
            //                                              //Localiza el directorio sobre el que se encuentra
            //                                              //      posicionada la aplicación.
            //                                              //sysdir, Current Directory.
            ) {
        //                                                  //Busca el current directory.
        String strCurrentDirectory;
        try {
            strCurrentDirectory = System.getProperty("user.dir");
        } //
        catch (Exception sysexcepError) {
            Test.abort(Test.toLog(sysexcepError, "sysexcepError") + " error in \"System.getProperty(\"user.dir\")\"");

            strCurrentDirectory = null;
        }

        //                                                  //Regresa un Directory.
        Path syspathCurrentDirectory = new Path(strCurrentDirectory);

        return new Directory(syspathCurrentDirectory);
    }

    //------------------------------------------------------------------------------------------------------------------
    /*TRANSFORMATION METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    public void setCurrent( //
            //                                              //Establece el Current Durectory.
            //                                              //Recibe el Directory sobre el cual se desea posicionar.
            ) {
        //                                                  //Crea el syspath del directorio, esto solo para confirmar
        //                                                  //      que todo sigue bien y tener un mejor diagnóstico en
        //                                                  //      caso de problemas.
        Path syspathToSet = this.getPath();

        if ( //
                !syspathToSet.isDirectory() //
                ) {
            Test.abort(Test.toLog(syspathToSet, "syspathToSet") + " do not exist as directory");
        }

        //                                                  //Establece el Current Directory a partir de un path.
        try {
            System.setProperty("user.dir", syspathToSet.fullPath());
        } //
        catch (Exception sysexcepError) {
            Test.abort(Test.toLog(sysexcepError, "sysexcepError") + " error in \"System.getProperty(\"user.dir\")\"",
                    Test.toLog(syspathToSet.fullPath(), "syspathToSet.FullPath"),
                    Test.toLog(syspathToSet, "syspathToSet"));
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public void createOnDisk( //
            //                                              //A partir de un Directory CREA el directorio en disco.
            //                                              //Recibe directory con el cual se desea crear el directorio 
            //                                              //      en disco.
            ) {
        //                                                  //Se obtiene un syspath para verificar la existencia
        Path syspathDirectory = this.getPath();

        if ( //
                //                                          //Se verifica si ya existe como directorio o como archivo.
                syspathDirectory.exists() //
                ) {
            Test.abort(
                    Test.toLog(syspathDirectory, "syspathDirectory")
                    + " can not create a directory, already exist as a directory o as a file");
        }

        //                                                  //Crea el directorio en disco.
        try {
            this.fileordirThatIsADirectory_Z.mkdir();
        } //
        catch (Exception sysexcepError) {
            Test.abort(Test.toLog(sysexcepError, "sysexcepError") + " error in \"Directory_M.mkdir()\"",
                    Test.toLog(this.fileordirThatIsADirectory_Z, "this.fileThatIsADirectory"));
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public void renameOnDisk( //
            //                                              //Modifica el nombre de un directorio (último
            //                                              //      subdirectorio)

            //                                              //Recibe un Directory del directorio que se quiere 
            //                                              //      renombrar.
            //                                              //Nuevo nombre del subdirectorio (sin el path).
            String newName_I
    ) {
        if ( //
                !Path.isPathNameValid(newName_I) //
                ) {
            Test.abort(Test.toLog(newName_I, "newName_I") + " is not valid");
        }

        //                                                  //Crea el syspath del directorio, esto solo para confirmar
        //                                                  //      que todo sigue bien y tener un mejor diagnóstico en
        //                                                  //      caso de problemas.
        Path syspathDirectory = this.getPath();

        if ( //
                !syspathDirectory.isDirectory() //
                ) {
            Test.abort(Test.toLog(syspathDirectory, "syspathDirectory") + " do not exist as directory");
        }

        if ( //
                //                                          //Verifica que el nuevo nombre no sea el mismo.
                newName_I.equals(this.fileordirThatIsADirectory_Z.getName()) //
                ) {
            Test.abort(Test.toLog(syspathDirectory, "syspathDirectory") + " & "
                    + Test.toLog(newName_I, "newName_I") + " both are the same name, can not rename");
        }

        //                                                  //Crea el nuevo path para confirmar que su forma es válida.
        Path syspathDirectoryRenamed = syspathDirectory.getDirectoryPath().addName(newName_I);

        if ( //
                //                                              //Verifica si ya existe un archivo o directorio con 
                //                                              //      el mismo nombre.
                syspathDirectoryRenamed.exists() //
                ) {
            Test.abort(Test.toLog(syspathDirectoryRenamed, "syspathDirectoryRanamed")
                    + " can not rename, already exists as directory o file");
        }

        //                                                  //Nótese que ya se hicieron muchas verificaciones para hacer
        //                                                  //      esto en forma segura.
        try {
            java.io.File fileordirToRenameDirectory = new java.io.File(syspathDirectoryRenamed.fullPath());
            this.fileordirThatIsADirectory_Z.renameTo(fileordirToRenameDirectory);
        
            //                                              //Rename Directory object
            this.fileordirThatIsADirectory_Z = fileordirToRenameDirectory;
        } //
        catch (Exception sysexcepError) {
            Test.abort(
                    Test.toLog(sysexcepError, "sysexcepError")
                    + " error in \"Directory_M.renameTo(new File(syspathDirectoryRanamed.FullPath()));\"",
                    Test.toLog(this.fileordirThatIsADirectory_Z, "Directory_M"),
                    Test.toLog(syspathDirectoryRenamed, "syspathDirectoryRanamed"));
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public void deleteFromDisk( //
            //                                              //Elimina un directorio del disco.

            //                                              //Recibe el Directory que se desea eliminar.

            //                                              //Si el siguiente booleano es true, borra el directorio y su 
            //                                              //      contenido, si es false, solo puede borrar el 
            //                                              //      directorio si está vacío, en su defecto aborta.
            boolean deleteSubdirectoriesAndFiles_I
    ) {
        //                                                  //Crea el syspath del directorio, esto solo para confirmar
        //                                                  //      que todo sigue bien y tener un mejor diagnóstico en
        //                                                  //      caso de problemas.
        Path syspathDirectory = this.getPath();

        if ( //
                !syspathDirectory.isDirectory() //
                ) {
            Test.abort(
                    Test.toLog(syspathDirectory.fullPath(), "syspathDirectory.FullPath") + " is not a directory",
                    Test.toLog(this.fileordirThatIsADirectory_Z, "Directory_M"), 
                    Test.toLog(syspathDirectory, "syspathDirectory"));
        }

        //                                                  //(Glg 19Ago2018) ESTO DEBE SER REESTRUCTURADO EN UN SOLO
        //                                                  //      METODOS, SI FUERA NECESARIO, QUE SE LLAME A SI
        //                                                  //      MISMO EN FORMA RECURSIVA
        if ( //
                deleteSubdirectoriesAndFiles_I //
                ) {
            //                                              //Delete the contents of the directory.
            Directory.subDeleteRecursively(this.fileordirThatIsADirectory_Z);
        }

        //                                                  //Hace el delete.
        try {
            //                                              //Delete the directory itself.
            Files.delete(Paths.get(this.fileordirThatIsADirectory_Z.getPath()));
        } //
        catch (Exception sysexcepError) {
            Test.abort(
                    Test.toLog(sysexcepError, "sysexcepError")
                    + " error in \"Files.delete(Paths.get(Directory_M.getPath()));\"",
                    Test.toLog(this.fileordirThatIsADirectory_Z, "Directory_M"),
                    Test.toLog(deleteSubdirectoriesAndFiles_I, "deleteSubdirectoriesAndFiles_I"));
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private static void subDeleteRecursively( //
            //                                              //Delete a directory recursively (deleting all of its
            //                                              //      contents. It will not delete the "root directory".

            //                                              //The folder that must be deleted recursively.
            java.io.File fileordirThatIsADirectory_M
    ) {
        for (java.io.File fileordir : fileordirThatIsADirectory_M.listFiles()) {
            if ( //
                    fileordir.isDirectory() //
                    ) {
                //                                          //Recursive method.
                Directory.subDeleteRecursively(fileordir);
            }

            //                                              //Hace el delete.
            try {
                //                                          //Delete the directory itself.
                Files.delete(Paths.get(fileordir.getPath()));
            } //
            catch (Exception sysexcepError) {
                Test.abort(
                        Test.toLog(sysexcepError, "sysexcepError")
                        + " error in \"Files.delete(Paths.get(sysdirOrFile.getPath()));\"",
                        Test.toLog(fileordirThatIsADirectory_M, "Directory_M"));
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public void moveOnDisk( //
            //                                              //Mueve un directorio o archivo a ser parte de otro
            //                                              //      directorio, no debe existir este directorio en el 
            //                                              //      nuevo padre.
            //                                              //Este move solo puede ser al mismo dispositivo.

            //                                              //Recibe un Directory que se quiere mover, lo
            //                                              //      actualiza a la nueva ubicación.

            //                                              //Directory del directorio al cual se desea mover el
            //                                              //      directorio anterior, este será el nuevo padre.
            Directory directoryReceiving_M
    ) {
        if ( //
                this.fileordirThatIsADirectory_Z == null //
                ) {
            Test.abort(Test.toLog(this.fileordirThatIsADirectory_Z, "File_M") + " can not be null");
        }

        //                                                  //Verifica que ambos directorios existan.
        Path syspathFile = this.getPath();
        if ( //
                //                                          //Verifica que sea un directorio.
                !syspathFile.isDirectory() //
                ) {
            Test.abort(Test.toLog(syspathFile.fullPath(), "syspathFile.FullPath") + " is not a directory",
                    Test.toLog(this.fileordirThatIsADirectory_Z, "File_M"), Test.toLog(syspathFile, "syspathFile"));
        }

        if ( //
                directoryReceiving_M == null //
                ) {
            Test.abort(Test.toLog(directoryReceiving_M, "directoryReceiving_M") + " can not be null");
        }

        Path syspathDirectoryReceiving = directoryReceiving_M.getPath();
        if ( //
                //                                          //Verifica que el Directory padre sea un directorio.
                !syspathDirectoryReceiving.isDirectory() //
                ) {
            Test.abort(
                    Test.toLog(syspathDirectoryReceiving.fullPath(), "syspathDirectoryReceiving.FullPath")
                    + " is not a directory",
                    Test.toLog(directoryReceiving_M, "directoryReceiving_M"),
                    Test.toLog(syspathDirectoryReceiving, "syspathDirectoryReceiving"));
        }

        if ( //
                //                                          //Verifica los directorios estén en raíces distintas.
                syspathFile.root().compareTo(syspathDirectoryReceiving.root()) != 0 //
                ) {
            Test.abort(
                    Test.toLog(syspathFile.fullPath(), "syspathFile.FullPath") + " can not move to "
                    + Test.toLog(syspathDirectoryReceiving.fullPath(), "syspathDirectoryReceiving.FullPath")
                    + " they are not in the same root",
                    Test.toLog(this.fileordirThatIsADirectory_Z, "File_M"), Test.toLog(syspathFile, "syspathFile"),
                    Test.toLog(directoryReceiving_M, "DirectoryReceiving_M"),
                    Test.toLog(syspathDirectoryReceiving, "syspathDirectoryReceiving"));
        }

        //                                                  //Forma el syspath del directorio ya movido.
        Path syspathFileMoved = syspathDirectoryReceiving.addName(syspathFile.name());

        //                                                  //Aborta si existe otro directorio o archivo con el mismo
        //                                                  //      nombre en el el disco.
        if ( //
                //                                          //El nuevo syspath, ya existe.
                syspathFileMoved.exists() //
                ) {
            Test.abort(
                    Test.toLog(syspathFile.fullPath(), "syspathFile.FullPath") + " can not move to "
                    + Test.toLog(syspathDirectoryReceiving.fullPath(), "syspathDirectoryReceiving.FullPath") + ", "
                    + Test.toLog(syspathFileMoved.name(), "syspathFileMoved.Name")
                    + " already exists (it is a directory or file with same name)",
                    Test.toLog(syspathFileMoved, "syspathFileMoved"),
                    Test.toLog(this.fileordirThatIsADirectory_Z, "File_M"),
                    Test.toLog(syspathFile, "syspathFile"),
                    Test.toLog(directoryReceiving_M, "directoryReceiving_M"),
                    Test.toLog(syspathDirectoryReceiving, "syspathDirectoryReceiving"));
        }

        //                                                  //Mueve el directorio al nuevo directorio.
        try {
            //                                              //Nótese que se mueve abajo del NewParent y que conserva el
            //                                              //      nombre (última parte) que tenía.
            java.io.File fileordirThatIsAFileRenamed = new java.io.File(syspathFileMoved.fullPath());
            this.fileordirThatIsADirectory_Z.renameTo(fileordirThatIsAFileRenamed);
            this.fileordirThatIsADirectory_Z = fileordirThatIsAFileRenamed;
//            Files.move(Paths.get(DirectoryReceiving_M.fullPath()), Paths.get(syspathFileMoved.fullPath()));
        } //
        catch (Exception sysexcepError) {
            Test.abort(
                    Test.toLog(sysexcepError, "sysexcepError")
                    + " error in \"Files.move(Paths.get(DirectoryReceiving_M.getPath()), "
                    + "Paths.get(syspathFileMoved.FullPath()));\"",
                    Test.toLog(this.fileordirThatIsADirectory_Z, "File_M"), 
                    Test.toLog(syspathFileMoved, "syspathFileMoved"));
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public void copyOnDisk( //
            //                                              //Copia el directorio (con todo su contenido) a otro
            //                                              //      directorio, se copia con el mismo nombre.
            //                                              //No debe existir el nombre en el nuevo padre.

            //                                              //Recibe el Directory del directorio que se quiere copiar.

            //                                              //Directory del directorio al cual se desea copiar, este
            //                                              //      será el padre que recibe el diretorio.
            Directory directoryReceiving_M,
            //                                              //Regresa el Directory del directorio nuevo (lo que
            //                                              //      quedo ya copiado).
            O<Directory> directoryCopied_O
    ) {
        //                                                  //Verifica que ambos directorios existan.
        Path syspathDirectory = this.getPath();
        if ( //
                //                                          //Verifica que sea un directorio.
                !syspathDirectory.isDirectory() //
                ) {
            Test.abort(Test.toLog(syspathDirectory, "syspathToCopy") + " do not exist as directory");
        }
        Path syspathDirectoryReciving = directoryReceiving_M.getPath();
        if ( //
                //                                          //Verifica que sea un directorio.
                !syspathDirectoryReciving.isDirectory() //
                ) {
            Test.abort(Test.toLog(syspathDirectoryReciving, "syspathDirectoryReciving")
                    + " do not exist as directory");
        }

        //                                                  //Verifica que el nuevo directorio no exista.
        Path syspathDirectoryCopied = syspathDirectoryReciving.addName(syspathDirectory.name());
        if ( //
                //                                          //El nuevo syspath, ya existe.
                syspathDirectoryCopied.exists() //
                ) {
            Test.abort(
                    Test.toLog(syspathDirectoryCopied, "syspathDirectoryCopied")
                    + " can not copy, already exists a directory or file with same name",
                    Test.toLog(syspathDirectoryCopied.exists(), "syspathDirectoryCopied.boolExists()"),
                    Test.toLog(this, "Directory_I"), Test.toLog(directoryReceiving_M, "directoryReceiving_M"));
        }

        //                                                  //Crea el nuevo sysdir y el directorio en el disco.
        directoryCopied_O.v = new Directory(syspathDirectoryCopied);
        directoryCopied_O.v.createOnDisk();

        //                                                  //Copia todos los archivos que se encuentran en el nivel
        //                                                  //      inmediato.
        FileX[] arrsysfileToCopy = this.getFiles();
        for (FileX sysfileF : arrsysfileToCopy) {
            //                                              //Copia cada uno, no habra remplazos.
            O<FileX> osysfile = new O<>();
            Directory.copyFileWrite(sysfileF, directoryCopied_O.v, osysfile);
        }

        //                                                  //Copia todos los subdirectorios que se encuentran en el
        //                                                  //      nivel inmediato.
        Directory[] arrsysdirToCopy = this.getDirectories();
        for (Directory sysdirD : arrsysdirToCopy) {
            //                                              //Copia cada uno de los subdirectorios (llamada recursiva).
            O<Directory> osysdir = new O<>();
            sysdirD.copyOnDisk(directoryCopied_O.v, osysdir);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public static void copyFileWrite( //
            //                                              //Copia un archivo a otro directorio donde no existe.

            //                                              //File del archivo que se quiere copiar.
            FileX sysfile_I,
            //                                              //Directory del directorio al cual se desea copiar el
            //                                              //      archivo, este será el padre que recibe el file.
            Directory sysdirReceiving_M,
            //                                              //File del archivo donde se va a regresar.
            O<FileX> ofileWrited_O
    ) {
        if ( //
                sysfile_I == null //
                ) {
            Test.abort(Test.toLog(sysfile_I, "sysfile_I") + " can not be null");
        }

        //                                                  //Verifica que el archivo y el directorio existan.
        Path syspathFile = sysfile_I.getPath();
        if ( //
                //                                          //Verifica que sea un archivo.
                !syspathFile.isFile() //
                ) {
            Test.abort(Test.toLog(syspathFile.fullPath(), "syspathFile.FullPath") + " file do not exist",
                    Test.toLog(sysfile_I, "sysfile_I"), Test.toLog(syspathFile, "syspathFile"));
        }

        if ( //
                sysdirReceiving_M == null //
                ) {
            Test.abort(Test.toLog(sysdirReceiving_M, "sysdirReceiving_M") + " can not be null");
        }

        Path syspathDirectoryReceiving = sysdirReceiving_M.getPath();
        if ( //
                //                                          //Verifica que sea un directorio.
                !syspathDirectoryReceiving.isDirectory() //
                ) {
            Test.abort(Test.toLog(syspathDirectoryReceiving.fullPath(), "syspathDirectoryReceiving.FullPath")
                    + " directory do not exist",
                    Test.toLog(sysdirReceiving_M, "sysdirReceiving_M"),
                    Test.toLog(syspathDirectoryReceiving, "syspathDirectoryReceiving"),
                    Test.toLog(sysfile_I, "sysfile_I"), Test.toLog(syspathFile, "syspathFile"));
        }

        //                                                  //Verifica que el archivo receptor no exista.
        Path syspathFileToWrite = syspathDirectoryReceiving.addName(syspathFile.name());
        if ( //
                //                                          //El nuevo syspatth existe como DIRECTORIO o FILE.
                syspathFileToWrite.exists() //
                ) {
            Test.abort(
                    Test.toLog(syspathFileToWrite.fullPath(), "syspathFileToWrite.FullPath")
                    + " already exists as directory or file, if it is a file you can try subCopyFileRewrite",
                    Test.toLog(syspathFileToWrite, "syspathFileToWrite"),
                    Test.toLog(sysdirReceiving_M, "sysdirReceiving_M"),
                    Test.toLog(syspathDirectoryReceiving, "syspathDirectoryReceiving"), Test.toLog(sysfile_I, "File_I"),
                    Test.toLog(syspathFile, "syspathFile"));
        }

        try {
            Files.copy(Paths.get(sysfile_I.getPath().fullPath()), Paths.get(syspathFileToWrite.fullPath()),
                    StandardCopyOption.REPLACE_EXISTING);
        } //
        catch (Exception sysexcepError) {
            Test.abort(
                    Test.toLog(sysexcepError, "sysexcepError") + " error in \"Files.copy(Paths.get(File_I.getPath()), "
                    + "Paths.get(syspathFileToWrite.FullPath()), StandardCopyOption.REPLACE_EXISTING);\"",
                    Test.toLog(sysfile_I, "File_I"), Test.toLog(syspathFileToWrite, "syspathFileToWrite"));
        }

        //                                                  //Regresa el nuevo File.
        ofileWrited_O.v = new FileX(syspathFileToWrite);
    }

    //------------------------------------------------------------------------------------------------------------------
    public void deleteContentFromDisk( //
            //                                              //De un directorio elimina los directories o files que
            //                                              //      inician con un prefijo.
            String namePrefix_I
    ) {
        if ( //
                namePrefix_I == null //
                ) {
            Test.abort(Test.toLog(namePrefix_I, "namePrefix_I") + " can not be null");
        }
        
        FileX[] arrsysfile = this.getFiles();
        for (FileX sysfile : arrsysfile) {
            if ( //
                    sysfile.name().startsWith(namePrefix_I) //
                    ) {
                sysfile.deleteFromDisk();
            }
        }

        Directory[] arrsysdir = this.getDirectories();
        for (Directory sysdir : arrsysdir) {
            if ( //
                    sysdir.name().startsWith(namePrefix_I) //
                    ) {
                sysdir.deleteFromDisk(true);
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    /*ACCESS METHODS*/
    //------------------------------------------------------------------------------------------------------------------
    public boolean exists() {
        //                                                  //Tomo el path para analizarlo y poder dar un mejor
        //                                                  //      diagnostico.
        Path syspathTextFile = this.getPath();
        if ( //
                syspathTextFile.isFile()//
                ) {
            Test.abort(
                    Test.toLog(syspathTextFile.fullPath(), "syspathTextFile.FullPath()") + " is a FILE",
                    Test.toLog(this, "this"), Test.toLog(syspathTextFile, "syspathTextFile"));
        }
        
        boolean boolExists;
        try {
            boolExists = this.fileordirThatIsADirectory_Z.exists();
        } //
        catch (Exception sysexcepError) {
            //                                              //Nótese que no puedo desplegar el objeto syspath como lo
            //                                              //      estoy haciento en la mayoría de los diagnósticos.
            Test.abort(Test.toLog(sysexcepError, "sysexcepError") + " error in \"Directory_I.fullPath()\"",
                    Test.toLog(this, "Directory_I"));

            boolExists = false;
        }

        return boolExists;
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
    public FileTime getLastAccessTime( //
            //                                              //Recibe un Directory y se obtiene el tiempo en que se 
            //                                              //      acceso por última vez.
            //                                              //Nota: Este método regresa un FileTime y se debe modificar 
            //                                              //      posteriormente a que regrese UTC.
            ) {
        return this.bfaGet().lastAccessTime();
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
    public Directory[] getDirectories( //
            //                                              //Extrae el conjunto de subdirectorios de un directorio.
            //                                              //Recibe un Directory del cual se quiere información.
            ) {
        java.io.File[] arrfileordirGetDirectoriesAndFiles = this.arrfileordirGetDirectoriesAndFiles();

        ArrayList<Directory> darrsysdirGetDirectories = new ArrayList<>();

        for (java.io.File fileordir : arrfileordirGetDirectoriesAndFiles) {
            if ( //
                    fileordir.isDirectory() //
                    ) {
                Directory sysdir = new Directory(fileordir);
                darrsysdirGetDirectories.add(sysdir);
            }
        }

        //                                                  //Regresa el conjunto de subdirectorios.
        return darrsysdirGetDirectories.toArray(new Directory[0]);
    }

    //------------------------------------------------------------------------------------------------------------------
    public FileX[] getFiles( //
            //                                              //Extrae el conjunto de archivos de un directorio.
            //                                              //DirectoryInfo del cual se quiere información.
            ) {
        java.io.File[] arrfileordirGetDirectoriesAndFiles = this.arrfileordirGetDirectoriesAndFiles();

        ArrayList<FileX> darrsysfileGetFiles = new ArrayList<>();

        for (java.io.File fileordir : arrfileordirGetDirectoriesAndFiles) {
            if ( //
                    fileordir.isFile() //
                    ) {
                FileX sysfile = new FileX(fileordir);
                darrsysfileGetFiles.add(sysfile);
            }
        }

        //                                                  //Regresa el conjunto de files.
        return darrsysfileGetFiles.toArray(new FileX[0]);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    private java.io.File[] arrfileordirGetDirectoriesAndFiles( //
            //                                              //Extrae el conjunto de subdirectorios and files.
    ) {
        //                                                  //Extrae subdirectorios and files
        java.io.File[] arrfileordirGetDirectoriesAndFiles;
        try {
            arrfileordirGetDirectoriesAndFiles = this.z_TowaPrivate_fileordirThatIsADirectory().listFiles();
        } //
        catch (Exception sysexcepError) {
            Test.abort(
                    Test.toLog(sysexcepError, "sysexcepError")
                            + " error in \"this.z_TowaPrivate_fileordirThatIsADirectory().listFiles()\"",
                    Test.toLog(this, "this"));

            arrfileordirGetDirectoriesAndFiles = null;
        }

        //                                                  //Regresa el conjunto de subdirectorios and files
        return arrfileordirGetDirectoriesAndFiles;
    }

    //------------------------------------------------------------------------------------------------------------------
}

//======================================================================================================================
/*END-TASK*/
