package seedu.address.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";

    public static final String MESSAGE_INVALID_NOTE_DISPLAYED_INDEX = "The note index provided is invalid!";
    public static final String MESSAGE_NOTES_LISTED_OVERVIEW = "%1$d notes listed!";
    public static final String MESSAGE_MATCHING_NOTE_FOUND = "Note matching the title exists.";
    public static final String MESSAGE_NO_MATCHING_NOTE_FOUND = "No note with that title exists!";
    public static final String MESSAGE_INCORRECT_NOTE_FRAGMENT_FORMAT = "Incorrect tagging format for note "
            + "highlights! Use 'C/' rather than 'c/', and 'TAG/' rather than 'tag/'!";

    public static final String MESSAGE_INVALID_FLASHCARD_DISPLAYED_INDEX = "The flashcard index provided is invalid";
    public static final String MESSAGE_NO_FLASHCARD_LOADED = "No flashcard has been loaded";
    public static final String MESSAGE_ANSWER_ALREADY_LOADED = "Answer has already been loaded";

    public static final String MESSAGE_INVALID_CHEATSHEET_DISPLAYED_INDEX = "The cheatsheet index provided is invalid";
    public static final String MESSAGE_INVALID_CHEATSHEET_CONTENT_DISPLAYED_INDEX = "The content index "
            + "provided is invalid";

    public static final String MESSAGE_TAG_LIMIT_EXCEEDED = "Sorry! A StudyBuddyItem can have no more than 10 tags.";

    public static final String SPECIFY_MODE = "Please specify a mode to start with: Cheatsheet, Flashcard or Note";

    public static final String ADD = "add";
    public static final String DELETE = "delete";
    public static final String EDIT = "edit";
    public static final String VIEW = "view";
    public static final String VIEW_RAW = "viewraw";
    public static final String LIST = "list";
    public static final String FILTER = "filter";
    public static final String FILTER_ALL = "filterall";

    public static final String TIMETRIAL = "timetrial";
    public static final String SHOW = "show";
}
