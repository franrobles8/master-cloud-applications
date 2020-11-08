package usantatecla.draughts.models;

import java.util.Map;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class DraughtTest {
    
    Game game;
    Game expectedGame;
    
    void setGame(Color color, Map<Integer,String> rows) {
        this.game = new GameBuilder().color(color).rows(rows.entrySet()).build();
    }

    void setExpectedGame(Color color, Map<Integer,String> rows) {
        this.expectedGame = new GameBuilder().color(color).rows(rows.entrySet()).build();
    }

    Map<Integer,String> getDraughtGame(List<Entry<Integer,String>> rows) {
        return rows.stream()
            .collect(Collectors.toMap(Entry<Integer,String>::getKey, Entry<Integer,String>::getValue));
    }

}