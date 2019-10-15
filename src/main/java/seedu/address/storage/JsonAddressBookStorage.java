package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyCheatSheetBook;
import seedu.address.model.ReadOnlyFlashcardBook;

/**
 * A class to access AddressBook data stored as a json file on the hard disk.
 */
public class JsonAddressBookStorage implements AddressBookStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonAddressBookStorage.class);

    private Path filePath;

    public JsonAddressBookStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getAddressBookFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook() throws DataConversionException {
        return readAddressBook(filePath);
    }

    /**
     * Similar to {@link #readAddressBook()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlyAddressBook> readAddressBook(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableAddressBook> jsonAddressBook = JsonUtil.readJsonFile(
                filePath, JsonSerializableAddressBook.class);
        if (!jsonAddressBook.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonAddressBook.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException {
        saveAddressBook(addressBook, filePath);
    }

    /**
     * Similar to {@link #saveAddressBook(ReadOnlyAddressBook)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveAddressBook(ReadOnlyAddressBook addressBook, Path filePath) throws IOException {
        requireNonNull(addressBook);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableAddressBook(addressBook), filePath);
    }

    //============== flashcard tools
    @Override
    public Path getFlashcardFilePath() {
        return this.filePath;
    }

    @Override
    public Optional<ReadOnlyFlashcardBook> readFlashcardBook() throws DataConversionException, IOException {
        return Optional.empty();
    }

    @Override
    public Optional<ReadOnlyFlashcardBook> readFlashcardBook(Path filePath)
            throws DataConversionException, IOException {
        return Optional.empty();
    }

    @Override
    public void saveFlashcardBook(ReadOnlyFlashcardBook flashcardBook) throws IOException {
        saveFlashcardBook(flashcardBook, filePath);
    }

    @Override
    public void saveFlashcardBook(ReadOnlyFlashcardBook flashcardBook, Path filePath) throws IOException {
        requireNonNull(flashcardBook);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        //JsonUtil.saveJsonFile(new JsonSerializableFlashcardBook(flashcardBook), filePath);
    }

    //============== cheatsheet tools
    @Override
    public Path getCheatSheetFilePath() {
        return this.filePath;
    }

    @Override
    public Optional<ReadOnlyCheatSheetBook> readCheatSheetBook() throws DataConversionException, IOException {
        return Optional.empty();
    }

    @Override
    public Optional<ReadOnlyCheatSheetBook> readCheatSheetBook(Path filePath)
            throws DataConversionException, IOException {
        return Optional.empty();
    }

    @Override
    public void saveCheatSheetBook(ReadOnlyCheatSheetBook cheatSheetBook) throws IOException {
        saveCheatSheetBook(cheatSheetBook, filePath);
    }

    @Override
    public void saveCheatSheetBook(ReadOnlyCheatSheetBook cheatSheetBook, Path filePath) throws IOException {
        requireNonNull(cheatSheetBook);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        //JsonUtil.saveJsonFile(new JsonSerializableCheatSheetBook(cheatSheetBook), filePath);
    }
}
