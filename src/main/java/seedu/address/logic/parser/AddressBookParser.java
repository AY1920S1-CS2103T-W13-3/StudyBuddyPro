package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.commons.core.Messages.SPECIFY_MODE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.LogicManager;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.GlobalTagFilterCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.ListTagCommand;
import seedu.address.logic.commands.SwitchModeCommand;
import seedu.address.logic.commands.cheatsheetcommands.AddCheatSheetCommand;
import seedu.address.logic.commands.cheatsheetcommands.DeleteCheatSheetCommand;
import seedu.address.logic.commands.cheatsheetcommands.EditCheatSheetCommand;
import seedu.address.logic.commands.cheatsheetcommands.FilterCheatSheetByTagCommand;
import seedu.address.logic.commands.cheatsheetcommands.ViewCheatSheetCommand;
import seedu.address.logic.commands.flashcardcommands.AddFlashcardCommand;
import seedu.address.logic.commands.flashcardcommands.DeleteFlashcardCommand;
import seedu.address.logic.commands.flashcardcommands.FilterFlashcardByTagCommand;
import seedu.address.logic.commands.flashcardcommands.ViewFlashcardCommand;
import seedu.address.logic.commands.notecommands.AddNoteCommand;
import seedu.address.logic.commands.notecommands.DeleteNoteCommand;
import seedu.address.logic.commands.notecommands.FilterNoteByTagCommand;
import seedu.address.logic.commands.notecommands.ViewNoteCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = (matcher.group("commandWord")).toLowerCase();
        final String arguments = matcher.group("arguments");

        switch (commandWord) { //global commands?
        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case ListTagCommand.COMMAND_WORD:
            return new ListTagCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case SwitchModeCommand.COMMAND_WORD:
            return new SwitchModeCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case GlobalTagFilterCommand.COMMAND_WORD:
            return new GlobalTagFilterCommandParser().parse(arguments);

        default:

            switch (LogicManager.getMode()) {
            case CHEATSHEET:
                return parseCheatSheetCommands(commandWord, arguments);

            case FLASHCARD:
                return parseFlashcardCommands(commandWord, arguments);

            case NOTE:
                return parseNoteCommands(commandWord, arguments);

            default:
                throw new ParseException(SPECIFY_MODE);
            }
        }
    }

    /**
     * Parses user input into command for execution.
     * @param commandWord the command to execute
     * @param arguments the parameters supplied to command
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    private Command parseCheatSheetCommands(String commandWord, String arguments) throws ParseException {
        switch (commandWord) {
        case AddCheatSheetCommand.COMMAND_WORD:
            return new AddCheatSheetCommandParser().parse(arguments);

        case DeleteCheatSheetCommand.COMMAND_WORD:
            return new DeleteCheatSheetCommandParser().parse(arguments);

        case EditCheatSheetCommand.COMMAND_WORD:
            return new EditCheatSheetCommandParser().parse(arguments);

        case FilterCheatSheetByTagCommand.COMMAND_WORD:
            return new FilterCheatSheetByTagCommandParser().parse(arguments);

        case ViewCheatSheetCommand.COMMAND_WORD:
            return new ViewCheatSheetCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    /**
     * Parses user input into command for execution.
     * @param commandWord the command to execute
     * @param arguments the parameters supplied to command
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    private Command parseFlashcardCommands(String commandWord, String arguments) throws ParseException {
        switch (commandWord) {
        case AddFlashcardCommand.COMMAND_WORD:
            return new AddFlashcardCommandParser().parse(arguments);

        case DeleteFlashcardCommand.COMMAND_WORD:
            return new DeleteFlashcardCommandParser().parse(arguments);

        case FilterFlashcardByTagCommand.COMMAND_WORD:
            return new FilterFlashcardByTagCommandParser().parse(arguments);

        case ViewFlashcardCommand.COMMAND_WORD:
            return new ViewFlashcardCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    /**
     * Parses user input into command for execution.
     * @param commandWord the command to execute
     * @param arguments the parameters supplied to command
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    private Command parseNoteCommands(String commandWord, String arguments) throws ParseException {
        switch (commandWord) {
        case AddNoteCommand.COMMAND_WORD:
            return new AddNoteCommandParser().parse(arguments);

        case DeleteNoteCommand.COMMAND_WORD:
            return new DeleteNoteCommandParser().parse(arguments);

        case FilterNoteByTagCommand.COMMAND_WORD:
            return new FilterNoteByTagCommandParser().parse(arguments);

        case ViewNoteCommand.COMMAND_WORD:
            return new ViewNoteCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }
}

/*
switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case AddNoteCommand.COMMAND_WORD:
            return new AddNoteCommandParser().parse(arguments);

        case AddCheatSheetCommand.COMMAND_WORD:
            return new AddCheatSheetCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case EditCheatSheetCommand.COMMAND_WORD:
            return new EditCheatSheetCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case DeleteNoteCommand.COMMAND_WORD:
            return new DeleteNoteCommandParser().parse(arguments);

        case DeleteCheatSheetCommand.COMMAND_WORD:
            return new DeleteCheatSheetCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ViewNoteCommand.COMMAND_WORD:
            return new ViewNoteCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ListNoteCommand.COMMAND_WORD:
            return new ListNoteCommand();

        case ListTagCommand.COMMAND_WORD:
            return new ListTagCommand();

        case ListCheatSheetCommand.COMMAND_WORD:
            return new ListCheatSheetCommand();

        case DisplayTagsCommand.COMMAND_WORD:
            return new DisplayTagsCommand();

        case FilterByTagCommand.COMMAND_WORD:
            return new FilterByTagCommandParser().parse(arguments);

        case FilterCheatSheetByTagCommand.COMMAND_WORD:
            return new FilterCheatSheetByTagCommandParser().parse(arguments);

        case FilterFlashcardByTagCommand.COMMAND_WORD:
            return new FilterFlashcardByTagCommandParser().parse(arguments);

        case FilterNoteByTagCommand.COMMAND_WORD:
            return new FilterNoteByTagCommandParser().parse(arguments);

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case AddFlashcardCommand.COMMAND_WORD:
            return new AddFlashcardCommandParser().parse(arguments);

        case DeleteFlashcardCommand.COMMAND_WORD:
            return new DeleteFlashcardCommandParser().parse(arguments);

        case SwitchModeCommand.COMMAND_WORD:
            return new SwitchModeCommandParser().parse(arguments);

        case ViewFlashcardCommand.COMMAND_WORD:
            return new ViewFlashcardCommandParser().parse(arguments);

        case ViewCheatSheetCommand.COMMAND_WORD:
            return new ViewCheatSheetCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
 */
