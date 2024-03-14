package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardRepository.class)
@DataJpaTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;
    private EntityManager em;



    @Test
    public void findAll_custom_inquery_test() {
        // given


        // when
        List<Board> boardList = boardRepository.findAll(); // JPA는 쿼리를 꼭 확인해야 한다.
        int[] userIds = boardList.stream().mapToInt(board -> board.getUser().getId()).distinct().toArray();
        // 보드리스트를.물길에 풀어서.인트로 받기 위해서(보드의.유저의.아이디중).겹치는 것을 제거하고.어레이에 담는다.;
        for (int i : userIds) {
            System.out.println(i);
        }
        // then


    }

    @Test
    public void findAll_lazyloading_test() {
        // given


        // when
        List<Board> boardList = boardRepository.findAll(); // JPA는 쿼리를 꼭 확인해야 한다.
        boardList.forEach(board -> {
            System.out.println("유저의 유저네임: " + board.getUser().getUsername());// lazy loading // 나중에 유저의 유저네임에  ssar만 두 번 나오는데 왜일까? // ssar이 두 명이다.
        });

        // then


    }

    @Test
    public void findAll_test() {
        // given


        // when
        List<Board> boardList = boardRepository.findAll(); // JPA는 쿼리를 꼭 확인해야 한다.
        boardList.forEach(board -> {
            System.out.println("유저의 유저네임: " + board.getUser().getUsername());// 나중에 유저의 유저네임에  ssar만 두 번 나오는데 왜일까?
        });
        // then


    }

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
