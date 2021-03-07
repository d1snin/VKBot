package xyz.d1snin.vkbot.commands;

import ru.codeoff.bots.keyboard.Button;
import ru.codeoff.bots.keyboard.ButtonColor;
import ru.codeoff.bots.keyboard.Keyboard;
import ru.codeoff.bots.sdk.objects.Message;
import xyz.d1snin.vkbot.App;
import xyz.d1snin.vkbot.util.AnimeList;

public class AnimeCommand {
    public AnimeCommand() {
        Keyboard keys = Keyboard.of(new Button("Anime", ButtonColor.POSITIVE));
        App.group.onCommand("Anime".toLowerCase(), message ->
                new Message()
                .from(App.group)
                .to(message.authorId())
                .text("Fetching picture...")
                .send()
        );
        App.group.onCommand("Anime".toLowerCase(), message ->
                new Message()
                .from(App.group)
                .to(message.authorId())
                .photo(AnimeList.getRandomPic())
                .keyboard(keys)
                .send()
        );
    }
}
