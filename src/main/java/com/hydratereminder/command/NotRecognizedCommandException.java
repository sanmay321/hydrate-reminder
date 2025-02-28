package com.hydratereminder.command;

import static com.hydratereminder.Commons.HYDRATE_COMMAND_ALIAS;
import static com.hydratereminder.Commons.RUNELITE_COMMAND_PREFIX;

public class NotRecognizedCommandException extends RuntimeException {
    private final String reason;

    public NotRecognizedCommandException(String unsupportedCommandName) {
        this.reason = String.format(
                "%s%s %s is not supported command",
                RUNELITE_COMMAND_PREFIX, HYDRATE_COMMAND_ALIAS, unsupportedCommandName
        );
    }

    public String getReason() {
        return reason;
    }
}
