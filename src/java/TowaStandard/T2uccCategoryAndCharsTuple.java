package TowaStandard;

//======================================================================================================================
public class T2uccCategoryAndCharsTuple extends BtupleAbstract {
    //                                                      //Map Unicode Category to characters.
    //------------------------------------------------------------------------------------------------------------------

    public /*KEY*/ UccUnicodeCategoryEnum ucc;
    public String strChars;

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toLogShort() {
        return "<" + Test.toLog(this.ucc) + ", " + Test.toLog(this.strChars)
                + ">";
    }

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toLogFull() {
        return "<" + Test.toLog(this.ucc, "ucc") + ", " + Test.toLog(this.strChars, "strChars") + ">";
    }

    //------------------------------------------------------------------------------------------------------------------
    public T2uccCategoryAndCharsTuple(UccUnicodeCategoryEnum ucc_I, String strChars_I) {
        super();
        this.ucc = ucc_I;
        this.strChars = strChars_I;
    }

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public int compareTo(Object obj_I) {
        int intCompareTo;
        /*CASE*/
        if ( //
                obj_I instanceof T2uccCategoryAndCharsTuple //
                ) {
            intCompareTo = this.ucc.compareTo(((T2uccCategoryAndCharsTuple) obj_I).ucc);
        } //
        else if ( //
                obj_I instanceof UccUnicodeCategoryEnum //
                ) {
            intCompareTo = this.ucc.compareTo(((UccUnicodeCategoryEnum) obj_I));
        } //
        else {
                Test.abort(
                    Test.toLog(obj_I.getClass(), "obj_I.type") +
                        " is not a compatible CompareTo argument, the options are: t2ucc & ucc",
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
