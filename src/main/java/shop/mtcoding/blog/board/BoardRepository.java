package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog.user.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Repository
public class BoardRepository {
    private final EntityManager em;

    @Transactional
    public void deleteById(int id) {
        Query query = em.createQuery("delete from Board  b where b.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void save(Board board) {
        em.persist(board); // persist는 내가 만든 것이 아니라 테스트할 필요가 없는 것 같다.
    }

    public List<Board> findAll() {
        Query query = em.createQuery("select b from Board b order by b.id desc", Board.class);
        return query.getResultList();
    }

    public Board findByIdJoinUser(int id) {
        Query query = em.createQuery("select b from Board b  join fetch b.user u where b.id = :id", Board.class); // 너가 보드 객체 조인하면서 보드객체의 유저도 같이 조인해라 이 말이다. on은 포린키와 피케이 연겷라 땐느 생략근ㅇ해서 안씀. .
        query.setParameter("id", id);
        return (Board) query.getSingleResult();
    }

    public Board findById(int id) {
        //id, title, content, user_id(이질감), created_at
        Board board = em.find(Board.class, id);
        return board;
    }
}