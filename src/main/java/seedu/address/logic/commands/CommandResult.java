package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Objects;

import javafx.util.Pair;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;

    /** Help information should be shown to the user. */
    private final boolean showHelp;

    /** The application should exit. */
    private final boolean exit;

    /** The chat box should be cleared. */
    private final boolean clear;

    private final List<Pair<Pair<Month, Year>, Integer>>  statisticResult;

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit, boolean clear) {
        this(feedbackToUser, showHelp, exit, clear, null);
    }

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit, boolean clear
            , List<Pair<Pair<Month, Year>, Integer>>  statisticResult) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.clear = clear;
        this.statisticResult = statisticResult;
    }

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, List<Pair<Pair<Month, Year>, Integer>> statisticResult) {
        this(feedbackToUser, false, false, false, statisticResult);
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, false, false, false);
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

    public boolean isClear() {
        return clear;
    }

    public boolean hasStatisticsResult() {
        return !Objects.isNull(this.statisticResult);
    }

    public List<Pair<Pair<Month, Year>, Integer>>  getStatisticResult() {
        return statisticResult;
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
                && clear == otherCommandResult.clear
                && exit == otherCommandResult.exit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, showHelp, exit, clear);
    }

}
