package seedu.address.logic.commands.person;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.commandresults.GlobalCommandResult;
import seedu.address.model.Model;
import seedu.address.model.person.PersonContainsTagPredicate;

/**
 * Command to filter person(s) with the related tag(s).
 */

public class FilterPersonByTagCommand extends Command {

    public static final String COMMAND_WORD = "filter";

    public static final String MESSAGE_USAGE = "filter by tags. Find all related persons with the specified \n"
            + "tags. Example : filter [neighbours] [friends]";

    public static final String FILTER_TAG_MESSAGE_SUCCESS = "Filter by tag(s) : ";

    private String[] tagKeywords;

    private final PersonContainsTagPredicate tagPredicate;

    /**
     * Constructor for filter by tag.
     * @param predicate to test on an person object to see if he has the tag.
     * @param tagKeywords the tags provided by user input to test on the person.
     */
    public FilterPersonByTagCommand(PersonContainsTagPredicate predicate, String[] tagKeywords) {
        this.tagPredicate = predicate;
        this.tagKeywords = tagKeywords;
    }

    /**
     * Displays the tags entered in the display
     * @return string of the tags keyed in
     */
    public String displayTagKeywords() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tagKeywords.length; i++) {
            if (i != tagKeywords.length - 1) {
                sb.append(tagKeywords[i] + ", ");
            } else {
                sb.append(tagKeywords[i]);
            }
        }
        return sb.toString();
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(tagPredicate);
        return new GlobalCommandResult(FILTER_TAG_MESSAGE_SUCCESS + displayTagKeywords());
    }
}
