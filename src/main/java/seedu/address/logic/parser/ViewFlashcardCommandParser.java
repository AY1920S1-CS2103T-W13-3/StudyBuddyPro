package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.flashcardcommands.ViewFlashcardCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ViewFlashcardCommand object
 */
public class ViewFlashcardCommandParser implements Parser<ViewFlashcardCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ViewFlashcardCommand
     * and returns a ViewFlashcardCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewFlashcardCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new ViewFlashcardCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewFlashcardCommand.MESSAGE_USAGE), pe);
        }
    }
}
