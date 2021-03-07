package xyz.d1snin.vkbot;
import xyz.d1snin.vkbot.commands.*;

import ru.codeoff.bots.sdk.clients.Group;

public class App {
    public static Group group = new Group(203098891, "de3743946f15c376400a2613e783faf57d1828e35d550850d2e0719dc9479663de799e216efc54633f3bf");
    public static void main(String[] args) {
        new TestCommand();
        new AnimeCommand();
    }
}
