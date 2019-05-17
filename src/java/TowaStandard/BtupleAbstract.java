/*TASK BtupleBaseTupleAbstract*/
package TowaStandard;

//                                                          //AUTHOR: Towa (GLG-Gerardo López).
//                                                          //CO-AUTHOR: Towa ().
//                                                          //DATE: January 2, 2016.
//                                                          //PURPOSE:
//                                                          //Base for all tuples.
//=====================================================================================================================
public abstract class BtupleAbstract extends BobjBaseObjectAbstract implements Comparable {
    //                                                      //Base class for all tuple defined by user.
    //                                                      //The purpose is to have a unique class to identify all
    //                                                      //      tuples.
    //                                                      //"key" puede ser simple o múltiple (varias "key" en orden
    //                                                      //      de jerarquía son la llave).
    //                                                      //En ambos casos Array.Sort(arrtnxxxx) o
    //                                                      //      Array.Sort(arrtnxxxx, arrobj).
    //                                                      //1. Cuando "key" es simple:
    //                                                      //1a. Ver 3 ejemplos en SAI Tech.cs.
    //                                                      //1b. Array.BinarySearch(arrtnxxx, objKey).
    //                                                      //2. Cuando "key" es múltiple:
    //                                                      //2a. Ver ejemplo T6mkeMultipleKeyExampleTuple.cs en
    //                                                      //      TowaInfrastructure.
    //                                                      //2b. Array.BinarySearch(arrtnxxx, tnxxxKey), con las keys
    //                                                      //      se debe construir un tnxxx usando el constructor de
    //                                                      //      "key".

    //-----------------------------------------------------------------------------------------------------------------
    protected BtupleAbstract( //
            //                                              //Inicializa la parte más abstracta de cada tuple.
            //                                              //this.*[O], nada.
            ) {
        super();
    }

    //-----------------------------------------------------------------------------------------------------------------
    @Override
    public int compareTo(Object obj_I) {
        //                                                  //Este método se debe implementar en todas las tuplas
        //                                                  //      que tienen "key" la cual se requiere para poder
        //                                                  //      usar los métodos Array.Sort y Array.BinarySearch.
        Test.abort(Test.toLog(this.getClass(), "this.type") + " this tuple does not implement CompareTo()",
                Test.toLog(obj_I.getClass(), "obj_I.type"));

        return 0;
    }

    //-----------------------------------------------------------------------------------------------------------------
}
//=====================================================================================================================
/*END-TASK*/
