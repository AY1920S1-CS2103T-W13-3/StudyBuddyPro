package seedu.address.model.flashcard;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.StudyBuddyItem;
import seedu.address.model.tag.Tag;

/**
 * Represents a flashcard in the StudyBuddy application.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Flashcard implements StudyBuddyItem {

    private final Question question;
    private final Answer answer;
    private final Title title;

    // Data fields
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Flashcard(Question question, Answer answer, Title title, Set<Tag> tags) {
        requireAllNonNull(question, answer, tags);
        this.question = question;
        this.answer = answer;
        this.title = title;
        this.tags.addAll(tags);
    }

    public Question getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public Title getTitle() {
        return title;
    }

    /**
     * Returns whether the flashcard contains a question in the form of a image file.
     */
    public boolean isImageFlashcard() {
        return false;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    public boolean containsTag(Tag tag) {
        return this.tags.contains(tag);
    }

    /**
     * Returns true if both flashcards have all the same fields.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Flashcard)) {
            return false;
        }

        Flashcard otherFlashcard = (Flashcard) other;
        return otherFlashcard.getQuestion().equals(getQuestion())
                && otherFlashcard.getAnswer().equals(getAnswer())
                && otherFlashcard.getTitle().equals(getTitle())
                && otherFlashcard.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(question, answer, title, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Question: ")
                .append(getQuestion())
                .append(" Answer: ")
                .append(getAnswer())
                .append(" Title: ")
                .append(getTitle())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }
}
