package com.github.javarushcommunity.jrtb.command;

/**
 * Enumeration for {@link Command}'s.
 */
public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    ADMIN_HELP("/ahelp"),
    STAT("/stat"),
    DELETE_GROUP_SUB("/deletegroupsub"),
    ADD_GROUP_SUB("/addgroupsub"),
    LIST_GROUP_SUB("/listgroupsub"),
    NO("/no");


    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
