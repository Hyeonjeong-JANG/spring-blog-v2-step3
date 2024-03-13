package shop.mtcoding.blog.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(BoardRepository.class)
@DataJpaTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void findByIdJoinUser_test() {
        // given
        int id = 1;

        // when
        boardRepository.findByIdJoinUser(id);

        // then


    }

    @Test
    public void findById_test() {
        // given
        int id = 1;

        // when
        boardRepository.findById(id);

        // then
    }
}
