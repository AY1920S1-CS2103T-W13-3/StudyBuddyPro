package seedu.address.logic.commands.global;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.GLOBAL_TAG_FILTER;

import java.util.ArrayList;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.commandresults.GlobalCommandResult;
import seedu.address.model.Model;
import seedu.address.model.StudyBuddyItem;
import seedu.address.model.StudyBuddyItemContainsTagPredicate;
import seedu.address.model.cheatsheet.CheatSheet;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.note.Note;

/**
 * Globally searches for any StudyBuddyItem that has tags which matches the user input of keywords.
 */

public class GlobalTagFilterCommand extends Command {

    public static final String COMMAND_WORD = GLOBAL_TAG_FILTER;

    public static final String MESSAGE_USAGE = "filters every studyBuddy item by a tag."
            + "\nexample usage : globaltagfilter cs2100";

    public static final String FILTER_TAG_MESSAGE_SUCCESS = "Filter the whole StudyBuddy by tag(s) : ";

    private String[] tagKeywords;

    private final StudyBuddyItemContainsTagPredicate tagPredicate;

    /**
     * Constructor for filter by tag.
     * @param predicate to test on an note object to see if it has the tag.
     * @param tagKeywords the tags provided by user input to test on the note.
     */
    public GlobalTagFilterCommand(StudyBuddyItemContainsTagPredicate predicate, String[] tagKeywords) {
        this.tagPredicate = predicate;
        this.tagKeywords = tagKeywords;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        ArrayList<StudyBuddyItem> tagListResult = model.collectTaggedItems(tagPredicate);
        StringBuilder sb = new StringBuilder("");
        for (StudyBuddyItem sbi : tagListResult) {
            if (sbi instanceof Flashcard) {
                sb.append("Flashcard : ");
            }
            if (sbi instanceof Note) {
                sb.append("Note : ");
            }
            if (sbi instanceof CheatSheet) {
                sb.append("CheatSheet : ");
            }
            sb.append(sbi.toString());
            sb.append("\n");
        }
        return new GlobalCommandResult(FILTER_TAG_MESSAGE_SUCCESS
                + "\n" + FilterByTagCommand.displayTagKeywords(tagKeywords)
                + "\n" + sb.toString());
    }
}
