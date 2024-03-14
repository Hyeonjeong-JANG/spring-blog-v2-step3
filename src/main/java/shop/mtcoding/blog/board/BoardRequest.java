package shop.mtcoding.blog.board;

import lombok.Data;
import shop.mtcoding.blog.user.User;

public class BoardRequest {
    public static class SaveDTO {
        private String title;
        private String content;

        // DTO를 클라이언트로부터 받아서 PC(PersistContext)에 전달하기 위해 사용
        public Board toEntity(User user) { // 비영속 보드객체를 만들어야 하는데 거기에다가 유저 객체를 넣어줘야 한다.
            return Board.builder()
                    .title(title)
                    .content(content)
                    .user(user) // 유저네임을 넣어줘야 하는데 세션이 그걸 들고 있어서 세션을 통째로 넣어준다. 유저객체를 넣어주면 된다는 말이다. 이게 ORM이다. 유저객체 전체가 아닌 유저의 프라이머리 키만 있어도 됨. 그러나 id(1) 이렇게 했는데 그 값이 없으면 탈이나니까 비추. 조회해서 넣어라. // 비영속객체도 되지만 영속화시켜서 넣어 주는 것이 안전하다.
                    .build();
        }
    }

}
