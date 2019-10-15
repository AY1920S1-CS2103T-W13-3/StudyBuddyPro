package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyCheatSheetBook;
import seedu.address.model.ReadOnlyFlashcardBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * Manages storage of AddressBook data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private AddressBookStorage addressBookStorage;
    private UserPrefsStorage userPrefsStorage;


    public StorageManager(AddressBookStorage addressBookStorage, UserPrefsStorage userPrefsStorage) {
        super();
        this.addressBookStorage = addressBookStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }


    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ AddressBook methods ==============================

    @Override
    public Path getAddressBookFilePath() {
        return addressBookStorage.getAddressBookFilePath();
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook() throws DataConversionException, IOException {
        return readAddressBook(addressBookStorage.getAddressBookFilePath());
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return addressBookStorage.readAddressBook(filePath);
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException {
        saveAddressBook(addressBook, addressBookStorage.getAddressBookFilePath());
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        addressBookStorage.saveAddressBook(addressBook, filePath);
    }

    // ================ CheatSheet methods ==============================

    @Override
    public Path getCheatSheetFilePath() {
        return addressBookStorage.getCheatSheetFilePath();
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
        saveCheatSheetBook(cheatSheetBook, addressBookStorage.getCheatSheetFilePath());
    }

    @Override
    public void saveCheatSheetBook(ReadOnlyCheatSheetBook cheatSheetBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        addressBookStorage.saveCheatSheetBook(cheatSheetBook, filePath);
    }

    // ================ Flashcard methods ==============================
    @Override
    public Path getFlashcardFilePath() {
        return addressBookStorage.getFlashcardFilePath();
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
        saveFlashcardBook(flashcardBook, addressBookStorage.getFlashcardFilePath());
    }

    @Override
    public void saveFlashcardBook(ReadOnlyFlashcardBook flashcardBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        addressBookStorage.saveFlashcardBook(flashcardBook, filePath);
    }

}
