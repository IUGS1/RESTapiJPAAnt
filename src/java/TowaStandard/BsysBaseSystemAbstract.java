package TowaStandard;

//======================================================================================================================
public abstract class BsysBaseSystemAbstract extends BobjBaseObjectAbstract {
    //                                                      //Base for added system class's (Ex. PathX).
    //                                                      //The purpose is to have a unique class to identify all
    //                                                      //      system addition class's.

    //------------------------------------------------------------------------------------------------------------------
    /*INSTANCE VARIABLES*/
    //                                                      //NO INSTANCE VARIABLES
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toLogShort( //
            //                                              //THIS METHOD SHOULD BE IMPLEMENTED IN EVERY TUPLE.
            //                                              //Produces a SHORT version of information for each of its
            //                                              //      item.
            //                                              //Example:
            //                                              //<item, item, ..., item>
            //                                              //this[I], all its instance variables.
            ) {
        Test.abort("SOMETHING IS WRONG!!!, strToShort() should not be call in "
                + Test.toLog(this.getClass(), "this.Type"));

        return null;
    }

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toLogFull( //
            //                                              //THIS METHOD SHOULD BE IMPLEMENTED IN EVERY TUPLE.
            //                                              //Produces a FULL version of information for each of its
            //                                              //      item.
            //                                              //Example:
            //                                              //prefix{???(item), ???(item), ..., ???(item)}
            //                                              //this[I], all its instance variables.
            ) {
        Test.abort("SOMETHING IS WRONG!!!, strToShort() should not be call in "
                + Test.toLog(this.getClass(), "this.Type"));

        return null;
    }

    //------------------------------------------------------------------------------------------------------------------
    /*OBJECT CONTRUCTORS*/
    //------------------------------------------------------------------------------------------------------------------
    protected BsysBaseSystemAbstract( //
            //                                              //Inicializa la parte más abstracta de cada tuple.
            //                                              //this.*[O], nada. 
            ) {
        super();
    }

    //------------------------------------------------------------------------------------------------------------------
}

//======================================================================================================================
