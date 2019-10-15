package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_TITLE = new Prefix("ti/");
    public static final Prefix PREFIX_CONTENT = new Prefix("c/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");

    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_QUESTION = new Prefix("q/");
    public static final Prefix PREFIX_ANSWER = new Prefix("ans/");
    public static final Prefix PREFIX_FLASHCARD_TITLE = new Prefix("title/");

    //public static final Prefix PREFIX_CHEATSHEET_TITLE = new Prefix("cti/");
    //public static final Prefix PREFIX_CONTENT = new Prefix("c/");

}
