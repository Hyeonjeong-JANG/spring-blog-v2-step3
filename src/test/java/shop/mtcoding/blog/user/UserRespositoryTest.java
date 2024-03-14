package shop.mtcoding.blog.user;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import shop.mtcoding.blog.board.BoardRequest;

@Import(UserRepository.class)
@DataJpaTest
public class UserRespositoryTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsernameAndPassword_test() {
        // given
        UserRequest.LoginDTO reqDTO = new UserRequest.LoginDTO();
        reqDTO.setPassword("1234");
        reqDTO.setUsername("ssar");
        // when
        userRepository.findByUsernameAndPassword(reqDTO);

        // then


    }

}
