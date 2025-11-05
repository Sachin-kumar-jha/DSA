package QUEUE.Question;

import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    private static class Node {
        int price;
        int span;
        Node(int p, int s) { price = p; span = s; }
    }

    private Deque<Node> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int currSpan = 1;
        // Pop while previous prices are <= current price and accumulate spans
        while (!stack.isEmpty() && stack.peekLast().price <= price) {
            currSpan += stack.peekLast().span;
            stack.removeLast();
        }
        // Push current price with its span
        stack.addLast(new Node(price, currSpan));
        return currSpan;
    }

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
