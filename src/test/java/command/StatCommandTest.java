package command;

import com.github.javarushcommunity.jrtb.command.Command;
import com.github.javarushcommunity.jrtb.command.StatCommand;
import com.github.javarushcommunity.jrtb.service.TelegramUserService;

import static com.github.javarushcommunity.jrtb.command.CommandName.STAT;
import static com.github.javarushcommunity.jrtb.command.StatCommand.STAT_MESSAGE;

public class StatCommandTest extends AbstractCommandTest{
    private TelegramUserService telegramUserService;

    @Override
    String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(STAT_MESSAGE, 0);
    }

    @Override
    Command getCommand() {
        return new StatCommand(sendBotMessageService, telegramUserService);
    }
}
