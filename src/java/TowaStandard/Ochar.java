/*TASK Boxing Boxing of primitives*/
package TowaStandard;

//                                                          //AUTHOR: Towa (GLG-Gerardo López).
//                                                          //CO-AUTHOR: Towa ().
//                                                          //DATE: February 19, 2016.
//                                                          //PURPOSE:
//                                                          //Base for all Bxxx.
//=====================================================================================================================
public /*OPEN*/ class Ochar extends BboxBaseBoxingAbstract
//                                                          //Boxing char.
{
    //-----------------------------------------------------------------------------------------------------------------
    /*INSTANCE VARIABLE*/

    public char /*NSTD*/v/*END-NSTD*/;

    //-----------------------------------------------------------------------------------------------------------------
    /*OBJECT CONSTRUCTORS*/

    //-----------------------------------------------------------------------------------------------------------------
    public Ochar(
            //                                              //Box a char.
            //                                              //this.*[O], assign u0000.
    ) {
        //                                                  //To show non assigned value
        this.v = '\u0000';
    }

    public Ochar(
            //                                              //Box a char.
            //                                              //this.*[O], assign variable.

            char char_I
    ) {
        this.v = char_I;
    }
}
//=====================================================================================================================
/*END-TASK*/
