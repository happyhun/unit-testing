import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    @Test
    public void 모든_프레임에서_또랑에_빠지면_0점이다() {
        // given
        BowlingGame bowlingGame = new BowlingGame();

        // when
        for (int i = 0; i < 20; i++) {
            bowlingGame.roll(0);
        }

        // then
        assertEquals(bowlingGame.score(), 0);
    }

    @Test
    public void 첫투구에서_1점을_기록하면_1점이다() {
        // given
        BowlingGame bowlingGame = new BowlingGame();

        // when
        bowlingGame.roll(1);
        for (int i = 1; i < 20; i++) {
            bowlingGame.roll(0);
        }

        // then
        assertEquals(bowlingGame.score(), 1);
    }

    @Test
    public void 투구에서_핀이_0개미만_10개초과_쓰러지면_에러가_발생한다() {
        // given
        BowlingGame bowlingGame = new BowlingGame();

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> bowlingGame.roll(-1));
        assertThrows(IllegalArgumentException.class, () -> bowlingGame.roll(11));
    }

    @Test
    public void 첫번째_투구에서_7개_두번째_투구에서_3개를_쓰러트리면_다음_투구를_보너스_점수로_얻는다() {
        // given
        BowlingGame bowlingGame = new BowlingGame();

        // when
        bowlingGame.roll(7);
        bowlingGame.roll(3);
        bowlingGame.roll(1);

        for (int i = 3; i < 20; i++) {
            bowlingGame.roll(0);
        }

        // then
        assertEquals(bowlingGame.score(), 12);
    }

    @Test
    public void 스트라이크를_치면_다음_두번의_투구를_보너스_점수로_얻는다() {
        // given
        BowlingGame bowlingGame = new BowlingGame();

        // when
        bowlingGame.roll(10);
        bowlingGame.roll(1);
        bowlingGame.roll(2);

        for (int i = 4; i < 20; i++) {
            bowlingGame.roll(0);
        }

        // then
        assertEquals(bowlingGame.score(), 16);
    }

    @Test
    public void 프레임에서_쓰러트린_핀의_개수가_0개_미만_10개_초과면_에러가_발생한다() {
        // given
        BowlingGame bowlingGame = new BowlingGame();

        // when
        bowlingGame.roll(5);
        bowlingGame.roll(6);

        for (int i = 2; i < 20; i++) {
            bowlingGame.roll(0);
        }

        // then
        assertThrows(IllegalArgumentException.class, bowlingGame::score);
    }

    @Test
    public void 모든_투구에서_스트라이크를_기록하면_점수는_300점이_된다() {
        // given
        BowlingGame bowlingGame = new BowlingGame();

        // when
        for (int i = 0; i < 12; i++) {
            bowlingGame.roll(10);
        }

        // then
        assertEquals(bowlingGame.score(), 300);
    }

    @Test
    public void 마지막_프레임에서_초구가_스트라이크면_핀의_합이_10을_초과할_수_있다() {
        // given
        BowlingGame bowlingGame = new BowlingGame();

        // when
        for (int i = 0; i < 18; i++) {
            bowlingGame.roll(0);
        }

        bowlingGame.roll(10);
        bowlingGame.roll(3);
        bowlingGame.roll(0);

        // then
        assertEquals(bowlingGame.score(), 13);
    }

    @Test
    public void 스트라이크_4번과_스페어_5번으로_188점을_만들_수_있다() {
        // given
        BowlingGame bowlingGame = new BowlingGame();

        // when
        bowlingGame.roll(10);
        bowlingGame.roll(9);
        bowlingGame.roll(1);
        bowlingGame.roll(7);
        bowlingGame.roll(0);
        bowlingGame.roll(9);
        bowlingGame.roll(1);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(8);
        bowlingGame.roll(2);
        bowlingGame.roll(10);
        bowlingGame.roll(9);
        bowlingGame.roll(1);
        bowlingGame.roll(9);
        bowlingGame.roll(1);
        bowlingGame.roll(7);

        // then
        assertEquals(bowlingGame.score(), 188);
    }
}