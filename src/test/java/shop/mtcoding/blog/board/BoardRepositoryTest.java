package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import shop.mtcoding.blog.user.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Import(BoardRepository.class)
@DataJpaTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;
    private EntityManager em;


//    // for문을 돌면서 동적 쿼리를 만들어 내는 방법
//    public List<Board> findAllV3() {
//        String q1 = "select b from Board b order by b.id desc";
//        List<Board> boardList = em.createQuery(q1, Board.class).getResultList();
//
//        int[] userIds = boardList.stream().mapToInt(board -> board.getUser().getId()).distinct().toArray();
//
//        String q2 = "select u from User u where u.id in(";
//        for (int i = 0; i < userIds.length; i++) {
//            if (i == userIds.length - 1) {
//                q2 = q2 + userIds[i] + ")";
//            } else q2 = q2 + userIds[i] + ",";
//        }
//
//        List<User> userList = em.createQuery(q2, User.class).getResultList();
//
//        for (Board board : boardList) {
//            for (User user : userList) {
//                if (user.getId() == board.getUser().getId()) {
//                    board.setUser(user);
//                }
//            }
//        }
//        return boardList;
//    }
//    @Test
//    public void findAllV3_test() {
//        // given
//
//
//        // when
//        List<Board> boardList = boardRepository.findAllV3();
//
//        // then
//        // then
//        System.out.println("findAllV3_test↓ ");
//        boardList.forEach(board -> {
//            System.out.println(board);
//        });
//
//    }


//    // JPQL에 List를 직접 매칭시키는 방법
//    public List<Board> findAllV2() {
//        Query q1 = em.createQuery("select b from Board b order by b.id desc", Board.class);
//        List<Board> boardList = q1.getResultList();
//
//        Set<Integer> userIds = new HashSet<>();
//        for (Board board : boardList) {
//            userIds.add(board.getUser().getId());
//        }
//
//        Query q2 = em.createQuery("select u from User u where u.id in :userIds", User.class); // User" 엔티티를 조회하고, 해당 엔티티의 ID가 userIds 세트에 포함되어 있는 경우만 반환
//        q2.setParameter("userIds", userIds);
//        List<User> userList = q2.getResultList();
//
//        for (Board board : boardList) {
//            for (User user : userList) {
//                if (user.getId() == board.getUser().getId()) {
//                    board.setUser(user);
//                }
//            }
//        }
//        return boardList;
//    }
//    @Test
//    public void findAllV2_test() {
//        // given
//
//        // when
//        List<Board> boardList = boardRepository.findAllV2();
//
//
//        // then
//        System.out.println("findAllV2_test↓ ");
//        boardList.forEach(board -> {
//            System.out.println(board);
//        });
//
//    }

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
