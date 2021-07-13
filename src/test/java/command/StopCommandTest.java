package command;

import com.github.javarushcommunity.jrtb.command.Command;
import com.github.javarushcommunity.jrtb.command.StopCommand;
import com.github.javarushcommunity.jrtb.service.TelegramUserService;
import org.junit.jupiter.api.DisplayName;

import static com.github.javarushcommunity.jrtb.command.CommandName.STOP;
import static com.github.javarushcommunity.jrtb.command.StopCommand.STOP_MESSAGE;

@DisplayName("Unit-level testing for StopCommand")
public class StopCommandTest extends AbstractCommandTest {

    private TelegramUserService telegramUserService;

    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService, telegramUserService);
    }
}
