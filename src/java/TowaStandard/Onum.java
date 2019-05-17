/*TASK Boxing Boxing of primitives*/
package TowaStandard;

//                                                          //AUTHOR: Towa (GLG-Gerardo López).
//                                                          //CO-AUTHOR: Towa ().
//                                                          //DATE: February 19, 2016.
//                                                          //PURPOSE:
//                                                          //Base for all Bxxx.
//=====================================================================================================================
public /*OPEN*/ class Onum extends BboxBaseBoxingAbstract
//                                                          //Boxing num.
{
    //-----------------------------------------------------------------------------------------------------------------
    /*INSTANCE VARIABLE*/

    public double /*NSTD*/v/*END-NSTD*/;

    //-----------------------------------------------------------------------------------------------------------------
    /*OBJECT CONSTRUCTORS*/

    //-----------------------------------------------------------------------------------------------------------------
    public Onum(
            //                                              //Box a num.
            //                                              //this.*[O], assign minimum value.
    ) {
        //                                                  //To show non assigned value
        this.v = Double.NaN;
    }

    public Onum(
            //                                              //Box a num.
            //                                              //this.*[O], assign variable.

            double num_I
    ) {
        this.v = num_I;
    }
}
//=====================================================================================================================
/*END-TASK*/
