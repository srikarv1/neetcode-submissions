
class Solution {
    public int maxProfit(int[] prices) {
        Map<State, Integer> cache = new HashMap<>();
        return dfs(prices, cache, 0, true);
    }

    private static int dfs(int[] prices, Map<State, Integer> cache, int i, boolean buy) {
        if (i >= prices.length) return 0;

        State key = new State(i, buy);
        if (cache.containsKey(key)) return cache.get(key);

        int cooldown = dfs(prices, cache, i + 1, buy);
        int result;

        if (buy) {
            int buying = dfs(prices, cache, i + 1, false) - prices[i];
            result = Math.max(buying, cooldown);
        } else {
            int selling = dfs(prices, cache, i + 2, true) + prices[i]; // cooldown after sell
            result = Math.max(selling, cooldown);
        }

        cache.put(key, result);
        return result;
    }
    static class State {
    int index;
    boolean buy;

    public State(int index, boolean buy) {
        this.index = index;
        this.buy = buy;
    }
}
}

