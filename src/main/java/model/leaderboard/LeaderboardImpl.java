package model.leaderboard;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class LeaderboardImpl implements Leaderboard {

    private Map<String, Integer> ranking;

    public LeaderboardImpl() {
        this.ranking = new HashMap<>();
    }

    public LeaderboardImpl(final Map<String, Integer> ranking) {
        this.ranking = ranking;
    }

    /**
     * 
     * {@inheritDoc}
     *
     */
    @Override
    public void sortByScore() {
        this.ranking = this.ranking.entrySet()
                                   .stream()
                                   .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                                   .collect(Collectors.toMap(Map.Entry::getKey,
                                            Map.Entry::getValue, (e1, e2) -> e1,
                                            LinkedHashMap::new));
    }

    /**
     * 
     * {@inheritDoc}
     *
     */
    @Override
    public void addPlayer(final String alias, final int score) {
        this.ranking.put(alias, score);
    }

    /**
     * 
     * {@inheritDoc}
     *
     */
    @Override
    public void removePlayer(final String alias, final int score) {
        if (this.ranking.entrySet()
                       .stream()
                       .filter(e -> e.getKey().equals(alias) && e.getValue() == score)
                       .findAny()
                       .isPresent()) {
            this.ranking.remove(alias, score);

        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 
     * {@inheritDoc}
     *
     */
    @Override
    public Map<String, Integer> getLeaderBoard() {
        return Collections.unmodifiableMap(this.ranking);
    }

    /**
     * 
     * {@inheritDoc}
     *
     */
    @Override
    public Optional<Entry<String, Integer>> getTopPlayer() {
        this.sortByScore();
        if (this.ranking.entrySet().stream().findFirst().isPresent()) {
            return this.ranking.entrySet().stream().findFirst();
        }
        return Optional.empty();
    }

    /**
     * 
     * {@inheritDoc}
     *
     */
    @Override
    public Optional<Entry<String, Integer>> getSecondPlayer() {
        this.sortByScore();
        if (this.ranking.entrySet().stream().findFirst().isPresent()) {
            return this.ranking.entrySet().stream().skip(1).findFirst();
        }
        return Optional.empty();
    }

    /**
     * 
     * {@inheritDoc}
     *
     */
    @Override
    public Optional<Entry<String, Integer>> getThirdPlayer() {
        this.sortByScore();
        if (this.ranking.entrySet().stream().findFirst().isPresent()) {
            return this.ranking.entrySet().stream().skip(2).findFirst();
        }
        return Optional.empty();
    }

    /**
     *  Return a String representing the ranking.
     *  @return a String representing the ranking.
     *
     */
    @Override
    public String toString() {
        return this.ranking.toString();
    }

}
