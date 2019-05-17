/*TASK Boxing Boxing of primitives*/
package TowaStandard;

//                                                          //AUTHOR: Towa (GLG-Gerardo López).
//                                                          //CO-AUTHOR: Towa ().
//                                                          //DATE: February 19, 2016.
//                                                          //PURPOSE:
//                                                          //Base for all Bxxx.
//======================================================================================================================
public /*OPEN*/ class Oint extends BboxBaseBoxingAbstract
//                                                          //Boxing int.
{
    //------------------------------------------------------------------------------------------------------------------
    /*INSTANCE VARIABLE*/

    public int /*NSTD*/v/*END-NSTD*/;

    //------------------------------------------------------------------------------------------------------------------
    /*OBJECT CONSTRUCTORS*/

    //------------------------------------------------------------------------------------------------------------------
    public Oint(
            //                                              //Box a int.
            //                                              //this.*[O], assign minimum value.
    ) {
        //                                                  //To show non assigned value
        this.v = Integer.MIN_VALUE;
    }

    public Oint(
            //                                              //Box a int.
            //                                              //this.*[O], assign variable.

            int int_I
    ) {
        this.v = int_I;
    }
}
//======================================================================================================================
/*END-TASK*/