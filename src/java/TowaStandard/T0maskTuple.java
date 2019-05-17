package TowaStandard;

import java.time.*;

//======================================================================================================================
public class T0maskTuple extends BtupleAbstract {
    //                                                  //Conjunto de parámetors para "mask" la información de
    //                                                  //      pruebas que requiren Comparación Automática.
    //                                                  //(EN EL FUTURO SE PUEDEN AÑADIR MÁS VALORES, SE PUEDEN
    //                                                  //      VARIOS CONSTURCTORES).
    //

    //--------------------------------------------------------------------------------------------------------------
    //                                                  //Conjunto de directorios a enmascarar, esto es, todos los
    //                                                  //      path que pertenecen a alguno de estos directorios,
    //                                                  //      el directorio es enmascarado (el inicio de full path
    //                                                  //      se substituye con strMASK).
    public Path[] arrsyspathDirectory;

    //                                                  //Cuando se requiere un tdtNow, en ves de tomar el .Now del
    //                                                  //      del sistema se toma este dt, a los subsecuentes
    //                                                  //      se les agrega numDeltaSeconds del arreglo en el
    //                                                  //      siguiente orden (Ej. si se tienen 4 deltas en el
    //                                                  //      arreglo, se toma 0, 1, 2, 3, 0, 1, ....).
    public LocalDateTime dtNowBase;
    public double[] arrnumDeltaSeconds;

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toLogShort() {
        return "<" + Test.toLog(this.arrsyspathDirectory) + ", "
                + Test.toLog(this.dtNowBase) + ", "
                + Test.toLog(this.arrnumDeltaSeconds) + ">";
    }

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toLogFull() {
        return "<" + Test.toLog(this.arrsyspathDirectory, "arrsyspathDirectory") + ", "
                + Test.toLog(this.dtNowBase, "tsNowBase") + ", "
                + Test.toLog(this.arrnumDeltaSeconds, "arrnumDeltaSeconds") + ">";
    }

    //------------------------------------------------------------------------------------------------------------------
    public T0maskTuple(Path[] arrsyspathDirectory_I, LocalDateTime dtNowBase_I, double[] arrnumDeltaSeconds_I) {
        super();

        this.arrsyspathDirectory = arrsyspathDirectory_I;
        this.dtNowBase = dtNowBase_I;
        this.arrnumDeltaSeconds = arrnumDeltaSeconds_I;
    }

    //------------------------------------------------------------------------------------------------------------------
}
//======================================================================================================================
/*END-TASK*/
