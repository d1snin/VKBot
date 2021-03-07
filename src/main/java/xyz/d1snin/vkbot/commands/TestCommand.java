package xyz.d1snin.vkbot.commands;

import ru.codeoff.bots.sdk.objects.Message;
import xyz.d1snin.vkbot.App;

public class TestCommand {
    public TestCommand() {
        App.group.onCommand("test", message ->
                new Message()
                        .from(App.group)
                        .to(message.authorId())
                        .text("ok")
                        .send()
        );
    }
}
