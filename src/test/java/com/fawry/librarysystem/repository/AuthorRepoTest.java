//package com.fawry.librarysystem.repository;
//
//import com.fawry.librarysystem.entity.Author;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//class AuthorRepoTest {
//
//    private final AuthorRepo authorRepo;
//
//    private final TestEntityManager testEntityManager;
//
//    @Autowired
//    public AuthorRepoTest(AuthorRepo authorRepo, TestEntityManager testEntityManager) {
//        this.authorRepo = authorRepo;
//        this.testEntityManager = testEntityManager;
//    }
//
//    @AfterEach
//    void tearDown() {
//        authorRepo.deleteAll();
//    }
//
//    @Test
//    void testSaveAuthor() {
//        // given
//        Author author = new Author();
//        author.setName("J.K. Rowling");
//        author.setEmail("jkrowling@example.com");
//
//        // when
//        Author savedAuthor = authorRepo.save(author);
//
//        // then
//        assertThat(savedAuthor.getId()).isNotNull();
//        assertThat(savedAuthor.getName()).isEqualTo("J.K. Rowling");
//        assertThat(savedAuthor.getEmail()).isEqualTo("jkrowling@example.com");
//    }
//
//    @Test
//    void testFindAuthorByName() {
//        // given
//        Author author = new Author();
//        author.setName("J.K. Rowling");
//        author.setEmail("jkrowling@example.com");
//        author = testEntityManager.persistAndFlush(author);
//
//        // when
//        Author foundAuthor = authorRepo.findByName("J.K. Rowling");
//
//        // then
//        assertThat(foundAuthor).isNotNull();
//        assertThat(foundAuthor.getId()).isEqualTo(author.getId());
//        assertThat(foundAuthor.getName()).isEqualTo("J.K. Rowling");
//        assertThat(foundAuthor.getEmail()).isEqualTo("jkrowling@example.com");
//    }
//
//    @Test
//    void testDeleteAuthorByName() {
//        // given
//        Author author = new Author();
//        author.setName("J.K. Rowling");
//        author.setEmail("jkrowling@example.com");
//        testEntityManager.persistAndFlush(author);
//
//        // when
//        authorRepo.deleteByName("J.K. Rowling");
//
//        // then
//        assertThat(authorRepo.findByName("J.K. Rowling")).isNull();
//    }
//
//}
