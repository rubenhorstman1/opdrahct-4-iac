package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import domain.rules.RockPaperScissors;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

public class RockPaperScissorsTest {
	
	@ParameterizedTest
    private static Stream<Arguments> provideMovesAndResults() {
        return Stream.of(
                Arguments.of(Move.SCISSORS, Move.PAPER, Result.WIN),
                Arguments.of(Move.ROCK, Move.SCISSORS, Result.WIN),
                Arguments.of(Move.PAPER, Move.ROCK, Result.WIN),

                Arguments.of(Move.SCISSORS, Move.SCISSORS, Result.DRAW),
                Arguments.of(Move.PAPER, Move.PAPER, Result.DRAW),
                Arguments.of(Move.ROCK, Move.ROCK, Result.DRAW),

                Arguments.of(Move.SCISSORS, Move.ROCK, Result.LOSE),
                Arguments.of(Move.ROCK, Move.PAPER, Result.LOSE),
                Arguments.of(Move.PAPER, Move.SCISSORS, Result.LOSE)
        );
    }
	
	@ParameterizedTest
    @MethodSource("provideMovesAndResults")
    void verifyMovesAndResults(Move mine, Move theirs, Result expectedResult) {
        Rules game = new RockPaperScissors();
        Result result = game.decide(mine, theirs);
        assertEquals(expectedResult, result);
    }
}
