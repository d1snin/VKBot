package xyz.d1snin.vkbot.commands;

import ru.codeoff.bots.keyboard.Button;
import ru.codeoff.bots.keyboard.ButtonColor;
import ru.codeoff.bots.keyboard.Keyboard;
import ru.codeoff.bots.sdk.objects.Message;
import sg4e.danbooru.Danbooru;
import sg4e.danbooru.DanbooruBuilder;
import sg4e.danbooru.Post;
import xyz.d1snin.vkbot.App;
import xyz.d1snin.vkbot.util.AnimeList;

import java.util.List;
import java.util.Random;

public class AnimeCommand {
    public AnimeCommand() {
        Keyboard keys = Keyboard.of(new Button("Anime Random", ButtonColor.POSITIVE), new Button("Anime Danbooru", ButtonColor.POSITIVE));
        App.group.onCommand(new String[]{"Anime Random".toLowerCase(), "Anime Danbooru".toLowerCase()}, message ->
                new Message()
                .from(App.group)
                .to(message.authorId())
                .text("Fetching picture...")
                .keyboard(keys)
                .send()
        );
        App.group.onCommand("Anime Random".toLowerCase(), message ->
                new Message()
                .from(App.group)
                .to(message.authorId())
                .photo(AnimeList.getRandomPic())
                .send()
        );
        App.group.onCommand("Anime Danbooru".toLowerCase(), message ->
                new Message()
                .from(App.group)
                .to(message.authorId())
                .photo(generateImage())
                .send()
        );
    }
    private static String generateImage() {
        Danbooru danbooru = new DanbooruBuilder().build();
        List<Post> posts = danbooru.getPosts("", true);
        Random rand = new Random();
        Post randomElement = posts.get(rand.nextInt(posts.size()));
        return randomElement.getFileUrl();
    }
}
