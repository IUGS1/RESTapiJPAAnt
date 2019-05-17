/*TASK Boxing Boxing of primitives*/
package TowaStandard;

//                                                          //AUTHOR: Towa (GLG-Gerardo López).
//                                                          //CO-AUTHOR: Towa ().
//                                                          //DATE: February 19, 2016.
//                                                          //PURPOSE:
//                                                          //Base for all Bxxx.
//======================================================================================================================
public /*OPEN*/ class Olong extends BboxBaseBoxingAbstract
//                                                          //Boxing long.
{
    //------------------------------------------------------------------------------------------------------------------
    /*INSTANCE VARIABLE*/

    public long /*NSTD*/v/*END-NSTD*/;

    //------------------------------------------------------------------------------------------------------------------
    /*OBJECT CONSTRUCTORS*/

    //------------------------------------------------------------------------------------------------------------------
    public Olong(
            //                                              //Box a long.
            //                                              //this.*[O], assign minimum value.
    ) {
        //                                                  //To show non assigned value
        this.v = Long.MIN_VALUE;
    }

    public Olong(
            //                                              //Box a long.
            //                                              //this.*[O], assign variable.

            long long_I
    ) {
        this.v = long_I;
    }
}
//=====================================================================================================================
/*END-TASK*/
