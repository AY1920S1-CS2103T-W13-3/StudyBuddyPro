package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;

import seedu.address.model.cheatsheet.CheatSheet;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.note.Note;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Note> PREDICATE_SHOW_ALL_NOTES = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<Flashcard> PREDICATE_SHOW_ALL_FLASHCARDS = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<CheatSheet> PREDICATE_SHOW_ALL_CHEATSHEETS = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<Tag> PREDICATE_SHOW_ALL_TAGS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setStudyBuddyBook(ReadOnlyStudyBuddyBook studyBuddyBook);

    /** Returns the AddressBook */
    ReadOnlyStudyBuddyBook getStudyBuddyBook();

    /** Returns an unmodifiable view of the filtered note list */
    ObservableList<Tag> getFilteredTagList();

    /**
     * Updates the filter of the filtered note list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredTagList(Predicate<Tag> predicate);

    /**
     * Returns true if a note with the same identity as {@code note} exists in the address book.
     */
    boolean hasNote(Note note);

    /**
     * Deletes the given note.
     * The note must exist in the address book.
     */
    void deleteNote(Note target);

    /**
     * Adds the given note.
     * {@code note} must not already exist in the address book.
     */
    void addNote(Note note);

    /**
     * Replaces the given note {@code target} with {@code editedNote}.
     * {@code target} must exist in the address book.
     * The note identity of {@code editedNote} must not be the same as another existing note in FiveNotes.
     */
    void setNote(Note target, Note editedNote);

    /** Returns an unmodifiable view of the filtered note list */
    ObservableList<Note> getFilteredNoteList();

    /**
     * Updates the filter of the filtered note list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredNoteList(Predicate<Note> predicate);

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedNote}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedNote} must not be the same as another existing person in FiveNotes.
     */
    void setPerson(Person target, Person editedNote);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    /**
     * Returns true if the same flashcard as {@code flashcard} exists in the application.
     */
    boolean hasFlashcard(Flashcard flashcard);

    /**
     * Adds the given flashcard.
     * {@code flashcard} must not already exist in the application.
     */
    void addFlashcard(Flashcard toAdd);

    /** Returns an unmodifiable view of the filtered flashcard list */
    ObservableList<Flashcard> getFilteredFlashcardList();

    /**
     * Deletes the given flashcard.
     * The flashcard must exist in the flashcard bank.
     */
    void deleteFlashcard(Flashcard target);

    /** Updates the filter of the filtered flashcard list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredFlashcardList(Predicate<Flashcard> predicate);

    /**
     * Adds the given cheatSheet.
     * {@code cheatSheet} must not already exist in the cheatSheet book.
     */
    void addCheatSheet(CheatSheet cheatSheet);

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasCheatSheet(CheatSheet cheatSheet);

    /**
     * Replaces the given cheatSheet {@code target} with {@code editedCheatSheet}.
     * {@code target} must exist in the cheatSheet book.
     * The cheatSheet identity of {@code editedCheatSheet} must not be the same as
     * another existing editedCheatSheet in Cheatsheet.
     */
    void setCheatSheet(CheatSheet target, CheatSheet editedCheatSheet);

    public ObservableList<CheatSheet> getFilteredCheatSheetList();

    public void updateFilteredCheatSheetList(Predicate<CheatSheet> predicate);

    /**
     * Deletes the given cheatSheet.
     * {@code cheatSheet} must exist in the cheatSheet book.
     */
    void deleteCheatSheet(CheatSheet cheatSheet);
}
