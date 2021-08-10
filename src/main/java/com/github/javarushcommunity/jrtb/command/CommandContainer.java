package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.command.annotation.AdminCommand;
import com.github.javarushcommunity.jrtb.javarushclient.JavaRushGroupClient;
import com.github.javarushcommunity.jrtb.service.GroupSubService;
import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import com.github.javarushcommunity.jrtb.service.StatisticsService;
import com.github.javarushcommunity.jrtb.service.TelegramUserService;
import com.google.common.collect.ImmutableMap;

import java.util.List;

import static com.github.javarushcommunity.jrtb.command.CommandName.*;
import static java.util.Objects.nonNull;

/**
 * Container of the {@link Command}s, which are using for handling telegram commands.
 */
public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;
    private final List<String> admins;

    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService,
                            JavaRushGroupClient javaRushGroupClient, GroupSubService groupSubService, List<String> admins, StatisticsService statisticsService) {
        this.admins = admins;

        commandMap = ImmutableMap.<String, Command>builder()
                .put(CommandName.START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService))
                .put(CommandName.STOP.getCommandName(), new StopCommand(sendBotMessageService, telegramUserService))
                .put(CommandName.HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(CommandName.NO.getCommandName(), new NoCommand(sendBotMessageService))
                .put(ADMIN_HELP.getCommandName(), new AdminHelpCommand(sendBotMessageService))
                .put(DELETE_GROUP_SUB.getCommandName(), new DeleteGroupSubCommand(sendBotMessageService, groupSubService, telegramUserService))
                .put(LIST_GROUP_SUB.getCommandName(), new ListGroupSubCommand(sendBotMessageService, telegramUserService))
                .put(ADD_GROUP_SUB.getCommandName(), new AddGroupSubCommand(sendBotMessageService, javaRushGroupClient, groupSubService))
                .put(CommandName.STAT.getCommandName(), new StatCommand(sendBotMessageService, statisticsService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command findCommand(String commandIdentifier, String username) {
        Command orDefault = commandMap.getOrDefault(commandIdentifier, unknownCommand);
        if (isAdminCommand(orDefault)) {
            if (admins.contains(username)) {
                return orDefault;
            } else {
                return unknownCommand;
            }
        }
        return orDefault;
    }

private boolean isAdminCommand(Command command){
        return nonNull(command.getClass().getAnnotation(AdminCommand.class));
}
}
