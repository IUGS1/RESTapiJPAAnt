/*TASK Boxing Boxing of primitives*/
package TowaStandard;

//                                                          //AUTHOR: Towa (GLG-Gerardo López).
//                                                          //CO-AUTHOR: Towa ().
//                                                          //DATE: February 19, 2016.
//                                                          //PURPOSE:
//                                                          //Base for all Bxxx.

//======================================================================================================================
public /*OPEN*/ class Obool extends BboxBaseBoxingAbstract
//                                                          //Boxing bool.
{
    //------------------------------------------------------------------------------------------------------------------
    /*INSTANCE VARIABLE*/

    public boolean /*NSTD*/v/*END-NSTD*/;

    //------------------------------------------------------------------------------------------------------------------
    /*OBJECT CONSTRUCTORS*/

    //------------------------------------------------------------------------------------------------------------------
    public Obool(
            //                                                  //Box a bool.
            //                                                  //this.*[O], assign variable.
    ) {
        //                                                      //No hay forma de asignar un valor atípico con el
        //                                                      //      propósito de indicar que aún no se ha asignado
        //                                                      //      valor.
        this.v = false;
    }

    public Obool(
            //                                                  //Box a bool.
            //                                                  //this.*[O], assign variable.

            boolean bool_I
    ) {
        this.v = bool_I;
    }
}
//======================================================================================================================
/*END-TASK*/
