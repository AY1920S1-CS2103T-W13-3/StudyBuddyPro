package seedu.address.logic.commands.note;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.EXPECTED_VIEW_SAMPLE;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showNoteAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_NOTE;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_NOTE;
import static seedu.address.testutil.TypicalNotes.getTypicalNoteList;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.commandresults.NoteCommandResult;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.note.Note;

/**
 * Contains integration tests (interaction with the Model) for {@code ViewNoteCommand}.
 */
public class ViewRawNoteCommandTest {
    private Model model = new ModelManager(getTypicalNoteList(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalNoteList(), new UserPrefs());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Note noteToView = model.getFilteredNoteList().get(INDEX_FIRST_NOTE.getZeroBased());
        ViewNoteCommand viewNoteCommand = new ViewNoteCommand(INDEX_FIRST_NOTE);

        String expectedMessage = String.format(EXPECTED_VIEW_SAMPLE, noteToView);

        NoteCommandResult noteCommandResult = new NoteCommandResult(expectedMessage, Optional.of(noteToView));

        assertCommandSuccess(viewNoteCommand, model, noteCommandResult, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredNoteList().size() + 1);
        ViewNoteCommand viewNoteCommand = new ViewNoteCommand(outOfBoundIndex);

        assertCommandFailure(viewNoteCommand, model, Messages.MESSAGE_INVALID_NOTE_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showNoteAtIndex(model, INDEX_FIRST_NOTE);

        Note noteToView = model.getFilteredNoteList().get(INDEX_FIRST_NOTE.getZeroBased());
        ViewNoteCommand viewNoteCommand = new ViewNoteCommand(INDEX_FIRST_NOTE);

        String expectedMessage = String.format(EXPECTED_VIEW_SAMPLE, noteToView);

        Model expectedModel = new ModelManager(model.getStudyBuddyPro(), new UserPrefs());
        showNoteAtIndex(expectedModel, INDEX_FIRST_NOTE);

        assertCommandSuccess(viewNoteCommand, model, new NoteCommandResult(expectedMessage, Optional.of(noteToView)),
                expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showNoteAtIndex(model, INDEX_FIRST_NOTE);

        Index outOfBoundIndex = INDEX_SECOND_NOTE;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getStudyBuddyPro().getNoteList().size());

        ViewNoteCommand viewNoteCommand = new ViewNoteCommand(outOfBoundIndex);

        assertCommandFailure(viewNoteCommand, model, Messages.MESSAGE_INVALID_NOTE_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        ViewNoteCommand viewFirstNoteCommand = new ViewNoteCommand(INDEX_FIRST_NOTE);
        ViewNoteCommand viewSecondNoteCommand = new ViewNoteCommand(INDEX_SECOND_NOTE);

        // same object -> returns true
        assertTrue(viewFirstNoteCommand.equals(viewFirstNoteCommand));

        // same values -> returns true
        ViewNoteCommand viewFirstNoteCommandCopy = new ViewNoteCommand(INDEX_FIRST_NOTE);
        assertTrue(viewFirstNoteCommand.equals(viewFirstNoteCommandCopy));

        // different types -> returns false
        assertFalse(viewFirstNoteCommand.equals(1));

        // null -> returns false
        assertFalse(viewFirstNoteCommand.equals(null));

        // different note -> returns false
        assertFalse(viewFirstNoteCommand.equals(viewSecondNoteCommand));
    }
}
