package xyz.d1snin.vkbot;
import xyz.d1snin.vkbot.commands.*;

import ru.codeoff.bots.sdk.clients.Group;
import xyz.d1snin.vkbot.util.ReadFromJSON;

import java.util.Objects;

public class App {
    public static Group group = new Group(Integer.parseInt(Objects.requireNonNull(ReadFromJSON.readJson("conf.json", "group-id"))), ReadFromJSON.readJson("conf.json", "token"));
    public static void main(String[] args) {
        new TestCommand();
        new AnimeCommand();
    }
}
