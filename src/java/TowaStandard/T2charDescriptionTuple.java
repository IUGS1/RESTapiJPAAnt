package TowaStandard;

//======================================================================================================================
public class T2charDescriptionTuple extends BtupleAbstract {

    //                                                      //Map special character description.
    //------------------------------------------------------------------------------------------------------------------
    public /*KEY*/ char charX;
    public String strDESCRIPTION;

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toLogShort() {
        return "<" + Test.toLog(this.charX) + ", "
                + Test.toLog(this.strDESCRIPTION) + ">";
    }

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toLogFull() {
        return "<" + Test.toLog(this.charX, "charX") + ", " + Test.toLog(this.strDESCRIPTION, "strDESCRIPTION")
                + ">";
    }

    //------------------------------------------------------------------------------------------------------------------
    public T2charDescriptionTuple(char charCHAR_I, String strDESCRIPTION_I) {
        super();
        this.charX = charCHAR_I;
        this.strDESCRIPTION = strDESCRIPTION_I;
    }

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public int compareTo(Object obj_I) {
        int intCompareTo;
        /*CASE*/
        if ( //
                obj_I instanceof T2charDescriptionTuple //
                ) {
            intCompareTo = Character.compare(this.charX, ((T2charDescriptionTuple) obj_I).charX);
        } //
        else if ( //
                obj_I instanceof Character //
                ) {
            intCompareTo = Character.compare(this.charX, (char) obj_I);
        } //
        else {
            Test.abort(
                Test.toLog(obj_I.getClass(), "obj_I.type") +
                    " is not a compatible CompareTo argument, the options are: t2char & char",
                Test.toLog(this.getClass(), "this.type"));

            intCompareTo = -1;
        }
        /*CASE*/

        return intCompareTo;
    }

    //------------------------------------------------------------------------------------------------------------------
}
//======================================================================================================================
/*END-TASK*/
