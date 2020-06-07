package domain.rules;

import static domain.Move.PAPER;
import static domain.Move.ROCK;
import static domain.Move.SCISSORS;

import domain.Move;
import domain.Result;
import domain.Rules;

public class RockPaperScissors implements Rules {
	@Override
    public Result decide(Move mine, Move theirs) {
        if(mine.equals(theirs)){
            return Result.DRAW;
        }
        switch (mine) {
            case ROCK:
                return game(theirs.equals(SCISSORS));
            case PAPER:
                return game(theirs.equals(ROCK));
            case SCISSORS:
                return game(theirs.equals(PAPER));
        }
        return null;
    }
	
    private Result game(boolean uitkomst){
        if(uitkomst){
            return Result.WIN;
        } else{
            return Result.LOSE;
        }
    }
}
