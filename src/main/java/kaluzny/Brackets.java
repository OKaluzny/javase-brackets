package kaluzny;

import com.google.common.collect.ImmutableMap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public final class Brackets {

    private static final Logger LOGGER = Logger.getLogger(Brackets.class.getName());
    private static Map<Character, Character> BRACKETS = ImmutableMap.of(')', '(', ']', '[', '}', '{');

    private Brackets() {
    }

    public static boolean checkBrackets(String text) {

        LOGGER.info(String.format("Initialize."));
        Objects.requireNonNull(text);
        Deque<Character> brackets = new ArrayDeque<Character>();
        for (Character symbol : text.toCharArray()) {
            if (BRACKETS.containsValue(symbol)) {
                brackets.addFirst(symbol);
            } else if (BRACKETS.containsKey(symbol)) {
                if (brackets.isEmpty()) {
                    return false;
                }
                if (!Objects.equals(brackets.removeFirst(), BRACKETS.get(symbol))) {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}