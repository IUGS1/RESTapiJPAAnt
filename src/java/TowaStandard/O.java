/*TASK Boxing*/
package TowaStandard;

//                                                          //AUTHOR: Towa (GLG-Gerardo López).
//                                                          //CO-AUTHOR: Towa ().
//                                                          //DATE: February 19, 2016.
//                                                          //PURPOSE:
//                                                          //Base for all Bxxx.
//======================================================================================================================
public class O<T> extends BboxBaseBoxingAbstract
//                                                          //Boxing of a null object of any type.
//                                                          //(For primitives int, long, num, bool, char, str use oint,
//                                                          //       olong, onum, obool, ochar and ostr).
//                                                          //This class is used for passing any object by referencie,
//                                                          //      to simulate the the out parameters of C#.
//                                                          //Notice that it is not allowed to pass an object as _IO
//                                                          //      parameter, but _O parameter is allowed.
//                                                          //For example, to pass an array of ints by as _O parameter.
//                                                          //[(before calling the method)
//                                                          //        Oobj<int[]> oarrintX = new Oobj<int[]>();
//                                                          //(if the object already exists maybe it was received as
//                                                          //parameter or was constructed before calling a previous
//                                                          //method, use the same object)
//                                                          //]
//                                                          //[Example (to extract value returned by method called);
//                                                          //        arrintX = oarrintX.v;
//                                                          //]
//                                                          //[Example (inside method called);
//                                                          //        oarrintX_O.v = desired object;
//                                                          //]
{
    //------------------------------------------------------------------------------------------------------------------
    /*INSTANCE VARIABLE*/

    public T v;

    //------------------------------------------------------------------------------------------------------------------
    /*OBJECT CONSTRUCTORS*/

    //------------------------------------------------------------------------------------------------------------------
    public O(
            //                                              //Box a null object.
            //                                              //this.*[O], assign null.
    ) {
        //                                                  //null is required to indicate no value has been assigned
        this.v = null;
    }
    
    public O(
            //                                              //Box a long.
            //                                              //this.*[O], assign variable.

            T T_I
    ) {
        this.v = T_I;
    }
}
//======================================================================================================================
/*END-TASK*/
