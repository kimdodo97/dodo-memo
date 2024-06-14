package com.kimdodo.ssgboard.post.domain;

import com.kimdodo.ssgboard.common.service.port.DateHolder;
import com.kimdodo.ssgboard.mock.TestDateHolder;
import com.kimdodo.ssgboard.post.infrastructure.PostEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
    private final DateHolder dateHolder
            = new TestDateHolder(Date.from(Instant.parse("2023-12-12T00:00:00Z")));
    @Test
    @DisplayName("PostCreate 객체로 Post 생성이 가능하다")
    void test1() throws Exception {
        //given
        PostCreate postCreate = PostCreate.builder()
                .title("제목")
                .content("내용")
                .build();
        //when
        Post post = Post.from(postCreate, dateHolder);
        //then
        assertEquals("제목",post.getTitle());
        assertEquals("내용",post.getContent());
        assertEquals(Date.from(Instant.parse("2023-12-12T00:00:00Z")),post.getCreateAt());
    }

    @Test
    @DisplayName("PostEdit 객체로 Post 수정이 가능하다")
    void test2() throws Exception {
        //given
        Post post = Post.builder()
                .id(1L)
                .title("제목")
                .content("내용")
                .createAt(dateHolder.getNow())
                .build();

        PostEdit postEdit = PostEdit.builder()
                .title("수정 제목")
                .content("수정 내용")
                .createAt(dateHolder.getNow())
                .build();
        //when
        post = post.edit(postEdit);
        //then
        assertEquals("수정 제목",post.getTitle());
        assertEquals("수정 내용",post.getContent());
        assertEquals(Date.from(Instant.parse("2023-12-12T00:00:00Z")),post.getCreateAt());
    }

    @Test
    @DisplayName("PostEdit 객체로 수정 시 비어있는 값은 Post의 기본값으로 설정된다")
    void test3() throws Exception {
        //given
        Post post = Post.builder()
                .id(1L)
                .title("제목")
                .content("내용")
                .createAt(dateHolder.getNow())
                .build();

        PostEdit postEdit = PostEdit.builder()
                .content("수정 내용")
                .createAt(dateHolder.getNow())
                .build();
        //when
        post = post.edit(postEdit);
        //then
        assertEquals(1L,post.getId());
        assertEquals("제목",post.getTitle());
        assertEquals("수정 내용",post.getContent());
        assertEquals(Date.from(Instant.parse("2023-12-12T00:00:00Z")),post.getCreateAt());
    }

    @Test
    @DisplayName("Post는 PostResponse 로 변환이 가능하다")
    void test4() throws Exception {
        //given
        Post post = Post.builder()
                .id(1L)
                .title("제목")
                .content("내용")
                .createAt(dateHolder.getNow())
                .build();

        //when
        PostResponse postResponse = post.toResponse();
        //then
        assertEquals(1L,postResponse.getId());
        assertEquals("제목",postResponse.getTitle());
        assertEquals("내용",postResponse.getContent());
        assertEquals(Date.from(Instant.parse("2023-12-12T00:00:00Z")),postResponse.getCreateAt());
    }
}

