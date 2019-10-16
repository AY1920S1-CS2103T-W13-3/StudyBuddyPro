package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyStudyBuddyBook;
import seedu.address.model.ReadOnlyCheatSheetBook;

/**
 * Represents a storage for {@link seedu.address.model.CheatSheetBook}.
 */

public interface CheatSheetBookStorage {

    /**
     * @return the datapath of the file
     */
    Path getCheatSheetBookFilePath();

    /**
     * Returns AddressBook data as a {@link ReadOnlyStudyBuddyBook}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlyCheatSheetBook> readCheatSheetBook() throws DataConversionException, IOException;

    /**
     * @see #getCheatSheetBookFilePath()
     */
    Optional<ReadOnlyCheatSheetBook> readCheatSheetBook(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyCheatSheetBook} to the storage.
     * @param cheatSheetBook cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveCheatSheetBook(ReadOnlyCheatSheetBook cheatSheetBook) throws IOException;

    /**
     * @see #saveCheatSheetBook(ReadOnlyCheatSheetBook);
     */
    void saveCheatSheetBook(ReadOnlyCheatSheetBook cheatSheetBook, Path filePath) throws IOException;
}
