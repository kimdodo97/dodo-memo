package com.kimdodo.ssgboard.post.infrastructure;

import com.kimdodo.ssgboard.common.service.port.DateHolder;
import com.kimdodo.ssgboard.post.domain.Post;
import com.kimdodo.ssgboard.post.service.port.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional(isolation = Isolation.READ_COMMITTED)
class PostRepositoryImplTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    
    @Test
    @DisplayName("Post 객체를 통해서 DB에 값을 저장 할 수 있다")
    void test1() throws Exception {
        //given
        Date createTime = Date.from(Instant.parse("2023-12-12T00:00:00Z"));
        Post post = Post.builder()
                .title("제목")
                .content("내용")
                .createAt(createTime)
                .build();
        //when
        Post saved = postRepository.save(post);
        //then
        assertThat(saved.getId()).isEqualTo(1L);
        assertThat(saved.getTitle()).isEqualTo("제목");
        assertThat(saved.getContent()).isEqualTo("내용");
    }

    @Test
    @DisplayName("Post ID 를 통해서 게시물을 조회할 수 있다")
    void test2() throws Exception {
        //given
        Date createTime = Date.from(Instant.parse("2023-12-12T00:00:00Z"));
        PostEntity postEntity = PostEntity.builder()
                .title("제목")
                .content("내용")
                .createAt(createTime)
                .build();
        postMapper.save(postEntity);
        //when
        Post post = postRepository.findById(postEntity.getId())
                .orElseThrow(RuntimeException::new);
        //then
        assertThat(post.getId()).isNotNull();
        assertThat(post.getTitle()).isEqualTo("제목");
        assertThat(post.getContent()).isEqualTo("내용");
    }

    @Test
    @DisplayName("저장된 게시물 수정이 가능하다")
    void test3() throws Exception {
        //given
        Date createTime = Date.from(Instant.parse("2023-12-12T00:00:00Z"));
        PostEntity postEntity = PostEntity.builder()
                .title("제목")
                .content("내용")
                .createAt(createTime)
                .build();
        Long savedId = postMapper.save(postEntity);
        
        Post post = Post.builder()
                .id(savedId)
                .title("수정 제목")
                .content("수정 내용")
                .build();
        //when
        Post updated = postRepository.update(post);
        //then
        assertThat(updated.getId()).isEqualTo(savedId);
        assertThat(updated.getTitle()).isEqualTo("수정 제목");
        assertThat(updated.getContent()).isEqualTo("수정 내용");
    }

    @Test
    @DisplayName("저장된 게시물은 삭제가 가능하다")
    void test4() throws Exception {
        //given
        Date createTime = Date.from(Instant.parse("2023-12-12T00:00:00Z"));
        PostEntity postEntity = PostEntity.builder()
                .title("제목")
                .content("내용")
                .createAt(createTime)
                .build();
        Long savedId = postMapper.save(postEntity);

        //when
        postRepository.delete(savedId);
        //then
        assertThatThrownBy(() -> {
            postMapper.findById(savedId)
                    .orElseThrow(RuntimeException::new);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("저장된 게시물은 삭제가 가능하다")
    void test5() throws Exception {
        //given
        Date createTime = Date.from(Instant.parse("2023-12-12T00:00:00Z"));
        PostEntity postEntity = PostEntity.builder()
                .title("제목")
                .content("내용")
                .createAt(createTime)
                .build();
        Long savedId = postMapper.save(postEntity);

        //when
        postRepository.delete(savedId);
        //then
        assertThatThrownBy(() -> {
            postMapper.findById(savedId)
                    .orElseThrow(RuntimeException::new);
        }).isInstanceOf(RuntimeException.class);
    }
    
    @Test
    @DisplayName("findAll 로 전체 조회가 가능하다")
    void test6() throws Exception {
        //given
        for (int i = 0; i < 100; i++) {
            Date createTime = Date.from(Instant.parse("2023-12-12T00:00:00Z"));
            PostEntity postEntity = PostEntity.builder()
                    .title("제목" + i)
                    .content("내용" + i)
                    .createAt(createTime)
                    .build();
            postMapper.save(postEntity);
        }
        //when
        List<Post> postList = postRepository.findAll();
        //then
        assertThat(postList.size()).isEqualTo(100);
    }

    @Test
    @DisplayName("offset과 페이지당 크기를 통해서 페이징 처리 조회가 가능하다 ")
    void test7() throws Exception {
        //given
        for (int i = 1; i < 100; i++) {
            Date createTime = Date.from(Instant.now());
            PostEntity postEntity = PostEntity.builder()
                    .title("제목" + i)
                    .content("내용" + i)
                    .createAt(createTime)
                    .build();
            postMapper.save(postEntity);
        }
        //when
        List<Post> page = postRepository.findByPage(10, 0, false);
        //then
        assertThat(page.size()).isEqualTo(10);
        assertThat(page.get(0).getTitle()).isEqualTo("제목99");
    }

    @Test
    @DisplayName("최신순 설정이 없으면  ")
    void test8() throws Exception {
        //given
        for (int i = 1; i < 100; i++) {
            Date createTime = Date.from(Instant.now());
            PostEntity postEntity = PostEntity.builder()
                    .title("제목" + i)
                    .content("내용" + i)
                    .createAt(createTime)
                    .build();
            postMapper.save(postEntity);
        }
        //when
        List<Post> page = postRepository.findByPage(10, 0, true);
        //then
        assertThat(page.size()).isEqualTo(10);
        assertThat(page.get(0).getTitle()).isEqualTo("제목1");
    }
}