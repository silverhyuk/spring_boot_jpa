package com.silverhyuk.spring_boot_jpa;

import com.silverhyuk.spring_boot_jpa.entity.account.Account;
import com.silverhyuk.spring_boot_jpa.entity.parentChild.Comment;
import com.silverhyuk.spring_boot_jpa.entity.parentChild.Post;
import com.silverhyuk.spring_boot_jpa.entity.study.Study;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager; //jpa 핵심 클래스


    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*Account account = new Account();
        account.setUsername("Silverhyuk");
        account.setPassword("password");

        Study study = new Study();
        study.setName("Spring Data JPA");

        account.addStudy(study);



        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);

        Account eunhyuk = session.load(Account.class, account.getId());
        eunhyuk.setUsername("Eunhyuk");
        eunhyuk.setUsername("Eunhyuk1");
        eunhyuk.setUsername("Eunhyuk2");
        System.out.println("==========================");
        System.out.println(eunhyuk.getUsername());*/

        /**
         * =====================================
         */
        /*Post post = new Post();
        post.setTitle("Spring Data JPA 언제보나...");

        Comment comment = new Comment();
        comment.setComment("빨리보고싶어요");
        post.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setComment("곧 보여드릴게요.");
        post.addComment(comment1);*/

        //Session session = entityManager.unwrap(Session.class);
        //session.save(post);

        //Post post1 = session.get(Post.class, 1l);// get은 DB에 값이 없으면 null로 가져옴
                                                            // load는 DB에 값이 없으면 Exception을 던짐
        //System.out.println("========================");
        //System.out.println(post1.getTitle());
        //session.delete(post);
        /*Comment comment = session.get(Comment.class, 2l);
        System.out.println("========================");
        System.out.println(comment.getComment());*/

        /**
         * =========================================
         */
        /*Query query = entityManager.createQuery("SELECT p FROM Post as p", Post.class);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);*/
        /**
         * Type Safe 한 쿼리 만들기===================
         */
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> query = builder.createQuery(Post.class);
        Root<Post> root = query.from(Post.class);
        query.select(root);

        List<Post> posts = entityManager.createQuery(query).getResultList();
        posts.forEach(System.out::println);
    }
}
