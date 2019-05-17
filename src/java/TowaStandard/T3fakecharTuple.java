package TowaStandard;

//======================================================================================================================
public class T3fakecharTuple extends BtupleAbstract {
    //                                                      //Map fake character to description.
    //                                                      //A "fake character" is a character thats looks like "other"
    //                                                      //      but its code is diferente.
    //                                                      //Ej. there exist several character that on screen and
    //                                                      //      printer looks IDENTICAL to A but they ARE NOT the
    //                                                      //      same "A" that you get when you key "A" on your
    //                                                      //      keyboard.
    //                                                      //THERE ARE MANY "FAKE" CHARACTERS.
    //------------------------------------------------------------------------------------------------------------------

    public /*KEY*/ char charFAKE;
    //                                                      //This should be equal to charFake, but should be "enter" in
    //                                                      //      \x???? format.
    //                                                      //The intention is to "see" the hexadecimal code of
    //                                                      //      the character.
    public char charHEX;
    //                                                      //Form: "A(x????) Fake"
    public String strDESCRIPTION;

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toLogShort() {
        return "<" + Test.toLog(this.charFAKE) + ", " + Test.toLog(this.charHEX)
                + ", " + Test.toLog(this.strDESCRIPTION) + ">";
    }

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toLogFull() {
        return "<" + Test.toLog(this.charFAKE, "charFAKE") + ", " + Test.toLog(this.charHEX, "charHEX") + ", "
                + Test.toLog(this.strDESCRIPTION, "strDESCRIPTION") + ">";
    }

    //------------------------------------------------------------------------------------------------------------------
    public T3fakecharTuple(char charFAKE_I, char charHEX_I, String strDESCRIPTION_I) {
        super();
        this.charFAKE = charFAKE_I;
        this.charHEX = charHEX_I;
        this.strDESCRIPTION = strDESCRIPTION_I;
    }

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public int compareTo(Object obj_I) {
        int intCompareTo;
        /*CASE*/
        if ( //
                obj_I instanceof T3fakecharTuple //
                ) {
            intCompareTo = Character.compare(this.charFAKE, ((T3fakecharTuple) obj_I).charFAKE);
        } //
        else if ( //
                //                                              //Originally it was intended as an instanceof primitive
                //                                              //      char, however, in java, primitives get wrapped, so
                //                                              //      a char in this method will be a Character.
                obj_I instanceof Character //
                ) {
            intCompareTo = Character.compare(this.charFAKE, (char) obj_I);
        } //
        else {
            Test.abort(
                Test.toLog(obj_I.getClass(), "obj_I.type") +
                    " is not a compatible CompareTo argument, the options are: t3fakechar & char",
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
