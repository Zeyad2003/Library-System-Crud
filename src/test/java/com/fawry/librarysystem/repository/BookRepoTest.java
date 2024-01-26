//package com.fawry.librarysystem.repository;
//
//import com.fawry.librarysystem.entity.Book;
//import com.fawry.librarysystem.entity.Category;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import java.math.BigDecimal;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@DataJpaTest
//class BookRepoTest {
//
//    private final BookRepo bookRepo;
//
//    @Autowired
//    private CategoryRepo categoryRepo;
//
//    private final TestEntityManager testEntityManager;
//
//    @Autowired
//    public BookRepoTest(BookRepo bookRepo, TestEntityManager testEntityManager) {
//        this.bookRepo = bookRepo;
//        this.testEntityManager = testEntityManager;
//    }
//
////    @AfterEach
////    void tearDown() {
////        bookRepo.deleteAll();
////    }
//
//    @Test
//    void testSaveBook() {
//        // given
//        Book book = new Book();
//        book.setName("Harry Potter and the Philosopher's Stone");
//        book.setPrice(BigDecimal.valueOf(10.0));
//
//        Category category = new Category();
//        category.setName("Fantasy");
//
//        book.setCategory(category);
//
//        // when
//        Book savedBook = bookRepo.save(book);
//
//        // then
//        assertThat(savedBook.getId()).isNotNull();
//        assertThat(savedBook.getName()).isEqualTo("Harry Potter and the Philosopher's Stone");
//        assertThat(savedBook.getPrice()).isEqualTo(10.0);
//
//        assertThat(savedBook.getCategory()).isNotNull();
//        assertThat(savedBook.getCategory().getName()).isEqualTo("Fantasy");
//    }
//
// /*   @Test
//    void testFindBookByName() {
//        // given
//        Book book = new Book();
//        book.setName("Harry Potter and the Philosopher's Stone");
//        book.setPrice(10.0);
//
//        Category category = new Category();
//        category.setName("Fantasy");
//
//        book.setCategory(category);
//
//        book = testEntityManager.persistAndFlush(book);
//
//        // when
//        Book foundBook = bookRepo.findByName("Harry Potter and the Philosopher's Stone");
//
//        // then
//        assertThat(foundBook).isNotNull();
//        assertThat(foundBook.getId()).isEqualTo(book.getId());
//        assertThat(foundBook.getName()).isEqualTo("Harry Potter and the Philosopher's Stone");
//        assertThat(foundBook.getPrice()).isEqualTo(10.0);
//
//        assertThat(foundBook.getCategory()).isNotNull();
//        assertThat(foundBook.getCategory().getName()).isEqualTo("Fantasy");
//    }
//
//    @Test
//    void testDeleteBookByName() {
//        // given
//        Book book = new Book();
//        book.setName("Harry Potter and the Philosopher's Stone");
//        book.setPrice(10.0);
//
//        Category category = new Category();
//        category.setName("Fantasy");
//
//        book.setCategory(category);
//
//        testEntityManager.persist(book);
//
//        // when
//        bookRepo.deleteByName("Harry Potter and the Philosopher's Stone");
//
//        // then
//        assertThat(bookRepo.findByName("Harry Potter and the Philosopher's Stone")).isNull();
//    }
//*/
//}
