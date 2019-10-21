package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.HashSet;
import java.util.Set;

import seedu.address.logic.commands.cheatsheetcommands.FilterCheatSheetByTagCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.cheatsheet.CheatSheetContainsTagPredicate;
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FilterCheatSheetByTagCommandParser implements Parser<FilterCheatSheetByTagCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FilterCheatSheetByTagCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCheatSheetByTagCommand.MESSAGE_USAGE));
        }

        String[] tagKeywords = trimmedArgs.split("\\s+");
        Set<Tag> tags = new HashSet<>();
        // copy to array of tags
        for (String s : tagKeywords) {
            tags.add(new Tag(s));
        }
        return new FilterCheatSheetByTagCommand(new CheatSheetContainsTagPredicate(tags), tagKeywords);
    }

}
