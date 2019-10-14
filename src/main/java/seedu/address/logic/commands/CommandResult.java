package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;
import java.util.Optional;

import seedu.address.logic.FunctionMode;
import seedu.address.model.cheatsheet.CheatSheet;
import seedu.address.model.flashcard.Flashcard;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;

    /** Help information should be shown to the user. */
    private final boolean showHelp;

    /** The application should exit. */
    private final boolean exit;

    /** The application should toggle to a different function. */
    private final boolean toggle;

    /** Targeted function. */
    private final Optional<FunctionMode> targetMode;

    /** Flashcard to display (if any) */
    private final Optional<Flashcard> flashcard;

    /** Cheatsheet to display (if any) */
    private final Optional<CheatSheet> cheatSheet;

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit,
                         boolean toggle, Optional<FunctionMode> targetMode, Optional<Flashcard> flashcard, Optional<CheatSheet> cheatSheet) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.toggle = toggle;
        this.targetMode = targetMode;
        this.flashcard = flashcard;
        this.cheatSheet = cheatSheet;
    }

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit) {
        this(feedbackToUser, showHelp, exit, false, Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, false, false,
                false, Optional.empty(), Optional.empty(), Optional.empty());
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public boolean isExit() {
        return exit;
    }

    public boolean isToggle() {
        return toggle;
    }

    public Optional<FunctionMode> getTargetMode() {
        return targetMode;
    }

    public Optional<Flashcard> getFlashcard() {
        return flashcard;
    }

    public Optional<CheatSheet> getCheatSheet() {
        return cheatSheet;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && showHelp == otherCommandResult.showHelp
                && exit == otherCommandResult.exit;
    }
    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, showHelp, exit);
    }

}
